package org.example.eticaret.response;

import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CustomerResponse {

    private int code;
    private String message;
    private Long id;
    private String name;
    private String surname;
    private String email;
    private int phoneNumber;
    private String address;
    private String password;

}
