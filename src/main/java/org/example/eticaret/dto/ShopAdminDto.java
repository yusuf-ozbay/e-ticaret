package org.example.eticaret.dto;

import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ShopAdminDto {

    private Long id;
    private String name;
    private String surname;
    private String email;
    private int phoneNumber;
    private String address;
    private String password;
    private String shopName;

}
