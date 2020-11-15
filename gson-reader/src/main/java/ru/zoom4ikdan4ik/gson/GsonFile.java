package ru.zoom4ikdan4ik.gson;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.jetbrains.annotations.NotNull;
import ru.zoom4ikdan4ik.gson.streams.FileReaderStream;
import ru.zoom4ikdan4ik.gson.streams.FileWriterStream;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

public class GsonFile extends GsonBase {
    private File file;

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
        super(gson);

        this.file = file;

        this.fileReaderStream = new FileReaderStream(this);
        this.fileWriterStream = new FileWriterStream(this);
    }

    @NotNull
    public final Object fromJsonToObject(@NotNull final Object object) {
        return this.fromJsonToObject(object, false);
    }

    @NotNull
    public final Object fromJsonToObject(@NotNull final Object object, final boolean rewrite) {
        if (rewrite || !this.file.exists() || this.file.length() <= 0) {
            final String json = this.fromObjectToJson(object);

            this.writeJsonFile(json);
        }

        return this.fromJsonToObject(this.getJsonFile(), object);
    }

    @NotNull
    public final String getJsonFile() {
        return this.fileReaderStream.getJsonFile();
    }

    public final void writeJsonFile(@NotNull final Object object) {
        final String json = this.fromObjectToJson(object);

        this.writeJsonFile(json);
    }

    public final void writeJsonFile(@NotNull final String json) {
        this.fileWriterStream.writeJsonFile(json);
    }

    @NotNull
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
}
