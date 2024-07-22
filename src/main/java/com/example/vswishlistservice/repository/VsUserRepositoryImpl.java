package com.example.vswishlistservice.repository;

import com.example.vswishlistservice.domain.VsUser;
import org.springframework.stereotype.Repository;

/**
 * VsUser Repository Impl
 *
 * @author Xiaowei
 */
@Repository
public class VsUserRepositoryImpl implements VsUserRepository {

    /**
     * Get User By Id
     *
     * @param id userId userId
     * @return VsUser
     */
    @Override
    public VsUser getUserById(String id) {
        VsUser vsUser = new VsUser();
        vsUser.setId(id);
        return vsUser;
    }

}
