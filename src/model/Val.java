package model;

public class Val implements Expression {

	Number val;

	public Val(Number val) {
		super();
		this.val = val;
	}

	@Override
	public Number evaluate() {
		return this.val;
	}

	@Override
	public String toExpressionString() {
		return this.val.toString();
	}

}
