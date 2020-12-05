package com.imooc2.auth.service;

import com.imooc2.user.permission.service.IPermissionService;
import com.imooc2.user.role.service.IRoleService;
import com.imooc2.user.user.entity.User;
import com.imooc2.user.user.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName UserService
 * @Description:
 * @Author: Snail
 * @Date: 3:03 上午 2020/8/25
 * @Version: 1.0
**/
@Service
public class UserService implements UserDetailsService {
//    private List<User> userList;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private IUserService userService;

    @Autowired
    private IRoleService roleService;

    @Autowired
    private IPermissionService permissionService;

    @PostConstruct
    public void initData() {
//        String password = passwordEncoder.encode("123456");
//        userList = new ArrayList<>();
//        userList.add(new User("macro", password, AuthorityUtils.commaSeparatedStringToAuthorityList("admin")));
//        userList.add(new User("andy", password, AuthorityUØtils.commaSeparatedStringToAuthorityList("client")));
//        userList.add(new User("mark", password, AuthorityUtils.commaSeparatedStringToAuthorityList("client")));
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if(StringUtils.isEmpty(username)) {
            throw new UsernameNotFoundException("UserDetailsService没有接收到用户账号");
        }
        //1.内存存储读取的模式
//        List<User> findUserList = userList.stream().filter(user -> user.getUsername().equals(username)).collect(Collectors.toList());
//        if (!CollectionUtils.isEmpty(findUserList)) {
//            return findUserList.get(0);
//        } else {
//            throw new UsernameNotFoundException("用户名或密码错误");
//        }
        //2.数据库读取的模式
        User user=userService.getTbUserByUserName(username);
        if (user == null) {
            throw new RuntimeException("无效用户");
        }
        //TODO 目前只返回了角色名，权限名尚未写
        List<String> roleAndPermissionList = roleService.getRoleAndPermissionByUserId(user.getTuId());
        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        roleAndPermissionList.forEach(e->{
            SimpleGrantedAuthority simpleGrantedAuthority = new SimpleGrantedAuthority(e);
            grantedAuthorities.add(simpleGrantedAuthority);
        });

        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), grantedAuthorities);
    }
}
