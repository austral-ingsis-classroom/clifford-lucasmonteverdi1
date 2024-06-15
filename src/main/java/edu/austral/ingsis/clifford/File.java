package edu.austral.ingsis.clifford;

public class File implements Archive {
  private final String name;
  private final String path;

  public File(String fileName, String filePath) {
    this.name = fileName;
    this.path = filePath;
  }

  @Override
  public String getName() {
    return name;
  }

  @Override
  public String getPath() {
    return path;
  }

  @Override
  public String toString() {
    return name;
  }
}
