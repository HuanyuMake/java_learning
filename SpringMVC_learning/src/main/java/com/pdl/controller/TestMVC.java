package com.pdl.controller;

import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.jetbrains.annotations.NotNull;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Date: 2023/1/29 15:04
 *
 * @author 潘栋磊
 * @version 0.0.1
 */
//@RestController //这个注解相当于 @Controller 和 给每个方法加上 @ResponseBody 的效果,这个以后比较常用
@Controller
public class TestMVC {

    // RequestMapping 支持 RESTfull 风格的url, 也即是 在url中携带 param 参数
    @RequestMapping("/t1/{id}/{name}")
    // 如果该处理方法没有返回值,也没有通过HttpRequest对象获取writer写内容, 则直接按照该请求路径,发送这个路径下的文件(一般以html的后缀发送)
    public void t1(@PathVariable("id") Integer id,@PathVariable("name") String name){
        System.out.println("id > "+id+" name > "+name);

    }

    @RequestMapping("/t2")
    public String t2(@NotNull HttpServletRequest req){
        String name = req.getParameter("name");
        String password = req.getParameter("password");
        System.out.println("name "+name+", password "+password);
        return "redirect:/"; // 重定向到绝对路径 /
    }

    @RequestMapping("/t3")
    public String t3( String name, String password){
        System.out.println("t3 name "+name+", password "+password);
        return "";
    }
    /*  @RequestParam
        如果形参与 req的query body参数(application/x-www-form-urlencoded格式)
        名字不一致, 可以通过 t3(@RequestParam("username") String name, String password)
        指定 请求参数 "username" 赋值给 该形参 "name"

        public @interface RequestParam {
        @AliasFor("name")
        String value() default ""; //指定与 该形参绑定的请求参数名

        @AliasFor("value")
        String name() default "";

        boolean required() default true; // 该请求参数是否必须传? 默认为必须传, 不传就会给客户端报错

        // 不传该参数,默认值是?
        String defaultValue() default "\n\t\t\n\t\t\n\ue000\ue001\ue002\n\t\t\t\t\n";
    }*/

    /*
    * @RequestHeader 将请求头信息与形参绑定
    * @RequestCookie 将Cookie信息与形参绑定
    *
    * 和 @RequestParam 的用法一致
    *
    * !!!通过实体类形参来获取请求参数 (暂时不知道是否可以同时获取Header, Cookie等其它信息)
    * 当时要保证 实体类的属性名与请求参数名一致,否则实体类对象的对应属性不会被赋值
    * */

    @RequestMapping("/t4")
    public String t4( User user){
        System.out.println(user);
        return "";
    }

    /*
    * **请求域 RequestScope
    * 以下4种 共享数据到请求域中的方式实质上都一样, 都会接收到
    * 一个 BindingAwareModelMap类 对象, 使用该类对应方法即可共享数据
    * BindingAwareModelMap -extends-> ExtendedModelMap -impl-> Model
    * ExtendedModelMap -extends-> ModelMap -extends-> LinkedHashMap -impl-> Map
    *
    * @param ModelAndView还可以实现页面跳转, 如果想实现该功能,就需要返回其
    * */
    @RequestMapping("/shareMAV")
    public ModelAndView shareDataInRequestDomainByModelAndView(ModelAndView mav){
        mav.addObject("k1", new User("name","44"));
        return mav;
    }
    @RequestMapping("/shareModelMap")
    public String shareDataInRequestDomainByModelMap(ModelMap mp){
        mp.addAttribute("k1", new User("name","44"));
        return "";
    }
    @SuppressWarnings("all")
    @RequestMapping("/shareMap")
    public String shareDataInRequestDomainByModelMap(Map m){
        m.put("k1", new User("name","44"));
        return "";
    }
    @RequestMapping("/shareModel")
    public String shareDataInRequestDomainByModel(Model m){
        m.addAttribute("k1", new User("name","44"));
        return "";
    }

    /**
     * **会话域  SessionScope
     * 在一次会话 连接 中共享数据
     * */
    @RequestMapping("/shareToSessionByHttpSession")
    public String shareToSessionByHttpSession(HttpSession session){
//        session中的对象想要被持久化, 这些对象的类必须实现 java.io.Serializable接口
        session.setAttribute("key1",new Object());
        return "";
    }
    /**
     * **应用域 ApplicationScope
     * 在服务器启动的这一次应用中共享数据
     * */
    @RequestMapping("/shareToApplicationByHttpSession")
    public String shareToApplicationByHttpSession(HttpSession session){
        ServletContext servletContext = session.getServletContext();
        servletContext.setAttribute("key1",new Object());
        return "";
    }
    @RequestMapping("/handleJsonBody")
    @ResponseBody  // 标注后,若返回一个实体类对象,则转化为json
    public User handleJsonBody(@RequestBody User user){
        System.out.println("小王".equals(user.getName())); // 传的 json 是 {"name": "小王", "password": "123456"}
        System.out.println(user); // IDEA的控制台会乱码 但是在程序里对应的字符集都是UTF-8不会"乱码"
        return user;
    }

    @RequestMapping("/handleJsonBodyReturnMap")
    @ResponseBody  // 标注后,若返回一个实体类对象,则转化为json
    public Map<String,String> handleJsonBodyReturnMap(@RequestBody User user){
        HashMap<String, String> m = new HashMap<>();
        m.put("name", user.getName());
        m.put("password", user.getPassword());
        // 效果同上
        return m;
    }

    @RequestMapping("/handleJsonBodyReturnJSArray")
    @ResponseBody
    public List<User> handleJsonBodyReturnJSArray(@RequestBody User user){
        // 返回一个 js 数组
        return Arrays.asList(user,user,user,user);
    }

    @RequestMapping("/fileDownload/{fileName}") // 客户端下载文件
    public ResponseEntity<byte[]> DownloadFile(HttpSession session, @PathVariable("fileName") String fileName) throws IOException {
        //获取ServletContext对象
        ServletContext servletContext = session.getServletContext();
        //文件的真实路径 servletContext.getRealPath() 该应用路径
        String realPath = servletContext.getRealPath("static");

        // 根据系统获取 下载的文件的绝对路径
        realPath = realPath + File.separator + fileName;

        //创建输入流
        InputStream inputStream = new FileInputStream(realPath);
        //创建字节数组
        byte[] bytes = new byte[inputStream.available()];
        //将流读到字节数组中
        inputStream.read(bytes);
        //创建HttpHeaders对象，设置响应头信息
        MultiValueMap<String,String> headers = new HttpHeaders();
        //设置下载方式和下载文件的名称   attachment表示以附件的形式下载
        headers.add("Content-Disposition","attachment;filename="+fileName);
        //设置响应状态码
        HttpStatus status = HttpStatus.OK;
        //创建ResponseEntity对象
        ResponseEntity<byte[]> responseEntity = new ResponseEntity<>(bytes,headers,status);
        //关闭输入流
        inputStream.close();
        return responseEntity;
    }

    @RequestMapping("/fileUpload")
    @ResponseBody
    public String uploadFile(MultipartFile file){
        String filename = file.getOriginalFilename();
        System.out.println("filename > "+filename);
        return "success";
    }
    @RequestMapping("/makeArithmeticException")
    public String makeArithmeticException(){
        throw new ArithmeticException("创造一个算数逻辑异常");
    }
}

class User /*implements Serializable*/ {
    private String name;

    private String password;

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public User() {
    }

    public User(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public User setName(String name) {
        this.name = name;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public User setPassword(String password) {
        this.password = password;
        return this;
    }
}
