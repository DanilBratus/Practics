package org.springframework.bean.factory;

import org.springframework.bean.factory.annotation.Autowired;
import org.springframework.bean.factory.annotation.Resource;
import org.springframework.bean.factory.config.BeanPostProcessor;
import org.springframework.bean.factory.stereotype.Component;
import org.springframework.bean.factory.stereotype.Service;
import org.springframework.context.ComponentScan;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.*;

public class BeanFactory {
    private Map<String, Object> singletons = new HashMap<>();
    private List<BeanPostProcessor> postProcessors = new ArrayList<>();

    public Object getBean(String nameBean) {
        return singletons.get(nameBean);
    }

    public Map<String, Object> getSingletons() {
        return singletons;
    }

    public void instantiate() {
        ClassLoader classLoader = ClassLoader.getSystemClassLoader();
        for (Package definedPackage : classLoader.getDefinedPackages()) {
            String namePackage = definedPackage.getName();
            String path = namePackage.replace(".", "/");
            try {
                Enumeration<URL> resources = classLoader.getResources(path);
                while (resources.hasMoreElements()) {
                    URL resource = resources.nextElement();
                    File file = new File(resource.toURI());
                    for (File classFile : file.listFiles()) {
                        String fileName = classFile.getName();
                        if (fileName.endsWith(".class")) {
                            String className = fileName.substring(0, fileName.lastIndexOf("."));
                            Class classObject = Class.forName(namePackage + "." + className);
                            if (classObject.isAnnotationPresent(ComponentScan.class)) {
                                classObject.getDeclaredAnnotationsByType(ComponentScan.class);
                                classObject.getName();
                                classObject.getAnnotatedInterfaces();
                            }
                        }
                    }
                }
            } catch (IOException | URISyntaxException | ClassNotFoundException e) {
                e.printStackTrace();
            }

        }
//        instantiate(basePackage);
    }
    public void instantiate(String basePackage) {
        System.out.println("--info-- Начало создания бина: 'Instantiate'");
        ClassLoader classLoader = ClassLoader.getSystemClassLoader();
        String path = basePackage.replace(".", "/");

        try {
            System.out.println("--info-Instantiate-- Получение списка классов по переданному адресу: '" + basePackage + "'");
            Enumeration<URL> resources = classLoader.getResources(path);

            while (resources.hasMoreElements()) {
                URL resource = resources.nextElement();
                File file = new File(resource.toURI());
                for (File classFile : file.listFiles()) {
                    String fileName = classFile.getName();
                    if (fileName.endsWith(".class")) {
                        String className = fileName.substring(0, fileName.lastIndexOf("."));
                        Class classObject = Class.forName(basePackage + "." + className);           // Получили bite-code класса
                        System.out.println("--info-Instantiate-- Проверка класса '" + className + "' на наличие анотаций 'Component'/'Service'");
                        if (classObject.isAnnotationPresent(Component.class)
                                || classObject.isAnnotationPresent(Service.class)) {                // Проверка на аннотацию Component/Service
                            System.out.println("--info-Instantiate-- Создание бина: '" + className + "'");
                            Object instance = classObject.newInstance();                            // Создание объекта класса
                            String beanName = className.substring(0, 1).toLowerCase() +
                                    className.substring(1);                                         // Задаем имя бину
                            System.out.println("--info-Instantiate-- Добавление бина в контейнер 'BeanFactory'");
                            singletons.put(beanName, instance);                                     // Добавляем бин в контейнер FactoryBean
                        }
                    }
                }
            }
        } catch (URISyntaxException | ClassNotFoundException | InstantiationException | IllegalAccessException | IOException e) {
                e.printStackTrace();
        }
        System.out.println("--info-- Конец создания бина: 'Instantiate'\n");
    }

