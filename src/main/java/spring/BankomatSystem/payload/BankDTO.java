package spring.BankomatSystem.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import spring.BankomatSystem.entity.Address;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BankDTO {
    private String name;
    private Address address;
}
