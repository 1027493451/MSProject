package com.imooc2.product.Atest;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.terran4j.commons.api2doc.annotations.Api2Doc;
import com.terran4j.commons.api2doc.annotations.ApiComment;
import com.terran4j.commons.api2doc.annotations.ApiError;

@Api2Doc(id = "demo1", name = "用户接口", order = 1)
@ApiComment(seeClass = User.class)
@RestController
@RequestMapping("/v3/edu/users")
public class UserController {

    @Api2Doc(order = 1)
    @ApiComment("添加一个新的用户。")
    @ApiError(value = "user.exists", comment = "此用户已经存在！")
    @PostMapping(name = "新增用户", value = "/add")
    public User addUser(
            @ApiComment("用户所在部门名称") @RequestParam(required = true) String dept,
            @ApiComment("用户名称") @RequestParam(required = true) String name,
            @ApiComment("用户密码") @RequestParam(required = true) String password,
            @ApiComment("用户类型") @RequestParam(required = true) UserType type) {
        User user = new User();
        user.setDept(dept).setName(name).setPassword(password).setType(type);
        return user; // TODO: 还未实现。
    }

    @Api2Doc(order = 2)
    @ApiComment("根据用户id，删除指定的用户")
    @ApiError(value = "user.not.found", comment = "此用户不存在！")
    @ApiError(value = "admin.cant.delete", comment = "不允许删除管理员用户！")
    @DeleteMapping(name = "删除指定用户", value = "/{id}")
    public void delete(@PathVariable("id") Long id) {

    }

    @Api2Doc(order = 3)
    @ApiComment("根据用户id，查询此用户的信息")
    @ApiError(value = "user.not.found", comment = "此用户不存在！")
    @GetMapping(name = "查询单个用户", value = "{id}")
    public User getUser(@PathVariable("id") Long id) {
        return null; // TODO: 还未实现。
    }

    @Api2Doc(order = 4)
    @ApiComment("查询所有用户，按注册时间进行排序。")
    @GetMapping(name = "查询用户列表", value = "")
    public List<User> getUsers() {
        return null; // TODO: 还未实现。
    }
}
