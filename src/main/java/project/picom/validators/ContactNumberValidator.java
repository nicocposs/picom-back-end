package project.picom.validators;

import java.util.regex.Pattern;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ContactNumberValidator implements 
ConstraintValidator<ContactNumberConstraint, String>{

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        Pattern myReg = Pattern.compile("/^(+33\s[1-9]{8})|(0[1-9]\s{8})$/", Pattern.LITERAL);
        return value != null && myReg.matcher(value).matches();
    }

}
