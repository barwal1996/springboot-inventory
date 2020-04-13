package com.niit.inventory;



import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.ui.Model;

import com.niit.inventory.controller.LoginController;
import com.niit.inventory.model.Address;
import com.niit.inventory.model.Dealer;
import com.niit.inventory.service.LoginService;

//in pom.xml included spring-boot-starter test
@RunWith(SpringRunner.class)
@SpringBootTest(classes= {LoginController.class})
public class LoginControllerTest {
	
	@InjectMocks
	LoginController loginController;

	@Mock
	 private LoginService lservice;
	
	@Spy
	Model model;
	
	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);		
	}
	
	@Test
	public void viewRegisterPageTest() {
		Assert.assertEquals(loginController.viewRegisterPage(model),"register");
	}
	
	@Test
	public void createDealerTest() {
		Dealer d = new Dealer();
		d.setId(1L);		
		d.setFname("Amit");
		d.setEmail("xyz@gmail.com");
		d.setLname("Barwal");
		d.setPassword("root");
		d.setDob(java.sql.Date.valueOf("1996-09-20"));
		d.setPhoneNo("9650563702");
		
		Address a = new Address();
		a.setStreet("Dakshinpuri");
		a.setCity("New Delhi");
		a.setPincode(110062);
		
		
		d.setAddress(a);
		a.setDealer(d);
		
		lservice.saveDealer(d);
		verify(lservice,times(1)).saveDealer(d);
	}
	
	@Test
	public void showLoginFormTest() {
		Assert.assertEquals(loginController.showLoginForm(model),"login");
		
	}
	@Test
	 public void loginDealerTest()
	 {
	 String email="tamit700@gmail.com";
	 Dealer d=new Dealer();
	 d.setEmail("tamit700@gmail.com");
	 d.setPassword("root");
	when(lservice.findByEmail(email)).thenReturn(d);
	 
	Dealer x=   lservice.findByEmail("tamit700@gmail.com");

	assertEquals(x.getEmail(),"tamit700@gmail.com" );
	assertEquals(x.getPassword(),"cm9vdA==");

	//assertEquals(loginController.loginDealer(req,d,model1),"products");
	 verify(lservice,times(1)).findByEmail("tamit700@gmail.com");
	 }
	
	@Spy
	 HttpServletRequest req;
	 
	 @Spy
	  HttpSession ses;
	 
	 @Test
	 public void logoutTest()
	 {    when(req.getSession()).thenReturn(ses);
	  Assert.assertEquals(loginController.logout(req),"index");
	 }


}
