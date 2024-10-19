package com.entity;

import com.annotation.ColumnInfo;
import javax.validation.constraints.*;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;
import java.io.Serializable;
import java.util.*;
import org.apache.tools.ant.util.DateUtils;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.utils.DateUtil;


/**
 * 饮食喜好
 *
 * @author 
 * @email
 */
@TableName("yinshixihao")
public class YinshixihaoEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public YinshixihaoEntity() {

	}

	public YinshixihaoEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
    @ColumnInfo(comment="主键",type="int(11)")
    @TableField(value = "id")

    private Integer id;


    /**
     * 食物名称
     */
    @ColumnInfo(comment="食物名称",type="varchar(200)")
    @TableField(value = "yinshixihao_name")

    private String yinshixihaoName;


    /**
     * 食物照片
     */
    @ColumnInfo(comment="食物照片",type="varchar(200)")
    @TableField(value = "yinshixihao_photo")

    private String yinshixihaoPhoto;


    /**
     * 食物类型
     */
    @ColumnInfo(comment="食物类型",type="int(11)")
    @TableField(value = "yinshixihao_types")

    private Integer yinshixihaoTypes;


    /**
     * 老人
     */
    @ColumnInfo(comment="老人",type="int(11)")
    @TableField(value = "yonghu_id")

    private Integer yonghuId;


    /**
     * 食物介绍
     */
    @ColumnInfo(comment="食物介绍",type="text")
    @TableField(value = "yinshixihao_content")

    private String yinshixihaoContent;


    /**
     * 逻辑删除
     */
    @ColumnInfo(comment="逻辑删除",type="int(11)")
    @TableField(value = "yinshixihao_delete")

    private Integer yinshixihaoDelete;


    /**
     * 创建时间     homeMain
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="创建时间     homeMain",type="timestamp")
    @TableField(value = "create_time",fill = FieldFill.INSERT)

    private Date createTime;


    /**
	 * 获取：主键
	 */
    public Integer getId() {
        return id;
    }
    /**
	 * 设置：主键
	 */

    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 获取：食物名称
	 */
    public String getYinshixihaoName() {
        return yinshixihaoName;
    }
    /**
	 * 设置：食物名称
	 */

    public void setYinshixihaoName(String yinshixihaoName) {
        this.yinshixihaoName = yinshixihaoName;
    }
    /**
	 * 获取：食物照片
	 */
    public String getYinshixihaoPhoto() {
        return yinshixihaoPhoto;
    }
    /**
	 * 设置：食物照片
	 */

    public void setYinshixihaoPhoto(String yinshixihaoPhoto) {
        this.yinshixihaoPhoto = yinshixihaoPhoto;
    }
    /**
	 * 获取：食物类型
	 */
    public Integer getYinshixihaoTypes() {
        return yinshixihaoTypes;
    }
    /**
	 * 设置：食物类型
	 */

    public void setYinshixihaoTypes(Integer yinshixihaoTypes) {
        this.yinshixihaoTypes = yinshixihaoTypes;
    }
    /**
	 * 获取：老人
	 */
    public Integer getYonghuId() {
        return yonghuId;
    }
    /**
	 * 设置：老人
	 */

    public void setYonghuId(Integer yonghuId) {
        this.yonghuId = yonghuId;
    }
    /**
	 * 获取：食物介绍
	 */
    public String getYinshixihaoContent() {
        return yinshixihaoContent;
    }
    /**
	 * 设置：食物介绍
	 */

    public void setYinshixihaoContent(String yinshixihaoContent) {
        this.yinshixihaoContent = yinshixihaoContent;
    }
    /**
	 * 获取：逻辑删除
	 */
    public Integer getYinshixihaoDelete() {
        return yinshixihaoDelete;
    }
    /**
	 * 设置：逻辑删除
	 */

    public void setYinshixihaoDelete(Integer yinshixihaoDelete) {
        this.yinshixihaoDelete = yinshixihaoDelete;
    }
    /**
	 * 获取：创建时间     homeMain
	 */
    public Date getCreateTime() {
        return createTime;
    }
    /**
	 * 设置：创建时间     homeMain
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Yinshixihao{" +
            ", id=" + id +
            ", yinshixihaoName=" + yinshixihaoName +
            ", yinshixihaoPhoto=" + yinshixihaoPhoto +
            ", yinshixihaoTypes=" + yinshixihaoTypes +
            ", yonghuId=" + yonghuId +
            ", yinshixihaoContent=" + yinshixihaoContent +
            ", yinshixihaoDelete=" + yinshixihaoDelete +
            ", createTime=" + DateUtil.convertString(createTime,"yyyy-MM-dd") +
        "}";
    }
}
