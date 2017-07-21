package com.mertaydar.emw.config;
 
import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.ResourceBundleViewResolver;

import com.mertaydar.emw.service.ActivationDAO;

import com.mertaydar.emw.service.BanDAO;
import com.mertaydar.emw.service.PassactivationDAO;
import com.mertaydar.emw.service.UserDAO;
import com.mertaydar.emw.service.UserRoleDAO;
import com.mertaydar.emw.service.impl.ActivationDAOImpl;
import com.mertaydar.emw.service.impl.BanDAOImpl;
import com.mertaydar.emw.service.impl.PassactivationDAOImpl;
import com.mertaydar.emw.service.impl.UserDAOImpl;
import com.mertaydar.emw.service.impl.UserRoleDAOImpl;

@Configuration
@ComponentScan("com.mertaydar.emw.*")
@EnableTransactionManagement
// Load to Environment.
@PropertySource("classpath:application.properties")
public class ApplicationContextConfig {
 
  // The Environment class serves as the property holder
  // and stores all the properties loaded by the @PropertySource
  @Autowired
  private Environment env;
 
 // @Autowired
//  private UserInfoDAO userInfoDAO;
  // created for validation(will fill)
 /* @Bean
  public ResourceBundleMessageSource messageSource() {
      ResourceBundleMessageSource rb = new ResourceBundleMessageSource();
      // Load property in message/validator.properties
      rb.setBasenames(new String[] { "messages/validator" });
      return rb;
  }*/
  
  @Bean(name = "userDAO")
  public UserDAO getUserDAO() {
      return new UserDAOImpl();
  }
  
  @Bean(name = "userRoleDAO")
  public UserRoleDAO getUserRoleDAO() {
      return new UserRoleDAOImpl();
  }

  @Bean(name = "banDAO")
  public BanDAO getBanDAO() {
      return new BanDAOImpl();
  }
  
  @Bean(name = "ActivationDAO")
  public ActivationDAO getActivationDAO() {
	  return new ActivationDAOImpl();
  }
  
  @Bean(name = "PassactivationDAO")
  public PassactivationDAO getPassactivationDAO() {
	  return new PassactivationDAOImpl();
  }
  
//Bean name must be "multipartResolver", by default Spring uses method name as bean name.
  @Bean
  public MultipartResolver multipartResolver() {
      return new StandardServletMultipartResolver();
  }

	/*
	// if the method name is different, you must define the bean name manually like this :
	@Bean(name = "multipartResolver")
  public MultipartResolver createMultipartResolver() {
      return new StandardServletMultipartResolver();
  }*/
  
  @Bean
  public JavaMailSender javaMailService() {
      JavaMailSenderImpl javaMailSender = new JavaMailSenderImpl();

      javaMailSender.setHost("smtp.gmail.com");
      javaMailSender.setPort(587);
      javaMailSender.setUsername("724system@gmail.com");
      javaMailSender.setPassword("sysprog724");
      
      javaMailSender.setJavaMailProperties(getMailProperties());

      return javaMailSender;
  }
  
  private Properties getMailProperties() {
      Properties properties = new Properties();
      properties.setProperty("mail.transport.protocol", "smtp");
      properties.setProperty("mail.smtp.auth", "false");
      properties.setProperty("mail.smtp.starttls.enable", "true");
      properties.setProperty("mail.debug", "false");
      return properties;
  }
 
  @Bean(name = "resourceViewResolver")
	public ResourceBundleViewResolver getResourceViewResolver() {
	    ResourceBundleViewResolver viewResolver = new ResourceBundleViewResolver();
		viewResolver.setOrder(1);
		viewResolver.setBasename("views");
		return viewResolver;
	}
  
  @Bean(name = "viewResolver")
  public InternalResourceViewResolver getViewResolver() {
      InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
      viewResolver.setPrefix("/WEB-INF/pages/");
      viewResolver.setSuffix(".jsp");
      viewResolver.setOrder(2);
      return viewResolver;
  }
 
  @Bean(name = "dataSource")
  public DataSource getDataSource() {
      DriverManagerDataSource dataSource = new DriverManagerDataSource();
 
      // See: datasouce-cfg.properties
      dataSource.setDriverClassName(env.getProperty("ds.database-driver"));
      dataSource.setUrl(env.getProperty("ds.url"));
      dataSource.setUsername(env.getProperty("ds.username"));
      dataSource.setPassword(env.getProperty("ds.password"));
 
      System.out.println("## getDataSource: " + dataSource);
 
      return dataSource;
  }
  
  @Autowired
  @Bean(name = "sessionFactory")
  public SessionFactory getSessionFactory(DataSource dataSource) throws Exception {
      Properties properties = new Properties();
     
      // See: ds-hibernate-cfg.properties
      properties.put("hibernate.dialect", env.getProperty("hibernate.dialect"));
      properties.put("hibernate.show_sql", env.getProperty("hibernate.show_sql"));
      properties.put("current_session_context_class", env.getProperty("current_session_context_class"));
       
  
      LocalSessionFactoryBean factoryBean = new LocalSessionFactoryBean();
      factoryBean.setPackagesToScan(new String[] { "tr.edu.yildiz.ce.entity" });
      factoryBean.setDataSource(dataSource);
      factoryBean.setHibernateProperties(properties);
      factoryBean.afterPropertiesSet();
      //
      SessionFactory sf = factoryBean.getObject();
      return sf;
  }
  
  @Autowired
  @Bean(name = "transactionManager")
  public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory) {
      HibernateTransactionManager transactionManager = new HibernateTransactionManager(sessionFactory);
  
      return transactionManager;
  }
 
  // Transaction Manager
/*  @Autowired
  @Bean(name = "transactionManager")
  public DataSourceTransactionManager getTransactionManager(DataSource dataSource) {
      DataSourceTransactionManager transactionManager = new DataSourceTransactionManager(dataSource);
 
      return transactionManager;
  }*/
  
}