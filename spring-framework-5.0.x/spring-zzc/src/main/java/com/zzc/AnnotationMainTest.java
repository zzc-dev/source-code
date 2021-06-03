package com.zzc;

import com.zzc.config.AnnotationConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationMainTest {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AnnotationConfig.class);
//		context.publishEvent(new ApplicationEvent("11") {
//			@Override
//			public Object getSource() {
//				return super.getSource();
//			}
//		});
//		System.out.println(context.getBean("user1"));
		context.close();
	}

	public static void processor(){
		/**
		 *  后置处理器
		 *  BeanDefinitionHodler
		 *  BeanDefinitionRegister --> DefaultListableBeanFactory(spring真正存储bean的容器)
		 *                                  Map<String, BeanDefinition> beanDefinitionMap
		 *                                  List<String> beanDefinitionNames
		 *                                  List<BeanPostProcessor> beanPostProcessors 后置处理器 默认添加了ApplicationContextAwareProcessor
		 *  DefaultSingletonBeanRegistry
		 *        Map<String, Object> singletonObjects 实例化的单例bean
		 *
		 *  所有的注册逻辑最终执行到DefaultListableBeanFactory   registerBeanDefinition(String beanName, BeanDefinition beanDefinition)
		 *
		 *
		 *
		 *
		 * */

		/**
		 * BeanFactoryPostProcessor
		 * 		  postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory)
		 * BeanDefinitionRegistryPostProcessor extends	BeanFactoryPostProcessor
		 *        postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry)
		 *
		 * */

		/**  事件监听
		 * SimpleApplicationEventMulticaster  事件多播器
		 * refresh()
		 *   initApplicationEventMulticaster() 初始化事件多播器SimpleApplicationEventMulticaster
		 *   registerListeners() 扫描实现ApplicationListener接口的bean将其注册到容器中
		 *   finishRefresh()
		 *          publishEvent(new ContextRefreshedEvent(this)); 刷新事件
		 *
		 * 使用@EventListener(classes = {ApplicationEvent.class})注解方式实现事件监听
		 * @EventListener 该注解会被 EventListenerMethodProcessor implements SmartInitializingSingleton 扫描
		 *    1.register(annotatedClasses);  容器中已经注入 org.springframework.context.event.internalEventListenerProcessor  【SmartInitializingSingleton】
		 *    2.finishBeanFactoryInitialization -> beanFactory.preInstantiateSingletons();
		 *       2.1 实例化所有的bean包括【1】中的SmartInitializingSingleton
		 *       2.2 遍历bean看是否有 SmartInitializingSingleton的子类，如果有调用他的 afterSingletonsInstantiated
		 *           afterSingletonsInstantiated()往容器中添加一个 ApplicationListener 监听器，
		 *    3.在发布事件时调用监听事件的方法
		 * */
	}
}
