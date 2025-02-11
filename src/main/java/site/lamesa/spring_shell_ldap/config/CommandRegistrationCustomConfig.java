package site.lamesa.spring_shell_ldap.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.shell.boot.CommandRegistrationCustomizer;
import org.springframework.shell.command.CommandRegistration;


@Configuration
public class CommandRegistrationCustomConfig {

    @Bean
    public CommandRegistrationCustomizer basicCommandGroupCustomizer() {
        return builder -> {  //this is a single instance used to create different groups of commands
            builder.group("basic");
            builder.group("game");
        };
    }

}
