package com.ybb.mapper;

import com.ybb.entity.TabUserEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {

    /**
     * 根据用户名查询该用户的基本信息
     * @param userName userName
     * @return 用户信息
     */
    //@Select("SELECT user_id,clinic_id,user_name, user_pwd,doctor_name,user_sex, user_id_card, user_phone, user_role, user_remark FROM tab_user WHERE user_name = #{userName};")
    TabUserEntity getUserByUserName(String userName);

    /**
     * 根据用户id查询该用户的信息
     * @param userId userId
     * @return userInfo
     */
    //@Select("SELECT user_id,clinic_id,user_name, user_pwd,doctor_name,user_sex, user_id_card, user_phone, user_role, user_remark FROM tab_user WHERE user_id = #{userId};")
    TabUserEntity getUserByUserId(Long userId);

}
