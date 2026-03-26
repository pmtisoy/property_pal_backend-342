package property.pal.bacolod.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class GuestDto {
    public Integer userId;
    public String firstName;
    public String lastName;
    public LocalDate birthdate;
    public String validIdPhotoUpload;
    public String email;
    public String phone;
    public String password; 
    public LocalDateTime createdAt;
}