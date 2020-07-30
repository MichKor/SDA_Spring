package pl.sda.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pl.sda.profiles.DevProfile;
import pl.sda.profiles.ProdProfile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Configuration
public class AppConfig {

    @Bean
    @DevProfile
    public DatabaseDatasource getH2Datasource() {
        return (() -> Arrays.asList("KasiaTest", "BartekTest", "AniaTest", "KrzysztofTest"));
    }

    @Bean
    @ProdProfile
    public DatabaseDatasource getMysqlDatasource() {
        return new DatabaseDatasource() {
            @Override
            public List<String> getDatabase() {
                try {
                    List<String> allLines = Files.readAllLines(Paths.get("data.txt"));
                    return allLines;
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return new ArrayList<>();
            }
        };
    }
}