package edu.austral.ingsis;

import edu.austral.ingsis.clifford.cli.CLI;
import edu.austral.ingsis.clifford.cli.Interpreter;
import edu.austral.ingsis.clifford.commands.command.Command;
import edu.austral.ingsis.clifford.commands.parser.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FileSystem implements FileSystemRunner {
  private final Map<String, CommandParser> parsers = new HashMap<>();
  private final Interpreter interpreter = new CLI();

  public FileSystem() {
    this.parsers.put("cd", new cdParser());
    this.parsers.put("ls", new lsParser());
    this.parsers.put("pwd", new pwdParser());
    this.parsers.put("rm", new rmParser());
    this.parsers.put("mkdir", new mkdirParser());
    this.parsers.put("touch", new touchParser());
  }

  @Override
  public List<String> executeCommands(List<String> commands) {
    List<String> results = new ArrayList<>();
    for (String command : commands) {
      String[] splitCommand = command.split(" ");
      Command cmd = this.parsers.get(splitCommand[0]).parse(command);
      if (cmd != null) {
        String res = cmd.execute(splitCommand, interpreter);
        results.add(res);
      }
    }
    return results;
  }
}
