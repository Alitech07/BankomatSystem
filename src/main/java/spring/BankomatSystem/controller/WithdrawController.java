package spring.BankomatSystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import spring.BankomatSystem.payload.WithdrawDto;
import spring.BankomatSystem.service.BankomatService;
import spring.BankomatSystem.service.CardService;
import spring.BankomatSystem.service.OutcomeService;

@RestController
@RequestMapping("/api/withdraw")
public class WithdrawController {
    @Autowired
    BankomatService bankomatService;
    @Autowired
    OutcomeService outcomeService;
    @Autowired
    CardService cardService;

    @PostMapping
    public HttpEntity<?> withdrawCard(WithdrawDto withdrawDto){
        
    }
}
