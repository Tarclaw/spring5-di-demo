package guru.springframework;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * Created by jt on 6/5/17.
 */
@Component
public class LifeCycleDemoBean implements InitializingBean,  DisposableBean, BeanNameAware, BeanFactoryAware, ApplicationContextAware {


    /**
     * Constructor
     * #1
     */
    public LifeCycleDemoBean() {
        System.out.println("## - 1. LifeCycleBean Constructor worked.");
    }

    /**
     * BeanNameAware
     * #2
     */
    @Override
    public void setBeanName(String name) {
        System.out.println("## - 2. setBeanName(name) method of BeanNameAware in LifeCycleDemoBean worked. " +
                "The setted name is: " + name);
    }

    /**
     * BeanFactoryAware
     * #3
     */
    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("## - 3. setBeanFactory(beanFactory) method of BeanFactoryAware in LifeCycleDemoBean worked. " +
                "We didn't set any beanFactory here.");
    }

    /**
     * ApplicationContextAware
     * #4
     */
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("## - 4. setApplicationContext(applicationContext) method of ApplicationContextAware in LifeCycleDemoBean worked. " +
                "We didn't set any applicationContext here.");
    }

    /**
     * beforeInit()
     * #5
     */
    public void beforeInit(){
        System.out.println("## - 5. beforeInit() method in LifeCycleDemoBean called by Bean Post Processor");
    }

    /**
     * @PostConstruct
     * #6
     */
    @PostConstruct
    public void postConstruct(){
        System.out.println("## - 6. The Post Construct annotated method in LifeCycleDemoBean has been called");
    }

    /**
     * InitializingBean
     * #7
     */
    @Override
    public void afterPropertiesSet() {
        System.out.println("## - 7. afterPropertiesSet() method of InitializingBean in LifeCycleDemoBean worked");
    }

    /**
     * afterInit()
     * #8
     */
    public void afterInit(){
        System.out.println("## - 8. afterInit() method in LifeCycleDemoBean called by Bean Post Processor");
    }

    /**
     * @PreDestroy
     * #9
     */
    @PreDestroy
    public void preDestroy() {
        System.out.println("## - 9. The Predestroy annotated method in LifeCycleDemoBean has been called");
    }

    /**
     * DisposableBean
     * #10
     */
    @Override
    public void destroy() {
        System.out.println("## - 10. destroy() method of DisposableBean in LifeCycleDemoBean worked");
    }
}
