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
import io.jsonwebtoken.Claims;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
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
//@CrossOrigin(allowCredentials="true",maxAge = 3600)
public class UserInfoController {
    @Autowired
    private IUserInfoService userInfoService;

    @Autowired
    private UserInfoMapper userInfoMapper;

   /* @RequestMapping(value = "/api/user_info", method = RequestMethod.GET)
    public List<UserInfo> findAllUserInfo() {
        return userInfoService.list();
    }*/

  /*  @RequestMapping(value = "/api/user_info", method = RequestMethod.POST)
    public void createUser(@RequestBody UserInfo userInfo) {
        userInfoService.save(userInfo);
    }*/

    /*@RequestMapping(value = "/api/user_info", method = RequestMethod.PUT)
    public void modifyUser(@RequestBody UserInfo userInfo) {
        userInfoService.saveOrUpdate(userInfo);
    }*/

    @RequestMapping(value = "/api/user_info/{id}", method = RequestMethod.DELETE)
    public void del(@PathVariable("id") Long id) {
        userInfoService.removeById(id);
    }

/*    @ApiOperation(value="根据id获取单个用户详细信息", notes="根据url的id来获取用户详细信息")
    @ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "Integer", paramType = "path")
    @RequestMapping(value = "api/user_info/{id}",produces="application/json;charset=UTF-8",method = RequestMethod.GET)
    public BaseResult<UserInfo> findOneUserInfo(@PathVariable("id") Long id)
    {
        BaseResult baseResult=new BaseResult();
        baseResult.setMessage("success");
        baseResult.setStatus("200");
        baseResult.setResult(userInfoService.getById(id));
        return baseResult;

    }*/

