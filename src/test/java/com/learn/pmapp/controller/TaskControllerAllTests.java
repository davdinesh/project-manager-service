package com.learn.pmapp.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.learn.pmapp.ProjManageApplication;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=ProjManageApplication.class)
@SpringBootTest
public class TaskControllerAllTests  {
	


	public MockMvc mockMvc;
	
	@Autowired
	public WebApplicationContext webApplicationContext;
	
	@Before
	public void setup() {
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}
	
	
	@Test
	public void testFindAllUser() throws Exception {
		mockMvc.perform(get("/task/getAllTasks")).andExpect(status().isOk());
	}
}
