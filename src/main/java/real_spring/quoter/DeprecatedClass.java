package real_spring.quoter;

import java.lang.annotation.Retention;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Retention(RUNTIME)
public @interface DeprecatedClass {
    Class<?> newClass();
}
