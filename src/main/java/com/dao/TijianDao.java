package com.dao;

import com.entity.TijianEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.TijianView;

/**
 * 体检 Dao 接口
 *
 * @author 
 */
public interface TijianDao extends BaseMapper<TijianEntity> {

   List<TijianView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
