package com.publiccms.entities.home;
// Generated 2016-11-13 13:44:22 by Hibernate Tools 4.3.1

import javax.persistence.Column;
import javax.persistence.Embeddable;

import com.publiccms.common.generator.annotation.GeneratorColumn;

/**
 * HomeDialogId generated by hbm2java
 */
@Embeddable
public class HomeDialogId implements java.io.Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    @GeneratorColumn(title = "用户")
    private long userId;
    @GeneratorColumn(title = "项目类型")
    private String itemType;
    @GeneratorColumn(title = "项目ID")
    private long itemId;

    public HomeDialogId() {
    }

    public HomeDialogId(long userId, String itemType, long itemId) {
        this.userId = userId;
        this.itemType = itemType;
        this.itemId = itemId;
    }

    @Column(name = "user_id", nullable = false)
    public long getUserId() {
        return this.userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    @Column(name = "item_type", nullable = false, length = 20)
    public String getItemType() {
        return this.itemType;
    }

    public void setItemType(String itemType) {
        this.itemType = itemType;
    }

    @Column(name = "item_id", nullable = false)
    public long getItemId() {
        return this.itemId;
    }

    public void setItemId(long itemId) {
        this.itemId = itemId;
    }

    public boolean equals(Object other) {
        if ((this == other))
            return true;
        if ((other == null))
            return false;
        if (!(other instanceof HomeDialogId))
            return false;
        HomeDialogId castOther = (HomeDialogId) other;

        return (this.getUserId() == castOther.getUserId())
                && ((this.getItemType() == castOther.getItemType()) || (this.getItemType() != null
                        && castOther.getItemType() != null && this.getItemType().equals(castOther.getItemType())))
                && (this.getItemId() == castOther.getItemId());
    }

    public int hashCode() {
        int result = 17;

        result = 37 * result + (int) this.getUserId();
        result = 37 * result + (getItemType() == null ? 0 : this.getItemType().hashCode());
        result = 37 * result + (int) this.getItemId();
        return result;
    }

}
