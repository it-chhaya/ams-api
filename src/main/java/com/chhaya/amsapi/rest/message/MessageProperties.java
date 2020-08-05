package com.chhaya.amsapi.rest.message;

import java.util.Locale;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.stereotype.Component;

@Component
public class MessageProperties {
    
    @Autowired
    private MessageSource source;

    private MessageSourceAccessor accessor;

    @PostConstruct
    private void init() {
        accessor = new MessageSourceAccessor(source, Locale.ENGLISH);
    }

    public String selected(String resourceName) {
        return accessor.getMessage("message.select",
            new Object[] {resourceName},
            Locale.ENGLISH);
    }

    public String selectedOne(String resourceName) {
        return accessor.getMessage("message.select-by",
            new Object[] {resourceName});
    }

    public String inserted(String resourceName) {
        return accessor.getMessage("message.inserted",
            new Object[] {resourceName});
    }


}