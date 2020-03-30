package abhash.springframewrok.msscbeerinventoryservice.web.controller;

import abhash.springframewrok.msscbeerinventoryservice.bootstrap.BeerInventoryBootstrap;
import abhash.springframewrok.msscbeerinventoryservice.repository.BeerInventoryRepository;
import abhash.springframewrok.msscbeerinventoryservice.web.mappers.BeerInventoryMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import static  org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(BeerInventoryController.class)
class BeerInventoryControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    BeerInventoryMapper beerInventoryMapper;

    @MockBean
    BeerInventoryRepository beerInventoryRepository;


    @Test
    void listBeersById() throws Exception {

        mockMvc.perform(get("/api/v1/beer/"+ BeerInventoryBootstrap.BEER_2_UUID+"/inventory").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
}