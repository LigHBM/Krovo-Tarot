package ru.hbm.krovotarot.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

@Data
@Component
@ConfigurationProperties(prefix = "random.service.simple")
public class SimpleRandomProperties {
    private String algorithm;
    private String personalizationString;
    private Integer strength;
    private List<Property> properties;

    @Data
    public static class Property {
        private String name;
        private String value;
    }
}
