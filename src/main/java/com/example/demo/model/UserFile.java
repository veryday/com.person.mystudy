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
public class UserFile implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId("FILE_ID")
    private String fileId;

    /**
     * 文件名字
     */
    @TableField("FILE_NAME")
    private String fileName;

    /**
     * 路径
     */
    @TableField("FILE_PATH")
    private String filePath;

    /**
     * 文件拥有者Id
     */
    @TableField("FILE_OWER_ID")
    private String fileOwerId;

    /**
     * 文件大小
     */
    @TableField("FILE_SIZE")
    private String fileSize;

    /**
     * 文件操作时间
     */
    @TableField("FILE_OPTION_DATA")
    private String fileOptionData;

    /**
     * 系统给用户文件的根路径
     */
    @TableField("FILE_ROOT_PATH")
    private String fileRootPath;


    public String getFileId() {
        return fileId;
    }

    public void setFileId(String fileId) {
        this.fileId = fileId;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public String getFileOwerId() {
        return fileOwerId;
    }

    public void setFileOwerId(String fileOwerId) {
        this.fileOwerId = fileOwerId;
    }

    public String getFileSize() {
        return fileSize;
    }

    public void setFileSize(String fileSize) {
        this.fileSize = fileSize;
    }

    public String getFileOptionData() {
        return fileOptionData;
    }

    public void setFileOptionData(String fileOptionData) {
        this.fileOptionData = fileOptionData;
    }

    public String getFileRootPath() {
        return fileRootPath;
    }

    public void setFileRootPath(String fileRootPath) {
        this.fileRootPath = fileRootPath;
    }

    @Override
    public String toString() {
        return "UserFile{" +
        "fileId=" + fileId +
        ", fileName=" + fileName +
        ", filePath=" + filePath +
        ", fileOwerId=" + fileOwerId +
        ", fileSize=" + fileSize +
        ", fileOptionData=" + fileOptionData +
        ", fileRootPath=" + fileRootPath +
        "}";
    }
}
