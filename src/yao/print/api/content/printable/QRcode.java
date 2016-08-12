package yao.print.api.content.printable;

import yao.print.api.content.Printable;

/**
 * 二维码<br/>
 * 输出完成后自动换新行
 */
public class QRcode implements Printable {

	/** 上下文间距(像素) */
	private int margin;

	/** 内容 */
	private String content;

	/** 宽度(像素) */
	private Integer width;

	/**
	 * 构造一个二维码
	 * 
	 * @param content
	 *            二维码内容
	 * @param width
	 *            图片宽度(像素)
	 */
	public QRcode(String content, int width) {
		this.content = content;
		this.width = width;
	}

	/**
	 * 构造一个二维码
	 * 
	 * @param content
	 *            二维码内容
	 * @param width
	 *            图片宽度(像素)
	 * @param margin
	 *            上下文间距(像素)
	 */
	public QRcode(String content, int width, int margin) {
		this.content = content;
		this.width = width;
		this.margin = margin;
	}

	/**
	 * 构造一个二维码，使用默认宽度
	 * 
	 * @param content
	 *            二维码内容
	 */
	public QRcode(String content) {
		this.content = content;
		this.width = 0;
	}

	public String getContent() {
		return content;
	}

	public Integer getWidth() {
		return width;
	}

	public int getMargin() {
		return margin;
	}

	public void setMargin(int margin) {
		this.margin = margin;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public void setWidth(Integer width) {
		this.width = width;
	}
}
