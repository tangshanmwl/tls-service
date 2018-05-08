package com.tls.tlsservice.controller;

import com.tls.tlsservice.GenerateSignService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


/**
 * @title:GetSignController
 * @description
 * @author：maweil
 * @date： 2018/5/8 8:04
 */
@RestController
public class GetSignController {
    private Logger logger = LoggerFactory.getLogger(GetSignController.class);
    @Autowired
    private GenerateSignService generateSignService;


    @RequestMapping(value="/getSign")
    @ResponseBody
    public String  getSignByUserId(String userId){
        logger.info("获取登录sign服务请求参数userId：{}",userId);
        String sign = "";
        try {
            if(StringUtils.isEmpty(sign)){
                sign = generateSignService.genSign(userId);
            }
            logger.info("获取登录sign服务响应sign：{}",sign);

        } catch (Exception e) {
            logger.error("获取登录sign服务异常",e);
        }
        return sign;
    }
}
