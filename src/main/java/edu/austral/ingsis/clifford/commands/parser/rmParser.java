package edu.austral.ingsis.clifford.commands.parser;

import edu.austral.ingsis.clifford.commands.command.Command;
import edu.austral.ingsis.clifford.commands.command.rm;

public class rmParser implements CommandParser {

  @Override
  public Command parse(String command) {
    String[] splitCommand = command.split(" ");
    if (splitCommand.length == 2) {
      return new rm();
    } else if (splitCommand.length == 3) {
      return splitCommand[1].equals("--recursive") ? new rm() : null;
    } else {
      return null;
    }
  }
}
