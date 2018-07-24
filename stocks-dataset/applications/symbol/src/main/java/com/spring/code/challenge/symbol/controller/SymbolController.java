package com.spring.code.challenge.symbol.controller;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.spring.code.challenge.symbol.domain.Symbol;
import com.spring.code.challenge.symbol.service.SymbolService;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.List;

@RestController
@RequestMapping("/stockSymbols/")
public class SymbolController {

    private static final String CONFIG_FILE = "/stock-symbols.json";
    private SymbolService symbolService;

    public SymbolController(SymbolService symbolService) {
        this.symbolService = symbolService;
    }

    @GetMapping
    public Iterable<Symbol> findAll(){
        return symbolService.findAll();
    }

//    @GetMapping("/{id}")
//    public Symbol findSymbolById(@PathVariable("id")Long id){
//        return symbolService.findById(id);
//    }

    @GetMapping("{symbol}")
    public Symbol findSymbolById(@PathVariable("symbol")String symbol){
        return symbolService.findBySymbol(symbol);
    }

    @PostMapping
    public void loadSymbols(){
        ObjectMapper mapper = new ObjectMapper();
        try {
            URL fileUrl = getClass().getResource(CONFIG_FILE);
            List<Symbol> symbols = mapper.readValue(new File(fileUrl.getFile()), new TypeReference<List<Symbol>>() {});
            symbolService.save(symbols);
            System.out.println("******************************");
            System.out.println("Symbols stored to database");
            System.out.println("******************************");
        } catch (IOException e) {
            System.out.println("Unable to save users: " + e.getMessage());
        }
    }
}
