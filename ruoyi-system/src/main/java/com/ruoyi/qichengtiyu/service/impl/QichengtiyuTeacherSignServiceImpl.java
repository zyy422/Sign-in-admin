package com.ruoyi.qichengtiyu.service.impl;

import com.ruoyi.qichengtiyu.domain.QichengtiyuCourse;
import com.ruoyi.qichengtiyu.domain.QichengtiyuUser;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QichengtiyuTeacherSignServiceImpl {

    @Autowired
    SqlSession sqlSession;

    public List<QichengtiyuCourse> queryAllCourse(){
        return sqlSession.selectList("com.ruoyi.qichengtiyu.mapper.QichengtiyuCustom.selectAllCourse");
    }

    /**
     * 查询指定日期下没有签到的学生的名字
     */
    public List queryAllUserWithOutSign(long courseId){
        return sqlSession.selectList("com.ruoyi.qichengtiyu.mapper.QichengtiyuCustom.queryAllUserWithOutSign", courseId);
    }
}
