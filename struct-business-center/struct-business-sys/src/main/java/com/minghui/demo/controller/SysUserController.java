package com.minghui.demo.controller;

import com.minghui.common.framework.model.CommonResult;
import com.minghui.common.framework.model.PageResult;
import com.minghui.demo.entity.custom.dto.SysUserParam;
import com.minghui.demo.entity.custom.dto.UmsAdminLoginParam;
import com.minghui.demo.entity.defaults.model.SysUser;
import com.minghui.demo.service.custom.SysUserCustomService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.HashMap;
import java.util.Map;

/**
 * 系统用户管理
 * Created by macro on 2018/4/26.
 */
@RestController
@Api(tags = "sysUserController", description = "系统用户管理")
@RequestMapping("/sysUser")
@Slf4j
public class SysUserController {

    @Value("${jwt.tokenHeader}")
    private String tokenHeader;

    @Value("${jwt.tokenHead}")
    private String tokenHead;

    @Autowired
    SysUserCustomService sysUserCustomService;


    @ApiOperation(value = "登录以后返回token")
    @RequestMapping(value = "/b/login", method = RequestMethod.POST)
    public PageResult login(@RequestBody UmsAdminLoginParam umsAdminLoginParam) {
        String token = sysUserCustomService.login(umsAdminLoginParam.getUsername(), umsAdminLoginParam.getPassword());
        if (token == null) {
            return PageResult.error("用户名或密码错误");
        }
        Map<String, String> tokenMap = new HashMap<>();
        tokenMap.put("token", token);
        tokenMap.put("tokenHead", tokenHead);
        return PageResult.ok(tokenMap);
    }

//    @ApiOperation(value = "刷新token")
//    @RequestMapping(value = "/refreshToken", method = RequestMethod.GET)
//    @ResponseBody
//    public CommonResult refreshToken(HttpServletRequest request) {
//        String token = request.getHeader(tokenHeader);
//        String refreshToken = adminService.refreshToken(token);
//        if (refreshToken == null) {
//            return CommonResult.failed("token已经过期！");
//        }
//        Map<String, String> tokenMap = new HashMap<>();
//        tokenMap.put("token", refreshToken);
//        tokenMap.put("tokenHead", tokenHead);
//        return CommonResult.success(tokenMap);
//    }

    @ApiOperation(value = "获取当前登录用户信息")
    @RequestMapping(value = "/info", method = RequestMethod.GET)
    public PageResult getCurrentUser(Principal principal) {
        PageResult result;
        try {
            String username = principal.getName();
            SysUser sysUser = sysUserCustomService.getUserByUsername(username);
            Map<String, Object> data = new HashMap<>();
            data.put("username", sysUser.getUsername());
            data.put("roles", new String[]{"TEST"});
            data.put("icon", sysUser.getIcon());
            result = PageResult.ok(data, "调用成功");
        } catch (Exception e) {
            log.error("【系统用户管理】获取当前用户信息异常", e);
            result = PageResult.error("获取当前用户信息异常");
        }
        return result;
    }

    @ApiOperation(value = "登出功能")
    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public CommonResult logout() {
        return CommonResult.success(null);
    }

    @ApiOperation(value = "添加用户")
    @RequestMapping(value = "/insertUser", method = RequestMethod.POST)
    public PageResult<SysUser> register(@RequestBody SysUserParam sysUserParam) {
        PageResult result;
        try {
            boolean insertFlag = sysUserCustomService.insertUser(sysUserParam);
            if (insertFlag) {
                result = PageResult.ok("添加成功");
            } else {
                result = PageResult.error("添加失败");
            }
        } catch (Exception e) {
            log.error("【系统用户管理】添加用户异常，e:{}", e);
            result = PageResult.error("添加用户异常");
        }
        return result;
    }

    @ApiOperation(value = "验证用户名是否存在")
    @RequestMapping(value = "/userNameIsExist", method = RequestMethod.GET)
    public PageResult<SysUser> checkUserName(String userName) {
        PageResult result;
        try {
            boolean isExist = sysUserCustomService.checkUserName(userName);
            if (isExist) {
                result = PageResult.error("用户名称已存在！");
            } else {
                result = PageResult.ok("用户名不存在");
            }
        } catch (Exception e) {
            log.error("【系统用户管理】验证用户名是否存在异常，e:{}", e);
            result = PageResult.error("验证用户名是否存在异常");
        }
        return result;
    }


