package at.hochbichler.bean;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@ToString
public class AddressDTO {
    private String street;
    private String houseNo;
    @NotNull(message = "City cannot be null")
    private String city;
    @ZipPattern
    private String zip;
    @NotNull(message = "Country cannot be null")
    private String country;
}
