package com.lc.www.dao.User;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import com.lc.www.pojo.Article;

@Repository
public interface ArticleDao {

	@Select("select html from article_html where isdelete = '1'")
	public List<Article> queryArticleList();
	
	@Insert("inesrt ignore into article_html(title, type, html) values (#{article.title}, #{article.type}, #{article.html})")
	public int insertArticle(Article article);
	
	@Update("update article_html set title = #{article.title} where id = #{article.id} and isdelete = '1'")
	public int updateArticle(Article article);
	
	@Update("update article_html set isdelete = '0' where id = #{id} and isdelete = '1'")
	public int deleteLogicArticle(long id);
}
