package pl.lukaszsuma.socialmediaapp.model;

import lombok.Data;
import org.hibernate.validator.constraints.Range;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    @Range(max = 20)
    private String login;
    @NotNull
    @Range(max = 30)
    private String password;
    @Range(max = 100)
    private String accountDescription;
//    @NotNull
//    private AccountStatus accountStatus;
//    @NotNull
//    private AccountType accountType;
}

enum AccountStatus {
    AKTYWNY,
    NIEAKTYWNY,
    ZABLOKOWANY
}

enum AccountType {
    PUBLICZNE,
    PRYWATNE
}
