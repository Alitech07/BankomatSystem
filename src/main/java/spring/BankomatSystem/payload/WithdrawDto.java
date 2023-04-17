package spring.BankomatSystem.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WithdrawDto {
    private String cardNumber;
    private String code;
    private double amount;
}
