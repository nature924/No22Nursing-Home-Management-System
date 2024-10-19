
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
 * 寝室信息
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/qinshi")
public class QinshiController {
    private static final Logger logger = LoggerFactory.getLogger(QinshiController.class);

    private static final String TABLE_NAME = "qinshi";

    @Autowired
    private QinshiService qinshiService;


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
        params.put("qinshiDeleteStart",1);params.put("qinshiDeleteEnd",1);
        CommonUtil.checkMap(params);
        PageUtils page = qinshiService.queryPage(params);

        //字典表数据转换
        List<QinshiView> list =(List<QinshiView>)page.getList();
        for(QinshiView c:list){
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
        QinshiEntity qinshi = qinshiService.selectById(id);
        if(qinshi !=null){
            //entity转view
            QinshiView view = new QinshiView();
            BeanUtils.copyProperties( qinshi , view );//把实体数据重构到view中
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
    public R save(@RequestBody QinshiEntity qinshi, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,qinshi:{}",this.getClass().getName(),qinshi.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");

        Wrapper<QinshiEntity> queryWrapper = new EntityWrapper<QinshiEntity>()
            .eq("qinshi_name", qinshi.getQinshiName())
            .eq("qinshi_types", qinshi.getQinshiTypes())
            .eq("status_types", qinshi.getStatusTypes())
            .eq("qinshi_delete", qinshi.getQinshiDelete())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        QinshiEntity qinshiEntity = qinshiService.selectOne(queryWrapper);
        if(qinshiEntity==null){
            qinshi.setQinshiDelete(1);
            qinshi.setCreateTime(new Date());
            qinshiService.insert(qinshi);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody QinshiEntity qinshi, HttpServletRequest request) throws NoSuchFieldException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        logger.debug("update方法:,,Controller:{},,qinshi:{}",this.getClass().getName(),qinshi.toString());
        QinshiEntity oldQinshiEntity = qinshiService.selectById(qinshi.getId());//查询原先数据

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
        //根据字段查询是否有相同数据
        Wrapper<QinshiEntity> queryWrapper = new EntityWrapper<QinshiEntity>()
            .notIn("id",qinshi.getId())
            .andNew()
            .eq("qinshi_name", qinshi.getQinshiName())
            .eq("qinshi_types", qinshi.getQinshiTypes())
            .eq("status_types", qinshi.getStatusTypes())
            .eq("qinshi_delete", qinshi.getQinshiDelete())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        QinshiEntity qinshiEntity = qinshiService.selectOne(queryWrapper);
        if(qinshiEntity==null){
            qinshiService.updateById(qinshi);//根据id更新
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
        List<QinshiEntity> oldQinshiList =qinshiService.selectBatchIds(Arrays.asList(ids));//要删除的数据
        ArrayList<QinshiEntity> list = new ArrayList<>();
        for(Integer id:ids){
            QinshiEntity qinshiEntity = new QinshiEntity();
            qinshiEntity.setId(id);
            qinshiEntity.setQinshiDelete(2);
            list.add(qinshiEntity);
        }
        if(list != null && list.size() >0){
            qinshiService.updateBatchById(list);
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
            List<QinshiEntity> qinshiList = new ArrayList<>();//上传的东西
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
                            QinshiEntity qinshiEntity = new QinshiEntity();
//                            qinshiEntity.setQinshiName(data.get(0));                    //寝室位置 要改的
//                            qinshiEntity.setQinshiTypes(Integer.valueOf(data.get(0)));   //寝室类型 要改的
//                            qinshiEntity.setStatusTypes(Integer.valueOf(data.get(0)));   //寝室状态 要改的
//                            qinshiEntity.setQinshiContent("");//详情和图片
//                            qinshiEntity.setQinshiDelete(1);//逻辑删除字段
//                            qinshiEntity.setCreateTime(date);//时间
                            qinshiList.add(qinshiEntity);


                            //把要查询是否重复的字段放入map中
                        }

                        //查询是否重复
                        qinshiService.insertBatch(qinshiList);
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
