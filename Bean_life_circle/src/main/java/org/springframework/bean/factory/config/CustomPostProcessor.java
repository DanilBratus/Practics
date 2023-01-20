package org.springframework.bean.factory.config;

public class CustomPostProcessor implements BeanPostProcessor{
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) {
        System.out.println("\t--CustomPostProcessorBefore: " + beanName);
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) {
        System.out.println("\t--CustomPostProcessorAfter: " + beanName);
        return bean;
    }
}
