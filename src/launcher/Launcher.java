package launcher;

import model.Expression;
import parser.ExpressionParser;

public class Launcher {

	public static void main(String[] args) {

		ValueMap vm = new ValueMap();
		Expression rootExpression = ExpressionParser.parse("-2 * x + (y - 3) * x", vm);
		vm.put("x", 1);
		vm.put("y", 6);

		System.err.println(rootExpression.toExpressionString() + " = " + rootExpression.evaluate() + " (for values: "
				+ vm.printValMap() + ")");

		vm = new ValueMap();
		rootExpression = ExpressionParser.parse("2 * y + 5 * x * ( 2 * x + y - 10 ) - 5 * y ", vm);
		vm.put("x", 5);
		vm.put("y", 3);

		System.err.println(rootExpression.toExpressionString() + " = " + rootExpression.evaluate() + " (for values: "
				+ vm.printValMap() + ")");

	}
}
