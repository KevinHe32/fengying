package com.wshop.config;

import com.wshop.damain.UserSysRole;
import com.wshop.dto.condition.CustomerCondition;
import com.wshop.entity.SysPermission;
import com.wshop.entity.SysRole;
import com.wshop.entity.UserInfo;
import com.wshop.service.RoleService;
import com.wshop.service.UserInfoService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Resource;

public class MyShiroRealm extends AuthorizingRealm {
    @Resource
    private UserInfoService userInfoService;

    @Autowired
    private RoleService roleService;

    /*查询权限*/
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        System.out.println("权限配置-->MyShiroRealm.doGetAuthorizationInfo()");
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        UserInfo userInfo  = (UserInfo)principals.getPrimaryPrincipal();
        for(SysRole role:userInfo.getRoleList()){
            authorizationInfo.addRole(role.getRole());
            for(SysPermission p : role.getPermissions()){
                //if(p.getAvailable()){
                    authorizationInfo.addStringPermission(p.getPermission());
                //}

            }
        }
        return authorizationInfo;
    }

    /*主要是用来进行身份认证的，也就是说验证用户输入的账号和密码是否正确。*/
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token)
            throws AuthenticationException {
        System.out.println("MyShiroRealm.doGetAuthenticationInfo()");
        //获取用户的输入的账号.
        String username = (String)token.getPrincipal();
        System.out.println(token.getCredentials());
        //通过username从数据库中查找 User对象，如果找到，没找到.
        //实际项目中，这里可以根据实际情况做缓存，如果不做，Shiro自己也是有时间间隔机制，2分钟内不会重复执行该方法
        UserInfo userInfo = userInfoService.findByUsername(username);
        if(userInfo == null){
            return null;
        }
        CustomerCondition customerCondition = new CustomerCondition();
        customerCondition.setUsername(username);
        UserSysRole sysRole = roleService.selectUserSysRole(customerCondition);

        Session session = SecurityUtils.getSubject().getSession();
        session.setAttribute("userInfo", userInfo);
        session.setAttribute("role", sysRole.getRole());
        session.setAttribute("name", userInfo.getName());
        System.out.println("----------username:"+userInfo.getUsername()+",role:"+sysRole.getRole());

//        System.out.println("-----------salt:" + userInfo.getCredentialsSalt());
        /*SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(
                userInfo, //用户名
                userInfo.getPassword(), //密码
                ByteSource.Util.bytes(userInfo.getCredentialsSalt()),//salt=username+salt
                getName()  //realm name
        );*/
        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(
                userInfo, //用户名
                userInfo.getPassword(), //密码0
                getName()  //realm name
        );
        return authenticationInfo;
    }

}