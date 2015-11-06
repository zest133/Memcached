package com.zest.memcached.user.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.code.ssm.api.InvalidateSingleCache;
import com.google.code.ssm.api.ParameterDataUpdateContent;
import com.google.code.ssm.api.ParameterValueKeyProvider;
import com.google.code.ssm.api.ReadThroughSingleCache;
import com.google.code.ssm.api.UpdateSingleCache;
import com.zest.memcached.user.dao.UserDao;
import com.zest.memcached.user.dto.UserDTO;


public class CopyOfUserServiceImpl implements UserService {
	
	@Resource
	private UserDao userDao;

//	public BoardDao getBoardDao() {
//		return userDao;
//	}

//	public void setBoardDao(BoardDao boardDao) {
//		this.userDao = boardDao;
//	}

	
	@Override
	public Iterable<UserDTO> list() {
		return userDao.findAll();
	}

	@Override
	@InvalidateSingleCache(namespace="CacheKeyMethod")
	public boolean delete(@ParameterValueKeyProvider long idx) {
		userDao.delete(idx);
		return false;
	}

	@Override
	@UpdateSingleCache(namespace="CacheKeyMethod", expiration=3600)
	public UserDTO edit(@ParameterValueKeyProvider @ParameterDataUpdateContent UserDTO userDTO) {
		return userDao.save(userDTO);
	}

	
	@Override
	@UpdateSingleCache(namespace="CacheKeyMethod", expiration=3600)
	public UserDTO write(@ParameterValueKeyProvider @ParameterDataUpdateContent UserDTO userDTO) {
		return userDao.save(userDTO);
	}

	@Override
	@ReadThroughSingleCache(namespace="CacheKeyMethod", expiration=3600)
	public UserDTO read(@ParameterValueKeyProvider long idx) {
		UserDTO userDTO =  userDao.findOne(idx);
//		userDao.save(userDTO);
		return userDTO;
	}
}
