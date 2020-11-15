package ru.zoom4ikdan4ik.systems.paths.streams;

import org.jetbrains.annotations.NotNull;
import ru.zoom4ikdan4ik.systems.paths.enums.PathRuleType;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public final class PathStream {
    private final File file;

    public PathStream(final String path) {
        this(Paths.get(path));
    }

    public PathStream(final Path path) {
        this(path.toFile());
    }

    public PathStream(final File file) {
        this.file = file;
    }

    @NotNull
    public final List<File> getFiles(final PathRuleType pathRuleType) {
        final List<File> fileList = new ArrayList<>();

        switch (pathRuleType) {
            case ALL: {
                final File[] tempFiles = this.file.listFiles();


                break;
            }
            case TO_LAST: {
                break;
            }
            case TO_FIRST: {
                break;
            }
            case IGNORE_FOLDERS: {
                break;
            }
            case IGNORE_FOLDERS_FILES: {
                break;
            }
        }

        return fileList;
    }
}
