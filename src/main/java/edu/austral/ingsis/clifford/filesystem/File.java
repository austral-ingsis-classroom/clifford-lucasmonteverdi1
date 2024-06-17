package edu.austral.ingsis.clifford.filesystem;

public class File implements Archive {
  private Directory parent;
  private final String name;
  private final String path;

  public File(String fileName, String filePath, Directory parent) {
    this.name = fileName;
    this.path = filePath;
    this.parent = parent;
  }

  @Override
  public String getName() {
    return name;
  }

  @Override
  public String getPath() {
    return path;
  }

  public Directory getParent() {
    return parent;
  }

  @Override
  public String toString() {
    return name;
  }
}
