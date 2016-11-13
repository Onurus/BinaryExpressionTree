package model;

public class Div extends Operation {

	public Div(Expression left, Expression right) {
		super(left, right);
	}

	@Override
	public Number evaluate() {

		return this.left.evaluate().doubleValue() / this.right.evaluate().doubleValue();
	}

	@Override
	public String getSymbol() {
		return "/";
	}

}
