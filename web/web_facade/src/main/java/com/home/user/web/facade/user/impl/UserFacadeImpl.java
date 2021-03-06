package com.home.user.web.facade.user.impl;


import com.home.user.persistence.repository.user.UserRepository;
import com.home.user.services.user.UserService;
import com.home.user.services.user.dto.UserDto;
import com.home.user.services.user.model.User;
import com.home.user.web.facade.user.UserFacade;
import com.home.user.web.facade.user.model.UserFacadeModel;
import com.home.user.web.facade.util.UniversalConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Nonnull;
import java.time.LocalDateTime;
import java.util.List;

/**
 * Created: Nadya Dainelyan
 * DATE:    5/14/15
 * TIME:    11:47 AM
 */
@Service
public class UserFacadeImpl implements UserFacade {


    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private UniversalConverter universalConverter;


    @Nonnull
    @Override
    public UserFacadeModel getUserModelById(@Nonnull final Long id) {
        return null;

    }

    @Nonnull
    @Override
    public List<UserFacadeModel> getAll() {
        return universalConverter.convertList(userRepository.findAll(), UserFacadeModel.class);
    }

    @Nonnull
    @Override
    public UserFacadeModel createUser(@Nonnull final UserDto userDto) {
        User user = new User();
        userDto.updateDomainEntityModelProperties(user);
        user.setCreated(LocalDateTime.now());
        user.setUpdated(LocalDateTime.now());

        user = userService.createUser(user);

        return universalConverter.convert(user, UserFacadeModel.class);
    }
}
