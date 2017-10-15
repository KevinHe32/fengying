package com.wshop.util;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.wshop.dto.model.OrderModel;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.List;

public class GenerateOrders {

	public static Font setChineseFont28() {
		BaseFont bf = null;
		Font fontChinese = null;
		try {
			bf = BaseFont.createFont("I:\\SIMYOU.TTF",
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
			bf = BaseFont.createFont("I:\\SIMYOU.TTF",
					BaseFont.IDENTITY_H, BaseFont.EMBEDDED);

			fontChinese = new Font(bf, 20, Font.NORMAL);
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
			bf = BaseFont.createFont("I:\\SIMYOU.TTF",
					BaseFont.IDENTITY_H, BaseFont.EMBEDDED);

			fontChinese = new Font(bf, 12, Font.NORMAL);
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
		Map dataMap = new HashMap();

		generateOrders(dataMap, "I:\\order123.pdf");
	}

	public static void generateOrders(Map<String, List<OrderModel>> orderMap, String fileName){


		//List<OrderModel> list = new ArrayList<>();

		Document document = new Document();
		document.setMargins(10, 10, 30, 40);
		try {
			PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(fileName));
			document.open();

			Paragraph title = new Paragraph("苏州丰盈工程塑胶有限公司", setChineseFont28());
			title.setAlignment(1);
			title.setSpacingBefore(10);
			title.setAlignment(Element.ALIGN_CENTER);
			title.setSpacingAfter(5);
			document.add(title);

			Paragraph title2 = new Paragraph("生产通知单", setChineseFont20());
			title2.setAlignment(1);
			title2.setSpacingBefore(15);
			title2.setAlignment(Element.ALIGN_CENTER);
			title2.setSpacingAfter(15);
			document.add(title2);

			float[] widths = {0.06f, 0.14f, 0.12f, 0.11f, 0.15f, 0.06f, 0.1f, 0.1f, 0.16f};
			PdfPTable ct = new PdfPTable(widths);
			ct.setWidthPercentage(100);

			PdfPCell row_1_1 = new PdfPCell(new Phrase("机台", setChineseFont18()));
			row_1_1.setMinimumHeight(40);
			row_1_1.setHorizontalAlignment(1);
			row_1_1.setVerticalAlignment(Element.ALIGN_MIDDLE);
			ct.addCell(row_1_1);

			PdfPCell row_1_2 = new PdfPCell(new Phrase("色号", setChineseFont18()));
			row_1_2.setMinimumHeight(40);
			row_1_2.setHorizontalAlignment(1);
			row_1_2.setVerticalAlignment(Element.ALIGN_MIDDLE);
			ct.addCell(row_1_2);

			PdfPCell row_1_3 = new PdfPCell(new Phrase("代号", setChineseFont18()));
			row_1_3.setMinimumHeight(40);
			row_1_3.setHorizontalAlignment(1);
			row_1_3.setVerticalAlignment(Element.ALIGN_MIDDLE);
			ct.addCell(row_1_3);

			PdfPCell row_1_4 = new PdfPCell(new Phrase("批号", setChineseFont18()));
			row_1_4.setMinimumHeight(40);
			row_1_4.setHorizontalAlignment(1);
			row_1_4.setVerticalAlignment(Element.ALIGN_MIDDLE);
			ct.addCell(row_1_4);

			PdfPCell row_1_5 = new PdfPCell(new Phrase("原料", setChineseFont18()));
			row_1_5.setMinimumHeight(40);
			row_1_5.setHorizontalAlignment(1);
			row_1_5.setVerticalAlignment(Element.ALIGN_MIDDLE);
			ct.addCell(row_1_5);

			PdfPCell row_1_6 = new PdfPCell(new Phrase("数量", setChineseFont18()));
			row_1_6.setMinimumHeight(40);
			row_1_6.setHorizontalAlignment(1);
			row_1_6.setVerticalAlignment(Element.ALIGN_MIDDLE);
			ct.addCell(row_1_6);

			PdfPCell row_1_7 = new PdfPCell(new Phrase("客户", setChineseFont18()));
			row_1_7.setMinimumHeight(40);
			row_1_7.setHorizontalAlignment(1);
			row_1_7.setVerticalAlignment(Element.ALIGN_MIDDLE);
			ct.addCell(row_1_7);

			PdfPCell row_1_8 = new PdfPCell(new Phrase("包装", setChineseFont18()));
			row_1_8.setMinimumHeight(40);
			row_1_8.setHorizontalAlignment(1);
			row_1_8.setVerticalAlignment(Element.ALIGN_MIDDLE);
			ct.addCell(row_1_8);

			PdfPCell row_1_9 = new PdfPCell(new Phrase("备注", setChineseFont18()));
			row_1_9.setMinimumHeight(40);
			row_1_9.setHorizontalAlignment(1);
			row_1_9.setVerticalAlignment(Element.ALIGN_MIDDLE);
			ct.addCell(row_1_9);

			/*if(list.size()<10){
				for(int i = list.size(); i < 10;i++){
					list.add(new OrderModel());
				}
			}*/

			int j = 0;
			for(String machineNumber1 : orderMap.keySet()){
				List<OrderModel> list = orderMap.get(machineNumber1);
				System.out.println("****************************"+orderMap.get(machineNumber1).toString());

				int i = 0;
				for (OrderModel model : list) {
					j++;

					Object machineNumber = model.getMachineNumber();
					if (machineNumber == null) machineNumber = "";
					PdfPCell row_2_1 = new PdfPCell(new Phrase(machineNumber.toString(), setChineseFont18()));
					row_2_1.setMinimumHeight(40);
					row_2_1.setHorizontalAlignment(1);
					if(i ==0){
						row_2_1.setRowspan(list.size());
						row_2_1.setVerticalAlignment(Element.ALIGN_MIDDLE);
						ct.addCell(row_2_1);
					}

					Object colorNumber = model.getColorNumber();
					if (colorNumber == null) colorNumber = "";
					PdfPCell row_2_2 = new PdfPCell(new Phrase(colorNumber.toString(), setChineseFont18()));
					row_2_2.setMinimumHeight(40);
					row_2_2.setHorizontalAlignment(1);
					row_2_2.setVerticalAlignment(Element.ALIGN_MIDDLE);
					ct.addCell(row_2_2);

					Object codeNumber = model.getCodeNumber();
					if (codeNumber == null) codeNumber = "";
					PdfPCell row_2_3 = new PdfPCell(new Phrase(codeNumber.toString(), setChineseFont18()));
					row_2_3.setMinimumHeight(40);
					row_2_3.setHorizontalAlignment(1);
					row_2_3.setVerticalAlignment(Element.ALIGN_MIDDLE);
					ct.addCell(row_2_3);

					Object batchNumber = model.getBatchNumber();
					if (batchNumber == null) batchNumber = "";
					PdfPCell row_2_4 = new PdfPCell(new Phrase(batchNumber.toString(), setChineseFont18()));
					row_2_4.setMinimumHeight(40);
					row_2_4.setHorizontalAlignment(1);
					row_2_4.setVerticalAlignment(Element.ALIGN_MIDDLE);
					ct.addCell(row_2_4);

					Object material = model.getMaterial();
					if (material == null) material = "";
					PdfPCell row_2_5 = new PdfPCell(new Phrase(material.toString(), setChineseFont18()));
					row_2_5.setMinimumHeight(40);
					row_2_5.setHorizontalAlignment(1);
					row_2_5.setVerticalAlignment(Element.ALIGN_MIDDLE);
					ct.addCell(row_2_5);

					Object number = model.getNumber();
					if (number == null) number = "";
					PdfPCell row_2_6 = new PdfPCell(new Phrase(number.toString(), setChineseFont18()));
					row_2_6.setMinimumHeight(40);
					row_2_6.setHorizontalAlignment(1);
					row_2_6.setVerticalAlignment(Element.ALIGN_MIDDLE);
					ct.addCell(row_2_6);

					Object customer = model.getCustomer();
					if (customer == null) customer = "";
					PdfPCell row_2_7 = new PdfPCell(new Phrase(customer.toString(), setChineseFont18()));
					row_2_7.setMinimumHeight(40);
					row_2_7.setHorizontalAlignment(1);
					row_2_7.setVerticalAlignment(Element.ALIGN_MIDDLE);
					ct.addCell(row_2_7);

					Object package2 = model.getPackage2();
					if (package2 == null) package2 = "";
					PdfPCell row_2_8 = new PdfPCell(new Phrase(package2.toString(), setChineseFont18()));
					row_2_8.setMinimumHeight(40);
					row_2_8.setHorizontalAlignment(1);
					row_2_8.setVerticalAlignment(Element.ALIGN_MIDDLE);
					ct.addCell(row_2_8);

					Object remark = model.getRemark();
					if (remark == null) remark = "";
					PdfPCell row_2_9 = new PdfPCell(new Phrase(remark.toString(), setChineseFont18()));
					if(i ==0){
						row_2_9.setRowspan(list.size());
						row_2_9.setMinimumHeight(40);
						row_2_9.setHorizontalAlignment(1);
						row_2_9.setVerticalAlignment(Element.ALIGN_MIDDLE);
						ct.addCell(row_2_9);
					}
					i++;
				}
			}
			System.out.print("-------------------j:"+j);
			while(j<14){
				PdfPCell row_2_1 = new PdfPCell(new Phrase("", setChineseFont18()));
				row_2_1.setMinimumHeight(40);
				row_2_1.setHorizontalAlignment(1);
				row_2_1.setVerticalAlignment(Element.ALIGN_MIDDLE);
				ct.addCell(row_2_1);

				PdfPCell row_2_2 = new PdfPCell(new Phrase("", setChineseFont18()));
				row_2_2.setMinimumHeight(40);
				row_2_2.setHorizontalAlignment(1);
				row_2_2.setVerticalAlignment(Element.ALIGN_MIDDLE);
				ct.addCell(row_2_2);

				PdfPCell row_2_3 = new PdfPCell(new Phrase("", setChineseFont18()));
				row_2_3.setMinimumHeight(40);
				row_2_3.setHorizontalAlignment(1);
				row_2_3.setVerticalAlignment(Element.ALIGN_MIDDLE);
				ct.addCell(row_2_3);

				PdfPCell row_2_4 = new PdfPCell(new Phrase("", setChineseFont18()));
				row_2_4.setMinimumHeight(40);
				row_2_4.setHorizontalAlignment(1);
				row_2_4.setVerticalAlignment(Element.ALIGN_MIDDLE);
				ct.addCell(row_2_4);

				PdfPCell row_2_5 = new PdfPCell(new Phrase("", setChineseFont18()));
				row_2_5.setMinimumHeight(40);
				row_2_5.setHorizontalAlignment(1);
				row_2_5.setVerticalAlignment(Element.ALIGN_MIDDLE);
				ct.addCell(row_2_5);

				PdfPCell row_2_6 = new PdfPCell(new Phrase("", setChineseFont18()));
				row_2_6.setMinimumHeight(40);
				row_2_6.setHorizontalAlignment(1);
				row_2_6.setVerticalAlignment(Element.ALIGN_MIDDLE);
				ct.addCell(row_2_6);

				PdfPCell row_2_7 = new PdfPCell(new Phrase("", setChineseFont18()));
				row_2_7.setMinimumHeight(40);
				row_2_7.setHorizontalAlignment(1);
				row_2_7.setVerticalAlignment(Element.ALIGN_MIDDLE);
				ct.addCell(row_2_7);

				PdfPCell row_2_8 = new PdfPCell(new Phrase("", setChineseFont18()));
				row_2_8.setMinimumHeight(40);
				row_2_8.setHorizontalAlignment(1);
				row_2_8.setVerticalAlignment(Element.ALIGN_MIDDLE);
				ct.addCell(row_2_8);

				PdfPCell row_2_9 = new PdfPCell(new Phrase("", setChineseFont18()));
				row_2_9.setMinimumHeight(40);
				row_2_9.setHorizontalAlignment(1);
				row_2_9.setVerticalAlignment(Element.ALIGN_MIDDLE);
				ct.addCell(row_2_9);

				j++;
			}

			document.add(ct);


			float[] widths2 = { 0.1f,0.6f,0.3f };
			PdfPTable ct2 = new PdfPTable(widths2);
			ct2.setSpacingBefore(10);
			ct2.setWidthPercentage(100);
			ct2.getDefaultCell().setBorder(PdfPCell.NO_BORDER);
			PdfPCell row2_1_1 = new PdfPCell(new Phrase("制表人:",setChineseFont18()));
			row2_1_1.setMinimumHeight(30);
			row2_1_1.setHorizontalAlignment(1);
			row2_1_1.setVerticalAlignment(Element.ALIGN_LEFT);
			row2_1_1.setBorder(PdfPCell.NO_BORDER);
			ct2.addCell(row2_1_1);

			PdfPCell row2_1_2 = new PdfPCell(new Phrase("",setChineseFont18()));
			row2_1_2.setMinimumHeight(30);
			row2_1_2.setHorizontalAlignment(1);
			row2_1_2.setVerticalAlignment(Element.ALIGN_LEFT);
			row2_1_2.setBorder(PdfPCell.NO_BORDER);
			ct2.addCell(row2_1_2);

			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

			PdfPCell row2_1_3 = new PdfPCell(new Phrase("日期:" + df.format(new Date()),setChineseFont18()));
			row2_1_3.setMinimumHeight(30);
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

}
