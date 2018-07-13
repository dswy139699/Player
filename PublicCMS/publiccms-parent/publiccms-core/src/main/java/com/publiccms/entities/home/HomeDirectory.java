package com.publiccms.entities.home;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.publiccms.common.database.CmsUpgrader;
import com.publiccms.common.generator.annotation.GeneratorColumn;

/**
 * HomeDirectory generated by hbm2java
 */
@Entity
@Table(name = "home_directory")
@DynamicUpdate
public class HomeDirectory implements java.io.Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    @GeneratorColumn(title = "ID")
    private Long id;
    @GeneratorColumn(title = "站点", condition = true)
    @JsonIgnore
    private short siteId;
    @GeneratorColumn(title = "用户", condition = true)
    private long userId;
    @GeneratorColumn(title = "标题")
    private String title;
    @GeneratorColumn(title = "封面")
    private String cover;
    @GeneratorColumn(title = "文件数")
    private int files;
    @GeneratorColumn(title = "保密")
    private boolean secret;
    @GeneratorColumn(title = "创建日期", order = true)
    private Date createDate;
    @GeneratorColumn(title = "已禁用", condition = true)
    private boolean disabled;

    public HomeDirectory() {
    }

    public HomeDirectory(short siteId, long userId, String title, int files, boolean secret, Date createDate, boolean disabled) {
        this.siteId = siteId;
        this.userId = userId;
        this.title = title;
        this.files = files;
        this.secret = secret;
        this.createDate = createDate;
        this.disabled = disabled;
    }

    public HomeDirectory(short siteId, long userId, String title, String cover, int files, boolean secret, Date createDate,
            boolean disabled) {
        this.siteId = siteId;
        this.userId = userId;
        this.title = title;
        this.cover = cover;
        this.files = files;
        this.secret = secret;
        this.createDate = createDate;
        this.disabled = disabled;
    }

    @Id
    @GeneratedValue(generator = "cmsGenerator")
    @GenericGenerator(name = "cmsGenerator", strategy = CmsUpgrader.IDENTIFIER_GENERATOR)
    @Column(name = "id", unique = true, nullable = false)
    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "site_id", nullable = false)
    public short getSiteId() {
        return this.siteId;
    }

    public void setSiteId(short siteId) {
        this.siteId = siteId;
    }

    @Column(name = "user_id", nullable = false)
    public long getUserId() {
        return this.userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    @Column(name = "title", nullable = false)
    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Column(name = "cover")
    public String getCover() {
        return this.cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    @Column(name = "files", nullable = false)
    public int getFiles() {
        return this.files;
    }

    public void setFiles(int files) {
        this.files = files;
    }

    @Column(name = "secret", nullable = false)
    public boolean isSecret() {
        return this.secret;
    }

    public void setSecret(boolean secret) {
        this.secret = secret;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "create_date", nullable = false, length = 19)
    public Date getCreateDate() {
        return this.createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    @Column(name = "disabled", nullable = false)
    public boolean isDisabled() {
        return this.disabled;
    }

    public void setDisabled(boolean disabled) {
        this.disabled = disabled;
    }

}
