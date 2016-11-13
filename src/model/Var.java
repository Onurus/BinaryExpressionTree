package model;

import launcher.ValueMap;

public class Var implements Expression {

	public String name;
	private ValueMap vm;

	public Var(String name, ValueMap vm) {
		super();
		this.name = name;
		this.vm = vm;
	}

	@Override
	public String toExpressionString() {
		return this.name;
	}

	@Override
	public Number evaluate() {
		return this.vm.getValue(this.name);
	}

}
