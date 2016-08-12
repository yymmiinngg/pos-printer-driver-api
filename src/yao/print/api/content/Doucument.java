package yao.print.api.content;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

/**
 * 此类位要打印的单个单据内容的集合容器，
 */
public class Doucument {

	private LinkedList<Printable> contents = new LinkedList<>();

	/**
	 * 获得内容
	 * 
	 * @return
	 */
	public List<Printable> getContents() {
		return contents;
	}

	/**
	 * 添加一条内容
	 * 
	 * @param content
	 * @return
	 */
	public boolean addContent(Printable content) {
		return this.contents.add(content);
	}

	/**
	 * 添加多条内容，默认跟在原有内容后面
	 * 
	 * @param contents
	 * @return
	 */
	public boolean addContents(Collection<Printable> contents) {
		return this.contents.addAll(contents);
	}

	/**
	 * 在头部插入打印条目
	 * 
	 * @param content
	 * @return
	 */
	public void addFirst(Printable content) {
		this.contents.addFirst(content);
	}
}
