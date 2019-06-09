package com.lkk.test.proxy;

public class TargetClass implements ProxyInface,OtherInface {
	
	public String tagerFun() {
		System.out.println("tager methof");
		return "tager methof";	
		
	}

	@Override
	public String proxyfunA(int i,int j) {
		System.out.println("代理方法A 执行中");
		return "代理方法A 执行完成";

	}

	@Override
	public String proxyfunB() {
		System.out.println("代理方法B 执行中");
		return "代理方法B 执行完成";

	}

	@Override
	public String proxyfunC() {
		System.out.println("代理方法C 执行中");
		return "代理方法C 执行完成";

	}

	@Override
	public void otherfunc() {
		System.out.println("*************otherfun*************");
		
	}

}
