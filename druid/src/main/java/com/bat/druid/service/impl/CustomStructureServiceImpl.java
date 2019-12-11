package com.bat.druid.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.bat.commoncode.entity.CustomStructure;
import com.bat.druid.config.DataSourceContextHolder;
import com.bat.druid.dao.CustomStructureDao;
import com.bat.druid.service.CustomStructureService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * CustomStructure ServiceImpl
 *
 * @author ZhengYu
 * @version 1.0 2019/12/10 11:44
 **/
@Slf4j
@Service
public class CustomStructureServiceImpl implements CustomStructureService {

    @Autowired
    private CustomStructureDao customStructureDao;

    /**
     * 获取所有数据
     *
     * @param dbFlag 数据源标识
     * @return java.util.List<com.bat.commoncode.entity.CustomStructure>
     * @author ZhengYu
     */
    @Override
    public List<CustomStructure> getCustomStructureList(String dbFlag) {
        DataSourceContextHolder.setRouteKey(dbFlag);
        return customStructureDao.getCustomStructureList();
    }

    /**
     * 新增一条数据
     *
     * @param dbFlag          数据源标识
     * @param customStructure 数据
     * @return boolean
     * @author ZhengYu
     */
    @Override
    public boolean insertCustomStructure(String dbFlag, CustomStructure customStructure) {
        log.info("库[{}] 新增一条数据 ==> [{}]", dbFlag, JSONObject.toJSONString(customStructure));
        DataSourceContextHolder.setRouteKey(dbFlag);
        return customStructureDao.insertCustomStructure(customStructure) > 0;
    }
}
