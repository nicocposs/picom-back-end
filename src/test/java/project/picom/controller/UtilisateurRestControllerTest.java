package project.picom.controller;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

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
	void testUtilisateurGetByMailMdp() throws Exception {
		MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders
				.get("/api/utilisateurs/" + email + "/" + motDePasse);

		mockMvc.perform(requestBuilder).andExpect(MockMvcResultMatchers.jsonPath("$.email").value(email))
				.andExpect(MockMvcResultMatchers.jsonPath("$.motDePasse").value(motDePasse)).andExpect(status().isOk())
				.andDo(MockMvcResultHandlers.print());
	}


	@Test
	@Order(2)
	void testUtilisateurGetByMailMdpFalse() throws Exception {
		MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders
				.get("/api/utilisateurs/false/samarshpa" );

		mockMvc.perform(requestBuilder).andExpect(status().isBadRequest())
				.andDo(MockMvcResultHandlers.print());
	}

	@Test
	@Order(3)
	void testGetall() throws Exception {
		MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders
				.get("/api/utilisateurs/");

		mockMvc.perform(requestBuilder).andExpect(MockMvcResultMatchers.jsonPath("$[0].email").value(email))
				.andExpect(MockMvcResultMatchers.jsonPath("$[0].motDePasse").value(motDePasse)).andExpect(status().isOk())
				.andDo(MockMvcResultHandlers.print());
	}

	@Test
	@Order(4)
	void testPostUtilisateur() throws Exception {
		c.setPrenom("Bob");
		c.setNom("Bob");
		c.setMotDePasse("12345678");
		c.setEmail("Bobob@orsys.fr");
		c.setNumeroDeTelephone("0607070707");

		clientJSON = objectMapper.writeValueAsString(c);

		mockMvc.perform(MockMvcRequestBuilders.post("/api/utilisateurs").content(clientJSON)
		.contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON))
		.andExpect(MockMvcResultMatchers.jsonPath("$.prenom").value(c.getPrenom()))
		.andExpect(MockMvcResultMatchers.jsonPath("$.nom").value(c.getNom()))
	    .andExpect(MockMvcResultMatchers.jsonPath("$.motDePasse").value(c.getMotDePasse()))
		.andExpect(MockMvcResultMatchers.jsonPath("$.email").value(c.getEmail()))
	    .andExpect(MockMvcResultMatchers.jsonPath("$.numeroDeTelephone").value(c.getNumeroDeTelephone()))
		// on vérifie que le code retour est bien 201
		.andExpect(status().isCreated())
		// on affiche dans la console l'intégralité de la requête et de la réponse
		.andDo(MockMvcResultHandlers.print());
	}

	@Test
	@Order(5)
	void testPostUtilisateurFalse() throws Exception {
		c.setPrenom("Bob");
		c.setNom("Bob");
		c.setMotDePasse("123");
		c.setEmail("Bobob@orsys.fr");
		c.setNumeroDeTelephone("0607070707");

		clientJSON = objectMapper.writeValueAsString(c);

		mockMvc.perform(MockMvcRequestBuilders.post("/api/utilisateurs").content(clientJSON)
		.contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON))
		// on vérifie que le code retour est bien 400
		.andExpect(status().isUnprocessableEntity())
		// on affiche dans la console l'intégralité de la requête et de la réponse
		.andDo(MockMvcResultHandlers.print());
	}

	@Test
	@Order(6)
	void testPostUtilisateurConnexion() throws Exception {

		mockMvc.perform(MockMvcRequestBuilders.post("/api/utilisateurs/connexion/"+email+"/"+motDePasse)
		.contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON))
		.andExpect(MockMvcResultMatchers.jsonPath("$.email").value(email))
		.andExpect(MockMvcResultMatchers.jsonPath("$.id").value(1))
	    .andExpect(MockMvcResultMatchers.jsonPath("$.role").value("client"))
		// on vérifie que le code retour est bien 400
		.andExpect(status().isOk())
		// on affiche dans la console l'intégralité de la requête et de la réponse
		.andDo(MockMvcResultHandlers.print());
	}

	@Test
	@Order(7)
	void testPostUtilisateurConnexionFalse() throws Exception {

		mockMvc.perform(MockMvcRequestBuilders.post("/api/utilisateurs/connexion/aaa/aaaa")
		.contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON))
		// on vérifie que le code retour est bien 400
		.andExpect(status().isBadRequest())
		// on affiche dans la console l'intégralité de la requête et de la réponse
		.andDo(MockMvcResultHandlers.print());
	}

}




