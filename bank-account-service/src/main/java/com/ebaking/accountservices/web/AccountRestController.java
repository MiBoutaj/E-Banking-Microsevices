package com.ebaking.accountservices.web;

import com.ebaking.accountservices.entities.BankAccount;
import com.ebaking.accountservices.repositories.BankAccountRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class AccountRestController {

    private final BankAccountRepository bankAccountRepository;


    @GetMapping("/bankAccounts")
    public List<BankAccount> bankAccounts(){
        return bankAccountRepository.findAll();
    }

    @GetMapping("/bankAccount/{id}")
    public BankAccount bankAccount(@PathVariable("id") String id){
        return bankAccountRepository.findById(id).orElseThrow(()->new RuntimeException(String.format("Account  %s not found ",id)));
    }
}
