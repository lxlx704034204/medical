package com.bben.samiservice.config.mutildb;

import com.alibaba.druid.pool.DruidDataSource;
import com.github.pagehelper.PageInterceptor;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.sql.SQLException;

@Configuration
@EnableTransactionManagement
/**
 * 扫描 Mapper 接口并容器管理
 */
@MapperScan(basePackages = MySqlDataSourceConfig.PACKAGE, sqlSessionFactoryRef = "samiserviceSqlSessionFactory")
public class MySqlDataSourceConfig {
    /**
     * 精确到 samiservice 目录，以便跟其他数据源隔离
     */
    static final String PACKAGE = "com.bben.samiservice.mapper.samiservice";
    static final String MAPPER_LOCATION = "classpath:mapper/samiservice/*.xml";

    private Logger logger = LoggerFactory.getLogger(MySqlDataSourceConfig.class);

    @Autowired
    private PageInterceptor pageInterceptor;

    @Value("${db.samiservice.url}")
    private String dbUrl;

    @Value("${db.samiservice.username}")
    private String username;

    @Value("${db.samiservice.password}")
    private String password;

    @Value("${db.samiservice.driver-class-name}")
    private String driverClassName;

    @Value("${db.samiservice.initialSize}")
    private int initialSize;

    @Value("${db.samiservice.minIdle}")
    private int minIdle;

    @Value("${db.samiservice.maxActive}")
    private int maxActive;

    @Value("${db.samiservice.maxWait}")
    private int maxWait;

    @Value("${db.samiservice.timeBetweenEvictionRunsMillis}")
    private int timeBetweenEvictionRunsMillis;

    @Value("${db.samiservice.minEvictableIdleTimeMillis}")
    private int minEvictableIdleTimeMillis;

    @Value("${db.samiservice.validationQuery}")
    private String validationQuery;

    @Value("${db.samiservice.testWhileIdle}")
    private boolean testWhileIdle;

    @Value("${db.samiservice.testOnBorrow}")
    private boolean testOnBorrow;

    @Value("${db.samiservice.testOnReturn}")
    private boolean testOnReturn;

    @Value("${db.samiservice.poolPreparedStatements}")
    private boolean poolPreparedStatements;

    @Value("${db.samiservice.maxPoolPreparedStatementPerConnectionSize}")
    private int maxPoolPreparedStatementPerConnectionSize;

    @Value("${db.samiservice.filters}")
    private String filters;

    @Value("{db.samiservice.connectionProperties}")
    private String connectionProperties;

    @Bean(name = "samiserviceDataSource")     //声明其为Bean实例
    @Primary    //在同样的DataSource中，首先使用被标注的DataSource
    public DataSource samiserviceDataSource() {
        DruidDataSource datasource = new DruidDataSource();

        datasource.setUrl(this.dbUrl);
        datasource.setUsername(username);
        datasource.setPassword(password);
        datasource.setDriverClassName(driverClassName);

        //configuration
        datasource.setInitialSize(initialSize);
        datasource.setMinIdle(minIdle);
        datasource.setMaxActive(maxActive);
        datasource.setMaxWait(maxWait);
        datasource.setTimeBetweenEvictionRunsMillis(timeBetweenEvictionRunsMillis);
        datasource.setMinEvictableIdleTimeMillis(minEvictableIdleTimeMillis);
        datasource.setValidationQuery(validationQuery);
        datasource.setTestWhileIdle(testWhileIdle);
        datasource.setTestOnBorrow(testOnBorrow);
        datasource.setTestOnReturn(testOnReturn);
        datasource.setPoolPreparedStatements(poolPreparedStatements);
        datasource.setMaxPoolPreparedStatementPerConnectionSize(maxPoolPreparedStatementPerConnectionSize);
        try {
            datasource.setFilters(filters);
        } catch (SQLException e) {
            logger.error("druid configuration initialization filter", e);
        }
        datasource.setConnectionProperties(connectionProperties);

        return datasource;
    }

    @Bean(name = "samiserviceTransactionManager")
    @Primary
    public DataSourceTransactionManager samiserviceTransactionManager() {
        return new DataSourceTransactionManager(samiserviceDataSource());
    }

    @Bean(name = "samiserviceSqlSessionFactory")
    @Primary
    public SqlSessionFactory samiserviceSqlSessionFactory(@Qualifier("samiserviceDataSource") DataSource samiserviceDataSource)
            throws Exception {
        final SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(samiserviceDataSource);

        //该配置非常的重要，如果不将PageInterceptor设置到SqlSessionFactoryBean中，导致分页失效
        sessionFactory.setPlugins(new Interceptor[]{pageInterceptor});
        sessionFactory.setMapperLocations(new PathMatchingResourcePatternResolver()
                .getResources(MySqlDataSourceConfig.MAPPER_LOCATION));
        return sessionFactory.getObject();
    }
}
