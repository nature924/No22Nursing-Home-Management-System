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
 * 访客信息
 *
 * @author 
 * @email
 */
@TableName("fangke")
public class FangkeEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public FangkeEntity() {

	}

	public FangkeEntity(T t) {
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
     * 标题
     */
    @ColumnInfo(comment="标题",type="varchar(200)")
    @TableField(value = "fangke_name")

    private String fangkeName;


    /**
     * 来访人名称
     */
    @ColumnInfo(comment="来访人名称",type="varchar(200)")
    @TableField(value = "fangke_mingc")

    private String fangkeMingc;


    /**
     * 来访人联系方式
     */
    @ColumnInfo(comment="来访人联系方式",type="varchar(200)")
    @TableField(value = "fangke_phone")

    private String fangkePhone;


    /**
     * 来访目的
     */
    @ColumnInfo(comment="来访目的",type="int(11)")
    @TableField(value = "fangke_types")

    private Integer fangkeTypes;


    /**
     * 来访时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="来访时间",type="timestamp")
    @TableField(value = "fangke_time")

    private Date fangkeTime;


    /**
     * 离开时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="离开时间",type="timestamp")
    @TableField(value = "huilia_time")

    private Date huiliaTime;


    /**
     * 老人
     */
    @ColumnInfo(comment="老人",type="int(11)")
    @TableField(value = "yonghu_id")

    private Integer yonghuId;


    /**
     * 备注
     */
    @ColumnInfo(comment="备注",type="text")
    @TableField(value = "fangke_text")

    private String fangkeText;


    /**
     * 详情
     */
    @ColumnInfo(comment="详情",type="text")
    @TableField(value = "fangke_content")

    private String fangkeContent;


    /**
     * 逻辑删除
     */
    @ColumnInfo(comment="逻辑删除",type="int(11)")
    @TableField(value = "fangke_delete")

    private Integer fangkeDelete;


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
	 * 获取：标题
	 */
    public String getFangkeName() {
        return fangkeName;
    }
    /**
	 * 设置：标题
	 */

    public void setFangkeName(String fangkeName) {
        this.fangkeName = fangkeName;
    }
    /**
	 * 获取：来访人名称
	 */
    public String getFangkeMingc() {
        return fangkeMingc;
    }
    /**
	 * 设置：来访人名称
	 */

    public void setFangkeMingc(String fangkeMingc) {
        this.fangkeMingc = fangkeMingc;
    }
    /**
	 * 获取：来访人联系方式
	 */
    public String getFangkePhone() {
        return fangkePhone;
    }
    /**
	 * 设置：来访人联系方式
	 */

    public void setFangkePhone(String fangkePhone) {
        this.fangkePhone = fangkePhone;
    }
    /**
	 * 获取：来访目的
	 */
    public Integer getFangkeTypes() {
        return fangkeTypes;
    }
    /**
	 * 设置：来访目的
	 */

    public void setFangkeTypes(Integer fangkeTypes) {
        this.fangkeTypes = fangkeTypes;
    }
    /**
	 * 获取：来访时间
	 */
    public Date getFangkeTime() {
        return fangkeTime;
    }
    /**
	 * 设置：来访时间
	 */

    public void setFangkeTime(Date fangkeTime) {
        this.fangkeTime = fangkeTime;
    }
    /**
	 * 获取：离开时间
	 */
    public Date getHuiliaTime() {
        return huiliaTime;
    }
    /**
	 * 设置：离开时间
	 */

    public void setHuiliaTime(Date huiliaTime) {
        this.huiliaTime = huiliaTime;
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
	 * 获取：备注
	 */
    public String getFangkeText() {
        return fangkeText;
    }
    /**
	 * 设置：备注
	 */

    public void setFangkeText(String fangkeText) {
        this.fangkeText = fangkeText;
    }
    /**
	 * 获取：详情
	 */
    public String getFangkeContent() {
        return fangkeContent;
    }
    /**
	 * 设置：详情
	 */

    public void setFangkeContent(String fangkeContent) {
        this.fangkeContent = fangkeContent;
    }
    /**
	 * 获取：逻辑删除
	 */
    public Integer getFangkeDelete() {
        return fangkeDelete;
    }
    /**
	 * 设置：逻辑删除
	 */

    public void setFangkeDelete(Integer fangkeDelete) {
        this.fangkeDelete = fangkeDelete;
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
        return "Fangke{" +
            ", id=" + id +
            ", fangkeName=" + fangkeName +
            ", fangkeMingc=" + fangkeMingc +
            ", fangkePhone=" + fangkePhone +
            ", fangkeTypes=" + fangkeTypes +
            ", fangkeTime=" + DateUtil.convertString(fangkeTime,"yyyy-MM-dd") +
            ", huiliaTime=" + DateUtil.convertString(huiliaTime,"yyyy-MM-dd") +
            ", yonghuId=" + yonghuId +
            ", fangkeText=" + fangkeText +
            ", fangkeContent=" + fangkeContent +
            ", fangkeDelete=" + fangkeDelete +
            ", createTime=" + DateUtil.convertString(createTime,"yyyy-MM-dd") +
        "}";
    }
}
