package model;

public class Par implements Expression {

	Expression inside;

	public Par(Expression inside) {
		super();
		this.inside = inside;
	}

	@Override
	public Number evaluate() {
		return this.inside.evaluate();
	}

	@Override
	public String toExpressionString() {

		return "(" + this.inside.toExpressionString() + ")";
	}

}
