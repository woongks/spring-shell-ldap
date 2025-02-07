package site.lamesa.spring_shell_ldap.service.commands;

import org.springframework.stereotype.Service;

@Service
public class HelloService {

    public String hello() {
        return "hello world!";
    }
}
