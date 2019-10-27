package config;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletRegistration;

//Webinitializer实现WebApplicationInitializer这个类的Onstartup方法，可以看做是Web.xml的替代
//它是一个接口，在其中可以添加Servlet，Listener等
//在加载Web项目的时候会加载WebApplicationInitializer接口实现类，并调用onStartup()方法
public class WebInitializer implements WebApplicationInitializer {

    //通过实现WebApplicationInitializer的onStartup()方法,来初始化Spring和DispatchServlet的上下文
    //该方法可以获取到servletContext
    public void onStartup(ServletContext container) {
        //创建根容器(Spring的上下文)
        AnnotationConfigWebApplicationContext rootContext = new AnnotationConfigWebApplicationContext();
        rootContext.register(SpringConfig.class);

        //添加监听器,管理根容器的生命周期
        container.addListener(new ContextLoaderListener(rootContext));

        //创建DispatchServlet的上下文
        AnnotationConfigWebApplicationContext dispatcherContext = new AnnotationConfigWebApplicationContext();
        dispatcherContext.register(SpringMVCConfig.class);

        //注册和映射DispatchServlet
        ServletRegistration.Dynamic dispatcher = container.addServlet("dispatcher", new DispatcherServlet(dispatcherContext));
        dispatcher.addMapping("/");
        dispatcher.setLoadOnStartup(1);
    }
}
