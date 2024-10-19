package com.entity.vo;

import com.entity.ShiguEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 老人事故信息
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("shigu")
public class ShiguVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 标题
     */

    @TableField(value = "shigu_name")
    private String shiguName;


    /**
     * 事故时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "shigu_time")
    private Date shiguTime;


    /**
     * 地点
     */

    @TableField(value = "shigu_address")
    private String shiguAddress;


    /**
     * 事故类型
     */

    @TableField(value = "shigu_types")
    private Integer shiguTypes;


    /**
     * 严重程度
     */

    @TableField(value = "yanzheng_types")
    private Integer yanzhengTypes;


    /**
     * 老人
     */

    @TableField(value = "yonghu_id")
    private Integer yonghuId;


    /**
     * 备注
     */

    @TableField(value = "shigu_text")
    private String shiguText;


    /**
     * 详情
     */

    @TableField(value = "shigu_content")
    private String shiguContent;


    /**
     * 逻辑删除
     */

    @TableField(value = "shigu_delete")
    private Integer shiguDelete;


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
    public String getShiguName() {
        return shiguName;
    }


    /**
	 * 获取：标题
	 */

    public void setShiguName(String shiguName) {
        this.shiguName = shiguName;
    }
    /**
	 * 设置：事故时间
	 */
    public Date getShiguTime() {
        return shiguTime;
    }


    /**
	 * 获取：事故时间
	 */

    public void setShiguTime(Date shiguTime) {
        this.shiguTime = shiguTime;
    }
    /**
	 * 设置：地点
	 */
    public String getShiguAddress() {
        return shiguAddress;
    }


    /**
	 * 获取：地点
	 */

    public void setShiguAddress(String shiguAddress) {
        this.shiguAddress = shiguAddress;
    }
    /**
	 * 设置：事故类型
	 */
    public Integer getShiguTypes() {
        return shiguTypes;
    }


    /**
	 * 获取：事故类型
	 */

    public void setShiguTypes(Integer shiguTypes) {
        this.shiguTypes = shiguTypes;
    }
    /**
	 * 设置：严重程度
	 */
    public Integer getYanzhengTypes() {
        return yanzhengTypes;
    }


    /**
	 * 获取：严重程度
	 */

    public void setYanzhengTypes(Integer yanzhengTypes) {
        this.yanzhengTypes = yanzhengTypes;
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
    public String getShiguText() {
        return shiguText;
    }


    /**
	 * 获取：备注
	 */

    public void setShiguText(String shiguText) {
        this.shiguText = shiguText;
    }
    /**
	 * 设置：详情
	 */
    public String getShiguContent() {
        return shiguContent;
    }


    /**
	 * 获取：详情
	 */

    public void setShiguContent(String shiguContent) {
        this.shiguContent = shiguContent;
    }
    /**
	 * 设置：逻辑删除
	 */
    public Integer getShiguDelete() {
        return shiguDelete;
    }


    /**
	 * 获取：逻辑删除
	 */

    public void setShiguDelete(Integer shiguDelete) {
        this.shiguDelete = shiguDelete;
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
