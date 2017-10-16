package com.wshop.util;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.List;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

public class GenerateMawbDRSPDF {

	final static String fontPath = Thread.currentThread().getContextClassLoader().getResource("/").getPath()+"\\SIMYOU.TTF";

	public static Font setChineseFont28() {
		BaseFont bf = null;
		Font fontChinese = null;
		try {
			bf = BaseFont.createFont(fontPath,
					BaseFont.IDENTITY_H, BaseFont.EMBEDDED);

			fontChinese = new Font(bf, 28, Font.NORMAL);
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return fontChinese;
	}

	public static Font setChineseFont20() {
		BaseFont bf = null;
		Font fontChinese = null;
		try {
			bf = BaseFont.createFont(fontPath,
					BaseFont.IDENTITY_H, BaseFont.EMBEDDED);

			fontChinese = new Font(bf, 22, Font.NORMAL);
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return fontChinese;
	}

	public static Font setChineseFont18() {
		BaseFont bf = null;
		Font fontChinese = null;
		try {
			bf = BaseFont.createFont(fontPath,
					BaseFont.IDENTITY_H, BaseFont.EMBEDDED);

			fontChinese = new Font(bf, 14, Font.NORMAL);
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return fontChinese;
	}


	public static void main(String[] args) throws DocumentException {
	}

	public static void generateMWBS(Map dataMap,String fileName){

		Document document = new Document();
		document.setMargins(25, 25, 30, 40);
		try {
			PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(fileName));
			document.open();

			Paragraph title = new Paragraph("苏州丰盈工程塑胶有限公司",setChineseFont28());
			title.setAlignment(1);
			title.setSpacingBefore(15);
			title.setAlignment(Element.ALIGN_CENTER);
			title.setSpacingAfter(6);

			document.add(title);



			Paragraph title2 = new Paragraph("配色作业制图表",setChineseFont20());
			title2.setAlignment(1);
			title2.setSpacingBefore(6);
			title2.setAlignment(Element.ALIGN_CENTER);
			title2.setSpacingAfter(10);
			document.add(title2);

			Paragraph titleDate = new Paragraph("生产日期: "+ dataMap.get("createDate"),setChineseFont18());
			titleDate.setAlignment(1);
			titleDate.setAlignment(Element.ALIGN_LEFT);
			titleDate.setSpacingAfter(8);
			document.add(titleDate);


			float[] widths = { 0.15f,0.15f,0.3f,0.2f,0.15f,0.15f };
			PdfPTable ct = new PdfPTable(widths);
			//ct.getDefaultCell().setBorder(PdfPCell.NO_BORDER);
			ct.setWidthPercentage(100);

			PdfPCell row_1_1 = new PdfPCell(new Phrase("色   号",setChineseFont18()));
			row_1_1.setMinimumHeight(35);
			//row_1_1.setBorder(PdfPCell.NO_BORDER);
			row_1_1.setHorizontalAlignment(1);
			row_1_1.setVerticalAlignment(Element.ALIGN_MIDDLE);
			ct.addCell(row_1_1);

			Object colorCode = dataMap.get("colorCode").toString();
			if(colorCode == null) colorCode = "";
			PdfPCell row_1_2 = new PdfPCell(new Phrase(colorCode.toString(),setChineseFont18()));
			row_1_2.setMinimumHeight(35);
			row_1_2.setHorizontalAlignment(1);
			row_1_2.setVerticalAlignment(Element.ALIGN_MIDDLE);
			ct.addCell(row_1_2);

			PdfPCell row_1_3 = new PdfPCell(new Phrase("产品批号",setChineseFont18()));
			row_1_3.setMinimumHeight(35);
			row_1_3.setHorizontalAlignment(1);
			row_1_3.setVerticalAlignment(Element.ALIGN_MIDDLE);
			ct.addCell(row_1_3);

			Object productBatchNumber = dataMap.get("productBatchNumber");
			if(productBatchNumber == null) productBatchNumber = "";
			PdfPCell row_1_4 = new PdfPCell(new Phrase(productBatchNumber.toString(),setChineseFont18()));
			row_1_4.setMinimumHeight(35);
			row_1_4.setHorizontalAlignment(1);
			row_1_4.setVerticalAlignment(Element.ALIGN_MIDDLE);
			ct.addCell(row_1_4);

			PdfPCell row_1_5 = new PdfPCell(new Phrase("顾客名称",setChineseFont18()));
			row_1_5.setMinimumHeight(35);
			row_1_5.setHorizontalAlignment(1);
			row_1_5.setVerticalAlignment(Element.ALIGN_MIDDLE);
			ct.addCell(row_1_5);

			Object customer = dataMap.get("customer");
			if(customer == null) customer = "";
			PdfPCell row_1_6 = new PdfPCell(new Phrase(customer.toString(),setChineseFont18()));
			row_1_6.setMinimumHeight(35);
			row_1_6.setHorizontalAlignment(1);
			row_1_6.setVerticalAlignment(Element.ALIGN_MIDDLE);
			ct.addCell(row_1_6);


			//---------------------
			PdfPCell row_2_1 = new PdfPCell(new Phrase("使用原料",setChineseFont18()));
			row_2_1.setMinimumHeight(35);
			row_2_1.setHorizontalAlignment(1);
			row_2_1.setVerticalAlignment(Element.ALIGN_MIDDLE);
			ct.addCell(row_2_1);

			Object material = dataMap.get("material");
			if(material == null) material = "";
			PdfPCell row_2_2 = new PdfPCell(new Phrase(material.toString(),setChineseFont18()));
			row_2_2.setMinimumHeight(35);
			row_2_2.setHorizontalAlignment(1);
			row_2_2.setVerticalAlignment(Element.ALIGN_MIDDLE);
			ct.addCell(row_2_2);

			PdfPCell row_2_3 = new PdfPCell(new Phrase("顾客代号",setChineseFont18()));
			row_2_3.setMinimumHeight(35);
			row_2_3.setHorizontalAlignment(1);
			row_2_3.setVerticalAlignment(Element.ALIGN_MIDDLE);
			ct.addCell(row_2_3);

			Object customeCode = dataMap.get("customeCode");
			if(customeCode == null) customeCode = "";
			PdfPCell row_2_4 = new PdfPCell(new Phrase(customeCode.toString(),setChineseFont18()));
			row_2_4.setMinimumHeight(35);
			row_2_4.setHorizontalAlignment(1);
			row_2_4.setVerticalAlignment(Element.ALIGN_MIDDLE);
			ct.addCell(row_2_4);

			PdfPCell row_2_5 = new PdfPCell(new Phrase("生产数量",setChineseFont18()));
			row_2_5.setMinimumHeight(35);
			row_2_5.setHorizontalAlignment(1);
			row_2_5.setVerticalAlignment(Element.ALIGN_MIDDLE);
			ct.addCell(row_2_5);

			Object number = dataMap.get("number");
			if(number == null) number = "";
			PdfPCell row_2_6 = new PdfPCell(new Phrase(number.toString(),setChineseFont18()));
			row_2_6.setMinimumHeight(35);
			row_2_6.setHorizontalAlignment(1);
			row_2_6.setVerticalAlignment(Element.ALIGN_MIDDLE);
			ct.addCell(row_2_6);

			//-----------------
			PdfPCell row_3_1 = new PdfPCell(new Phrase("生产机台",setChineseFont18()));
			row_3_1.setMinimumHeight(35);
			row_3_1.setHorizontalAlignment(1);
			row_3_1.setVerticalAlignment(Element.ALIGN_MIDDLE);
			ct.addCell(row_3_1);

			Object machineCode = dataMap.get("machineCode");
			if(machineCode == null) machineCode = "";
			PdfPCell row_3_2 = new PdfPCell(new Phrase(machineCode.toString(),setChineseFont18()));
			row_3_2.setMinimumHeight(35);
			row_3_2.setHorizontalAlignment(1);
			row_3_2.setVerticalAlignment(Element.ALIGN_MIDDLE);
			ct.addCell(row_3_2);

			PdfPCell row_3_3 = new PdfPCell(new Phrase("尾数重量（KG）X 方次",setChineseFont18()));
			row_3_3.setMinimumHeight(35);
			row_3_3.setHorizontalAlignment(1);
			row_3_3.setVerticalAlignment(Element.ALIGN_MIDDLE);
			ct.addCell(row_3_3);

			PdfPCell row_3_4 = new PdfPCell(new Phrase("补正记录",setChineseFont18()));
			row_3_4.setMinimumHeight(35);
			row_3_4.setHorizontalAlignment(1);
			row_3_4.setVerticalAlignment(Element.ALIGN_MIDDLE);
			ct.addCell(row_3_4);

			PdfPCell row_3_5 = new PdfPCell(new Phrase("重量(KG)X方次",setChineseFont18()));
			row_3_5.setMinimumHeight(35);
			row_3_5.setColspan(2);
			row_3_5.setHorizontalAlignment(1);
			row_3_5.setVerticalAlignment(Element.ALIGN_MIDDLE);
			ct.addCell(row_3_5);

			//-----------------
			PdfPCell row_4_1 = new PdfPCell(new Phrase("色料名称",setChineseFont18()));
			row_4_1.setMinimumHeight(35);
			row_4_1.setHorizontalAlignment(1);
			row_4_1.setVerticalAlignment(Element.ALIGN_MIDDLE);
			ct.addCell(row_4_1);

			PdfPCell row_4_2 = new PdfPCell(new Phrase("基本配方",setChineseFont18()));
			row_4_2.setMinimumHeight(35);
			row_4_2.setHorizontalAlignment(1);
			row_4_2.setVerticalAlignment(Element.ALIGN_MIDDLE);
			ct.addCell(row_4_2);

			Object weishuWeight = dataMap.get("weishuWeight");
			if(weishuWeight == null) weishuWeight = "";
			PdfPCell row_4_3 = new PdfPCell(new Phrase(weishuWeight.toString(),setChineseFont18()));
			row_4_3.setMinimumHeight(35);
			row_4_3.setHorizontalAlignment(1);
			row_4_3.setVerticalAlignment(Element.ALIGN_MIDDLE);
			ct.addCell(row_4_3);

			PdfPCell row_4_4 = new PdfPCell(new Phrase("",setChineseFont18()));
			row_4_4.setMinimumHeight(35);
			row_4_4.setHorizontalAlignment(1);
			row_4_4.setVerticalAlignment(Element.ALIGN_MIDDLE);
			ct.addCell(row_4_4);

			Object buzhengWeight = dataMap.get("buzhengWeight");
			if(buzhengWeight == null) buzhengWeight = "";
			PdfPCell row_4_5 = new PdfPCell(new Phrase(buzhengWeight.toString(),setChineseFont18()));
			row_4_5.setMinimumHeight(35);
			row_4_5.setColspan(2);
			row_4_5.setHorizontalAlignment(1);
			row_4_5.setVerticalAlignment(Element.ALIGN_MIDDLE);
			ct.addCell(row_4_5);
			//

			//-----------1------
			Object colorMaterialName1 = dataMap.get("colorMaterialName1");
			if(colorMaterialName1 == null) colorMaterialName1 = "";
			PdfPCell row_c_1_1 = new PdfPCell(new Phrase(colorMaterialName1.toString(),setChineseFont18()));
			row_c_1_1.setMinimumHeight(35);
			row_c_1_1.setHorizontalAlignment(1);
			row_c_1_1.setVerticalAlignment(Element.ALIGN_MIDDLE);
			ct.addCell(row_c_1_1);

			Object baseRecipe1 = dataMap.get("baseRecipe1");
			if(baseRecipe1 == null) baseRecipe1 = "";
			PdfPCell row_c_1_2 = new PdfPCell(new Phrase(baseRecipe1.toString(),setChineseFont18()));
			row_c_1_2.setMinimumHeight(35);
			row_c_1_2.setHorizontalAlignment(1);
			row_c_1_2.setVerticalAlignment(Element.ALIGN_MIDDLE);
			ct.addCell(row_c_1_2);

			Object weishuWeight1 = dataMap.get("weishuWeight1");
			if(weishuWeight1 == null) weishuWeight1 = "";
			PdfPCell row_c_1_3 = new PdfPCell(new Phrase(weishuWeight1.toString(),setChineseFont18()));
			row_c_1_3.setMinimumHeight(35);
			row_c_1_3.setHorizontalAlignment(1);
			row_c_1_3.setVerticalAlignment(Element.ALIGN_MIDDLE);
			ct.addCell(row_c_1_3);

			PdfPCell row_c_1_4 = new PdfPCell(new Phrase("",setChineseFont18()));
			row_c_1_4.setMinimumHeight(35);
			row_c_1_4.setHorizontalAlignment(1);
			row_c_1_4.setVerticalAlignment(Element.ALIGN_MIDDLE);
			ct.addCell(row_c_1_4);

			Object buzhengWeight1 = dataMap.get("buzhengWeight1");
			if(buzhengWeight1 == null) buzhengWeight1 = "";
			PdfPCell row_c_1_5 = new PdfPCell(new Phrase(buzhengWeight1.toString(),setChineseFont18()));
			row_c_1_5.setMinimumHeight(35);
			row_c_1_5.setColspan(2);
			row_c_1_5.setHorizontalAlignment(1);
			row_c_1_5.setVerticalAlignment(Element.ALIGN_MIDDLE);
			ct.addCell(row_c_1_5);
			//

			//----------2-------
			Object colorMaterialName2 = dataMap.get("colorMaterialName2");
			if(colorMaterialName2 == null) colorMaterialName2 = "";
			PdfPCell row_c_2_1 = new PdfPCell(new Phrase(colorMaterialName2.toString(),setChineseFont18()));
			row_c_2_1.setMinimumHeight(35);
			row_c_2_1.setHorizontalAlignment(1);
			row_c_2_1.setVerticalAlignment(Element.ALIGN_MIDDLE);
			ct.addCell(row_c_2_1);

			Object baseRecipe2 = dataMap.get("baseRecipe2");
			if(baseRecipe2 == null) baseRecipe2 = "";
			PdfPCell row_c_2_2 = new PdfPCell(new Phrase(baseRecipe2.toString(),setChineseFont18()));
			row_c_2_2.setMinimumHeight(35);
			row_c_2_2.setHorizontalAlignment(1);
			row_c_2_2.setVerticalAlignment(Element.ALIGN_MIDDLE);
			ct.addCell(row_c_2_2);

			Object weishuWeight2 = dataMap.get("weishuWeight2");
			if(weishuWeight2 == null) weishuWeight2 = "";
			PdfPCell row_c_2_3 = new PdfPCell(new Phrase(weishuWeight2.toString(),setChineseFont18()));
			row_c_2_3.setMinimumHeight(35);
			row_c_2_3.setHorizontalAlignment(1);
			row_c_2_3.setVerticalAlignment(Element.ALIGN_MIDDLE);
			ct.addCell(row_c_2_3);

			PdfPCell row_c_2_4 = new PdfPCell(new Phrase("",setChineseFont18()));
			row_c_2_4.setMinimumHeight(35);
			row_c_2_4.setHorizontalAlignment(1);
			row_c_2_4.setVerticalAlignment(Element.ALIGN_MIDDLE);
			ct.addCell(row_c_2_4);

			Object buzhengWeight2 = dataMap.get("buzhengWeight2");
			if(buzhengWeight2 == null) buzhengWeight2 = "";
			PdfPCell row_c_2_5 = new PdfPCell(new Phrase(buzhengWeight2.toString(),setChineseFont18()));
			row_c_2_5.setMinimumHeight(35);
			row_c_2_5.setColspan(2);
			row_c_2_5.setHorizontalAlignment(1);
			row_c_2_5.setVerticalAlignment(Element.ALIGN_MIDDLE);
			ct.addCell(row_c_2_5);
			//

			//----------3-------
			Object colorMaterialName3 = dataMap.get("colorMaterialName3");
			if(colorMaterialName3 == null) colorMaterialName3 = "";
			PdfPCell row_c_3_1 = new PdfPCell(new Phrase(colorMaterialName3.toString(),setChineseFont18()));
			row_c_3_1.setMinimumHeight(35);
			row_c_3_1.setHorizontalAlignment(1);
			row_c_3_1.setVerticalAlignment(Element.ALIGN_MIDDLE);
			ct.addCell(row_c_3_1);

			Object baseRecipe3 = dataMap.get("baseRecipe3");
			if(baseRecipe3 == null) baseRecipe3 = "";
			PdfPCell row_c_3_2 = new PdfPCell(new Phrase(baseRecipe3.toString(),setChineseFont18()));
			row_c_3_2.setMinimumHeight(35);
			row_c_3_2.setHorizontalAlignment(1);
			row_c_3_2.setVerticalAlignment(Element.ALIGN_MIDDLE);
			ct.addCell(row_c_3_2);

			Object weishuWeight3 = dataMap.get("weishuWeight3");
			if(weishuWeight3 == null) weishuWeight3 = "";
			PdfPCell row_c_3_3 = new PdfPCell(new Phrase(weishuWeight3.toString(),setChineseFont18()));
			row_c_3_3.setMinimumHeight(35);
			row_c_3_3.setHorizontalAlignment(1);
			row_c_3_3.setVerticalAlignment(Element.ALIGN_MIDDLE);
			ct.addCell(row_c_3_3);

			PdfPCell row_c_3_4 = new PdfPCell(new Phrase("",setChineseFont18()));
			row_c_3_4.setMinimumHeight(35);
			row_c_3_4.setHorizontalAlignment(1);
			row_c_3_4.setVerticalAlignment(Element.ALIGN_MIDDLE);
			ct.addCell(row_c_3_4);

			Object buzhengWeight3 = dataMap.get("buzhengWeight3");
			if(buzhengWeight3 == null) buzhengWeight3 = "";
			PdfPCell row_c_3_5 = new PdfPCell(new Phrase(buzhengWeight3.toString(),setChineseFont18()));
			row_c_3_5.setMinimumHeight(35);
			row_c_3_5.setColspan(2);
			row_c_3_5.setHorizontalAlignment(1);
			row_c_3_5.setVerticalAlignment(Element.ALIGN_MIDDLE);
			ct.addCell(row_c_3_5);
			//

			//----------4-------
			Object colorMaterialName4= dataMap.get("colorMaterialName4");
			if(colorMaterialName4 == null) colorMaterialName4 = "";
			PdfPCell row_c_4_1 = new PdfPCell(new Phrase(colorMaterialName4.toString(),setChineseFont18()));
			row_c_4_1.setMinimumHeight(35);
			row_c_4_1.setHorizontalAlignment(1);
			row_c_4_1.setVerticalAlignment(Element.ALIGN_MIDDLE);
			ct.addCell(row_c_4_1);

			Object baseRecipe4 = dataMap.get("baseRecipe4");
			if(baseRecipe4 == null) baseRecipe4 = "";
			PdfPCell row_c_4_2 = new PdfPCell(new Phrase(baseRecipe4.toString(),setChineseFont18()));
			row_c_4_2.setMinimumHeight(35);
			row_c_4_2.setHorizontalAlignment(1);
			row_c_4_2.setVerticalAlignment(Element.ALIGN_MIDDLE);
			ct.addCell(row_c_4_2);

			Object weishuWeight4 = dataMap.get("weishuWeight4");
			if(weishuWeight4 == null) weishuWeight4 = "";
			PdfPCell row_c_4_3 = new PdfPCell(new Phrase(weishuWeight4.toString(),setChineseFont18()));
			row_c_4_3.setMinimumHeight(35);
			row_c_4_3.setHorizontalAlignment(1);
			row_c_4_3.setVerticalAlignment(Element.ALIGN_MIDDLE);
			ct.addCell(row_c_4_3);

			PdfPCell row_c_4_4 = new PdfPCell(new Phrase("",setChineseFont18()));
			row_c_4_4.setMinimumHeight(35);
			row_c_4_4.setHorizontalAlignment(1);
			row_c_4_4.setVerticalAlignment(Element.ALIGN_MIDDLE);
			ct.addCell(row_c_4_4);

			Object buzhengWeight4 = dataMap.get("buzhengWeight4");
			if(buzhengWeight4 == null) buzhengWeight4 = "";
			PdfPCell row_c_4_5 = new PdfPCell(new Phrase(buzhengWeight4.toString(),setChineseFont18()));
			row_c_4_5.setMinimumHeight(35);
			row_c_4_5.setColspan(2);
			row_c_4_5.setHorizontalAlignment(1);
			row_c_4_5.setVerticalAlignment(Element.ALIGN_MIDDLE);
			ct.addCell(row_c_4_5);
			//

			//----------5-------
			Object colorMaterialName5= dataMap.get("colorMaterialName5");
			if(colorMaterialName5 == null) colorMaterialName5 = "";
			PdfPCell row_c_5_1 = new PdfPCell(new Phrase(colorMaterialName5.toString(),setChineseFont18()));
			row_c_5_1.setMinimumHeight(35);
			row_c_5_1.setHorizontalAlignment(1);
			row_c_5_1.setVerticalAlignment(Element.ALIGN_MIDDLE);
			ct.addCell(row_c_5_1);

			Object baseRecipe5 = dataMap.get("baseRecipe5");
			if(baseRecipe5 == null) baseRecipe5 = "";
			PdfPCell row_c_5_2 = new PdfPCell(new Phrase(baseRecipe5.toString(),setChineseFont18()));
			row_c_5_2.setMinimumHeight(35);
			row_c_5_2.setHorizontalAlignment(1);
			row_c_5_2.setVerticalAlignment(Element.ALIGN_MIDDLE);
			ct.addCell(row_c_5_2);

			Object weishuWeight5 = dataMap.get("weishuWeight5");
			if(weishuWeight5 == null) weishuWeight5 = "";
			PdfPCell row_c_5_3 = new PdfPCell(new Phrase(weishuWeight5.toString(),setChineseFont18()));
			row_c_5_3.setMinimumHeight(35);
			row_c_5_3.setHorizontalAlignment(1);
			row_c_5_3.setVerticalAlignment(Element.ALIGN_MIDDLE);
			ct.addCell(row_c_5_3);

			PdfPCell row_c_5_4 = new PdfPCell(new Phrase("",setChineseFont18()));
			row_c_5_4.setMinimumHeight(35);
			row_c_5_4.setHorizontalAlignment(1);
			row_c_5_4.setVerticalAlignment(Element.ALIGN_MIDDLE);
			ct.addCell(row_c_5_4);

			Object buzhengWeight5 = dataMap.get("buzhengWeight5");
			if(buzhengWeight5 == null) buzhengWeight5 = "";
			PdfPCell row_c_5_5 = new PdfPCell(new Phrase(buzhengWeight5.toString(),setChineseFont18()));
			row_c_5_5.setMinimumHeight(35);
			row_c_5_5.setColspan(2);
			row_c_5_5.setHorizontalAlignment(1);
			row_c_5_5.setVerticalAlignment(Element.ALIGN_MIDDLE);
			ct.addCell(row_c_5_5);
			//

			//----------6-------
			Object colorMaterialName6= dataMap.get("colorMaterialName6");
			if(colorMaterialName6 == null) colorMaterialName6 = "";
			PdfPCell row_c_6_1 = new PdfPCell(new Phrase(colorMaterialName6.toString(),setChineseFont18()));
			row_c_6_1.setMinimumHeight(35);
			row_c_6_1.setHorizontalAlignment(1);
			row_c_6_1.setVerticalAlignment(Element.ALIGN_MIDDLE);
			ct.addCell(row_c_6_1);

			Object baseRecipe6 = dataMap.get("baseRecipe6");
			if(baseRecipe6 == null) baseRecipe6 = "";
			PdfPCell row_c_6_2 = new PdfPCell(new Phrase(baseRecipe6.toString(),setChineseFont18()));
			row_c_6_2.setMinimumHeight(35);
			row_c_6_2.setHorizontalAlignment(1);
			row_c_6_2.setVerticalAlignment(Element.ALIGN_MIDDLE);
			ct.addCell(row_c_6_2);

			Object weishuWeight6 = dataMap.get("weishuWeight6");
			if(weishuWeight6 == null) weishuWeight6 = "";
			PdfPCell row_c_6_3 = new PdfPCell(new Phrase(weishuWeight6.toString(),setChineseFont18()));
			row_c_6_3.setMinimumHeight(35);
			row_c_6_3.setHorizontalAlignment(1);
			row_c_6_3.setVerticalAlignment(Element.ALIGN_MIDDLE);
			ct.addCell(row_c_6_3);

			PdfPCell row_c_6_4 = new PdfPCell(new Phrase("",setChineseFont18()));
			row_c_6_4.setMinimumHeight(35);
			row_c_6_4.setHorizontalAlignment(1);
			row_c_6_4.setVerticalAlignment(Element.ALIGN_MIDDLE);
			ct.addCell(row_c_6_4);

			Object buzhengWeight6 = dataMap.get("buzhengWeight6");
			if(buzhengWeight6 == null) buzhengWeight6 = "";
			PdfPCell row_c_6_5 = new PdfPCell(new Phrase(buzhengWeight6.toString(),setChineseFont18()));
			row_c_6_5.setMinimumHeight(35);
			row_c_6_5.setColspan(2);
			row_c_6_5.setHorizontalAlignment(1);
			row_c_6_5.setVerticalAlignment(Element.ALIGN_MIDDLE);
			ct.addCell(row_c_6_5);
			//

			//----------7-------
			Object colorMaterialName7= dataMap.get("colorMaterialName7");
			if(colorMaterialName7 == null) colorMaterialName7 = "";
			PdfPCell row_c_7_1 = new PdfPCell(new Phrase(colorMaterialName7.toString(),setChineseFont18()));
			row_c_7_1.setMinimumHeight(35);
			row_c_7_1.setHorizontalAlignment(1);
			row_c_7_1.setVerticalAlignment(Element.ALIGN_MIDDLE);
			ct.addCell(row_c_7_1);

			Object baseRecipe7 = dataMap.get("baseRecipe7");
			if(baseRecipe7 == null) baseRecipe7 = "";
			PdfPCell row_c_7_2 = new PdfPCell(new Phrase(baseRecipe7.toString(),setChineseFont18()));
			row_c_7_2.setMinimumHeight(35);
			row_c_7_2.setHorizontalAlignment(1);
			row_c_7_2.setVerticalAlignment(Element.ALIGN_MIDDLE);
			ct.addCell(row_c_7_2);

			Object weishuWeight7 = dataMap.get("weishuWeight7");
			if(weishuWeight7 == null) weishuWeight7 = "";
			PdfPCell row_c_7_3 = new PdfPCell(new Phrase(weishuWeight7.toString(),setChineseFont18()));
			row_c_7_3.setMinimumHeight(35);
			row_c_7_3.setHorizontalAlignment(1);
			row_c_7_3.setVerticalAlignment(Element.ALIGN_MIDDLE);
			ct.addCell(row_c_7_3);

			PdfPCell row_c_7_4 = new PdfPCell(new Phrase("",setChineseFont18()));
			row_c_7_4.setMinimumHeight(35);
			row_c_7_4.setHorizontalAlignment(1);
			row_c_7_4.setVerticalAlignment(Element.ALIGN_MIDDLE);
			ct.addCell(row_c_7_4);

			Object buzhengWeight7 = dataMap.get("buzhengWeight7");
			if(buzhengWeight7 == null) buzhengWeight7 = "";
			PdfPCell row_c_7_5 = new PdfPCell(new Phrase(buzhengWeight7.toString(),setChineseFont18()));
			row_c_7_5.setMinimumHeight(35);
			row_c_7_5.setColspan(2);
			row_c_7_5.setHorizontalAlignment(1);
			row_c_7_5.setVerticalAlignment(Element.ALIGN_MIDDLE);
			ct.addCell(row_c_7_5);
			//


			//----------8-------
			Object colorMaterialName8= dataMap.get("colorMaterialName8");
			if(colorMaterialName8 == null) colorMaterialName8 = "";
			PdfPCell row_c_8_1 = new PdfPCell(new Phrase(colorMaterialName8.toString(),setChineseFont18()));
			row_c_8_1.setMinimumHeight(35);
			row_c_8_1.setHorizontalAlignment(1);
			row_c_8_1.setVerticalAlignment(Element.ALIGN_MIDDLE);
			ct.addCell(row_c_8_1);

			Object baseRecipe8 = dataMap.get("baseRecipe8");
			if(baseRecipe8 == null) baseRecipe8 = "";
			PdfPCell row_c_8_2 = new PdfPCell(new Phrase(baseRecipe8.toString(),setChineseFont18()));
			row_c_8_2.setMinimumHeight(35);
			row_c_8_2.setHorizontalAlignment(1);
			row_c_8_2.setVerticalAlignment(Element.ALIGN_MIDDLE);
			ct.addCell(row_c_8_2);

			Object weishuWeight8 = dataMap.get("weishuWeight8");
			if(weishuWeight8 == null) weishuWeight8 = "";
			PdfPCell row_c_8_3 = new PdfPCell(new Phrase(weishuWeight8.toString(),setChineseFont18()));
			row_c_8_3.setMinimumHeight(35);
			row_c_8_3.setHorizontalAlignment(1);
			row_c_8_3.setVerticalAlignment(Element.ALIGN_MIDDLE);
			ct.addCell(row_c_8_3);

			PdfPCell row_c_8_4 = new PdfPCell(new Phrase("",setChineseFont18()));
			row_c_8_4.setMinimumHeight(35);
			row_c_8_4.setHorizontalAlignment(1);
			row_c_8_4.setVerticalAlignment(Element.ALIGN_MIDDLE);
			ct.addCell(row_c_8_4);

			Object buzhengWeight8 = dataMap.get("buzhengWeight8");
			if(buzhengWeight8 == null) buzhengWeight8 = "";
			PdfPCell row_c_8_5 = new PdfPCell(new Phrase(buzhengWeight8.toString(),setChineseFont18()));
			row_c_8_5.setMinimumHeight(35);
			row_c_8_5.setColspan(2);
			row_c_8_5.setHorizontalAlignment(1);
			row_c_8_5.setVerticalAlignment(Element.ALIGN_MIDDLE);
			ct.addCell(row_c_8_5);
			//

			//----------9-------
			Object colorMaterialName9 =  dataMap.get("colorMaterialName9");
			if(colorMaterialName9 == null) colorMaterialName9 = "";
			PdfPCell row_c_9_1 = new PdfPCell(new Phrase(colorMaterialName9.toString(),setChineseFont18()));
			row_c_9_1.setMinimumHeight(35);
			row_c_9_1.setHorizontalAlignment(1);
			row_c_9_1.setVerticalAlignment(Element.ALIGN_MIDDLE);
			ct.addCell(row_c_9_1);

			Object baseRecipe9 = dataMap.get("baseRecipe9");
			if(baseRecipe9 == null) baseRecipe9 = "";
			PdfPCell row_c_9_2 = new PdfPCell(new Phrase(baseRecipe9.toString(),setChineseFont18()));
			row_c_9_2.setMinimumHeight(35);
			row_c_9_2.setHorizontalAlignment(1);
			row_c_9_2.setVerticalAlignment(Element.ALIGN_MIDDLE);
			ct.addCell(row_c_9_2);

			Object weishuWeight9 = dataMap.get("weishuWeight9");
			if(weishuWeight9 == null) weishuWeight9 = "";
			PdfPCell row_c_9_3 = new PdfPCell(new Phrase(weishuWeight9.toString(),setChineseFont18()));
			row_c_9_3.setMinimumHeight(35);
			row_c_9_3.setHorizontalAlignment(1);
			row_c_9_3.setVerticalAlignment(Element.ALIGN_MIDDLE);
			ct.addCell(row_c_9_3);

			PdfPCell row_c_9_4 = new PdfPCell(new Phrase("",setChineseFont18()));
			row_c_9_4.setMinimumHeight(35);
			row_c_9_4.setHorizontalAlignment(1);
			row_c_9_4.setVerticalAlignment(Element.ALIGN_MIDDLE);
			ct.addCell(row_c_9_4);

			Object buzhengWeight9 = dataMap.get("buzhengWeight9");
			if(buzhengWeight9 == null) buzhengWeight9 = "";
			PdfPCell row_c_9_5 = new PdfPCell(new Phrase(buzhengWeight9.toString(),setChineseFont18()));
			row_c_9_5.setMinimumHeight(35);
			row_c_9_5.setColspan(2);
			row_c_9_5.setHorizontalAlignment(1);
			row_c_9_5.setVerticalAlignment(Element.ALIGN_MIDDLE);
			ct.addCell(row_c_9_5);
			//

//----------10------
			Object colorMaterialName10 =  dataMap.get("colorMaterialName10");
			if(colorMaterialName10 == null) colorMaterialName10 = "";
			PdfPCell row_c_10_1 = new PdfPCell(new Phrase(colorMaterialName10.toString(),setChineseFont18()));
			row_c_10_1.setMinimumHeight(35);
			row_c_10_1.setHorizontalAlignment(1);
			row_c_10_1.setVerticalAlignment(Element.ALIGN_MIDDLE);
			ct.addCell(row_c_10_1);

			Object baseRecipe10 = dataMap.get("baseRecipe10");
			if(baseRecipe10 == null) baseRecipe10 = "";
			PdfPCell row_c_10_2 = new PdfPCell(new Phrase(baseRecipe10.toString(),setChineseFont18()));
			row_c_10_2.setMinimumHeight(35);
			row_c_10_2.setHorizontalAlignment(1);
			row_c_10_2.setVerticalAlignment(Element.ALIGN_MIDDLE);
			ct.addCell(row_c_10_2);

			Object weishuWeight10 = dataMap.get("weishuWeight10");
			if(weishuWeight10 == null) weishuWeight10 = "";
			PdfPCell row_c_10_3 = new PdfPCell(new Phrase(weishuWeight10.toString(),setChineseFont18()));
			row_c_10_3.setMinimumHeight(35);
			row_c_10_3.setHorizontalAlignment(1);
			row_c_10_3.setVerticalAlignment(Element.ALIGN_MIDDLE);
			ct.addCell(row_c_10_3);

			PdfPCell row_c_10_4 = new PdfPCell(new Phrase("",setChineseFont18()));
			row_c_10_4.setMinimumHeight(35);
			row_c_10_4.setHorizontalAlignment(1);
			row_c_10_4.setVerticalAlignment(Element.ALIGN_MIDDLE);
			ct.addCell(row_c_10_4);

			Object buzhengWeight10 = dataMap.get("buzhengWeight10");
			if(buzhengWeight10 == null) buzhengWeight10 = "";
			PdfPCell row_c_10_5 = new PdfPCell(new Phrase(buzhengWeight10.toString(),setChineseFont18()));
			row_c_10_5.setMinimumHeight(35);
			row_c_10_5.setColspan(2);
			row_c_10_5.setHorizontalAlignment(1);
			row_c_10_5.setVerticalAlignment(Element.ALIGN_MIDDLE);
			ct.addCell(row_c_10_5);
			//

			//---------
			PdfPCell row_s_1 = new PdfPCell(new Phrase("小计",setChineseFont18()));
			row_s_1.setMinimumHeight(35);
			row_s_1.setHorizontalAlignment(1);
			row_s_1.setVerticalAlignment(Element.ALIGN_MIDDLE);
			ct.addCell(row_s_1);

			Object sumOfRecipe = dataMap.get("sumOfRecipe");
			if(sumOfRecipe == null) sumOfRecipe = "";
			PdfPCell row_s_2 = new PdfPCell(new Phrase("",setChineseFont18()));
			row_s_2.setMinimumHeight(35);
			row_s_2.setHorizontalAlignment(1);
			row_s_2.setVerticalAlignment(Element.ALIGN_MIDDLE);
			ct.addCell(row_s_2);

			Object sumOfWeishu = dataMap.get("sumOfWeishu");
			if(sumOfWeishu == null) sumOfWeishu = "";
			PdfPCell row_s_3 = new PdfPCell(new Phrase("小计",setChineseFont18()));
			row_s_3.setMinimumHeight(35);
			row_s_3.setHorizontalAlignment(1);
			row_s_3.setVerticalAlignment(Element.ALIGN_MIDDLE);
			ct.addCell(row_s_3);

			PdfPCell row_s_4 = new PdfPCell(new Phrase("小计",setChineseFont18()));
			row_s_4.setMinimumHeight(35);
			row_s_4.setHorizontalAlignment(1);
			row_s_4.setVerticalAlignment(Element.ALIGN_MIDDLE);
			ct.addCell(row_s_4);

			Object sumOfBuzheng = dataMap.get("sumOfBuzheng");
			if(sumOfBuzheng == null) sumOfBuzheng = "";
			PdfPCell row_s_5 = new PdfPCell(new Phrase("",setChineseFont18()));
			row_s_5.setMinimumHeight(35);
			row_s_5.setColspan(2);
			row_s_5.setHorizontalAlignment(1);
			row_s_5.setVerticalAlignment(Element.ALIGN_MIDDLE);
			ct.addCell(row_s_5);



			//---------
			PdfPCell row_m_1 = new PdfPCell(new Phrase("备  注：",setChineseFont18()));
			row_m_1.setPaddingLeft(10);
			row_m_1.setMinimumHeight(65);
			row_m_1.setRowspan(2);
			row_m_1.setColspan(6);
			ct.addCell(row_m_1);

			document.add(ct);

			float[] widths2 = { 0.1f,0.55f,0.35f };
			PdfPTable ct2 = new PdfPTable(widths2);
			ct2.setSpacingBefore(10);
			ct2.setWidthPercentage(100);
			ct2.getDefaultCell().setBorder(PdfPCell.NO_BORDER);
			PdfPCell row2_1_1 = new PdfPCell(new Phrase("编制:",setChineseFont18()));
			row2_1_1.setMinimumHeight(35);
			row2_1_1.setHorizontalAlignment(1);
			row2_1_1.setVerticalAlignment(Element.ALIGN_LEFT);
			row2_1_1.setBorder(PdfPCell.NO_BORDER);
			ct2.addCell(row2_1_1);

			PdfPCell row2_1_2 = new PdfPCell(new Phrase("",setChineseFont18()));
			row2_1_2.setMinimumHeight(35);
			row2_1_2.setHorizontalAlignment(1);
			row2_1_2.setVerticalAlignment(Element.ALIGN_LEFT);
			row2_1_2.setBorder(PdfPCell.NO_BORDER);
			ct2.addCell(row2_1_2);

			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");

			PdfPCell row2_1_3 = new PdfPCell(new Phrase("日期 : " + df.format(new Date()),setChineseFont18()));
			row2_1_3.setMinimumHeight(35);
			row2_1_3.setHorizontalAlignment(1);
			row2_1_3.setVerticalAlignment(Element.ALIGN_LEFT);
			row2_1_3.setBorder(PdfPCell.NO_BORDER);
			ct2.addCell(row2_1_3);

			document.add(ct2);



			document.close();
			writer.close();
		} catch (DocumentException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		//generateMawbDrsPdf("I:\\","123");
	}


	public static boolean generateMawbDrsPdf(String file_path,String file_name) throws DocumentException{
		//page size
		Rectangle rect = new Rectangle(PageSize.B5.rotate());   
		//page background
		rect.setBackgroundColor(BaseColor.WHITE);   
		
		Font font = FontFactory.getFont(FontFactory.HELVETICA, 11, Font.NORMAL);
		Font font2 = FontFactory.getFont(FontFactory.COURIER, 10, Font.BOLD);
		Document doc = new Document(PageSize.A4.rotate());   
		
		PdfWriter writer = null;
		try {
			try {
				writer = PdfWriter.getInstance(doc, new FileOutputStream(file_path + file_name+".pdf"));
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		} catch (DocumentException e) {
			e.printStackTrace();
		}   
		  

		doc.setMargins(5, 5, 30, 40);   
		doc.open();

		doc.add(new Paragraph("苏州丰盈工程塑胶有限公司苏州丰盈工程塑胶有限公司"));

		PdfPTable title_table = new PdfPTable(1);
		PdfPCell row_1_1 = new PdfPCell(new Phrase("苏州丰盈工程塑胶有限公司苏州丰盈工程塑胶有限公司",font));
		row_1_1.setBorderWidth(0f);
		title_table.addCell(row_1_1);
		doc.add(title_table);

		doc.close();
		writer.close();
		return true;
	}
	/*public static void drawTitle(Document doc,Font font){




		

	
		float[] widths = { 0.2f, 0.4f,0.15f,0.25f};
		PdfPTable title_table_temp = new PdfPTable(widths);   
		
		PdfPCell title_table_temp_0 = new PdfPCell(new Phrase("",font));
		title_table_temp_0.setBorderWidth(0f);   
		title_table_temp.addCell(title_table_temp_0);
		
		PdfPCell title_table_temp_1 = new PdfPCell(title_table);
		title_table_temp_1.setBorderWidth(0f);   
		title_table_temp.addCell(title_table_temp_1);
		
		PdfPCell title_table_temp_3 = new PdfPCell(new Phrase("",font));
		title_table_temp_3.setBorderWidth(0f);   
		title_table_temp.addCell(title_table_temp_3);
		
		PdfPCell title_table_temp_4 = new PdfPCell(new Phrase("",font));
		title_table_temp_4.setBorderWidth(0f);   
		title_table_temp.addCell(title_table_temp_4);
		
		row_1_1.setBorderWidth(0f);  
		try {
			doc.add(title_table_temp);
		} catch (DocumentException e) {
			e.printStackTrace();
		}
		title_table_temp.setSpacingAfter(5f);
	}
	
	public static void drawTable(Document doc,Font font,List<MawbDrsContent> list){
		int minimumHeight = 30;
		int minimumHeight2 = 50;
		
		float[] widths = { 0.05f, 0.1f, 0.1f, 0.1f,0.1f,0.1f, 0.1f,0.08f, 0.08f,0.1f,0.09f};
	    PdfPTable table = new PdfPTable(widths);
		table.setSpacingBefore(5f);
		
		PdfPCell cell_1_1 = new PdfPCell(new Phrase("S.No",font));
		cell_1_1.setMinimumHeight(minimumHeight);
		table.addCell(cell_1_1);
		
		PdfPCell cell_1_2 = new PdfPCell(new Phrase("Bag#",font));
		cell_1_2.setMinimumHeight(minimumHeight);
		table.addCell(cell_1_2);
		
		PdfPCell cell_1_3 = new PdfPCell(new Phrase("Bag Seal#",font));
		cell_1_3.setMinimumHeight(minimumHeight);
		table.addCell(cell_1_3);
		
		PdfPCell cell_1_4 = new PdfPCell(new Phrase("MAWB#",font));
		cell_1_4.setMinimumHeight(minimumHeight);
		table.addCell(cell_1_4);
		
		PdfPCell cell_1_5 = new PdfPCell(new Phrase("Origin Airport",font));
		cell_1_5.setMinimumHeight(minimumHeight);
		table.addCell(cell_1_5);
		
		PdfPCell cell_1_6 = new PdfPCell(new Phrase("Destination Airport",font));
		cell_1_6.setMinimumHeight(minimumHeight);
		table.addCell(cell_1_6);
		
		PdfPCell cell_1_7 = new PdfPCell(new Phrase("Flight#",font));
		cell_1_7.setMinimumHeight(minimumHeight);
		table.addCell(cell_1_7);
		
		PdfPCell cell_1_8 = new PdfPCell(new Phrase("Flight Date/Time",font));
		cell_1_8.setMinimumHeight(minimumHeight);
		table.addCell(cell_1_8);
		
		PdfPCell cell_1_9 = new PdfPCell(new Phrase("Total Pieces",font));
		cell_1_9.setMinimumHeight(minimumHeight);
		table.addCell(cell_1_9);
		
		PdfPCell cell_1_10 = new PdfPCell(new Phrase("Total Weight(kg)",font));
		cell_1_10.setMinimumHeight(minimumHeight);
		table.addCell(cell_1_10);
		
		PdfPCell cell_1_11 = new PdfPCell(new Phrase("Sign/Mob.",font));
		cell_1_11.setMinimumHeight(minimumHeight);
		table.addCell(cell_1_11);
		
		
		for(int i = 0; i< list.size();i++){
			int index = i+1;
			
			PdfPCell cell_2_1 = new PdfPCell(new Phrase(index+"",font));
			cell_2_1.setMinimumHeight(minimumHeight2);
			table.addCell(cell_2_1);
			
			MawbDrsContent mdc = list.get(i);
			
			if(mdc.getBag_id().equals("")){
				PdfPCell cell_2_2 = new PdfPCell(new Phrase("",font));
				cell_2_2.setMinimumHeight(minimumHeight2);
				table.addCell(cell_2_2);
			}else{
				PdfPCell cell_2_2 = new PdfPCell(new Phrase(mdc.getBag_id(),font));
				cell_2_2.setMinimumHeight(minimumHeight2);
				table.addCell(cell_2_2);
			}
			
			if(mdc.getBag_seal_number().equals("")){
				PdfPCell cell_2_3 = new PdfPCell(new Phrase("",font));
				cell_2_3.setMinimumHeight(minimumHeight2);
				table.addCell(cell_2_3);
			}else{
				PdfPCell cell_2_3 = new PdfPCell(new Phrase(mdc.getBag_seal_number(),font));
				cell_2_3.setMinimumHeight(minimumHeight2);
				table.addCell(cell_2_3);
			}
			
			if(mdc.getMawb_id().equals("")){
				PdfPCell cell_2_4 = new PdfPCell(new Phrase("" ,font));
				cell_2_4.setMinimumHeight(minimumHeight2);
				table.addCell(cell_2_4);
			}else{
				PdfPCell cell_2_4 = new PdfPCell(new Phrase(mdc.getMawb_id() ,font));
				cell_2_4.setMinimumHeight(minimumHeight2);
				table.addCell(cell_2_4);
			}
			
			if(mdc.getOrigin_airport().equals("")){
				PdfPCell cell_2_5 = new PdfPCell(new Phrase("",font));
				cell_2_5.setMinimumHeight(minimumHeight2);
				table.addCell(cell_2_5);
			}else{
				PdfPCell cell_2_5 = new PdfPCell(new Phrase(mdc.getOrigin_airport(),font));
				cell_2_5.setMinimumHeight(minimumHeight2);
				table.addCell(cell_2_5);
			}
		
			if(mdc.getDestination_airport().equals("")){
				PdfPCell cell_2_6 = new PdfPCell(new Phrase("",font));
				cell_2_6.setMinimumHeight(minimumHeight2);
				table.addCell(cell_2_6);
			}else{
				PdfPCell cell_2_6 = new PdfPCell(new Phrase(mdc.getDestination_airport(),font));
				cell_2_6.setMinimumHeight(minimumHeight2);
				table.addCell(cell_2_6);
			}
			
			if(mdc.getFlight_number().equals("")){
				PdfPCell cell_2_7 = new PdfPCell(new Phrase("",font));
				cell_2_7.setMinimumHeight(minimumHeight2);
				table.addCell(cell_2_7);
			}else{
				PdfPCell cell_2_7 = new PdfPCell(new Phrase(mdc.getFlight_number(),font));
				cell_2_7.setMinimumHeight(minimumHeight2);
				table.addCell(cell_2_7);
			}
			
			if(mdc.getFlight_date().equals("")){
				PdfPCell cell_2_8 = new PdfPCell(new Phrase("",font));
				cell_2_8.setMinimumHeight(minimumHeight2);
				table.addCell(cell_2_8);
			}else{
				PdfPCell cell_2_8 = new PdfPCell(new Phrase(mdc.getFlight_date(),font));
				cell_2_8.setMinimumHeight(minimumHeight2);
				table.addCell(cell_2_8);
			}
			
			if(mdc.getTotal_pieces().equals("")){
				PdfPCell cell_2_9 = new PdfPCell(new Phrase("",font));
				cell_2_9.setMinimumHeight(minimumHeight2);
				table.addCell(cell_2_9);
			}else{
				PdfPCell cell_2_9 = new PdfPCell(new Phrase(mdc.getTotal_pieces(),font));
				cell_2_9.setMinimumHeight(minimumHeight2);
				table.addCell(cell_2_9);
			}
			
			if(mdc.getCurrent_weight().equals("")){
				PdfPCell cell_2_10 = new PdfPCell(new Phrase("",font));
				cell_2_10.setMinimumHeight(minimumHeight2);
				table.addCell(cell_2_10);
			}else{
				PdfPCell cell_2_10 = new PdfPCell(new Phrase(mdc.getCurrent_weight(),font));
				cell_2_10.setMinimumHeight(minimumHeight2);
				table.addCell(cell_2_10);
			}
			
			
			PdfPCell cell_2_11 = new PdfPCell(new Phrase("",font));
			cell_2_11.setMinimumHeight(minimumHeight2);
			table.addCell(cell_2_11);
		}
		
		try {
			doc.add(table);
		} catch (DocumentException e) {
			e.printStackTrace();
		}
	}*/
	
}
