package com.wanglab.geektime.uglycode.todo.command.vo;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class CommandVO {
    private String software;

    private String mainCommand;

    private List<ParamVO> param;
}
