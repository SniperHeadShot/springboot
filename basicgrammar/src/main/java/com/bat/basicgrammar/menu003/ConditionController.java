package com.bat.basicgrammar.menu003;

import com.bat.basicgrammar.menu003.common.NeedInjectedBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 可以实现只有在特定条件满足时才启用一些配置
 *
 * @author ZhengYu
 * @version 1.0 2019/12/2 17:12
 **/
@RestController
@RequestMapping("/basicGrammar/menu003")
public class ConditionController {

    @Autowired
    private NeedInjectedBean needInjectedBean;

    @GetMapping("/test")
    public String testMethod() {
        needInjectedBean.selfIntroduction();
        return "succ";
    }
}
