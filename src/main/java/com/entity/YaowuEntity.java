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
 * 药物
 *
 * @author 
 * @email
 */
@TableName("yaowu")
public class YaowuEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public YaowuEntity() {

	}

	public YaowuEntity(T t) {
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
     * 药物名称
     */
    @ColumnInfo(comment="药物名称",type="varchar(200)")
    @TableField(value = "yaowu_name")

    private String yaowuName;


    /**
     * 药物类型
     */
    @ColumnInfo(comment="药物类型",type="int(11)")
    @TableField(value = "yaowu_types")

    private Integer yaowuTypes;


    /**
     * 药物数量
     */
    @ColumnInfo(comment="药物数量",type="int(11)")
    @TableField(value = "yaowu_kucun_number")

    private Integer yaowuKucunNumber;


    /**
     * 药物介绍
     */
    @ColumnInfo(comment="药物介绍",type="text")
    @TableField(value = "yaowu_content")

    private String yaowuContent;


    /**
     * 逻辑删除
     */
    @ColumnInfo(comment="逻辑删除",type="int(11)")
    @TableField(value = "yaowu_delete")

    private Integer yaowuDelete;


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
	 * 获取：药物名称
	 */
    public String getYaowuName() {
        return yaowuName;
    }
    /**
	 * 设置：药物名称
	 */

    public void setYaowuName(String yaowuName) {
        this.yaowuName = yaowuName;
    }
    /**
	 * 获取：药物类型
	 */
    public Integer getYaowuTypes() {
        return yaowuTypes;
    }
    /**
	 * 设置：药物类型
	 */

    public void setYaowuTypes(Integer yaowuTypes) {
        this.yaowuTypes = yaowuTypes;
    }
    /**
	 * 获取：药物数量
	 */
    public Integer getYaowuKucunNumber() {
        return yaowuKucunNumber;
    }
    /**
	 * 设置：药物数量
	 */

    public void setYaowuKucunNumber(Integer yaowuKucunNumber) {
        this.yaowuKucunNumber = yaowuKucunNumber;
    }
    /**
	 * 获取：药物介绍
	 */
    public String getYaowuContent() {
        return yaowuContent;
    }
    /**
	 * 设置：药物介绍
	 */

    public void setYaowuContent(String yaowuContent) {
        this.yaowuContent = yaowuContent;
    }
    /**
	 * 获取：逻辑删除
	 */
    public Integer getYaowuDelete() {
        return yaowuDelete;
    }
    /**
	 * 设置：逻辑删除
	 */

    public void setYaowuDelete(Integer yaowuDelete) {
        this.yaowuDelete = yaowuDelete;
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
        return "Yaowu{" +
            ", id=" + id +
            ", yaowuName=" + yaowuName +
            ", yaowuTypes=" + yaowuTypes +
            ", yaowuKucunNumber=" + yaowuKucunNumber +
            ", yaowuContent=" + yaowuContent +
            ", yaowuDelete=" + yaowuDelete +
            ", createTime=" + DateUtil.convertString(createTime,"yyyy-MM-dd") +
        "}";
    }
}
