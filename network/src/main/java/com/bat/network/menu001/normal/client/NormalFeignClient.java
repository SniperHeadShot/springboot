package com.bat.network.menu001.normal.client;

import com.bat.network.menu001.BodyInfo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * NormalFeignClient
 *
 * @author ZhengYu
 * @version 1.0 2019/10/26 17:01
 **/
@FeignClient(name = "normal-verity", url = "${custom.serverUrl}")
public interface NormalFeignClient {

    /**
     * 模拟使用FeignClient发送Http请求
     *
     * @param param1   参数1
     * @param param2   参数2
     * @param header1  请求头1
     * @param header2  请求头2
     * @param bodyInfo 请求体
     * @author ZhengYu
     */
    @PostMapping("/verity")
    void verity(@RequestParam("param1") String param1,
                @RequestParam("param2") String param2,
                @RequestHeader("header1") String header1,
                @RequestHeader("header2") String header2,
                @RequestBody BodyInfo bodyInfo);
}
