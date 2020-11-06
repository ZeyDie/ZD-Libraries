package ru.zoom4ikdan4ik.systems;

import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;

public final class PathSystem {
    public static Path getPathLibrary() {
        final URL location = PathSystem.class.getProtectionDomain().getCodeSource().getLocation();

        try {
            return Paths.get(location.toURI());
        } catch (URISyntaxException error) {
            error.printStackTrace();

            return null;
        }
    }
}
