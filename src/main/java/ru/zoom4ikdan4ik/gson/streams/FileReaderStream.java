package ru.zoom4ikdan4ik.gson.streams;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public final class FileReaderStream {
    private final File file;

    public FileReaderStream(final File file) {
        this.file = file;

        if (!this.file.exists()) {
            try {
                this.file.getParentFile().mkdirs();
                this.file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public final String getJSONFromFile() {
        String json = "";

        for (String string : this.getLines())
            json += string + "\n";

        return json;
    }

    public final List<String> getLines() {
        List<String> lines = new ArrayList<>();

        try (final FileReader fileReader = new FileReader(this.file)) {
            final Scanner scanner = new Scanner(fileReader);

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();

                if (!line.isEmpty())
                    lines.add(line);
            }
        } catch (IOException error) {
            error.printStackTrace();
        }

        return lines;
    }
}
