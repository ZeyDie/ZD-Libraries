package ru.zoom4ikdan4ik.systems;

import org.jetbrains.annotations.NotNull;
import ru.zoom4ikdan4ik.systems.enums.ArchitectureType;
import ru.zoom4ikdan4ik.systems.enums.OSType;
import ru.zoom4ikdan4ik.systems.exceptions.OperatingSystemException;

public final class OperatingSystem {
    private static OSType osType;
    private static ArchitectureType architectureType;

    static {
        try {
            osType = OSType.getOS();
            architectureType = ArchitectureType.getArchitecture();
        } catch (OperatingSystemException error) {
            error.printStackTrace();
        }
    }

    @NotNull
    public static boolean isLinux() {
        return osType == OSType.LINUX;
    }

    @NotNull
    public static boolean isWindows() {
        return osType == OSType.WINDOWS;
    }

    @NotNull
    public static boolean isMacOS() {
        return osType == OSType.MACOS;
    }

    @NotNull
    public static boolean isSolaris() {
        return osType == OSType.SOLARIS;
    }

    @NotNull
    public static boolean isX64() {
        return architectureType == ArchitectureType.x64;
    }

    @NotNull
    public static boolean isX32() {
        return architectureType == ArchitectureType.x32;
    }

    @NotNull
    public static OSType getOSType() throws OperatingSystemException {
        return OSType.getOS();
    }

    public static ArchitectureType getArchitectureType() throws OperatingSystemException {
        return ArchitectureType.getArchitecture();
    }
}
