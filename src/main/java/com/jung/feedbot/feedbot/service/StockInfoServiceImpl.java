package com.jung.feedbot.feedbot.service;

import com.jung.feedbot.feedbot.crawler.TheRichCrawler;
import com.jung.feedbot.feedbot.crawler.YahooCrawler;
import com.jung.feedbot.feedbot.domain.BackTestStock;
import com.jung.feedbot.feedbot.domain.BackTestStockFeed;
import com.jung.feedbot.feedbot.domain.BackTestStockPrice;
import com.jung.feedbot.feedbot.domain.FeedPeriod;
import com.jung.feedbot.feedbot.utils.DateUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class StockInfoServiceImpl implements StockInfoService{

    @Value("${custom.filter.monthly-feed}")
    private float MONTHLY_FEED_LIMIT;

    private final TheRichCrawler theRichCrawler;
    private final YahooCrawler yahooCrawler;



    @Override
    public void collectBackTestData(){
        //종목 종류 수집
//        List<BackTestStock> backTestStocks = collectStockBasicInfo();
//        log.info("backTestStocks size after collectStockBasicInfo: "+backTestStocks.size());
//
//        //수집 종목 필터링
//        backTestStocks = filterCollectedStocks(backTestStocks);
//        log.info("backTestStocks size after filterCollectedStocks: "+backTestStocks.size());
//
//        //종목 배당락일, 배당금 수집
//        List<BackTestStockFeed> backTestStocksFeed = collectStockFeedInfo(backTestStocks);
//        log.info("backTestStocksFeed size: "+backTestStocksFeed.size());

//        List<BackTestStockPrice> backTestStockPrices = collectStockPriceInfo(backTestStocks);
        List<BackTestStockPrice> backTestStockPrices = collectStockPriceInfo(null);
        log.info("backTestStocks size final: "+backTestStockPrices.size());
    }

    private List<BackTestStock> collectStockBasicInfo() {
        return theRichCrawler.crawlMainPage(DateUtil.getDate(), "01");
    }

    private List<BackTestStock> filterCollectedStocks(List<BackTestStock> stockList) {
        return stockList.stream()
                .filter(item->item.getFeedPeriod() == FeedPeriod.MONTH
                && item.getYearFeedRate()/12 >=MONTHLY_FEED_LIMIT)
                .collect(Collectors.toList());
    }

    private List<BackTestStockFeed> collectStockFeedInfo(List<BackTestStock> stockList) {
        List<BackTestStockFeed> backTestStocksFeed = new ArrayList<>();
        for(BackTestStock stock:stockList){
            List<BackTestStockFeed> currentFeedInfo = theRichCrawler.crawlDetailPage(stock.getStockName());
            backTestStocksFeed.addAll(currentFeedInfo);
        }

        return backTestStocksFeed;
    }

    private List<BackTestStockPrice> collectStockPriceInfo(List<BackTestStock> stockList) {
        List<BackTestStockPrice> backTestStockPrices = new ArrayList<>();

//        for(BackTestStock stock:stockList){
//            List<BackTestStockPrice> currentPriceInfo = yahooCrawler.crawlPricePage(stock.getStockName());
//            backTestStockPrices.addAll(currentPriceInfo);
//        }

        List<BackTestStockPrice> currentPriceInfo = yahooCrawler.crawlPricePage("TSLY");
        backTestStockPrices.addAll(currentPriceInfo);

        return backTestStockPrices;

    }
}
