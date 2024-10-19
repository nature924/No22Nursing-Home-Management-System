package com.entity.model;

import com.entity.JiashuyijianEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 家属意见
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class JiashuyijianModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 标题
     */
    private String jiashuyijianName;


    /**
     * 类型 -
     */
    private Integer jiashuyijianTypes;


    /**
     * 家属
     */
    private Integer jiashuId;


    /**
     * 详细信息
     */
    private String jiashuyijianContent;


    /**
     * 逻辑删除
     */
    private Integer jiashuyijianDelete;


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
    public String getJiashuyijianName() {
        return jiashuyijianName;
    }


    /**
	 * 设置：标题
	 */
    public void setJiashuyijianName(String jiashuyijianName) {
        this.jiashuyijianName = jiashuyijianName;
    }
    /**
	 * 获取：类型 -
	 */
    public Integer getJiashuyijianTypes() {
        return jiashuyijianTypes;
    }


    /**
	 * 设置：类型 -
	 */
    public void setJiashuyijianTypes(Integer jiashuyijianTypes) {
        this.jiashuyijianTypes = jiashuyijianTypes;
    }
    /**
	 * 获取：家属
	 */
    public Integer getJiashuId() {
        return jiashuId;
    }


    /**
	 * 设置：家属
	 */
    public void setJiashuId(Integer jiashuId) {
        this.jiashuId = jiashuId;
    }
    /**
	 * 获取：详细信息
	 */
    public String getJiashuyijianContent() {
        return jiashuyijianContent;
    }


    /**
	 * 设置：详细信息
	 */
    public void setJiashuyijianContent(String jiashuyijianContent) {
        this.jiashuyijianContent = jiashuyijianContent;
    }
    /**
	 * 获取：逻辑删除
	 */
    public Integer getJiashuyijianDelete() {
        return jiashuyijianDelete;
    }


    /**
	 * 设置：逻辑删除
	 */
    public void setJiashuyijianDelete(Integer jiashuyijianDelete) {
        this.jiashuyijianDelete = jiashuyijianDelete;
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
