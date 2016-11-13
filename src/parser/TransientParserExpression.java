package parser;

import model.Expression;

public class TransientParserExpression implements Expression {
	@Override
	public Number evaluate() {
		throw new UnsupportedOperationException("NOT FINAL PARSED CLASS");
	}

	@Override
	public String toExpressionString() {
		throw new UnsupportedOperationException("NOT FINAL PARSED CLASS");
	}
}
