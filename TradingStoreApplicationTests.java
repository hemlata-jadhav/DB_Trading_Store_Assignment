package com.tradeAssignment.tradingStore;

import java.time.LocalDate;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
//import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.tradeAssignment.tradingStore.controller.TradeController;
import com.tradeAssignment.tradingStore.domain.Trade;


//@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:app-context.xml")
@SpringBootTest
class TradingStoreApplicationTests {
	
	/*
	 * @Test void contextLoads() { }
	 * 
	 */
	

	@Autowired
	private TradeController tradeController;
	
	
	
	@Test
	void testTradeValidateAndStore_successful() {
		Trade trade1= createTrade("T1",1,LocalDate.now());
		@SuppressWarnings("rawtypes")
		ResponseEntity actualcResponseEntity = tradeController.saveValidTradeToStore(trade1);
		Assertions.assertEquals(ResponseEntity.status(HttpStatus.OK).build(),actualcResponseEntity);
		
	}
	
	public Trade createTrade(String tradeId,int version,LocalDate  maturityDate){
		Trade trade = new Trade();
		trade.setTradeId(tradeId);
		trade.setBookId(tradeId+"B1");
		trade.setVersion(version);
		trade.setCounterParty(tradeId+"Cpty");
		trade.setMaturityDate(maturityDate);
		trade.setExpiredFlag("Y");
		return trade;
	}
}
