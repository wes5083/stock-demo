package com.example.stock.service;

import com.example.stock.common.Constants;
import com.example.stock.common.ResponseVo;
import com.example.stock.exception.NotSupportException;
import com.example.stock.model.StockApiResponseFundamentalDataDTO;
import com.example.stock.model.StockApiResponseSymbolDTO;
import com.example.stock.model.StockExchangeDTO;
import com.example.stock.util.LocalExchange;
import com.example.stock.util.LocalFundamentalData;
import com.example.stock.util.LocalSymbol;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
@Slf4j
@RequiredArgsConstructor
public class StockService {

    private final StockServiceClient stockServiceClient;

    /**
     * All exchanges
     *
     * @return
     */
    public ResponseVo allExchanges() {
        List<StockExchangeDTO> list = LocalExchange.getExchangesMap().entrySet().stream().
                sorted(Comparator.comparing(e -> e.getValue()))
                .map(e -> new StockExchangeDTO(e.getKey(), e.getValue())).collect(Collectors.toList());
        return ResponseVo.success(list);
    }

    /**
     * All symbols code of this exchange
     *
     * @param exchangeId
     * @return
     */
    public ResponseVo allSymbols(final String exchangeId) {
        if (!StringUtils.hasLength(LocalExchange.getExchangesMap().get(exchangeId))) {
            throw new NotSupportException(exchangeId);
        }
        List<StockApiResponseSymbolDTO> list = LocalSymbol.get(exchangeId);
        if (CollectionUtils.isEmpty(list)) {
            list = stockServiceClient.getExchangeSymbol(exchangeId);
            LocalSymbol.put(exchangeId, list);
        }
        return ResponseVo.success(list);
    }

    /**
     * Get Recent one year data by symbol code & exchange ID
     *
     * @param symbolCode
     * @param exchangeId
     * @return
     */
    public ResponseVo fundamentalData(final String symbolCode, final String exchangeId) {

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(Constants.DATA_FORMATTER_PATTERN_YYYYMMDD);

        String localCacheKey = symbolCode + Constants.SEPARATOR_COMMA_DOT + exchangeId +
                Constants.SEPARATOR_COMMA_DOT + dateTimeFormatter.format(LocalDateTime.now());

        if (!StringUtils.hasLength(LocalExchange.getExchangesMap().get(exchangeId))) {
            throw new NotSupportException(exchangeId);
        }

        List<StockApiResponseSymbolDTO> symbolLocal = LocalSymbol.get(exchangeId);
        boolean symbolExist = Optional.ofNullable(symbolLocal).orElse(new ArrayList<>()).stream().
                filter(item -> item.getCode().equals(symbolCode)).findFirst().isPresent();
        if (!symbolExist) {
            throw new NotSupportException(exchangeId + Constants.SEPARATOR_COMMA_DOT + symbolCode);
        }

        List<StockApiResponseFundamentalDataDTO> list = LocalFundamentalData.get(localCacheKey);
        if (CollectionUtils.isEmpty(list)) {
            list = stockServiceClient.fundamentalData(symbolCode, exchangeId);
            LocalFundamentalData.put(localCacheKey, list);
        }

        return ResponseVo.success(list);
    }

}