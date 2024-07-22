package com.example.vswishlistservice.domain;

import lombok.Data;

import java.util.Set;
import java.util.UUID;

/**
 * VisitScotland customers entity
 *
 * @author Xiaowei
 */
@Data
public class VsUser extends BaseDomainEntity {

    private WishList wishList;

    /**
     * Create User's Wish List
     *
     * @return Wish List
     */
    public WishList createWishList() {

        if (wishList != null) {
            throw new UnsupportedOperationException("Wish List already exists");
        }

        wishList = new WishList();
        String uuid = UUID.randomUUID().toString();
        wishList.setId(uuid);
        wishList.setVsUser(this);

        return wishList;
    }

    /**
     * Delete User's Wish List
     */
    public void deleteWishList() {
        if (wishList == null) {
            throw new UnsupportedOperationException("Wish list not found");
        }
        wishList = null;
    }

    /**
     * Add item to wish list
     *
     * @param abstractProduct Product to be added
     */
    public void addItemToWishList(AbstractProduct abstractProduct) {

        if (wishList == null) {
            throw new UnsupportedOperationException("Wish list not found");
        }

        wishList.addProduct(abstractProduct);

    }

    /**
     * Remove product from wish list
     *
     * @param abstractProduct product to be removed
     */
    public void removeItemFromWishList(AbstractProduct abstractProduct) {
        if (wishList == null) {
            throw new UnsupportedOperationException("Wish list not found");
        }

        wishList.removeProduct(abstractProduct);

    }

    /**
     * Get Wish List products
     *
     * @return Products in Wish List
     */
    public Set<AbstractProduct> getWishListProducts() {
        if (wishList == null) {
            throw new UnsupportedOperationException("Wish list not found");
        }

        return wishList.getProducts();
    }

    /**
     * Get Wish List products by Cateogry
     *
     * @param category to get products
     * @return products in wish list
     */
    public Set<AbstractProduct> getWishListProducts(String category) {
        if (wishList == null) {
            throw new UnsupportedOperationException("Wish list not found");
        }

        return wishList.getProductsByCategory(category);
    }

}
