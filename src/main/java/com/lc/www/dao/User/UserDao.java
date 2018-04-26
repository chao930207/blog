package com.lc.www.dao.User;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import com.lc.www.pojo.User;

@Repository
public interface UserDao {

	@Select("select * from art_user au where au.name = #{userName}")
	public User checkUserExistsByName(String userName);
	
	@Select("select * from art_user au where au.name = #{name} and au.password = #{password}")
	public User validateUserData(User user);
	
	@Select("select * from art_user au where au.name = #{userName}")
	public User queryUserData(String userName);
	
	@Insert("insert into art_user set name = #{name}, password = #{password}")
	public int insertUserOneData(User user);
}
