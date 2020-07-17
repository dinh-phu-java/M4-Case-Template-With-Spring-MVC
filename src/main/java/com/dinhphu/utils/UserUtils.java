package com.dinhphu.utils;

import com.dinhphu.dto.UserDTO;
import com.dinhphu.model.User;
import com.dinhphu.model.UserRole;

public class UserUtils {

    public static User setUserFromUserDTO(UserDTO userDTO, String imageUrl, UserRole role){
        User user=new User();
        user.setDateOfBirth(userDTO.getDateOfBirth());
        user.setName(userDTO.getName());
        user.setDateOfBirth(userDTO.getDateOfBirth());
        user.setAvatarUrl(imageUrl);
        user.setUserRole(role);
        return user;
    }
}
