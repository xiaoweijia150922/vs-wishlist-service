package com.example.vswishlistservice.domain;

import lombok.Data;

/**
 * Abstract Product Entity representing an item eg hotel, car rentals etc.
 *
 * @author Xiaowei
 */
@Data
public abstract class AbstractProduct extends BaseDomainEntity {

    private String title;

    private String description;

    private ProductCategory productCategory;

}
