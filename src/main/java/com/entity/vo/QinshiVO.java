package com.entity.vo;

import com.entity.QinshiEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 寝室信息
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("qinshi")
public class QinshiVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 寝室位置
     */

    @TableField(value = "qinshi_name")
    private String qinshiName;


    /**
     * 寝室类型
     */

    @TableField(value = "qinshi_types")
    private Integer qinshiTypes;


    /**
     * 寝室状态
     */

    @TableField(value = "status_types")
    private Integer statusTypes;


    /**
     * 寝室详情
     */

    @TableField(value = "qinshi_content")
    private String qinshiContent;


    /**
     * 逻辑删除
     */

    @TableField(value = "qinshi_delete")
    private Integer qinshiDelete;


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
	 * 设置：寝室位置
	 */
    public String getQinshiName() {
        return qinshiName;
    }


    /**
	 * 获取：寝室位置
	 */

    public void setQinshiName(String qinshiName) {
        this.qinshiName = qinshiName;
    }
    /**
	 * 设置：寝室类型
	 */
    public Integer getQinshiTypes() {
        return qinshiTypes;
    }


    /**
	 * 获取：寝室类型
	 */

    public void setQinshiTypes(Integer qinshiTypes) {
        this.qinshiTypes = qinshiTypes;
    }
    /**
	 * 设置：寝室状态
	 */
    public Integer getStatusTypes() {
        return statusTypes;
    }


    /**
	 * 获取：寝室状态
	 */

    public void setStatusTypes(Integer statusTypes) {
        this.statusTypes = statusTypes;
    }
    /**
	 * 设置：寝室详情
	 */
    public String getQinshiContent() {
        return qinshiContent;
    }


    /**
	 * 获取：寝室详情
	 */

    public void setQinshiContent(String qinshiContent) {
        this.qinshiContent = qinshiContent;
    }
    /**
	 * 设置：逻辑删除
	 */
    public Integer getQinshiDelete() {
        return qinshiDelete;
    }


    /**
	 * 获取：逻辑删除
	 */

    public void setQinshiDelete(Integer qinshiDelete) {
        this.qinshiDelete = qinshiDelete;
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
