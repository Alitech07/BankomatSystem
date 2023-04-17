package spring.BankomatSystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import spring.BankomatSystem.entity.Bank;

public interface BankRepository extends JpaRepository<Bank,Integer> {
    boolean existsBankByName(String name);
}
