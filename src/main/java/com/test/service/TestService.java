package com.test.service;


import com.jisweb.common.CommonDao;
import com.test.vo.Test01VO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class TestService {

    @Autowired
    CommonDao commonDao;

    private final String sqlMapper = "com.test.mapper.TestSqlMapper.";

    @Transactional
    public int insertTest(Map<String,Object> paramMap){
        int result = commonDao.insert(sqlMapper + "insertTest",paramMap);
        return result;
    }

    @Transactional
    public int updateTest(Map<String,Object> paramMap){
        int result = commonDao.updete(sqlMapper + "updateTest",paramMap);
        return result;
    }

    @Transactional
    public int deleteTest(Map<String,Object> paramMap){
        int result = commonDao.delete(sqlMapper + "deleteTest",paramMap);
        return result;
    }

    public List<Test01VO> selectTest(String seq){

        String paramSeq = null;

        if(!"".equals(seq) && seq != null){
            paramSeq =seq;
        }

        return commonDao.selectList(sqlMapper + "selectTest",paramSeq);
    }
}
