import APIRequest from "../utils/APIRequest";

const StockService = {
  getAllExchanges: () => {
    const url = `/stock/exchanges`;
    return APIRequest.get(url);
  },

  getAllSymbolesByExchangeId: (exchangeId: string) => {
    const url = `/stock/exchanges/${exchangeId}`;
    return APIRequest.get(url);
  },

  getFundamentalDataBySymbolcodeAndExchangeId: (
    symbolCode: string,
    exchangeId: string
  ) => {
    const url = `/stock/fundamental/${symbolCode}.${exchangeId}`;
    return APIRequest.get(url);
  },
};
export default StockService;
