package com.weinong.print.api.content.convertable;

import com.weinong.print.api.content.Convertable;

/**
 * 文本，可以设置文本的格式
 */
public class Text implements Convertable {

	private String text;
	private Font font;

	/**
	 * 用默认字体构造一个文本对象
	 * 
	 * @param text
	 */
	public Text(String text) {
		this(text, Font.DEFAULT);
	}

	/**
	 * 用指定字体构造一个文本对象
	 * 
	 * @param text
	 * @param font
	 */
	public Text(String text, Font font) {
		this.text = text;
		this.font = font;
	}

	public String getText() {
		return text;
	}

	public Font getFont() {
		return font;
	}

	public void setFont(Font textStyle) {
		this.font = textStyle;
	}

}
