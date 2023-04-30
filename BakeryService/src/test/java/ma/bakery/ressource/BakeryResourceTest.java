package ma.bakery.ressource;

import ma.bakery.services.BakeryService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
class BakeryResourceTest {


    @Autowired
    MockMvc mockMvc ;

    @Autowired
    BakeryService bakeryService ;


    @Test
    void createBakery() {
        var b = bakeryService.saveBakery() ;
        assertNotNull(b);

    }

    @Test
    void getBakery() throws Exception {
        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/v1/bakery/1");
        mockMvc
                .perform(requestBuilder)
                .andExpect(status().isNotFound());
    }

    @Test
    void deleteBakery() {
        // create a Bakery
        var b = bakeryService.saveBakery();
        // delete created bakery
        bakeryService.deleteBakery(b.getId());
        // assert no bakery found
        var numOfBakeries  = bakeryService.findAllBakeries().stream().count();
        assertEquals(0,numOfBakeries);

    }

    @Test
    void updateBakery() {
    }


    @Test
    void shouldExposeSecondVersionOfTheResource() throws Exception {
        // create a bakery :
        bakeryService.saveBakery();
        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/v2/bakery/1") ;
        MvcResult result = mockMvc
                .perform(requestBuilder)
                .andExpect(status().isAccepted())
                .andReturn();
        assertEquals(result,"V2 :)");

    }
}