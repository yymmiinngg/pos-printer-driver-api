package yao.print.api;

import java.io.IOException;

public interface Connection {

	void write(byte[] bytes) throws IOException;

	void write(byte[] bytes, int start, int length) throws IOException;

	void flush() throws IOException;

	int read(byte[] bytes) throws IOException;

	void close() throws IOException;

}
