package com.example.proxyandcglib.proxy.staticproxy;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SaleProxy implements HouseSale {

    private HouseOfJack jack = new HouseOfJack();

    @Override
    public void sale() {
        log.info("中介（proxy）现在有房源了，欢迎选购...");
        jack.sale();
        log.info("中介（proxy）出租了一间房子");
    }
}
