package yao.print.api.content.printable;

import yao.print.api.content.Printable;

/**
 * 条形码(Code128编码)<br/>
 * 输出完成后自动换新行
 */
public class Barcode implements Printable {

	/** 上下文间距(像素) */
	private int margin;

	/**
	 * 内容，必须设置
	 */
	private String content;

	/**
	 * 高度(像素)，必须设置
	 */
	private int height;

	/**
	 * 构造一个条形码对象
	 * 
	 * @param content
	 *            条码内容
	 */
	public Barcode(String content) {
		this(content, 0, 0);
	}

	/**
	 * 构造一个条形码对象
	 * 
	 * @param content
	 *            条码内容
	 * @param height
	 *            条码高度(像素)
	 */
	public Barcode(String content, int height) {
		this(content, height, 0);
	}

	/**
	 * 构造一个条形码对象
	 * 
	 * @param content
	 *            条码内容
	 * @param height
	 *            条码高度(像素)
	 * @param margin
	 *            上下文间距(像素)
	 */
	public Barcode(String content, int height, int margin) {
		this.content = content;
		this.height = height;
		this.margin = margin;

	}

	public String getContent() {
		return content;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getMargin() {
		return margin;
	}

	public void setMargin(int margin) {
		this.margin = margin;
	}

}
