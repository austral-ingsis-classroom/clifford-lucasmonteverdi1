package edu.austral.ingsis.clifford.commands.command;

import edu.austral.ingsis.clifford.filesystem.Directory;

public interface Command {
  String execute(String[] splitCommand, Directory directory);
}
