package com.home.user.web.admin.ui.pages.user.helper.impl;

import com.home.user.services.user.dto.UserDto;
import com.home.user.web.admin.ui.pages.user.helper.UserPageHelper;
import com.home.user.web.admin.ui.pages.user.model.UserPageModel;
import com.home.user.web.facade.user.UserModelFacade;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Nonnull;

/**
 * Created: Nadya Dainelyan
 * DATE:    5/16/15
 * TIME:    12:18 AM
 */
public class UserPageHelperImpl implements UserPageHelper {

    @Autowired
    private UserModelFacade userModelFacade;

    @Override
    public void createUser(@Nonnull UserPageModel userPageModel) {

        final UserDto userDto = new UserDto();
        userDto.setName(userPageModel.getName());
        userDto.setFirstName(userPageModel.getFirstName());
        userDto.setSecondName(userPageModel.getSecondName());
        userDto.setPassword(userPageModel.getPassword());
        userDto.setCreated(userPageModel.getCreated());

        userModelFacade.createUser(userDto);
    }
}
