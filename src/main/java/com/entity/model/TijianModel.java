package com.entity.model;

import com.entity.TijianEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 体检
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class TijianModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 标题
     */
    private String tijianName;


    /**
     * 体检项目
     */
    private Integer tijianTypes;


    /**
     * 体检文件
     */
    private String tijianFile;


    /**
     * 体检价格
     */
    private Double tijianNewMoney;


    /**
     * 体检项目介绍
     */
    private String tijianContent;


    /**
     * 逻辑删除
     */
    private Integer tijianDelete;


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
    public String getTijianName() {
        return tijianName;
    }


    /**
	 * 设置：标题
	 */
    public void setTijianName(String tijianName) {
        this.tijianName = tijianName;
    }
    /**
	 * 获取：体检项目
	 */
    public Integer getTijianTypes() {
        return tijianTypes;
    }


    /**
	 * 设置：体检项目
	 */
    public void setTijianTypes(Integer tijianTypes) {
        this.tijianTypes = tijianTypes;
    }
    /**
	 * 获取：体检文件
	 */
    public String getTijianFile() {
        return tijianFile;
    }


    /**
	 * 设置：体检文件
	 */
    public void setTijianFile(String tijianFile) {
        this.tijianFile = tijianFile;
    }
    /**
	 * 获取：体检价格
	 */
    public Double getTijianNewMoney() {
        return tijianNewMoney;
    }


    /**
	 * 设置：体检价格
	 */
    public void setTijianNewMoney(Double tijianNewMoney) {
        this.tijianNewMoney = tijianNewMoney;
    }
    /**
	 * 获取：体检项目介绍
	 */
    public String getTijianContent() {
        return tijianContent;
    }


    /**
	 * 设置：体检项目介绍
	 */
    public void setTijianContent(String tijianContent) {
        this.tijianContent = tijianContent;
    }
    /**
	 * 获取：逻辑删除
	 */
    public Integer getTijianDelete() {
        return tijianDelete;
    }


    /**
	 * 设置：逻辑删除
	 */
    public void setTijianDelete(Integer tijianDelete) {
        this.tijianDelete = tijianDelete;
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
