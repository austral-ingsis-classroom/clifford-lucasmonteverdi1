package edu.austral.ingsis.clifford.commands.parser;

import edu.austral.ingsis.clifford.commands.command.Command;
import edu.austral.ingsis.clifford.commands.command.mkdir;

public class mkdirParser implements CommandParser {

  @Override
  public Command parse(String command) {
    String[] splitCommand = command.split(" ");
    if (splitCommand.length != 2) {
      return null;
    } else {
      return parseArguments(splitCommand[1]);
    }
  }

  /* No spaces for the name or slashes at the beginning. */
  private Command parseArguments(String arg) {
    String[] splitArg = arg.split(" ");
    if (splitArg.length > 1 || splitArg[0].charAt(0) == '/') {
      return null;
    } else {
      return new mkdir();
    }
  }
}
