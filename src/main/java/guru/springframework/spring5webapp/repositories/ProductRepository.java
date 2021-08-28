package guru.springframework.spring5webapp.repositories;

import guru.springframework.spring5webapp.web.model.ProductDto;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.UUID;

public interface ProductRepository extends PagingAndSortingRepository<ProductDto, UUID> {

}
