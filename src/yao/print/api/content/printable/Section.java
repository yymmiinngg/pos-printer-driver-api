package yao.print.api.content.printable;

import java.util.LinkedList;

import yao.print.api.content.Convertable;
import yao.print.api.content.Printable;
import yao.print.api.content.convertable.Font;
import yao.print.api.content.convertable.LF;
import yao.print.api.content.convertable.Text;

/**
 * 打印文字块，每个文字块是一个段落<br/>
 * 输出完成后自动换新行
 */
public class Section implements Printable {

	private LinkedList<Convertable> convertables = new LinkedList<Convertable>();
	private TextAlign textAlign;
	private Font defaultFont;

	/** 对齐方式 */
	public enum TextAlign {
		Left, Center, Right;
	}

	/**
	 * 一段普通文本
	 * 
	 * @param text
	 *            文本内容
	 */
	public Section(String text) {
		this(text, Font.DEFAULT, TextAlign.Left);
	}

	/**
	 * 一段
	 * 
	 * @param text
	 * @param font
	 */
	public Section(String text, Font font) {
		this(text, font, TextAlign.Left);
	}

	public Section(String text, TextAlign textAlign) {
		this(text, Font.DEFAULT, textAlign);
	}

	public Section(String text, Font font, TextAlign textAlign) {
		this.convertables.add(new Text(text, font));
		this.textAlign = textAlign;
		this.defaultFont = font;
	}

	public void addText(Text text) {
		this.convertables.add(text);
	}

	public void addText(String text) {
		this.convertables.add(new Text(text, defaultFont));
	}

	public void addText(String text, Font font) {
		this.convertables.add(new Text(text, font));
	}

	public void addLF() {
		this.convertables.add(new LF());
	}

	public LinkedList<Convertable> getConvertables() {
		return convertables;
	}

	public TextAlign getTextAlign() {
		return textAlign;
	}

	public void setTextAlign(TextAlign textAlign) {
		this.textAlign = textAlign;
	}

}
