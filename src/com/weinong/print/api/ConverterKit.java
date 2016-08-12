package com.weinong.print.api;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import sun.reflect.generics.reflectiveObjects.ParameterizedTypeImpl;

import com.weinong.print.api.content.Convertable;
import com.weinong.print.api.exception.PrinterException;

/**
 * 可打印对象的转换器
 */
public abstract class ConverterKit {

	/**
	 * 可打印类型 对应 转换器类型
	 */
	private HashMap<Class<?>, Class<?>> convertMap = new HashMap<Class<?>, Class<?>>();

	/**
	 * 构造一个转换器套件
	 */
	public ConverterKit() {
		Set<Class<? extends Converter<?>>> set = new HashSet<Class<? extends Converter<?>>>();
		// 先获得所有注册的转换器
		registConverter(set);
		for (Class<?> c : set) {
			// 通过泛型生成匹配图
			ParameterizedTypeImpl pti = (ParameterizedTypeImpl) c.getGenericSuperclass();
			convertMap.put((Class<?>) pti.getActualTypeArguments()[0], c);
		}
	}

	/**
	 * 注册转换器<br/>
	 * 将转换器add到converters集合中
	 * 
	 * @param converters
	 *            转换器
	 */
	protected abstract void registConverter(Set<Class<? extends Converter<?>>> converters);

	/**
	 * 匹配转换器
	 * 
	 * @param printable
	 *            可打印对象
	 * @return
	 * @throws PrinterException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private Converter<?> matchConverter(Convertable printable) throws PrinterException {
		Class<?> commandClass = convertMap.get(printable.getClass());
		if (null == commandClass) {
			if (noMatchConverterException()) {
				throw new PrinterException(printable.getClass() + " has not registed converter.");
			}
			return null;
		}
		Converter cc;
		try {
			cc = (Converter<?>) commandClass.newInstance();
		} catch (InstantiationException | IllegalAccessException e) {
			throw new PrinterException("New converter instance error.", e);
		}
		cc.setConvertable(printable);
		cc.setConverterKit(this);
		return cc;
	}

	/**
	 * 获得转换后的字节
	 * 
	 * @param convertable
	 *            可转换对象
	 * @param deviceSetting
	 * @return
	 * @throws PrinterException
	 */
	public byte[] fromConverter(Convertable convertable, DeviceSetting deviceSetting) throws PrinterException {
		Converter<?> c;
		c = matchConverter(convertable);
		if (null == c) {
			return new byte[0];
		}
		return c.toBytes(deviceSetting);
	}

	public abstract boolean noMatchConverterException();

}
