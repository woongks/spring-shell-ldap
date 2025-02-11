package site.lamesa.spring_shell_ldap.service.commands;

import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class CreateService {

    public String create(String[] args) {
        if (args.length == 0) {
            return "";
        }
        return String.join(" ", args);
    }
}
