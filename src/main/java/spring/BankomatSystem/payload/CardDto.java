package spring.BankomatSystem.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import spring.BankomatSystem.entity.Bank;
import spring.BankomatSystem.entity.CardType;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CardDto {
    @NotNull
    @Size(min=16)
    private String number;

    @NotNull
    private BankDTO bank;

    private Integer CVV;

    @NotNull
    @Size(min = 6)
    private String fullName;

    @NotNull
    @Size(min = 8)
    private String password;

    @NotNull
    private CardType cardType;

    @NotNull
    @Size(min = 4)
    private String expireDate;
}
