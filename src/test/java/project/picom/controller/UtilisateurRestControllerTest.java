package project.picom.controller;

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
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fasterxml.jackson.databind.ObjectMapper;

import project.picom.business.Client;

@SpringBootTest
@AutoConfigureMockMvc
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class UtilisateurRestControllerTest {
    
    @Autowired
	private MockMvc mockMvc;

    @Autowired
	private ObjectMapper objectMapper;

    private static String email = "client1@orsys.fr";
	private static String motDePasse = "12345678";

    Client c = new Client();
    String clientJSON = null;

    @Test
	@Order(1)
	@GetMapping("utilisateurs/{email}/{motDePasse}")
	void testUtilisateurGetByMailMdp() throws Exception {
		MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders
				.get("/api/utilisateurs/" + email + "/" + motDePasse);

		mockMvc.perform(requestBuilder).andExpect(MockMvcResultMatchers.jsonPath("$.email").value(email))
				.andExpect(MockMvcResultMatchers.jsonPath("$.motDePasse").value(motDePasse)).andExpect(status().isOk())
				.andDo(MockMvcResultHandlers.print());
	}
}




