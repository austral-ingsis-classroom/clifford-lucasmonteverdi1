package edu.austral.ingsis.clifford.commands.command;

import edu.austral.ingsis.clifford.Directory;

public class mkdir implements Command {

  @Override
  public Directory execute(String command, Directory directory) {
    String[] splitCommand = command.split(" ");
    if (isInvalidInput(splitCommand)) {
      System.out.println("Invalid argument for directory name.");
    } else {
      Directory newDir = new Directory(splitCommand[1], directory.getPath() + "/" + splitCommand[1]);
      directory.addDirectory(newDir);
      System.out.println("'" + splitCommand[1] + "' directory created.");
    }
    return directory;
  }

  /* No spaces for the name or slashes at the beginning. */
  private boolean isInvalidInput(String[] splitCommand) {
    return splitCommand.length > 2 || splitCommand[1].charAt(0) == '/';
  }
}
