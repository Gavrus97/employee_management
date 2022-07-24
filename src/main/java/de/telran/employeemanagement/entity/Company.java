package de.telran.employeemanagement.entity;

import de.telran.employeemanagement.entity.type.LanguageType;
import de.telran.employeemanagement.entity.type.LanguageTypeConverter;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "company")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "company_id")
    private Long id;

    @Column(name = "company_name")
    private String name;

    @Column(name = "language_type")
    @Convert(converter = LanguageTypeConverter.class)
    private LanguageType language;
}
