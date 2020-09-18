package br.com.hilker.config;

import javax.sql.DataSource;

import org.hibernate.dialect.PostgreSQL95Dialect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jndi.JndiObjectFactoryBean;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaDialect;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

// @Configuration
@EnableJpaRepositories(
		entityManagerFactoryRef = "entityManagerPostgres"
)
public class DataSourceConfigPostgres {
	
	@Autowired
	private DataSourceProperties dataSourceProperties;
	
	private static final String PREFIXO_JNDI = "java:comp/env/";
	
	@Primary
	@Bean(name="dataSourcePostgres")
	public DataSource dataSource() {
		try {
			JndiObjectFactoryBean bean = new JndiObjectFactoryBean();
			bean.setJndiName(PREFIXO_JNDI + dataSourceProperties.getPostgre().getJndi());
			bean.setProxyInterface(DataSource.class);
			bean.setLookupOnStartup(false);
			bean.afterPropertiesSet();
			
			return (DataSource) bean.getObject();
		} catch (Exception e) {
			//UtilLog.getLog().error(e.getMessage(), e);
		}
		return null;
	}
	
	@Primary
	@Bean(name="entityManagerPostgres")
	public LocalContainerEntityManagerFactoryBean entityManagerFactory(EntityManagerFactoryBuilder builder, DataSource dataSource) {
		
		LocalContainerEntityManagerFactoryBean factory = builder
				.dataSource(dataSource)
				.persistenceUnit(dataSourceProperties.getPostgre().getPersistenceUnit())
				.packages("br.com.fujioka")
				.build();
		
		factory.setJpaDialect(new HibernateJpaDialect());
		factory.setJpaVendorAdapter(jpaVendorAdapter());
		
		return factory;
	}
	
	private JpaVendorAdapter jpaVendorAdapter() {
		HibernateJpaVendorAdapter bean = new HibernateJpaVendorAdapter();
		bean.setDatabase(Database.POSTGRESQL);
		bean.setDatabasePlatform(PostgreSQL95Dialect.class.getName());
		bean.setGenerateDdl(true);
		bean.setShowSql(true);
		return bean;
	}	


}
