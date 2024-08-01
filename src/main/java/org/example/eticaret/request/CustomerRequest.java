package org.example.eticaret.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CustomerRequest {

    @NotEmpty(message = ".......")
    private String name;
    @NotEmpty
    private String surname;
    @NotEmpty
    @Email
    private String email;
    private int phoneNumber;
    private String address;
    private String password;

}
