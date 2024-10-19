package com.entity.model;

import com.entity.MeishiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 食物
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class MeishiModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 食物名称
     */
    private String meishiName;


    /**
     * 食物照片
     */
    private String meishiPhoto;


    /**
     * 食物类型
     */
    private Integer meishiTypes;


    /**
     * 价格
     */
    private Double meishiNewMoney;


    /**
     * 食物介绍
     */
    private String meishiContent;


    /**
     * 逻辑删除
     */
    private Integer meishiDelete;


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
    public String getMeishiName() {
        return meishiName;
    }


    /**
	 * 设置：食物名称
	 */
    public void setMeishiName(String meishiName) {
        this.meishiName = meishiName;
    }
    /**
	 * 获取：食物照片
	 */
    public String getMeishiPhoto() {
        return meishiPhoto;
    }


    /**
	 * 设置：食物照片
	 */
    public void setMeishiPhoto(String meishiPhoto) {
        this.meishiPhoto = meishiPhoto;
    }
    /**
	 * 获取：食物类型
	 */
    public Integer getMeishiTypes() {
        return meishiTypes;
    }


    /**
	 * 设置：食物类型
	 */
    public void setMeishiTypes(Integer meishiTypes) {
        this.meishiTypes = meishiTypes;
    }
    /**
	 * 获取：价格
	 */
    public Double getMeishiNewMoney() {
        return meishiNewMoney;
    }


    /**
	 * 设置：价格
	 */
    public void setMeishiNewMoney(Double meishiNewMoney) {
        this.meishiNewMoney = meishiNewMoney;
    }
    /**
	 * 获取：食物介绍
	 */
    public String getMeishiContent() {
        return meishiContent;
    }


    /**
	 * 设置：食物介绍
	 */
    public void setMeishiContent(String meishiContent) {
        this.meishiContent = meishiContent;
    }
    /**
	 * 获取：逻辑删除
	 */
    public Integer getMeishiDelete() {
        return meishiDelete;
    }


    /**
	 * 设置：逻辑删除
	 */
    public void setMeishiDelete(Integer meishiDelete) {
        this.meishiDelete = meishiDelete;
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
