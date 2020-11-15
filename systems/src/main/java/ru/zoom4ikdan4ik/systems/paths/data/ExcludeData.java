package ru.zoom4ikdan4ik.systems.paths.data;

import org.jetbrains.annotations.NotNull;

public final class ExcludeData {
    private final String name;
    private final boolean isFile;

    public ExcludeData(final String name) {
        this.name = name;

        this.isFile = this.name.contains(".");
    }

    @NotNull
    public final String getName() {
        return this.name;
    }

    @NotNull
    public final boolean isFile() {
        return this.isFile;
    }

    @NotNull
    public final boolean isFolder() {
        return !this.isFile;
    }
}
