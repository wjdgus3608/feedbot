package com.jung.feedbot.feedbot.domain;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Entity
@Getter
@AllArgsConstructor
@ToString
public class BackTestStockFeed {
    @EmbeddedId
    StockKey stockKey;
    float feedAmount;
}
