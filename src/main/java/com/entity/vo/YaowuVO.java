package com.entity.vo;

import com.entity.YaowuEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 药物
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("yaowu")
public class YaowuVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 药物名称
     */

    @TableField(value = "yaowu_name")
    private String yaowuName;


    /**
     * 药物类型
     */

    @TableField(value = "yaowu_types")
    private Integer yaowuTypes;


    /**
     * 药物数量
     */

    @TableField(value = "yaowu_kucun_number")
    private Integer yaowuKucunNumber;


    /**
     * 药物介绍
     */

    @TableField(value = "yaowu_content")
    private String yaowuContent;


    /**
     * 逻辑删除
     */

    @TableField(value = "yaowu_delete")
    private Integer yaowuDelete;


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
	 * 设置：药物名称
	 */
    public String getYaowuName() {
        return yaowuName;
    }


    /**
	 * 获取：药物名称
	 */

    public void setYaowuName(String yaowuName) {
        this.yaowuName = yaowuName;
    }
    /**
	 * 设置：药物类型
	 */
    public Integer getYaowuTypes() {
        return yaowuTypes;
    }


    /**
	 * 获取：药物类型
	 */

    public void setYaowuTypes(Integer yaowuTypes) {
        this.yaowuTypes = yaowuTypes;
    }
    /**
	 * 设置：药物数量
	 */
    public Integer getYaowuKucunNumber() {
        return yaowuKucunNumber;
    }


    /**
	 * 获取：药物数量
	 */

    public void setYaowuKucunNumber(Integer yaowuKucunNumber) {
        this.yaowuKucunNumber = yaowuKucunNumber;
    }
    /**
	 * 设置：药物介绍
	 */
    public String getYaowuContent() {
        return yaowuContent;
    }


    /**
	 * 获取：药物介绍
	 */

    public void setYaowuContent(String yaowuContent) {
        this.yaowuContent = yaowuContent;
    }
    /**
	 * 设置：逻辑删除
	 */
    public Integer getYaowuDelete() {
        return yaowuDelete;
    }


    /**
	 * 获取：逻辑删除
	 */

    public void setYaowuDelete(Integer yaowuDelete) {
        this.yaowuDelete = yaowuDelete;
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
