package guru.springframework.spring5webapp.repositories;

import guru.springframework.spring5webapp.entities.Product;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.UUID;

public interface ProductRepository extends PagingAndSortingRepository<Product, UUID> {

}
