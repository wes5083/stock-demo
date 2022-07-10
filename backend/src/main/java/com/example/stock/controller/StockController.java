package com.example.stock.controller;


import com.example.stock.service.StockService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequiredArgsConstructor
public class StockController {

    private final StockService stockService;

    @GetMapping("/api/stock/exchanges")
    public ResponseEntity<?> allExchanges() {
        return ResponseEntity.ok(stockService.allExchanges());
    }

    @GetMapping("/api/stock/exchanges/{exchangeId}")
    public ResponseEntity<?> allSymbols(@PathVariable("exchangeId") String exchangeId) {
        return ResponseEntity.ok(stockService.allSymbols(exchangeId));
    }

    @GetMapping("/api/stock/fundamental/{symbolCode}.{exchangeId}")
    public ResponseEntity<?> fundamentalData(@PathVariable("symbolCode") String symbolCode,
                                             @PathVariable("exchangeId") String exchangeId) {
        return ResponseEntity.ok(stockService.fundamentalData(symbolCode, exchangeId));
    }

}