package com.StokTakip.DTO;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.Data;


@Data
public final class UserCreateDTO {
	// DATA TRANSFER OBJECT USER
	
    @NotNull(message="{StokTakip.constraints.Notnull.message}")
    @NotEmpty
    private String name;
    
    @NotNull(message="{StokTakip.constraints.Notnull.message}")
    @NotEmpty
    private String password;
    
    @NotNull(message="{StokTakip.constraints.Notnull.message}")
    @NotEmpty
    private String email;
    
}
