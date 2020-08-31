package com.sammidev.designpattern.command;

import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) {
        CommandExecutor executor = new CommandExecutor();
        executor.getCommandList().add(new WebServiceCommandCall());
        executor.getCommandList().add(new WriteCommand("data.txt", "studentList"));
        executor.run();
    }
}

interface Command {
    public void execute();
}

class CommandExecutor {

    private List<Command> commandList = new ArrayList<>();

    public void run() {
        for (Command c : commandList) {
            c.execute();
        }
    }

    public void run(Command command) {
        command.execute();
    }

    public CommandExecutor(List<Command> commandList) {
        this.commandList = commandList;
    }

    public CommandExecutor() {
    }

    public List<Command> getCommandList() {
        return commandList;
    }

    public void setCommandList(List<Command> commandList) {
        this.commandList = commandList;
    }
}

class WebServiceCommandCall implements Command {
    @Override
    public void execute() {
        System.out.printf("mengakses rest api : http://localhost:9000/api/students");
    }
}


class WriteCommand implements Command {

    private String namefile;
    private String content;

    @Override
    public void execute() {
        System.out.println("menulis data "+content+" ke file ");
    }

    public WriteCommand(String namefile, String content) {
        this.namefile = namefile;
        this.content = content;
    }

    public WriteCommand() {
    }

    public String getNamefile() {
        return namefile;
    }

    public void setNamefile(String namefile) {
        this.namefile = namefile;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}