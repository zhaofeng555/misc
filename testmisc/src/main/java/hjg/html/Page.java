package hjg.html;

import java.util.Date;

public class Page {

	String id;
	String url;
	String host;
	String title;
	String keywords;
	String description;
	Date date;
	public Page(){}
	public Page(String id, String url, String host, String title, String keywords,
			String description, Date date) {
		this.id = id;
		this.url = url;
		this.host=host;
		this.title = title;
		this.keywords = keywords;
		this.description = description;
		this.date = date;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getKeywords() {
		return keywords;
	}
	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getHost() {
		return host;
	}
	public void setHost(String host) {
		this.host = host;
	}

	
}
