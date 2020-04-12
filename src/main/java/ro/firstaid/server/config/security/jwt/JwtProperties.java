package ro.firstaid.server.config.security.jwt;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class JwtProperties {
    private String secretKey = "secret";

    //validity in milliseconds
    private long validityInMs = 3600000; // 1h
}
