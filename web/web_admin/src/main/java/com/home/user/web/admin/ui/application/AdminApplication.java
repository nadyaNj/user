package com.home.user.web.admin.ui.application;

import com.home.user.web.admin.ui.pages.user.UserPage;
import org.apache.wicket.Page;
import org.apache.wicket.devutils.stateless.StatelessChecker;
import org.apache.wicket.protocol.http.WebApplication;
import org.apache.wicket.spring.injection.annot.SpringComponentInjector;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

/**
 * Created: Nadya Dainelyan
 * DATE:    5/16/15
 * TIME:    12:10 AM
 */
public class AdminApplication extends WebApplication {

    @Autowired
    private ApplicationContext ctx;


    @Override
    protected void init() {
        super.init();


        if (ctx != null) {
            getComponentInstantiationListeners().add(new SpringComponentInjector(this, ctx, true));
        } else {
            getComponentInstantiationListeners().add(new SpringComponentInjector(this));
        }

        getMarkupSettings().setStripWicketTags(true);
        getMarkupSettings().setDefaultMarkupEncoding("UTF-8");

        getDebugSettings().setAjaxDebugModeEnabled(false);
        getRequestCycleSettings().setResponseRequestEncoding("UTF-8");
        getComponentPostOnBeforeRenderListeners().add(new StatelessChecker());

        // getExceptionSettings().setUnexpectedExceptionDisplay(ExceptionSettings.SHOW_INTERNAL_ERROR_PAGE);


        /*mount pages*/
        mountPages();
    }


    @Override
    public Class<? extends Page> getHomePage() {
        return UserPage.class;
    }


    /**
     * Mount pages
     */
    private void mountPages() {
        /*User page*/
        mountPage("/user", UserPage.class);
    }
}
