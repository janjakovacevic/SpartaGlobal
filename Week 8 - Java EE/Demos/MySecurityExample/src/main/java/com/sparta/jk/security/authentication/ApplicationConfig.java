package com.sparta.jk.security.authentication;

// configuring via annotations

//import javax.security.enterprise.identitystore.DatabaseIdentityStoreDefinition;
//@DatabaseIdentityStoreDefinition() // query the db using SQL statements


import javax.enterprise.context.ApplicationScoped;
import javax.faces.annotation.FacesConfig;
import javax.security.enterprise.authentication.mechanism.http.CustomFormAuthenticationMechanismDefinition;
import javax.security.enterprise.authentication.mechanism.http.LoginToContinue;

@CustomFormAuthenticationMechanismDefinition(
        loginToContinue = @LoginToContinue(
                // this overrides the welcome list
                loginPage = "/login.xhtml",
                errorPage = "", //if login incorrect, send you to another page (could be error page)
                useForwardToLogin = false //makes you stay on login page
        )
)
@FacesConfig
@ApplicationScoped
public class ApplicationConfig {}