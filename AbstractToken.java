public abstract class AbstractToken implements Token {

	private TerminalSymbol type;

	public TerminalSymbol getType() {
		return type;
	}

	public final boolean matches(TerminalSymbol type) {
		return (this.type == type);
	}
}