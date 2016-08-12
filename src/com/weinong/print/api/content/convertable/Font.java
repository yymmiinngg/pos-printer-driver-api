package com.weinong.print.api.content.convertable;

import com.weinong.print.api.content.Convertable;

/**
 * 文本样式，对所有文本有效
 */
public class Font implements Convertable {

	/** 字体 */
	public enum FontSize {
		Max, Big, Normal
	}

	/** 默认配置，正常字体，无加粗，无下划线 */
	public static final Font DEFAULT = new Font(FontSize.Normal, false, false);

	/** 字体大小 */
	private FontSize fontSize;

	/** 加粗 */
	private boolean bold;

	/** 是否有下划线 */
	private boolean underline;

	/**
	 * 构造一个字体对象
	 * 
	 * @param fontSize
	 *            字体大小
	 */
	public Font(FontSize fontSize) {
		this.fontSize = fontSize;
		this.bold = false;
		this.underline = false;
	}

	/**
	 * 构造一个字体对象
	 * 
	 * @param fontSize
	 *            字体大小
	 * @param fontBold
	 *            是否粗体
	 * @param underline
	 *            是否下划线
	 */
	public Font(FontSize fontSize, boolean fontBold, boolean underline) {
		this.fontSize = fontSize;
		this.bold = fontBold;
		this.underline = underline;
	}

	public FontSize getFontSize() {
		return fontSize;
	}

	public void setFontSize(FontSize fontSize) {
		this.fontSize = fontSize;
	}

	public boolean isBold() {
		return bold;
	}

	public void setBold(boolean fontBold) {
		this.bold = fontBold;
	}

	public boolean isUnderline() {
		return underline;
	}

	public void setUnderline(boolean fontItalic) {
		this.underline = fontItalic;
	}

}
