package com.ybb.service.impl;

import com.alibaba.druid.util.StringUtils;
import com.ybb.constant.JwtClaimsConstant;
import com.ybb.constant.MessageConstant;
import com.ybb.constant.StatusConstant;
import com.ybb.context.BaseContext;
import com.ybb.dto.UserLoginDTO;
import com.ybb.dto.UserTokenLoginDTO;
import com.ybb.entity.TabUserEntity;
import com.ybb.exception.account.*;
import com.ybb.mapper.UserMapper;
import com.ybb.properties.JwtProperties;
import com.ybb.service.IUserService;
import com.ybb.utils.JwtUtil;
import io.jsonwebtoken.Claims;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Transactional
@Service
@Slf4j
public class UserServiceImpl implements IUserService {

    private UserMapper mUserMapper;

    private JwtProperties jwtProperties;


    @Autowired
    public void setUserMapper(UserMapper userMapper) {
        this.mUserMapper = userMapper;
    }
    @Autowired
    public void setJwtProperties(JwtProperties jwtProperties){
        this.jwtProperties = jwtProperties;
    }



    /**
     * 用户登录
     *
     * @param userLoginDTO 前端传递过来的dto
     * @return 当前用户信息
     */
    @Override
    public TabUserEntity login(UserLoginDTO userLoginDTO) {
        TabUserEntity tabUserEntity = mUserMapper.getUserByUserName(userLoginDTO.getUserName());
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

    /**
     * 用户token登录
     * @param tokenLoginDTO token dto
     * @return 当前用户信息
     */
    @Override
    public TabUserEntity tokenLogin(UserTokenLoginDTO tokenLoginDTO) {
        log.info("解析token: {}", tokenLoginDTO.getToken());
        Claims claims = JwtUtil.parseJWT(jwtProperties.getJwtSecretKey(), tokenLoginDTO.getToken());
        if (claims != null && claims.size() > 0) {
            String currentUserId = String.valueOf(claims.get(JwtClaimsConstant.USER_ID));
            if(StringUtils.isEmpty(currentUserId)){
                throw new UserInfoDataException(MessageConstant.CURRENT_USER_ID + null + MessageConstant.DATA_EXCEPTION);
            }
            TabUserEntity tabUserEntity = mUserMapper.getUserByUserId(Long.valueOf(currentUserId));
            if (tabUserEntity == null) {
                throw new AccountNotFoundException(MessageConstant.CURRENT_USER_ID + currentUserId + MessageConstant.ACCOUNT_NOT_FOUND);
            }
            if (StatusConstant.DISABLE.equals(tabUserEntity.getUserStatus())) {
                throw new UserDisableException(MessageConstant.CURRENT_USER_ID + currentUserId + MessageConstant.DISABLE_STATUS);
            }
            return tabUserEntity;
        }else{
            throw new UserTokenParseException(MessageConstant.USER_TOKEN_PARSE_ERROR);
        }
    }

}
