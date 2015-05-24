package com.home.user.services.user.impl;

import com.home.user.persistence.repository.user.UserRepository;
import com.home.user.services.user.UserService;
import com.home.user.services.user.dto.UserDto;
import com.home.user.services.user.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created: Nadya Dainelyan
 * DATE:    5/14/15
 * TIME:    11:47 AM
 */
@Service
public class UserServiceImpl implements UserService {


    /*Dependencies*/
    @Autowired
    private UserRepository userRepository;


    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    @Override
    public User createUser(final User user) {
        return userRepository.save(user);
    }

    @Override
    public User createUser(UserDto userDto) {
        return null;
    }
}
