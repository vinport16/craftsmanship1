package parser;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
//import static org.junit.Assert.assertThrows;
import static org.junit.Assert.fail;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.junit.Test;

class InternalNodeTests {

	@Test(expected = NullPointerException.class) 
	public void testInternalNodeFailsOnNull() { 
	     InternalNode.build(null);
	}

/*	@Test
	void testInternalNodeFailsOnNull() {
		assertThrows(NullPointerException.class, () -> {
			InternalNode.build(null);
		});
	}
*/

	@Test
	void testInternalNodesNotCached() {
		List<Node> children = new LinkedList<>();
		children.add(LeafNode.build(Variable.build("a")));
		children.add(LeafNode.build(Connector.build(TerminalSymbol.TIMES)));
		children.add(LeafNode.build(Variable.build("b")));
		
		assertFalse(InternalNode.build(children) == InternalNode.build(children));
	}
	
}
