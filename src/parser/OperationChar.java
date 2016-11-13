package parser;


public class OperationChar extends TransientParserExpression {

	enum OpType {
		Add, Sub, Div, Mul;
	}

	OpType type;

	public OperationChar(OpType type) {
		super();
		this.type = type;
	}

}
