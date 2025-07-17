package co.istad.mobilebanking.domain;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;
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

    @Column(nullable = false)
    private LocalDate dob;

    private BigDecimal monthlyIncomeRange;

    @Column(length = 50)
    private String cityOrProvince;

    @Column(length = 50)
    private String companyName;

    @Column(length = 50)
    private String country;

    @Column(length = 50)
    private String employmentType;

    @Column(length = 50)
    private String mainSourceIncome;

    @Column(length = 50)
    private String position;

    @Column(length = 50)
    private String zipCode;

    @Column(length = 100)
    private String address;

    @Column(columnDefinition = "TEXT")
    private String remarks;

    @Column(nullable = false)
    private Boolean isDeleted;

    @OneToMany(mappedBy = "customer")
    private List<Account> accounts;

    @OneToOne(mappedBy = "customer",cascade = CascadeType.PERSIST)
    @PrimaryKeyJoinColumn
    private KYC kyc;

    @ManyToOne(optional = false)
    private CustomerSegment customerSegment;
}
