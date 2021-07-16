package com.tradeAssignment.tradingStore.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.tradeAssignment.tradingStore.domain.Trade;

@Repository
public interface TradeRepository extends CrudRepository<Trade,String> {
}
