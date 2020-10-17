package ru.zoom4ikdan4ik.gson.streams;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public final class FileWriterStream {
    private final File file;

    public FileWriterStream(final File file) {
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

    public final void writeJSON(final String json) {
        try (final FileWriter fileWriter = new FileWriter(this.file)) {
            fileWriter.write(json);

            fileWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
