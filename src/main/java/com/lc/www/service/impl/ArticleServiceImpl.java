package com.lc.www.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lc.www.dao.User.UserDao;
import com.lc.www.dao.cacheDao.RedisDao;
import com.lc.www.pojo.Article;
import com.lc.www.service.ArticleService;

@Service
public class ArticleServiceImpl implements ArticleService {

	@Autowired
	UserDao userDao;
	
	@Autowired
	RedisDao redisDao;
	
	public List<String> getArticleHtmlList() {
		return null;
	}

	public Map<String, String> insertArticle(Article article) {
		return null;
	}

	public Map<String, String> deleteLogicArticle(long id) {
		return null;
	}

}
