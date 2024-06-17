package edu.austral.ingsis.clifford.commands.parser;

import edu.austral.ingsis.clifford.commands.command.Command;
import edu.austral.ingsis.clifford.commands.command.pwd;

public class pwdParser implements CommandParser {

  @Override
  public Command parse(String command) {
    String[] splitCommand = command.split(" ");
    return splitCommand.length == 1 ? new pwd() : null;
  }
}
