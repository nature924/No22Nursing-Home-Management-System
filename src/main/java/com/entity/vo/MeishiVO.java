package com.entity.vo;

import com.entity.MeishiEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 食物
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("meishi")
public class MeishiVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 食物名称
     */

    @TableField(value = "meishi_name")
    private String meishiName;


    /**
     * 食物照片
     */

    @TableField(value = "meishi_photo")
    private String meishiPhoto;


    /**
     * 食物类型
     */

    @TableField(value = "meishi_types")
    private Integer meishiTypes;


    /**
     * 价格
     */

    @TableField(value = "meishi_new_money")
    private Double meishiNewMoney;


    /**
     * 食物介绍
     */

    @TableField(value = "meishi_content")
    private String meishiContent;


    /**
     * 逻辑删除
     */

    @TableField(value = "meishi_delete")
    private Integer meishiDelete;


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
	 * 设置：食物名称
	 */
    public String getMeishiName() {
        return meishiName;
    }


    /**
	 * 获取：食物名称
	 */

    public void setMeishiName(String meishiName) {
        this.meishiName = meishiName;
    }
    /**
	 * 设置：食物照片
	 */
    public String getMeishiPhoto() {
        return meishiPhoto;
    }


    /**
	 * 获取：食物照片
	 */

    public void setMeishiPhoto(String meishiPhoto) {
        this.meishiPhoto = meishiPhoto;
    }
    /**
	 * 设置：食物类型
	 */
    public Integer getMeishiTypes() {
        return meishiTypes;
    }


    /**
	 * 获取：食物类型
	 */

    public void setMeishiTypes(Integer meishiTypes) {
        this.meishiTypes = meishiTypes;
    }
    /**
	 * 设置：价格
	 */
    public Double getMeishiNewMoney() {
        return meishiNewMoney;
    }


    /**
	 * 获取：价格
	 */

    public void setMeishiNewMoney(Double meishiNewMoney) {
        this.meishiNewMoney = meishiNewMoney;
    }
    /**
	 * 设置：食物介绍
	 */
    public String getMeishiContent() {
        return meishiContent;
    }


    /**
	 * 获取：食物介绍
	 */

    public void setMeishiContent(String meishiContent) {
        this.meishiContent = meishiContent;
    }
    /**
	 * 设置：逻辑删除
	 */
    public Integer getMeishiDelete() {
        return meishiDelete;
    }


    /**
	 * 获取：逻辑删除
	 */

    public void setMeishiDelete(Integer meishiDelete) {
        this.meishiDelete = meishiDelete;
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
