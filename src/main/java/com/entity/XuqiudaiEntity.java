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
 * 需求袋
 *
 * @author 
 * @email
 */
@TableName("xuqiudai")
public class XuqiudaiEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public XuqiudaiEntity() {

	}

	public XuqiudaiEntity(T t) {
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
     * 药物
     */
    @ColumnInfo(comment="药物",type="int(11)")
    @TableField(value = "yaowu_id")

    private Integer yaowuId;


    /**
     * 老人
     */
    @ColumnInfo(comment="老人",type="int(11)")
    @TableField(value = "yonghu_id")

    private Integer yonghuId;


    /**
     * 需求数量
     */
    @ColumnInfo(comment="需求数量",type="int(11)")
    @TableField(value = "xuqiudai_kucun_number")

    private Integer xuqiudaiKucunNumber;


    /**
     * 需求状态
     */
    @ColumnInfo(comment="需求状态",type="int(11)")
    @TableField(value = "xuqiudai_types")

    private Integer xuqiudaiTypes;


    /**
     * 添加时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="添加时间",type="timestamp")
    @TableField(value = "insert_time",fill = FieldFill.INSERT)

    private Date insertTime;


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
	 * 获取：药物
	 */
    public Integer getYaowuId() {
        return yaowuId;
    }
    /**
	 * 设置：药物
	 */

    public void setYaowuId(Integer yaowuId) {
        this.yaowuId = yaowuId;
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
	 * 获取：需求数量
	 */
    public Integer getXuqiudaiKucunNumber() {
        return xuqiudaiKucunNumber;
    }
    /**
	 * 设置：需求数量
	 */

    public void setXuqiudaiKucunNumber(Integer xuqiudaiKucunNumber) {
        this.xuqiudaiKucunNumber = xuqiudaiKucunNumber;
    }
    /**
	 * 获取：需求状态
	 */
    public Integer getXuqiudaiTypes() {
        return xuqiudaiTypes;
    }
    /**
	 * 设置：需求状态
	 */

    public void setXuqiudaiTypes(Integer xuqiudaiTypes) {
        this.xuqiudaiTypes = xuqiudaiTypes;
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
        return "Xuqiudai{" +
            ", id=" + id +
            ", yaowuId=" + yaowuId +
            ", yonghuId=" + yonghuId +
            ", xuqiudaiKucunNumber=" + xuqiudaiKucunNumber +
            ", xuqiudaiTypes=" + xuqiudaiTypes +
            ", insertTime=" + DateUtil.convertString(insertTime,"yyyy-MM-dd") +
            ", createTime=" + DateUtil.convertString(createTime,"yyyy-MM-dd") +
        "}";
    }
}
