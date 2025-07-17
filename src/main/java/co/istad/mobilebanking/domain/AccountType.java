package co.istad.mobilebanking.domain;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "account_types")
public class AccountType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true, length = 100)
    private String type;

    @Column(nullable = false)
    private Boolean isDeleted;

    @OneToMany(mappedBy = "accountType")
    private List<Account> accounts;
}
