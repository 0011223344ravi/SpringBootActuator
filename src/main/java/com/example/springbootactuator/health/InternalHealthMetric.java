package com.example.springbootactuator.health;

import lombok.extern.apachecommons.CommonsLog;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

import java.net.URL;
import java.net.URLConnection;

@Component
public class InternalHealthMetric implements HealthIndicator {


        @Override
        public Health health() {
            return checkInternet() == true ? Health.up().withDetail("success code", "Active Internet Connection").build()
                    : Health.down().withDetail("error code", "InActive Internet Connection").build();

        }

        private boolean checkInternet() {
            boolean flag = false;
            try {
                URL url = new URL("https://www.google.com");
                URLConnection connection = url.openConnection();
                connection.connect();
                flag = true;
            } catch (Exception e) {
                flag = false;
            }
            return flag;
        }

}
