
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
 * 体检
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/tijian")
public class TijianController {
    private static final Logger logger = LoggerFactory.getLogger(TijianController.class);

    private static final String TABLE_NAME = "tijian";

    @Autowired
    private TijianService tijianService;


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
        params.put("tijianDeleteStart",1);params.put("tijianDeleteEnd",1);
        CommonUtil.checkMap(params);
        PageUtils page = tijianService.queryPage(params);

        //字典表数据转换
        List<TijianView> list =(List<TijianView>)page.getList();
        for(TijianView c:list){
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
        TijianEntity tijian = tijianService.selectById(id);
        if(tijian !=null){
            //entity转view
            TijianView view = new TijianView();
            BeanUtils.copyProperties( tijian , view );//把实体数据重构到view中
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
    public R save(@RequestBody TijianEntity tijian, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,tijian:{}",this.getClass().getName(),tijian.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");

        Wrapper<TijianEntity> queryWrapper = new EntityWrapper<TijianEntity>()
            .eq("tijian_name", tijian.getTijianName())
            .eq("tijian_types", tijian.getTijianTypes())
            .eq("tijian_delete", tijian.getTijianDelete())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        TijianEntity tijianEntity = tijianService.selectOne(queryWrapper);
        if(tijianEntity==null){
            tijian.setTijianDelete(1);
            tijian.setCreateTime(new Date());
            tijianService.insert(tijian);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody TijianEntity tijian, HttpServletRequest request) throws NoSuchFieldException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        logger.debug("update方法:,,Controller:{},,tijian:{}",this.getClass().getName(),tijian.toString());
        TijianEntity oldTijianEntity = tijianService.selectById(tijian.getId());//查询原先数据

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
        //根据字段查询是否有相同数据
        Wrapper<TijianEntity> queryWrapper = new EntityWrapper<TijianEntity>()
            .notIn("id",tijian.getId())
            .andNew()
            .eq("tijian_name", tijian.getTijianName())
            .eq("tijian_types", tijian.getTijianTypes())
            .eq("tijian_delete", tijian.getTijianDelete())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        TijianEntity tijianEntity = tijianService.selectOne(queryWrapper);
        if("".equals(tijian.getTijianFile()) || "null".equals(tijian.getTijianFile())){
                tijian.setTijianFile(null);
        }
        if(tijianEntity==null){
            tijianService.updateById(tijian);//根据id更新
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
        List<TijianEntity> oldTijianList =tijianService.selectBatchIds(Arrays.asList(ids));//要删除的数据
        ArrayList<TijianEntity> list = new ArrayList<>();
        for(Integer id:ids){
            TijianEntity tijianEntity = new TijianEntity();
            tijianEntity.setId(id);
            tijianEntity.setTijianDelete(2);
            list.add(tijianEntity);
        }
        if(list != null && list.size() >0){
            tijianService.updateBatchById(list);
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
            List<TijianEntity> tijianList = new ArrayList<>();//上传的东西
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
                            TijianEntity tijianEntity = new TijianEntity();
//                            tijianEntity.setTijianName(data.get(0));                    //标题 要改的
//                            tijianEntity.setTijianTypes(Integer.valueOf(data.get(0)));   //体检项目 要改的
//                            tijianEntity.setTijianFile(data.get(0));                    //体检文件 要改的
//                            tijianEntity.setTijianNewMoney(data.get(0));                    //体检价格 要改的
//                            tijianEntity.setTijianContent("");//详情和图片
//                            tijianEntity.setTijianDelete(1);//逻辑删除字段
//                            tijianEntity.setCreateTime(date);//时间
                            tijianList.add(tijianEntity);


                            //把要查询是否重复的字段放入map中
                        }

                        //查询是否重复
                        tijianService.insertBatch(tijianList);
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
