package edu.austral.ingsis.clifford.commands.command;

import edu.austral.ingsis.clifford.filesystem.Directory;

public class touch implements Command {

  @Override
  public Directory execute(String command, Directory directory) {

    return directory;
  }
}
