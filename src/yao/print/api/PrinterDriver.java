package yao.print.api;

public class PrinterDriver {

	/**
	 * 重构一个打印机对象
	 * 
	 * @param driver
	 *            打印机驱动
	 * @param paramString
	 *            打印机专有配置
	 * @return
	 * @throws ClassNotFoundException
	 * @throws IllegalAccessException
	 * @throws InstantiationException
	 */
	public static BasePrinter newInstanse(String driver, String paramString) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		BasePrinter p = null;
		p = (BasePrinter) Class.forName(driver).newInstance();
		p.init(paramString);
		return p;
	}

}
