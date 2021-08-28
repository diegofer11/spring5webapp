package guru.springframework.spring5webapp.web.model;

import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.util.List;

public class CustomerPaged extends PageImpl<CustomerDto> {
    public CustomerPaged(List<CustomerDto> content, Pageable pageable, long total) {
        super(content, pageable, total);
    }

    public CustomerPaged(List<CustomerDto> content) {
        super(content);
    }
}
