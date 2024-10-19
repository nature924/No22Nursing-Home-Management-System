package com.entity.vo;

import com.entity.JiashuyijianEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 家属意见
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("jiashuyijian")
public class JiashuyijianVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 标题
     */

    @TableField(value = "jiashuyijian_name")
    private String jiashuyijianName;


    /**
     * 类型 -
     */

    @TableField(value = "jiashuyijian_types")
    private Integer jiashuyijianTypes;


    /**
     * 家属
     */

    @TableField(value = "jiashu_id")
    private Integer jiashuId;


    /**
     * 详细信息
     */

    @TableField(value = "jiashuyijian_content")
    private String jiashuyijianContent;


    /**
     * 逻辑删除
     */

    @TableField(value = "jiashuyijian_delete")
    private Integer jiashuyijianDelete;


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
    public String getJiashuyijianName() {
        return jiashuyijianName;
    }


    /**
	 * 获取：标题
	 */

    public void setJiashuyijianName(String jiashuyijianName) {
        this.jiashuyijianName = jiashuyijianName;
    }
    /**
	 * 设置：类型 -
	 */
    public Integer getJiashuyijianTypes() {
        return jiashuyijianTypes;
    }


    /**
	 * 获取：类型 -
	 */

    public void setJiashuyijianTypes(Integer jiashuyijianTypes) {
        this.jiashuyijianTypes = jiashuyijianTypes;
    }
    /**
	 * 设置：家属
	 */
    public Integer getJiashuId() {
        return jiashuId;
    }


    /**
	 * 获取：家属
	 */

    public void setJiashuId(Integer jiashuId) {
        this.jiashuId = jiashuId;
    }
    /**
	 * 设置：详细信息
	 */
    public String getJiashuyijianContent() {
        return jiashuyijianContent;
    }


    /**
	 * 获取：详细信息
	 */

    public void setJiashuyijianContent(String jiashuyijianContent) {
        this.jiashuyijianContent = jiashuyijianContent;
    }
    /**
	 * 设置：逻辑删除
	 */
    public Integer getJiashuyijianDelete() {
        return jiashuyijianDelete;
    }


    /**
	 * 获取：逻辑删除
	 */

    public void setJiashuyijianDelete(Integer jiashuyijianDelete) {
        this.jiashuyijianDelete = jiashuyijianDelete;
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
