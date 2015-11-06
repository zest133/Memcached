package com.zest.memcached.user.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.zest.memcached.user.dao.UserDao;
import com.zest.memcached.user.dto.UserDTO;

@Service(value="Cachable")
public class CachableUserServiceImpl implements UserService {
	
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
	@CacheEvict(value="cachable")
	public boolean delete( long idx) {
		userDao.delete(idx);
		return false;
	}

	@Override
	@CachePut(value="cachable", key="#userDTO.idx")
	public UserDTO edit( UserDTO userDTO) {
		return userDao.save(userDTO);
	}

	
	@Override
	@CachePut(value="cachable", key="#userDTO.idx")
	public UserDTO write( UserDTO userDTO) {
		return userDao.save(userDTO);
	}

	@Override
	@Cacheable(value="cachable", key="#idx")
	public UserDTO read( long idx) {
		UserDTO userDTO =  userDao.findOne(idx);
//		userDao.save(userDTO);
		return userDTO;
	}
}
