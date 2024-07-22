package com.example.vswishlistservice.service;

import com.example.vswishlistservice.domain.AbstractProduct;
import com.example.vswishlistservice.domain.VsUser;
import com.example.vswishlistservice.domain.WishList;
import com.example.vswishlistservice.repository.VsUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

/**
 * WishList Service Class
 *
 * @author Xiaowei
 */
@Service
public class WishListService {

    private final VsUserRepository vsUserRepository;

    @Autowired
    public WishListService(VsUserRepository vsUserRepository) {
        this.vsUserRepository = vsUserRepository;
    }

    /**
     * Create Wish list for a user
     *
     * @param userId userId to create wish list for
     * @return New Wish list entity
     */
    public WishList createWishList(String userId) {

        VsUser vsUser = vsUserRepository.getUserById(userId);
        WishList wishList = vsUser.createWishList();

        return wishList;
    }

    /**
     * Delete a Wish list
     *
     * @param userId userId to delete a wish list
     */
    public void deleteWishList(String userId) {

        VsUser vsUser = vsUserRepository.getUserById(userId);
        vsUser.deleteWishList();

    }

    /**
     * Add item to wish list
     *
     * @param userId          user to add product to wish list
     * @param abstractProduct product to be added
     */
    public void addItemToWishList(String userId, AbstractProduct abstractProduct) {

        VsUser vsUser = vsUserRepository.getUserById(userId);
        vsUser.addItemToWishList(abstractProduct);

    }

    /**
     * Remove item from wish list
     *
     * @param userId          user to remove item
     * @param abstractProduct product to be removed
     */
    public void removeItemFromWishList(String userId, AbstractProduct abstractProduct) {

        VsUser vsUser = vsUserRepository.getUserById(userId);
        vsUser.removeItemFromWishList(abstractProduct);

    }

    /**
     * Get User's Wish List
     *
     * @param userId to get Wish List
     * @return Wish List
     */
    public Set<AbstractProduct> getWishList(String userId) {
        VsUser vsUser = vsUserRepository.getUserById(userId);
        return vsUser.getWishListProducts();
    }

    public Set<AbstractProduct> getWishList(String userId, String category) {
        VsUser vsUser = vsUserRepository.getUserById(userId);
        return vsUser.getWishListProducts(category);

    }

}
