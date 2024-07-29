package org.example.eticaret.response;

import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SuperAdminResponse {
    private Long superAdminId;
    private String username;
    private String password;
}
