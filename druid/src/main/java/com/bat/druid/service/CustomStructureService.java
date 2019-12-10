package com.bat.druid.service;

import com.bat.commoncode.entity.CustomStructure;

import java.util.List;

/**
 * CustomStructure Service
 *
 * @author ZhengYu
 * @version 1.0 2019/12/10 11:38
 **/
public interface CustomStructureService {

    /**
     * 获取所有数据
     *
     * @param dbFlag 数据源标识
     * @return java.util.List<com.bat.commoncode.entity.CustomStructure>
     * @author ZhengYu
     */
    List<CustomStructure> getCustomStructureList(String dbFlag);

    /**
     * 新增一条数据
     *
     * @param dbFlag          数据源标识
     * @param customStructure 数据
     * @return boolean
     * @author ZhengYu
     */
    boolean insertCustomStructure(String dbFlag, CustomStructure customStructure);
}
