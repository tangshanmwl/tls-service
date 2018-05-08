package com.tls.tlsservice;

import java.util.HashMap;


import java.util.Map;

/**
 * @title:ResponseUtil
 * @description
 * @author：maweil
 * @date： 2018/5/8 11:53
 */
public class ResponseUtil {

    public static Map buildSucessResp(Map data){
        Map<String,Object> retMap = new HashMap<String,Object>();
        retMap.put("code","0000");
        retMap.put("msg","成功");
        retMap.put("data",data);
        return retMap;
    }

    public static Map buildFailedResp(){
        Map<String,Object> retMap = new HashMap<String,Object>();
        retMap.put("code","9999");
        retMap.put("msg","异常");
        retMap.put("data","");
        return retMap;
    }
}
