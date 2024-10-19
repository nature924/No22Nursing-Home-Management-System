package com.entity.model;

import com.entity.XuqiudaiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 需求袋
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class XuqiudaiModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 药物
     */
    private Integer yaowuId;


    /**
     * 老人
     */
    private Integer yonghuId;


    /**
     * 需求数量
     */
    private Integer xuqiudaiKucunNumber;


    /**
     * 需求状态
     */
    private Integer xuqiudaiTypes;


    /**
     * 添加时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date insertTime;


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
