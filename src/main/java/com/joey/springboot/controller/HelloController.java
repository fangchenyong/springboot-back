package com.joey.springboot.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;


import com.joey.springboot.exception.UserNotExistException;
import com.joey.springboot.mapper.UserMapper;
import com.joey.springboot.model.Config;
import org.apache.ibatis.javassist.ClassPath;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.joey.springboot.model.Book;
import com.joey.springboot.service.BookService;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller

//读取外部配置文件,配置多个文件 忽略没有找到的配置文件
@PropertySource(value={"jdbc.proprites","1","1"},ignoreResourceNotFound = true)
public class HelloController {

	@Autowired
	private BookService bookService;

	@Autowired
	private Config config;


	//@Value("${sql.select}")
	//private  String str;

//	@Value("${spring.mvc.view.prefix}")
	private String port;



//	@RequestMapping({"/","/login",""})
//	public String index(){
//		//System.out.println(str);
//		return "login";
//	}

	/**
	* 测试Thymeleaf
	*/
	@RequestMapping("/su")
	public String success(){
		return "su";
	}

//	@RequestMapping("/login")
//	@ResponseBody
//	public String login(HttpServletRequest request){
//		String username = request.getParameter("username");
//		String password = request.getParameter("password");
//		System.out.println("UserName:"+username);
//		System.out.println("PassWord:"+password);
//
//
//		return "UserName:"+username +"PassWord:"+password;
//
//	}



	@RequestMapping("/say")
	@ResponseBody
	public List<Book> hello() {
		List<Book> books = bookService.getAllBooks();
		return books;
	}

	@RequestMapping("/get")
	@ResponseBody
	public String get(@RequestParam("id") int id) {
		Map book = bookService.getBooksById(id);
		book.get("id");
		book.get("price");
		String title = (String)book.get("title");
		return title;
	}

	//获取配置文件参数
	@ResponseBody
	@RequestMapping("/weixin")
	public String weixin(){
		System.out.print(config.getPort());
		return port;
	}

//	@RequestMapping("")
//	public String index(Map map){
//
//		map.put("hello","<h1>nihao</h1>");
//		map.put("users", Arrays.asList("joey","zhangsan","lisi"));
//		return "su";
//	}


	@ResponseBody
	@RequestMapping("/hello")
	public  String hello(@RequestParam("user") String user){
		if(user.equals("aaa")){
			throw new UserNotExistException();
		}
		return "Hello World";
	}
}

