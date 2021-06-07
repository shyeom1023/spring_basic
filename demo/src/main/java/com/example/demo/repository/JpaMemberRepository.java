package com.example.demo.repository;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;

import com.example.demo.domain.Member;

public class JpaMemberRepository implements MemberRepository {

	private final EntityManager em;

	public JpaMemberRepository(EntityManager em) {
		super();
		this.em = em;
	}

	@Override
	public Member save(Member member) {
		// TODO Auto-generated method stub
		em.persist(member);
		return member;
	}

	@Override
	public Optional<Member> findById(Long id) {
		// TODO Auto-generated method stub
		Member findMember = em.find(Member.class, id);
		return Optional.ofNullable(findMember);
	}

	@Override
	public List<Member> findAll() {
		// TODO Auto-generated method stub
		List<Member> resultList = em.createQuery("select m from Member as m", Member.class).getResultList();
		return resultList;
	}

	@Override
	public Optional<Member> findByName(String name) {
		List<Member> resultList = em.createQuery("select m from Member m where m.name = :name", Member.class)
				.setParameter("name", name).getResultList();

		return resultList.stream().findAny();
	}

}
