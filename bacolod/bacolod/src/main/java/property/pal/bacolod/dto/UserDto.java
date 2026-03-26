package property.pal.bacolod.dto;

import java.time.LocalDateTime;
import java.util.Set;
import property.pal.bacolod.model.UserRole;

public class UserDto {
    public Integer userId;
    public String firstName;
    public String lastName;
    public String email;
    public String phone;
    public String password;
    public LocalDateTime createdAt;
    public Set<UserRole> roles;
}