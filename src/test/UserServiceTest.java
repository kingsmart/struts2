package test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.jxc.struts2.services.UserService;

public class UserServiceTest {
	ApplicationContext context = null;   
    UserService userService = null;   
  
    @Before  
    public void init() throws Exception {   
    	context = new ClassPathXmlApplicationContext(new String[] {"applicationContext.xml"});   
    	userService = (UserService)context.getBean("userService");   
    }   
  
    @Test  
    public void findByCondition() {   
        assertEquals(userService.loadUserByUsername("admin").getAuthorities().size(),2);   
    }   

}
