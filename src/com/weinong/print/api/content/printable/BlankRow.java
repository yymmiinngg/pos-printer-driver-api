package com.weinong.print.api.content.printable;

import com.weinong.print.api.content.Printable;

/**
 * 前进多行，输出指定数量的空白行<br/>
 * 输出完成后自动换新行
 */
public class BlankRow implements Printable {

	/**
	 * 前进行数
	 */
	private int lineNumber;

	/**
	 * 输出指定行数的空白行
	 * 
	 * @param lineNumber
	 */
	public BlankRow(int lineNumber) {
		this.lineNumber = lineNumber;
	}

	/**
	 * 输出一个空白行
	 */
	public BlankRow() {
		this(1);
	}

	public int getLineNumber() {
		return lineNumber;
	}

	public void setLineNumber(int lineNumber) {
		this.lineNumber = lineNumber;
	}

}
