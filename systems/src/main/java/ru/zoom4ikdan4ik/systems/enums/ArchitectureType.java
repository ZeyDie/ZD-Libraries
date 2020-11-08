package ru.zoom4ikdan4ik.systems.enums;

import ru.zoom4ikdan4ik.systems.exceptions.OperatingSystemException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public enum ArchitectureType {
    x32("x86"),
    x64("amd64");

    private final List<String> contains;

    ArchitectureType(final String... args) {
        this.contains = new ArrayList<>(Arrays.asList(args));
    }

    public static ArchitectureType getArchitecture() throws OperatingSystemException {
        final String architecture = System.getProperty("os.arch").toLowerCase();

        for (final ArchitectureType architectureType : values())
            for (final String contain : architectureType.getContains())
                if (architecture.contains(contain))
                    return architectureType;

        throw new OperatingSystemException("Unnamed architecture with name: " + architecture);
    }

    public final List<String> getContains() {
        return this.contains;
    }
}
