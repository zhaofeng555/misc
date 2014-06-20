package hjg.jdbc.hibernate;

import java.util.ArrayList;

/**
 * @author hjg
 * @version 创建时间：2010-2-3下午03:24:27 类说明
 * 
 **/
public class Page {
	private static int DEFAULT_PAGE_SIZE = 8;

	private Object data; // 当前页中存放的记录，类型一般为List

	private int pageSize = DEFAULT_PAGE_SIZE;

	private int skipPageNo;
	private long start; // 当前第一条数据在List中的位置，从0开始
	private long totalCount; // 总记录数

	public Page() {
		this(0, 0, DEFAULT_PAGE_SIZE, new ArrayList());
	}

	public Page(long start, long totalCount, int pageSize, Object data) {
		this.pageSize = pageSize;
		this.start = start;
		this.data = data;
		this.totalCount = totalCount;
	}

	public Page(String start, String pageSize) {
		this(Integer.parseInt(start), 0,
				(Integer.parseInt(pageSize) == 0 ? DEFAULT_PAGE_SIZE : Integer
						.parseInt(pageSize)), new ArrayList());
	}

	/*
	 * 取该页当前的页码，页码从1开始
	 */
	public long getCurrentPageNo() {
		return start / pageSize + 1;
	}

	/*
	 * 取得每页数据容量
	 */
	public int getPageSize() {
		return pageSize;
	}

	/*
	 * 取当前页中的记录
	 */
	public Object getResult() {
		return data;
	}

	public int getSkipPageNo() {
		return skipPageNo;
	}

	public int getStart() {
		return Long.valueOf(start).intValue();
	}

	/*
	 * @see #getStartOfPage(int, int)
	 */
	public int getStartOfPage(int pageNo) {
		return this.getStartOfPage(pageNo, DEFAULT_PAGE_SIZE);
	}
	
	/*
	 * 获取任一页第一条数据在数据集的位置，每页条数使用默认值
	 */
	public int getStartOfPage(int pageNo, int pageSize) {
		return (pageNo - 1) * pageSize;
	}

	/*
	 * 取得总的记录数
	 */
	public long getTotalCount() {
		return this.totalCount;
	}

	/*
	 * 获取总的页数
	 */
	public long getTotalPageCount() {
		if (totalCount % pageSize == 0) {
			return totalCount / pageSize;
		} else {
			return totalCount / pageSize + 1;
		}
	}

	/*
	 * 判断是否有下一页
	 */
	public boolean hasNextPage() {
		return this.getCurrentPageNo() < this.getTotalPageCount() - 1;
	}

	/*
	 * 判断是否有上一页
	 */
	public boolean hasPreviousPage() {
		return this.getCurrentPageNo() > 1;
	}

	public void setResult(Object data) {
		this.data = data;
	}

	public void setSkipPageNo(int skipPageNo) {
		this.skipPageNo = skipPageNo;
	}

	public void setTotalCount(long totalCount) {
		this.totalCount = totalCount;
	}

}

