package site.lamesa.spring_shell_ldap.commands.game;

import org.jline.terminal.Terminal;
import org.springframework.shell.command.CommandRegistration;
import org.springframework.stereotype.Component;
import site.lamesa.spring_shell_ldap.service.commands.CreateService;

import java.util.Arrays;

@Component
public class CreateCommand {

    private final CreateService createService;
    private final Terminal terminal;

    public CreateCommand(CreateService createService, Terminal terminal) {
        this.createService = createService;
        this.terminal = terminal;
    }

    public CommandRegistration createCommand(CommandRegistration.BuilderSupplier builder) {
        return builder.get()
                .command("create")
                .description("Create a user")
                .group("game")
                .withTarget()
                .consumer(ctx -> {
                    String[] rawArgs = ctx.getRawArgs();
                    String[] args = Arrays.copyOfRange(rawArgs,1,rawArgs.length);
                    String output = createService.create(args);
                    terminal.writer().println("created: " + output);
                    terminal.flush();
                })
                .and()
                .build();
    }
}
