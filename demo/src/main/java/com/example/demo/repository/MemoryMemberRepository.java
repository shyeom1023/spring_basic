package com.example.demo.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.example.demo.domain.Member;

public class MemoryMemberRepository implements MemberRepository {

	private static Map<Long, Member> store = new HashMap<>();
	private static long sequence = 0L;
	
	@Override
	public Member save(Member member) {
		// TODO Auto-generated method stub
		member.setId(++sequence);
		store.put(member.getId(), member);
		return member;
	}

	@Override
	public Optional<Member> findById(Long id) {
		// TODO Auto-generated method stub
		 Optional<Member> ofNullable = Optional.ofNullable(store.get(id));
		return ofNullable;
	}

	@Override
	public Optional<Member> findByString(String name) {
		// TODO Auto-generated method stub
		Optional<Member> findAny = store.values().stream()
			.filter(member -> member.getName().equals(name))
			.findAny();
		return findAny;
	}

	@Override
	public List<Member> findAll() {
		// TODO Auto-generated method stub
		List<Member> arrayList = new ArrayList<>(store.values());
		return arrayList;
	}
	
	public void clearStore() {
		store.clear();
	}
	

}
