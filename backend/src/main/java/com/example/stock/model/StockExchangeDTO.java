package com.example.stock.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
public class StockExchangeDTO {

    private String exchangeId;

    private String description;

    public StockExchangeDTO(String exchangeId, String description){
        this.exchangeId = exchangeId;
        this.description = description;
    }
}
