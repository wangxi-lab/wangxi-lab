package com.wanglab.geektime.uglycode.todo.parser;

import com.wanglab.geektime.uglycode.todo.command.vo.CommandVO;
import org.springframework.stereotype.Component;

@Component
public class CommandParser {

    public CommandVO parser(String command) {
        return new CommandVO();
    }
}
