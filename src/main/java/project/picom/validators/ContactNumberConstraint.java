package project.picom.validators;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Documented
@Constraint(validatedBy = ContactNumberValidator.class)
public @interface ContactNumberConstraint {
    String message() default "Le numéro de téléphone n'est pas correct";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}