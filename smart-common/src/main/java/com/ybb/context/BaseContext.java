package com.ybb.context;

/**
 * 当前线程保存用户数据
 */
public class BaseContext {

    private static final ThreadLocal<String> sThreadLocal = new ThreadLocal<>();

    public static void setCurrentUserId(String userId){
        sThreadLocal.set(userId);
    }

    public static String getCurrentUserId(){
        return sThreadLocal.get();
    }

    public static void removeData(){
        sThreadLocal.remove();
    }

}
