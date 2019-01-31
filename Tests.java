import static org.junit.Assertions.assertEquals;

import org.junit.Test;

import java.util.*;

public class MyTests {

    @Test
    public void createExpressionTree() {
        LeafNode c = LeafNode.build(Variable.build("c"));
        LeafNode divide = LeafNode.build(Variable.build("/"));
        InternalNode divideByC = InternalNode.build(Arrays.asList(c,divide));

        LeafNode b = LeafNode.build(Variable.build("b"));

        InternalNode bOverC = InternalNode.build(Arrays.asList(b,divideByC));

        // assert statements
        //assertEquals(0, tester.multiply(10, 0), "10 x 0 must be 0");
        //assertEquals(0, tester.multiply(0, 10), "0 x 10 must be 0");
        //assertEquals(0, tester.multiply(0, 0), "0 x 0 must be 0");
    }
}