package com.wshop.controller;

import com.github.pagehelper.PageInfo;
import com.wshop.dto.condition.MultiOrderCondition;
import com.wshop.dto.condition.OrderCondition;
import com.wshop.dto.model.MultiOrdersModel;
import com.wshop.dto.model.OrderModel;
import com.wshop.entity.Customer;
import com.wshop.entity.Order;
import com.wshop.rest.Result;
import com.wshop.rest.StatusCode;
import com.wshop.service.OrderService;
import com.wshop.util.WordUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import java.text.SimpleDateFormat;
import java.util.*;

@Controller
@RequestMapping("/order/")
public class OrderController {

	@Autowired
	private OrderService orderService;

	@RequestMapping("/list")
	public ModelAndView list(@ModelAttribute OrderCondition condition, Model model, String language,
					   HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		String startTime = condition.getBirthTimeStart2();
		String endTime = condition.getBirthtimeEnd2();
		condition.setBirthtimeStart3(startTime);
		condition.setBirthtimeEnd3(endTime);

		PageInfo<Order> pageInfo = orderService.selectAll(condition);
		model.addAttribute("recordList", pageInfo.getList());
		model.addAttribute("condition", condition);
		mav.addObject("pageNum", pageInfo.getPageNum());
		mav.addObject("pageSize", pageInfo.getPageSize());
		mav.addObject("isFirstPage", pageInfo.isIsFirstPage());
		mav.addObject("totalPages", pageInfo.getPages());
		mav.addObject("isLastPage", pageInfo.isIsLastPage());
		mav.addObject("condition", condition);
		mav.addObject("recordSize", pageInfo.getList().size());
		mav.setViewName("order/order_list");
		return mav;
	}

	@RequestMapping(value = "/add_order", method = RequestMethod.GET)
	public ModelAndView add_order(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("order/order_add");
		return mav;
	}

	@RequestMapping(value = "/addOrder", method = RequestMethod.POST)
	@ResponseBody
	public Result addOrder(@ModelAttribute OrderModel model) {
		Order order = model.orderFormToOrder(model);
		Integer result = orderService.addOrder(order);
		if (result > 0) {
			return Result.ok(StatusCode.SUCCESS, "添加成功！");
		} else {
			return Result.ok(StatusCode.ERROR, "添加失败！");
		}
	}

	@RequestMapping(value = "/edit_order/{id}", method = RequestMethod.GET)
	public ModelAndView edit_order(@PathVariable("id") Integer id, Model model) {
		ModelAndView mav = new ModelAndView();
		Order order = null;
		if(id != null){ 
			order = orderService.selectByPrimaryKey(id);
		}
		mav.addObject("record", order);
		mav.setViewName("order/order_edit");
		return mav;
	}

	@RequestMapping(value = "editOrder", method = RequestMethod.POST)
	@ResponseBody
	public Result editOrder(@ModelAttribute OrderModel model) {
		ModelAndView mav = new ModelAndView();

		Order order = model.orderFormToOrder(model);
		order.setId(model.getId());
		Integer result = orderService.editOrder(order);
		if (result > 0) {
			return Result.ok(StatusCode.SUCCESS, "编辑成功！");
		} else {
			return Result.ok(StatusCode.ERROR, "编辑失败！");
		}
	}

	
	@RequestMapping(value = "/delete_order", method = RequestMethod.GET)
    public ModelAndView delete_order(@ModelAttribute OrderModel model) {
    	ModelAndView mav = new ModelAndView();
    	Integer id = model.getId();
    	if(id != null){
    		orderService.deleteByPrimaryKey(id);
    	}
    	mav.setViewName("redirect:/order/list");
		return mav;
    }

	@RequestMapping(value = "/printOrder", method = RequestMethod.GET)
	@ResponseBody
	public Result printOrder(@ModelAttribute OrderModel model) {
		ModelAndView mav = new ModelAndView();
		Integer id = model.getId();
		Order order = null;
		if(id != null){
			order = orderService.selectByPrimaryKey(id);
		}

		Map dataMap = new HashMap();
		List<OrderModel> list = new ArrayList<>();
		OrderModel orderModel = new OrderModel();
		orderModel.setMachineNumber(order.getMachineNumber());
		orderModel.setColorNumber(order.getColorNumber());
		orderModel.setCodeNumber(order.getCodeNumber());
		orderModel.setBatchNumber(order.getBatchNumber());
		orderModel.setMaterial(order.getMaterial());
		orderModel.setNumber(order.getNumber());
		orderModel.setCustomer(order.getCustomer());
		orderModel.setPackage2(order.getPackage2());
		orderModel.setRemark(order.getRemark());
		list.add(orderModel);
		dataMap.put("recordList",list);

		/** 文件名称，唯一字符串 */
		Random r=new Random();
		SimpleDateFormat sdf1=new SimpleDateFormat("yyyyMMdd_HHmmss");
		StringBuffer sb=new StringBuffer();
		sb.append(sdf1.format(new Date()));
		sb.append("_");
		sb.append(r.nextInt(100));
		//文件路径
		String filePath = Class.class.getClass().getResource("/").getPath()+"\\static\\category_img\\";
		//文件唯一名称
		String fileOnlyName = "生产通知单"+sb+".doc";
		//文件名称
		String fileName="生产通知单.doc";
		/** 生成word */
		WordUtil.createWord(dataMap, "productorder.ftl", filePath, fileOnlyName);

		return Result.one("http://127.0.0.1:8070/static/category_img/"+fileOnlyName);
	}

	@RequestMapping(value = "/printMultiOrders", method = RequestMethod.GET)
	@ResponseBody
	public Result printMultiOrders(@ModelAttribute MultiOrdersModel model){
		if(StringUtils.isEmpty(model.getPorderIds())){
			return Result.error();
		}

		String [] arr = model.getPorderIds().split(",");

		List<Integer> pOrderId = new ArrayList<>();
		if(arr.length>0){
			for(int i=0; i< arr.length;i++){
				pOrderId.add(Integer.parseInt(arr[i]));
			}
		}

		MultiOrderCondition condition = new MultiOrderCondition();
		condition.setOids(pOrderId);
		List<Order> orderList = orderService.selectAllToPrint(condition);

		Map dataMap = new HashMap();
		List<OrderModel> list = new ArrayList<>();
		for(Order order: orderList){
			OrderModel orderModel = new OrderModel();
			orderModel.setMachineNumber(order.getMachineNumber());
			orderModel.setColorNumber(order.getColorNumber());
			orderModel.setCodeNumber(order.getCodeNumber());
			orderModel.setBatchNumber(order.getBatchNumber());
			orderModel.setMaterial(order.getMaterial());
			orderModel.setNumber(order.getNumber());
			orderModel.setCustomer(order.getCustomer());
			orderModel.setPackage2(order.getPackage2());
			orderModel.setRemark(order.getRemark());
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
		String filePath = Class.class.getClass().getResource("/").getPath()+"\\static\\category_img\\";
		//文件唯一名称
		String fileOnlyName = "生产通知单"+sb+".doc";
		//文件名称
		String fileName="生产通知单.doc";
		/** 生成word */
		WordUtil.createWord(dataMap, "productorder.ftl", filePath, fileOnlyName);
		String fileFinalPath = "http://127.0.0.1:8070/static/category_img/"+fileOnlyName;
		Result result = new Result();
		result.setData(fileFinalPath);
		return result;
	}


}
