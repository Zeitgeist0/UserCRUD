package com.usercrud.domain;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserRequestDto {

    private Integer id;
    @NotBlank
    @Size(min = 3, message = "Name must have 3 letters")
    private String name;
    @Pattern(regexp = "^\\w+([-+.']\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*$")
    @NotBlank(message = "Email cannot be empty")
    private String email;
    @NotBlank
    @Size(min = 3, message = "Password must have 3 symbols")
    private String password;

    @Override
    public String toString() {
        return "UserRequestDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
