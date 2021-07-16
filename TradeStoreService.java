package com.tradeAssignment.tradingStore.service;

import org.springframework.stereotype.Service;

import com.tradeAssignment.tradingStore.domain.Trade;

@Service
public interface TradeStoreService {
	 
	 public Trade saveValidTradeToStore(Trade trade);

}
