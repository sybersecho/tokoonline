package com.kupalatu.toko.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.forwardedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.kupalatu.toko.config.MvcConfig;
import com.kupalatu.toko.config.WebAppInitalizer;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { WebAppInitalizer.class, MvcConfig.class })
@WebAppConfiguration
public class RoleControllerTest {
	private static Logger logger = LoggerFactory
			.getLogger(RoleControllerTest.class);
	private MockMvc mockMvc;

	@Autowired
	private WebApplicationContext webApplicationContext;

	@Before
	public void setup() {
		logger.info("settup");

		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext)
				.build();
	}

	@Test
	public void showRole() throws Exception {
		mockMvc.perform(get("/roles")).andExpect(status().isOk())
				.andExpect(view().name("role/roles"))
				.andExpect(forwardedUrl("/WEB-INF/pages/role/roles.jsp"));
	}

	@Test
	public void showRoleFormGet() throws Exception {
		mockMvc.perform(get("/roleform")).andExpect(status().isOk())
				.andExpect(view().name("role/roleform"))
				.andExpect(forwardedUrl("/WEB-INF/pages/role/roleform.jsp"));
	}

	@Test
	public void showRoleFormPost() throws Exception {
		mockMvc.perform(post("/roleform")).andExpect(status().isOk())
				.andExpect(view().name("role/roles"))
				.andExpect(forwardedUrl("/WEB-INF/pages/role/roles.jsp"));
	}
}
