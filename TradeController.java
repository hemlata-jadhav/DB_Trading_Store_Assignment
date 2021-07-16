package com.tradeAssignment.tradingStore.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.tradeAssignment.tradingStore.domain.Trade;
import com.tradeAssignment.tradingStore.exception.InvalidTradeException;
import com.tradeAssignment.tradingStore.service.TradeStoreService;



@RestController
public class TradeController {
	
    @Autowired
    private TradeStoreService tradeStoreService;
    
  
    @PostMapping("/trade")
    public ResponseEntity<String> saveValidTradeToStore(@RequestBody Trade trade) throws InvalidTradeException{
      
    	
    	tradeStoreService.saveValidTradeToStore(trade);
    	
    
        return ResponseEntity.status(HttpStatus.OK).build();
    }

}
