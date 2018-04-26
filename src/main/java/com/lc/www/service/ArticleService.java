package com.lc.www.service;

import java.util.List;
import java.util.Map;

import com.lc.www.pojo.Article;

public interface ArticleService {

	public List<String> getArticleHtmlList();
	
	public Map<String, String> insertArticle(Article article);
	
	public Map<String, String> deleteLogicArticle(long id);
}
