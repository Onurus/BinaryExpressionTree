package parser;

import java.util.ArrayList;
import java.util.List;

import model.Expression;
import model.Par;

public class ParenthesisSimplifier {

	public static List<Expression> simplify(List<Expression> expressions) {
		int pslast = -1;
		int peFirst = -1;
		for (int i = 0; i < expressions.size(); i++) {
			if (expressions.get(i) instanceof ParenStart) {
				pslast = i;
			}

			if (expressions.get(i) instanceof ParenEnd) {
				peFirst = i;
				break;
			}
		}

		if (peFirst != -1) {
			if (pslast < 0) {
				throw new UnsupportedOperationException("no macth for : (");
			} else {
				List<Expression> result = new ArrayList<Expression>();
				List<Expression> temp = new ArrayList<Expression>();
				for (int i = 0; i < expressions.size(); i++) {
					Expression e = expressions.get(i);
					if ((i < pslast) || (i > peFirst)) {
						result.add(e);
					} else if ((i > pslast) && (i < peFirst)) {
						temp.add(e);
					} else if ((i > pslast) && (i == peFirst)) {
						result.add(new Par(ExpressionSimplifier.simplify(temp)));
					}

				}
				return result;
			}
		} else {
			return expressions;
		}

	}

}
