package yao.print.api.content.printable;

import java.util.LinkedList;
import java.util.List;

import yao.print.api.content.Printable;
import yao.print.api.exception.PrintException;

/**
 * 表格<br/>
 * 表格从第2列开始，每列之前都会增加一个空格位，也就是说这些列的实际可用宽度会少一个字条位置。 <br/>
 * 如：{10,10,10}的列宽设置，而列的实际可用字符位置数为：{10,9,9} <br/>
 * 输出完成后自动换新行
 */
public class Table implements Printable {

	/** 表头内容 */
	private String[] headers;

	/** 每个单元格的宽度（字符数），中文算两个，英文算一个 */
	private int[] columnWidths;

	/** 是否靠右打印，默认为靠左打印 */
	private boolean[] alignRights;

	/** 行内容 */
	private List<Object[]> rows = new LinkedList<Object[]>();

	/**
	 * 线行
	 */
	public static final Object[] LINE_ROW = new Object[] { '-' };

	/**
	 * 构造一个表格
	 * 
	 * @param headers
	 *            表头
	 * @param columnWidths
	 *            列宽
	 */
	public Table(String[] headers, int[] columnWidths) {
		this.headers = headers;
		this.columnWidths = columnWidths;
	}

	/**
	 * 构造一个表格
	 * 
	 * @param headers
	 *            表头
	 * @param columnWidths
	 *            表头
	 * @param alignRights
	 *            列对齐
	 */
	public Table(String[] headers, int[] columnWidths, boolean[] alignRights) {
		if (headers.length != columnWidths.length || headers.length != alignRights.length) {
			throw new PrintException("The number of headers & cellWidths & alignRights must be equal!");
		}
		this.headers = headers;
		this.columnWidths = columnWidths;
		this.alignRights = alignRights;
	}

	public String[] getHeaders() {
		return headers;
	}

	public int[] getColumnWidths() {
		return columnWidths;
	}

	public boolean[] getAlignRights() {
		return alignRights;
	}

	public boolean addOneRow(Object[] lineRow) {
		return rows.add(lineRow);
	}

	public boolean addManyRows(List<Object[]> many_rows) {
		return rows.addAll(many_rows);
	}

	public List<Object[]> getRows() {
		return rows;
	}
}
