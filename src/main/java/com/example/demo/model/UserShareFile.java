package com.example.demo.model;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author hujing
 * @since 2019-05-11
 */
public class UserShareFile implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * USER_FILE的id
     */
    @TableId("SHARE_FILE_ID")
    private String shareFileId;

    /**
     * 分享有效时间：day,week,month,year
     */
    @TableField("SHARE_TIME")
    private String shareTime;

    /**
     * 分享类型：key(需要密码),NO(公开)
     */
    @TableField("SHARE_TYPE")
    private String shareType;

    /**
     * 分享时间
     */
    @TableField("FILE_OPTION_DATA")
    private String fileOptionData;

    /**
     * 获取分享文件的token
     */
    @TableField("FILE_TOKEN")
    private String fileToken;


    public String getShareFileId() {
        return shareFileId;
    }

    public void setShareFileId(String shareFileId) {
        this.shareFileId = shareFileId;
    }

    public String getShareTime() {
        return shareTime;
    }

    public void setShareTime(String shareTime) {
        this.shareTime = shareTime;
    }

    public String getShareType() {
        return shareType;
    }

    public void setShareType(String shareType) {
        this.shareType = shareType;
    }

    public String getFileOptionData() {
        return fileOptionData;
    }

    public void setFileOptionData(String fileOptionData) {
        this.fileOptionData = fileOptionData;
    }

    public String getFileToken() {
        return fileToken;
    }

    public void setFileToken(String fileToken) {
        this.fileToken = fileToken;
    }

    @Override
    public String toString() {
        return "UserShareFile{" +
        "shareFileId=" + shareFileId +
        ", shareTime=" + shareTime +
        ", shareType=" + shareType +
        ", fileOptionData=" + fileOptionData +
        ", fileToken=" + fileToken +
        "}";
    }
}
