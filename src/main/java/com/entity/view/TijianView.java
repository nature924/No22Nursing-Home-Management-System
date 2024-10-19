package com.entity.view;

import org.apache.tools.ant.util.DateUtils;
import com.annotation.ColumnInfo;
import com.entity.TijianEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;
import com.utils.DateUtil;

/**
* 体检
* 后端返回视图实体辅助类
* （通常后端关联的表或者自定义的字段需要返回使用）
*/
@TableName("tijian")
public class TijianView extends TijianEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	//当前表
	/**
	* 体检项目的值
	*/
	@ColumnInfo(comment="体检项目的字典表值",type="varchar(200)")
	private String tijianValue;




	public TijianView() {

	}

	public TijianView(TijianEntity tijianEntity) {
		try {
			BeanUtils.copyProperties(this, tijianEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



	//当前表的
	/**
	* 获取： 体检项目的值
	*/
	public String getTijianValue() {
		return tijianValue;
	}
	/**
	* 设置： 体检项目的值
	*/
	public void setTijianValue(String tijianValue) {
		this.tijianValue = tijianValue;
	}




	@Override
	public String toString() {
		return "TijianView{" +
			", tijianValue=" + tijianValue +
			"} " + super.toString();
	}
}
