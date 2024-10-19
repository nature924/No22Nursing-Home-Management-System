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
 * 家属意见
 *
 * @author 
 * @email
 */
@TableName("jiashuyijian")
public class JiashuyijianEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public JiashuyijianEntity() {

	}

	public JiashuyijianEntity(T t) {
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
    @TableField(value = "jiashuyijian_name")

    private String jiashuyijianName;


    /**
     * 类型 -
     */
    @ColumnInfo(comment="类型 -",type="int(11)")
    @TableField(value = "jiashuyijian_types")

    private Integer jiashuyijianTypes;


    /**
     * 家属
     */
    @ColumnInfo(comment="家属",type="int(11)")
    @TableField(value = "jiashu_id")

    private Integer jiashuId;


    /**
     * 详细信息
     */
    @ColumnInfo(comment="详细信息",type="text")
    @TableField(value = "jiashuyijian_content")

    private String jiashuyijianContent;


    /**
     * 逻辑删除
     */
    @ColumnInfo(comment="逻辑删除",type="int(11)")
    @TableField(value = "jiashuyijian_delete")

    private Integer jiashuyijianDelete;


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
    public String getJiashuyijianName() {
        return jiashuyijianName;
    }
    /**
	 * 设置：标题
	 */

    public void setJiashuyijianName(String jiashuyijianName) {
        this.jiashuyijianName = jiashuyijianName;
    }
    /**
	 * 获取：类型 -
	 */
    public Integer getJiashuyijianTypes() {
        return jiashuyijianTypes;
    }
    /**
	 * 设置：类型 -
	 */

    public void setJiashuyijianTypes(Integer jiashuyijianTypes) {
        this.jiashuyijianTypes = jiashuyijianTypes;
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
	 * 获取：详细信息
	 */
    public String getJiashuyijianContent() {
        return jiashuyijianContent;
    }
    /**
	 * 设置：详细信息
	 */

    public void setJiashuyijianContent(String jiashuyijianContent) {
        this.jiashuyijianContent = jiashuyijianContent;
    }
    /**
	 * 获取：逻辑删除
	 */
    public Integer getJiashuyijianDelete() {
        return jiashuyijianDelete;
    }
    /**
	 * 设置：逻辑删除
	 */

    public void setJiashuyijianDelete(Integer jiashuyijianDelete) {
        this.jiashuyijianDelete = jiashuyijianDelete;
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
        return "Jiashuyijian{" +
            ", id=" + id +
            ", jiashuyijianName=" + jiashuyijianName +
            ", jiashuyijianTypes=" + jiashuyijianTypes +
            ", jiashuId=" + jiashuId +
            ", jiashuyijianContent=" + jiashuyijianContent +
            ", jiashuyijianDelete=" + jiashuyijianDelete +
            ", createTime=" + DateUtil.convertString(createTime,"yyyy-MM-dd") +
        "}";
    }
}
