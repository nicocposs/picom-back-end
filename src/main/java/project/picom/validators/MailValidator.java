package project.picom.validators;

import java.util.regex.Pattern;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class MailValidator implements 
ConstraintValidator<MailConstraint, String>{

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        Pattern myReg = Pattern.compile("^[a-zA-Z0-9_!#$%&’*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+.[a-zA-Z]+$");
        return !value.isEmpty() && myReg.matcher(value).matches();
    }

}
