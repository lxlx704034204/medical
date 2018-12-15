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

//@Configuration
//@EnableTransactionManagement
//// 扫描 Mapper 接口并容器管理
//@MapperScan(basePackages = OracleDataSourceConfig.PACKAGE, sqlSessionFactoryRef = "oracleSqlSessionFactory")
public class OracleDataSourceConfig {
    // 精确到 oracle 目录，以便跟其他数据源隔离
    static final String PACKAGE = "com.bben.medical.mapper.oracle";
    static final String MAPPER_LOCATION = "classpath:mapper/oracle/*.xml";

    private Logger logger = LoggerFactory.getLogger(OracleDataSourceConfig.class);

    @Autowired
    @Qualifier("pageInterceptorOracle")
    private PageInterceptor pageInterceptor;

    @Value("${db.oracle.url}")
    private String dbUrl;

    @Value("${db.oracle.username}")
    private String username;

    @Value("${db.oracle.password}")
    private String password;

    @Value("${db.oracle.driver-class-name}")
    private String driverClassName;

    @Value("${db.oracle.initialSize}")
    private int initialSize;

    @Value("${db.oracle.minIdle}")
    private int minIdle;

    @Value("${db.oracle.maxActive}")
    private int maxActive;

    @Value("${db.oracle.maxWait}")
    private int maxWait;

    @Value("${db.oracle.timeBetweenEvictionRunsMillis}")
    private int timeBetweenEvictionRunsMillis;

    @Value("${db.oracle.minEvictableIdleTimeMillis}")
    private int minEvictableIdleTimeMillis;

    @Value("${db.oracle.validationQuery}")
    private String validationQuery;

    @Value("${db.oracle.testWhileIdle}")
    private boolean testWhileIdle;

    @Value("${db.oracle.testOnBorrow}")
    private boolean testOnBorrow;

    @Value("${db.oracle.testOnReturn}")
    private boolean testOnReturn;

    @Value("${db.oracle.poolPreparedStatements}")
    private boolean poolPreparedStatements;

    @Value("${db.oracle.maxPoolPreparedStatementPerConnectionSize}")
    private int maxPoolPreparedStatementPerConnectionSize;

    @Value("${db.oracle.filters}")
    private String filters;

    @Value("{db.oracle.connectionProperties}")
    private String connectionProperties;

    @Bean(name = "oracleDataSource")     //声明其为Bean实例
//    @Primary    //在同样的DataSource中，首先使用被标注的DataSource
    public DataSource oracleDataSource() {
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

    @Bean(name = "oracleTransactionManager")
//    @Primary
    public DataSourceTransactionManager oracleTransactionManager() {
        return new DataSourceTransactionManager(oracleDataSource());
    }

    @Bean(name = "oracleSqlSessionFactory")
//    @Primary
    public SqlSessionFactory oracleSqlSessionFactory(@Qualifier("oracleDataSource") DataSource oracleDataSource)
            throws Exception {
        final SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(oracleDataSource);

        //该配置非常的重要，如果不将PageInterceptor设置到SqlSessionFactoryBean中，导致分页失效
        sessionFactory.setPlugins(new Interceptor[]{pageInterceptor});
        sessionFactory.setMapperLocations(new PathMatchingResourcePatternResolver()
                .getResources(OracleDataSourceConfig.MAPPER_LOCATION));
        return sessionFactory.getObject();
    }
}