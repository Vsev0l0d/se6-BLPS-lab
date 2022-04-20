package itmo.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import itmo.jobs.ImportStatJob;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.quartz.QuartzDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.quartz.*;

import javax.sql.DataSource;

@Slf4j
@Configuration
public class QuartzConfig {

    @Bean(name = "importStatJobDetail")
    public JobDetailFactoryBean projectDiscoverJobDetails() {
        final JobDetailFactoryBean factoryBean = new JobDetailFactoryBean();
        factoryBean.setJobClass(ImportStatJob.class);
        factoryBean.setName("ImportStatJob");
        factoryBean.setDurability(true);

        return factoryBean;
    }

    @Bean
    @ConfigurationProperties("datasource.quartz.hikari")
    public HikariConfig quartzHikariConfig() {
        return new HikariConfig();
    }

    @Bean("quartzDataSource")
    @QuartzDataSource
    public DataSource quartzDataSource(HikariConfig quartzHikariConfig) {
        return new HikariDataSource(quartzHikariConfig);
    }
}