    public void populateProperties() {
        System.out.println("--info-- Начало внедрения зависимостей: 'Populate Properties'");
        for (Object bean : singletons.values()) {
            for (Field beanField : bean.getClass().getDeclaredFields()) {
                System.out.println("--info-Populate Properties-- Проверка поля: '" + beanField.getName() + "', бина: '" + bean.getClass().getName().substring(bean.getClass().getName().lastIndexOf(".") + 1) + "' на наличие анотации 'Autowired'");
                if (beanField.isAnnotationPresent(Autowired.class)) {
                    for (Object dependency : singletons.values()) {
                        if (dependency.getClass().equals(beanField.getType())) {
                            String setterMethodName = "set" +
                                            beanField.getName().substring(0, 1).toUpperCase() +
                                            beanField.getName().substring(1);
                            try {
                                Method setterMethod = bean.getClass().getMethod(setterMethodName, dependency.getClass());
                                System.out.println("--info-Populate Properties-- Выполнение внедрения зависимости");
                                setterMethod.invoke(bean, dependency);
                            } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
                System.out.println("--info-Populate Properties-- Проверка поля: '" + beanField.getName() + "', бина: '" + bean.getClass().getName().substring(bean.getClass().getName().lastIndexOf(".") + 1) + "' на наличие анотации 'Resource'");
                if (beanField.isAnnotationPresent(Resource.class)) {
                    for (Object dependency : singletons.values()) {
                        if (dependency.getClass().getName().endsWith(beanField.getName().substring(0, 1).toUpperCase() + beanField.getName().substring(1))) {
                            String setterMethodName = "set" +
                                    beanField.getName().substring(0, 1).toUpperCase() +
                                    beanField.getName().substring(1);
                            try {
                                Method setterMethod = bean.getClass().getMethod(setterMethodName, dependency.getClass());
                                System.out.println("--info-Populate Properties-- Выполнение внедрения зависимости");
                                setterMethod.invoke(bean, dependency);
                            } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
            }
        }
        System.out.println("--info-- Окончание внедрения зависимостей: 'Populate Properties'\n");
    }

    public void injectBeanName() {
        System.out.println("--info-- Добовление бину имени: 'Awareness BeanNameAware'\n");
        for (String nameBean : singletons.keySet()) {
            Object bean = singletons.get(nameBean);
            if (bean instanceof BeanNameAware) {
                ((BeanNameAware) bean).setBeanName(nameBean);
            }
        }
    }

    public void injectBeanFactory() {
        System.out.println("--info-- Добовление бину ссылки на контейнер: 'Awareness BeanFactoryAware'\n");
        for (Object bean : singletons.values()) {
            if (bean instanceof BeanFactoryAware) {
                ((BeanFactoryAware) bean).setBeanFactory(this);
            }
        }
    }

    public void initializeBean() {
        System.out.println("--info-- Начало инициализации бина: 'InitializingBean'");
        for (String nameBean : singletons.keySet()) {
            Object bean = singletons.get(nameBean);

            if (!postProcessors.isEmpty()) {
                for (BeanPostProcessor postProcessor : postProcessors) {
                    System.out.println("--info-BeanPostProcessor-Before-- Выполнение прединициализации бина");
                    postProcessor.postProcessBeforeInitialization(bean, nameBean);
                }
                for (Method method : bean.getClass().getDeclaredMethods()) {
                    if (method.isAnnotationPresent(PostConstruct.class)) {
                        System.out.println("--info-PostConstruct-- Выполнение прединициализации бина");
                        try {
                            method.invoke(bean, method.getParameters());
                        } catch (IllegalAccessException | InvocationTargetException e) {
                            e.printStackTrace();
                        }
                    }
                }

                if (bean instanceof InitializingBean) {
                    System.out.println("--info-InitializingBean-- Выполнение инициализации бина");
                    ((InitializingBean) bean).afterPropertiesSet();
                }
                for (BeanPostProcessor postProcessor : postProcessors) {
                    System.out.println("--info-BeanPostProcessor-After-- Выполнение постинициализации бина");
                    postProcessor.postProcessAfterInitialization(bean, nameBean);
                }
            } else {
                for (Method method : bean.getClass().getDeclaredMethods()) {
                    if (method.isAnnotationPresent(PostConstruct.class)) {
                        System.out.println("--info-PostConstruct-- Выполнение прединициализации бина");
                        try {
                            method.invoke(bean, method.getParameters());
                        } catch (IllegalAccessException | InvocationTargetException e) {
                            e.printStackTrace();
                        }
                    }
                }
                if (bean instanceof InitializingBean) {
                    System.out.println("--info-InitializingBean-- Выполнение инициализации бина");
                    ((InitializingBean) bean).afterPropertiesSet();
                }
            }
        }
        System.out.println("--info-- Окончание инициализации бина: 'InitializingBean'\n");
    }

    public void close() {
        for (String beanName : singletons.keySet()) {
            System.out.println("--info-- Начало удаление бина: " + beanName);
            Object bean = singletons.get(beanName);
            for (Method method : bean.getClass().getDeclaredMethods()) {
                if (method.isAnnotationPresent(PreDestroy.class)) {
                    System.out.println("--info-PreDestroy-- Выполнение метода перед удалением бина: " + beanName);
                    try {
                        method.invoke(bean);
                    } catch (IllegalAccessException | InvocationTargetException e) {
                        e.printStackTrace();
                    }
                }
            }

            if (bean instanceof DisposableBean) {
                try {
                    Method destroy = bean.getClass().getDeclaredMethod("destroy");
                    System.out.println("--info-DisposableBean.destroy()-- Выполнение предудаления бина: " + beanName);
                    destroy.invoke(bean, destroy.getParameters());
                } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("--info-- Завершение удаление бина: " + beanName + "\n");
            singletons.remove(bean);
        }

    }

    public void addPostProcessor(BeanPostProcessor postProcessor) {
        postProcessors.add(postProcessor);
    }
}
