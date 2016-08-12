package yao.print.api;

import yao.print.api.content.Doucument;
import yao.print.api.exception.PrinterException;

public interface IPrinter {

	public void print(Doucument content) throws PrinterException;

}
