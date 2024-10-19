package com.dao;

import com.entity.XuqiudaiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.XuqiudaiView;

/**
 * 需求袋 Dao 接口
 *
 * @author 
 */
public interface XuqiudaiDao extends BaseMapper<XuqiudaiEntity> {

   List<XuqiudaiView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
