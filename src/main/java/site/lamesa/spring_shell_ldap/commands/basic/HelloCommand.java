package site.lamesa.spring_shell_ldap.commands.basic;

import org.springframework.shell.command.CommandRegistration;
import org.springframework.stereotype.Component;
import site.lamesa.spring_shell_ldap.service.commands.HelloService;

@Component
public class HelloCommand {

    private final HelloService helloService;

    public HelloCommand(HelloService helloService) {
        this.helloService = helloService;
    }

    public CommandRegistration helloCommand(CommandRegistration.BuilderSupplier builder) {
        return builder.get()
                .command("hello")
                .description("Say hello")
                .group("basic")
                .withTarget()
                .consumer(ctx -> {
                    String hello = helloService.hello();
                    ctx.getTerminal().writer().println(hello);
                    ctx.getTerminal().flush();
                })
                .and()
                .build();
    }
}
