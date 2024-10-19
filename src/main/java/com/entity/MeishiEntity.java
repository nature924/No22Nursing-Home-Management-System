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
 * 食物
 *
 * @author 
 * @email
 */
@TableName("meishi")
public class MeishiEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public MeishiEntity() {

	}

	public MeishiEntity(T t) {
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
    @TableField(value = "meishi_name")

    private String meishiName;


    /**
     * 食物照片
     */
    @ColumnInfo(comment="食物照片",type="varchar(200)")
    @TableField(value = "meishi_photo")

    private String meishiPhoto;


    /**
     * 食物类型
     */
    @ColumnInfo(comment="食物类型",type="int(11)")
    @TableField(value = "meishi_types")

    private Integer meishiTypes;


    /**
     * 价格
     */
    @ColumnInfo(comment="价格",type="decimal(10,2)")
    @TableField(value = "meishi_new_money")

    private Double meishiNewMoney;


    /**
     * 食物介绍
     */
    @ColumnInfo(comment="食物介绍",type="text")
    @TableField(value = "meishi_content")

    private String meishiContent;


    /**
     * 逻辑删除
     */
    @ColumnInfo(comment="逻辑删除",type="int(11)")
    @TableField(value = "meishi_delete")

    private Integer meishiDelete;


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
    public String getMeishiName() {
        return meishiName;
    }
    /**
	 * 设置：食物名称
	 */

    public void setMeishiName(String meishiName) {
        this.meishiName = meishiName;
    }
    /**
	 * 获取：食物照片
	 */
    public String getMeishiPhoto() {
        return meishiPhoto;
    }
    /**
	 * 设置：食物照片
	 */

    public void setMeishiPhoto(String meishiPhoto) {
        this.meishiPhoto = meishiPhoto;
    }
    /**
	 * 获取：食物类型
	 */
    public Integer getMeishiTypes() {
        return meishiTypes;
    }
    /**
	 * 设置：食物类型
	 */

    public void setMeishiTypes(Integer meishiTypes) {
        this.meishiTypes = meishiTypes;
    }
    /**
	 * 获取：价格
	 */
    public Double getMeishiNewMoney() {
        return meishiNewMoney;
    }
    /**
	 * 设置：价格
	 */

    public void setMeishiNewMoney(Double meishiNewMoney) {
        this.meishiNewMoney = meishiNewMoney;
    }
    /**
	 * 获取：食物介绍
	 */
    public String getMeishiContent() {
        return meishiContent;
    }
    /**
	 * 设置：食物介绍
	 */

    public void setMeishiContent(String meishiContent) {
        this.meishiContent = meishiContent;
    }
    /**
	 * 获取：逻辑删除
	 */
    public Integer getMeishiDelete() {
        return meishiDelete;
    }
    /**
	 * 设置：逻辑删除
	 */

    public void setMeishiDelete(Integer meishiDelete) {
        this.meishiDelete = meishiDelete;
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
        return "Meishi{" +
            ", id=" + id +
            ", meishiName=" + meishiName +
            ", meishiPhoto=" + meishiPhoto +
            ", meishiTypes=" + meishiTypes +
            ", meishiNewMoney=" + meishiNewMoney +
            ", meishiContent=" + meishiContent +
            ", meishiDelete=" + meishiDelete +
            ", createTime=" + DateUtil.convertString(createTime,"yyyy-MM-dd") +
        "}";
    }
}
