package br.minhaigreja.dto;

import br.minhaigreja.models.Admin;
import lombok.Data;

@Data
public class AdminDTO {
	
    private String id;
    
    private String name;
    
    private String email;
    
    private String password;
    
    public Admin toEntity() {
        Admin admin = new Admin();
        admin.setId(this.id);
        admin.setName(this.name);
        admin.setEmail(this.email);
        admin.setPassword(this.password);
        return admin;
    }
}
