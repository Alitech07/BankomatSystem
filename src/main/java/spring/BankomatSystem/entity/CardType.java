package spring.BankomatSystem.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import spring.BankomatSystem.entity.enums.CardTypeName;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlSeeAlso;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class CardType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Enumerated(value = EnumType.STRING)
    private CardTypeName cardTypeName;

    @OneToOne(mappedBy = "cardType")
    private Card card;
}
