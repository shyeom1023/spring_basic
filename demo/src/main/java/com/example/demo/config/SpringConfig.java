package com.example.demo.config;

import javax.persistence.EntityManager;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.demo.repository.JpaMemberRepository;
import com.example.demo.repository.MemberRepository;
import com.example.demo.service.MemberService;

@Configuration
public class SpringConfig {

//	private final DataSource dataSource;
//
//	public SpringConfig(DataSource dataSource) {
//		super();
//		this.dataSource = dataSource;
//	}

	private final EntityManager em;

	public SpringConfig(EntityManager em) {
		super();
		this.em = em;
	}

	@Bean
	public MemberService memberService() {
		return new MemberService(memberRepository());
	}

	@Bean
	public MemberRepository memberRepository() {
//		return new MemoryMemberRepository();
//		return new JdbcMemberRepository(dataSource);
//		return new JdbcTemplateMemberRepository(dataSource);
		return new JpaMemberRepository(em);
	}
}
