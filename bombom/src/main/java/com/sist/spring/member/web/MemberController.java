package com.sist.spring.member.web;

import javax.inject.Qualifier;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sist.spring.member.service.UserService;
import com.sist.spring.member.service.UserVO;

@Controller
public class MemberController {
	private final Logger LOG = LoggerFactory.getLogger(this.getClass());
	  
	@Autowired
	UserService userService;
	
	@RequestMapping(value = "member/add.do",method = RequestMethod.POST)
	public String add(UserVO user) {
		String url ="portfolio/index";		//보여�? ?��면으�? ?��?�� 보내?��?��?���? �??��(?��류없?��기위?��)
		LOG.debug("1===============");
		LOG.debug("1=user=" + user);
		LOG.debug("1===============");
		
		int flag = userService.add(user);
		LOG.debug("1.2===============");
		LOG.debug("1.2=flag=" + flag);
		LOG.debug("1.2===============");
		
		return url;
	}
	
}
