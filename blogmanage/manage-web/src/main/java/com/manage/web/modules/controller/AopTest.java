package com.manage.web.modules.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.manage.web.App;

@Controller
@RequestMapping("/testaop")
public class AopTest {
	@Autowired
	private App app;
	
	@RequestMapping("/testaop")
	@ResponseBody
	public String testaop() {
		return app.aoptest();
	}

}
