package br.com.edielsonassis.authuser.mapper;

import java.time.LocalDateTime;
import java.time.ZoneId;

import org.springframework.beans.BeanUtils;

import br.com.edielsonassis.authuser.dtos.UserDto;
import br.com.edielsonassis.authuser.models.UserModel;
import br.com.edielsonassis.authuser.models.enums.UserStatus;
import br.com.edielsonassis.authuser.models.enums.UserType;

public class UserMapper {

    private static final String ZONE_ID = "America/Sao_Paulo";
    
    private UserMapper() {}

    public static UserModel convertDtoToModel(UserDto userDto) {
        var userModel = new UserModel();
        BeanUtils.copyProperties(userDto, userModel);
        userModel.setUserStatus(UserStatus.ACTIVE);
        userModel.setUserType(UserType.STUDENT);
        userModel.setCreationDate(LocalDateTime.now(ZoneId.of(ZONE_ID)));
        userModel.setLastUpdateDate(LocalDateTime.now(ZoneId.of(ZONE_ID)));
        return userModel;
    }

    public static UserModel updateUser(UserModel userModel, UserDto userDto) {
        userModel.setFullName(userDto.getFullName());
        userModel.setPhoneNumber(userDto.getPhoneNumber());
        userModel.setLastUpdateDate(LocalDateTime.now(ZoneId.of(ZONE_ID)));
        return userModel;
    }

    public static UserModel updatePassword(UserModel userModel, UserDto userDto) {
        userModel.setPassword(userDto.getPassword());
        userModel.setLastUpdateDate(LocalDateTime.now(ZoneId.of(ZONE_ID)));
        return userModel;
    }

    public static UserModel updateImage(UserModel userModel, UserDto userDto) {
        userModel.setImgUrl(userDto.getImgUrl());
        userModel.setLastUpdateDate(LocalDateTime.now(ZoneId.of(ZONE_ID)));
        return userModel;
    }
}