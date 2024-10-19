package com.dao;

import com.entity.JiashuyijianEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.JiashuyijianView;

/**
 * 家属意见 Dao 接口
 *
 * @author 
 */
public interface JiashuyijianDao extends BaseMapper<JiashuyijianEntity> {

   List<JiashuyijianView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
