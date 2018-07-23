package com.spring.code.challenge.symbol.service;

import com.spring.code.challenge.symbol.domain.Symbol;
import com.spring.code.challenge.symbol.repository.SymbolRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SymbolService {

    private SymbolRepository symbolRepository;
    private List<Symbol> listOfSymbols = new ArrayList<>();
    private List<Symbol> newListOfSymbols = new ArrayList<>();


    public SymbolService(SymbolRepository symbolRepository) {
        this.symbolRepository = symbolRepository;
    }

    public Iterable<Symbol> findAll(){
        return symbolRepository.findAll();
    }

    public Symbol findById(Long id) {
        return symbolRepository.findById(id).get();
    }

    public Symbol findBySymbol(String symbol){
        return symbolRepository.findBySymbol(symbol);
    }

    public List<Symbol> save(List<Symbol> symbolInfo) {
        if (symbolInfo != null) {
            for (int i = 0; i < symbolInfo.size(); i++) {
                Symbol symbol = new Symbol();
                symbol.setSymbol(symbolInfo.get(i).getSymbol());
                listOfSymbols.add(symbol);
            }
        }
        symbolRepository.saveAll(listOfSymbols).forEach(newListOfSymbols::add);
        return newListOfSymbols;
    }
}
