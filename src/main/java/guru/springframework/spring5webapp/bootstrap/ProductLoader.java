package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.repositories.ProductRepository;
import guru.springframework.spring5webapp.web.model.ProductDto;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class ProductLoader implements CommandLineRunner {
    private final ProductRepository productRepository;

    public ProductLoader(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        loadProductObject();
    }

    private void loadProductObject() {
        if (productRepository.count() == 0) {
            productRepository.save(ProductDto.builder()
                    .productName("Test product 1")
                    .sku("234")
                    .build()
            );
        }
    }
}
