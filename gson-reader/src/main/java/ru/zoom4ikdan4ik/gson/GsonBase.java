package ru.zoom4ikdan4ik.gson;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.jetbrains.annotations.NotNull;

public class GsonBase {
    private Gson gson;

    public GsonBase() {
        this(new GsonBuilder().setPrettyPrinting());
    }

    public GsonBase(@NotNull final GsonBuilder gsonBuilder) {
        this(gsonBuilder.create());
    }

    public GsonBase(@NotNull final Gson gson) {
        this.gson = gson;
    }

    @NotNull
    public final String fromObjectToJson(@NotNull final Object object) {
        return this.gson.toJson(object);
    }

    @NotNull
    public final Object fromJsonToObject(@NotNull final String json, @NotNull final Object object) {
        return this.gson.fromJson(json, object.getClass());
    }

    @NotNull
    public final Gson getGson() {
        return this.gson;
    }

    public final void setGson(@NotNull final GsonBuilder gsonBuilder) {
        this.setGson(gsonBuilder.create());
    }

    public final void setGson(@NotNull final Gson gson) {
        this.gson = gson;
    }
}
