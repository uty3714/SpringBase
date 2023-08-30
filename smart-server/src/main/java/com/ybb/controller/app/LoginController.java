package com.ybb.controller.app;

import com.ybb.constant.JwtClaimsConstant;
import com.ybb.dto.UserLoginDTO;
import com.ybb.dto.UserTokenLoginDTO;
import com.ybb.entity.TabUserEntity;
import com.ybb.properties.JwtProperties;
import com.ybb.result.Result;
import com.ybb.service.IUserService;
import com.ybb.utils.JwtUtil;
import com.ybb.vo.UserVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * 登陆相关接口
 */
@RestController
@RequestMapping("/api/user")
@CrossOrigin
@Slf4j
public class LoginController {

    private IUserService mUserService;
    private JwtProperties mJwtProperties;


    @Autowired
    public void setUserService(IUserService userService) {
        this.mUserService = userService;
    }

    @Autowired
    public void setJwtProperties(JwtProperties jwtProperties) {
        this.mJwtProperties = jwtProperties;
    }


    @PostMapping("/tokenLogin")
    public String tokenLogin(@RequestBody UserTokenLoginDTO tokenLoginDTO){
        log.info("用户token登录: {}", tokenLoginDTO);
        TabUserEntity userEntity = mUserService.tokenLogin(tokenLoginDTO);
        UserVO userVO = tabCopyVO(userEntity);
        return Result.success(userVO);
    }


    @PostMapping(value = "/login")
    public String login(@RequestBody UserLoginDTO userLoginDTO) {
        log.info("用户登录: {}", userLoginDTO);
        TabUserEntity tabUserEntity = mUserService.login(userLoginDTO);
        UserVO userVO = tabCopyVO(tabUserEntity);
        return Result.success(userVO);
    }


    /**
     * 数据库entity对象转vo对象
     */
    private UserVO tabCopyVO(TabUserEntity tabUserEntity){
        UserVO userVO = new UserVO();
        BeanUtils.copyProperties(tabUserEntity, userVO);
        Map<String, Object> claims = new HashMap<>();
        claims.put(JwtClaimsConstant.USER_ID, tabUserEntity.getUserId());
        //生成token
        String userToken = JwtUtil.createJWT(mJwtProperties.getJwtSecretKey(),
                mJwtProperties.getJwtTtl(),
                claims
        );
        userVO.setUserToken(userToken);
        return userVO;
    }

}
