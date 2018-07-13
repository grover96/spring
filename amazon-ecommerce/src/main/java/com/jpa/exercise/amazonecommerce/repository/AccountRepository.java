package com.jpa.exercise.amazonecommerce.repository;

import com.jpa.exercise.amazonecommerce.domain.Account;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends CrudRepository<Account, Long> {
}
