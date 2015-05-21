package com.home.user.services.user;

import com.home.user.services.user.dto.UserDto;
import com.home.user.services.user.model.User;

/**
 * Created: Nadya Dainelyan
 * DATE:    5/15/15
 * TIME:    12:52 PM
 */

public interface UserService {


    User createUser(User user);


    User createUser(UserDto userDto);

}
