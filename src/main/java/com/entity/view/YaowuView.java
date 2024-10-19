package com.entity.view;

import org.apache.tools.ant.util.DateUtils;
import com.annotation.ColumnInfo;
import com.entity.YaowuEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;
import com.utils.DateUtil;

/**
* 药物
* 后端返回视图实体辅助类
* （通常后端关联的表或者自定义的字段需要返回使用）
*/
@TableName("yaowu")
public class YaowuView extends YaowuEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	//当前表
	/**
	* 药物类型的值
	*/
	@ColumnInfo(comment="药物类型的字典表值",type="varchar(200)")
	private String yaowuValue;




	public YaowuView() {

	}

	public YaowuView(YaowuEntity yaowuEntity) {
		try {
			BeanUtils.copyProperties(this, yaowuEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



	//当前表的
	/**
	* 获取： 药物类型的值
	*/
	public String getYaowuValue() {
		return yaowuValue;
	}
	/**
	* 设置： 药物类型的值
	*/
	public void setYaowuValue(String yaowuValue) {
		this.yaowuValue = yaowuValue;
	}




	@Override
	public String toString() {
		return "YaowuView{" +
			", yaowuValue=" + yaowuValue +
			"} " + super.toString();
	}
}
