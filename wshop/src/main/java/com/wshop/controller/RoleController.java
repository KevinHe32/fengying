package com.wshop.controller;

import com.github.pagehelper.PageInfo;
import com.wshop.dto.condition.CategoryCondition;
import com.wshop.dto.condition.RoleCondition;
import com.wshop.dto.form.RoleForm;
import com.wshop.dto.model.CategoryModel;
import com.wshop.dto.model.RoleModel;
import com.wshop.entity.Category;
import com.wshop.entity.SysRole;
import com.wshop.rest.Result;
import com.wshop.rest.StatusCode;
import com.wshop.service.CategoryService;
import com.wshop.service.RoleService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@Api(description = "角色模块")
@RequestMapping(value = "/role/")
public class RoleController {

    public static Integer merchantId = 123;
    @Autowired
    private RoleService roleService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ModelAndView list(@ModelAttribute RoleCondition condition) {
        ModelAndView mav = new ModelAndView();

        condition.setMerchantId(merchantId);
        PageInfo<SysRole> pageInfo = roleService.selectAll(condition);

        mav.addObject("recordList", pageInfo);
        mav.addObject("condition", condition);

        //--------------------------------------------------------------------
        mav.addObject("recordSize", pageInfo.getList().size());
        //获得当前页
        mav.addObject("pageNum", pageInfo.getPageNum());
        //获得一页显示的条数
        mav.addObject("pageSize", pageInfo.getPageSize());
        //是否是第一页
        mav.addObject("isFirstPage", pageInfo.isIsFirstPage());
        //获得总页数
        mav.addObject("totalPages", pageInfo.getPages());
        //是否是最后一页
        mav.addObject("isLastPage", pageInfo.isIsLastPage());
        //--------------------------------------------------------------------

        mav.setViewName("role/role_list");
        return mav;
    }


    @RequestMapping(value = "/add_role", method = RequestMethod.GET)
    public ModelAndView add_role() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("role/role_add");
        return mav;
    }


    @RequestMapping(value = "addRole", method = RequestMethod.POST)
    @ResponseBody
    public Result addRole(@ModelAttribute RoleForm form) {
        if (StringUtils.isEmpty(form.getRole())) {
            return Result.error(StatusCode.ERROR, "添加角色失败，您输入的角色名称无效!");
        }
        try {
            Integer result = roleService.insertSelective(form);
            if(result > 0){
                return Result.ok(StatusCode.SUCCESS, "添加成功！");
            }else{
                return Result.ok(StatusCode.ERROR, "添加失败！");
            }
        } catch (Exception e) {
            return Result.error(StatusCode.ERROR, "添加角色发生异常：" + e.getCause().getMessage());
        }
    }


    @RequestMapping(value = "/edit_role/{id}", method = RequestMethod.GET)
    public ModelAndView edit_role(@PathVariable("id") Integer id) {
        ModelAndView mav = new ModelAndView();

        SysRole sysRole = null;
        if(id != null){
            sysRole = roleService.selectByPrimaryKey(id);
        }
        mav.addObject("record", sysRole);

        mav.setViewName("role/role_edit");
        return mav;
    }

    @RequestMapping(value = "editRole", method = RequestMethod.POST)
    @ResponseBody
    public Result editRole(@ModelAttribute RoleModel model) {
        if (StringUtils.isEmpty(model.getRole())) {
            return Result.error(StatusCode.ERROR, "更新类别失败，您输入的角色名称无效!");
        }
        if (StringUtils.isEmpty(model.getId())) {
            return Result.error(StatusCode.ERROR, "更新类别失败!");
        }

        try {
            Integer result = roleService.updateSelective(model);
            if(result > 0){
                return Result.ok(StatusCode.SUCCESS, "更新成功！");
            }else{
                return Result.ok(StatusCode.ERROR, "更新失败！");
            }
        } catch (Exception e) {
            return Result.error(StatusCode.ERROR, "更新类别发生异常：" + e.getCause().getMessage());
        }
    }

   /*



    @RequestMapping(value = "/redirectList", method = RequestMethod.GET)
    public ModelAndView redirectList(HttpServletRequest request, RedirectAttributes attr) {
        ModelAndView mav = new ModelAndView();

        attr.addFlashAttribute("newCategoryName",request.getParameter("newCategoryName"));
        mav.setViewName("redirect:/category/list");
        return mav;
    }
*/
}