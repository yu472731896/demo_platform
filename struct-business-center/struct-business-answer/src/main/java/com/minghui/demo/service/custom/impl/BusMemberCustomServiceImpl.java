package com.minghui.demo.service.custom.impl;

import com.alibaba.fastjson.JSONObject;
import com.minghui.demo.entity.custom.bo.MemberDetails;
import com.minghui.demo.entity.custom.vo.TokenVO;
import com.minghui.demo.entity.defaults.model.BusMember;
import com.minghui.demo.entity.defaults.model.BusMemberExample;
import com.minghui.demo.service.custom.BusMemberCustomService;
import com.minghui.demo.service.defaults.impl.BusMemberServiceImpl;
import com.minghui.security.util.JwtTokenUtil;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

/**
 * 用户表服务实现类
 * @author ThinkPad 2020-08-20 14:17
 * @since 1.0.0
 */
@Service("busMemberCustomService")
public class BusMemberCustomServiceImpl extends BusMemberServiceImpl implements BusMemberCustomService {

    @Value("${jwt.tokenHeader}")
    private String tokenHeader;
    @Value("${jwt.tokenHead}")
    private String tokenHead;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    private JSONObject getJsonRequest(HttpServletRequest request) {
        JSONObject result = null;
        StringBuilder sb = new StringBuilder();
        try (BufferedReader reader = request.getReader();) {
            char[] buff = new char[1024];
            int len;
            while ((len = reader.read(buff)) != -1) {
                sb.append(buff, 0, len);
            }
            result = JSONObject.parseObject(sb.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }

        return result;
    }

    @Override
    public BusMember loginByWeixin(HttpServletRequest request) {
        return null;
    }

    @Override
    public TokenVO login(String username, String password) {
        MemberDetails userDetails = loadUserByUsername(username);
        if (null == userDetails) {
            throw new UsernameNotFoundException("用户名或密码错误");
        }
        if(!passwordEncoder.matches(password, userDetails.getPassword())){
            throw new BadCredentialsException("密码不正确");
        }
        UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String token = jwtTokenUtil.generateToken(userDetails);
        return new TokenVO(tokenHead, token);
    }

    /**
     * 根据用户名获取用户信息
     * @param username 用户名
     * @author mh
     * @date 2020/8/20 15:29
     * @return UserDetails
      **/
    @Override
    public MemberDetails loadUserByUsername(String username) {
        MemberDetails details = new MemberDetails();
        BusMemberExample example = new BusMemberExample();
        example.createCriteria().andUsernameEqualTo(username);
        List<BusMember> memberList = selectByExample(example);
        if (CollectionUtils.isNotEmpty(memberList)) {
            BeanUtils.copyProperties(memberList.get(0), details);
            return details;
        }
        return null;
    }
}