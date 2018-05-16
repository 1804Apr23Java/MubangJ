package com.Revature.dao;

import java.util.List;

import com.Revature.domain.User;

public interface CommentDao {
	void putComment(String username, String comment);
	List<User> getAllComments();
}
