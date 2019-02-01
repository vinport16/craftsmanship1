import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.junit.*;

public class ConnectorTests {

	@Test(expected = NullPointerException.class) 
	public void testConnectorBuildFailsOnNull() { 
	    Connector.build(null);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testConnectorBuildFailsOnVariable() {
		Connector.build(TerminalSymbol.VARIABLE);
	}

	// @Test
	// public void testConnectorBuildNotCached() {
	// 	assertEquals("TerminalSymbol is not ADD", Connector.build(TerminalSymbol.ADD));
	// }

	// @Test
	// public void testConnectorBuildCached() {
	// 	Connector.build(TerminalSymbol.ADD);
	// }

	@Test
	public void testConnectorGetType() {
		Connector c = Connector.build(TerminalSymbol.PLUS);
		assertEquals("TerminalSymbol getType does not return correct type", TerminalSymbol.PLUS, c.getType());
	}

	@Test
	public void testConnectorToString() {
		Connector c = Connector.build(TerminalSymbol.PLUS);
		assertEquals("+", c.toString());
	}

	@Test
	public void testInternalNodesNotCached() {
		List<Node> children = new LinkedList<>();
		children.add(LeafNode.build(Variable.build("a")));
		children.add(LeafNode.build(Connector.build(TerminalSymbol.TIMES)));
		children.add(LeafNode.build(Variable.build("b")));
		
		//assertFalse(InternalNode.build(children) == InternalNode.build(children));
		assertFalse("Hello", true);
	}
}