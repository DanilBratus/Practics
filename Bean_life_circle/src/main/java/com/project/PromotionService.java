package com.project;

import org.springframework.bean.factory.*;
import org.springframework.bean.factory.stereotype.Component;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextClosedEvent;

@Component
public class PromotionService implements BeanNameAware, BeanFactoryAware, InitializingBean, DisposableBean, ApplicationListener<ContextClosedEvent> {
    private String beanName;
    private BeanFactory beanFactory;

    @Override
    public void setBeanName(String name) {
        this.beanName = name;
    }

    public String getBeanName() {
        return beanName;
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) {
        this.beanFactory = beanFactory;
    }

    public BeanFactory getBeanFactory() {
        return beanFactory;
    }

    @Override
    public void afterPropertiesSet() {
    }

    @Override
    public void destroy() {
    }

    @Override
    public void onApplicationEvent(ContextClosedEvent event) {
        event.startContextClosed();
    }
}
