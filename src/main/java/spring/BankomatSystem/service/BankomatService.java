package spring.BankomatSystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.BankomatSystem.entity.Bank;
import spring.BankomatSystem.entity.Bankomat;
import spring.BankomatSystem.payload.ApiResponse;
import spring.BankomatSystem.payload.BankomatDto;
import spring.BankomatSystem.repository.BankRepository;
import spring.BankomatSystem.repository.BankomatRepository;

import java.util.List;
import java.util.Optional;

@Service
public class BankomatService {
    @Autowired
    BankomatRepository bankomatRepository;
    @Autowired
    BankRepository bankRepository;

    public List<Bankomat> getBankomatsService(){
        return bankomatRepository.findAll();
    }
    public Bankomat getBankomatService(Integer id){
        Optional<Bankomat> optionalBankomat = bankomatRepository.findById(id);
        return optionalBankomat.orElse(null);
    }
    public ApiResponse addBankomatService(BankomatDto bankomatDto){

        Optional<Bank> optionalBank = bankRepository.findById(bankomatDto.getBankId());
        if (!optionalBank.isPresent()) return new ApiResponse("Bunday bank mavjud emas.",false);
        Bankomat bankomat = new Bankomat();
        bankomat.setBank(optionalBank.get());
        bankomat.setMoney(bankomatDto.getMoney());
        bankomat.setCommision_amount(bankomatDto.getCommision_amount());
        bankomat.setAddress(bankomatDto.getAddress());

        bankomatRepository.save(bankomat);

        return new ApiResponse("Bankomat saqlandi.",true);
    }

    public ApiResponse editBankomatService(Integer id,BankomatDto bankomatDto){

        Optional<Bankomat> optionalBankomat = bankomatRepository.findById(id);
        if (!optionalBankomat.isPresent()) return new ApiResponse("Bunday bankomat yoq.",false);

        Optional<Bank> optionalBank = bankRepository.findById(bankomatDto.getBankId());
        if (!optionalBank.isPresent()) return new ApiResponse("Bunday bank mavjud emas.",false);
        Bankomat bankomat = optionalBankomat.get();
        bankomat.setBank(optionalBank.get());
        bankomat.setMoney(bankomatDto.getMoney());
        bankomat.setCommision_amount(bankomatDto.getCommision_amount());
        bankomat.setAddress(bankomatDto.getAddress());

        bankomatRepository.save(bankomat);

        return new ApiResponse("Bankomat malumotlari yangilandi.",true);
    }

    public ApiResponse deleteBankomatService(Integer id){
        Optional<Bankomat> optionalBankomat = bankomatRepository.findById(id);
        if (!optionalBankomat.isPresent()) return new ApiResponse("Bunday bankomat mavjud emas.",false);
        bankomatRepository.deleteById(id);
        return new ApiResponse("Bankomat o'chirildi.",true);
    }
}
