import React, { useState, useEffect } from "react";
import StockService from "../services/StockService";
import {
  StockProps,
  StockExchangeProps,
  StockSymbolProps,
} from "../interfaces/StockProps";
import { LOCAL_STORAGE_EXCHANGES_KEY } from "../utils/Constants";

const StockPage = () => {
  const [exchangeList, setExchangeList] = useState<StockExchangeProps[]>([]);
  const [symbolList, setSymbolList] = useState<StockSymbolProps[]>([]);
  const [stockList, setStockList] = useState<StockProps[]>([]);
  const [isLoading, setIsLoading] = useState<boolean>(true);

  const [queryExchangeId, setQueryExchangeId] = useState<string>("");
  const [querySymbolCode, setQuerySymbolCode] = useState<string>("");

  useEffect(() => {
    handleExchange();
  }, []);

  useEffect(() => {
    handleSymbol();
  }, [queryExchangeId]);

  const handleExchange = () => {
    let exchangeLocal = localStorage.getItem(LOCAL_STORAGE_EXCHANGES_KEY);
    if (exchangeLocal) {
      setExchangeList(JSON.parse(exchangeLocal));
      return;
    }

    StockService.getAllExchanges()
      .then((res) => {
        if (res.data.statusCode === 1) {
          setExchangeList(res.data.data);
          localStorage.setItem(
            LOCAL_STORAGE_EXCHANGES_KEY,
            JSON.stringify(res.data.data)
          );
        }
      })
      .catch(function (error) {
        console.log(error);
      });
  };

  const handleSymbol = () => {
    if (queryExchangeId) {
      let key = queryExchangeId;
      let symbolLocal = localStorage.getItem(key);
      if (symbolLocal) {
        setSymbolList(JSON.parse(symbolLocal));
        return;
      }

      StockService.getAllSymbolesByExchangeId(queryExchangeId)
        .then((res) => {
          if (res.data.statusCode === 1) {
            setSymbolList(res.data.data);
            localStorage.setItem(key, JSON.stringify(res.data.data));
          }
        })
        .catch(function (error) {
          console.log(error);
        });
    }
  };

  const handleQuery = () => {
    if (querySymbolCode && queryExchangeId) {
      let key = querySymbolCode + "." + queryExchangeId;
      let stockLocal = localStorage.getItem(key);

      if (stockLocal) {
        setStockList(JSON.parse(stockLocal));
        return;
      }

      StockService.getFundamentalDataBySymbolcodeAndExchangeId(
        querySymbolCode,
        queryExchangeId
      )
        .then((res) => {
          if (res.data.statusCode === 1) {
            setStockList(res.data.data);
            setIsLoading(false);
            localStorage.setItem(key, JSON.stringify(res.data.data));
          }
        })
        .catch(function (error) {
          console.log(error);
        });
    }
  };

  return (
    <div className="container">
      <div className="container">
        <h2 className="text-center mt-5 mb-3">Stock Query</h2>
        <div className="card">
          <div className="card-header">
            <div className="input-group">
              <label htmlFor="exchanges" className="col-form-label">
                &nbsp;EXCHANGES:&nbsp;
              </label>
              <select
                id="exchanges"
                className="form-control"
                onChange={(event) => {
                  setQueryExchangeId(event.target.value);
                  handleSymbol();
                }}
              >
                {exchangeList.map((item, index) => (
                  <option key={index} value={item.exchangeId}>
                    {item.description}
                  </option>
                ))}
              </select>
            </div>

            <div className="input-group">
              <label htmlFor="symbol" className="col-form-label">
                &nbsp;SYMBOL:&nbsp;
              </label>
              <select
                id="symbol"
                className="form-control"
                onChange={(event) => {
                  setQuerySymbolCode(event.target.value);
                }}
              >
                {symbolList &&
                  symbolList.map((item, index) => (
                    <option key={index} value={item.Code}>
                      {item.Code}:{item.Name}
                    </option>
                  ))}
              </select>
            </div>
            <button
              onClick={handleQuery}
              className="btn btn-outline-primary mx-3"
            >
              Query
            </button>
          </div>
          <div className="card-body">
            <table className="table table-bordered">
              <thead>
                <tr>
                  <th>No.</th>
                  <th>DATE</th>
                  <th>OPEN</th>
                  <th>HEIGH</th>
                  <th>LOW</th>
                  <th>CLOSE</th>
                  <th>VOLUME</th>
                </tr>
              </thead>
              <tbody>
                {isLoading ? (
                  <tr>
                    <td>Data isLoading......</td>
                  </tr>
                ) : (
                  stockList &&
                  stockList.map((stock: StockProps, index: number) => {
                    return (
                      <tr key={index}>
                        <td>{index + 1}</td>
                        <td>{stock.date}</td>
                        <td>{stock.open}</td>
                        <td>{stock.high}</td>
                        <td>{stock.low}</td>
                        <td>{stock.close}</td>
                        <td>{stock.volume}</td>
                      </tr>
                    );
                  })
                )}
              </tbody>
            </table>
          </div>
        </div>
      </div>
    </div>
  );
};

export default StockPage;
