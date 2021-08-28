package guru.springframework.spring5webapp.web.services;

import guru.springframework.spring5webapp.web.model.ProductDto;

import java.util.UUID;

public interface ProductService {

    ProductDto getProductById(UUID productId);

    ProductDto saveProduct(ProductDto productDto);

    void updateProduct(UUID productId, ProductDto productDto);
}
