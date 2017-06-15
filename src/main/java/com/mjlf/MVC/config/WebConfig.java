package com.mjlf.MVC.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.*;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.*;
import org.thymeleaf.spring4.SpringTemplateEngine;
import org.thymeleaf.spring4.view.ThymeleafViewResolver;
import org.thymeleaf.templateresolver.ServletContextTemplateResolver;

import java.io.IOException;


/**
 * Created by a123 on 17/6/1.
 */

@Configuration
@EnableWebMvc
@EnableAspectJAutoProxy
@EnableScheduling
@ComponentScan("com.mjlf.MVC")
@MapperScan("com.mjlf.MVC")
public class WebConfig extends WebMvcConfigurerAdapter{

//    @Bean
//    public ViewResolver viewResolver(){
//        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
//        resolver.setPrefix("/WEB-INF/views/");
//        resolver.setSuffix(".html");
//        resolver.setExposeContextBeansAsAttributes(true);
//        return resolver;
//    }

    @Bean
    @Description("Thymeleaf Template Resolver")
    public ServletContextTemplateResolver templateResolver() {
        ServletContextTemplateResolver templateResolver = new ServletContextTemplateResolver();
        templateResolver.setPrefix("/WEB-INF/views/");
        templateResolver.setSuffix(".html");
        templateResolver.setTemplateMode("HTML5");

        return templateResolver;
    }

    @Bean
    @Description("Thymeleaf Template Engine")
    public SpringTemplateEngine templateEngine() {
        SpringTemplateEngine templateEngine = new SpringTemplateEngine();
        templateEngine.setTemplateResolver(templateResolver());
        templateEngine.setTemplateEngineMessageSource(messageSource());
        return templateEngine;
    }

    @Bean
    @Description("Thymeleaf View Resolver")
    public ThymeleafViewResolver viewResolver() {
        ThymeleafViewResolver viewResolver = new ThymeleafViewResolver();
        viewResolver.setTemplateEngine(templateEngine());
        viewResolver.setOrder(1);
        return viewResolver;
    }

    @Bean
    @Description("Spring Message Resolver")
    public ResourceBundleMessageSource messageSource() {
        ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
        messageSource.setBasename("messages");
        return messageSource;
    }
    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }


    /**
     * 过滤控制
     * @return
     */
    @Bean MyIntercptor myIntercptor(){
        return new MyIntercptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        super.addInterceptors(registry);
        System.out.println("yes");
        registry.addInterceptor(myIntercptor()).addPathPatterns("/**");
    }

    /* multipart 文件上传 */

    /**
     * StandardServletMultipartResolver 解析器上传文件配置
     * @return
     * @throws IOException
     */

//    @Bean
//    public MultipartResolver multipartResolver() throws IOException{
//        return new StandardServletMultipartResolver();
//    }

    /**
     * commonsMultipartResolver文件上传配置
     * @return
     * @throws IOException
     */
    @Bean
    public MultipartResolver multipartResolver() throws IOException{
        CommonsMultipartResolver commonsMultipartResolver =  new CommonsMultipartResolver();
        commonsMultipartResolver.setUploadTempDir(new FileSystemResource("/tmp/webMVC"));
        return commonsMultipartResolver;
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {

    }

    /**
     *  公共部分解析器
     * @return
     */
    @Bean(name="multipartResolver")
    public CommonsMultipartResolver commonsMultipartResolver(){
        CommonsMultipartResolver common = new CommonsMultipartResolver();
        common.setMaxUploadSize(10 * 1024 * 1024);//10M
        return common;
    }
}
