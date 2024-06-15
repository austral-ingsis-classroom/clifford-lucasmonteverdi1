package edu.austral.ingsis.clifford.commands.command;

import edu.austral.ingsis.clifford.Directory;

public interface Command {
  Directory execute(String command);
}
