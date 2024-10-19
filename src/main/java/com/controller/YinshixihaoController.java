
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
 * 饮食喜好
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/yinshixihao")
public class YinshixihaoController {
    private static final Logger logger = LoggerFactory.getLogger(YinshixihaoController.class);

    private static final String TABLE_NAME = "yinshixihao";

    @Autowired
    private YinshixihaoService yinshixihaoService;


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
        params.put("yinshixihaoDeleteStart",1);params.put("yinshixihaoDeleteEnd",1);
        CommonUtil.checkMap(params);
        PageUtils page = yinshixihaoService.queryPage(params);

        //字典表数据转换
        List<YinshixihaoView> list =(List<YinshixihaoView>)page.getList();
        for(YinshixihaoView c:list){
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
        YinshixihaoEntity yinshixihao = yinshixihaoService.selectById(id);
        if(yinshixihao !=null){
            //entity转view
            YinshixihaoView view = new YinshixihaoView();
            BeanUtils.copyProperties( yinshixihao , view );//把实体数据重构到view中
            //级联表 老人
            //级联表
            YonghuEntity yonghu = yonghuService.selectById(yinshixihao.getYonghuId());
            if(yonghu != null){
            BeanUtils.copyProperties( yonghu , view ,new String[]{ "id", "createTime", "insertTime", "updateTime", "yonghuId"});//把级联的数据添加到view中,并排除id和创建时间字段,当前表的级联注册表
            view.setYonghuId(yonghu.getId());
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
    public R save(@RequestBody YinshixihaoEntity yinshixihao, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,yinshixihao:{}",this.getClass().getName(),yinshixihao.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");
        else if("老人".equals(role))
            yinshixihao.setYonghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));

        Wrapper<YinshixihaoEntity> queryWrapper = new EntityWrapper<YinshixihaoEntity>()
            .eq("yinshixihao_name", yinshixihao.getYinshixihaoName())
            .eq("yinshixihao_types", yinshixihao.getYinshixihaoTypes())
            .eq("yonghu_id", yinshixihao.getYonghuId())
            .eq("yinshixihao_delete", yinshixihao.getYinshixihaoDelete())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        YinshixihaoEntity yinshixihaoEntity = yinshixihaoService.selectOne(queryWrapper);
        if(yinshixihaoEntity==null){
            yinshixihao.setYinshixihaoDelete(1);
            yinshixihao.setCreateTime(new Date());
            yinshixihaoService.insert(yinshixihao);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody YinshixihaoEntity yinshixihao, HttpServletRequest request) throws NoSuchFieldException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        logger.debug("update方法:,,Controller:{},,yinshixihao:{}",this.getClass().getName(),yinshixihao.toString());
        YinshixihaoEntity oldYinshixihaoEntity = yinshixihaoService.selectById(yinshixihao.getId());//查询原先数据

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
//        else if("老人".equals(role))
//            yinshixihao.setYonghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));
        //根据字段查询是否有相同数据
        Wrapper<YinshixihaoEntity> queryWrapper = new EntityWrapper<YinshixihaoEntity>()
            .notIn("id",yinshixihao.getId())
            .andNew()
            .eq("yinshixihao_name", yinshixihao.getYinshixihaoName())
            .eq("yinshixihao_types", yinshixihao.getYinshixihaoTypes())
            .eq("yonghu_id", yinshixihao.getYonghuId())
            .eq("yinshixihao_delete", yinshixihao.getYinshixihaoDelete())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        YinshixihaoEntity yinshixihaoEntity = yinshixihaoService.selectOne(queryWrapper);
        if("".equals(yinshixihao.getYinshixihaoPhoto()) || "null".equals(yinshixihao.getYinshixihaoPhoto())){
                yinshixihao.setYinshixihaoPhoto(null);
        }
        if(yinshixihaoEntity==null){
            yinshixihaoService.updateById(yinshixihao);//根据id更新
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
        List<YinshixihaoEntity> oldYinshixihaoList =yinshixihaoService.selectBatchIds(Arrays.asList(ids));//要删除的数据
        ArrayList<YinshixihaoEntity> list = new ArrayList<>();
        for(Integer id:ids){
            YinshixihaoEntity yinshixihaoEntity = new YinshixihaoEntity();
            yinshixihaoEntity.setId(id);
            yinshixihaoEntity.setYinshixihaoDelete(2);
            list.add(yinshixihaoEntity);
        }
        if(list != null && list.size() >0){
            yinshixihaoService.updateBatchById(list);
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
            List<YinshixihaoEntity> yinshixihaoList = new ArrayList<>();//上传的东西
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
                            YinshixihaoEntity yinshixihaoEntity = new YinshixihaoEntity();
//                            yinshixihaoEntity.setYinshixihaoName(data.get(0));                    //食物名称 要改的
//                            yinshixihaoEntity.setYinshixihaoPhoto("");//详情和图片
//                            yinshixihaoEntity.setYinshixihaoTypes(Integer.valueOf(data.get(0)));   //食物类型 要改的
//                            yinshixihaoEntity.setYonghuId(Integer.valueOf(data.get(0)));   //老人 要改的
//                            yinshixihaoEntity.setYinshixihaoContent("");//详情和图片
//                            yinshixihaoEntity.setYinshixihaoDelete(1);//逻辑删除字段
//                            yinshixihaoEntity.setCreateTime(date);//时间
                            yinshixihaoList.add(yinshixihaoEntity);


                            //把要查询是否重复的字段放入map中
                        }

                        //查询是否重复
                        yinshixihaoService.insertBatch(yinshixihaoList);
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
