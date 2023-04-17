package spring.BankomatSystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.BankomatSystem.entity.Bank;
import spring.BankomatSystem.payload.ApiResponse;
import spring.BankomatSystem.payload.BankDTO;
import spring.BankomatSystem.repository.BankRepository;

import java.util.List;
import java.util.Optional;

@Service
public class BankService {

    @Autowired
    BankRepository bankRepository;

    /**
     * Banklar ro'yhatini olish.
     * @return
     */
    public List<Bank> getBanksService(){
        return bankRepository.findAll();
    }

    /**
     * Id bo'yicha bankni ozini olish.
     * @param id
     * @return
     */
    public Bank getBankService(Integer id){
        Optional<Bank> optionalBank = bankRepository.findById(id);
        return optionalBank.orElse(null);
    }

    /**
     * Yangi bank qo'shish.
     * @param bankDTO
     * @return
     */
    public ApiResponse addBankService(BankDTO bankDTO){
        boolean existsed = bankRepository.existsBankByName(bankDTO.getName());
        if (existsed) return new ApiResponse("Bynday nomli bank mavjud.",false);
        Bank bank = new Bank();
        bank.setName(bank.getName());
        bank.setAddress(bankDTO.getAddress());
        bankRepository.save(bank);
        return new ApiResponse("Bank saqlandi.",true);
    }

    /**
     * Bank malumotlarini yangilash.
     * @param id
     * @param bankDTO
     * @return
     */
    public ApiResponse editBankService(Integer id,BankDTO bankDTO){
        Optional<Bank> optionalBank = bankRepository.findById(id);
        if (!optionalBank.isPresent()) return new ApiResponse("Bunday bank mavjud emas.",false);
        Bank bank = new Bank();
        bank.setName(bankDTO.getName());
        bank.setAddress(bankDTO.getAddress());
        bankRepository.save(bank);
        return new ApiResponse("Bank ma'lumotlari yangilandi.",true);
    }

    /**
     * Bankni id bo'yicha o'chirish.
     * @param id
     * @return
     */
    public ApiResponse deleteBankService(Integer id){
        Optional<Bank> optionalBank = bankRepository.findById(id);
        if (!optionalBank.isPresent()) return new ApiResponse("Bunday bank mavjud emas.",false);
        bankRepository.deleteById(id);
        return new ApiResponse("Bank o'chirildi.",true);
    }
}
