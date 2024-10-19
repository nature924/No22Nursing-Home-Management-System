package com.dao;

import com.entity.YinshixihaoEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.YinshixihaoView;

/**
 * 饮食喜好 Dao 接口
 *
 * @author 
 */
public interface YinshixihaoDao extends BaseMapper<YinshixihaoEntity> {

   List<YinshixihaoView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
