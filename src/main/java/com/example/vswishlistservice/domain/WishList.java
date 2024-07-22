package com.example.vswishlistservice.domain;

import lombok.Data;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Wish List entity class
 *
 * @author Xiaowei
 */
@Data
public class WishList extends BaseDomainEntity {

    private VsUser vsUser;

    private Set<AbstractProduct> products = new HashSet<>();

    /**
     * Add Product
     *
     * @param abstractProduct product to be added
     */
    public void addProduct(AbstractProduct abstractProduct) {
        products.add(abstractProduct);
    }

    /**
     * Remove product
     *
     * @param abstractProduct product to be removed
     */
    public void removeProduct(AbstractProduct abstractProduct) {
        products.remove(abstractProduct);
    }

    /**
     * Get Products by Category
     *
     * @param category to get Products for
     * @return products in Wish List
     */
    public Set<AbstractProduct> getProductsByCategory(String category) {
        return switch (category) {
            case "HOTEL" -> products.stream().filter(p -> p instanceof Hotel).collect(Collectors.toSet());
            case "ATTRACTION" -> products.stream().filter(p -> p instanceof Attraction).collect(Collectors.toSet());
            case "TOURISTEVENT" -> products.stream().filter(p -> p instanceof TouristEvent).collect(Collectors.toSet());
            default -> throw new IllegalArgumentException("Unsupported product type");
        };
    }

}
