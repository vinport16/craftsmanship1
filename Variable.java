public final class Variable extends AbstractToken {

	private TerminalSymbol type = TerminalSymbol.VARIABLE;
	private final String representation;
	private static Cache<String, Variable> cache = new Cache<String, Variable>();

	private Variable(String representation) {
		this.representation = representation;
	}

	public TerminalSymbol getType() {
		return type;
	}

	public final String getRepresentation() {
		return representation;
	}

	// Returns a variable with given representation or
	// Throws a NullPointerException if representation is null
	public static final Variable build(String representation) {
		if (representation == null) {
			throw new NullPointerException("representation provided is null");
		} else if(cache.containsKey(representation)) {
			return cache.get(representation, rep -> new Variable(rep));
		} else {
			return new Variable(representation);
		}
	}

	public String toString() {
		return representation;
	}

}