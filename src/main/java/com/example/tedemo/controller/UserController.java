package com.example.tedemo.controller;
import com.example.tedemo.pojo.PassWord;
import com.example.tedemo.pojo.result;
import com.example.tedemo.pojo.userReg;
import com.example.tedemo.pojo.user_info;
import com.example.tedemo.service.impl.UserService;
import com.example.tedemo.utils.JwtUtil;
import com.example.tedemo.utils.Md5Util;
import com.example.tedemo.utils.ThreadLocalUtil;
import jakarta.validation.constraints.Pattern;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



@RestController
@RequestMapping("/user")
@Validated
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/registerNew")
    public result registerNew(@RequestBody @Validated userReg u){

        Map<String,Object> map = ThreadLocalUtil.get();
        String power = (String) map.get("power");
        if (!power.equals("管理员")){
            return result.error("没有权限添加用户");
        }
        System.out.println(u);
        user_info user = userService.findByUserName(u.getJobid());
        if (user == null){
            userService.registerNew(u);
            return result.success();
        }else{
            return result.error("用户存在");
        }

    }

    //注册
    @PostMapping("/register")
    public result register(@Pattern(regexp = "^\\d{1,7}$")String username , @Pattern(regexp = "^\\S{5,16}$") String password){
        //查询用户
        user_info u =  userService.findByUserName(username);
        if (u == null){
            //注册
            userService.register(username,password);
            return result.success();
        }else{
            //已存在就是视为已注册
            return result.error("用户已经被注册");
        }
    }
    //登录
    @PostMapping("/login")
    public result<String> login(String username , @Pattern(regexp = "^\\S{5,16}$") String password){
        user_info u = userService.findByUserName(username);
        System.out.println(u);
        if (u == null ) {
            return result.error("用户名错误,或者不存在此用户请去注册");
        }
        if (Md5Util.getMD5String(password).equals(u.getPassword())){
            Map<String,Object> claims = new HashMap<>();
            claims.put("id",u.getId());
            claims.put("nick",u.getNickname());
            claims.put("userName",u.getJobid());
            claims.put("power",u.getPower());
            String token = JwtUtil.genToken(claims);
//            Map<String,Object> map = ThreadLocalUtil.get();
//            String usernames = (String) map.get("userName");

            return result.success(token,u.getPower());
        }
        System.out.println(u.getPassword());
        System.out.println(Md5Util.getMD5String(password));
        return result.error("密码错误");
    }
    //获取用户信息
    @GetMapping("/userInfo")
    public result<user_info> userInfo(){
        Map<String,Object> map = ThreadLocalUtil.get();
        String username = (String) map.get("userName");
        user_info u = userService.findByUserName(username);
        return result.success(u);
    }
    //更新用户信息
    @PutMapping("/update")
    public result update(@RequestBody @Validated user_info u){
        userService.update(u);
        return result.success();
    }

    @PatchMapping("/updatePwd")
    public result<String> updatePwd(@RequestBody PassWord pwd){
        System.out.println(pwd);
        Map<String,Object> map = ThreadLocalUtil.get();
        String id  = (String) map.get("userName");
        user_info u = userService.findByUserName(id);
        if (!u.getPassword().equals(Md5Util.getMD5String(pwd.getLowPassWord()))){
            return result.error("原密码不一致");
        }
        if (!pwd.getNewPassWord().equals(pwd.getRePassWord())){
            return result.error("两次密码不一致");
        }
        if (pwd.getLowPassWord().equals(pwd.getRePassWord())){
            return result.error("原密码和密码一致");
        }
        userService.updatePwd(pwd.getRePassWord());
        return result.success("密码修改成功");
    }
    @GetMapping("/userList")
    public result<List<user_info>> userDataList(){
        List<user_info> data = userService.userAll();
        System.out.println(data);
        return result.success(data);
    }






}
