package com.wshop.util;

import com.github.pagehelper.PageInfo;
import com.wshop.dto.model.OrderModel;
import freemarker.template.Configuration;
import freemarker.template.Template;
import org.apache.catalina.connector.Request;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by kevin on 2017/8/1.
 */
public class WordUtil {
    /**
     * @Desc：生成word文件
     * @Author：kevin
     * @Date：2017-08-01下午05:33:42
     * @param dataMap word中需要展示的动态数据，用map集合来保存
     * @param templateName word模板名称，例如：test.ftl
     * @param filePath 文件生成的目标路径，例如：D:/wordFile/
     * @param fileName 生成的文件名称，例如：test.doc
     */
    @SuppressWarnings("unchecked")
    public static void createWord(Map dataMap, String templateName, String filePath, String fileName){
        try{
            Configuration configuration = new Configuration();
            configuration.setDefaultEncoding("UTF-8");
            //ftl模板文件统一放至 com.lun.template 包下面
            String tempPath = Class.class.getClass().getResource("/").getPath();
            System.out.println(tempPath);
            configuration.setDirectoryForTemplateLoading(new File(tempPath+"\\"));
            //获取模板
            Template template = configuration.getTemplate(templateName);
            //输出文件
            File outFile = new File(filePath+File.separator+fileName);
            //如果输出目标文件夹不存在，则创建
            if (!outFile.getParentFile().exists()){
                outFile.getParentFile().mkdirs();
            }
            //将模板和数据模型合并生成文件
            Writer out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outFile),"UTF-8"));
            //生成文件
            template.process(dataMap, out);
            //关闭流
            out.flush();
            out.close();
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public static  void  main(String[] args){
        Map dataMap = new HashMap();
        List<OrderModel> list = new ArrayList<>();
        for(int i =0; i<10;i++){
            OrderModel orderModel = new OrderModel();
            orderModel.setMachineNumber("10001"+i);
            orderModel.setColorNumber("Red"+i);
            orderModel.setCodeNumber("RTS-001-100"+i);
            orderModel.setBatchNumber("FY-2017-00"+i);
            orderModel.setMaterial("好材料");
            //orderModel.setNumber(Double.valueOf(100*(i+1)));
            orderModel.setCustomer("顾客您好0"+i);
            orderModel.setPackage2("包装好好");
            orderModel.setRemark("这是一个测试使用的备注信息"+i);
            list.add(orderModel);
        }
        dataMap.put("recordList",list);

        /** 文件名称，唯一字符串 */
        Random r=new Random();
        SimpleDateFormat sdf1=new SimpleDateFormat("yyyyMMdd_HHmmss");
        StringBuffer sb=new StringBuffer();
        sb.append(sdf1.format(new Date()));
        sb.append("_");
        sb.append(r.nextInt(100));

        //文件路径
        String filePath="D:\\";

        //文件唯一名称
        String fileOnlyName = "用freemarker导出的Word文档_"+sb+".doc";

        //文件名称
       String fileName="用freemarker导出的Word文档.doc";
        /** 生成word */
        WordUtil.createWord(dataMap, "productorder.ftl", filePath, fileOnlyName);

    }

    }
