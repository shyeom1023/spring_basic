package com.example.demo.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class TimeTraceAop {

//	@Around("execution(* com.example.demo..*(..))") //��ü �� ��ȸ
	@Around("execution(* com.example.demo.service..*(..))") //���񽺸� ���� ������
	public Object excute(ProceedingJoinPoint joinPoint) throws Throwable {

		long start = System.currentTimeMillis();
		System.out.println("Start: " + joinPoint.toString());

		try {
			return joinPoint.proceed();
		} finally {
			// TODO: handle finally clause
			long finish = System.currentTimeMillis();
			long timeMs = finish - start;
			System.out.println("End: " + joinPoint.toString() + " " + timeMs + "ms");
		}

	}

}
