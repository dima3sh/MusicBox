package org.music.box.external.controller.service;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;

@Component
public class RandomNumberAnnotationBeanPostProcessor implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        Field[] fields = bean.getClass().getDeclaredFields();
        for(Field field :  fields) {
            RandomNumber rnumber = field.getAnnotation(RandomNumber.class);
            if (rnumber != null) {
                try {
                    String s = (String)(Class.forName("java.lang.String")).getDeclaredConstructor(String.class).newInstance("hello");
                    System.out.println(s);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
                int max = rnumber.max();
                int min = rnumber.min();
                field.setAccessible(true);
                ReflectionUtils.setField(field, bean, (int)(Math.random() * (max - min) + min));
            }
        }
        return BeanPostProcessor.super.postProcessBeforeInitialization(bean, beanName);
    }
}
