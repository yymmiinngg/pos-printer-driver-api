package com.weinong.print.api.content.printable;

import com.weinong.print.api.content.Printable;

/**
 * 打印一个线条，可以设置上下文间距（像素）和粗细（height,注意这里设置的是像素点）<br/>
 * 输出完成后自动换新行
 */
public class Line implements Printable {

	public static final Line DOT_THIN = new Line(0, 1, true);
	public static final Line DOT_THICK = new Line(0, 2, true);
	public static final Line SOLID_THIN = new Line(0, 1, false);
	public static final Line SOLID_THICK = new Line(0, 2, false);

	/**
	 * 线行距，该线条相对上一行的距离 和该线条距离下一行的距离(像素)
	 */
	private int margin;

	/**
	 * 线高度 这个单位是像素点
	 */
	private int height;

	/**
	 * 是否为虚实交叉线
	 */
	private boolean dotted = false;

	/**
	 * 一条简单的实横线, margin=1px, height=1px
	 */
	public Line() {
		this(0, 1, false);
	}

	/**
	 * 一条横线, margin=1px, height=1px
	 * 
	 * @param dotted
	 *            是否虚线
	 */
	public Line(boolean dotted) {
		this(0, 1, dotted);
	}

	/**
	 * 一条横线
	 * 
	 * @param margin
	 *            与上下文的间距(像素)
	 * @param height
	 *            线高(像素)
	 * @param dotted
	 *            是否虚线
	 */
	public Line(int margin, int height, boolean dotted) {
		this.margin = margin;
		this.height = height;
		this.dotted = dotted;
	}

	public int getMargin() {
		return margin;
	}

	public void setMargin(int margin) {
		this.margin = margin;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public boolean isDotted() {
		return dotted;
	}

	public void setDotted(boolean dotted) {
		this.dotted = dotted;
	}

}
