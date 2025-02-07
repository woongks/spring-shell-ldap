package site.lamesa.spring_shell_ldap.commands.basic;

import org.jline.terminal.Terminal;
import org.springframework.shell.command.CommandRegistration;
import org.springframework.stereotype.Component;
import site.lamesa.spring_shell_ldap.service.commands.HelloService;

@Component
public class HelloCommand {

    private final HelloService helloService;
    private final Terminal terminal;

    public HelloCommand(HelloService helloService, Terminal terminal) {
        this.helloService = helloService;
        this.terminal = terminal;
    }

    public CommandRegistration helloCommand(CommandRegistration.BuilderSupplier builder) {
        return builder.get()
                .command("hello")
                .description("Say hello")
                .withTarget()
                .consumer(ctx -> {
                    String hello = helloService.hello();
                    terminal.writer().println(hello);
                    terminal.flush();
                })
                .and()
                .build();
    }
}
