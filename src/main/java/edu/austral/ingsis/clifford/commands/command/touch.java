package edu.austral.ingsis.clifford.commands.command;

import edu.austral.ingsis.clifford.filesystem.Archive;
import edu.austral.ingsis.clifford.filesystem.Directory;
import edu.austral.ingsis.clifford.filesystem.File;

public class touch implements Command {

  @Override
  public Directory execute(String command, Directory directory) {
    String[] cmd = command.split(" ");
    Archive file = new File(cmd[1], directory.getPath());
    directory.addFile(file);
    System.out.println("'" + cmd[1] + "' file created. ");
    return directory;
  }
}