    @ApiOperation("获取用户列表")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public PageResult<SysUser> list(String userName) {
        PageResult result;
        try {
            boolean isExist = sysUserCustomService.checkUserName(userName);
            if (isExist) {
                result = PageResult.error("用户名称已存在！");
            } else {
                result = PageResult.ok("用户名不存在");
            }
        } catch (Exception e) {
            log.error("【系统用户管理】验证用户名是否存在异常，e:{}", e);
            result = PageResult.error("验证用户名是否存在异常");
        }
        return result;
    }
//
//    @ApiOperation("获取指定用户信息")
//    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
//    @ResponseBody
//    public CommonResult<UmsAdmin> getItem(@PathVariable Long id) {
//        UmsAdmin admin = adminService.getItem(id);
//        return CommonResult.success(admin);
//    }
//
//    @ApiOperation("修改指定用户信息")
//    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
//    @ResponseBody
//    public CommonResult update(@PathVariable Long id, @RequestBody UmsAdmin admin) {
//        int count = adminService.update(id, admin);
//        if (count > 0) {
//            return CommonResult.success(count);
//        }
//        return CommonResult.failed();
//    }
//
//    @ApiOperation("修改指定用户密码")
//    @RequestMapping(value = "/updatePassword", method = RequestMethod.POST)
//    @ResponseBody
//    public CommonResult updatePassword(@RequestBody UpdateAdminPasswordParam updatePasswordParam) {
//        int status = adminService.updatePassword(updatePasswordParam);
//        if (status > 0) {
//            return CommonResult.success(status);
//        } else if (status == -1) {
//            return CommonResult.failed("提交参数不合法");
//        } else if (status == -2) {
//            return CommonResult.failed("找不到该用户");
//        } else if (status == -3) {
//            return CommonResult.failed("旧密码错误");
//        } else {
//            return CommonResult.failed();
//        }
//    }
//
//    @ApiOperation("删除指定用户信息")
//    @RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
//    @ResponseBody
//    public CommonResult delete(@PathVariable Long id) {
//        int count = adminService.delete(id);
//        if (count > 0) {
//            return CommonResult.success(count);
//        }
//        return CommonResult.failed();
//    }
//
//    @ApiOperation("给用户分配角色")
//    @RequestMapping(value = "/role/update", method = RequestMethod.POST)
//    @ResponseBody
//    public CommonResult updateRole(@RequestParam("adminId") Long adminId,
//                                   @RequestParam("roleIds") List<Long> roleIds) {
//        int count = adminService.updateRole(adminId, roleIds);
//        if (count >= 0) {
//            return CommonResult.success(count);
//        }
//        return CommonResult.failed();
//    }
//
//    @ApiOperation("获取指定用户的角色")
//    @RequestMapping(value = "/role/{adminId}", method = RequestMethod.GET)
//    @ResponseBody
//    public CommonResult<List<UmsRole>> getRoleList(@PathVariable Long adminId) {
//        List<UmsRole> roleList = adminService.getRoleList(adminId);
//        return CommonResult.success(roleList);
//    }
//
//    @ApiOperation("给用户分配+-权限")
//    @RequestMapping(value = "/permission/update", method = RequestMethod.POST)
//    @ResponseBody
//    public CommonResult updatePermission(@RequestParam Long adminId,
//                                         @RequestParam("permissionIds") List<Long> permissionIds) {
//        int count = adminService.updatePermission(adminId, permissionIds);
//        if (count > 0) {
//            return CommonResult.success(count);
//        }
//        return CommonResult.failed();
//    }
//
//    @ApiOperation("获取用户所有权限（包括+-权限）")
//    @RequestMapping(value = "/permission/{adminId}", method = RequestMethod.GET)
//    @ResponseBody
//    public CommonResult<List<UmsPermission>> getPermissionList(@PathVariable Long adminId) {
//        List<UmsPermission> permissionList = adminService.getPermissionList(adminId);
//        return CommonResult.success(permissionList);
//    }
}
