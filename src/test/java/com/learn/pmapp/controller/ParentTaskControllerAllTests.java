package com.learn.pmapp.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.learn.pmapp.model.ParentTask;

public class ParentTaskControllerAllTests extends ProjectControllerAllTest {
	
	@Override
	   @Before
	   public void setUp() {
	      super.setUp();
	   }
	
	   @Test
	   public void getAllParentTasks() throws Exception {
	      String uri = "/task/getAllParentTasks";
	      MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
	         .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();
	      
	      int status = mvcResult.getResponse().getStatus();
	      assertEquals(200, status);
	      String content = mvcResult.getResponse().getContentAsString();
	      ParentTask[] parentTask = super.mapFromJson(content, ParentTask[].class);
	      assertTrue(parentTask.length > 0);
	   }

}
