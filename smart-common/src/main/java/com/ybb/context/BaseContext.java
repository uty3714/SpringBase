package com.ybb.context;

/**
 * 当前线程保存用户数据
 */
public class BaseContext {

    private static final ThreadLocal<SmartContextData> sThreadLocal = new ThreadLocal<>();

    public static void setCurrentData(SmartContextData data){
        sThreadLocal.set(data);
    }

    public static SmartContextData getCurrentData(){
        return sThreadLocal.get();
    }

    public static void removeData(){
        sThreadLocal.remove();
    }

}
