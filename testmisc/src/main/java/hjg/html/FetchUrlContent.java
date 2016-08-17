package hjg.html;

import hjg.enctrypt.MD5;

import java.util.Date;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.alibaba.fastjson.JSONObject;


public class FetchUrlContent {
	public static void main(String[] args) throws Exception {
//		String url = "http://www.baidu.com/";
		String url = "http://www.sina.com.cn/";
		Document doc = Jsoup.connect(url).timeout(1000).get();

		String urlMd5 = MD5.getMD5(url);
		String host = getHostFromUrl(url);
		String title =doc.title();
		
		Page p = new Page();
		p.setUrl(url);
		p.setId(urlMd5);
		p.setHost(host);
		p.setTitle(title);
		p.setDate(new Date());
		Elements meta = doc.select("meta");
		Iterator<Element> itMeta = meta.iterator();
		while (itMeta.hasNext()) {
			Element e = itMeta.next();
			String eleName = e.attr("name");
			if(StringUtils.equals("keywords", eleName)){
				String keywords = e.attr("content");
				p.setKeywords(keywords);
			}
			if(StringUtils.equals("description", eleName)){
				String description = e.attr("content");
				p.setDescription(description);
			}
		}
		System.out.println(JSONObject.toJSONString(p));
	}
	
	private static String getHostFromUrl(String url) {
		Pattern p = Pattern.compile("(?<=http://|\\.)[^.]*?\\.(com|cn|net|org|biz|info|cc|tv)", Pattern.CASE_INSENSITIVE);
		Matcher matcher = p.matcher(url);
		if(matcher.find()){
			return matcher.group();
		}
		return "";
	}
	
}