package com.weinong.print.api;

import java.util.HashMap;

/**
 * 设备设置对象
 */
public class DeviceSetting {

	/** 参数串 */
	private String paramString;
	/** 参数对 */
	private HashMap<String, String> params = new HashMap<String, String>();

	/**
	 * 可打印的宽度（像素）
	 */
	protected int drawablePixel;

	/** 字符编码 */
	protected String charset = "gbk";

	public DeviceSetting(String paramString, int drawablePixel, String charset) {
		super();
		this.paramString = paramString;
		this.drawablePixel = drawablePixel;
		this.charset = charset;
		String[] kvs = paramString.split("&");
		for (String kv : kvs) {
			int pos = kv.indexOf('=');
			if (-1 != pos) {
				String k = kv.substring(0, pos);
				String v = kv.substring(pos);
				params.put(k, v);
			}
		}
	}

	public int getDrawablePixel() {
		return drawablePixel;
	}

	public String getCharset() {
		return charset;
	}

	public String getParamString() {
		return paramString;
	}

}
