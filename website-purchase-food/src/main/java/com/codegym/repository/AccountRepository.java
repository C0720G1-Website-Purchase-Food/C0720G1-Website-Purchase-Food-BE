package com.codegym.repository;

import com.codegym.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Integer> {
    Account findByUsername(String username);

    Account findByAdminManager_Id(Integer student_id);

    Account findByUserManager_Id(Integer teacher_id);

}
