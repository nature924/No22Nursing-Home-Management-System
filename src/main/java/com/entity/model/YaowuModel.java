package com.entity.model;

import com.entity.YaowuEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 药物
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class YaowuModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 药物名称
     */
    private String yaowuName;


    /**
     * 药物类型
     */
    private Integer yaowuTypes;


    /**
     * 药物数量
     */
    private Integer yaowuKucunNumber;


    /**
     * 药物介绍
     */
    private String yaowuContent;


    /**
     * 逻辑删除
     */
    private Integer yaowuDelete;


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
	 * 获取：药物名称
	 */
    public String getYaowuName() {
        return yaowuName;
    }


    /**
	 * 设置：药物名称
	 */
    public void setYaowuName(String yaowuName) {
        this.yaowuName = yaowuName;
    }
    /**
	 * 获取：药物类型
	 */
    public Integer getYaowuTypes() {
        return yaowuTypes;
    }


    /**
	 * 设置：药物类型
	 */
    public void setYaowuTypes(Integer yaowuTypes) {
        this.yaowuTypes = yaowuTypes;
    }
    /**
	 * 获取：药物数量
	 */
    public Integer getYaowuKucunNumber() {
        return yaowuKucunNumber;
    }


    /**
	 * 设置：药物数量
	 */
    public void setYaowuKucunNumber(Integer yaowuKucunNumber) {
        this.yaowuKucunNumber = yaowuKucunNumber;
    }
    /**
	 * 获取：药物介绍
	 */
    public String getYaowuContent() {
        return yaowuContent;
    }


    /**
	 * 设置：药物介绍
	 */
    public void setYaowuContent(String yaowuContent) {
        this.yaowuContent = yaowuContent;
    }
    /**
	 * 获取：逻辑删除
	 */
    public Integer getYaowuDelete() {
        return yaowuDelete;
    }


    /**
	 * 设置：逻辑删除
	 */
    public void setYaowuDelete(Integer yaowuDelete) {
        this.yaowuDelete = yaowuDelete;
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
