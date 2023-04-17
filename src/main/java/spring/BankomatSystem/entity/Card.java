package spring.BankomatSystem.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String number;

    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private Bank bank;

    @Column(nullable = false)
    private Integer CVV;

    @Column(nullable = false)
    private String fullName;

    @Column(nullable = false)
    private String password;

    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private CardType cardType;

    @Column(nullable = false)
    private String expireDate;

    @OneToMany(mappedBy = "card")
    private List<Outcome> outcome;
}
