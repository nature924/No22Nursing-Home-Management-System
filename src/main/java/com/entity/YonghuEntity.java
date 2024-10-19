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
 * 老人
 *
 * @author 
 * @email
 */
@TableName("yonghu")
public class YonghuEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public YonghuEntity() {

	}

	public YonghuEntity(T t) {
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
     * 老人姓名
     */
    @ColumnInfo(comment="老人姓名",type="varchar(200)")
    @TableField(value = "yonghu_name")

    private String yonghuName;


    /**
     * 头像
     */
    @ColumnInfo(comment="头像",type="varchar(255)")
    @TableField(value = "yonghu_photo")

    private String yonghuPhoto;


    /**
     * 性别
     */
    @ColumnInfo(comment="性别",type="int(11)")
    @TableField(value = "sex_types")

    private Integer sexTypes;


    /**
     * 健康状态
     */
    @ColumnInfo(comment="健康状态",type="int(11)")
    @TableField(value = "jiankang_types")

    private Integer jiankangTypes;


    /**
     * 年龄
     */
    @ColumnInfo(comment="年龄",type="int(11)")
    @TableField(value = "yonghu_age")

    private Integer yonghuAge;


    /**
     * 紧急联系方式
     */
    @ColumnInfo(comment="紧急联系方式",type="varchar(200)")
    @TableField(value = "yonghu_phone")

    private String yonghuPhone;


    /**
     * 住址
     */
    @ColumnInfo(comment="住址",type="varchar(200)")
    @TableField(value = "yonghu_address")

    private String yonghuAddress;


    /**
     * 健康报警
     */
    @ColumnInfo(comment="健康报警",type="int(11)")
    @TableField(value = "baojing_types")

    private Integer baojingTypes;


    /**
     * 家属
     */
    @ColumnInfo(comment="家属",type="int(11)")
    @TableField(value = "jiashu_id")

    private Integer jiashuId;


    /**
     * 假删
     */
    @ColumnInfo(comment="假删",type="int(11)")
    @TableField(value = "yonghu_delete")

    private Integer yonghuDelete;


    /**
     * 添加时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="添加时间",type="timestamp")
    @TableField(value = "insert_time",fill = FieldFill.INSERT)

    private Date insertTime;


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
	 * 获取：老人姓名
	 */
    public String getYonghuName() {
        return yonghuName;
    }
    /**
	 * 设置：老人姓名
	 */

    public void setYonghuName(String yonghuName) {
        this.yonghuName = yonghuName;
    }
    /**
	 * 获取：头像
	 */
    public String getYonghuPhoto() {
        return yonghuPhoto;
    }
    /**
	 * 设置：头像
	 */

    public void setYonghuPhoto(String yonghuPhoto) {
        this.yonghuPhoto = yonghuPhoto;
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
	 * 获取：健康状态
	 */
    public Integer getJiankangTypes() {
        return jiankangTypes;
    }
    /**
	 * 设置：健康状态
	 */

    public void setJiankangTypes(Integer jiankangTypes) {
        this.jiankangTypes = jiankangTypes;
    }
    /**
	 * 获取：年龄
	 */
    public Integer getYonghuAge() {
        return yonghuAge;
    }
    /**
	 * 设置：年龄
	 */

    public void setYonghuAge(Integer yonghuAge) {
        this.yonghuAge = yonghuAge;
    }
    /**
	 * 获取：紧急联系方式
	 */
    public String getYonghuPhone() {
        return yonghuPhone;
    }
    /**
	 * 设置：紧急联系方式
	 */

    public void setYonghuPhone(String yonghuPhone) {
        this.yonghuPhone = yonghuPhone;
    }
    /**
	 * 获取：住址
	 */
    public String getYonghuAddress() {
        return yonghuAddress;
    }
    /**
	 * 设置：住址
	 */

    public void setYonghuAddress(String yonghuAddress) {
        this.yonghuAddress = yonghuAddress;
    }
    /**
	 * 获取：健康报警
	 */
    public Integer getBaojingTypes() {
        return baojingTypes;
    }
    /**
	 * 设置：健康报警
	 */

    public void setBaojingTypes(Integer baojingTypes) {
        this.baojingTypes = baojingTypes;
    }
    /**
	 * 获取：家属
	 */
    public Integer getJiashuId() {
        return jiashuId;
    }
    /**
	 * 设置：家属
	 */

    public void setJiashuId(Integer jiashuId) {
        this.jiashuId = jiashuId;
    }
    /**
	 * 获取：假删
	 */
    public Integer getYonghuDelete() {
        return yonghuDelete;
    }
    /**
	 * 设置：假删
	 */

    public void setYonghuDelete(Integer yonghuDelete) {
        this.yonghuDelete = yonghuDelete;
    }
    /**
	 * 获取：添加时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }
    /**
	 * 设置：添加时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
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
        return "Yonghu{" +
            ", id=" + id +
            ", username=" + username +
            ", password=" + password +
            ", yonghuName=" + yonghuName +
            ", yonghuPhoto=" + yonghuPhoto +
            ", sexTypes=" + sexTypes +
            ", jiankangTypes=" + jiankangTypes +
            ", yonghuAge=" + yonghuAge +
            ", yonghuPhone=" + yonghuPhone +
            ", yonghuAddress=" + yonghuAddress +
            ", baojingTypes=" + baojingTypes +
            ", jiashuId=" + jiashuId +
            ", yonghuDelete=" + yonghuDelete +
            ", insertTime=" + DateUtil.convertString(insertTime,"yyyy-MM-dd") +
            ", createTime=" + DateUtil.convertString(createTime,"yyyy-MM-dd") +
        "}";
    }
}
