package com.entity.view;

import org.apache.tools.ant.util.DateUtils;
import com.annotation.ColumnInfo;
import com.entity.LaorenjiashuEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;
import com.utils.DateUtil;

/**
* 老人家属信息
* 后端返回视图实体辅助类
* （通常后端关联的表或者自定义的字段需要返回使用）
*/
@TableName("laorenjiashu")
public class LaorenjiashuView extends LaorenjiashuEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	//当前表
	/**
	* 家属身份的值
	*/
	@ColumnInfo(comment="家属身份的字典表值",type="varchar(200)")
	private String laorenjiashuValue;

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
		* 假删
		*/

		@ColumnInfo(comment="假删",type="int(11)")
		private Integer yonghuDelete;
	//级联表 家属
		/**
		* 家属名称
		*/

		@ColumnInfo(comment="家属名称",type="varchar(200)")
		private String jiashuName;
		/**
		* 家属照片
		*/

		@ColumnInfo(comment="家属照片",type="varchar(200)")
		private String jiashuPhoto;
		/**
		* 联系电话
		*/

		@ColumnInfo(comment="联系电话",type="varchar(200)")
		private String jiashuPhone;
		/**
		* 邮箱
		*/

		@ColumnInfo(comment="邮箱",type="varchar(200)")
		private String jiashuEmail;
		/**
		* 逻辑删除
		*/

		@ColumnInfo(comment="逻辑删除",type="int(11)")
		private Integer jiashuDelete;

	//重复字段
			/**
			* 重复字段 的types
			*/
			@ColumnInfo(comment="重复字段 的types",type="Integer")
			private Integer sexTypes;
				@ColumnInfo(comment="重复字段 的值",type="varchar(200)")
				private String sexValue;


	public LaorenjiashuView() {

	}

	public LaorenjiashuView(LaorenjiashuEntity laorenjiashuEntity) {
		try {
			BeanUtils.copyProperties(this, laorenjiashuEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



	//当前表的
	/**
	* 获取： 家属身份的值
	*/
	public String getLaorenjiashuValue() {
		return laorenjiashuValue;
	}
	/**
	* 设置： 家属身份的值
	*/
	public void setLaorenjiashuValue(String laorenjiashuValue) {
		this.laorenjiashuValue = laorenjiashuValue;
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
	//级联表的get和set 家属

		/**
		* 获取： 家属名称
		*/
		public String getJiashuName() {
			return jiashuName;
		}
		/**
		* 设置： 家属名称
		*/
		public void setJiashuName(String jiashuName) {
			this.jiashuName = jiashuName;
		}

		/**
		* 获取： 家属照片
		*/
		public String getJiashuPhoto() {
			return jiashuPhoto;
		}
		/**
		* 设置： 家属照片
		*/
		public void setJiashuPhoto(String jiashuPhoto) {
			this.jiashuPhoto = jiashuPhoto;
		}

		/**
		* 获取： 联系电话
		*/
		public String getJiashuPhone() {
			return jiashuPhone;
		}
		/**
		* 设置： 联系电话
		*/
		public void setJiashuPhone(String jiashuPhone) {
			this.jiashuPhone = jiashuPhone;
		}

		/**
		* 获取： 邮箱
		*/
		public String getJiashuEmail() {
			return jiashuEmail;
		}
		/**
		* 设置： 邮箱
		*/
		public void setJiashuEmail(String jiashuEmail) {
			this.jiashuEmail = jiashuEmail;
		}

		/**
		* 获取： 逻辑删除
		*/
		public Integer getJiashuDelete() {
			return jiashuDelete;
		}
		/**
		* 设置： 逻辑删除
		*/
		public void setJiashuDelete(Integer jiashuDelete) {
			this.jiashuDelete = jiashuDelete;
		}

	//重复字段
			/**
			* 获取： 重复字段 的types
			*/
			public Integer getSexTypes() {
			return sexTypes;
			}
			/**
			* 设置： 重复字段 的types
			*/
			public void setSexTypes(Integer sexTypes) {
			this.sexTypes = sexTypes;
			}
				public String getSexValue() {
				return sexValue;
				}
				public void setSexValue(String sexValue) {
				this.sexValue = sexValue;
				}

	@Override
	public String toString() {
		return "LaorenjiashuView{" +
			", laorenjiashuValue=" + laorenjiashuValue +
			", yonghuName=" + yonghuName +
			", yonghuPhoto=" + yonghuPhoto +
			", yonghuAge=" + yonghuAge +
			", yonghuPhone=" + yonghuPhone +
			", yonghuAddress=" + yonghuAddress +
			", yonghuDelete=" + yonghuDelete +
			", jiashuName=" + jiashuName +
			", jiashuPhoto=" + jiashuPhoto +
			", jiashuPhone=" + jiashuPhone +
			", jiashuEmail=" + jiashuEmail +
			", jiashuDelete=" + jiashuDelete +
			"} " + super.toString();
	}
}
