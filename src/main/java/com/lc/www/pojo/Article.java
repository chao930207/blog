package com.lc.www.pojo;

import java.util.Date;

public class Article {

	private long id;
	
	private String title;
	
	private String type;
	
	private String html;
	
	private int version;
	
	private Date lastModifyTime;
	
	private Date createTime;
	
	private char isdelete;

	public Article(){
	}
	
	public Article(long id, String title, String type, String html, int version, Date lastModifyTime, Date createTime, char isdelete) {
		super();
		this.id = id;
		this.title = title;
		this.type = type;
		this.html = html;
		this.version = version;
		this.lastModifyTime = lastModifyTime;
		this.createTime = createTime;
		this.isdelete = isdelete;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getHtml() {
		return html;
	}

	public void setHtml(String html) {
		this.html = html;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public Date getLastModifyTime() {
		return lastModifyTime;
	}

	public void setLastModifyTime(Date lastModifyTime) {
		this.lastModifyTime = lastModifyTime;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	
	public char getIsdelete() {
		return isdelete;
	}
	
	public void setIsdelete(char isdelete) {
		this.isdelete = isdelete;
	}

	@Override
	public String toString() {
		return "Article [id=" + id + ", title=" + title + ", type=" + type + ", html=" + html + ", version=" + version
				+ ", lastModifyTime=" + lastModifyTime + ", createTime=" + createTime + ", isdelete=" + isdelete + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((createTime == null) ? 0 : createTime.hashCode());
		result = prime * result + ((html == null) ? 0 : html.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((lastModifyTime == null) ? 0 : lastModifyTime.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		result = prime * result + version;
		result = prime * result + isdelete;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Article other = (Article) obj;
		if (createTime == null) {
			if (other.createTime != null)
				return false;
		} else if (!createTime.equals(other.createTime))
			return false;
		if (html == null) {
			if (other.html != null)
				return false;
		} else if (!html.equals(other.html))
			return false;
		if (id != other.id)
			return false;
		if (lastModifyTime == null) {
			if (other.lastModifyTime != null)
				return false;
		} else if (!lastModifyTime.equals(other.lastModifyTime))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		if (version != other.version)
			return false;
		if (isdelete != other.isdelete)
			return false;
		return true;
	}
	
}
