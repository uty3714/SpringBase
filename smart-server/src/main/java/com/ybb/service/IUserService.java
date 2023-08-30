package com.ybb.service;

import com.ybb.dto.UserLoginDTO;
import com.ybb.dto.UserTokenLoginDTO;
import com.ybb.entity.TabUserEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

public interface IUserService {

    TabUserEntity login(UserLoginDTO userLoginDTO);

    TabUserEntity tokenLogin(UserTokenLoginDTO tokenLoginDTO);

}
