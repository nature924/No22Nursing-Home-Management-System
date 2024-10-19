package com.entity.view;

import org.apache.tools.ant.util.DateUtils;
import com.annotation.ColumnInfo;
import com.entity.WaichuEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;
import com.utils.DateUtil;

/**
* 老人外出信息
* 后端返回视图实体辅助类
* （通常后端关联的表或者自定义的字段需要返回使用）
*/
@TableName("waichu")
public class WaichuView extends WaichuEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	//当前表
	/**
	* 外出目的的值
	*/
	@ColumnInfo(comment="外出目的的字典表值",type="varchar(200)")
	private String waichuValue;

	//级联表 老人
		/**
		* 老人姓名
		*/

		@ColumnInfo(comment="老人姓名",type="varchar(200)")
		private String yonghuName;
		/**
		* 头像
		*/

		@ColumnInfo(comment="头像",type="varchar(255)")
		private String yonghuPhoto;
		/**
		* 健康状态
		*/
		@ColumnInfo(comment="健康状态",type="int(11)")
		private Integer jiankangTypes;
			/**
			* 健康状态的值
			*/
			@ColumnInfo(comment="健康状态的字典表值",type="varchar(200)")
			private String jiankangValue;
		/**
		* 年龄
		*/

		@ColumnInfo(comment="年龄",type="int(11)")
		private Integer yonghuAge;
		/**
		* 紧急联系方式
		*/

		@ColumnInfo(comment="紧急联系方式",type="varchar(200)")
		private String yonghuPhone;
		/**
		* 住址
		*/

		@ColumnInfo(comment="住址",type="varchar(200)")
		private String yonghuAddress;
		/**
		* 健康报警
		*/
		@ColumnInfo(comment="健康报警",type="int(11)")
		private Integer baojingTypes;
			/**
			* 健康报警的值
			*/
			@ColumnInfo(comment="健康报警的字典表值",type="varchar(200)")
			private String baojingValue;
					 
		/**
		* 老人 的 家属
		*/
		@ColumnInfo(comment="家属",type="int(11)")
		private Integer yonghuJiashuId;
		/**
		* 假删
		*/

		@ColumnInfo(comment="假删",type="int(11)")
		private Integer yonghuDelete;



	public WaichuView() {

	}

	public WaichuView(WaichuEntity waichuEntity) {
		try {
			BeanUtils.copyProperties(this, waichuEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



	//当前表的
	/**
	* 获取： 外出目的的值
	*/
	public String getWaichuValue() {
		return waichuValue;
	}
	/**
	* 设置： 外出目的的值
	*/
	public void setWaichuValue(String waichuValue) {
		this.waichuValue = waichuValue;
	}


	//级联表的get和set 老人

		/**
		* 获取： 老人姓名
		*/
		public String getYonghuName() {
			return yonghuName;
		}
		/**
		* 设置： 老人姓名
		*/
		public void setYonghuName(String yonghuName) {
			this.yonghuName = yonghuName;
		}

		/**
		* 获取： 头像
		*/
		public String getYonghuPhoto() {
			return yonghuPhoto;
		}
		/**
		* 设置： 头像
		*/
		public void setYonghuPhoto(String yonghuPhoto) {
			this.yonghuPhoto = yonghuPhoto;
		}
		/**
		* 获取： 健康状态
		*/
		public Integer getJiankangTypes() {
			return jiankangTypes;
		}
		/**
		* 设置： 健康状态
		*/
		public void setJiankangTypes(Integer jiankangTypes) {
			this.jiankangTypes = jiankangTypes;
		}


			/**
			* 获取： 健康状态的值
			*/
			public String getJiankangValue() {
				return jiankangValue;
			}
			/**
			* 设置： 健康状态的值
			*/
			public void setJiankangValue(String jiankangValue) {
				this.jiankangValue = jiankangValue;
			}

		/**
		* 获取： 年龄
		*/
		public Integer getYonghuAge() {
			return yonghuAge;
		}
		/**
		* 设置： 年龄
		*/
		public void setYonghuAge(Integer yonghuAge) {
			this.yonghuAge = yonghuAge;
		}

		/**
		* 获取： 紧急联系方式
		*/
		public String getYonghuPhone() {
			return yonghuPhone;
		}
		/**
		* 设置： 紧急联系方式
		*/
		public void setYonghuPhone(String yonghuPhone) {
			this.yonghuPhone = yonghuPhone;
		}

		/**
		* 获取： 住址
		*/
		public String getYonghuAddress() {
			return yonghuAddress;
		}
		/**
		* 设置： 住址
		*/
		public void setYonghuAddress(String yonghuAddress) {
			this.yonghuAddress = yonghuAddress;
		}
		/**
		* 获取： 健康报警
		*/
		public Integer getBaojingTypes() {
			return baojingTypes;
		}
		/**
		* 设置： 健康报警
		*/
		public void setBaojingTypes(Integer baojingTypes) {
			this.baojingTypes = baojingTypes;
		}


			/**
			* 获取： 健康报警的值
			*/
			public String getBaojingValue() {
				return baojingValue;
			}
			/**
			* 设置： 健康报警的值
			*/
			public void setBaojingValue(String baojingValue) {
				this.baojingValue = baojingValue;
			}
		/**
		* 获取：老人 的 家属
		*/
		public Integer getYonghuJiashuId() {
			return yonghuJiashuId;
		}
		/**
		* 设置：老人 的 家属
		*/
		public void setYonghuJiashuId(Integer yonghuJiashuId) {
			this.yonghuJiashuId = yonghuJiashuId;
		}

		/**
		* 获取： 假删
		*/
		public Integer getYonghuDelete() {
			return yonghuDelete;
		}
		/**
		* 设置： 假删
		*/
		public void setYonghuDelete(Integer yonghuDelete) {
			this.yonghuDelete = yonghuDelete;
		}


	@Override
	public String toString() {
		return "WaichuView{" +
			", waichuValue=" + waichuValue +
			", yonghuName=" + yonghuName +
			", yonghuPhoto=" + yonghuPhoto +
			", yonghuAge=" + yonghuAge +
			", yonghuPhone=" + yonghuPhone +
			", yonghuAddress=" + yonghuAddress +
			", yonghuDelete=" + yonghuDelete +
			"} " + super.toString();
	}
}
