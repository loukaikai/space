package com.manage.web;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.activation.DataSource;

import org.aopalliance.aop.Advice;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.poi.hssf.util.HSSFColor.GOLD;
import org.aspectj.lang.reflect.Pointcut;
import org.springframework.aop.BeforeAdvice;
import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.aop.framework.DefaultAdvisorChainFactory;
import org.springframework.aop.framework.ReflectiveMethodInvocation;
import org.springframework.aop.framework.adapter.AfterReturningAdviceInterceptor;
import org.springframework.aop.framework.adapter.DefaultAdvisorAdapterRegistry;
import org.springframework.aop.framework.adapter.MethodBeforeAdviceInterceptor;
import org.springframework.aop.framework.adapter.ThrowsAdviceInterceptor;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.aop.support.ExpressionPointcut;
import org.springframework.aop.support.JdkRegexpMethodPointcut;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionReader;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.support.AbstractRefreshableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.jdbc.datasource.DataSourceUtils;
import org.springframework.jdbc.object.RdbmsOperation;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;
import org.springframework.web.context.ContextLoaderListener;

/**
 * Hello world!
 *
 */
class Frob {}
class Fnorkle {}
class Quark<Q> {}
class Particle<POSITION,MOMENTUM> {}
public class App 
{
	
    public String aoptest() {
    	
//    	PointcutAdvisor   
    	//    	JdbcTemplate/
//    	ClassLoader  
//    	AbstractRefreshableApplicationContext 
//    	DefaultListableBeanFactory
//    	AbstractAutowireCapableBeanFactory
//    	XmlBeanDefinitionReader
//    	AbstractBeanDefinitionReader
//    	BeanDefinitionParserDelegate 
//    	DefaultListableBeanFactory
//    	AbstractApplicationContext
//    	AbstractRefreshableApplicationContext
//    	AbstractRefreshableConfigApplicationContext 
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
//    	System.out.println("sssss");
    	return "aop test";
    }
    public static void main(String[] args) {
    	/* List<Frob> list = new ArrayList<Frob>();
 	    Map<Frob,Fnorkle> map = new HashMap<Frob,Fnorkle>();
 	    Quark<Fnorkle> quark = new Quark<Fnorkle>();
 	    Particle<Long,Double> p = new Particle<Long,Double>();
 	    System.out.println(Arrays.toString(
 	      list.getClass().getTypeParameters()));
 	    System.out.println(Arrays.toString(
 	      map.getClass().getTypeParameters()));
 	    System.out.println(Arrays.toString(
 	      quark.getClass().getTypeParameters()));
 	    System.out.println(Arrays.toString(
 	      p.getClass().getTypeParameters()));*/
    	
    	  Solid<Bounded> solid =
    		      new Solid<Bounded>(new Bounded());
    	  System.out.println();
    		    solid.color();
    		    solid.getY();
    		    solid.weight();
	}
}

interface HasColor { java.awt.Color getColor(); }

class Colored<T extends HasColor> {
  T item;
  Colored(T item) { this.item = item; }
  T getItem() { return item; }
  // The bound allows you to call a method:
  java.awt.Color color() { return item.getColor(); }
}

class Dimension { public int x, y, z; }

// This won't work -- class must be first, then interfaces:
// class ColoredDimension<T extends HasColor & Dimension> {
	
// Multiple bounds:
class ColoredDimension<T extends Dimension & HasColor> {
  T item;
  ColoredDimension(T item) { this.item = item; }
  T getItem() { return item; }
  java.awt.Color color() { return item.getColor(); }
  int getX() { return item.x; }
  int getY() { return item.y; }
  int getZ() { return item.z; }
}

interface Weight { int weight(); }	

// As with inheritance, you can have only one
// concrete class but multiple interfaces:
class Solid<T extends Dimension & HasColor & Weight> {
  T item;
  Solid(T item) { this.item = item; }
  T getItem() { return item; }
  java.awt.Color color() { return item.getColor(); }
  int getX() { return item.x; }
  int getY() { return item.y; }
  int getZ() { return item.z; }
  int weight() { return item.weight(); }
}

class Bounded
extends Dimension implements HasColor, Weight {
  public java.awt.Color getColor() { return null; }
  public int weight() { return 0; }
}	

