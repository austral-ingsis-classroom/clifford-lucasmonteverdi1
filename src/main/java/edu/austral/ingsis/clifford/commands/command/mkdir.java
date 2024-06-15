package edu.austral.ingsis.clifford.commands.command;

import edu.austral.ingsis.clifford.filesystem.Directory;

public class mkdir implements Command {

  @Override
  public Directory execute(String[] splitCommand, Directory directory) {
    Directory newDir = new Directory(splitCommand[1], directory.getPath() + "/" + splitCommand[1]);
    directory.addDirectory(newDir);
    System.out.println("'" + splitCommand[1] + "' directory created.");
    return directory;
  }
}
