package com.base.controller;

import com.base.dao.pojo.User;
import com.base.exception.SystemException;
import com.base.service.UserService;
import com.wordnik.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.apache.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("manager")
public class LoginController {
    @Autowired
    private UserService userService;
    private Logger logger;

    {
        logger = Logger.getLogger(this.getClass());
    }

    @RequestMapping("{system}")
    public String index(HttpServletRequest request, @PathVariable("system") String system) {
        User user = new User();
        user.setUsername(system);
        user = userService.getUserByUser(user);
        User currentUsr = (User) request.getSession().getAttribute("currentUser");
        if (user == null) throw new SystemException("不存在该管理员!");
        if (currentUsr != null && user.getId().intValue() == currentUsr.getId()) {
            return "manager/main";
        } else {
            return "manager/login";
        }
    }

    /**
     * 管理系统页面跳转
     */
    @RequestMapping("/action")
    public String go(HttpServletRequest request, ModelMap model) {
        String path = null;
        for (Object paramName : request.getParameterMap().keySet()) {
            if (StringUtils.isNotBlank((String) paramName)) {
                String paramValue = request.getParameter((String) paramName);
                model.addAttribute((String) paramName, paramValue);
                if (paramName.equals("path")) {
                    path = paramValue;
                } else {
                    model.addAttribute((String) paramName, paramValue);
                }
            }
        }
        if (StringUtils.isBlank(path)) {
            throw new SystemException("请输入需要请求的页面路径!");
        }
        return path;
    }

    /**
     * 用户登录
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(HttpServletRequest request, User user, @RequestParam(value = "remember", defaultValue = "false") Boolean remember) {

        String username = user.getUsername();
        String password = user.getPassword();


        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
//        记住登录
        token.setRememberMe(remember);
        logger.debug("为了验证登录用户而封装的token为" + ReflectionToStringBuilder.toString(token, ToStringStyle.MULTI_LINE_STYLE));
        //获取当前的Subject
        Subject currentUser = SecurityUtils.getSubject();
        try {
            //在调用了login方法后,SecurityManager会收到AuthenticationToken,并将其发送给已配置的Realm执行必须的认证检查
            //每个Realm都能在必要时对提交的AuthenticationTokens作出反应
            //所以这一步在调用login(token)方法时,它会走到MyRealm.doGetAuthenticationInfo()方法中,具体验证方式详见此方法
            logger.debug("对用户[" + username + "]进行登录验证..验证开始");
            currentUser.login(token);
            logger.debug("对用户[" + username + "]进行登录验证..验证通过");
        } catch (UnknownAccountException uae) {
            logger.debug("对用户[" + username + "]进行登录验证..验证未通过,未知账户");
            request.setAttribute("message_login", "未知账户");
        } catch (IncorrectCredentialsException ice) {
            logger.debug("对用户[" + username + "]进行登录验证..验证未通过,错误的凭证");
            request.setAttribute("message_login", "密码不正确");
        } catch (LockedAccountException lae) {
            logger.debug("对用户[" + username + "]进行登录验证..验证未通过,账户已锁定");
            request.setAttribute("message_login", "账户已锁定");
        } catch (ExcessiveAttemptsException eae) {
            logger.debug("对用户[" + username + "]进行登录验证..验证未通过,错误次数过多");
            request.setAttribute("message_login", "用户名或密码错误次数过多");
        } catch (AuthenticationException ae) {
            //通过处理Shiro的运行时AuthenticationException就可以控制用户登录失败或密码错误时的情景
            logger.error("对用户[" + username + "]进行登录验证..验证未通过,堆栈轨迹如下");
            ae.printStackTrace();
            request.setAttribute("message_login", "用户名或密码不正确");
        }
        //验证是否登录成功
        if (currentUser.isAuthenticated()) {
            logger.debug("用户[" + username + "]登录认证通过(这里可以进行一些认证通过后的一些系统参数初始化操作)");
            return "redirect:main";
        } else {
            token.clear();
        }
        return "manager/login";
    }


    /**
     * 用户登出
     */
    @RequestMapping("logout")
    public String logout(HttpServletRequest request) {
        SecurityUtils.getSubject().logout();
        return InternalResourceViewResolver.REDIRECT_URL_PREFIX + "main";
    }

    /**
     * 主页
     */
    @RequestMapping("main")
    public String main(HttpServletRequest request) {
        return "manager/main";
    }
}
