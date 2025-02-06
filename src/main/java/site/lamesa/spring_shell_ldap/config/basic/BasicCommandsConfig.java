package site.lamesa.spring_shell_ldap.config.basic;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.shell.boot.CommandRegistrationCustomizer;
import org.springframework.shell.command.CommandRegistration;

import java.util.Arrays;
import java.util.List;

@Configuration
public class BasicCommandsConfig {

    // This will apply the "basic" group to all commands
    @Bean
    public CommandRegistrationCustomizer basicCommandGroupCustomizer() {
        return builder -> builder.group("basic");
    }

    // Define individual commands
    @Bean
    public CommandRegistration echoCommand(CommandRegistration.BuilderSupplier builder) {
        return builder.get()
                .command("echo")
                .description("print what you have given as an argument")
                .withTarget()
                .consumer(ctx -> {
                    String[] args = ctx.getRawArgs();
                    String[] arg = Arrays.copyOfRange(args, 1, args.length);
                    ctx.getTerminal().writer().println(String.join(" ",arg));

                })
                .and()
                .build();
    }
}

