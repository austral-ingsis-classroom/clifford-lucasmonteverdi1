package edu.austral.ingsis.clifford.commands.command;

import edu.austral.ingsis.clifford.filesystem.Directory;

public class cd implements Command {

  @Override
  public Directory execute(String[] splitCommand, Directory directory) {
    return directory;
  }
}
