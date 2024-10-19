package com.entity.vo;

import com.entity.FangkeEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 访客信息
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("fangke")
public class FangkeVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 标题
     */

    @TableField(value = "fangke_name")
    private String fangkeName;


    /**
     * 来访人名称
     */

    @TableField(value = "fangke_mingc")
    private String fangkeMingc;


    /**
     * 来访人联系方式
     */

    @TableField(value = "fangke_phone")
    private String fangkePhone;


    /**
     * 来访目的
     */

    @TableField(value = "fangke_types")
    private Integer fangkeTypes;


    /**
     * 来访时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "fangke_time")
    private Date fangkeTime;


    /**
     * 离开时间
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

    @TableField(value = "fangke_text")
    private String fangkeText;


    /**
     * 详情
     */

    @TableField(value = "fangke_content")
    private String fangkeContent;


    /**
     * 逻辑删除
     */

    @TableField(value = "fangke_delete")
    private Integer fangkeDelete;


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
    public String getFangkeName() {
        return fangkeName;
    }


    /**
	 * 获取：标题
	 */

    public void setFangkeName(String fangkeName) {
        this.fangkeName = fangkeName;
    }
    /**
	 * 设置：来访人名称
	 */
    public String getFangkeMingc() {
        return fangkeMingc;
    }


    /**
	 * 获取：来访人名称
	 */

    public void setFangkeMingc(String fangkeMingc) {
        this.fangkeMingc = fangkeMingc;
    }
    /**
	 * 设置：来访人联系方式
	 */
    public String getFangkePhone() {
        return fangkePhone;
    }


    /**
	 * 获取：来访人联系方式
	 */

    public void setFangkePhone(String fangkePhone) {
        this.fangkePhone = fangkePhone;
    }
    /**
	 * 设置：来访目的
	 */
    public Integer getFangkeTypes() {
        return fangkeTypes;
    }


    /**
	 * 获取：来访目的
	 */

    public void setFangkeTypes(Integer fangkeTypes) {
        this.fangkeTypes = fangkeTypes;
    }
    /**
	 * 设置：来访时间
	 */
    public Date getFangkeTime() {
        return fangkeTime;
    }


    /**
	 * 获取：来访时间
	 */

    public void setFangkeTime(Date fangkeTime) {
        this.fangkeTime = fangkeTime;
    }
    /**
	 * 设置：离开时间
	 */
    public Date getHuiliaTime() {
        return huiliaTime;
    }


    /**
	 * 获取：离开时间
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
    public String getFangkeText() {
        return fangkeText;
    }


    /**
	 * 获取：备注
	 */

    public void setFangkeText(String fangkeText) {
        this.fangkeText = fangkeText;
    }
    /**
	 * 设置：详情
	 */
    public String getFangkeContent() {
        return fangkeContent;
    }


    /**
	 * 获取：详情
	 */

    public void setFangkeContent(String fangkeContent) {
        this.fangkeContent = fangkeContent;
    }
    /**
	 * 设置：逻辑删除
	 */
    public Integer getFangkeDelete() {
        return fangkeDelete;
    }


    /**
	 * 获取：逻辑删除
	 */

    public void setFangkeDelete(Integer fangkeDelete) {
        this.fangkeDelete = fangkeDelete;
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
