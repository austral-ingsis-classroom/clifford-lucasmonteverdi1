package edu.austral.ingsis.clifford.cli;

import edu.austral.ingsis.clifford.Directory;
import edu.austral.ingsis.clifford.commands.command.Command;
import edu.austral.ingsis.clifford.commands.parser.*;
import java.util.HashMap;
import java.util.Map;

public class CLI implements Interpreter {
  private Directory directory;
  private final Map<String, CommandParser> parsers = new HashMap<>();

  public CLI() {
    this.parsers.put("cd", new cdParser());
    this.parsers.put("ls", new lsParser());
    this.parsers.put("pwd", new pwdParser());
    this.parsers.put("rm", new rmParser());
    this.parsers.put("mkdir", new mkdirParser());
    this.parsers.put("touch", new touchParser());
  }

  @Override
  public void execute(String command) {
    String[] splitCommand = command.split(" ");
    CommandParser parser = parsers.get(splitCommand[0]);
    Command cmd = parser.parse(command);
    this.directory = cmd.execute(command, directory);
  }
}
