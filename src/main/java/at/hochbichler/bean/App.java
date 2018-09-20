package at.hochbichler.bean;

import lombok.extern.java.Log;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;

@Log
public class App {
    public static void main(String[] args) {
        AddressDTO invalidAddress = createInvalidAddress();
        validateAddress(invalidAddress);

        AddressDTO validAddress = createValudAddress();
        validateAddress(validAddress);
    }

    private static AddressDTO createValudAddress() {
        AddressDTO addressDTO= new AddressDTO();
        addressDTO.setStreet("Musterstr.");
        addressDTO.setHouseNo("1a");
        addressDTO.setCity("Vienna");
        addressDTO.setZip("1020");
        addressDTO.setCountry("Austria");
        return addressDTO;
    }

    private static void validateAddress(AddressDTO addressDTO) {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        Set<ConstraintViolation<AddressDTO>> violations = validator.validate(addressDTO);

        for (ConstraintViolation<AddressDTO> violation : violations) {
            log.warning(violation.getMessage());
        }

        if (violations.size() == 0) {
            log.info("Address is valid: " + addressDTO);
        }
    }

    private static AddressDTO createInvalidAddress() {
        AddressDTO addressDTO= new AddressDTO();
        addressDTO.setStreet("Street 1a");
        addressDTO.setZip("12345");
        return addressDTO;
    }
}
