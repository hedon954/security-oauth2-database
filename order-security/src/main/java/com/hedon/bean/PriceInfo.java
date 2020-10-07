package com.hedon.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.math.BigDecimal;

/**
 * @author Hedon Wang
 * @create 2020-10-05 16:14
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class PriceInfo {

    private Integer id;

    private BigDecimal price;
}
