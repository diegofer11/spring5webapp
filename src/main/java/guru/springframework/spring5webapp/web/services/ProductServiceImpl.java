package guru.springframework.spring5webapp.web.services;

import guru.springframework.spring5webapp.web.model.ProductDto;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ProductServiceImpl implements ProductService {
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
    public ProductDto saveProduct(ProductDto productDto) {
        //TODO crear registro en mongo
        return ProductDto.builder()
                .id(UUID.randomUUID())
                .build();

    }

    @Override
    public void updateProduct(UUID productId, ProductDto productDto) {
        //TODO implementar update
    }
}
