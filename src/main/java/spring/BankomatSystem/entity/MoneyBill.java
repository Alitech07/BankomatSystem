package spring.BankomatSystem.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class MoneyBill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private Integer value;

    @Column(nullable = false)
    private String currency;

    @Column(nullable = false)
    private double amount;

    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private Income income;
}
