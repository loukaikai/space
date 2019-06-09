package com.lkk.test.proxy;

import java.lang.reflect.Constructor;
import java.lang.reflect.Executable;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyTest {
	public static void main(String[] args) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
//		Class clazz = Proxy.getProxyClass(ProxyInface.class.getClassLoader(), ProxyInface.class);
		/*System.out.println(clazz.getName());
		Constructor[] constructors = clazz.getConstructors();
		System.out.println("******************构造器***********************************");
		ArrayName(constructors);
		System.out.println("******************构造器***********************************");
		Method[] methods = clazz.getMethods();
		System.out.println("******************方法***********************************");
		ArrayName(methods);
		System.out.println("******************方法***********************************");*/
		TargetClass tartget = new TargetClass();
		//传入目标对象
        //目的：1.根据它实现的接口生成代理对象 2.代理对象调用目标对象方法
		ProxyInface targetclass = (ProxyInface) getProxy(tartget);
		targetclass.proxyfunA(1, 1);
		
		ProxyInface targetclassa = (ProxyInface)getProxyTwo(tartget);
		targetclassa.proxyfunA(1, 1);
//		targetclassa.tagerFun();
		 
		
//		new TargetClass().tagerFun();
		 
	}
	
	public static Object getProxy(final Object target) throws NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Class targetClazz = Proxy.getProxyClass(target.getClass().getClassLoader(), target.getClass().getInterfaces());
		Constructor constructor = targetClazz.getConstructor(InvocationHandler.class);
		Object object = constructor.newInstance(new InvocationHandler() {

			@Override
			public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
				System.out.println("*********************调用"+method.getName()+"开始*************************");
				Object Result = method.invoke(target, args);
				System.out.println("*********************调用"+method.getName()+"结束*******************************");
				return Result;
			}
			
		});
		return object;
	}
	
	
	public static Object getProxyTwo(final Object target) throws NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), new InvocationHandler() {
			
			@Override
			public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
				System.out.println("*********************调用"+method.getName()+"开始*************************");
				Object Result = method.invoke(target, args);
				System.out.println("*********************调用"+method.getName()+"结束*******************************");
				return Result;
			}
		});
		 
	}
	
	
	public static void ArrayName(Executable[] targets) {
		for(Executable target:targets) {
			System.out.println(target.getName());
		}
	}

}
