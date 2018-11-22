package ru.sertok.transfer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.sertok.models.User;

import java.sql.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
    private String name;
    private Date date;

    public static UserDto from(User user){
        return new UserDto(user.getName(),user.getBirthDate());
    }
}
