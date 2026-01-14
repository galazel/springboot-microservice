package com.glyzel.product_service;

import java.math.BigDecimal;

public interface ProductView {
    String getName();
    String getDescription();
    BigDecimal getPrice();
}
