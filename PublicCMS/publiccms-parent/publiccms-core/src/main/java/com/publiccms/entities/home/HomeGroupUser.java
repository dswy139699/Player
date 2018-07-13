package com.publiccms.entities.home;
// Generated 2016-11-12 18:33:49 by Hibernate Tools 4.3.1

import java.util.Date;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.DynamicUpdate;

import com.publiccms.common.generator.annotation.GeneratorColumn;

/**
 * HomeGroupUser generated by hbm2java
 */
@Entity
@Table(name = "home_group_user")
@DynamicUpdate
public class HomeGroupUser implements java.io.Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    @GeneratorColumn(title = "ID")
    private HomeGroupUserId id;
    @GeneratorColumn(title = "管理员")
    private boolean superuserAccess;
    @GeneratorColumn(title = "已禁用", condition = true)
    private boolean disabled;
    @GeneratorColumn(title = "创建日期")
    private Date createDate;

    public HomeGroupUser() {
    }

    public HomeGroupUser(HomeGroupUserId id, boolean superuserAccess, Date createDate) {
        this.id = id;
        this.superuserAccess = superuserAccess;
        this.createDate = createDate;
    }

    @EmbeddedId

    @AttributeOverrides({ @AttributeOverride(name = "groupId", column = @Column(name = "group_id", nullable = false)),
            @AttributeOverride(name = "userId", column = @Column(name = "user_id", nullable = false)) })
    public HomeGroupUserId getId() {
        return this.id;
    }

    public void setId(HomeGroupUserId id) {
        this.id = id;
    }

    @Column(name = "superuser_access", nullable = false)
    public boolean getSuperuserAccess() {
        return this.superuserAccess;
    }

    public void setSuperuserAccess(boolean superuserAccess) {
        this.superuserAccess = superuserAccess;
    }

    @Column(name = "disabled", nullable = false)
    public boolean isDisabled() {
        return this.disabled;
    }

    public void setDisabled(boolean disabled) {
        this.disabled = disabled;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "create_date", nullable = false, length = 19)
    public Date getCreateDate() {
        return this.createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

}
