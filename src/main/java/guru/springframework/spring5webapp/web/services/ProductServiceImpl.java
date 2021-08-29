package guru.springframework.spring5webapp.web.services;

import guru.springframework.spring5webapp.entities.Product;
import guru.springframework.spring5webapp.repositories.ProductRepository;
import guru.springframework.spring5webapp.web.model.ProductDto;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public ProductDto getProductById(UUID productId) {
        //TODO buscar registro no quemado
        return ProductDto.builder()
                .id(UUID.randomUUID())
                .productName("producto de prueba")
                .sku("345234")
                .upc(158000L)
                .build();
    }

    @Override
    public Product saveProduct(Product product) {
        //TODO crear registro en mongo
        return productRepository.save(product);
    }

    @Override
    public void updateProduct(UUID productId, ProductDto productDto) {
        //TODO implementar update
    }
}
