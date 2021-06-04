package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.example.demo.service.MemberService;

@Controller
public class MemberController {

	private final MemberService memberService;

	@Autowired
	public MemberController(MemberService memberService) {
		super();
		this.memberService = memberService;
	}

}
