package model;

public abstract class Operation implements Expression {

	protected Expression left;
	protected Expression right;

	public Operation(Expression left, Expression right) {
		this.left = left;
		this.right = right;
	}

	@Override
	public String toExpressionString() {
		return this.left.toExpressionString() + getSymbol() + this.right.toExpressionString();
	}

	public abstract String getSymbol();

}
