package com.ybb.properties;

import lombok.Data;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "ybb.jwt")
@Data
@ToString
public class JwtProperties {

    private String jwtSecretKey;
    private Long jwtTtl;
    private String jwtTokenName;

}
