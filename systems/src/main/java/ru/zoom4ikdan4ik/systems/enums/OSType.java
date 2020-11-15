package ru.zoom4ikdan4ik.systems.enums;

import org.jetbrains.annotations.NotNull;
import ru.zoom4ikdan4ik.systems.exceptions.OperatingSystemException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public enum OSType {
    LINUX("nix", "nux", "aix"),
    WINDOWS("win"),
    MACOS("mac"),
    SOLARIS("sunos");

    private final List<String> contains;

    OSType(final String... args) {
        this.contains = new ArrayList<>(Arrays.asList(args));
    }

    @NotNull
    public static OSType getOS() throws OperatingSystemException {
        final String os = System.getProperty("os.name").toLowerCase();

        for (final OSType osType : values())
            for (final String contain : osType.getContains())
                if (os.contains(contain))
                    return osType;

        throw new OperatingSystemException("Unnamed OS with name: " + os);
    }

    public final List<String> getContains() {
        return this.contains;
    }
}
