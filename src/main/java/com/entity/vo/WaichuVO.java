package com.entity.vo;

import com.entity.WaichuEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 老人外出信息
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("waichu")
public class WaichuVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 标题
     */

    @TableField(value = "waichu_name")
    private String waichuName;


    /**
     * 外出目的
     */

    @TableField(value = "waichu_types")
    private Integer waichuTypes;


    /**
     * 外出时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "waichu_time")
    private Date waichuTime;


    /**
     * 回来时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "huilia_time")
    private Date huiliaTime;


    /**
     * 老人
     */

    @TableField(value = "yonghu_id")
    private Integer yonghuId;


    /**
     * 备注
     */

    @TableField(value = "waichu_text")
    private String waichuText;


    /**
     * 详情
     */

    @TableField(value = "waichu_content")
    private String waichuContent;


    /**
     * 逻辑删除
     */

    @TableField(value = "waichu_delete")
    private Integer waichuDelete;


    /**
     * 创建时间  show1 show2 photoShow homeMain
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "create_time")
    private Date createTime;


    /**
	 * 设置：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 获取：主键
	 */

    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 设置：标题
	 */
    public String getWaichuName() {
        return waichuName;
    }


    /**
	 * 获取：标题
	 */

    public void setWaichuName(String waichuName) {
        this.waichuName = waichuName;
    }
    /**
	 * 设置：外出目的
	 */
    public Integer getWaichuTypes() {
        return waichuTypes;
    }


    /**
	 * 获取：外出目的
	 */

    public void setWaichuTypes(Integer waichuTypes) {
        this.waichuTypes = waichuTypes;
    }
    /**
	 * 设置：外出时间
	 */
    public Date getWaichuTime() {
        return waichuTime;
    }


    /**
	 * 获取：外出时间
	 */

    public void setWaichuTime(Date waichuTime) {
        this.waichuTime = waichuTime;
    }
    /**
	 * 设置：回来时间
	 */
    public Date getHuiliaTime() {
        return huiliaTime;
    }


    /**
	 * 获取：回来时间
	 */

    public void setHuiliaTime(Date huiliaTime) {
        this.huiliaTime = huiliaTime;
    }
    /**
	 * 设置：老人
	 */
    public Integer getYonghuId() {
        return yonghuId;
    }


    /**
	 * 获取：老人
	 */

    public void setYonghuId(Integer yonghuId) {
        this.yonghuId = yonghuId;
    }
    /**
	 * 设置：备注
	 */
    public String getWaichuText() {
        return waichuText;
    }


    /**
	 * 获取：备注
	 */

    public void setWaichuText(String waichuText) {
        this.waichuText = waichuText;
    }
    /**
	 * 设置：详情
	 */
    public String getWaichuContent() {
        return waichuContent;
    }


    /**
	 * 获取：详情
	 */

    public void setWaichuContent(String waichuContent) {
        this.waichuContent = waichuContent;
    }
    /**
	 * 设置：逻辑删除
	 */
    public Integer getWaichuDelete() {
        return waichuDelete;
    }


    /**
	 * 获取：逻辑删除
	 */

    public void setWaichuDelete(Integer waichuDelete) {
        this.waichuDelete = waichuDelete;
    }
    /**
	 * 设置：创建时间  show1 show2 photoShow homeMain
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间  show1 show2 photoShow homeMain
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
