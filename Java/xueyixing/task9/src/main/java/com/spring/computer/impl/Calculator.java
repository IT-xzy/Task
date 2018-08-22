package com.spring.computer.impl;

import com.spring.computer.*;
import org.oasisopen.sca.annotation.Reference;

public class Calculator implements CalculatorInterface {

	/**
	 * 引用其他组件IAdd，ISubtract，IMultiply,IDivide
	 * @Reference 说明引用其他组件 会和.composite文件进行配置
	 */
	private addInterface add;//加法组件
	private subtractInterface subtract;//减法组件
	private multiplyInterface multiply;//乘法组件
	private divideInterface divide;//除法组件
	public addInterface getAdd() {
		return add;
	}
	@Reference
	public void setAdd(addInterface add) {
		this.add = add;
	}

	public subtractInterface getSubtract() {
		return subtract;
	}
	@Reference
	public void setSubtract(subtractInterface subtract) {
		this.subtract = subtract;
	}

	public multiplyInterface getMultiply() {
		return multiply;
	}
	@Reference
	public void setMultiply(multiplyInterface multiply) {
		this.multiply = multiply;
	}

	public divideInterface getDivide() {
		return divide;
	}
	@Reference
	public void setDivide(divideInterface divide) {
		this.divide = divide;
	}


	public double add(double n1, double n2) {
		return this.add.add(n1, n2);
	}

	public double subtract(double n1, double n2) {
		return this.subtract.subtract(n1, n2);
	}

	public double divide(double n1, double n2) {
		return this.divide.divide(n1, n2);
	}

	public double multiply(double n1, double n2) {
		return this.multiply.multiply(n1, n2);
	}
}