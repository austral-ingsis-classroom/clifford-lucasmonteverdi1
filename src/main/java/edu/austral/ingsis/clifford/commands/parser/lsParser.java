package edu.austral.ingsis.clifford.commands.parser;

import edu.austral.ingsis.clifford.commands.command.Command;
import edu.austral.ingsis.clifford.commands.command.ls;

public class lsParser implements CommandParser {

  @Override
  public Command parse(String command) {
    String[] splitCommand = command.split(" ");
    if (splitCommand.length == 1) {
      return new ls();
    } else if (splitCommand.length == 2) {
      return parseArguments(splitCommand[1]);
    } else {
      return null;
    }
  }

  private Command parseArguments(String param) {
    String[] splitParam = param.split("=");
    if (!splitParam[0].equals("--ord")) {
      System.out.println("Invalid parameter: '" + splitParam[0] + "'");
      return null;
    } else {
      if (splitParam[1].equals("asc") || splitParam[1].equals("desc")) {
        return new ls();
      } else {
        return null;
      }
    }
  }
}
