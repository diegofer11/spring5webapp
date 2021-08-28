package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.entities.Product;
import guru.springframework.spring5webapp.repositories.ProductRepository;
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
            productRepository.save(Product.builder()
                    .name("producto test 1")
                    .sku("1234")
                    .upc(5342L)
                    .build());
        }
    }
}
