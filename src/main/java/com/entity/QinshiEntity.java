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
 * 寝室信息
 *
 * @author 
 * @email
 */
@TableName("qinshi")
public class QinshiEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public QinshiEntity() {

	}

	public QinshiEntity(T t) {
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
     * 寝室位置
     */
    @ColumnInfo(comment="寝室位置",type="varchar(200)")
    @TableField(value = "qinshi_name")

    private String qinshiName;


    /**
     * 寝室类型
     */
    @ColumnInfo(comment="寝室类型",type="int(11)")
    @TableField(value = "qinshi_types")

    private Integer qinshiTypes;


    /**
     * 寝室状态
     */
    @ColumnInfo(comment="寝室状态",type="int(11)")
    @TableField(value = "status_types")

    private Integer statusTypes;


    /**
     * 寝室详情
     */
    @ColumnInfo(comment="寝室详情",type="text")
    @TableField(value = "qinshi_content")

    private String qinshiContent;


    /**
     * 逻辑删除
     */
    @ColumnInfo(comment="逻辑删除",type="int(11)")
    @TableField(value = "qinshi_delete")

    private Integer qinshiDelete;


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
	 * 获取：寝室位置
	 */
    public String getQinshiName() {
        return qinshiName;
    }
    /**
	 * 设置：寝室位置
	 */

    public void setQinshiName(String qinshiName) {
        this.qinshiName = qinshiName;
    }
    /**
	 * 获取：寝室类型
	 */
    public Integer getQinshiTypes() {
        return qinshiTypes;
    }
    /**
	 * 设置：寝室类型
	 */

    public void setQinshiTypes(Integer qinshiTypes) {
        this.qinshiTypes = qinshiTypes;
    }
    /**
	 * 获取：寝室状态
	 */
    public Integer getStatusTypes() {
        return statusTypes;
    }
    /**
	 * 设置：寝室状态
	 */

    public void setStatusTypes(Integer statusTypes) {
        this.statusTypes = statusTypes;
    }
    /**
	 * 获取：寝室详情
	 */
    public String getQinshiContent() {
        return qinshiContent;
    }
    /**
	 * 设置：寝室详情
	 */

    public void setQinshiContent(String qinshiContent) {
        this.qinshiContent = qinshiContent;
    }
    /**
	 * 获取：逻辑删除
	 */
    public Integer getQinshiDelete() {
        return qinshiDelete;
    }
    /**
	 * 设置：逻辑删除
	 */

    public void setQinshiDelete(Integer qinshiDelete) {
        this.qinshiDelete = qinshiDelete;
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
        return "Qinshi{" +
            ", id=" + id +
            ", qinshiName=" + qinshiName +
            ", qinshiTypes=" + qinshiTypes +
            ", statusTypes=" + statusTypes +
            ", qinshiContent=" + qinshiContent +
            ", qinshiDelete=" + qinshiDelete +
            ", createTime=" + DateUtil.convertString(createTime,"yyyy-MM-dd") +
        "}";
    }
}
