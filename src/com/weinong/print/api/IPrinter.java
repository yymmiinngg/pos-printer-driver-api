package com.weinong.print.api;

import com.weinong.print.api.content.Doucument;
import com.weinong.print.api.exception.PrinterException;

public interface IPrinter {

	public void print(Doucument content) throws PrinterException;

}
