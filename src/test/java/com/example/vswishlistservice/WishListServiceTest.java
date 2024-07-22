package com.example.vswishlistservice;

import com.example.vswishlistservice.domain.VsUser;
import com.example.vswishlistservice.domain.WishList;
import com.example.vswishlistservice.repository.VsUserRepository;
import com.example.vswishlistservice.service.WishListService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@TestInstance(TestInstance.Lifecycle.PER_METHOD)
@ExtendWith(MockitoExtension.class)
public class WishListServiceTest {

    @InjectMocks
    private WishListService wishListService;

    @Mock
    private VsUserRepository vsUserRepository;

    @Test
    public void createWishList_Success() {
        // Prepare
        VsUser vsUser = new VsUser();
        vsUser.setId("123456");
        when(vsUserRepository.getUserById("123456")).thenReturn(vsUser);

        // Invoke
        WishList wishList = wishListService.createWishList("123456");

        // Assert
        assertNotNull(wishList);
        verify(vsUserRepository, times(1)).getUserById("123456");
    }

    @Test
    public void createWishList_ThrowException_WhenWishListExists() {
        // Prepare
        VsUser vsUser = new VsUser();
        vsUser.setId("123456");
        vsUser.setWishList(new WishList());
        when(vsUserRepository.getUserById("123456")).thenReturn(vsUser);

        // Invoke
        assertThrows(UnsupportedOperationException.class, () -> wishListService.createWishList("123456"));

        // Assert

    }


}
