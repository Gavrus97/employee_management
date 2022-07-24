package de.telran.employeemanagement.entity.type;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = true)
public class LanguageTypeConverter implements AttributeConverter<LanguageType, Integer> {

    @Override
    public Integer convertToDatabaseColumn(LanguageType languageType) {
        return languageType == null ? null : languageType.getLanguageId();
    }

    @Override
    public LanguageType convertToEntityAttribute(Integer languageId) {
        return languageId == null ? null : LanguageType.findById(languageId);
    }
}
