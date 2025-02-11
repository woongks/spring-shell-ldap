package site.lamesa.spring_shell_ldap.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.shell.command.CommandRegistration;
import site.lamesa.spring_shell_ldap.commands.basic.EchoCommand;
import site.lamesa.spring_shell_ldap.commands.basic.HelloCommand;

@Configuration
public class BasicCommandsConfig {


    @Bean
    public CommandRegistration registerEchoCommand(EchoCommand echoCommand, CommandRegistration.BuilderSupplier builder) {
        return echoCommand.echoCommand(builder);
    }

    @Bean
    public CommandRegistration registerHelloCommand(HelloCommand HelloCommand, CommandRegistration.BuilderSupplier builder) {
        return HelloCommand.helloCommand(builder);
    }
}
