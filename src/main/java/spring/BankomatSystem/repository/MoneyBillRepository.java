package spring.BankomatSystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import spring.BankomatSystem.entity.MoneyBill;

@RepositoryRestResource(path = "moneybill")
public interface MoneyBillRepository extends JpaRepository<MoneyBill,Integer> {
}
