package com.entity.model;

import com.entity.YinshixihaoEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 饮食喜好
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class YinshixihaoModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 食物名称
     */
    private String yinshixihaoName;


    /**
     * 食物照片
     */
    private String yinshixihaoPhoto;


    /**
     * 食物类型
     */
    private Integer yinshixihaoTypes;


    /**
     * 老人
     */
    private Integer yonghuId;


    /**
     * 食物介绍
     */
    private String yinshixihaoContent;


    /**
     * 逻辑删除
     */
    private Integer yinshixihaoDelete;


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
	 * 获取：食物名称
	 */
    public String getYinshixihaoName() {
        return yinshixihaoName;
    }


    /**
	 * 设置：食物名称
	 */
    public void setYinshixihaoName(String yinshixihaoName) {
        this.yinshixihaoName = yinshixihaoName;
    }
    /**
	 * 获取：食物照片
	 */
    public String getYinshixihaoPhoto() {
        return yinshixihaoPhoto;
    }


    /**
	 * 设置：食物照片
	 */
    public void setYinshixihaoPhoto(String yinshixihaoPhoto) {
        this.yinshixihaoPhoto = yinshixihaoPhoto;
    }
    /**
	 * 获取：食物类型
	 */
    public Integer getYinshixihaoTypes() {
        return yinshixihaoTypes;
    }


    /**
	 * 设置：食物类型
	 */
    public void setYinshixihaoTypes(Integer yinshixihaoTypes) {
        this.yinshixihaoTypes = yinshixihaoTypes;
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
	 * 获取：食物介绍
	 */
    public String getYinshixihaoContent() {
        return yinshixihaoContent;
    }


    /**
	 * 设置：食物介绍
	 */
    public void setYinshixihaoContent(String yinshixihaoContent) {
        this.yinshixihaoContent = yinshixihaoContent;
    }
    /**
	 * 获取：逻辑删除
	 */
    public Integer getYinshixihaoDelete() {
        return yinshixihaoDelete;
    }


    /**
	 * 设置：逻辑删除
	 */
    public void setYinshixihaoDelete(Integer yinshixihaoDelete) {
        this.yinshixihaoDelete = yinshixihaoDelete;
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
