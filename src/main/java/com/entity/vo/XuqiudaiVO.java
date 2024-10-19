package com.entity.vo;

import com.entity.XuqiudaiEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 需求袋
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("xuqiudai")
public class XuqiudaiVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 药物
     */

    @TableField(value = "yaowu_id")
    private Integer yaowuId;


    /**
     * 老人
     */

    @TableField(value = "yonghu_id")
    private Integer yonghuId;


    /**
     * 需求数量
     */

    @TableField(value = "xuqiudai_kucun_number")
    private Integer xuqiudaiKucunNumber;


    /**
     * 需求状态
     */

    @TableField(value = "xuqiudai_types")
    private Integer xuqiudaiTypes;


    /**
     * 添加时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "insert_time")
    private Date insertTime;


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
	 * 设置：药物
	 */
    public Integer getYaowuId() {
        return yaowuId;
    }


    /**
	 * 获取：药物
	 */

    public void setYaowuId(Integer yaowuId) {
        this.yaowuId = yaowuId;
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
	 * 设置：需求数量
	 */
    public Integer getXuqiudaiKucunNumber() {
        return xuqiudaiKucunNumber;
    }


    /**
	 * 获取：需求数量
	 */

    public void setXuqiudaiKucunNumber(Integer xuqiudaiKucunNumber) {
        this.xuqiudaiKucunNumber = xuqiudaiKucunNumber;
    }
    /**
	 * 设置：需求状态
	 */
    public Integer getXuqiudaiTypes() {
        return xuqiudaiTypes;
    }


    /**
	 * 获取：需求状态
	 */

    public void setXuqiudaiTypes(Integer xuqiudaiTypes) {
        this.xuqiudaiTypes = xuqiudaiTypes;
    }
    /**
	 * 设置：添加时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 获取：添加时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
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
