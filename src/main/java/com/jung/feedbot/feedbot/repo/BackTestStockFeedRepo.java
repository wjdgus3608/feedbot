package com.jung.feedbot.feedbot.repo;


import com.jung.feedbot.feedbot.domain.BackTestStockFeed;
import com.jung.feedbot.feedbot.domain.StockKey;
import org.springframework.data.repository.CrudRepository;

public interface BackTestStockFeedRepo extends CrudRepository<BackTestStockFeed, StockKey> {
}
