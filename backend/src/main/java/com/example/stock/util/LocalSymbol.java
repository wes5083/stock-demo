package com.example.stock.util;

import com.example.stock.model.StockApiResponseSymbolDTO;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class LocalSymbol {
    private final static Map<String, List<StockApiResponseSymbolDTO>> symbolMap = new ConcurrentHashMap<>();

    public static void put(String exchangeId, List<StockApiResponseSymbolDTO> symbolList) {
        symbolMap.put(exchangeId, symbolList);
    }

    public static List<StockApiResponseSymbolDTO> get(String exchangeId) {
        return symbolMap.get(exchangeId);
    }


}
