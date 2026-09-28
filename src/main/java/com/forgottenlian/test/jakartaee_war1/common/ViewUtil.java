package com.forgottenlian.test.jakartaee_war1.common;

import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;

public class ViewUtil {

    public static void error(String summary, Object... params) {
        FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage(FacesMessage.SEVERITY_ERROR, summary.formatted(params), null));
    }

    public static void error_with_detail(String summary, String detail) {
        FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage(FacesMessage.SEVERITY_ERROR, summary, detail));
    }

    public static void warn(String clientId, String summary, Object... params) {
        FacesContext.getCurrentInstance().addMessage(clientId,
                new FacesMessage(FacesMessage.SEVERITY_WARN, summary.formatted(params), null));
    }

}
