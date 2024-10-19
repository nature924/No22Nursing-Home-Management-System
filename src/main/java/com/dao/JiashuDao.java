package com.dao;

import com.entity.JiashuEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.JiashuView;

/**
 * 家属 Dao 接口
 *
 * @author 
 */
public interface JiashuDao extends BaseMapper<JiashuEntity> {

   List<JiashuView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
