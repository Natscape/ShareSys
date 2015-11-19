package com.share.domain;
import java.util.Date;

public class DynamicComment {
    private long commentId;
    private long dynamicId;
    private long userId;//the dynamic be commentted
    private long lastCommentId;//if lastCommentId=0,说明这不是回复内容
    private String content;
    private Date date;

    public long getCommentId() {
        return commentId;
    }

    public void setCommentId(long commentId) {
        this.commentId = commentId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public long getDynamicId() {
        return dynamicId;
    }

    public void setDynamicId(long dynamicId) {
        this.dynamicId = dynamicId;
    }

    public long getLastCommentId() {
        return lastCommentId;
    }

    public void setLastCommentId(long lastCommentId) {
        this.lastCommentId = lastCommentId;
    }

    @Override
    public String toString() {
        return "DynamicComment{" +
                "commentId=" + commentId +
                ", dynamicId=" + dynamicId +
                ", userId=" + userId +
                ", lastCommentId=" + lastCommentId +
                ", content='" + content + '\'' +
                ", date=" + date +
                '}';
    }
}
