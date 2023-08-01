package com.ybb.service;

import com.ybb.dto.UserLoginDTO;
import com.ybb.entity.TabUserEntity;

public interface IUserService {

    TabUserEntity login(UserLoginDTO userLoginDTO);


}
