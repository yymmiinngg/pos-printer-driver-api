package com.weinong.print.api.content.printable;

import com.weinong.print.api.content.Printable;

/**
 * 打印点位图片，即，将要打印的图片的位图存储进来，默认传入进来的是24位图（RGB）<br/>
 * 输出完成后自动换新行
 */
public class Image implements Printable {

	/** 上下文间距(像素) */
	private int margin;

	/** 图片宽度，像素数，必填 */
	private int width;

	/** 图片高度，像素数，必填 */
	private int height;

	/** 图片的点阵图，必填 */
	private int[] pixels;

	/**
	 * 构造一个图片对象
	 * 
	 * @param width
	 *            宽度(像素)
	 * @param height
	 *            高度(像素)
	 * @param pixels
	 *            位图数据
	 * @param margin
	 *            上下文间距(像素)
	 */
	public Image(int width, int height, int[] pixels, int margin) {
		this.width = width;
		this.height = height;
		this.pixels = pixels;
		this.margin = margin;
	}

	/**
	 * 构造一个图片对象
	 * 
	 * @param width
	 *            宽度(像素)
	 * @param height
	 *            高度(像素)
	 * @param pixels
	 *            位图数据
	 */
	public Image(int width, int height, int[] pixels) {
		this(width, height, pixels, 0);
	}

	/**
	 * 缩放图形
	 * 
	 * @param width
	 *            缩放后的宽度
	 * @param height
	 *            缩放后的高度
	 */
	public void scale(int width, int height) {
		double widthRate, heightRate;
		widthRate = (double) getWidth() / width;
		heightRate = (double) getHeight() / height;
		int[] srcBytes = getPixels();
		int[] destBytes = new int[width * height];
		for (int y = 0; y < height; y++) {
			for (int x = 0; x < width; x++) {
				int i = toInt(y * heightRate) * toInt(width * widthRate) + toInt(x * widthRate);
				destBytes[y * width + x] = srcBytes[i];
			}
		}
		this.width = width;
		this.height = height;
		this.pixels = destBytes;
	}

	/**
	 * 缩放图形
	 * 
	 * @param width
	 *            缩放后的宽度
	 */
	public void scaleWidth(int width) {
		scale(width, (int) (((double) width / getWidth()) * getHeight()));
	}

	private static int toInt(double n) {
		return (int) n;
	}

	public int[] getPixels() {
		return this.pixels;
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	public int getMargin() {
		return margin;
	}

	public void setMargin(int margin) {
		this.margin = margin;
	}

}
