package com.jung.feedbot.feedbot.domain;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

@Embeddable
@AllArgsConstructor
@ToString
public class StockKey implements Serializable {
    private String stockName;
    private String feedDate;
}
