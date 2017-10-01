package com.epam.university.java.project.core.cdi.bean;

import java.util.HashMap;
import java.util.Map;

public class BeanDefinitionRegistryImpl implements BeanDefinitionRegistry {
    private Map<String, BeanDefinition> map = new HashMap<>();

    @Override
    public void addBeanDefinition(BeanDefinition definition) {
        map.put(definition.getId(), definition);
    }

    @Override
    public BeanDefinition getBeanDefinition(String beanId) {
        return map.get(beanId);
    }
}
