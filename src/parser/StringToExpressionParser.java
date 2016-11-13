package parser;

import java.util.ArrayList;
import java.util.List;

import launcher.ValueMap;
import model.Expression;
import model.Val;
import model.Var;
import parser.OperationChar.OpType;

public class StringToExpressionParser {

	public static List<Expression> parse(String string, ValueMap vm) {

		List<Expression> expressions = new ArrayList<Expression>();

		string = string.trim().replaceAll("[)]", " )").replaceAll("[(]", "( ");
		String[] list = string.split(" ");
		for (String str : list) {

			try {
				expressions.add(new Val(Double.parseDouble(str)));
			} catch (Exception e) {
				if (!str.isEmpty()) {
					if (str.equals("(")) {
						expressions.add(new ParenStart());
					} else if (str.equals(")")) {
						expressions.add(new ParenEnd());
					} else if (str.equals("-")) {
						expressions.add(new OperationChar(OpType.Sub));
					} else if (str.equals("+")) {
						expressions.add(new OperationChar(OpType.Add));
					} else if (str.equals("*")) {
						expressions.add(new OperationChar(OpType.Mul));
					} else if (str.equals("/")) {
						expressions.add(new OperationChar(OpType.Div));
					} else {
						expressions.add(new Var(str, vm));
					}
				}
			}
		}
		return expressions;
	}
}
