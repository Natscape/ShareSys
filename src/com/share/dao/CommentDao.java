package com.share.dao;

import com.share.domain.DynamicComment;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by WTJ on 2015/11/17.
 */
public interface CommentDao {
    //获得当前动态的所有评论并按时间和评论回复次序排序
    public List<DynamicComment> getComments(long dynamicId) throws SQLException;
    //只有评论者和被评论者才有权限删除评论
    public  boolean deleteComment(long commentId) throws SQLException;
    //当动态被删除时删除该动态的所有评论
    public void deleteDynamicAllComment(long dynamicId) throws SQLException;

    public DynamicComment getComment(long lastCommentId) throws SQLException;

    public Long addComment(DynamicComment comment) throws SQLException;
}
