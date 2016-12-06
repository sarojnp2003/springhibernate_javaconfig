package com.tshirtdesign.dao;

import java.util.List;

import com.tshirtdesign.model.User;

/**
 * @author saroj-gautam
 *
 */
public interface UserDao {

	User findById(long id);

	User findByUsername(String userName);

	void saveUser(User user);

	void updateUser(User user);

	void deleteUserById(long id);

	List<User> findAllUser();

	boolean isUserExist(User user);
}
