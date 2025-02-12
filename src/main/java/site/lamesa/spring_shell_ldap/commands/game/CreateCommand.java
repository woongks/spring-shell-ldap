package site.lamesa.spring_shell_ldap.commands.game;

import org.springframework.shell.command.CommandRegistration;
import org.springframework.stereotype.Component;
import site.lamesa.spring_shell_ldap.service.commands.CreateService;

import java.util.Arrays;

@Component
public class CreateCommand {

    private final CreateService createService;

    public CreateCommand(CreateService createService) {
        this.createService = createService;
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
                    ctx.getTerminal().writer().println("created: " + output);
                    ctx.getTerminal().flush();
                })
                .and()
                .build();
    }
}
