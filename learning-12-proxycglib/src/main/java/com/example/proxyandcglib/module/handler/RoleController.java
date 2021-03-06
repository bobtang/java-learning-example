package com.example.proxyandcglib.module.handler;

import com.example.proxyandcglib.module.model.Role;
import com.example.proxyandcglib.module.service.RoleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class RoleController {

    @Autowired
    private RoleService roleService;

    /**
     * http://localhost:8080/register?nick=%27mbs%27
     * @param nick
     * @return
     */
    @RequestMapping(value = "/register")
    @ResponseBody
    public String register(String nick) {
        Role role = new Role();
        role.setNick(nick);
        role.setLoginTime((int) (System.currentTimeMillis() / 1000));
        roleService.add(role);
        return "success";
    }

    /**
     * http://localhost:8080/login?id=1
     * @param id
     * @return
     */
    @RequestMapping(value = "/login")
    @ResponseBody
    public String login(long id) {
        Role role = roleService.get(id);
        long time = System.currentTimeMillis() / 1000;
        log.info(String.format("登录成功， 登录时间: %d", time));
        role.setLoginTime((int) (System.currentTimeMillis() / 1000));
        roleService.save(role);
        return String.format("login success, nick: %s", role.getNick());
    }

    /**
     * http://localhost:8080/get?id=1
     * @param id
     * @return
     */
    @RequestMapping(value = "/get")
    @ResponseBody
    public Role get(long id) {
        return roleService.get(id);
    }
}
