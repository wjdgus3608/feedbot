package com.jung.feedbot.feedbot.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Entity
@Getter
@AllArgsConstructor
@ToString
public class BackTestStock {
    @Id
    String stockName;
    FeedPeriod feedPeriod;
    float yearFeedRate;

}