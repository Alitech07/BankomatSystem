package spring.BankomatSystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import spring.BankomatSystem.service.BankomatService;

@RestController
@RequestMapping("/api/bankomat")
public class BankomatController {
    @Autowired
    BankomatService bankomatService;
}
