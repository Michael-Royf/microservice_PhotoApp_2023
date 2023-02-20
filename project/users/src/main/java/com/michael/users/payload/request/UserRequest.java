package com.michael.users.payload.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class UserRequest {
    @NotBlank(message = "First name cannot be empty")
    @Size(min = 2, message = "First name must not be less than tho characters")
    private String firstName;
    @NotBlank(message = "Last name cannot be empty")
    @Size(min = 2, message = "Last name must not be less than tho characters")
    private String lastName;
    @NotBlank(message = "Username cannot be empty")
    @Size(min = 2, message = "Username must not be less than tho characters")
    private String username;
    @NotBlank(message = "Password cannot be empty")
    @Size(min = 2, max = 16, message = "Password must be equal  or grater than 8 characters and less than 16 characters")
    private String password;
    @NotBlank(message = "Email can not be empty")
    @Email
    private String email;
}
