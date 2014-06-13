package jsr168portlet.utils;

import org.springframework.aop.framework.*;
import org.springframework.aop.interceptor.*;
import org.springframework.aop.support.*;

public class AopSample {

	public static void main(String[] args) {
		ProxyFactory factory = new ProxyFactory(new Person());
		factory.setProxyTargetClass(true);

		RegexpMethodPointcutAdvisor advisor = new RegexpMethodPointcutAdvisor();
		advisor.setPattern(".*(get|set).*");
		DebugInterceptor interceptor = new DebugInterceptor();
		advisor.setAdvice(interceptor);

		factory.addAdvisor(advisor);

		Person person = (Person) factory.getProxy();
		person.setAge(100);

		System.out.println(person.getAge());

	}
}

class Person {

	private String name;
	private int age;

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the age
	 */
	public int getAge() {
		return age;
	}

	/**
	 * @param age
	 *            the age to set
	 */
	public void setAge(int age) {
		this.age = age;
	}

}