    @ApiOperation(value="根据独有的信息获取单个用户详细信息", notes="用户名、手机号、邮箱、uuid")
    @RequestMapping(value = "api/user_info/{info}",produces="application/json;charset=UTF-8",method = RequestMethod.GET)
    public BaseResult<UserInfo> findOneUserInfo2(@PathVariable("info") String info)
    {
        BaseResult baseResult=new BaseResult();
        QueryWrapper<UserInfo> queryWrapper1 = new QueryWrapper<>();
        QueryWrapper<UserInfo> queryWrapper2 = new QueryWrapper<>();
        QueryWrapper<UserInfo> queryWrapper3 = new QueryWrapper<>();
        QueryWrapper<UserInfo> queryWrapper4 = new QueryWrapper<>();
        queryWrapper1.lambda().eq(UserInfo::getUsername, info);
        queryWrapper2.lambda().eq(UserInfo::getEmail,info);
        queryWrapper3.lambda().eq(UserInfo::getPhoneNumber,info);
        queryWrapper4.lambda().eq(UserInfo::getUserId,info);
        UserInfo userInfo1=userInfoService.getOne(queryWrapper1);
        UserInfo userInfo2=userInfoService.getOne(queryWrapper2);
        UserInfo userInfo3=userInfoService.getOne(queryWrapper3);
        UserInfo userInfo4=userInfoService.getOne(queryWrapper4);
        String status="400";
        if (userInfo1!=null)
        {
            baseResult.setResult(userInfo1);
            status="200";
            baseResult.setResult(userInfo1);
        }
        if (userInfo2!=null){
            baseResult.setResult(userInfo2);
            status="200";
            baseResult.setResult(userInfo2);
        }
        if (userInfo3!=null){
            baseResult.setResult(userInfo3);
            status="200";
            baseResult.setResult(userInfo3);
        }
        if (userInfo4!=null){
            baseResult.setResult(userInfo4);
            status="200";
            baseResult.setResult(userInfo4);
        }
        if (status.equals("200"))
            baseResult.setMessage("success");
        else
            baseResult.setMessage("error");

        return baseResult;

    }
    @ApiOperation(value="用户登录情况一：有密码", notes="用户名、邮箱、手机都可以登录")
    @RequestMapping(value = "/api/login1",method = { RequestMethod.POST})
    public LoginResult loginRequest(@RequestBody LoginRes loginRes){
        LoginResult loginResult = new LoginResult();
       // System.out.println(loginRes);
        try {
            String user_data=loginRes.getUser_data1();
            String password=loginRes.getUser_data2();
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
            ArrayList<UserInfo> userInfos=new ArrayList<>();
            userInfos.add(userInfo1);
            userInfos.add(userInfo2);
            userInfos.add(userInfo3);
            String jwtToken=null;
                for(UserInfo userInfo:userInfos){
                if(userInfo!=null){
                     jwtToken=JwtHelper.generateToken(userInfo.getUserId());
                }
            }
            ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes)RequestContextHolder.getRequestAttributes();
            HttpServletResponse response = servletRequestAttributes.getResponse();
            Cookie cookie = new Cookie("token", jwtToken);
            cookie.setMaxAge(3600);
            cookie.setDomain("localhost");
            cookie.setPath("/");
            response.addCookie(cookie);
            loginResult.setResult(jwtToken);
            System.out.println(jwtToken);
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
    @ApiOperation(value="用户登录情况二：无密码登录，步骤1", notes="发送验证码")
    @RequestMapping(value = "/api/login2bynumber1", method = RequestMethod.POST)
    @ResponseBody
    public String login2bynumber1( @RequestBody String phone_number) throws Exception {
        SendSmsResponse sendSms =sendSms(phone_number);//此处传只能传字符串手机号不要json！
        return sendSms.getCode();
    }

    @ApiOperation(value="用户登录情况二：无密码登录，步骤2", notes="只可以手机号+验证码登录")
    @RequestMapping(value = "/api/login2bynumber2",method = { RequestMethod.POST})
    public LoginResult login2bynumber2(@RequestBody LoginRes loginRes) {
        LoginResult loginResult=new LoginResult();
        String user_data1 = loginRes.getUser_data1();
        String user_data2 = loginRes.getUser_data2();
        String code = (String) RedisClientServer.get("code" + user_data1);//获得reids中的验证码
        if (user_data2.equals(code)) { //与存入redis中的验证码比对，有效时间5分钟
            QueryWrapper<UserInfo> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("phone_number",user_data1);
            UserInfo userInfo=userInfoService.getOne(queryWrapper);
            if(userInfo!=null){//跟数据库比对若存在该用户
                String jwtToken = JwtHelper.generateToken(userInfo.getUserId());
                ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes)RequestContextHolder.getRequestAttributes();
                HttpServletResponse response = servletRequestAttributes.getResponse();
                Cookie cookie = new Cookie("token", jwtToken);
                cookie.setMaxAge(3600);
                cookie.setDomain("localhost");
                cookie.setPath("/");
                response.addCookie(cookie);
                // System.out.println(response.getHeaders("set-cookie"));
                loginResult.setResult(jwtToken);
                loginResult.setMessage(userInfo.getUserId());
                loginResult.setStatus("200");
            }
            else {//若不存在自动注册
                UserInfo userInfo2=new UserInfo();
                userInfo2.setRegisterTime(LocalDateTime.now());
                userInfo2.setUserId(IdGenerator.createUserCode());
                userInfo2.setPhoneNumber(user_data1);
                userInfoService.save(userInfo2);//存入
                String jwtToken = JwtHelper.generateToken(userInfo2.getUserId());

                ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes)RequestContextHolder.getRequestAttributes();
                HttpServletResponse response = servletRequestAttributes.getResponse();
                Cookie cookie = new Cookie("token", jwtToken);
                cookie.setMaxAge(3600);
                cookie.setDomain("localhost");
                cookie.setPath("/");
                response.addCookie(cookie);

                loginResult.setResult(jwtToken);
                loginResult.setMessage("验证码正确，自动注册，登录成功！");
                loginResult.setStatus("201");
            }
        }
        else {
            loginResult.setResult(user_data1);
            loginResult.setMessage("登录失败");
            loginResult.setStatus("400");
        }
        //System.out.println(loginResult.getResult());
        return loginResult;
    }
    @ApiOperation(value="用户注册方法一：通过用户名注册", notes="通过用户名username注册")
    @RequestMapping(value = "/api/register1", method = RequestMethod.POST)
    @ResponseBody
    public BaseResult register( @RequestBody UserInfo userInfo){
        BaseResult baseResult =new BaseResult();
       if (userInfo.getUsername()!=null&&userInfo.getPassword()!=null){
           QueryWrapper<UserInfo> queryWrapper = new QueryWrapper<>();
           queryWrapper.eq("username",userInfo.getUsername());
           if(userInfoService.getOne(queryWrapper)==null) {//不存在相同用户名
               userInfo.setRegisterTime(LocalDateTime.now());
               userInfo.setUserId(IdGenerator.createUserCode());
               userInfoService.save(userInfo);//存入
               String  jwtToken=JwtHelper.generateToken(userInfo.getUserId());
               ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes)RequestContextHolder.getRequestAttributes();
               HttpServletResponse response = servletRequestAttributes.getResponse();
               Cookie cookie = new Cookie("token", jwtToken);
               cookie.setMaxAge(3600);
               cookie.setDomain("localhost");
               cookie.setPath("/");
               response.addCookie(cookie);
               baseResult.setResult(jwtToken);
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
        return baseResult;
    }

    @ApiOperation(value="用户注册方法2：通过手机号注册步骤1---点击'验证码'", notes="发送验证码")
    @RequestMapping(value = "/api/register2bynumber1", method = RequestMethod.POST)
    @ResponseBody
    public String registerbynumber( @RequestBody String phone_number) throws Exception {
        SendSmsResponse sendSms =sendSms(phone_number);//注册此处传只能传字符串手机号不要json！
        return sendSms.getCode();
    }

    @ApiOperation(value="用户注册方法2：通过手机号注册步骤2---点击'注册'", notes="通过手机号，接收验证码注册，默认生成一个userid")
    @RequestMapping(value = "/api/register2bynumber2", method = RequestMethod.POST)
    @ResponseBody
    public BaseResult registerbynumber2( @RequestBody RegisertRes regisertRes){//此时传回一个手机号+验证码
        BaseResult baseResult =new BaseResult();
        String phone_number=regisertRes.getPhone_number();
        String register_number=regisertRes.getRegister_number();
        String code= (String) RedisClientServer.get("code"+phone_number);//获得reids中的验证码
        if(register_number.equals(code)) { //与存入redis中的验证码比对，有效时间5分钟
            QueryWrapper<UserInfo> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("phone_number", phone_number);
            if(userInfoService.getOne(queryWrapper)==null){//若没注册，则注册
                UserInfo userInfo=new UserInfo();
                userInfo.setPhoneNumber(phone_number);
                String userid= IdGenerator.createUserCode();
                userInfo.setUserId(userid);
                userInfo.setRegisterTime(LocalDateTime.now());//此种方法注册没有密码，下次登录还得验证码登录
                userInfoService.save(userInfo);

                String  jwtToken=JwtHelper.generateToken(userid);
                ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes)RequestContextHolder.getRequestAttributes();
                HttpServletResponse response = servletRequestAttributes.getResponse();
                Cookie cookie = new Cookie("token", jwtToken);
                cookie.setMaxAge(3600);
                cookie.setDomain("localhost");
                cookie.setPath("/");
                response.addCookie(cookie);
                baseResult.setResult(jwtToken);
                baseResult.setStatus("200");//注册成功返回200
                baseResult.setMessage("注册成功");
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

        return baseResult;
    }

    @ApiOperation(value="根据token获取用户信息", notes="token需要解析")
    @RequestMapping(value = "/api/user_info/token", method = RequestMethod.GET)
    public BaseResult<UserInfo> findUser() {
       ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes)RequestContextHolder.getRequestAttributes();
        HttpServletRequest request= servletRequestAttributes.getRequest();
        String jwttoken=request.getHeader("token");
        Claims claims=JwtHelper.verifyJwt(jwttoken);
        String userid = String.valueOf(claims.get("userid"));
        QueryWrapper<UserInfo> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_id", userid);
        UserInfo userInfo=userInfoService.getOne(queryWrapper);
        BaseResult baseResult=new BaseResult();
        if(userInfo!=null){
            baseResult.setResult(userInfo);
            baseResult.setStatus("200");//注册成功返回200
            baseResult.setMessage("查询成功");
            return baseResult;
        }
        else {
            baseResult.setResult(userInfo);
            baseResult.setStatus("400");//注册成功返回200
            baseResult.setMessage("查询失败");
            return baseResult;
        }
    }

    @ApiOperation(value="修改用户信息", notes="token需要解析")
    @RequestMapping(value = "/api/user_info", method = RequestMethod.PUT)
    public BaseResult<UserInfo> Userupdate(@RequestBody UserInfo userInfo) {
        BaseResult baseResult=new BaseResult();
        if(userInfo!=null){
            QueryWrapper<UserInfo> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("user_id",userInfo.getUserId());
     /*       UserInfo userInfo2=userInfoService.getOne(queryWrapper);
            userInfo2.setUsername(userInfo.getUsername());
            userInfo2.setPhoneNumber(userInfo.getPhoneNumber());
            userInfo2.setEmail(userInfo.getEmail());
            userInfo2.setSex(userInfo.getSex());
            userInfo2.setBirthday(userInfo.getBirthday());
            userInfo2.setRegisterTime(userInfo.getRegisterTime());
            userInfo2.setRealname(userInfo.getRealname());
            userInfo2.setRemark(userInfo.getRemark());
            userInfoService.saveOrUpdate(userInfo2);*/
            userInfo.updateById();
            baseResult.setResult(userInfo);
            baseResult.setStatus("200");
            baseResult.setMessage("修改成功");
            return baseResult;
        }
        else {
            baseResult.setResult(userInfo);
            baseResult.setStatus("400");
            baseResult.setMessage("查询失败");
            return baseResult;
        }
    }




}
