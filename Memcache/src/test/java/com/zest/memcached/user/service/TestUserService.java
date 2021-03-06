package com.zest.memcached.user.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.zest.memcached.user.dto.UserDTO;




@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="/cache-context.xml")
public class TestUserService {

	@Autowired
	@Qualifier(value="CacheKeyMethod")
	UserService service;
	
	@Test
	public void writeTest(){
		UserDTO dto = new UserDTO(2,"gno","gno","gno","gno");
		service.write(dto);
	}
	
}
