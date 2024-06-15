package edu.austral.ingsis.clifford.commands.command;

import edu.austral.ingsis.clifford.Directory;

public class cd implements Command {

  @Override
  public Directory execute(String command, Directory directory) {
    String[] splitCommand = command.split(" ");

  }
}
