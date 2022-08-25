package controller;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

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

    private static Client c = new Client();

}


