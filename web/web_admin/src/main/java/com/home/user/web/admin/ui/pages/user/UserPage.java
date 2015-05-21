package com.home.user.web.admin.ui.pages.user;

import com.home.user.web.admin.ui.pages.user.helper.UserPageHelper;
import com.home.user.web.admin.ui.pages.user.model.UserPageModel;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.PasswordTextField;
import org.apache.wicket.markup.html.form.RequiredTextField;
import org.apache.wicket.spring.injection.annot.SpringBean;

/**
 * Created: Nadya Dainelyan
 * DATE:    5/16/15
 * TIME:    12:14 AM
 */
public class UserPage extends WebPage {

    private static final long serialVersionUID = 1091140132373428576L;

    /* dependencies*/
    @SpringBean
    private UserPageHelper userPageHelper;

    public UserPage() {
        add(new RegistrationForm("registrationForm"));
    }

    public final class RegistrationForm extends Form<Void> {

        public RegistrationForm(final String id) {
            super(id);
            UserPageModel userPageModel = new UserPageModel();
            final RequiredTextField<String> username = new RequiredTextField<String>("userName");
            final PasswordTextField password = new PasswordTextField("password");
            final RequiredTextField<String> firstName = new RequiredTextField<String>("firstName");
            final RequiredTextField<String> secondName = new RequiredTextField<String>("secondName");
            userPageModel.setName(username.getInput());
            userPageModel.setFirstName(firstName.getInput());
            userPageModel.setSecondName(secondName.getInput());
            userPageModel.setPassword(password.getInput());

            Form loginForm = new Form("loginForm") {
                @Override
                protected void onSubmit() {


                }
            };


            loginForm.add(username);
            loginForm.add(password);
            loginForm.add(firstName);
            loginForm.add(secondName);


            add(loginForm);
        }
    }

}
