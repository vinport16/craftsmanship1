import java.util.*;
import java.util.stream.Collectors;

public final class InternalNode implements Node{
  
  private final List<Node> children;
  private String computedString;
  private List<Token> computedTokenList;

  private InternalNode(List<Node> childs){
    // childs are copied before being put in children
    children = new ArrayList<Node>();
    for(Node child : childs){
      if(child instanceof InternalNode){
        children.add(((InternalNode)child).build(((InternalNode)child).getChildren()));
      }else{
        // child is a leaf node
        children.add(((LeafNode)child).build(((LeafNode)child).getToken()));
      }
    }
  }

  public static InternalNode build(List<Node> childs){
    if(childs == null){
      throw new NullPointerException("Cannot build InternalNode with null children");
    }
    return new InternalNode(childs);
  }

  public List<Node> getChildren(){
    // return copy of children
    List<Node> list = new ArrayList<Node>();
    for(Node child : children){
      if(child instanceof InternalNode){
        list.add(((InternalNode)child).build(((InternalNode)child).getChildren()));
      }else{
        // child is a leaf node
        list.add(((LeafNode)child).build(((LeafNode)child).getToken()));
      }
    }
    return list;
  }

  public final List<Token> toList(){
    // if the token list has not yet been computed, compute and store it
    if(computedTokenList == null){
      List<Token> list = new ArrayList<Token>();
      for(Node child : children){
        list.addAll(child.toList());
      }
      computedTokenList = list;
    }
    return computedTokenList;
  }

  public String toString(){
    // if the string representation has not yet been computed, compute and store it
    if(computedString == null){
      computedString = "[" + children.stream().map(c -> c.toString()).collect(Collectors.joining(",")) + "]";
    }
    return computedString;
  }

  public static void main(String[] args) {
    Connector a = Connector.build(TerminalSymbol.PLUS);
    System.out.println(a.getType());
    System.out.println(a);
    LeafNode l = LeafNode.build(a);
    System.out.println(l.getToken());
    System.out.println(l);
    System.out.println(l.toList());
    List<Node> ll = new ArrayList<>();
    ll.add(l);
    InternalNode il = InternalNode.build(ll);
    System.out.println(il.getChildren());
    System.out.println(il.toList());
    System.out.println(il);
  }
}