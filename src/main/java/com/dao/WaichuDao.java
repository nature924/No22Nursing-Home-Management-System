package com.dao;

import com.entity.WaichuEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.WaichuView;

/**
 * 老人外出信息 Dao 接口
 *
 * @author 
 */
public interface WaichuDao extends BaseMapper<WaichuEntity> {

   List<WaichuView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
