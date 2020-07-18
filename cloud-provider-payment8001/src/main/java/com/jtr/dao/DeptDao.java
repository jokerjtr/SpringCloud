package com.jtr.dao;

import com.jtr.entriy.Dept;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author: lihuizhi
 * @date: 2020/7/17:21:15
 */
@Mapper
public interface DeptDao {
    public Dept selectById(@Param("deptno") Integer deptno);
    public List<Dept> selectAll();
    public Integer insertDept(Dept dept);
    public Integer deleteDept(@Param("deptno")Integer deptno);
}
