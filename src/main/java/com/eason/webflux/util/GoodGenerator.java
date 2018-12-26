package com.eason.webflux.util;

import com.eason.webflux.model.Good;
import org.springframework.context.annotation.Configuration;
import reactor.core.publisher.Flux;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Eason
 * @createTime 2018-12-26 10:54
 * @description
 */
@Configuration
public class GoodGenerator {

    public Flux<Good> findGoods() {
        List<Good> goods = new ArrayList<>();
        goods.add(new Good(1,"小米",new BigDecimal(2000)));
        goods.add(new Good(2,"华为",new BigDecimal(4000)));
        goods.add(new Good(3,"苹果",new BigDecimal(8000)));
        return Flux.fromIterable(goods);
    }
}
