package com.jung.feedbot.feedbot.repo;

import com.jung.feedbot.feedbot.domain.BackTestStock;
import org.springframework.data.repository.CrudRepository;

public interface BackTestStockRepo extends CrudRepository<BackTestStock, Long> {
}
