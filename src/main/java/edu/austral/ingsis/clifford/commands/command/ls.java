package edu.austral.ingsis.clifford.commands.command;

import edu.austral.ingsis.clifford.Archive;
import edu.austral.ingsis.clifford.Directory;

public class ls implements Command {

  @Override
  public Directory execute(String command, Directory directory) {
    String[] splitCommand = command.split(" ");
    String output = loadFiles(directory);
    if (splitCommand.length == 1) {
      System.out.println(output);
    } else {
      printAccordingToParameters(output, command);
    }
    return directory;
  }

  private void printAccordingToParameters(String output, String command) {
    String[] splitParam = command.split("=");
    if (splitParam[1].equals("asc")) {
      System.out.println(output);
    } else if (splitParam[1].equals("desc")) {
      System.out.println(new StringBuilder(output).reverse());
    } else {
      System.out.println("Invalid argument for parameter: '" + splitParam[0] + "'");
    }
  }

  private String loadFiles(Directory directory) {
    StringBuilder res = new StringBuilder();
    if (!directory.getFiles().isEmpty()) {
      for (Archive file : directory.getFiles()) {
        res.append(file.toString()).append(" ");
      }
    }
    return res.toString();
  }
}
