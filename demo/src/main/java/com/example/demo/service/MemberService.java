package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.transaction.annotation.Transactional;

import com.example.demo.domain.Member;
import com.example.demo.repository.MemberRepository;

@Transactional
public class MemberService {

	private final MemberRepository memberRepository;

	public MemberService(MemberRepository memberRepository) {
		super();
		this.memberRepository = memberRepository;
	}

	/**
	 * ȸ�� ���� ���� �̸��� �ִ� �ߺ� ȸ��x
	 * 
	 * @param member
	 * @return
	 */
	public Long join(Member member) {

		validateDuplicateMember(member);
		memberRepository.save(member);

		return member.getId();

	}

	private void validateDuplicateMember(Member member) {
		Optional<Member> result = memberRepository.findByString(member.getName());

		result.ifPresent(m -> {
			throw new IllegalStateException("�̹� �����ϴ� ȸ���Դϴ�.");
		});
	}

	/**
	 * ��ü ȸ�� ��ȸ
	 * 
	 * @return
	 */
	public List<Member> findMembers() {

		List<Member> result = memberRepository.findAll();

		return result;
	}

	/**
	 * �Ѹ��� ȸ�� ��ȸ
	 * 
	 * @param memberId
	 * @return
	 */
	public Optional<Member> findOne(Long memberId) {
		Optional<Member> result = memberRepository.findById(memberId);

		return result;
	}

}
