package spring.BankomatSystem.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import spring.BankomatSystem.entity.Address;
import spring.BankomatSystem.entity.Bank;

import javax.persistence.ManyToOne;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BankomatDto {

    private Integer bankId;

    private Double money;

    private double commision_amount;

    private Address address;

}
