package com.bat.basicgrammar.menu002.common;

import lombok.extern.slf4j.Slf4j;

/**
 * 需要被注入的bean1
 *
 * @author ZhengYu
 * @version 1.0 2019/12/2 16:19
 **/
@Slf4j
public class NeedInjectedBean1 {

    /**
     * 方法
     *
     * @author ZhengYu
     */
    public void selfIntroduction() {
        log.info("i am NeedInjectedBean1");
    }
}
