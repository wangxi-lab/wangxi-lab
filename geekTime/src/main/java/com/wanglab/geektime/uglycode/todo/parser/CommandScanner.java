package com.wanglab.geektime.uglycode.todo.parser;


import com.wanglab.geektime.uglycode.todo.command.vo.CommandVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Optional;
import java.util.Scanner;

@Slf4j
@Component
public class CommandScanner {
    @Autowired
    private CommandParser commandParser;

    @PostConstruct
    public void scanner() {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String command = scanner.nextLine();

            Optional<CommandVO> commandVO = parserCommand(command);
            if (!commandVO.isPresent()) {
                System.out.println("command parse error");
                continue;
            }

            action(commandVO.get());
        }
    }

    private Optional<CommandVO> parserCommand(String command) {
        try {
            return Optional.of(commandParser.parser(command));
        } catch (Exception e) {
            return Optional.empty();
        }
    }

    private void action(CommandVO commandVO) {

    }
}
