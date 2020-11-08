package ru.zoom4ikdan4ik.gson.streams;

import ru.zoom4ikdan4ik.gson.GsonFile;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public final class FileReaderStream {
    private final File file;

    public FileReaderStream(final GsonFile gsonFile) {
        this(gsonFile.getFile());
    }

    public FileReaderStream(final File file) {
        this.file = file;

        if (!this.file.exists()) {
            try {
                final File parent = this.file.getParentFile();

                if (parent != null)
                    parent.mkdirs();

                this.file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public final String getJsonFile() {
        final StringBuilder json = new StringBuilder();

        for (final String string : this.getLines())
            json.append(string).append("\n");

        return json.toString();
    }

    public final List<String> getLines() {
        final List<String> lines = new ArrayList<>();

        try (final FileReader fileReader = new FileReader(this.file)) {
            final Scanner scanner = new Scanner(fileReader);

            while (scanner.hasNextLine()) {
                final String line = scanner.nextLine();

                if (!line.isEmpty())
                    lines.add(line);
            }
        } catch (IOException error) {
            error.printStackTrace();
        }

        return lines;
    }
}
