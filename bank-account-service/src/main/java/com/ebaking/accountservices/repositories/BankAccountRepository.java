package com.ebaking.accountservices.repositories;

import com.ebaking.accountservices.entities.BankAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BankAccountRepository extends JpaRepository<BankAccount,String> {
}
