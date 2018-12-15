package com.bben.medical.config.mutildb;

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
// 扫描 Mapper 接口并容器管理
@MapperScan(basePackages = MySqlDataSourceConfig.PACKAGE, sqlSessionFactoryRef = "medicalSqlSessionFactory")
public class MySqlDataSourceConfig {
    // 精确到 medical 目录，以便跟其他数据源隔离
    static final String PACKAGE = "com.bben.medical.mapper.medical";
    static final String MAPPER_LOCATION = "classpath:mapper/medical/*.xml";

    private Logger logger = LoggerFactory.getLogger(MySqlDataSourceConfig.class);

    @Autowired
    private PageInterceptor pageInterceptor;

    @Value("${db.medical.url}")
    private String dbUrl;

    @Value("${db.medical.username}")
    private String username;

    @Value("${db.medical.password}")
    private String password;

    @Value("${db.medical.driver-class-name}")
    private String driverClassName;

    @Value("${db.medical.initialSize}")
    private int initialSize;

    @Value("${db.medical.minIdle}")
    private int minIdle;

    @Value("${db.medical.maxActive}")
    private int maxActive;

    @Value("${db.medical.maxWait}")
    private int maxWait;

    @Value("${db.medical.timeBetweenEvictionRunsMillis}")
    private int timeBetweenEvictionRunsMillis;

    @Value("${db.medical.minEvictableIdleTimeMillis}")
    private int minEvictableIdleTimeMillis;

    @Value("${db.medical.validationQuery}")
    private String validationQuery;

    @Value("${db.medical.testWhileIdle}")
    private boolean testWhileIdle;

    @Value("${db.medical.testOnBorrow}")
    private boolean testOnBorrow;

    @Value("${db.medical.testOnReturn}")
    private boolean testOnReturn;

    @Value("${db.medical.poolPreparedStatements}")
    private boolean poolPreparedStatements;

    @Value("${db.medical.maxPoolPreparedStatementPerConnectionSize}")
    private int maxPoolPreparedStatementPerConnectionSize;

    @Value("${db.medical.filters}")
    private String filters;

    @Value("{db.medical.connectionProperties}")
    private String connectionProperties;

    @Bean(name = "medicalDataSource")     //声明其为Bean实例
    @Primary    //在同样的DataSource中，首先使用被标注的DataSource
    public DataSource medicalDataSource() {
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

    @Bean(name = "medicalTransactionManager")
    @Primary
    public DataSourceTransactionManager medicalTransactionManager() {
        return new DataSourceTransactionManager(medicalDataSource());
    }

    @Bean(name = "medicalSqlSessionFactory")
    @Primary
    public SqlSessionFactory medicalSqlSessionFactory(@Qualifier("medicalDataSource") DataSource medicalDataSource)
            throws Exception {
        final SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(medicalDataSource);

        //该配置非常的重要，如果不将PageInterceptor设置到SqlSessionFactoryBean中，导致分页失效
        sessionFactory.setPlugins(new Interceptor[]{pageInterceptor});
        sessionFactory.setMapperLocations(new PathMatchingResourcePatternResolver()
                .getResources(MySqlDataSourceConfig.MAPPER_LOCATION));
        return sessionFactory.getObject();
    }
}
