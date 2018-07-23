package com.spring.code.challenge.symbol.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.Id;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Table;

@Entity
@AllArgsConstructor
@Data
@Table(name = "symbols")
public class Symbol {

    @Id
    @GeneratedValue
    private long id;
    private String symbol;

    public Symbol() {}

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }
}
