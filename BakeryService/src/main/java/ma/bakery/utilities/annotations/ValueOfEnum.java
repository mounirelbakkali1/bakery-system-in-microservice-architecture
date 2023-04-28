package ma.bakery.utilities.annotations;


import ma.bakery.utilities.constrints.ValueOfEnumValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({METHOD,TYPE,PARAMETER,FIELD})
@Retention(RUNTIME)
@Documented
@Constraint(validatedBy = ValueOfEnumValidator.class)
public @interface ValueOfEnum {
    Class<? extends Enum<?>> enumClass();
    String message() default  "must be any of enum {enumClass}";
    Class<? extends Payload>[] payload() default {};
    // required
    Class<?>[] groups() default {};

}
