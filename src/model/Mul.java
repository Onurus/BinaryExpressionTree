package model;

public class Mul extends Operation {

	public Mul(Expression left, Expression right) {
		super(left, right);
	}

	@Override
	public Number evaluate() {

		return this.left.evaluate().doubleValue() * this.right.evaluate().doubleValue();
	}

	@Override
	public String getSymbol() {
		return "*";
	}

}
