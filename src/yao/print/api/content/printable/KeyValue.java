package yao.print.api.content.printable;

import yao.print.api.content.Printable;

/**
 * 打印key=value型的文档，有紧凑和分离两种排列方式，如：<br/>
 * 紧凑型排列方式：
 * 
 * <pre>
 * |name: yaoming      |
 * |address: BeiJing   |
 * |         chaoyang  |
 * </pre>
 * 
 * 分离型排列方式：
 * 
 * <pre>
 * |name        yaoming|
 * |address            |
 * |   BeiJing ChaoYang|
 * </pre>
 * 
 * 输出完成后自动换新行
 */
public class KeyValue implements Printable {

	private boolean outter;

	private String key;

	private String value;

	/**
	 * 构造一个KeyValue项，紧凑排列
	 * 
	 * @param key
	 *            靠左的文本
	 * @param value
	 *            靠右的文本
	 */
	public KeyValue(String key, String value) {
		this.key = key;
		this.value = value;
	}

	/**
	 * 构造一个KeyValue项
	 * 
	 * @param key
	 *            靠左的文本
	 * @param value
	 *            靠右的文本
	 * @param outter
	 *            是否靠两端排列
	 */
	public KeyValue(String key, String value, boolean outter) {
		super();
		this.key = key;
		this.value = value;
		this.outter = outter;
	}

	public String getKey() {
		return key;
	}

	public String getValue() {
		return value;
	}

	public boolean isOutter() {
		return outter;
	}

	public void setOutter(boolean outter) {
		this.outter = outter;
	}

}
