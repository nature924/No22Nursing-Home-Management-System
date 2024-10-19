package com.entity;

import com.annotation.ColumnInfo;
import javax.validation.constraints.*;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;
import java.io.Serializable;
import java.util.*;
import org.apache.tools.ant.util.DateUtils;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.utils.DateUtil;


/**
 * 体检
 *
 * @author 
 * @email
 */
@TableName("tijian")
public class TijianEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public TijianEntity() {

	}

	public TijianEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
    @ColumnInfo(comment="主键",type="int(11)")
    @TableField(value = "id")

    private Integer id;


    /**
     * 标题
     */
    @ColumnInfo(comment="标题",type="varchar(200)")
    @TableField(value = "tijian_name")

    private String tijianName;


    /**
     * 体检项目
     */
    @ColumnInfo(comment="体检项目",type="int(11)")
    @TableField(value = "tijian_types")

    private Integer tijianTypes;


    /**
     * 体检文件
     */
    @ColumnInfo(comment="体检文件",type="varchar(200)")
    @TableField(value = "tijian_file")

    private String tijianFile;


    /**
     * 体检价格
     */
    @ColumnInfo(comment="体检价格",type="decimal(10,2)")
    @TableField(value = "tijian_new_money")

    private Double tijianNewMoney;


    /**
     * 体检项目介绍
     */
    @ColumnInfo(comment="体检项目介绍",type="text")
    @TableField(value = "tijian_content")

    private String tijianContent;


    /**
     * 逻辑删除
     */
    @ColumnInfo(comment="逻辑删除",type="int(11)")
    @TableField(value = "tijian_delete")

    private Integer tijianDelete;


    /**
     * 创建时间     homeMain
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="创建时间     homeMain",type="timestamp")
    @TableField(value = "create_time",fill = FieldFill.INSERT)

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
	 * 获取：创建时间     homeMain
	 */
    public Date getCreateTime() {
        return createTime;
    }
    /**
	 * 设置：创建时间     homeMain
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Tijian{" +
            ", id=" + id +
            ", tijianName=" + tijianName +
            ", tijianTypes=" + tijianTypes +
            ", tijianFile=" + tijianFile +
            ", tijianNewMoney=" + tijianNewMoney +
            ", tijianContent=" + tijianContent +
            ", tijianDelete=" + tijianDelete +
            ", createTime=" + DateUtil.convertString(createTime,"yyyy-MM-dd") +
        "}";
    }
}
