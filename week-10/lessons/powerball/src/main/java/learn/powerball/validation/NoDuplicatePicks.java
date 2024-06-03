package learn.powerball.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({TYPE, ANNOTATION_TYPE})
@Retention(RUNTIME)
@Constraint(validatedBy = {DuplicatePickValidator.class})
@Documented
public @interface NoDuplicatePicks {
    String message() default "{duplicate picks are forbidden}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
