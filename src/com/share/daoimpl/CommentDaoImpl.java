package com.share.daoimpl;

import com.share.dao.CommentDao;
import com.share.dbutil.DbTools;
import com.share.domain.DynamicComment;
import org.apache.commons.dbutils.BasicRowProcessor;
import org.apache.commons.dbutils.BeanProcessor;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.RowProcessor;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by WTJ on 2015/11/18.
 */
public class CommentDaoImpl implements CommentDao {

    @Override
    public List<DynamicComment> getComments(long dynamicId) throws SQLException {
        QueryRunner queryRunner = new QueryRunner(DbTools.getDatasource());
        String sql = "select * from Dynamic_comment where dynamic_id=?";
        Object []param={dynamicId};
    return  queryRunner.query(sql,new BeanListHandler<DynamicComment>(DynamicComment.class,getProcessor()),param);

    }

    @Override//先判断role是被评论者还是回复者
    public boolean deleteComment( long commentId) throws SQLException {
     QueryRunner queryRunner=new QueryRunner(DbTools.getDatasource());
        String sql="delete from Dynamic_comment where comment_id=?";
        Object []param={commentId};
        queryRunner.update(sql,param);
        return true;
    }

    @Override
    public void deleteDynamicAllComment(long dynamicId) throws SQLException {
        QueryRunner queryRunner = new QueryRunner(DbTools.getDatasource());
        String sql = "delete from Dynamic_comment where dynamic_id=?";
        Object []param={dynamicId};
        queryRunner.update(sql,param);

    }

    @Override
    public DynamicComment getComment(long lastCommentId) throws SQLException {
        QueryRunner queryRunner = new QueryRunner(DbTools.getDatasource());
        String sql = "select * from Dynamic_comment where comment_id=?";
        Object[] param = {lastCommentId};
        return queryRunner.query(sql, getBeanHandler(), param);

    }

    @Override
    public Long addComment(DynamicComment comment) throws SQLException {
        QueryRunner queryRunner = new QueryRunner(DbTools.getDatasource());
        String sql = "insert into Dynamic_comment(dynamic_id,user_id,user_id,Dyn_comment_id,content,date)" +
                " values(?,?,?,?,?)";
        Object[] param = {comment.getDynamicId(), comment.getUserId(), comment.getLastCommentId(),
                comment.getContent(), comment.getDate()};
        Long commentId = queryRunner.insert(sql, new ScalarHandler<Long>(), param);
        return commentId;

    }

    /**
     * 这个应该使用泛型。。。。。。。因为每个dao都差不多涉及到
     *
     * @return
     */
    private RowProcessor getProcessor() {
        Map<String, String> beanMap = new HashMap<>();
        beanMap.put("comment_id", "commentId");
        beanMap.put("dynamic_id", "dynamicId");
        beanMap.put("user_id", "userId");
        beanMap.put("Dyn_comment_id", "lastCommentId");
        beanMap.put("content", "content");
        beanMap.put("date", "date");
        BeanProcessor beanProcessor = new BeanProcessor(beanMap);
        RowProcessor rowProcessor = new BasicRowProcessor(beanProcessor);
        return rowProcessor;
    }

    private BeanHandler<DynamicComment> getBeanHandler() {
        return new BeanHandler<DynamicComment>(DynamicComment.class, getProcessor());
    }
}

