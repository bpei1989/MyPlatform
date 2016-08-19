package com.myplatform.web.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.myplatform.web.entity.TestCase;


public interface TestCaseDao {
	 /**
     * 根据偏移量查询可用商品列表
     *
     * @param offset
     * @param limit
     * @return
     */
    List<TestCase> queryAll(@Param("offset") int offset, @Param("limit") int limit);
}
