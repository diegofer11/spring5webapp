package guru.springframework.spring5webapp.web.controller;

import guru.springframework.spring5webapp.web.model.ProductDto;
import guru.springframework.spring5webapp.web.services.ProductService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<ProductDto> postProduct(@RequestBody ProductDto productDto) {
        ProductDto savedProduct = productService.saveProduct(productDto);
        HttpHeaders headers = new HttpHeaders();
        //TODO se debe buscar la mejor forma de obtener el hostname
        headers.add("Location", "http://localhost:8080/api/v1/product/" + savedProduct.getId().toString());

        return new ResponseEntity<>(headers, HttpStatus.CREATED);
    }

    @PutMapping("/{productId}")
    public ResponseEntity<ProductDto> putProduct(@PathVariable UUID productId, @RequestBody ProductDto productDto) {

        productService.updateProduct(productId, productDto);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
