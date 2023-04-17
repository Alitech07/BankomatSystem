package spring.BankomatSystem.controller;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import spring.BankomatSystem.entity.Bank;
import spring.BankomatSystem.payload.ApiResponse;
import spring.BankomatSystem.payload.BankDTO;
import spring.BankomatSystem.service.BankService;

import java.util.List;

@RestController
@RequestMapping("/api/bank")
public class BankController {
    @Autowired
    BankService bankService;

    @GetMapping
    public HttpEntity<?> getBanks(){
        List<Bank> banksService = bankService.getBanksService();
        return ResponseEntity.ok(banksService);
    }

    @PostMapping("/add")
    public HttpEntity<?> addBank(@RequestBody BankDTO bankDTO){
        ApiResponse apiResponse = bankService.addBankService(bankDTO);
        return ResponseEntity.status(apiResponse.isSuccess()?200:409).body(apiResponse);
    }

    @PutMapping("/edite/{id}")
    public HttpEntity<?> editBank(@RequestBody BankDTO bankDTO,@PathVariable Integer id){
        ApiResponse apiResponse = bankService.editBankService(id, bankDTO);
        return ResponseEntity.status(apiResponse.isSuccess()?200:409).body(apiResponse);
    }

    @DeleteMapping("/delete/{id}")
    public HttpEntity<?> deleteBank(@PathVariable Integer id){
        ApiResponse apiResponse = bankService.deleteBankService(id);
        return ResponseEntity.status(apiResponse.isSuccess()?200:409).body(apiResponse);
    }
}
