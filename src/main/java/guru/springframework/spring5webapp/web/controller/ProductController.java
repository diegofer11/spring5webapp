package guru.springframework.spring5webapp.web.controller;

import guru.springframework.spring5webapp.web.model.ProductDto;
import guru.springframework.spring5webapp.web.services.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RequestMapping("/api/v1/product")
@RestController
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping({"/productId"})
    public ResponseEntity<ProductDto> getProduct(UUID productId) {
        return new ResponseEntity<>(productService.getProductById(productId), HttpStatus.OK);
    }
}
