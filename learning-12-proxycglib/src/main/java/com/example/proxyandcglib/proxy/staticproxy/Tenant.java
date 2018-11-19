package com.example.proxyandcglib.proxy.staticproxy;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * 这个就是静态代理的demo
 */
@Slf4j
public class Tenant {

    @Test
    public void tenant() {
        log.info("没房子住了...找中介租房才行");
        SaleProxy mbs = new SaleProxy();
        mbs.sale();
        log.info("mbs终于租到房子住了...");
    }
}
