package com.bat.basicgrammar.menu002;

import com.bat.basicgrammar.menu002.common.NeedInjectedBean1;
import com.bat.basicgrammar.menu002.common.NeedInjectedBean2;
import com.bat.basicgrammar.menu002.common.NeedInjectedBean3;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 验证类
 *
 * @author ZhengYu
 * @version 1.0 2019/12/2 16:18
 **/
@RestController
@RequestMapping("/basicGrammar/menu002")
public class ImportTestController {

    @Autowired
    private NeedInjectedBean1 needInjectedBean1;

    @Autowired
    private NeedInjectedBean2 needInjectedBean2;

    @Autowired
    private NeedInjectedBean3 needInjectedBean3;

    @GetMapping("/test")
    public String testMethod() {
        needInjectedBean1.selfIntroduction();
        needInjectedBean2.selfIntroduction();
        needInjectedBean3.selfIntroduction();
        return "succ";
    }
}
