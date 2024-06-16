package edu.austral.ingsis.clifford.cli;

import edu.austral.ingsis.clifford.commands.command.Command;
import edu.austral.ingsis.clifford.commands.parser.*;
import edu.austral.ingsis.clifford.filesystem.Directory;
import java.util.HashMap;
import java.util.Map;

public class CLI implements Interpreter {
  private Directory directory;
  private final Directory root = new Directory("root", "/", null);
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
    if (cmd == null) {
      System.out.println("Unknown command: " + command);
    } else {
      System.out.println(cmd.execute(splitCommand, this));
    }
  }

  @Override
  public Directory getCurrentDirectory() {
    return directory;
  }

  @Override
  public Directory getRoot() {
    return root;
  }

  @Override
  public void setDirectory(Directory directory) {
    this.directory = directory;
  }
}
