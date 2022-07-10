package com.example.stock.service;


import com.example.stock.config.FeignClientConfiguration;
import com.example.stock.model.StockApiResponseFundamentalDataDTO;
import com.example.stock.model.StockApiResponseSymbolDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import java.util.List;


@FeignClient(value = "stockServiceClient",
        url = "${stock.service.api.domain}",
        configuration = FeignClientConfiguration.class
)
public interface StockServiceClient {
    @RequestMapping(method = RequestMethod.GET, value = "/exchange-symbol-list/{exchangeId}?api_token=${stock.service.api.token}&fmt=json")
    List<StockApiResponseSymbolDTO> getExchangeSymbol(@PathVariable("exchangeId") String exchangeId);

    @RequestMapping(method = RequestMethod.GET, value = "/eod/{symbolCode}.{exchangeId}?api_token=${stock.service.api.token}&fmt=json")
    List<StockApiResponseFundamentalDataDTO> fundamentalData(@PathVariable("symbolCode") String symbolCode, @PathVariable("exchangeId") String exchangeId);
}
