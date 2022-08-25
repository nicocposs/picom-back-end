package project.picom.validators;

import java.util.regex.Pattern;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ContactNumberValidator implements 
ConstraintValidator<ContactNumberConstraint, String>{

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        Pattern myReg = Pattern.compile("(0|\\+33)[1-9][0-9]{8", Pattern.LITERAL);
        return value != null && myReg.matcher(value).matches();
    }

}
