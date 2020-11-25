package com.sparta.jk.security.authentication;


import com.sparta.jk.security.entity.User;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.security.enterprise.AuthenticationStatus;
import javax.security.enterprise.SecurityContext;
import javax.security.enterprise.authentication.mechanism.http.AuthenticationParameters;
import javax.security.enterprise.credential.UsernamePasswordCredential;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Named
@RequestScoped
public class LoginBean {
    @Inject
    User user;

    // something that links us to security api
    @Inject
    SecurityContext securityContext;

    // control (roles and which pages they go to)
    @Inject
    ExternalContext externalContext;

    @Inject
    FacesContext facesContext;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void submit() throws IOException {
        switch(continueAuthentication()){
            case SEND_CONTINUE:
                facesContext.responseComplete();
                break;
            case SEND_FAILURE:
                facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Login unsuccessful", null));
                break;
            case SUCCESS:
                externalContext.redirect(externalContext.getRequestContextPath() + "/views/welcome.xhtml"); //throws exception, should be try/catch
                break;
        }
    }

    // checks whether login info is valid or not
    private AuthenticationStatus continueAuthentication() {
        return securityContext.authenticate(
                (HttpServletRequest) externalContext.getRequest(),
                (HttpServletResponse) externalContext.getResponse(),
                AuthenticationParameters.withParams()
                        .credential(new UsernamePasswordCredential(user.getUsername(), user.getPassword()))
        );
    }

}
