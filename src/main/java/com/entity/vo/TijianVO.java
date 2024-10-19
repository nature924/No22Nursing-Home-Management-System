package com.entity.vo;

import com.entity.TijianEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 体检
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("tijian")
public class TijianVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 标题
     */

    @TableField(value = "tijian_name")
    private String tijianName;


    /**
     * 体检项目
     */

    @TableField(value = "tijian_types")
    private Integer tijianTypes;


    /**
     * 体检文件
     */

    @TableField(value = "tijian_file")
    private String tijianFile;


    /**
     * 体检价格
     */

    @TableField(value = "tijian_new_money")
    private Double tijianNewMoney;


    /**
     * 体检项目介绍
     */

    @TableField(value = "tijian_content")
    private String tijianContent;


    /**
     * 逻辑删除
     */

    @TableField(value = "tijian_delete")
    private Integer tijianDelete;


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
    public String getTijianName() {
        return tijianName;
    }


    /**
	 * 获取：标题
	 */

    public void setTijianName(String tijianName) {
        this.tijianName = tijianName;
    }
    /**
	 * 设置：体检项目
	 */
    public Integer getTijianTypes() {
        return tijianTypes;
    }


    /**
	 * 获取：体检项目
	 */

    public void setTijianTypes(Integer tijianTypes) {
        this.tijianTypes = tijianTypes;
    }
    /**
	 * 设置：体检文件
	 */
    public String getTijianFile() {
        return tijianFile;
    }


    /**
	 * 获取：体检文件
	 */

    public void setTijianFile(String tijianFile) {
        this.tijianFile = tijianFile;
    }
    /**
	 * 设置：体检价格
	 */
    public Double getTijianNewMoney() {
        return tijianNewMoney;
    }


    /**
	 * 获取：体检价格
	 */

    public void setTijianNewMoney(Double tijianNewMoney) {
        this.tijianNewMoney = tijianNewMoney;
    }
    /**
	 * 设置：体检项目介绍
	 */
    public String getTijianContent() {
        return tijianContent;
    }


    /**
	 * 获取：体检项目介绍
	 */

    public void setTijianContent(String tijianContent) {
        this.tijianContent = tijianContent;
    }
    /**
	 * 设置：逻辑删除
	 */
    public Integer getTijianDelete() {
        return tijianDelete;
    }


    /**
	 * 获取：逻辑删除
	 */

    public void setTijianDelete(Integer tijianDelete) {
        this.tijianDelete = tijianDelete;
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
