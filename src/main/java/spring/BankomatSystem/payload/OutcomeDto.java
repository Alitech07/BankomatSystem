package spring.BankomatSystem.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import spring.BankomatSystem.entity.Bankomat;
import spring.BankomatSystem.entity.Card;
import spring.BankomatSystem.entity.MoneyBill;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OutcomeDto {
    private Integer cardId;
    private List<MoneyBill> moneyBills;
    private double total;
    private Integer bankomatId;
}
