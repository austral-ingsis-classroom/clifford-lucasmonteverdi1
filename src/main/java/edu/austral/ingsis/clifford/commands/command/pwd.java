package edu.austral.ingsis.clifford.commands.command;

import edu.austral.ingsis.clifford.Directory;

public class pwd implements Command {

  @Override
  public Directory execute(String command, Directory directory) {
    System.out.println(directory.getPath());
    return directory;
  }
}
