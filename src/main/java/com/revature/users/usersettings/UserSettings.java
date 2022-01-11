package com.revature.users.usersettings;

import com.revature.users.User;
import lombok.*;
import javax.persistence.*;
import java.util.Objects;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "user_settings")
public class UserSettings {

    @Id
    @GeneratedValue
    private String uuid; //Change back to UUID After testing

    @OneToOne
    @MapsId
    @JoinColumn(name="user_id_fk", referencedColumnName = "user_id", nullable = false, unique = true)
    private User user;

    @Column(name="dark_mode",nullable = false)
    private boolean darkMode;

    public boolean isDarkMode() {
        return darkMode;
    }

    public void setDarkMode(boolean darkMode) {
        this.darkMode = darkMode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserSettings that = (UserSettings) o;
        return darkMode == that.darkMode && uuid.equals(that.uuid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(uuid, darkMode);
    }
}
