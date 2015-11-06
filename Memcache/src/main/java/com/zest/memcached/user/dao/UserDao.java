package com.zest.memcached.user.dao;


import org.springframework.data.repository.CrudRepository;

import com.zest.memcached.user.dto.UserDTO;


//table과 1:1 맵핑이 된다. 
//<T, Serializable>
//T = table, 
//Serializable = pk와 맵핍되는 넘과 맵핑을 해준다. 
//<BoardVO, Integer>
public interface UserDao extends CrudRepository<UserDTO, Long> {
	
}