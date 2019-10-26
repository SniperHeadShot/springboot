package com.bat.network.menu001.normal.service.impl;

import com.bat.network.menu001.BodyInfo;
import com.bat.network.menu001.normal.client.NormalFeignClient;
import com.bat.network.menu001.normal.service.NormalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 服务层
 *
 * @author ZhengYu
 * @version 1.0 2019/10/26 17:20
 **/
@Service
public class NormalServiceImpl implements NormalService {

    @Autowired
    private NormalFeignClient normalFeignClient;

    /**
     * 发送请求
     *
     * @author ZhengYu
     */
    @Override
    public void sendHttpRequest() {
        BodyInfo bodyInfo = new BodyInfo();
        bodyInfo.setUsername("username");
        bodyInfo.setPassword("password");
        normalFeignClient.verity("param1", "param2", "header1", "header2", bodyInfo);
    }
}
