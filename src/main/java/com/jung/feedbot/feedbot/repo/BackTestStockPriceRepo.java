package com.jung.feedbot.feedbot.repo;

import com.jung.feedbot.feedbot.domain.BackTestStockPrice;
import com.jung.feedbot.feedbot.domain.StockKey;
import org.springframework.data.repository.CrudRepository;

public interface BackTestStockPriceRepo extends CrudRepository<BackTestStockPrice, StockKey> {
}
