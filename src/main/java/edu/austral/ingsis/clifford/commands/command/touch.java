package edu.austral.ingsis.clifford.commands.command;

import edu.austral.ingsis.clifford.filesystem.Archive;
import edu.austral.ingsis.clifford.filesystem.Directory;
import edu.austral.ingsis.clifford.filesystem.File;

public class touch implements Command {

  @Override
  public String execute(String[] splitCommand, Directory directory) {
    Archive file = new File(splitCommand[1], directory.getPath());
    directory.addFile(file);
    return "'" + splitCommand[1] + "' file created. ";
  }
}
