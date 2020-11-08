package ru.zoom4ikdan4ik.systems.paths.data;

public final class ExcludeData {
    private final String name;
    private final boolean isFile;

    public ExcludeData(final String name) {
        this.name = name;

        this.isFile = this.name.contains(".");
    }

    public final String getName() {
        return this.name;
    }

    public final boolean isFile() {
        return this.isFile;
    }

    public final boolean isFolder() {
        return !this.isFile;
    }
}
