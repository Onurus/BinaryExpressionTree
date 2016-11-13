package parser;

import java.util.List;

import launcher.ValueMap;
import model.Expression;

public class ExpressionParser {

	public static Expression parse(String string, ValueMap vm) {

		List<Expression> expressions = StringToExpressionParser.parse(string, vm);
		Expression result = ExpressionSimplifier.simplify(expressions);
		return result;

	}
}
