package com.entity.model;

import com.entity.QinshiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 寝室信息
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class QinshiModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 寝室位置
     */
    private String qinshiName;


    /**
     * 寝室类型
     */
    private Integer qinshiTypes;


    /**
     * 寝室状态
     */
    private Integer statusTypes;


    /**
     * 寝室详情
     */
    private String qinshiContent;


    /**
     * 逻辑删除
     */
    private Integer qinshiDelete;


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
	 * 获取：寝室位置
	 */
    public String getQinshiName() {
        return qinshiName;
    }


    /**
	 * 设置：寝室位置
	 */
    public void setQinshiName(String qinshiName) {
        this.qinshiName = qinshiName;
    }
    /**
	 * 获取：寝室类型
	 */
    public Integer getQinshiTypes() {
        return qinshiTypes;
    }


    /**
	 * 设置：寝室类型
	 */
    public void setQinshiTypes(Integer qinshiTypes) {
        this.qinshiTypes = qinshiTypes;
    }
    /**
	 * 获取：寝室状态
	 */
    public Integer getStatusTypes() {
        return statusTypes;
    }


    /**
	 * 设置：寝室状态
	 */
    public void setStatusTypes(Integer statusTypes) {
        this.statusTypes = statusTypes;
    }
    /**
	 * 获取：寝室详情
	 */
    public String getQinshiContent() {
        return qinshiContent;
    }


    /**
	 * 设置：寝室详情
	 */
    public void setQinshiContent(String qinshiContent) {
        this.qinshiContent = qinshiContent;
    }
    /**
	 * 获取：逻辑删除
	 */
    public Integer getQinshiDelete() {
        return qinshiDelete;
    }


    /**
	 * 设置：逻辑删除
	 */
    public void setQinshiDelete(Integer qinshiDelete) {
        this.qinshiDelete = qinshiDelete;
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
