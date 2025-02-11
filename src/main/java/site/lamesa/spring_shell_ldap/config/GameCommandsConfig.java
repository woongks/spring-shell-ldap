package site.lamesa.spring_shell_ldap.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.shell.boot.CommandRegistrationCustomizer;
import org.springframework.shell.command.CommandRegistration;
import site.lamesa.spring_shell_ldap.commands.game.CreateCommand;


@Configuration
public class GameCommandsConfig {


    @Bean
    public CommandRegistration registerCreateCommand(CreateCommand createCommand, CommandRegistration.BuilderSupplier builder) {
        return createCommand.createCommand(builder);
    }

}
