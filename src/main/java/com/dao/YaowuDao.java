package com.dao;

import com.entity.YaowuEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.YaowuView;

/**
 * 药物 Dao 接口
 *
 * @author 
 */
public interface YaowuDao extends BaseMapper<YaowuEntity> {

   List<YaowuView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
