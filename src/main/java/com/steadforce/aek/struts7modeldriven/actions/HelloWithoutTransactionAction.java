package com.steadforce.aek.struts7modeldriven.actions;

import org.apache.struts2.ActionSupport;
import org.apache.struts2.ModelDriven;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.interceptor.parameter.StrutsParameter;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@Action(value = "hello2",
        results = {
                @Result(name = ActionSupport.SUCCESS, location = "hello2.jsp"),
        })
public class HelloWithoutTransactionAction extends ActionSupport implements ModelDriven<HelloModel> {

    private HelloModel model = new HelloModel();

    @Override
    @StrutsParameter(depth = 1)
    public HelloModel getModel() {
        return model;
    }

    @Override
    public String execute() throws Exception {
        return SUCCESS;
    }
}
