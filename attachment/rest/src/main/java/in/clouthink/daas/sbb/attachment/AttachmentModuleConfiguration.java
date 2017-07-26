package in.clouthink.daas.sbb.attachment;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@ComponentScan({"in.clouthink.daas.sbb.attachment"})
@EnableMongoRepositories({"in.clouthink.daas.sbb.attachment"})
@EnableConfigurationProperties(AttachmentConfigurationProperties.class)
public class AttachmentModuleConfiguration {

}
