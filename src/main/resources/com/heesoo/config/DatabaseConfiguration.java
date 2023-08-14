import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.context.ApplicationContext;

import com.zaxxer.hikari.HikariDataSource;

@Configuration
@MapperScan("com.heesoo.mapper")
@RequiredArgsConstructor
@propertySource("classpath:/application.properties")
public class DatabaseConfiguration {
	
	@Autowired
	private ApplicationContext applicationContext;
	
	@Bean
	@ConfigurationProperties(prefix="spring.datasource.hikari")
	public HikariConfig hikariConfig() {
		return new HikariConfig();
	}
	
	@Bean
	public DataSource dataSource() throws Exception{
		DataSource dataSource = new HikariDataSource(hikariConfig());
		System.out.println(dataSource.toString());
		return dataSource;
	}
	
	@Bean
	public SqlSessionTemplate sqlSessionTemplate(SqlSessionFactory sqlSessionFactory) {
		return new SqlSessionTemplate(sqlSessionFactory);
	}
	
	@Bean
	public SqlSessionFactory sqlSessionFactory(DataSource dataSource) {
		SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
		
		System.out.println("Mapper Resources::" + sqlSessionFactoryBean.getObject());
		sqlSessionFactoryBean.setMapperLocations(applicationContext.getResources("classpath:/mapper/NutrientMapper.xml"));
		
		sqlSessionFactoryBean.setConfiguration(mybatisConfig());
		return sqlSessionFactoryBean.getObject();
	}
	
	@Bean
	@ConfigurationProperties(prefix = "mybatis.configuration")
	public Configuration mybatisConfig() {
		return new Configuration();
	}

}
