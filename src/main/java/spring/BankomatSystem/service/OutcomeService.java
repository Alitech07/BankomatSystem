package spring.BankomatSystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.BankomatSystem.entity.*;
import spring.BankomatSystem.payload.ApiResponse;
import spring.BankomatSystem.payload.IncomeDto;
import spring.BankomatSystem.payload.OutcomeDto;
import spring.BankomatSystem.repository.BankomatRepository;
import spring.BankomatSystem.repository.CardRepository;
import spring.BankomatSystem.repository.IncomeRepository;
import spring.BankomatSystem.repository.OutcomeRepository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class OutcomeService {
    @Autowired
    OutcomeRepository outcomeRepository;
    @Autowired
    BankomatRepository bankomatRepository;
    @Autowired
    CardRepository cardRepository;

    public List<Outcome> getIncomesService(){
        return outcomeRepository.findAll();
    }

    public List<Outcome> getIncomeBankomatService(Integer bankomatId){
        Optional<Bankomat> optionalBankomat = bankomatRepository.findById(bankomatId);
        if (!optionalBankomat.isPresent()) return null;
        return outcomeRepository.getOutcomesByBankomat_Id(bankomatId);
    }

    public ApiResponse addIncomeService(OutcomeDto outcomeDto){
        Optional<Bankomat> optionalBankomat = bankomatRepository.findById(outcomeDto.getBankomatId());
        if (!optionalBankomat.isPresent()) return new ApiResponse("Bunday bankomat yuq.",false);

        Optional<Card> optionalCard = cardRepository.findById(outcomeDto.getCardId());
        if (!optionalCard.isPresent()) return new ApiResponse("Bunday carta mavjud emas.",false);

        Outcome outcome = new Outcome();
        outcome.setCard(optionalCard.get());
        outcome.setBankomat(optionalBankomat.get());
        outcome.setDate(new Date());

        double total = 0;
        for (MoneyBill moneyBill: outcomeDto.getMoneyBills()){
            total=moneyBill.getValue()*moneyBill.getAmount();
        }
        outcome.setTotal(total);
        outcome.setMoneyBill(outcomeDto.getMoneyBills());
        outcomeRepository.save(outcome);
        return new ApiResponse("Kirim saqlandi.",true);
    }

    public ApiResponse deleteIncomeService(Integer id){
        Optional<Outcome> optionalIncome = outcomeRepository.findById(id);
        if (!optionalIncome.isPresent()) return new ApiResponse("Bunday kirim qilinmagan.",false);
        outcomeRepository.deleteById(id);
        return new ApiResponse("Kirim o'chirildi.",true);

    }
}
