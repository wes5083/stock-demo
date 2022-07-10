package com.example.stock.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Map;

@Data
@JsonIgnoreProperties
public class StockApiResponseSymbolDTO {

    @JsonProperty(value = "Code")
    private String code;

    @JsonProperty(value = "Name")
    private String name;

//    @JsonProperty(value = "Country")
//    private String country;
//
//    @JsonProperty(value = "Exchange")
//    private String exchange;
//
//    @JsonProperty(value = "Currency")
//    private String currency;

}
