package com.dao;

import com.entity.QinshiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.QinshiView;

/**
 * 寝室信息 Dao 接口
 *
 * @author 
 */
public interface QinshiDao extends BaseMapper<QinshiEntity> {

   List<QinshiView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
