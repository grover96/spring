package com.spring.code.challenge.symbol.repository;

import com.spring.code.challenge.symbol.domain.Symbol;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SymbolRepository extends CrudRepository<Symbol, Long> {
    public Symbol findBySymbol(String symbol);
}
