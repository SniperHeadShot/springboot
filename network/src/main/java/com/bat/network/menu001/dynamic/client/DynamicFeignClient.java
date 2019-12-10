package com.bat.network.menu001.dynamic.client;

import com.bat.network.menu001.BodyInfo;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * DynamicFeignClient
 *
 * @author ZhengYu
 * @version 1.0 2019/10/26 17:01
 **/
public interface DynamicFeignClient {

    /**
     * 模拟使用FeignClient发送Http请求
     *
     * @param param1   参数1
     * @param param2   参数2
     * @param header1  请求头1
     * @param bodyInfo 请求体
     * @author ZhengYu
     */
    @PostMapping("/verity")
    void verity(@RequestParam("param1") String param1,
                @RequestParam("param2") String param2,
                @RequestHeader("header1") String header1,
                @RequestBody BodyInfo bodyInfo);
}
