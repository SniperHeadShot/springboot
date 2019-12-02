package com.bat.basicgrammar.menu003.common;

import lombok.extern.slf4j.Slf4j;

/**
 * 需要被注入的bean
 *
 * @author ZhengYu
 * @version 1.0 2019/12/2 16:19
 **/
@Slf4j
public class NeedInjectedBean {

    /**
     * 方法
     *
     * @author ZhengYu
     */
    public void selfIntroduction() {
        log.info("i am NeedInjectedBean");
    }
}
