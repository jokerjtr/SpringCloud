package com.jtr.serviceImp;

import com.jtr.dao.DeptDao;
import com.jtr.entriy.Dept;
import com.jtr.service.DeptService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author: lihuizhi
 * @date: 2020/7/17:21:25
 */
@Service
public class DeptServiceImpl implements DeptService {
    @Resource
    private DeptDao deptDao;
    @Override
    public Dept selectById(Integer deptno) {
        return deptDao.selectById(deptno);
    }

    @Override
    public List<Dept> selectAll() {
        return deptDao.selectAll();
    }

    @Override
    public Integer insertDept(Dept dept) {
        return deptDao.insertDept(dept);
    }

    @Override
    public Integer deleteDept(Integer deptno) {
        return deptDao.deleteDept(deptno);
    }
}
