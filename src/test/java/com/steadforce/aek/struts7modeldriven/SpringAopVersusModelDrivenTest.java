package com.steadforce.aek.struts7modeldriven;

import com.steadforce.aek.struts7modeldriven.actions.HelloAction;
import org.apache.struts2.interceptor.parameter.ParametersInterceptor;
import org.apache.struts2.interceptor.parameter.StrutsParameter;
import org.junit.jupiter.api.Test;
import org.springframework.aop.support.AopUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.beans.PropertyDescriptor;

@SpringBootTest
class SpringAopVersusModelDrivenTest {

    @Autowired
    HelloAction helloAction;

    /**
     * @see ParametersInterceptor#hasValidAnnotatedPropertyDescriptor(Object, PropertyDescriptor, long)
     */
    @Test
    void findAnnotationStrutsParameterOnSpringObject() throws Exception {
        var clazz = helloAction.getClass();

        var method = clazz.getMethod("getModel");
        var lookedForAnnotation = method.getAnnotation(StrutsParameter.class);
        assert lookedForAnnotation != null; // this will fail
    }

    @Test
    void findAnnotationStrutsParameterOnRealClass() throws Exception {
        var clazz = AopUtils.getTargetClass(helloAction);

        var method = clazz.getMethod("getModel");
        var lookedForAnnotation = method.getAnnotation(StrutsParameter.class);
        assert lookedForAnnotation != null; // this works
    }

}
