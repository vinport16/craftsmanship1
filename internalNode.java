public final class InternalNode implements Node{
  
  private final List<Node> children;

  private InternalNode(List<Node> childs){
    // change this so that children = a copy of childs, not the actual childs
    children = childs;
  }

  public InternalNode build(List<Node> childs){
    if(childs == null){
      throw new NullPointerException("Cannot build InternalNode with null children");
    }
    return new InternalNode(childs);
  }

  public List<Node> getChildren(){
    // return copy of children
    return children;
  }

  public final toList(){
    list = new List<Token>();
    for(Token child : children){
      list.addAll(child.toList());
    }
    return list;
  }
}