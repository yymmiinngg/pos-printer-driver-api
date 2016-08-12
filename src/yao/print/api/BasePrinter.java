package yao.print.api;

import java.io.IOException;
import java.util.List;

import yao.print.api.content.Doucument;
import yao.print.api.content.Printable;
import yao.print.api.exception.PrinterException;

/**
 * 打印机对象
 */
public abstract class BasePrinter implements IPrinter {

	/**
	 * 设备信息，宽度，像素密度等
	 */
	private DeviceSetting deviceSetting;

	/**
	 * 指令转换器
	 */
	private ConverterKit convertKit;

	/**
	 * 连接，与具体设备的连接通道
	 */
	private Connection connection;

	final void init(String paramString) {
		this.deviceSetting = generateDeviceSetting(paramString);
		this.convertKit = generateConvert();

	}

	/**
	 * 获得一个转换器对象
	 * 
	 * @return
	 */
	protected abstract ConverterKit generateConvert();

	/**
	 * 获得一个配置对象
	 * 
	 * @param paramString
	 * @return
	 */
	protected abstract DeviceSetting generateDeviceSetting(String paramString);

	/**
	 * 设置打印机连接，只能设置一次
	 * 
	 * @param connection
	 * @throws PrinterException
	 */
	public void setConnection(final Connection connection) throws PrinterException {
		if (null != this.connection) {
			throw new PrinterException("Connection is already seted.");
		}
		this.connection = connection;
	}

	/**
	 * 检查打印机连接
	 * 
	 * @param connection
	 * @throws IOException
	 */
	protected abstract void checkConnection(Connection connection) throws IOException;

	/**
	 * 打印文档之前的动作
	 * 
	 * @param connection
	 * @throws IOException
	 */
	protected abstract void beforPrint(Connection connection) throws IOException;

	/**
	 * 打印文档，实际上是调用connection.write(byte[])来写入东西
	 * 
	 * @param content
	 * @return
	 * @throws IOException
	 * @throws PrinterException
	 */
	public void print(Doucument content) throws PrinterException {
		if (null == connection) {
			throw new PrinterException("Connection is null, please call setConnection() befor call print.");
		}
		try {
			checkConnection(connection);
			beforPrint(connection);
			printDocument(content);
			afterPrint(connection);
			connection.flush();
		} catch (IOException e) {
			throw new PrinterException(e);
		}
	}

	/**
	 * 打印动作之后的动作
	 * 
	 * @param connection
	 * @throws IOException
	 */
	protected abstract void afterPrint(Connection connection) throws IOException;

	/**
	 * 将打印条目转换为打印机识别的指令
	 * 
	 * @param content
	 * @return
	 * @throws IOException
	 * @throws PrinterException
	 */
	private void printDocument(Doucument content) throws PrinterException {
		List<Printable> printable_list = content.getContents();
		for (Printable printable : printable_list) {
			byte[] bs = convertKit.fromConverter(printable, deviceSetting);
			try {
				connection.write(bs);
			} catch (IOException e) {
				throw new PrinterException(e);
			}
		}
	}

	public Connection getConnection() {
		return connection;
	}

	public DeviceSetting getDeviceSetting() {
		return deviceSetting;
	}

	public ConverterKit getConvertKit() {
		return convertKit;
	}

}
