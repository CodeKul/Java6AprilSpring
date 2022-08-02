package com.codekul.java6AprilSpring.reports;

import com.haulmont.yarg.formatters.factory.DefaultFormatterFactory;
import com.haulmont.yarg.loaders.factory.DefaultLoaderFactory;
import com.haulmont.yarg.loaders.impl.SqlDataLoader;
import com.haulmont.yarg.reporting.Reporting;
import com.haulmont.yarg.structure.impl.ReportBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;


@Configuration
public class YargConfig {

    @Autowired
    private DataSource dataSource;

    @Bean
    public ReportBuilder reportBuilder() {
        return new ReportBuilder();
    }

    @Bean
    public Reporting reporting() {
        Reporting reporting = new Reporting();
        reporting.setFormatterFactory(new DefaultFormatterFactory());
        reporting.setLoaderFactory(
                new DefaultLoaderFactory()
                        .setSqlDataLoader(
                                new SqlDataLoader(dataSource)
                        )
        );

        return reporting;
    }
}
