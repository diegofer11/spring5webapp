package guru.springframework.spring5webapp.web.services;

import guru.springframework.spring5webapp.entities.Product;
import guru.springframework.spring5webapp.web.model.ProductDto;

import java.util.UUID;

public interface ProductService {

    ProductDto getProductById(UUID productId);

    Product saveProduct(Product product);

    void updateProduct(UUID productId, ProductDto productDto);
}
