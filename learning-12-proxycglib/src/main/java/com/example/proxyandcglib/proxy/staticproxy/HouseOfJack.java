package com.example.proxyandcglib.proxy.staticproxy;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class HouseOfJack implements HouseSale {
    @Override
    public void sale() {
        log.info("jack有房子出租...");
    }
}
