package com.learn.pmapp.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.learn.pmapp.ProjManagerApplicationTests;
import com.learn.pmapp.model.Project;

public class ProjectControllerAllTest extends ProjManagerApplicationTests {

	
	@Override
	   @Before
	   public void setUp() {
	      super.setUp();
	   }
	
	   @Test
	   public void getAllProjectsTest() throws Exception {
	      String uri = "/project/";
	      MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
	         .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();
	      
	      int status = mvcResult.getResponse().getStatus();
	      assertEquals(200, status);
	      String content = mvcResult.getResponse().getContentAsString();
	      Project[] project = super.mapFromJson(content, Project[].class);
	      assertTrue(project.length > 0);
	   }

	
}
