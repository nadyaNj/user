package com.home.user.web.admin.ui.pages.user.helper.impl;

import com.home.user.web.admin.ui.pages.user.helper.UserPageHelper;
import com.home.user.web.admin.ui.pages.user.model.UserPageModel;
import com.home.user.web.facade.user.UserModelFacade;
import com.home.user.web.facade.user.impl.UserFacadeImpl;
import com.home.user.web.facade.util.UniversalConverter;
import com.home.user.web.facade.util.UniversalConverterImpl;

import javax.annotation.Nonnull;

/**
 * Created: Nadya Dainelyan
 * DATE:    5/16/15
 * TIME:    12:18 AM
 */
public class UserPageHelperImpl implements UserPageHelper {
    @Override
    public void createUser(@Nonnull UserPageModel userPageModel) {

        UserModelFacade userModelFacade = new UserFacadeImpl();
        UniversalConverter universalConverter = new UniversalConverterImpl();
        userModelFacade.createUser(universalConverter.convert(userPageModel, UserModelFacade.class));
    }
}
