package yao.print.api;

import yao.print.api.content.Convertable;
import yao.print.api.exception.PrinterException;

/**
 * 指令转换器
 */
public abstract class Converter<T extends Convertable> {

	/** 可转换对象 */
	private T convertable;

	/** 指令转换器套件 */
	private ConverterKit converterKit;

	/**
	 * 转化为byte来方便打印
	 * 
	 * @param deviceSetting
	 *            设备设置
	 * @return
	 */
	protected abstract byte[] toBytes(DeviceSetting deviceSetting) throws PrinterException;

	public T getConvertable() {
		return convertable;
	}

	void setConvertable(T convertable) {
		this.convertable = convertable;
	}

	public ConverterKit getConverterKit() {
		return converterKit;
	}

	void setConverterKit(ConverterKit converterKit) {
		this.converterKit = converterKit;
	}

}
