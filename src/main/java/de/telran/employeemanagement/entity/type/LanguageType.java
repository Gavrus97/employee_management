package de.telran.employeemanagement.entity.type;

import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.util.Arrays;

@AllArgsConstructor
@Getter
public enum LanguageType {

    ENGLISH(1, "en"),
    RUSSIAN(2, "ru");

    private final Integer languageId;
    private final String languageExternalId;

    public static LanguageType findById(Integer languageId) {
        if (languageId == null) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST,
                    "language cannot be null"
            );
        }

        return Arrays.stream(LanguageType.values())
                .filter(type -> type.getLanguageId().equals(languageId))
                .findFirst()
                .orElseThrow(
                        () -> new ResponseStatusException(
                                HttpStatus.NOT_FOUND,
                                String.format("Language with id {%s} doesn't exist", languageId)
                        )
                );
    }

    @JsonCreator
    public static LanguageType findByExternalId(String externalId) {
        if (externalId == null) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST,
                    "language cannot be null"
            );
        }

        return Arrays.stream(LanguageType.values())
                .filter(type -> type.getLanguageExternalId().equals(externalId))
                .findFirst()
                .orElseThrow(
                        () -> new ResponseStatusException(
                                HttpStatus.NOT_FOUND,
                                String.format("Language {%s} doesn't exist", externalId)
                        )
                );
    }
}
