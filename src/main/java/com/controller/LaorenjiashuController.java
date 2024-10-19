
package com.controller;

import java.io.File;
import java.math.BigDecimal;
import java.net.URL;
import java.text.SimpleDateFormat;

import com.alibaba.fastjson.JSONObject;

import java.util.*;

import org.springframework.beans.BeanUtils;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.context.ContextLoader;

import javax.servlet.ServletContext;

import com.service.TokenService;
import com.utils.*;

import java.lang.reflect.InvocationTargetException;

import com.service.DictionaryService;
import org.apache.commons.lang3.StringUtils;
import com.annotation.IgnoreAuth;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.entity.*;
import com.entity.view.*;
import com.service.*;
import com.utils.PageUtils;
import com.utils.R;
import com.alibaba.fastjson.*;

/**
 * 老人家属信息
 * 后端接口
 *
 * @author
 * @email
 */
@RestController
@Controller
@RequestMapping("/laorenjiashu")
public class LaorenjiashuController {
    private static final Logger logger = LoggerFactory.getLogger(LaorenjiashuController.class);

    private static final String TABLE_NAME = "laorenjiashu";

    @Autowired
    private LaorenjiashuService laorenjiashuService;


    @Autowired
    private TokenService tokenService;
    @Autowired
    private DictionaryService dictionaryService;

