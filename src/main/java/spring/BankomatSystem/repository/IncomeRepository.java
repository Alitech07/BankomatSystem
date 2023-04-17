package spring.BankomatSystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import spring.BankomatSystem.entity.Income;

import java.util.List;

public interface IncomeRepository extends JpaRepository<Income,Integer> {
    List<Income> getIncomesByBankomat_Id(Integer bankomat_id);
}
