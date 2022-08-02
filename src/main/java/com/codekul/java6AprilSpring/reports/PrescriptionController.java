package com.codekul.java6AprilSpring.reports;

import com.haulmont.yarg.formatters.factory.DefaultFormatterFactory;
import com.haulmont.yarg.loaders.factory.DefaultLoaderFactory;
import com.haulmont.yarg.loaders.impl.SqlDataLoader;
import com.haulmont.yarg.reporting.Reporting;
import com.haulmont.yarg.reporting.RunParams;
import com.haulmont.yarg.structure.Report;
import com.haulmont.yarg.structure.ReportOutputType;
import com.haulmont.yarg.structure.impl.BandBuilder;
import com.haulmont.yarg.structure.impl.ReportBuilder;
import com.haulmont.yarg.structure.impl.ReportTemplateBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.IOException;

@RestController
@CrossOrigin(allowedHeaders =
        {"Origin", "X-Requested-With", "Content-Type", "Accept", "Authorization"},
        methods = {RequestMethod.DELETE, RequestMethod.POST, RequestMethod.GET, RequestMethod.PUT})
public class PrescriptionController {

    DefaultFormatterFactory defaultFormatterFactory = new DefaultFormatterFactory();

//    @Autowired
//    private JdbcTemplate jdbcTemplate;
    DefaultLoaderFactory defaultLoaderFactory = new DefaultLoaderFactory();
    SqlDataLoader sqlDataLoader;
    @Autowired
    private DataSource dataSource;

    private final Logger logger = LoggerFactory.getLogger(this.getClass().getName());

    @PostConstruct
    void reportSetup() {
        sqlDataLoader = new SqlDataLoader(dataSource);
        defaultLoaderFactory.setSqlDataLoader(sqlDataLoader);
    }

    private void generatePrescription(HttpServletResponse response, Long patientId) throws IOException {
        ReportBuilder reportBuilder = new ReportBuilder();

        ReportTemplateBuilder reportTemplateBuilder = new ReportTemplateBuilder()
                .documentPath("reports/prescription.docx")
                .documentName("prescription.docx")
                .outputType(ReportOutputType.pdf)
                .readFileFromPath();
        reportBuilder.template(reportTemplateBuilder.build());
        BandBuilder bandBuilder = new BandBuilder();
//        ReportBand medicines = bandBuilder.name("medicines")
//                .query("medicines", , "sql")
//                .build();
//        reportBuilder.band(medicines);

        Report report = reportBuilder.build();
        Reporting reporting = new Reporting();
        reporting.setFormatterFactory(new DefaultFormatterFactory());
        reporting.setLoaderFactory(
                new DefaultLoaderFactory()
                        .setSqlDataLoader(
                                new SqlDataLoader(dataSource)
                        )
        );

        response.setContentType("application/pdf");
        response.addHeader("Content-Disposition", "attachment ; filename = " + "" + ".pdf");
        response.addHeader(HttpHeaders.ACCESS_CONTROL_EXPOSE_HEADERS, HttpHeaders.CONTENT_DISPOSITION);

        reporting.runReport(
                new RunParams(report),
                response.getOutputStream()
        );
    }


}
