package com.example.stock.util;

import com.example.stock.model.StockApiResponseFundamentalDataDTO;

import java.util.List;
import java.util.Map;
import java.util.concurrent.*;

/**
 * key={SYMBOL_CODE}.{EXCHANGE_ID}.yyyyMMdd
 */
public class LocalFundamentalData {

    private final static Map<String, List<StockApiResponseFundamentalDataDTO>> fundamentalMap = new ConcurrentHashMap<>();

    public static void put(String key, List<StockApiResponseFundamentalDataDTO> fundamentalList) {
        fundamentalMap.put(key, fundamentalList);
    }

    public static List<StockApiResponseFundamentalDataDTO> get(String key) {
        return fundamentalMap.get(key);
    }

}
