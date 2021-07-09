package com.loitrem.models;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.usertype.UserType;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Getter
@Setter
@ToString
@NoArgsConstructor
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity //database
@Component //spring boot component
public class Users implements Serializable {


    private static final long serialVersionUID = -2868033610941646633L;


    //fields
    @Id //makes this field the id
    @SequenceGenerator( //creates a sequence
            name = "User_sequence", //names the table in the database
            sequenceName = "User_sequence", // sequence name
            allocationSize = 1 // incriment by 1
    )
    @GeneratedValue(//tells what value to input
            strategy = GenerationType.SEQUENCE, // says to use a sequence instead of auto increment aka GenerationType.IDENTITY
            generator = "User_sequence" // use sequence name
    )
    @Column
    Long uId;

    String uUsername;

    String uPassword;

    UserType userType;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Users users = (Users) o;
        return uId.equals(users.uId) && uUsername.equals(users.uUsername) && uPassword.equals(users.uPassword) && userType.equals(users.userType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(uId, uUsername, uPassword, userType);
    }
}
