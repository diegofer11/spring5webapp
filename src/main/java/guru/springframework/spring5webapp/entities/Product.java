package guru.springframework.spring5webapp.entities;

import lombok.*;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    @Id
    @GeneratedValue(generator = "UUID")
    @Type(type = "uuid-char")
    @Column(columnDefinition = "BINARY(16)")
    private UUID id;
    private String name;
    private String sku;
    private Long upc;

}
