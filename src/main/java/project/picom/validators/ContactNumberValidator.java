package project.picom.validators;

import java.util.regex.Pattern;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ContactNumberValidator implements 
ConstraintValidator<ContactNumberConstraint, String>{

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        Pattern myReg = Pattern.compile("^0[1-9]\\d{8}$");
        return !value.isEmpty() && myReg.matcher(value).matches();
    }

}
