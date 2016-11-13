package parser;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import model.Add;
import model.Div;
import model.Expression;
import model.Mul;
import model.Sub;
import parser.OperationChar.OpType;

public class FourOperationSimplifier {

	public static List<Expression> simplify(List<Expression> expressions, OpType... oppTypes) {
		Stack<Expression> stack = new Stack<Expression>();
		for (Expression expression : expressions) {
			if (stack.isEmpty()) {
				stack.add(expression);
			} else {
				Expression left1 = stack.pop();
				if (checkInstanceOppType(left1, oppTypes)) {
					Expression left2 = stack.pop();
					stack.add(mergeOpp(left2, left1, expression));
				} else {
					stack.add(left1);
					stack.add(expression);
				}
			}
		}
		return new ArrayList<Expression>(stack);
	}

	private static boolean checkInstanceOppType(Expression left1, OpType[] oppTypes) {
		if (left1 instanceof OperationChar) {
			for (int i = 0; i < oppTypes.length; i++) {
				if (oppTypes[i] == ((OperationChar) left1).type) {
					return true;
				}
			}
		}
		return false;
	}

	private static Expression mergeOpp(Expression left, Expression opp, Expression right) {
		OperationChar oc = (OperationChar) opp;
		switch (oc.type) {
		case Div:
			return new Div(left, right);
		case Sub:
			return new Sub(left, right);
		case Mul:
			return new Mul(left, right);
		case Add:
			return new Add(left, right);
		default:
			break;

		}
		throw new UnsupportedOperationException("Not operation char : " + oc.type);
	}

}
