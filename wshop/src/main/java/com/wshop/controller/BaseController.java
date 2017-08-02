package com.wshop.controller;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.wshop.config.AppConstantProperties;
import com.wshop.entity.User;
import com.wshop.util.RequestUtil;
import com.wshop.util.StringUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.io.File;


/**
 * 基础控制器，Action的基类封装
 */
public abstract class BaseController {


    protected Logger log = LoggerFactory.getLogger(getClass());

    private static final ThreadLocal<HttpServletRequest> LOCAL_REQUEST = new ThreadLocal<>();

    private static final ThreadLocal<HttpServletResponse> LOCAL_RESPONSE = new ThreadLocal<>();

    @Autowired
    protected AppConstantProperties properties;

    public BaseController() {
        super();
    }

    @ModelAttribute
    public void setHttp(HttpServletRequest request, HttpServletResponse response) {
        LOCAL_REQUEST.set(request);
        LOCAL_RESPONSE.set(response);
    }

    /**
     * 获取当前request
     */
    protected HttpServletRequest getRequest() {
        return LOCAL_REQUEST.get();
    }

    /**
     * 获取当前response
     */
    protected HttpServletResponse getResponse() {
        return LOCAL_RESPONSE.get();
    }

    /**
     * 获取session
     */
    protected HttpSession getHttpSession() {
        HttpServletRequest request = LOCAL_REQUEST.get();
        return request.getSession();
    }

    /**
     * 获取当前用户
     */
    protected User getCuruser() {
        return RequestUtil.getCuruser();
    }


    /**
     * 获取当前URL
     */
    protected String getCururl() {
        HttpServletRequest request = LOCAL_REQUEST.get();
        String reqStr = request.getRequestURL().toString();
        String queryStr = request.getQueryString();

        if (StringUtils.isEmpty(queryStr)) {
            return reqStr;
        } else {
            return reqStr + "?" + queryStr;
        }
    }

    /**
     * 获取文件上传路径
     */
    public String getFileUploadPath(String... subDirectory) {
        String savepath = properties.getUploadfileSavePath();
        if (StringUtil.isEmpty(savepath)) return null;
        // unix 仅支持"/",windows支持 "/" 和 "\"，此处统一为 "/"
        savepath = savepath.replaceAll("\\\\", "/");
        // 检测目录是否以"/"结尾,没有则追加
        savepath = savepath.endsWith("/") ? savepath : savepath + "/";

        for (String dir : subDirectory) {
            if (StringUtil.isNotEmpty(dir))
                savepath = savepath.concat(dir).concat("/");
        }

        File fileDir = new File(savepath);
        if (!fileDir.exists() & !fileDir.mkdirs()) {
            log.error(savepath + "directory creation failed.");
        }
        return savepath;
    }
}