    //级联表非注册的service
    @Autowired
    private YonghuService yonghuService;
    @Autowired
    private JiashuService jiashuService;


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, HttpServletRequest request) {
        logger.debug("page方法:,,Controller:{},,params:{}", this.getClass().getName(), JSONObject.toJSONString(params));
        String role = String.valueOf(request.getSession().getAttribute("role"));
        if (false)
            return R.error(511, "永不会进入");
        else if ("老人".equals(role))
            params.put("yonghuId", request.getSession().getAttribute("userId"));
        else if ("家属".equals(role))
            params.put("jiashuId", request.getSession().getAttribute("userId"));
        CommonUtil.checkMap(params);
        PageUtils page = laorenjiashuService.queryPage(params);

        //字典表数据转换
        List<LaorenjiashuView> list = (List<LaorenjiashuView>) page.getList();
        for (LaorenjiashuView c : list) {
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(c, request);
        }
        return R.ok().put("data", page);
    }

    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id, HttpServletRequest request) {
        logger.debug("info方法:,,Controller:{},,id:{}", this.getClass().getName(), id);
        LaorenjiashuEntity laorenjiashu = laorenjiashuService.selectById(id);
        if (laorenjiashu != null) {
            //entity转view
            LaorenjiashuView view = new LaorenjiashuView();
            BeanUtils.copyProperties(laorenjiashu, view);//把实体数据重构到view中
            //级联表 老人
            //级联表
            YonghuEntity yonghu = yonghuService.selectById(laorenjiashu.getYonghuId());
            if (yonghu != null) {
                BeanUtils.copyProperties(yonghu, view, new String[]{"id", "createTime", "insertTime", "updateTime", "jiashuId"
                        , "yonghuId"});//把级联的数据添加到view中,并排除id和创建时间字段,当前表的级联注册表
                view.setYonghuId(yonghu.getId());
            }
            //级联表 家属
            //级联表
            JiashuEntity jiashu = jiashuService.selectById(laorenjiashu.getJiashuId());
            if (jiashu != null) {
                BeanUtils.copyProperties(jiashu, view, new String[]{"id", "createTime", "insertTime", "updateTime", "jiashuId"
                        , "yonghuId"});//把级联的数据添加到view中,并排除id和创建时间字段,当前表的级联注册表
                view.setJiashuId(jiashu.getId());
            }
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(view, request);
            return R.ok().put("data", view);
        } else {
            return R.error(511, "查不到数据");
        }

    }

    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody LaorenjiashuEntity laorenjiashu, HttpServletRequest request) {
        logger.debug("save方法:,,Controller:{},,laorenjiashu:{}", this.getClass().getName(), laorenjiashu.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if (false)
            return R.error(511, "永远不会进入");
        else if ("家属".equals(role))
            laorenjiashu.setJiashuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));
        else if ("老人".equals(role))
            laorenjiashu.setYonghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));

        Wrapper<LaorenjiashuEntity> queryWrapper = new EntityWrapper<LaorenjiashuEntity>()
                .eq("yonghu_id", laorenjiashu.getYonghuId())
                .eq("jiashu_id", laorenjiashu.getJiashuId());

        logger.info("sql语句:" + queryWrapper.getSqlSegment());
        LaorenjiashuEntity laorenjiashuEntity = laorenjiashuService.selectOne(queryWrapper);
        if (laorenjiashuEntity == null) {
            laorenjiashu.setInsertTime(new Date());
            laorenjiashu.setCreateTime(new Date());
            laorenjiashuService.insert(laorenjiashu);
            return R.ok();
        } else {
            return R.error(511, "请不要重复添加");
        }
    }

    /**
     * 后端修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody LaorenjiashuEntity laorenjiashu, HttpServletRequest request) throws NoSuchFieldException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        logger.debug("update方法:,,Controller:{},,laorenjiashu:{}", this.getClass().getName(), laorenjiashu.toString());
        LaorenjiashuEntity oldLaorenjiashuEntity = laorenjiashuService.selectById(laorenjiashu.getId());//查询原先数据

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
//        else if("家属".equals(role))
//            laorenjiashu.setJiashuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));
//        else if("老人".equals(role))
//            laorenjiashu.setYonghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));
        //根据字段查询是否有相同数据
        Wrapper<LaorenjiashuEntity> queryWrapper = new EntityWrapper<LaorenjiashuEntity>()
                .notIn("id", laorenjiashu.getId())
                .andNew()
                .eq("yonghu_id", laorenjiashu.getYonghuId())
                .eq("jiashu_id", laorenjiashu.getJiashuId())
                .eq("laorenjiashu_types", laorenjiashu.getLaorenjiashuTypes());

        logger.info("sql语句:" + queryWrapper.getSqlSegment());
        LaorenjiashuEntity laorenjiashuEntity = laorenjiashuService.selectOne(queryWrapper);
        if (laorenjiashuEntity == null) {
            laorenjiashuService.updateById(laorenjiashu);//根据id更新
            return R.ok();
        } else {
            return R.error(511, "表中有相同数据");
        }
    }


    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids, HttpServletRequest request) {
        logger.debug("delete:,,Controller:{},,ids:{}", this.getClass().getName(), ids.toString());
        List<LaorenjiashuEntity> oldLaorenjiashuList = laorenjiashuService.selectBatchIds(Arrays.asList(ids));//要删除的数据
        laorenjiashuService.deleteBatchIds(Arrays.asList(ids));

        return R.ok();
    }


    /**
     * 批量上传
     */
    @RequestMapping("/batchInsert")
    public R save(String fileName, HttpServletRequest request) {
        logger.debug("batchInsert方法:,,Controller:{},,fileName:{}", this.getClass().getName(), fileName);
        Integer yonghuId = Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId")));
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            List<LaorenjiashuEntity> laorenjiashuList = new ArrayList<>();//上传的东西
            Map<String, List<String>> seachFields = new HashMap<>();//要查询的字段
            Date date = new Date();
            int lastIndexOf = fileName.lastIndexOf(".");
            if (lastIndexOf == -1) {
                return R.error(511, "该文件没有后缀");
            } else {
                String suffix = fileName.substring(lastIndexOf);
                if (!".xls".equals(suffix)) {
                    return R.error(511, "只支持后缀为xls的excel文件");
                } else {
                    URL resource = this.getClass().getClassLoader().getResource("static/upload/" + fileName);//获取文件路径
                    File file = new File(resource.getFile());
                    if (!file.exists()) {
                        return R.error(511, "找不到上传文件，请联系管理员");
                    } else {
                        List<List<String>> dataList = PoiUtil.poiImport(file.getPath());//读取xls文件
                        dataList.remove(0);//删除第一行，因为第一行是提示
                        for (List<String> data : dataList) {
                            //循环
                            LaorenjiashuEntity laorenjiashuEntity = new LaorenjiashuEntity();
//                            laorenjiashuEntity.setYonghuId(Integer.valueOf(data.get(0)));   //老人 要改的
//                            laorenjiashuEntity.setJiashuId(Integer.valueOf(data.get(0)));   //家属 要改的
//                            laorenjiashuEntity.setLaorenjiashuTypes(Integer.valueOf(data.get(0)));   //家属身份 要改的
//                            laorenjiashuEntity.setInsertTime(date);//时间
//                            laorenjiashuEntity.setCreateTime(date);//时间
                            laorenjiashuList.add(laorenjiashuEntity);


                            //把要查询是否重复的字段放入map中
                        }

                        //查询是否重复
                        laorenjiashuService.insertBatch(laorenjiashuList);
                        return R.ok();
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            return R.error(511, "批量插入数据异常，请联系管理员");
        }
    }


}
