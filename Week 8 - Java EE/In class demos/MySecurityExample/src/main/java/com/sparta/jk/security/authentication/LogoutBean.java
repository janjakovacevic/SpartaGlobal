package com.sparta.jk.security.authentication;

import com.sparta.jk.security.entity.User;

import javax.enterprise.context.RequestScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Named
@RequestScoped
public class LogoutBean {

    @Inject
    User user;

    @Inject
    ExternalContext externalContext;

    @Inject
    FacesContext facesContext;

    public String logout() throws ServletException {
//        ((HttpSession) facesContext.getCurrentInstance()
//                .getExternalContext().getSession(false)).invalidate();
//        return "login";
//        ((HttpServletRequest) externalContext.getRequest()).logout();
        facesContext.getCurrentInstance().getExternalContext().invalidateSession();
        return "/login.xhtml?faces-redirect=true";
    }

}

