package edu.austral.ingsis.clifford.commands.command;

import edu.austral.ingsis.clifford.filesystem.Directory;

public class pwd implements Command {

  @Override
  public Directory execute(String[] splitCommand, Directory directory) {
    System.out.println(directory.getPath());
    return directory;
  }
}
