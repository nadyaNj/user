package com.home.user.web.admin.ui.pages.user;

import com.home.user.web.admin.ui.pages.user.helper.UserPageHelper;
import com.home.user.web.admin.ui.pages.user.model.UserPageModel;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.form.AjaxButton;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.PasswordTextField;
import org.apache.wicket.markup.html.form.RequiredTextField;
import org.apache.wicket.model.PropertyModel;
import org.apache.wicket.spring.injection.annot.SpringBean;

/**
 * Created: Nadya Dainelyan
 * DATE:    5/16/15
 * TIME:    12:14 AM
 */
public class UserPage extends WebPage {

    private static final long serialVersionUID = 1091140132373428576L;


    /*dependencies*/
    @SpringBean
    private UserPageHelper userPageHelper;


    /*Properties*/
    private final UserPageModel pageModel;


    /*Constructor*/
    public UserPage() {
        pageModel = new UserPageModel();

        add(new RegistrationForm("registrationForm"));
    }


    /**
     * Registration form
     */
    private class RegistrationForm extends Form<Void> {

        /*Constructor*/
        public RegistrationForm(final String id) {
            super(id);

            initRegistrationForm();
        }


        /**
         * Initializing registration form
         */
        private void initRegistrationForm() {
            final RequiredTextField<String> username = new RequiredTextField<>("name", new PropertyModel<>(pageModel, "name"));
            add(username);

            final PasswordTextField password = new PasswordTextField("password", new PropertyModel<>(pageModel, "password"));
            add(password);

            final RequiredTextField<String> firstName = new RequiredTextField<>("firstName", new PropertyModel<>(pageModel, "firstName"));
            add(firstName);


            final RequiredTextField<String> secondName = new RequiredTextField<>("secondName", new PropertyModel<>(pageModel, "secondName"));
            add(secondName);

            add(new Save("save", this));
        }


        /**
         * Save button
         */
        private class Save extends AjaxButton {

            /*Constructor*/
            public Save(final String id, final Form<?> form) {
                super(id, form);
            }


            @Override
            protected void onSubmit(final AjaxRequestTarget target, final Form<?> form) {
                userPageHelper.createUser(pageModel);
            }

            @Override
            protected void onAfterSubmit(final AjaxRequestTarget target, final Form<?> form) {

            }

            @Override
            protected void onError(final AjaxRequestTarget target, final Form<?> form) {
                target.add(form);
            }
        }
    }


}
