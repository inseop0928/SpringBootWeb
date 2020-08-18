package com.jisweb.common;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("commonDao")
public class CommonDao {

    protected Log log = LogFactory.getLog(CommonDao.class);

    @Autowired
    private SqlSessionTemplate sqlSessionTemplate;

    @Autowired
    private SqlSession sqlSession;

    protected void printQueryId(String queryId){
        if(log.isDebugEnabled()){
            log.debug("Query : " + queryId);
        }
    }

    public int insert(String queryId,Object params){

        printQueryId(queryId);
        int result = sqlSession.insert(queryId,params);
       // sqlSession.commit();
        return result;
    }

    public int updete(String queryId,Object params){

        printQueryId(queryId);
        return sqlSessionTemplate.update(queryId,params);
    }

    public int delete(String queryId,Object params){
        printQueryId(queryId);
        return sqlSessionTemplate.delete(queryId,params);
    }

    public Object selectOne(String queryId){

        printQueryId(queryId);
        return sqlSessionTemplate.selectOne(queryId);
    }

    public Object selectOne(String queryId, Object params){

        printQueryId(queryId);
       return sqlSessionTemplate.selectOne(queryId,params);
    }

    public List selectList(String queryId){

        return sqlSessionTemplate.selectList(queryId);
    }

    public List selectList(String queryId, Object params){

        return sqlSessionTemplate.selectList(queryId,params);
    }
}
