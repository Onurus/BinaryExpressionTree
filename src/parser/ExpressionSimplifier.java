package parser;

import java.util.List;

import model.Expression;
import parser.OperationChar.OpType;

public class ExpressionSimplifier {

	public static Expression simplify(List<Expression> expressions) {
		expressions = ParenthesisSimplifier.simplify(expressions);
		expressions = FourOperationSimplifier.simplify(expressions, OpType.Mul, OpType.Div);
		expressions = FourOperationSimplifier.simplify(expressions, OpType.Add, OpType.Sub);

		if (expressions.size() == 1) {
			return expressions.get(0);
		} else {
			throw new UnsupportedOperationException("ExpressionSimplifier : Stack size : " + expressions.size());
		}
	}
}
