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
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.sql.SQLException;

@Configuration
@EnableTransactionManagement
// 扫描 Mapper 接口并容器管理
@MapperScan(basePackages = SqlServerDataSourceConfig.PACKAGE, sqlSessionFactoryRef = "sqlMedicalSqlSessionFactory")
public class SqlServerDataSourceConfig {
    // 精确到 sqlMedical 目录，以便跟其他数据源隔离
    static final String PACKAGE = "com.bben.medical.mapper.sqlMedical";
    static final String MAPPER_LOCATION = "classpath:mapper/sqlMedical/*.xml";

    private Logger logger = LoggerFactory.getLogger(SqlServerDataSourceConfig.class);

    @Autowired
    @Qualifier("pageInterceptorSqlServer")
    private PageInterceptor pageInterceptor;

    @Value("${db.sqlMedical.url}")
    private String dbUrl;

    @Value("${db.sqlMedical.username}")
    private String username;

    @Value("${db.sqlMedical.password}")
    private String password;

    @Value("${db.sqlMedical.driver-class-name}")
    private String driverClassName;

    @Value("${db.sqlMedical.initialSize}")
    private int initialSize;

    @Value("${db.sqlMedical.minIdle}")
    private int minIdle;

    @Value("${db.sqlMedical.maxActive}")
    private int maxActive;

    @Value("${db.sqlMedical.maxWait}")
    private int maxWait;

    @Value("${db.sqlMedical.timeBetweenEvictionRunsMillis}")
    private int timeBetweenEvictionRunsMillis;

    @Value("${db.sqlMedical.minEvictableIdleTimeMillis}")
    private int minEvictableIdleTimeMillis;

    @Value("${db.sqlMedical.validationQuery}")
    private String validationQuery;

    @Value("${db.sqlMedical.testWhileIdle}")
    private boolean testWhileIdle;

    @Value("${db.sqlMedical.testOnBorrow}")
    private boolean testOnBorrow;

    @Value("${db.sqlMedical.testOnReturn}")
    private boolean testOnReturn;

    @Value("${db.sqlMedical.poolPreparedStatements}")
    private boolean poolPreparedStatements;

    @Value("${db.sqlMedical.maxPoolPreparedStatementPerConnectionSize}")
    private int maxPoolPreparedStatementPerConnectionSize;

    @Value("${db.sqlMedical.filters}")
    private String filters;

    @Value("{db.sqlMedical.connectionProperties}")
    private String connectionProperties;

    @Bean(name = "sqlMedicalDataSource")     //声明其为Bean实例
//    @Primary    //在同样的DataSource中，首先使用被标注的DataSource
    public DataSource sqlMedicalDataSource() {
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
        datasource.setTestOnReturn(testOnReturn);
        datasource.setTestOnBorrow(testOnBorrow);
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

    @Bean(name = "sqlMedicalTransactionManager")
//    @Primary
    public DataSourceTransactionManager sqlMedicalTransactionManager() {
        return new DataSourceTransactionManager(sqlMedicalDataSource());
    }

    @Bean(name = "sqlMedicalSqlSessionFactory")
//    @Primary
    public SqlSessionFactory sqlMedicalSqlSessionFactory(@Qualifier("sqlMedicalDataSource") DataSource sqlMedicalDataSource)
            throws Exception {
        final SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(sqlMedicalDataSource);

        //该配置非常的重要，如果不将PageInterceptor设置到SqlSessionFactoryBean中，导致分页失效
        sessionFactory.setPlugins(new Interceptor[]{pageInterceptor});
        sessionFactory.setMapperLocations(new PathMatchingResourcePatternResolver()
                .getResources(SqlServerDataSourceConfig.MAPPER_LOCATION));
        return sessionFactory.getObject();
    }
}