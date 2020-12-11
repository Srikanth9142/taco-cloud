package com.srikanth.tacos;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.srikanth.tacos.controller.HomeController;

@RunWith(SpringRunner.class)
@WebMvcTest(HomeController.class)
class HomeControllerTest {
	
	@Autowired
	private MockMvc mockMvc;	
	
	@Test
	public void testHomePage() throws Exception{
		mockMvc.perform(get("/")).andExpect(status().isOk()).andExpect(view().name("home"));
	}

}
