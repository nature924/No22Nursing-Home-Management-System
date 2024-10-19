
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
 * 药物
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/yaowu")
public class YaowuController {
    private static final Logger logger = LoggerFactory.getLogger(YaowuController.class);

    private static final String TABLE_NAME = "yaowu";

    @Autowired
    private YaowuService yaowuService;


    @Autowired
    private TokenService tokenService;
    @Autowired
    private DictionaryService dictionaryService;

    //级联表非注册的service
    //注册表service
    @Autowired
    private YonghuService yonghuService;
    @Autowired
    private JiashuService jiashuService;


    /**
    * 后端列表
    */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("page方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));
        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永不会进入");
        else if("老人".equals(role))
            params.put("yonghuId",request.getSession().getAttribute("userId"));
        else if("家属".equals(role))
            params.put("jiashuId",request.getSession().getAttribute("userId"));
        params.put("yaowuDeleteStart",1);params.put("yaowuDeleteEnd",1);
        CommonUtil.checkMap(params);
        PageUtils page = yaowuService.queryPage(params);

        //字典表数据转换
        List<YaowuView> list =(List<YaowuView>)page.getList();
        for(YaowuView c:list){
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(c, request);
        }
        return R.ok().put("data", page);
    }

    /**
    * 后端详情
    */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("info方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        YaowuEntity yaowu = yaowuService.selectById(id);
        if(yaowu !=null){
            //entity转view
            YaowuView view = new YaowuView();
            BeanUtils.copyProperties( yaowu , view );//把实体数据重构到view中
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(view, request);
            return R.ok().put("data", view);
        }else {
            return R.error(511,"查不到数据");
        }

    }

    /**
    * 后端保存
    */
    @RequestMapping("/save")
    public R save(@RequestBody YaowuEntity yaowu, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,yaowu:{}",this.getClass().getName(),yaowu.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");

        Wrapper<YaowuEntity> queryWrapper = new EntityWrapper<YaowuEntity>()
            .eq("yaowu_name", yaowu.getYaowuName())
            .eq("yaowu_types", yaowu.getYaowuTypes())
            .eq("yaowu_kucun_number", yaowu.getYaowuKucunNumber())
            .eq("yaowu_delete", yaowu.getYaowuDelete())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        YaowuEntity yaowuEntity = yaowuService.selectOne(queryWrapper);
        if(yaowuEntity==null){
            yaowu.setYaowuDelete(1);
            yaowu.setCreateTime(new Date());
            yaowuService.insert(yaowu);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody YaowuEntity yaowu, HttpServletRequest request) throws NoSuchFieldException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        logger.debug("update方法:,,Controller:{},,yaowu:{}",this.getClass().getName(),yaowu.toString());
        YaowuEntity oldYaowuEntity = yaowuService.selectById(yaowu.getId());//查询原先数据

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
        //根据字段查询是否有相同数据
        Wrapper<YaowuEntity> queryWrapper = new EntityWrapper<YaowuEntity>()
            .notIn("id",yaowu.getId())
            .andNew()
            .eq("yaowu_name", yaowu.getYaowuName())
            .eq("yaowu_types", yaowu.getYaowuTypes())
            .eq("yaowu_kucun_number", yaowu.getYaowuKucunNumber())
            .eq("yaowu_delete", yaowu.getYaowuDelete())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        YaowuEntity yaowuEntity = yaowuService.selectOne(queryWrapper);
        if(yaowuEntity==null){
            yaowuService.updateById(yaowu);//根据id更新
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }



    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids, HttpServletRequest request){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        List<YaowuEntity> oldYaowuList =yaowuService.selectBatchIds(Arrays.asList(ids));//要删除的数据
        ArrayList<YaowuEntity> list = new ArrayList<>();
        for(Integer id:ids){
            YaowuEntity yaowuEntity = new YaowuEntity();
            yaowuEntity.setId(id);
            yaowuEntity.setYaowuDelete(2);
            list.add(yaowuEntity);
        }
        if(list != null && list.size() >0){
            yaowuService.updateBatchById(list);
        }

        return R.ok();
    }


    /**
     * 批量上传
     */
    @RequestMapping("/batchInsert")
    public R save( String fileName, HttpServletRequest request){
        logger.debug("batchInsert方法:,,Controller:{},,fileName:{}",this.getClass().getName(),fileName);
        Integer yonghuId = Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId")));
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            List<YaowuEntity> yaowuList = new ArrayList<>();//上传的东西
            Map<String, List<String>> seachFields= new HashMap<>();//要查询的字段
            Date date = new Date();
            int lastIndexOf = fileName.lastIndexOf(".");
            if(lastIndexOf == -1){
                return R.error(511,"该文件没有后缀");
            }else{
                String suffix = fileName.substring(lastIndexOf);
                if(!".xls".equals(suffix)){
                    return R.error(511,"只支持后缀为xls的excel文件");
                }else{
                    URL resource = this.getClass().getClassLoader().getResource("static/upload/" + fileName);//获取文件路径
                    File file = new File(resource.getFile());
                    if(!file.exists()){
                        return R.error(511,"找不到上传文件，请联系管理员");
                    }else{
                        List<List<String>> dataList = PoiUtil.poiImport(file.getPath());//读取xls文件
                        dataList.remove(0);//删除第一行，因为第一行是提示
                        for(List<String> data:dataList){
                            //循环
                            YaowuEntity yaowuEntity = new YaowuEntity();
//                            yaowuEntity.setYaowuName(data.get(0));                    //药物名称 要改的
//                            yaowuEntity.setYaowuTypes(Integer.valueOf(data.get(0)));   //药物类型 要改的
//                            yaowuEntity.setYaowuKucunNumber(Integer.valueOf(data.get(0)));   //药物数量 要改的
//                            yaowuEntity.setYaowuContent("");//详情和图片
//                            yaowuEntity.setYaowuDelete(1);//逻辑删除字段
//                            yaowuEntity.setCreateTime(date);//时间
                            yaowuList.add(yaowuEntity);


                            //把要查询是否重复的字段放入map中
                        }

                        //查询是否重复
                        yaowuService.insertBatch(yaowuList);
                        return R.ok();
                    }
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            return R.error(511,"批量插入数据异常，请联系管理员");
        }
    }





}
