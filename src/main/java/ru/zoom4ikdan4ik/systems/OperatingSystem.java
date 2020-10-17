package ru.zoom4ikdan4ik.systems;

import ru.zoom4ikdan4ik.systems.enums.OSType;
import ru.zoom4ikdan4ik.systems.exceptions.OperatingSystemException;

public final class OperatingSystem {
    private static OSType osType;

    static {
        try {
            osType = OSType.getOS();
        } catch (OperatingSystemException error) {
            error.printStackTrace();
        }
    }

    public static boolean isLinux() {
        return osType == OSType.LINUX;
    }

    public static boolean isWindows() {
        return osType == OSType.WINDOWS;
    }

    public static boolean isMacOS() {
        return osType == OSType.MACOS;
    }

    public static boolean isSolaris() {
        return osType == OSType.SOLARIS;
    }

    public static OSType getOSType() throws OperatingSystemException {
        return OSType.getOS();
    }
}
