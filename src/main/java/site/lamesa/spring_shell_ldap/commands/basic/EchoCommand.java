package site.lamesa.spring_shell_ldap.commands.basic;

import org.jline.terminal.Terminal;
import org.springframework.shell.command.CommandRegistration;
import org.springframework.stereotype.Component;
import site.lamesa.spring_shell_ldap.service.commands.EchoService;

import java.util.Arrays;

@Component
public class EchoCommand {

    private final EchoService echoService;
    private final Terminal terminal;

    public EchoCommand(EchoService echoService, Terminal terminal) {
        this.echoService = echoService;
        this.terminal = terminal;
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
                    terminal.writer().println(output);
                    terminal.flush();
                })
                .and()
                .build();
    }
}
