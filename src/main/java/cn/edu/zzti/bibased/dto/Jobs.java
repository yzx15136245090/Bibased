package cn.edu.zzti.bibased.dto;

import java.io.Serializable;

/**
 * zhi
 * <p>
 * Created by huaidou on  2018/1/11
 */
public class Jobs implements Serializable {
    private long id;
    private String jobUrl;//职位url链接地址
    private String jobName;//职位名称
    private String include;//属于哪个网站
    private long parentId;//父id  如果父节点为0 则为根节点
    private long rootId;//根节点
    private boolean leaf = true;//是否为叶子节点
    private long createTime;//创建时间
    private long opTime;//修改时间
    private long lastVer;// 版本
    private int isValid;//是否有效

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getJobUrl() {
        return jobUrl;
    }

    public void setJobUrl(String jobUrl) {
        this.jobUrl = jobUrl;
    }

    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    public String getInclude() {
        return include;
    }

    public void setInclude(String include) {
        this.include = include;
    }

    public long getParentId() {
        return parentId;
    }

    public void setParentId(long parentId) {
        this.parentId = parentId;
    }

    public long getRootId() {
        return rootId;
    }

    public void setRootId(long rootId) {
        this.rootId = rootId;
    }

    public boolean isLeaf() {
        return leaf;
    }

    public void setLeaf(boolean leaf) {
        this.leaf = leaf;
    }

    public long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(long createTime) {
        this.createTime = createTime;
    }

    public long getOpTime() {
        return opTime;
    }

    public void setOpTime(long opTime) {
        this.opTime = opTime;
    }

    public long getLastVer() {
        return lastVer;
    }

    public void setLastVer(long lastVer) {
        this.lastVer = lastVer;
    }

    public int getIsValid() {
        return isValid;
    }

    public void setIsValid(int isValid) {
        this.isValid = isValid;
    }
}
