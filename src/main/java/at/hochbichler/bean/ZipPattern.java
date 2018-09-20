package at.hochbichler.bean;

import javax.validation.Constraint;
import javax.validation.Payload;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Pattern(regexp = AddressPattern.ZIP)
@NotNull(message = "ZIP code cannot be null")
@Constraint(validatedBy = {})
@Target(value = { ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface ZipPattern {
    String message() default "Invalid ZIP code";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };

}
