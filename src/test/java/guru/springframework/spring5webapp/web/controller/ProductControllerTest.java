package guru.springframework.spring5webapp.web.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import guru.springframework.spring5webapp.web.model.ProductDto;
import guru.springframework.spring5webapp.web.services.ProductService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.UUID;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;

@RunWith(SpringRunner.class)
@WebMvcTest(ProductController.class)
@AutoConfigureRestDocs(uriScheme = "https", uriHost = "dev.dramirez.com", uriPort = 80)
public class ProductControllerTest {
    @MockBean
    ProductService productService;

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    ProductDto product;

    @Before
    public void setup() {
        product = ProductDto.builder().id(UUID.randomUUID())
                .productName("productoPrueba")
                .sku("1234")
                .build();
    }

    @Test
    public void getProduct() throws Exception {
        given(productService.getProductById(any(UUID.class))).willReturn(product);

        mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/v1/product/" + product.getId().toString()).accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(product.getId().toString()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.productName").value("productoPrueba"));
    }
}
