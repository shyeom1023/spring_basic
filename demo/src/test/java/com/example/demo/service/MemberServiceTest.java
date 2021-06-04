package com.example.demo.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.example.demo.domain.Member;
import com.example.demo.repository.MemoryMemberRepository;

public class MemberServiceTest {

	MemberService memberService;
	MemoryMemberRepository memberRepository;

	@BeforeEach
	public void beforeEach() {
		memberRepository = new MemoryMemberRepository();
		memberService = new MemberService(memberRepository);

	}

	@AfterEach
	public void afterEach() {
		memberRepository.clearStore();
	}

	@Test
	public void testJoin() {

		// given
		Member member = new Member();
		member.setName("spring1");

		// when
		Long saveId = memberService.join(member);

		// then
		Member findMember = memberService.findOne(saveId).get();

		assertThat(member.getName()).isEqualTo(findMember.getName());
	}

	@Test
	public void testJoinDuplicate() {
		// given
		Member member1 = new Member();
		member1.setName("spring1");

		Member member2 = new Member();
		member2.setName("spring1");

		// when
		memberService.join(member1);
		IllegalStateException e = assertThrows(IllegalStateException.class, () -> memberService.join(member2));

		assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
		// then

	}

	@Test
	public void testFindMembers() {

	}

	@Test
	public void testFindOne() {

	}

}
