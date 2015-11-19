package com.share.test.dao;

import com.share.dao.CommentDao;
import com.share.daoimpl.CommentDaoImpl;
import com.share.domain.DynamicComment;
import org.junit.Test;

import java.sql.SQLException;
import java.util.Date;

/**
 * Created by WTJ on 2015/11/18.
 */
public class CommentTest {
    @Test
    public  void testadd() throws SQLException {
        CommentDao commentDao=new CommentDaoImpl();
        DynamicComment comment=new DynamicComment();
        comment.setDate(new Date());
     //   comment.setUserId();
        commentDao.addComment(comment);

    }
}
