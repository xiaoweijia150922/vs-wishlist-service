package com.example.vswishlistservice.repository;

import com.example.vswishlistservice.domain.VsUser;
import org.springframework.stereotype.Repository;

/**
 * User Repository
 *
 * @author Xiaowei
 */
public interface VsUserRepository {

    /**
     * Get User By Id
     *
     * @param id userId
     * @return VsUser
     */
    VsUser getUserById(String id);

}
