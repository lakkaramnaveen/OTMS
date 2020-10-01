package com.cg.otms;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import com.cg.otms.dao.IUserDao;
import com.cg.otms.entity.User;
import com.cg.otms.exception.OtmsException;
import com.cg.otms.service.IUserService;

@SpringBootTest
class OnlineTestManagementApplicationTests {

	@Autowired
	private IUserService userService;

	@MockBean
	private IUserDao userDao;

	@Test
	void contextLoads() {
	}

	@Test
	void addUserTest() {

		User user = new User("nani",1000012L, true ,"1234");
		//when is used to check whether the given method is returning the expected result
		//assert checks the value
		when(userService.addUser(user)).thenReturn(user);
		assertThat(userService.addUser(user)).isEqualTo(user);

	}


	@Test
	public void getAllUsersTest() throws OtmsException {
		when(userDao.findAll()).thenReturn(Stream.of(new User(12121L,"nani", 1000012L, true ,"1234"),
				new User(121221L,"chandu", 1000013L, false ,"1234")).collect(Collectors.toList()));
		assertEquals(2, userService.getAllUsers().size());

	}

}
