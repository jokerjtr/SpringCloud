package com.jtr.serviceImp;

import com.jtr.entriy.Dept;
import com.jtr.service.DeptService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author: lihuizhi
 * @date: 2020/7/17:21:57
 */
@Service
public class DeptTrans {
    @Resource
    private DeptService deptService;
    public void inserdel(Dept dept){
        System.out.println(Thread.currentThread().getName()+"开始插入");
        deptService.insertDept(dept);
        System.out.println(Thread.currentThread().getName()+"开始删除");
        deptService.deleteDept(dept.getDeptno());
    }
}
