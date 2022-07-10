export type StockExchangeProps = {
  exchangeId: string;
  description: string;
};

export type StockSymbolProps = {
  Code: string;
  Name: string;
};

export type StockProps = {
  date: string;
  open: number;
  high: number;
  low: number;
  close: number;
  volume: number;
};
