package com.ebaking.accountservices;

import com.ebaking.accountservices.entities.BankAccount;
import com.ebaking.accountservices.enums.AccountType;
import com.ebaking.accountservices.repositories.BankAccountRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Time;
import java.time.LocalDateTime;
import java.util.UUID;

@SpringBootApplication
public class AccountServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(AccountServiceApplication.class,args);
    }

    @Bean
    CommandLineRunner
     commandLineRunner(BankAccountRepository bankAccountRepository){
        return args -> {

            for (int i = 0; i < 10; i++) {

                BankAccount bankAccount = BankAccount
                        .builder()
                        .id(UUID.randomUUID().toString())
                        .accountType(Math.random()>0.5? AccountType.CURRENT_ACCOUNT:AccountType.SAVING_ACCOUNT)
                        .balance(10000+Math.random()*9000)
                        .currency("MAD")
                        .createdAt(System.currentTimeMillis())
                        .build();
                bankAccountRepository.save(bankAccount);
            }
        };
    }
}
