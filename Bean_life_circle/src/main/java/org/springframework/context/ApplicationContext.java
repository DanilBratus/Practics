package org.springframework.context;

import org.springframework.bean.factory.BeanFactory;
import org.springframework.bean.factory.config.CustomPostProcessor;
import org.springframework.context.event.ContextClosedEvent;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public class ApplicationContext {
    private BeanFactory beanFactory = new BeanFactory();

    public ApplicationContext() {
        beanFactory.instantiate();
        beanFactory.populateProperties();
        beanFactory.injectBeanName();
        beanFactory.injectBeanFactory();
        beanFactory.addPostProcessor(new CustomPostProcessor());
        beanFactory.initializeBean();
    }

    public ApplicationContext(String basePackage) {
        beanFactory.instantiate(basePackage);
        beanFactory.populateProperties();
        beanFactory.injectBeanName();
        beanFactory.injectBeanFactory();
        beanFactory.addPostProcessor(new CustomPostProcessor());
        beanFactory.initializeBean();
    }

    public void close() {
        beanFactory.close();
        for (Object bean : beanFactory.getSingletons().values()) {
            if (bean instanceof ApplicationListener) {
                for (Type interfacesWithGenerics : bean.getClass().getGenericInterfaces()) {
                    if (interfacesWithGenerics instanceof ParameterizedType) {
                        ParameterizedType parameterizedType = (ParameterizedType) interfacesWithGenerics;
                        Type firstGenericParameterType = parameterizedType.getActualTypeArguments()[0];
                        if (firstGenericParameterType.equals(ContextClosedEvent.class)) {
                            try {
                                Method method = bean.getClass().getMethod("onApplicationEvent", ContextClosedEvent.class);
                                method.invoke(bean, new ContextClosedEvent());
                            } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
            }
        }
    }
}
