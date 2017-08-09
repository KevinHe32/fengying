package com.wshop.controller;

import com.wshop.dto.model.OrderModel;
import com.wshop.entity.Order;
import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.hwpf.usermodel.Range;
import org.junit.Test;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by kevin on 2017/8/9.
 */
public class HwpfTest {
    @Test
    public void testWrite() throws Exception {
        String templatePath = "D:\\test.doc";
        InputStream is = new FileInputStream(templatePath);
        HWPFDocument doc = new HWPFDocument(is);

        Map data = getData();

        Range range = doc.getRange();

        //把range范围内的${reportDate}替换为当前的日期
//        range.replaceText("${reportDate}", new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
//        range.replaceText("${appleAmt}", "100.00");
//        range.replaceText("${bananaAmt}", "200.00");
//        range.replaceText("${totalAmt}", "300.00");

        OutputStream os = new FileOutputStream("D:\\write.doc");
        //把doc输出到输出流中
        doc.write(os);
        this.closeStream(os);
        this.closeStream(is);
    }

    public static Map getData(){
        Map map = new HashMap();
        List<OrderModel> list = new ArrayList<>();
        for(int i =0; i<10;i++){
            OrderModel orderModel = new OrderModel();
            orderModel.setMachineNumber("10001"+i);
            orderModel.setColorNumber("Red"+i);
            orderModel.setCodeNumber("RTS-001-100"+i);
            orderModel.setBatchNumber("FY-2017-00"+i);
            orderModel.setMaterial("好材料");
            orderModel.setNumber(Double.valueOf(100*(i+1)));
            orderModel.setCustomer("顾客您好0"+i);
            orderModel.setPackage2("包装好好");
            orderModel.setCreatetime(new Date());
            list.add(orderModel);
        }
        map.put("recordList",list);
        return  map;
    }

    /**
     * 关闭输入流
     * @param is
     */
    private void closeStream(InputStream is) {
        if (is != null) {
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 关闭输出流
     * @param os
     */
    private void closeStream(OutputStream os) {
        if (os != null) {
            try {
                os.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
