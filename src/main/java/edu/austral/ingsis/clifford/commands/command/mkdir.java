package edu.austral.ingsis.clifford.commands.command;

import edu.austral.ingsis.clifford.filesystem.Directory;

public class mkdir implements Command {

  @Override
  public String execute(String[] splitCommand, Directory directory) {
    Directory newDir = new Directory(
        splitCommand[1], directory.getPath() + "/" + splitCommand[1], directory);
    directory.addDirectory(newDir);
    return "'" + splitCommand[1] + "' directory created.";
  }
}
