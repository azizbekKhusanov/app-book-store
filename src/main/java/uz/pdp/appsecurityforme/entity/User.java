package uz.pdp.appsecurityforme.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import org.springframework.boot.context.properties.bind.DefaultValue;
import uz.pdp.appsecurityforme.entity.temp.AbsLongEntity;
import uz.pdp.appsecurityforme.enums.RoleEnum;
import uz.pdp.appsecurityforme.utils.AppConstants;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Table(name = "users", uniqueConstraints = {
        @UniqueConstraint(columnNames = "email")
})
public class User extends AbsLongEntity {

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;

    @Enumerated(value = EnumType.STRING)
    @ColumnDefault("USER")
    private RoleEnum roleEnum;

}
