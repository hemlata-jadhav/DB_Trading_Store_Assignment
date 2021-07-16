package com.tradeAssignment.tradingStore.serviceImpl;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tradeAssignment.tradingStore.domain.Trade;
import com.tradeAssignment.tradingStore.repository.TradeRepository;
import com.tradeAssignment.tradingStore.service.TradeStoreService;

@Component
public class TradeStoreServiceImpl implements TradeStoreService {

	@Autowired
	private TradeRepository tradeRepository;

	/**
	 * @param trade
	 * @return
	 * allow the trade which has less maturity date
	 */
	private boolean validateMaturityDate(Trade trade) {
		return trade.getMaturityDate().isBefore(LocalDate.now()) ? false : true;
	}

	/**
	 * @param trade
	 * @param oldTrade
	 * @return
	 * check for version should be greater than or equal 
	 */
	private boolean validateVersion(Trade trade, Trade oldTrade) {

		if (trade.getVersion() >= oldTrade.getVersion()) {
			return true;
		}
		return false;
	}

	@Override
	public Trade saveValidTradeToStore(Trade trade) {
		// TODO Auto-generated method stub
		if (validateMaturityDate(trade)) {
			Optional<Trade> exsitingTrade = tradeRepository.findById(trade.getTradeId());
			if (validateVersion(trade, exsitingTrade.get())) {
				tradeRepository.save(trade);
			}

		}
		return trade;
	}
}
