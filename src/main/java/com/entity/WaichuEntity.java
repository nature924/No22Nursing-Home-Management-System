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
 * 老人外出信息
 *
 * @author 
 * @email
 */
@TableName("waichu")
public class WaichuEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public WaichuEntity() {

	}

	public WaichuEntity(T t) {
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
    @TableField(value = "waichu_name")

    private String waichuName;


    /**
     * 外出目的
     */
    @ColumnInfo(comment="外出目的",type="int(11)")
    @TableField(value = "waichu_types")

    private Integer waichuTypes;


    /**
     * 外出时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="外出时间",type="timestamp")
    @TableField(value = "waichu_time")

    private Date waichuTime;


    /**
     * 回来时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="回来时间",type="timestamp")
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
    @TableField(value = "waichu_text")

    private String waichuText;


    /**
     * 详情
     */
    @ColumnInfo(comment="详情",type="text")
    @TableField(value = "waichu_content")

    private String waichuContent;


    /**
     * 逻辑删除
     */
    @ColumnInfo(comment="逻辑删除",type="int(11)")
    @TableField(value = "waichu_delete")

    private Integer waichuDelete;


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
    public String getWaichuName() {
        return waichuName;
    }
    /**
	 * 设置：标题
	 */

    public void setWaichuName(String waichuName) {
        this.waichuName = waichuName;
    }
    /**
	 * 获取：外出目的
	 */
    public Integer getWaichuTypes() {
        return waichuTypes;
    }
    /**
	 * 设置：外出目的
	 */

    public void setWaichuTypes(Integer waichuTypes) {
        this.waichuTypes = waichuTypes;
    }
    /**
	 * 获取：外出时间
	 */
    public Date getWaichuTime() {
        return waichuTime;
    }
    /**
	 * 设置：外出时间
	 */

    public void setWaichuTime(Date waichuTime) {
        this.waichuTime = waichuTime;
    }
    /**
	 * 获取：回来时间
	 */
    public Date getHuiliaTime() {
        return huiliaTime;
    }
    /**
	 * 设置：回来时间
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
    public String getWaichuText() {
        return waichuText;
    }
    /**
	 * 设置：备注
	 */

    public void setWaichuText(String waichuText) {
        this.waichuText = waichuText;
    }
    /**
	 * 获取：详情
	 */
    public String getWaichuContent() {
        return waichuContent;
    }
    /**
	 * 设置：详情
	 */

    public void setWaichuContent(String waichuContent) {
        this.waichuContent = waichuContent;
    }
    /**
	 * 获取：逻辑删除
	 */
    public Integer getWaichuDelete() {
        return waichuDelete;
    }
    /**
	 * 设置：逻辑删除
	 */

    public void setWaichuDelete(Integer waichuDelete) {
        this.waichuDelete = waichuDelete;
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
        return "Waichu{" +
            ", id=" + id +
            ", waichuName=" + waichuName +
            ", waichuTypes=" + waichuTypes +
            ", waichuTime=" + DateUtil.convertString(waichuTime,"yyyy-MM-dd") +
            ", huiliaTime=" + DateUtil.convertString(huiliaTime,"yyyy-MM-dd") +
            ", yonghuId=" + yonghuId +
            ", waichuText=" + waichuText +
            ", waichuContent=" + waichuContent +
            ", waichuDelete=" + waichuDelete +
            ", createTime=" + DateUtil.convertString(createTime,"yyyy-MM-dd") +
        "}";
    }
}
