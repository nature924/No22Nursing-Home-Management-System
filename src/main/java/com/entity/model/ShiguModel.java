package com.entity.model;

import com.entity.ShiguEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 老人事故信息
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class ShiguModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 标题
     */
    private String shiguName;


    /**
     * 事故时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date shiguTime;


    /**
     * 地点
     */
    private String shiguAddress;


    /**
     * 事故类型
     */
    private Integer shiguTypes;


    /**
     * 严重程度
     */
    private Integer yanzhengTypes;


    /**
     * 老人
     */
    private Integer yonghuId;


    /**
     * 备注
     */
    private String shiguText;


    /**
     * 详情
     */
    private String shiguContent;


    /**
     * 逻辑删除
     */
    private Integer shiguDelete;


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
