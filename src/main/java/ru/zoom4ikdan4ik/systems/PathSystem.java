package ru.zoom4ikdan4ik.systems;

import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.CodeSource;
import java.security.ProtectionDomain;

public final class PathSystem {
    public static Path getPathLibrary() {
        final ProtectionDomain protectionDomain = PathSystem.class.getProtectionDomain();
        final CodeSource codeSource = protectionDomain.getCodeSource();
        final URL location = codeSource.getLocation();

        try {
            final URI uri = location.toURI();

            return Paths.get(uri);
        } catch (URISyntaxException error) {
            error.printStackTrace();

            return null;
        }
    }
}
