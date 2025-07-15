package co.istad.mobilebanking.domain;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Builder
@AllArgsConstructor
@Entity
@Table(name = "customer_segments")
public class CustomerSegment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String segment;
    private String description;

    @Column(nullable = false)
    private Boolean isDeleted;

    @OneToMany(mappedBy = "customerSegment")
    private List<Customer> customers;
}
