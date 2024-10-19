package com.entity.model;

import com.entity.WaichuEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 老人外出信息
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class WaichuModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 标题
     */
    private String waichuName;


    /**
     * 外出目的
     */
    private Integer waichuTypes;


    /**
     * 外出时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date waichuTime;


    /**
     * 回来时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date huiliaTime;


    /**
     * 老人
     */
    private Integer yonghuId;


    /**
     * 备注
     */
    private String waichuText;


    /**
     * 详情
     */
    private String waichuContent;


    /**
     * 逻辑删除
     */
    private Integer waichuDelete;


    /**
     * 创建时间  show1 show2 photoShow homeMain
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
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
	 * 获取：创建时间  show1 show2 photoShow homeMain
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间  show1 show2 photoShow homeMain
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }
