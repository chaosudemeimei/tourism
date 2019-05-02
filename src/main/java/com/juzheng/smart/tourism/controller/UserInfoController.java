package com.juzheng.smart.tourism.controller;


import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.google.gson.Gson;
import com.juzheng.smart.tourism.entity.UserInfo;
import com.juzheng.smart.tourism.jwt.JwtHelper;
import com.juzheng.smart.tourism.mapper.UserInfoMapper;
import com.juzheng.smart.tourism.result.LoginRes;
import com.juzheng.smart.tourism.result.RegisertRes;
import com.juzheng.smart.tourism.service.IUserInfoService;
import com.juzheng.smart.tourism.result.BaseResult;
import com.juzheng.smart.tourism.result.LoginResult;
import com.juzheng.smart.tourism.util.IdGenerator;
import com.juzheng.smart.tourism.util.RedisClientServer;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.juzheng.smart.tourism.util.SmsUtils.sendSms;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author juzheng
 * @since 2019-04-19
 */
@RestController
@RequestMapping("/user-info")
@CrossOrigin
public class UserInfoController {
    @Autowired
    private IUserInfoService userInfoService;
    @Autowired
    private UserInfoMapper userInfoMapper;

    @ApiOperation(value="获取单个用户详细信息", notes="根据url的id来获取用户详细信息")
    @ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "Integer", paramType = "path")
    @RequestMapping(value = "api/user_info/{id}",produces="application/json;charset=UTF-8",method = RequestMethod.GET)
    public BaseResult findOneUserInfo(@PathVariable("id") Long id)
    {
        BaseResult baseResult=new BaseResult();
        baseResult.setMessage("success");
        baseResult.setStatus("1");
        baseResult.setResult(userInfoService.getById(id));
        return baseResult;

    }

    @RequestMapping(value = "/api/user_info", method = RequestMethod.GET)
    public List<UserInfo> findAllUserInfo() {
        return userInfoService.list();
    }

    @RequestMapping(value = "/api/user_info", method = RequestMethod.POST)
    public void createUser(@RequestBody UserInfo userInfo) {
        userInfoService.save(userInfo);
    }

    @RequestMapping(value = "/api/user_info", method = RequestMethod.PUT)
    public void modifyUser(@RequestBody UserInfo userInfo) {
        userInfoService.saveOrUpdate(userInfo);
    }

    @RequestMapping(value = "/api/user_info/{id}", method = RequestMethod.DELETE)
    public void del(@PathVariable("id") Long id) {
        userInfoService.removeById(id);
    }


    @ApiOperation(value="用户登录1", notes="用户名、邮箱、手机都可以登录")
    @RequestMapping(value = "/api/login",method = { RequestMethod.POST})
    public LoginResult loginRequest(@RequestBody LoginRes loginRes){
        LoginResult loginResult = new LoginResult();
        try {
            Gson gson = new Gson();
           String  user_data=loginRes.getUser_data();
           String password=loginRes.getPassword();
            QueryWrapper<UserInfo> queryWrapper1 = new QueryWrapper<>();
            QueryWrapper<UserInfo> queryWrapper2 = new QueryWrapper<>();
            QueryWrapper<UserInfo> queryWrapper3 = new QueryWrapper<>();
            queryWrapper1.lambda().eq(UserInfo::getUsername, user_data)
                                  .eq(UserInfo::getPassword,password);
            queryWrapper2.lambda().eq(UserInfo::getEmail,user_data)
                                  .eq(UserInfo::getPassword,password);
            queryWrapper3.lambda().eq(UserInfo::getPhoneNumber,user_data)
                    .eq(UserInfo::getPassword,password);
            UserInfo userInfo1=userInfoMapper.selectOne(queryWrapper1);
            UserInfo userInfo2=userInfoMapper.selectOne(queryWrapper2);
            UserInfo userInfo3=userInfoMapper.selectOne(queryWrapper3);
           /* queryWrapper.isNull("email")
                        .eq("username",username);
            UserInfo userInfo2=userInfoMapper.selectOne(queryWrapper);*/
            if (userInfo1!=null||userInfo2!=null||userInfo3!=null){
            loginResult.setStatus("200");
            loginResult.setMessage("密码正确，登录成功");
           // loginResult.setResult(user_data);
            String jwtToken = JwtHelper.generateToken(user_data);
            loginResult.setResult(jwtToken);
        }
            else
        {
            loginResult.setStatus("400");
            loginResult.setMessage("密码错误，登录失败");
            loginResult.setResult("null");
        }
    }catch (Exception e){
        e.printStackTrace();
    }
        return loginResult;
}
    @ApiOperation(value="用户注册方法一：通过用户名注册", notes="通过用户名username注册")
    @RequestMapping(value = "/api/register", method = RequestMethod.POST)
    @ResponseBody
    public String register( @RequestBody UserInfo userInfo){
        BaseResult baseResult =new BaseResult();
       if (userInfo.getUsername()!=null&&userInfo.getPassword()!=null){
           QueryWrapper<UserInfo> queryWrapper = new QueryWrapper<>();
           queryWrapper.eq("username",userInfo.getUsername());
           if(userInfoService.getOne(queryWrapper)==null) {//不存在相同用户名
               userInfoService.save(userInfo);//存入
               baseResult.setResult(userInfo.toString());
               baseResult.setMessage("注册成功");
               baseResult.setStatus("200");
           }
           else {
               baseResult.setResult(userInfo.toString());
               baseResult.setMessage("注册失败，用户名已存在");
               baseResult.setStatus("400");
           }
       }
       else {
           baseResult.setResult(userInfo.toString());
           baseResult.setMessage("no message");
           baseResult.setStatus("404");
       }
        return baseResult.getStatus();
    }

    @ApiOperation(value="用户注册方法2：通过手机号注册步骤1---点击'验证码'", notes="发送验证码")
    @RequestMapping(value = "/api/registerbynumber1", method = RequestMethod.POST)
    @ResponseBody
    public String registerbynumber( @RequestBody String phone_number) throws Exception {
        SendSmsResponse sendSms =sendSms(phone_number);//注册此处传只能传字符串手机号不要json！
        return sendSms.getCode();
    }

    @ApiOperation(value="用户注册方法2：通过手机号注册步骤2---点击'注册'", notes="通过手机号，接收验证码注册，默认生成一个userid")
    @RequestMapping(value = "/api/registerbynumber2", method = RequestMethod.POST)
    @ResponseBody
    public String registerbynumber2( @RequestBody RegisertRes regisertRes){//此时传回一个手机号+验证码
        BaseResult baseResult =new BaseResult();
        String phone_number=regisertRes.getPhone_number();
        String register_number=regisertRes.getRegister_number();
      //  System.out.println(phone_number);
        //System.out.println(register_number);
        String code= (String) RedisClientServer.get("code"+phone_number);//获得reids中的验证码
        if(register_number.equals(code)) { //与存入redis中的验证码比对，有效时间一分钟
            QueryWrapper<UserInfo> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("phone_number", phone_number);
            if(userInfoService.getOne(queryWrapper)==null){//若没注册，则注册
                UserInfo userInfo=new UserInfo();
                userInfo.setPhoneNumber(phone_number);
                String userid= IdGenerator.createUserCode();
                userInfo.setUserId(userid);
                userInfoService.save(userInfo);

                baseResult.setStatus("200");//注册成功返回200
                baseResult.setMessage("success");
                baseResult.setResult(phone_number);
            }
            else {
                baseResult.setStatus("400");
                baseResult.setMessage("注册失败，该手机号已被注册！");
                baseResult.setResult(phone_number);
            }
        }
        else{
            baseResult.setStatus("404");
            baseResult.setMessage("验证码错误！");
            baseResult.setResult(phone_number);
        }

        return baseResult.getStatus();
    }


}
