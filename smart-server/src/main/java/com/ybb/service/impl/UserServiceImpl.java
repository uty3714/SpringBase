package com.ybb.service.impl;

import com.alibaba.druid.util.StringUtils;
import com.ybb.constant.MessageConstant;
import com.ybb.constant.StatusConstant;
import com.ybb.dto.UserLoginDTO;
import com.ybb.entity.TabUserEntity;
import com.ybb.exception.account.AccountNotFoundException;
import com.ybb.exception.account.PasswordIncorrectException;
import com.ybb.exception.account.UserDisableException;
import com.ybb.mapper.UserMapper;
import com.ybb.service.IUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Transactional
@Service
@Slf4j
public class UserServiceImpl implements IUserService {

    private UserMapper mUserMapper;

    @Autowired
    public void setUserMapper(UserMapper userMapper) {
        this.mUserMapper = userMapper;
    }

    /**
     * 用户登录
     *
     * @param userLoginDTO 前端传递过来的dto
     * @return 当前用户信息
     */
    @Override
    public TabUserEntity login(UserLoginDTO userLoginDTO) {
        TabUserEntity tabUserEntity = mUserMapper.getUserByUserName(userLoginDTO.getClinicId(), userLoginDTO.getUserName());
        log.info("查询登陆用户结果: {}" , tabUserEntity);
        if (tabUserEntity == null) {
            throw new AccountNotFoundException(userLoginDTO.getUserName() + MessageConstant.ACCOUNT_NOT_FOUND);
        }
        //检测用户状态
        if (StatusConstant.DISABLE.equals(tabUserEntity.getUserStatus())) {
            throw new UserDisableException(userLoginDTO.getUserName() + MessageConstant.DISABLE_STATUS);
        }

        //检测密码
        if (!StringUtils.equals(userLoginDTO.getPassWord(), tabUserEntity.getUserPwd())) {
            throw new PasswordIncorrectException(MessageConstant.PASSWORD_INCORRECT);
        }
        return tabUserEntity;
    }
}
