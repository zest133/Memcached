package com.zest.memcached.user.service;


import com.zest.memcached.user.dto.UserDTO;

public interface UserService {
	public abstract Iterable<UserDTO> list();

	public abstract boolean delete(long idx);
	
	public abstract UserDTO edit(UserDTO userDTO);

	public abstract UserDTO write(UserDTO userDTO);

	public abstract UserDTO read(long idx);
}