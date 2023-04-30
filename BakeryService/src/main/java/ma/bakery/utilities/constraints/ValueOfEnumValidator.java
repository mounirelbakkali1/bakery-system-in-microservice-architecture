package ma.bakery.utilities.constraints;

import ma.bakery.utilities.annotations.ValueOfEnum;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.constraintvalidation.SupportedValidationTarget;
import javax.validation.constraintvalidation.ValidationTarget;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;


@Component
@SupportedValidationTarget(ValidationTarget.ANNOTATED_ELEMENT)
public class ValueOfEnumValidator implements ConstraintValidator<ValueOfEnum,CharSequence> {
    private List<String> acceptedValues;

    @Override
    public void initialize(ValueOfEnum constraintAnnotation) {
        acceptedValues = Stream.of(constraintAnnotation.enumClass().getEnumConstants())
                .map(Enum::name)
                .collect(Collectors.toList());
    }

    @Override
    public boolean isValid(CharSequence charSequence, ConstraintValidatorContext constraintValidatorContext) {
        if (charSequence==null) return true ;
        return acceptedValues.contains(charSequence.toString());
    }
}
