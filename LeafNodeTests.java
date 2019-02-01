import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.junit.*;

public class LeafNodeTests {

  @Test
  public void testLeafNodesMethods() {
    LeafNode a = LeafNode.build(Variable.build("a"));
    LeafNode times = LeafNode.build(Connector.build(TerminalSymbol.TIMES));
    LeafNode a2 = LeafNode.build(Variable.build("a"));
    
    assertTrue("two 'a' tokens in two different LeafNodes have different representations", ((Variable)a.getToken()).getRepresentation() == ((Variable)a2.getToken()).getRepresentation());
    assertTrue("the 'a' token in a LeafNode does produce a string of 'a'", a.getToken().toString().equals("a"));
    assertTrue("LeafNode toString doesn't work", times.toString().equals("*"));
  }
  
}
