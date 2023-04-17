package spring.BankomatSystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import spring.BankomatSystem.entity.Bankomat;
import spring.BankomatSystem.entity.Income;

import java.util.List;

public interface BankomatRepository extends JpaRepository<Bankomat,Integer> {
}
