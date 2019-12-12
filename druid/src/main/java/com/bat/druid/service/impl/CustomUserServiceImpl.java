package com.bat.druid.service.impl;

import com.bat.commoncode.util.UuidUtils;
import com.bat.druid.config.DataSourceContextHolder;
import com.bat.druid.dao.CustomUserDao;
import com.bat.druid.po.UserInfo;
import com.bat.druid.service.CustomUserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.StopWatch;

import javax.annotation.Resource;
import java.util.List;
import java.util.Random;
import java.util.stream.LongStream;

/**
 * CustomStructure ServiceImpl
 *
 * @author ZhengYu
 * @version 1.0 2019/12/10 11:44
 **/
@Slf4j
@Service
public class CustomUserServiceImpl implements CustomUserService {

    private static final Random RANDOM = new Random();

    private static final String[] ADDRESS_OPTIONS = {
            "上海市浦东新区六灶镇鹿达路28号汇领商墅66幢",
            "上海市奉贤区大亭公路999号",
            "上海市浦东新区横沔新镇川周公路3044号",
            "上海市徐汇区石龙路金牛苑731弄45号301室",
            "下盐公路248号",
            "上海市浦东新区川沙新镇六灶社区民义村1685号(南六公路与龄南路交汇处往南80米路西)"
    };

    private static final String[] USERNAME_OPTIONS = {
            "Marguerite",
            "Wilder",
            "Jenelle",
            "Brigitte",
            "Guinevere",
            "Johnson"
    };

    private static final String[] BIRTHDAY_OPTIONS = {
            "1995-05-18",
            "1996-04-02",
            "1997-02-23",
            "1988-08-04",
            "1979-01-11",
            "1970-09-30",
    };

    @Resource
    private CustomUserDao customUserDao;

    /**
     * 获取用户信息列表
     *
     * @param dbFlag   库
     * @param username 用户名
     * @return java.util.List<com.bat.druid.po.UserInfo>
     * @author ZhengYu
     */
    @Override
    public List<UserInfo> getCustomUserList(String dbFlag, String username) {
        DataSourceContextHolder.setRouteKey(dbFlag);
        StopWatch stopWatch = new StopWatch();
        stopWatch.start("测试查询 - 不开启缓存");
        List<UserInfo> result = customUserDao.getUserInfoList(username);
        stopWatch.stop();
        log.info("查询任务执行结果集长度:[{}], 耗时详情 ===> [{}]", result == null ? 0 : result.size(), stopWatch.prettyPrint());
        return result;
    }

    /**
     * 新增用户列表
     *
     * @param dbFlag 库
     * @param count  数量
     * @return boolean
     * @author ZhengYu
     */
    @Override
    public boolean insertCustomUser(String dbFlag, long count) {
        DataSourceContextHolder.setRouteKey(dbFlag);
        StopWatch stopWatch = new StopWatch();
        LongStream.range(0, count).forEach(index -> {
            UserInfo userInfo = new UserInfo();
            userInfo.setUserUuid(UuidUtils.getRandomUuid());
            userInfo.setUsername(USERNAME_OPTIONS[RANDOM.nextInt(USERNAME_OPTIONS.length)]);
            userInfo.setPassword(DigestUtils.md5Hex(Long.toString(index)));
            userInfo.setBirthday(BIRTHDAY_OPTIONS[RANDOM.nextInt(BIRTHDAY_OPTIONS.length)]);
            userInfo.setAddress(ADDRESS_OPTIONS[RANDOM.nextInt(ADDRESS_OPTIONS.length)]);

            stopWatch.start(String.format("测试添加 [%s]", userInfo.getUserUuid()));
            customUserDao.insertUser(userInfo);
            stopWatch.stop();
        });
        log.info("添加任务执行结果: [{}], 耗时详情 ===> [{}]", true, stopWatch.prettyPrint());
        return true;
    }
}
