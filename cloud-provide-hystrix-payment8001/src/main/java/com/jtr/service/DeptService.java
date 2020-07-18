package com.jtr.service;

import com.jtr.entriy.Dept;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/**
 * @author: lihuizhi
 * @date: 2020/7/17:21:24
 */
@Service
public interface DeptService {
    public Dept selectById( Integer deptno);
    public List<Dept> selectAll();
    public Integer insertDept(Dept dept);
    public Integer deleteDept(Integer deptno);

}
