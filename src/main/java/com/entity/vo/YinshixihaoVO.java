package com.entity.vo;

import com.entity.YinshixihaoEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 饮食喜好
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("yinshixihao")
public class YinshixihaoVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 食物名称
     */

    @TableField(value = "yinshixihao_name")
    private String yinshixihaoName;


    /**
     * 食物照片
     */

    @TableField(value = "yinshixihao_photo")
    private String yinshixihaoPhoto;


    /**
     * 食物类型
     */

    @TableField(value = "yinshixihao_types")
    private Integer yinshixihaoTypes;


    /**
     * 老人
     */

    @TableField(value = "yonghu_id")
    private Integer yonghuId;


    /**
     * 食物介绍
     */

    @TableField(value = "yinshixihao_content")
    private String yinshixihaoContent;


    /**
     * 逻辑删除
     */

    @TableField(value = "yinshixihao_delete")
    private Integer yinshixihaoDelete;


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
    public String getYinshixihaoName() {
        return yinshixihaoName;
    }


    /**
	 * 获取：食物名称
	 */

    public void setYinshixihaoName(String yinshixihaoName) {
        this.yinshixihaoName = yinshixihaoName;
    }
    /**
	 * 设置：食物照片
	 */
    public String getYinshixihaoPhoto() {
        return yinshixihaoPhoto;
    }


    /**
	 * 获取：食物照片
	 */

    public void setYinshixihaoPhoto(String yinshixihaoPhoto) {
        this.yinshixihaoPhoto = yinshixihaoPhoto;
    }
    /**
	 * 设置：食物类型
	 */
    public Integer getYinshixihaoTypes() {
        return yinshixihaoTypes;
    }


    /**
	 * 获取：食物类型
	 */

    public void setYinshixihaoTypes(Integer yinshixihaoTypes) {
        this.yinshixihaoTypes = yinshixihaoTypes;
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
	 * 设置：食物介绍
	 */
    public String getYinshixihaoContent() {
        return yinshixihaoContent;
    }


    /**
	 * 获取：食物介绍
	 */

    public void setYinshixihaoContent(String yinshixihaoContent) {
        this.yinshixihaoContent = yinshixihaoContent;
    }
    /**
	 * 设置：逻辑删除
	 */
    public Integer getYinshixihaoDelete() {
        return yinshixihaoDelete;
    }


    /**
	 * 获取：逻辑删除
	 */

    public void setYinshixihaoDelete(Integer yinshixihaoDelete) {
        this.yinshixihaoDelete = yinshixihaoDelete;
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
