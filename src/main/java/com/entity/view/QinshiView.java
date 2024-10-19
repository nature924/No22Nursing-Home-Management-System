package com.entity.view;

import org.apache.tools.ant.util.DateUtils;
import com.annotation.ColumnInfo;
import com.entity.QinshiEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;
import com.utils.DateUtil;

/**
* 寝室信息
* 后端返回视图实体辅助类
* （通常后端关联的表或者自定义的字段需要返回使用）
*/
@TableName("qinshi")
public class QinshiView extends QinshiEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	//当前表
	/**
	* 寝室类型的值
	*/
	@ColumnInfo(comment="寝室类型的字典表值",type="varchar(200)")
	private String qinshiValue;
	/**
	* 寝室状态的值
	*/
	@ColumnInfo(comment="寝室状态的字典表值",type="varchar(200)")
	private String statusValue;




	public QinshiView() {

	}

	public QinshiView(QinshiEntity qinshiEntity) {
		try {
			BeanUtils.copyProperties(this, qinshiEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



	//当前表的
	/**
	* 获取： 寝室类型的值
	*/
	public String getQinshiValue() {
		return qinshiValue;
	}
	/**
	* 设置： 寝室类型的值
	*/
	public void setQinshiValue(String qinshiValue) {
		this.qinshiValue = qinshiValue;
	}
	//当前表的
	/**
	* 获取： 寝室状态的值
	*/
	public String getStatusValue() {
		return statusValue;
	}
	/**
	* 设置： 寝室状态的值
	*/
	public void setStatusValue(String statusValue) {
		this.statusValue = statusValue;
	}




	@Override
	public String toString() {
		return "QinshiView{" +
			", qinshiValue=" + qinshiValue +
			", statusValue=" + statusValue +
			"} " + super.toString();
	}
}
