package spring.BankomatSystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.BankomatSystem.entity.Bankomat;
import spring.BankomatSystem.entity.Income;
import spring.BankomatSystem.entity.MoneyBill;
import spring.BankomatSystem.payload.ApiResponse;
import spring.BankomatSystem.payload.IncomeDto;
import spring.BankomatSystem.repository.BankomatRepository;
import spring.BankomatSystem.repository.IncomeRepository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class IncomeService {
    @Autowired
    IncomeRepository incomeRepository;
    @Autowired
    BankomatRepository bankomatRepository;

    public List<Income> getIncomesService(){
        return incomeRepository.findAll();
    }

    public List<Income> getIncomeBankomatService(Integer bankomatId){
        Optional<Bankomat> optionalBankomat = bankomatRepository.findById(bankomatId);
        if (!optionalBankomat.isPresent()) return null;
        return incomeRepository.getIncomesByBankomat_Id(bankomatId);
    }

    public ApiResponse addIncomeService(IncomeDto incomeDto){
        Optional<Bankomat> optionalBankomat = bankomatRepository.findById(incomeDto.getBankomatId());
        if (!optionalBankomat.isPresent()) return new ApiResponse("Bunday bankomat yuq.",false);
        Income income = new Income();
        income.setBankomat(optionalBankomat.get());
        income.setDate(new Date());

        double total = 0;
        for (MoneyBill moneyBill: incomeDto.getMoneyBills()){
            total=moneyBill.getValue()*moneyBill.getAmount();
        }
        income.setTotal(total);
        income.setMoneyBill(incomeDto.getMoneyBills());
        incomeRepository.save(income);
        return new ApiResponse("Kirim saqlandi.",true);
    }

    public ApiResponse deleteIncomeService(Integer id){
        Optional<Income> optionalIncome = incomeRepository.findById(id);
        if (!optionalIncome.isPresent()) return new ApiResponse("Bunday kirim qilinmagan.",false);
        incomeRepository.deleteById(id);
        return new ApiResponse("Kirim o'chirildi.",true);

    }
}
