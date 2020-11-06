package ru.zoom4ikdan4ik.gson;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.jetbrains.annotations.NotNull;
import ru.zoom4ikdan4ik.gson.streams.FileReaderStream;
import ru.zoom4ikdan4ik.gson.streams.FileWriterStream;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

public class GsonFile {
    private File file;
    private Gson gson;
    private FileReaderStream fileReaderStream;
    private FileWriterStream fileWriterStream;

    public GsonFile(@NotNull final String path) {
        this(Paths.get(path));
    }

    public GsonFile(@NotNull final Path path) {
        this(path.toFile());
    }

    public GsonFile(@NotNull final File file) {
        this(file, new GsonBuilder().setPrettyPrinting());
    }

    public GsonFile(@NotNull final File file, @NotNull final GsonBuilder gsonBuilder) {
        this(file, gsonBuilder.create());
    }

    public GsonFile(@NotNull final File file, @NotNull final Gson gson) {
        this.file = file;
        this.gson = gson;

        this.fileReaderStream = new FileReaderStream(this);
        this.fileWriterStream = new FileWriterStream(this);
    }

    public final Object fromJsonToObject(@NotNull final Object object) {
        return this.fromJsonToObject(object, false);
    }

    public final Object fromJsonToObject(@NotNull final Object object, final boolean rewrite) {
        if (rewrite || !this.file.exists() || this.file.length() <= 0)
            this.writeJSON(this.gson.toJson(object));

        return this.gson.fromJson(this.getJSONFromFile(), object.getClass());
    }

    public final String getJSONFromFile() {
        return this.fileReaderStream.getJSONFromFile();
    }

    public final void writeJSON(@NotNull final Object object) {
        this.writeJSON(this.gson.toJson(object));
    }

    public final void writeJSON(@NotNull final String json) {
        this.fileWriterStream.writeJSON(json);
    }

    public final File getFile() {
        return this.file;
    }

    public final void setFile(@NotNull final String path) {
        this.setFile(Paths.get(path));
    }

    public final void setFile(@NotNull final Path path) {
        this.setFile(path.toFile());
    }

    public final void setFile(@NotNull final File file) {
        this.file = file;

        this.fileReaderStream = new FileReaderStream(this);
        this.fileWriterStream = new FileWriterStream(this);
    }

    public final void setGson(@NotNull final GsonBuilder gsonBuilder) {
        this.setGson(gsonBuilder.create());
    }

    public final void setGson(@NotNull final Gson gson) {
        this.gson = gson;
    }
}
