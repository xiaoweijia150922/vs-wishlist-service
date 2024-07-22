package com.example.vswishlistservice.domain;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * Tourist Event Class
 *
 * @author Xiaowei
 */
@Data
public class TouristEvent extends AbstractProduct {

    private LocalDateTime eventDateTime;

}
