
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
 * 家属意见
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/jiashuyijian")
public class JiashuyijianController {
    private static final Logger logger = LoggerFactory.getLogger(JiashuyijianController.class);

    private static final String TABLE_NAME = "jiashuyijian";

    @Autowired
    private JiashuyijianService jiashuyijianService;


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
        params.put("jiashuyijianDeleteStart",1);params.put("jiashuyijianDeleteEnd",1);
        CommonUtil.checkMap(params);
        PageUtils page = jiashuyijianService.queryPage(params);

        //字典表数据转换
        List<JiashuyijianView> list =(List<JiashuyijianView>)page.getList();
        for(JiashuyijianView c:list){
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
        JiashuyijianEntity jiashuyijian = jiashuyijianService.selectById(id);
        if(jiashuyijian !=null){
            //entity转view
            JiashuyijianView view = new JiashuyijianView();
            BeanUtils.copyProperties( jiashuyijian , view );//把实体数据重构到view中
            //级联表 家属
            //级联表
            JiashuEntity jiashu = jiashuService.selectById(jiashuyijian.getJiashuId());
            if(jiashu != null){
            BeanUtils.copyProperties( jiashu , view ,new String[]{ "id", "createTime", "insertTime", "updateTime", "jiashuId"});//把级联的数据添加到view中,并排除id和创建时间字段,当前表的级联注册表
            view.setJiashuId(jiashu.getId());
            }
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
    public R save(@RequestBody JiashuyijianEntity jiashuyijian, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,jiashuyijian:{}",this.getClass().getName(),jiashuyijian.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");
        else if("家属".equals(role))
            jiashuyijian.setJiashuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));

        Wrapper<JiashuyijianEntity> queryWrapper = new EntityWrapper<JiashuyijianEntity>()
            .eq("jiashuyijian_name", jiashuyijian.getJiashuyijianName())
            .eq("jiashuyijian_types", jiashuyijian.getJiashuyijianTypes())
            .eq("jiashu_id", jiashuyijian.getJiashuId())
            .eq("jiashuyijian_delete", jiashuyijian.getJiashuyijianDelete())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        JiashuyijianEntity jiashuyijianEntity = jiashuyijianService.selectOne(queryWrapper);
        if(jiashuyijianEntity==null){
            jiashuyijian.setJiashuyijianTypes(2);
            jiashuyijian.setJiashuyijianDelete(1);
            jiashuyijian.setCreateTime(new Date());
            jiashuyijianService.insert(jiashuyijian);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody JiashuyijianEntity jiashuyijian, HttpServletRequest request) throws NoSuchFieldException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        logger.debug("update方法:,,Controller:{},,jiashuyijian:{}",this.getClass().getName(),jiashuyijian.toString());
        JiashuyijianEntity oldJiashuyijianEntity = jiashuyijianService.selectById(jiashuyijian.getId());//查询原先数据

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
//        else if("家属".equals(role))
//            jiashuyijian.setJiashuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));
        //根据字段查询是否有相同数据
        Wrapper<JiashuyijianEntity> queryWrapper = new EntityWrapper<JiashuyijianEntity>()
            .notIn("id",jiashuyijian.getId())
            .andNew()
            .eq("jiashuyijian_name", jiashuyijian.getJiashuyijianName())
            .eq("jiashuyijian_types", jiashuyijian.getJiashuyijianTypes())
            .eq("jiashu_id", jiashuyijian.getJiashuId())
            .eq("jiashuyijian_delete", jiashuyijian.getJiashuyijianDelete())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        JiashuyijianEntity jiashuyijianEntity = jiashuyijianService.selectOne(queryWrapper);
        if(jiashuyijianEntity==null){
            jiashuyijianService.updateById(jiashuyijian);//根据id更新
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
        List<JiashuyijianEntity> oldJiashuyijianList =jiashuyijianService.selectBatchIds(Arrays.asList(ids));//要删除的数据
        ArrayList<JiashuyijianEntity> list = new ArrayList<>();
        for(Integer id:ids){
            JiashuyijianEntity jiashuyijianEntity = new JiashuyijianEntity();
            jiashuyijianEntity.setId(id);
            jiashuyijianEntity.setJiashuyijianDelete(2);
            list.add(jiashuyijianEntity);
        }
        if(list != null && list.size() >0){
            jiashuyijianService.updateBatchById(list);
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
            List<JiashuyijianEntity> jiashuyijianList = new ArrayList<>();//上传的东西
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
                            JiashuyijianEntity jiashuyijianEntity = new JiashuyijianEntity();
//                            jiashuyijianEntity.setJiashuyijianName(data.get(0));                    //标题 要改的
//                            jiashuyijianEntity.setJiashuyijianTypes(Integer.valueOf(data.get(0)));   //类型 - 要改的
//                            jiashuyijianEntity.setJiashuId(Integer.valueOf(data.get(0)));   //家属 要改的
//                            jiashuyijianEntity.setJiashuyijianContent("");//详情和图片
//                            jiashuyijianEntity.setJiashuyijianDelete(1);//逻辑删除字段
//                            jiashuyijianEntity.setCreateTime(date);//时间
                            jiashuyijianList.add(jiashuyijianEntity);


                            //把要查询是否重复的字段放入map中
                        }

                        //查询是否重复
                        jiashuyijianService.insertBatch(jiashuyijianList);
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
