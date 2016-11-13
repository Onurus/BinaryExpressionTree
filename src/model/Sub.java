package model;

public class Sub extends Operation {

	public Sub(Expression left, Expression right) {
		super(left, right);
	}

	@Override
	public Number evaluate() {

		return this.left.evaluate().doubleValue() - this.right.evaluate().doubleValue();
	}

	@Override
	public String getSymbol() {
		return "-";
	}

}
