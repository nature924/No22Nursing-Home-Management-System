package com.entity.model;

import com.entity.FangkeEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 访客信息
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class FangkeModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 标题
     */
    private String fangkeName;


    /**
     * 来访人名称
     */
    private String fangkeMingc;


    /**
     * 来访人联系方式
     */
    private String fangkePhone;


    /**
     * 来访目的
     */
    private Integer fangkeTypes;


    /**
     * 来访时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date fangkeTime;


    /**
     * 离开时间
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
    private String fangkeText;


    /**
     * 详情
     */
    private String fangkeContent;


    /**
     * 逻辑删除
     */
    private Integer fangkeDelete;


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
