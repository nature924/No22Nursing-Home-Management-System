package com.dao;

import com.entity.LaorenjiashuEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.LaorenjiashuView;

/**
 * 老人家属信息 Dao 接口
 *
 * @author 
 */
public interface LaorenjiashuDao extends BaseMapper<LaorenjiashuEntity> {

   List<LaorenjiashuView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
