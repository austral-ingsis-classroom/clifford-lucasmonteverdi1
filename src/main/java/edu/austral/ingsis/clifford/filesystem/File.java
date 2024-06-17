package edu.austral.ingsis.clifford.filesystem;

import java.util.Objects;

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

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof File file)) return false;
    return Objects.equals(parent, file.parent)
        && Objects.equals(name, file.name)
        && Objects.equals(path, file.path);
  }

  @Override
  public int hashCode() {
    return Objects.hash(parent, name, path);
  }
}
