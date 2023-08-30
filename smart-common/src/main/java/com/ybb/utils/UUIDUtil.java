package com.ybb.utils;

import java.util.UUID;

public class UUIDUtil {

    private static UUIDUtil instance;

    public static UUIDUtil get() {
        if (instance == null) {
            instance = new UUIDUtil();
        }
        return instance;
    }

    private UUIDUtil() {
    }

    /**
     * 获取一个uuid
     *
     * @return uuid
     */
    public String getUUID() {
        String uuid = UUID.randomUUID().toString();
        uuid = uuid.replace("-", "");
        return uuid;
    }

}
