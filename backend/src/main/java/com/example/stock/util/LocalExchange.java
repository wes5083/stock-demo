package com.example.stock.util;

import java.util.HashMap;
import java.util.Map;

/**
 * all support exchanges
 *     https://eodhistoricaldata.com/financial-apis/list-supported-exchanges/
 */
public class LocalExchange {

    private final static Map<String, String> exchangesMap;
    public static Map<String, String> getExchangesMap(){
        return exchangesMap;
    }
    static {
        exchangesMap = new HashMap<>();
        exchangesMap.put("US","US"); // default
        exchangesMap.put("AS","EuronextAmsterdam");
        exchangesMap.put("AT","AthensExchange");
        exchangesMap.put("AU","AustraliaExchange");
        exchangesMap.put("BA","BuenosAiresExchange");
        exchangesMap.put("BE","BerlinExchange");
        exchangesMap.put("BK","ThailandExchange");
        exchangesMap.put("BOND","BondVirtualExchange");
        exchangesMap.put("BR","EuronextBrussels");
        exchangesMap.put("BSE","BombayExchange");
        exchangesMap.put("BUD","BudapestStockExchange");
        exchangesMap.put("CC","Cryptocurrencies");
        exchangesMap.put("CM","ColomboStockExchange");
        exchangesMap.put("CN","CanadianSecuritiesExchange");
        exchangesMap.put("CO","CopenhagenExchange");
        exchangesMap.put("COMM","Commodities");
        exchangesMap.put("DU","DusseldorfExchange");
        exchangesMap.put("ETLX","BorsaItalianaCertificates");
        exchangesMap.put("EUFUND","EuropeFundVirtualExchange");
        exchangesMap.put("F","FrankfurtExchange");
        exchangesMap.put("FOREX","FOREX");
        exchangesMap.put("GBOND","GovernmentBonds");
        exchangesMap.put("HA","HanoverExchange");
        exchangesMap.put("HE","HelsinkiExchange");
        exchangesMap.put("HK","HongKongExchange");
        exchangesMap.put("HM","HamburgExchange");
        exchangesMap.put("IC","IcelandExchange");
        exchangesMap.put("IL","LondonIL");
        exchangesMap.put("INDX","Indices");
        exchangesMap.put("IR","IrishExchange");
        exchangesMap.put("IS","IstanbulStockExchange");
        exchangesMap.put("JK","JakartaExchange");
        exchangesMap.put("JSE","JohannesburgExchange");
        exchangesMap.put("KAR","KarachiStockExchange");
        exchangesMap.put("KLSE","KualaLumpurExchange");
        exchangesMap.put("KO","KoreaStockExchange");
        exchangesMap.put("KQ","KOSDAQ");
        exchangesMap.put("LIM","BolsadeValoresdeLima");
        exchangesMap.put("LS","EuronextLisbon");
        exchangesMap.put("LSE","LondonExchange");
        exchangesMap.put("LU","LuxembourgStockExchange");
        exchangesMap.put("MC","MadridExchange");
        exchangesMap.put("MCX","MICEXMoscowRussia");
        exchangesMap.put("MI","BorsaItaliana");
        exchangesMap.put("MONEY","MoneyMarketVirtualExchange");
        exchangesMap.put("MU","MunichExchange");
        exchangesMap.put("MX","MexicanExchange");
        exchangesMap.put("NB","NasdaqBaltic");
        exchangesMap.put("NEO","NEOExchange");
        exchangesMap.put("NFN","FirstNorthDenmark");
        exchangesMap.put("NSE","NSE(India)");
        exchangesMap.put("OL","OsloStockExchange");
        exchangesMap.put("PA","EuronextParis");
        exchangesMap.put("PSE","PhilippineStockExchange");
        exchangesMap.put("RG","RigaExchange");
        exchangesMap.put("RO","BucharestStockExchange");
        exchangesMap.put("SA","SaoPaoloExchange");
        exchangesMap.put("SG","SingaporeExchange");
        exchangesMap.put("SHE","ShenzhenExchange");
        exchangesMap.put("SHG","ShanghaiExchange");
        exchangesMap.put("SN","ChileanStockExchange");
        exchangesMap.put("SR","SaudiArabiaExchange");
        exchangesMap.put("ST","StockholmExchange");
        exchangesMap.put("STU","StuttgartExchange");
        exchangesMap.put("SW","SIXSwissExchange");
        exchangesMap.put("TA","TelAvivExchange");
        exchangesMap.put("TL","TallinnExchange");
        exchangesMap.put("TO","TorontoExchange");
        exchangesMap.put("TW","TaiwanExchange");
        exchangesMap.put("TWO","TaiwanOTCExchange");
        exchangesMap.put("V","TSXVentureExchange");
        exchangesMap.put("VI","ViennaExchange");
        exchangesMap.put("VN","VietnamStocks");
        exchangesMap.put("VS","VilnusExchange");
        exchangesMap.put("VX","SwissExchange");
        exchangesMap.put("WAR","WarsawStockExchange");
        exchangesMap.put("XETRA","XETRAExchange");
        exchangesMap.put("ZSE","ZagrebStockExchange");


    }

}


