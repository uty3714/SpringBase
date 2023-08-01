package com.ybb.controller.app;

import com.ybb.constant.JwtClaimsConstant;
import com.ybb.dto.UserLoginDTO;
import com.ybb.entity.TabUserEntity;
import com.ybb.properties.JwtProperties;
import com.ybb.result.Result;
import com.ybb.service.IUserService;
import com.ybb.utils.JwtUtil;
import com.ybb.vo.UserVO;
import io.jsonwebtoken.Jwts;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/user")
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

//    @PostMapping(value = "/login",produces = "application/json;charset=UTF-8")
    @PostMapping(value = "/login")
    public String login(@RequestBody UserLoginDTO userLoginDTO) {
        log.info("用户登录: {}", userLoginDTO);
        TabUserEntity userEntity = mUserService.login(userLoginDTO);
        UserVO userVO = new UserVO();
        BeanUtils.copyProperties(userEntity, userVO);
        Map<String, Object> claims = new HashMap<>();
        claims.put(JwtClaimsConstant.USER_ID, userEntity.getUserId());
        //生成token
        String userToken = JwtUtil.createJWT(mJwtProperties.getJwtSecretKey(),
                mJwtProperties.getJwtTtl(),
                claims
        );
        userVO.setUserToken(userToken);
        return Result.success(userVO);
    }


}
