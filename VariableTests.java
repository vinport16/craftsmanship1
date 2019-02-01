import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.junit.*;

public class VariableTests {

	@Test(expected = NullPointerException.class) 
	public void testVariableBuildFailsOnNull() { 
	    Variable.build(null);
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
	public void testVariableGetType() {
		Variable v = Variable.build("a");
		assertEquals(TerminalSymbol.VARIABLE, v.getType());
	}

	@Test
	public void testVariableGetRepresentation() {
		Variable v = Variable.build("a");
		assertEquals("a", v.getRepresentation());
	}

	@Test
	public void testVariableToString() {
		Variable v = Variable.build("a");
		assertEquals("a", v.toString());		
	}
}