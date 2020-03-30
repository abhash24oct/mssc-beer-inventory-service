package abhash.springframewrok.msscbeerinventoryservice.web.controller;

import abhash.springframewrok.msscbeerinventoryservice.bootstrap.BeerInventoryBootstrap;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import static  org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(BeerInventoryController.class)
class BeerInventoryControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;



    @Test
    void listBeersById() throws Exception {

        mockMvc.perform(get("/api/v1/beer/"+ BeerInventoryBootstrap.BEER_1_UPC+"/inventory").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
}