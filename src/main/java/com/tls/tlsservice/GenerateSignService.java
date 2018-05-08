package com.tls.tlsservice;

import com.tls.sigcheck.tls_sigcheck;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

/**
 * @title:GenerateSign
 * @description
 * @author：maweil
 * @date： 2018/5/7 14:18
 */
@Service
public class GenerateSignService {


    @Value("${dynamic.file.path}")
    private String dynamicFilePath;

    @Value("${private.key.path}")
    private String privateKeyPath;

    @Value("${sdk.appid}")
    private String sdkAppid;

    public String genSign(String userId) throws Exception{
        String sign = "";

            tls_sigcheck demo = new tls_sigcheck();

            demo.loadJniLib(dynamicFilePath);
            File priKeyFile = new File(privateKeyPath);
            StringBuilder strBuilder = new StringBuilder();
            String s = "";

            BufferedReader br = new BufferedReader(new FileReader(priKeyFile));
            while ((s = br.readLine()) != null) {
                strBuilder.append(s + '\n');
            }
            br.close();
            String priKey = strBuilder.toString();
            int ret = demo.tls_gen_signature_ex2(sdkAppid, userId, priKey);

            if (0 != ret) {
                System.out.println("ret " + ret + " " + demo.getErrMsg());
            } else {
                sign = demo.getSig();
                System.out.println("sig:\n" + demo.getSig());
            }

       /* File pubKeyFile = new File("public.pem");
        br = new BufferedReader(new FileReader(pubKeyFile));
        strBuilder.setLength(0);
        while ((s = br.readLine()) != null) {
            strBuilder.append(s + '\n');
        }
        br.close();
        String pubKey = strBuilder.toString();
        ret = demo.tls_check_signature_ex2(demo.getSig(), pubKey, "1400000267", "xiaojun");
        if (0 != ret) {
            System.out.println("ret " + ret + " " + demo.getErrMsg());
        }
        else
        {
            System.out.println("--\nverify ok -- expire time " + demo.getExpireTime() + " -- init time " + demo.getInitTime());
        }*/

        return sign;
    }

}
