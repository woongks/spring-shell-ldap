package site.lamesa.spring_shell_ldap.commands.basic;

import org.springframework.shell.command.CommandRegistration;
import org.springframework.stereotype.Component;
import site.lamesa.spring_shell_ldap.service.commands.EchoService;

import java.util.Arrays;

@Component
public class EchoCommand {

    private final EchoService echoService;

    public EchoCommand(EchoService echoService) {
        this.echoService = echoService;
    }

    public CommandRegistration echoCommand(CommandRegistration.BuilderSupplier builder) {
        return builder.get()
                .command("echo")
                .description("Prints the given input arguments")
                .group("basic")
                .withTarget()
                .consumer(ctx -> {
                    String[] rawArgs = ctx.getRawArgs();
                    String[] args = Arrays.copyOfRange(rawArgs,1,rawArgs.length);
                    String output = echoService.echo(args);
                    ctx.getTerminal().writer().println(output);
                    ctx.getTerminal().flush();
                })
                .and()
                .build();
    }
}
