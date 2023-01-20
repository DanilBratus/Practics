package com.project;

import org.springframework.bean.factory.annotation.Autowired;
import org.springframework.bean.factory.annotation.Resource;
import org.springframework.bean.factory.stereotype.Component;
import org.springframework.bean.factory.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Service
public class ProductService {
    @Resource
    private PromotionService promotionService;
    private int number = 0;

    public PromotionService getPromotionService() {
        return promotionService;
    }

    public void setPromotionService(PromotionService promotionService) {
        this.promotionService = promotionService;
    }

    public int getNumber() {
        return number;
    }

    @PostConstruct
    public void playPostConstruct() {
        number = 6;
        System.out.println("***Выполнен PostConstruct*** \t Значение Number: " + this.number);
    }

    @PreDestroy
    public void playPreDestroy() {
        number = 2;
        System.out.println("***Выполнен PreDestroy*** \t Значение Number: " + this.number);
    }
}
