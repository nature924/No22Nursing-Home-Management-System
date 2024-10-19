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
 * 家属
 *
 * @author 
 * @email
 */
@TableName("jiashu")
public class JiashuEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public JiashuEntity() {

	}

	public JiashuEntity(T t) {
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
     * 账号
     */
    @ColumnInfo(comment="账号",type="varchar(200)")
    @TableField(value = "username")

    private String username;


    /**
     * 密码
     */
    @ColumnInfo(comment="密码",type="varchar(200)")
    @TableField(value = "password")

    private String password;


    /**
     * 家属名称
     */
    @ColumnInfo(comment="家属名称",type="varchar(200)")
    @TableField(value = "jiashu_name")

    private String jiashuName;


    /**
     * 家属照片
     */
    @ColumnInfo(comment="家属照片",type="varchar(200)")
    @TableField(value = "jiashu_photo")

    private String jiashuPhoto;


    /**
     * 性别
     */
    @ColumnInfo(comment="性别",type="int(11)")
    @TableField(value = "sex_types")

    private Integer sexTypes;


    /**
     * 联系电话
     */
    @ColumnInfo(comment="联系电话",type="varchar(200)")
    @TableField(value = "jiashu_phone")

    private String jiashuPhone;


    /**
     * 邮箱
     */
    @ColumnInfo(comment="邮箱",type="varchar(200)")
    @TableField(value = "jiashu_email")

    private String jiashuEmail;


    /**
     * 身份
     */
    @ColumnInfo(comment="身份",type="int(11)")
    @TableField(value = "jiashu_types")

    private Integer jiashuTypes;


    /**
     * 逻辑删除
     */
    @ColumnInfo(comment="逻辑删除",type="int(11)")
    @TableField(value = "jiashu_delete")

    private Integer jiashuDelete;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="创建时间",type="timestamp")
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
	 * 获取：账号
	 */
    public String getUsername() {
        return username;
    }
    /**
	 * 设置：账号
	 */

    public void setUsername(String username) {
        this.username = username;
    }
    /**
	 * 获取：密码
	 */
    public String getPassword() {
        return password;
    }
    /**
	 * 设置：密码
	 */

    public void setPassword(String password) {
        this.password = password;
    }
    /**
	 * 获取：家属名称
	 */
    public String getJiashuName() {
        return jiashuName;
    }
    /**
	 * 设置：家属名称
	 */

    public void setJiashuName(String jiashuName) {
        this.jiashuName = jiashuName;
    }
    /**
	 * 获取：家属照片
	 */
    public String getJiashuPhoto() {
        return jiashuPhoto;
    }
    /**
	 * 设置：家属照片
	 */

    public void setJiashuPhoto(String jiashuPhoto) {
        this.jiashuPhoto = jiashuPhoto;
    }
    /**
	 * 获取：性别
	 */
    public Integer getSexTypes() {
        return sexTypes;
    }
    /**
	 * 设置：性别
	 */

    public void setSexTypes(Integer sexTypes) {
        this.sexTypes = sexTypes;
    }
    /**
	 * 获取：联系电话
	 */
    public String getJiashuPhone() {
        return jiashuPhone;
    }
    /**
	 * 设置：联系电话
	 */

    public void setJiashuPhone(String jiashuPhone) {
        this.jiashuPhone = jiashuPhone;
    }
    /**
	 * 获取：邮箱
	 */
    public String getJiashuEmail() {
        return jiashuEmail;
    }
    /**
	 * 设置：邮箱
	 */

    public void setJiashuEmail(String jiashuEmail) {
        this.jiashuEmail = jiashuEmail;
    }
    /**
	 * 获取：身份
	 */
    public Integer getJiashuTypes() {
        return jiashuTypes;
    }
    /**
	 * 设置：身份
	 */

    public void setJiashuTypes(Integer jiashuTypes) {
        this.jiashuTypes = jiashuTypes;
    }
    /**
	 * 获取：逻辑删除
	 */
    public Integer getJiashuDelete() {
        return jiashuDelete;
    }
    /**
	 * 设置：逻辑删除
	 */

    public void setJiashuDelete(Integer jiashuDelete) {
        this.jiashuDelete = jiashuDelete;
    }
    /**
	 * 获取：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }
    /**
	 * 设置：创建时间
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Jiashu{" +
            ", id=" + id +
            ", username=" + username +
            ", password=" + password +
            ", jiashuName=" + jiashuName +
            ", jiashuPhoto=" + jiashuPhoto +
            ", sexTypes=" + sexTypes +
            ", jiashuPhone=" + jiashuPhone +
            ", jiashuEmail=" + jiashuEmail +
            ", jiashuTypes=" + jiashuTypes +
            ", jiashuDelete=" + jiashuDelete +
            ", createTime=" + DateUtil.convertString(createTime,"yyyy-MM-dd") +
        "}";
    }
}
