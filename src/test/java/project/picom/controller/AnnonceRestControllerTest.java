package project.picom.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.web.bind.annotation.GetMapping;

@SpringBootTest
@AutoConfigureMockMvc
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class AnnonceRestControllerTest {

    @Autowired
	private MockMvc mockMvc;

    @Test
	@Order(1)
	void testGetAnnoncesById() throws Exception {
		MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders
				.get("/api/annonces/1");

		mockMvc.perform(requestBuilder).andExpect(MockMvcResultMatchers.jsonPath("$[0].titre").value("Annonce 1"))
				.andExpect(MockMvcResultMatchers.jsonPath("$[0].moisExpiration").value(1)).andExpect(status().isOk())
				.andDo(MockMvcResultHandlers.print());
	}

    @Test
	@Order(2)
	void testGetAnnoncesByIdFalse() throws Exception {
		MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders
				.get("/api/annonces/2");

		mockMvc.perform(requestBuilder)
				.andExpect(status().isNoContent())
				.andDo(MockMvcResultHandlers.print());
	}

	@Test
	@Order(3)
	void testGetAnnoncesByAnnonceId() throws Exception {
		MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders
				.get("/api/annonces/annonce/1");

		mockMvc.perform(requestBuilder)
				.andExpect(status().isOk())
				.andExpect(MockMvcResultMatchers.jsonPath("$.titre").value("Annonce 1"))
				.andExpect(MockMvcResultMatchers.jsonPath("$.moisExpiration").value(1))
				.andDo(MockMvcResultHandlers.print());
	}

	@Test
	@Order(4)
	void testGetAnnoncesByAnnonceIdFalse() throws Exception {
		MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders
				.get("/api/annonces/annonce/0");

		mockMvc.perform(requestBuilder)
				.andExpect(status().isBadRequest())
				.andDo(MockMvcResultHandlers.print());
	}
    
    
}
