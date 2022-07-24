package de.telran.employeemanagement.entity;

import de.telran.employeemanagement.entity.type.LanguageType;
import de.telran.employeemanagement.entity.type.LanguageTypeConverter;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "employee")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@EntityListeners(AuditingEntityListener.class)
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employee_id")
    private Long id;

    @Column(name = "employee_name")
    private String name;

    @Convert(converter = LanguageTypeConverter.class)
    @Column(name = "language_type")
    private LanguageType languageType;

    @CreatedDate
    @Column(name = "created_on")
    private LocalDateTime createdOn;

    @LastModifiedDate
    @Column(name = "employed_on")
    private LocalDateTime employedOn;

    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company company;
}
