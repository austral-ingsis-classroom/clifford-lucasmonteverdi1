package edu.austral.ingsis.clifford.commands.command;

import edu.austral.ingsis.clifford.filesystem.Archive;
import edu.austral.ingsis.clifford.filesystem.Directory;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ls implements Command {

  @Override
  public String execute(String[] splitCommand, Directory directory) {
    if (splitCommand.length == 1) {
      return loadFiles(directory);
    } else {
      return printAccordingToParameters(directory, splitCommand);
    }
  }

  private String printAccordingToParameters(Directory directory, String[] splitCommand) {
    String[] splitParam = splitCommand[1].split("=");
    StringBuilder output = new StringBuilder();
    List<String> files = loadFilesToString(directory);
    if (splitParam[1].equals("asc")) {
      Collections.sort(files);
    } else {
      files.sort(Collections.reverseOrder());
    }
    return buildString(output, files);
  }

  private String buildString(StringBuilder output, List<String> files) {
    for (String file : files) {
      output.append(file).append(" ");
    }
    return output.toString();
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

  private List<String> loadFilesToString(Directory directory) {
    List<String> res = new ArrayList<>();
    for (Archive file : directory.getFiles()) {
      res.add(file.toString());
    }
    return res;
  }
}
