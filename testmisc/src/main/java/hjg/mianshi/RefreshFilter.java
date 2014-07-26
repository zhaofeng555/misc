package hjg.mianshi;

import java.io.IOException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RefreshFilter implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {

		filter((HttpServletRequest) request, (HttpServletResponse) response,
				chain);
	}

	private void filter(HttpServletRequest request,
			HttpServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		String requestURI = request.getRequestURI();
		Cache cache = Cache.getInstance();
		cache.increment(requestURI);
		if (cache.isUpCount(requestURI)) {
			response.getWriter().println("到达次数，不允许请求，请稍候再试");
			return;
		}
		chain.doFilter(request, response);
	}

	@Override
	public void destroy() {

	}

	@Override
	public void init(FilterConfig config) throws ServletException {

	}

	// 缓存
	private static class Cache {

		private static final ConcurrentHashMap<String, CopyOnWriteArrayList<Long>> map = new ConcurrentHashMap<String, CopyOnWriteArrayList<Long>>();
		private static final long EXPIRE_TIME = 1000 * 20L;
		private static final long CLEAR_TIME = 1000 * 2L;
		private static final int MAX_REFRESH_COUNT = 20;

		private static final Cache cache = new Cache();

		private Cache() {
			new Thread(new ClearCacheRunnable()).start();
		}

		public static Cache getInstance() {
			return cache;
		}

		// 增长指定URL的点击次数
		public void increment(String key) {
			CopyOnWriteArrayList<Long> list = map.get(key);
			if (list == null) {
				map.put(key, new CopyOnWriteArrayList<Long>());
			}
			map.get(key).add(new Long(System.currentTimeMillis()));
		}

		// 是否到达指定数量
		public boolean isUpCount(String key) {
			CopyOnWriteArrayList<Long> list = map.get(key);
			if (list == null) {
				return false;
			}
			return list.size() > MAX_REFRESH_COUNT;
		}

		// 清理过期数据线程
		private static class ClearCacheRunnable implements Runnable {
			@Override
			public void run() {
				while (true) {
					try {
						Thread.sleep(Cache.CLEAR_TIME);
						clear();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}

			private void clear() {
				for (String key : map.keySet()) {
					CopyOnWriteArrayList<Long> list = map.get(key);
					for (Long date : list) {
						if (System.currentTimeMillis() - date > Cache.EXPIRE_TIME) {
							System.out.println(list.remove(date));
						}
					}
				}
			}
		}
	}

}
