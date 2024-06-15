package edu.austral.ingsis.clifford.commands.parser;

import edu.austral.ingsis.clifford.commands.command.Command;
import edu.austral.ingsis.clifford.commands.command.touch;

public class touchParser implements CommandParser {

  @Override
  public Command parse(String command) {
    String[] splitCommand = command.split(" ");
    if (splitCommand.length != 2) {
      System.out.println("Invalid command");
      return null;
    } else {
      return parseFileName(splitCommand[1]);
    }
  }

  private Command parseFileName(String fileName) {
    return fileName.charAt(0) == '/' ? null : new touch();
  }
}
