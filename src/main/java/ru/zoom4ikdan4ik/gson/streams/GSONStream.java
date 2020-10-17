package ru.zoom4ikdan4ik.gson.streams;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.File;

public final class GSONStream {
    private final File file;

    public GSONStream(final File file) {
        this.file = file;
    }

    public final Object initGsonFile(final Object object) {
        final Gson gson = this.getDefaultGson();

        if (!this.file.exists() || this.file.length() <= 0)
            this.writeJSON(gson.toJson(object));

        return gson.fromJson(this.getJSONFromFile(), object.getClass());
    }

    public final String getJSONFromFile() {
        final FileReaderStream fileReaderStream = new FileReaderStream(this.file);

        return fileReaderStream.getJSONFromFile();
    }

    public final void writeJSON(final Object object) {
        final Gson gson = this.getDefaultGson();

        this.writeJSON(gson.toJson(object));
    }

    public final void writeJSON(final String json) {
        final FileWriterStream fileWriterStream = new FileWriterStream(this.file);

        fileWriterStream.writeJSON(json);
    }

    public final Gson getDefaultGson() {
        return new GsonBuilder().setPrettyPrinting().create();
    }
}
