package com.mertaydar.emw.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.mertaydar.emw.entity.Account;

public interface AccountRepository extends JpaRepository<Account, Integer> {

}
