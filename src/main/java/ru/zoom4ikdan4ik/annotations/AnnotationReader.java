package ru.zoom4ikdan4ik.annotations;

import com.sun.istack.internal.NotNull;
import ru.zoom4ikdan4ik.annotations.exceptions.AnnotationReaderException;

import java.lang.annotation.Annotation;

public final class AnnotationReader {
    private final Class<?> clazz;
    private final Annotation annotation;

    public AnnotationReader(@NotNull final Class<?> clazz) {
        this.clazz = clazz;
        this.annotation = null;
    }

    public AnnotationReader(@NotNull final Class<?> clazz, @NotNull final Annotation annotation) {
        this.clazz = clazz;
        this.annotation = annotation;
    }

    public final boolean hasAnnotation() throws AnnotationReaderException {
        if (this.hasReadingAnnotation())
            return this.hasAnnotation(this.annotation);
        else throw new AnnotationReaderException("Reading annotation is null! Try method hasAnnotation(Annotation)");
    }

    public final boolean hasAnnotation(@NotNull final Annotation annotation) {
        return this.hasAnnotation(annotation.getClass());
    }

    public final boolean hasAnnotation(@NotNull final Class<? extends Annotation> annotation) {
        return this.clazz.isAnnotationPresent(annotation);
    }

    public final Class<?> getReadingClass() {
        return this.clazz;
    }

    public final Annotation getReadingAnnotation() {
        return this.annotation;
    }

    public final boolean hasReadingAnnotation() {
        return this.annotation != null;
    }
}
