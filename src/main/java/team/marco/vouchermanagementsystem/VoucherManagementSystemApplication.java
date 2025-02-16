package team.marco.vouchermanagementsystem;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.context.ApplicationContext;
import org.springframework.core.env.Environment;
import team.marco.vouchermanagementsystem.application.ConsoleApplication;

@SpringBootApplication
@ConfigurationPropertiesScan
public class VoucherManagementSystemApplication {
    private static final Logger logger = LoggerFactory.getLogger(VoucherManagementSystemApplication.class);

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(VoucherManagementSystemApplication.class, args);
        Environment environment = context.getEnvironment();

        logger.info("Program start (profile: {})", environment.getActiveProfiles()[0]);

        ConsoleApplication application = context.getBean(ConsoleApplication.class);
        application.run();

        logger.info("Program exit");
    }
}
