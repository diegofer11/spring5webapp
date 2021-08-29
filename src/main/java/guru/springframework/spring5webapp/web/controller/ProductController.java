package guru.springframework.spring5webapp.web.controller;

import guru.springframework.spring5webapp.entities.Product;
import guru.springframework.spring5webapp.web.model.ProductDto;
import guru.springframework.spring5webapp.web.services.ProductService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.UUID;

@RequestMapping("/api/v1/product")
@RestController
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/{productId}")
    public ResponseEntity<ProductDto> getProduct(@PathVariable UUID productId) {
        return new ResponseEntity<>(productService.getProductById(productId), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ProductDto> postProduct(@Valid @RequestBody Product product) {
        Product savedProduct = productService.saveProduct(product);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Location", "http://localhost:8080/api/v1/product/" + savedProduct.getId().toString());

        return new ResponseEntity<>(headers, HttpStatus.CREATED);
    }

    @PutMapping("/{productId}")
    public ResponseEntity<ProductDto> putProduct(@PathVariable UUID productId, @Valid @RequestBody ProductDto productDto) {

        productService.updateProduct(productId, productDto);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
