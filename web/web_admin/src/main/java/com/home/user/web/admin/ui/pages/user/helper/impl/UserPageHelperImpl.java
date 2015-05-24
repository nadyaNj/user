package com.home.user.web.admin.ui.pages.user.helper.impl;

import com.home.user.services.user.dto.UserDto;
import com.home.user.web.admin.ui.pages.user.helper.UserPageHelper;
import com.home.user.web.admin.ui.pages.user.model.UserPageModel;
import com.home.user.web.facade.user.UserFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.Nonnull;

/**
 * Created: Nadya Dainelyan
 * DATE:    5/16/15
 * TIME:    12:18 AM
 */
@Component
public class UserPageHelperImpl implements UserPageHelper {

    /*Dependencies*/
    @Autowired
    private UserFacade userFacade;


    @Override
    public void createUser(@Nonnull final UserPageModel pageModel) {

        final UserDto userDto = new UserDto();

        userDto.setName(pageModel.getName());
        userDto.setFirstName(pageModel.getFirstName());
        userDto.setSecondName(pageModel.getSecondName());
        userDto.setPassword(pageModel.getPassword());

        userFacade.createUser(userDto);
    }
}
