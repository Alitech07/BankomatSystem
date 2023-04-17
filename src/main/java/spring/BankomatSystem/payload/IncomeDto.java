package spring.BankomatSystem.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import spring.BankomatSystem.entity.Bankomat;
import spring.BankomatSystem.entity.MoneyBill;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class IncomeDto {
    private double total;

    private Date date;

    private Integer bankomatId;

    private List<MoneyBill> moneyBills;
}
