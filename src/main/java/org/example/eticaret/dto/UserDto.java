package org.example.eticaret.dto;

import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {


    private Long id;
    private String firstName;
    private String lastName;
    private String email;


}
