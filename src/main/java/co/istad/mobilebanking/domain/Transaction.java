package co.istad.mobilebanking.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "transactions")
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(nullable = false)
    private BigDecimal amount;

    @Column(columnDefinition = "TEXT")
    private String remark;

    @ManyToOne
    private TransactionType transactionType;

    @ManyToOne
    private Account sender;

    @ManyToOne
    private Account receiver;
}
