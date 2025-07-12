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
@Table(name = "customers")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false,length = 150)
    private String fullName;

    @Column(nullable = false,length = 10)
    private String gender;

    @Column(unique = true,length = 100)
    private String email;

    @Column(unique = true,length = 15)
    private String phoneNumber;

    @Column(columnDefinition = "TEXT")
    private String remarks;

    @Column(nullable = false)
    private Boolean isDeleted;

    @OneToMany(mappedBy = "customer")
    private List<Account> accounts;

    @OneToOne(mappedBy = "customer")
    private KYC kyc;
}
