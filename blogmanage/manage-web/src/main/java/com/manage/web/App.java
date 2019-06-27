package com.manage.web;

import org.aopalliance.aop.Advice;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.poi.hssf.util.HSSFColor.GOLD;
import org.aspectj.lang.reflect.Pointcut;
import org.springframework.aop.BeforeAdvice;
import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.aop.framework.DefaultAdvisorChainFactory;
import org.springframework.aop.framework.ReflectiveMethodInvocation;
import org.springframework.aop.framework.adapter.DefaultAdvisorAdapterRegistry;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.aop.support.ExpressionPointcut;
import org.springframework.aop.support.JdkRegexpMethodPointcut;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionReader;
import org.springframework.context.support.AbstractRefreshableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;
import org.springframework.web.context.ContextLoaderListener;

/**
 * Hello world!
 *
 */
@Service
public class App 
{
	
    public String aoptest() {
//    	FileSystemXmlApplicationContext
//    	AbstractApplicationContext
//    	AbstractRefreshableApplicationContext
//    	AbstractXmlApplicationContext
//    	DefaultResourceLoader
//    	AbstractBeanDefinitionReader
//    	BeanDefinitionReader
//    	AbstractApplicationContextAwareProcessor
//    	AbstractAutowireCapableBeanFactory
//    	ClassPathXmlApplicationContext
//    	FactoryBean
//    	BeanPostProcessor
//    	BeanFactory
//    	BeanUtils
//    	DisposableBeanAdapter
//    	ReflectionUtils.makeAccessible(ctor);
//    	ReflectiveMethodInvocation
//    	AdvisedSupport
//    	DefaultAdvisorChainFactory
//    	ProxyFactoryBean
//    	GlobalAdvisorAdapterRegistry
//    	DefaultAdvisorAdapterRegistry
    	
//    	ContextLoaderListener
//    	ServletContextListener
    	
//    	HashMap.
    	
//    	Advice
//    	BeforeAdvice
//    	MethodBeforeAdvice
//    	CountingBeforeAdvice
//    	MethodCount
//    	Pointcut
//    	ExpressionPointcut
//    	JdkRegexpMethodPointcut
//    	DefaultPointcutAdvisor
//    	MethodMatcher
//    	ClassFilter
    	System.out.println("sssss");
    	return "aop test";
    }
}
