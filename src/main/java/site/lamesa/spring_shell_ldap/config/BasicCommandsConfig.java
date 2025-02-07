package site.lamesa.spring_shell_ldap.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.shell.boot.CommandRegistrationCustomizer;
import org.springframework.shell.command.CommandRegistration;
import site.lamesa.spring_shell_ldap.commands.basic.EchoCommand;

@Configuration
public class BasicCommandsConfig {

    @Bean
    public CommandRegistrationCustomizer basicCommandGroupCustomizer() {
        return builder -> builder.group("basic");
    }

    @Bean
    public CommandRegistration registerEchoCommand(EchoCommand echoCommand, CommandRegistration.BuilderSupplier builder) {
        return echoCommand.echoCommand(builder);
    }
}
