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
 * 老人事故信息
 *
 * @author 
 * @email
 */
@TableName("shigu")
public class ShiguEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public ShiguEntity() {

	}

	public ShiguEntity(T t) {
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
    @TableField(value = "shigu_name")

    private String shiguName;


    /**
     * 事故时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="事故时间",type="timestamp")
    @TableField(value = "shigu_time")

    private Date shiguTime;


    /**
     * 地点
     */
    @ColumnInfo(comment="地点",type="varchar(200)")
    @TableField(value = "shigu_address")

    private String shiguAddress;


    /**
     * 事故类型
     */
    @ColumnInfo(comment="事故类型",type="int(11)")
    @TableField(value = "shigu_types")

    private Integer shiguTypes;


    /**
     * 严重程度
     */
    @ColumnInfo(comment="严重程度",type="int(11)")
    @TableField(value = "yanzheng_types")

    private Integer yanzhengTypes;


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
    @TableField(value = "shigu_text")

    private String shiguText;


    /**
     * 详情
     */
    @ColumnInfo(comment="详情",type="text")
    @TableField(value = "shigu_content")

    private String shiguContent;


    /**
     * 逻辑删除
     */
    @ColumnInfo(comment="逻辑删除",type="int(11)")
    @TableField(value = "shigu_delete")

    private Integer shiguDelete;


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
    public String getShiguName() {
        return shiguName;
    }
    /**
	 * 设置：标题
	 */

    public void setShiguName(String shiguName) {
        this.shiguName = shiguName;
    }
    /**
	 * 获取：事故时间
	 */
    public Date getShiguTime() {
        return shiguTime;
    }
    /**
	 * 设置：事故时间
	 */

    public void setShiguTime(Date shiguTime) {
        this.shiguTime = shiguTime;
    }
    /**
	 * 获取：地点
	 */
    public String getShiguAddress() {
        return shiguAddress;
    }
    /**
	 * 设置：地点
	 */

    public void setShiguAddress(String shiguAddress) {
        this.shiguAddress = shiguAddress;
    }
    /**
	 * 获取：事故类型
	 */
    public Integer getShiguTypes() {
        return shiguTypes;
    }
    /**
	 * 设置：事故类型
	 */

    public void setShiguTypes(Integer shiguTypes) {
        this.shiguTypes = shiguTypes;
    }
    /**
	 * 获取：严重程度
	 */
    public Integer getYanzhengTypes() {
        return yanzhengTypes;
    }
    /**
	 * 设置：严重程度
	 */

    public void setYanzhengTypes(Integer yanzhengTypes) {
        this.yanzhengTypes = yanzhengTypes;
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
    public String getShiguText() {
        return shiguText;
    }
    /**
	 * 设置：备注
	 */

    public void setShiguText(String shiguText) {
        this.shiguText = shiguText;
    }
    /**
	 * 获取：详情
	 */
    public String getShiguContent() {
        return shiguContent;
    }
    /**
	 * 设置：详情
	 */

    public void setShiguContent(String shiguContent) {
        this.shiguContent = shiguContent;
    }
    /**
	 * 获取：逻辑删除
	 */
    public Integer getShiguDelete() {
        return shiguDelete;
    }
    /**
	 * 设置：逻辑删除
	 */

    public void setShiguDelete(Integer shiguDelete) {
        this.shiguDelete = shiguDelete;
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
        return "Shigu{" +
            ", id=" + id +
            ", shiguName=" + shiguName +
            ", shiguTime=" + DateUtil.convertString(shiguTime,"yyyy-MM-dd") +
            ", shiguAddress=" + shiguAddress +
            ", shiguTypes=" + shiguTypes +
            ", yanzhengTypes=" + yanzhengTypes +
            ", yonghuId=" + yonghuId +
            ", shiguText=" + shiguText +
            ", shiguContent=" + shiguContent +
            ", shiguDelete=" + shiguDelete +
            ", createTime=" + DateUtil.convertString(createTime,"yyyy-MM-dd") +
        "}";
    }
}
