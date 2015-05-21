package com.home.user.web.facade.user;


import com.home.user.services.user.dto.UserDto;
import com.home.user.web.facade.user.model.UserFacadeModel;

import javax.annotation.Nonnull;
import java.util.List;

/**
 * Created by nadya on 5/14/15.
 */
public interface UserModelFacade {


    @Nonnull
    UserFacadeModel getUserModelById(@Nonnull final Long id);


    @Nonnull
    List<UserFacadeModel> getAll();
    
    @Nonnull
    UserModelFacade createUser(final UserDto userDto);


}
