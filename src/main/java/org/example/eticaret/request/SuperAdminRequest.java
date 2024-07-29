package org.example.eticaret.request;

import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SuperAdminRequest {
    private Long superAdminId;
    private String username;
    private String password;
}
