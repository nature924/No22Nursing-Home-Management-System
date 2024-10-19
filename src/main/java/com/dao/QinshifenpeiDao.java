package com.dao;

import com.entity.QinshifenpeiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.QinshifenpeiView;

/**
 * 寝室分配信息 Dao 接口
 *
 * @author 
 */
public interface QinshifenpeiDao extends BaseMapper<QinshifenpeiEntity> {

   List<QinshifenpeiView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
