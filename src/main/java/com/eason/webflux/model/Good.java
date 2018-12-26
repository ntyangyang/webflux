package com.eason.webflux.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.math.BigDecimal;

/**
 * @author Eason
 * @createTime 2018-12-26 10:52
 * @description
 */
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Good {
    private Integer id;
    private String name;
    private BigDecimal price;
}
