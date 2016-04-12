package com.github.vinunair.userdata.repository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.github.vinunair.userdata.configuration.UserRepositoryConfiguration;
import com.github.vinunair.userdata.domain.User;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = {UserRepositoryConfiguration.class})
public class UserRepositoryTest {

	private UserRespository userRespository;
	
	@Autowired
	public void setUserRepository(UserRespository userRepository) {
		this.userRespository = userRepository;
	}
	
	
	@Test
	public void testListUser() {
		User user = new User();
		user.setFirstname("Clark");
		user.setLastname("Kent");
		
		userRespository.save(user);
		
		user = new User();
		user.setFirstname("Bruce");
		user.setLastname("Wayne");
		
		userRespository.save(user);
		
		assertEquals(userRespository.count(),2);
		
		List<User>fetchedUser  = userRespository.findByFirstnameContaining("Clark");
		assertEquals(fetchedUser.size(),1);
		assertEquals(fetchedUser.get(0).getFirstname(),"Clark");
		
		fetchedUser = userRespository.findByLastnameContaining("Wayne");
		assertEquals(fetchedUser.size(),1);
		assertEquals(fetchedUser.get(0).getLastname(),"Wayne");
		
		fetchedUser= userRespository.findByFirstnameAndLastnameContaining("Bruce", "Wayne");
		assertEquals(fetchedUser.size(),1);
		assertEquals(fetchedUser.get(0).getFirstname(),"Bruce");
		assertEquals(fetchedUser.get(0).getLastname(),"Wayne");
		
	}
}
