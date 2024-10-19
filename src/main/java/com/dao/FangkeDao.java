package com.dao;

import com.entity.FangkeEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.FangkeView;

/**
 * 访客信息 Dao 接口
 *
 * @author 
 */
public interface FangkeDao extends BaseMapper<FangkeEntity> {

   List<FangkeView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
