package ru.artemchernov.studentsdemo.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.Date;

@Setter
@Getter
@Entity
@Table(name = "students")
@Schema(description = "Сущность студента")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @Schema(description = "Идентификатор", example = "0")
    private Long id;

    @NotNull
    @Pattern(regexp = "[а-яёА-ЯЁ]+")
    @Column(name = "fio")
    @Schema(description = "ФИО", example = "Иванов Иван Иванович")
    private String fio;

    @NotNull
    @Column(name = "birthday")
    @Schema(description = "Дата рождения")
    private Date birthday;

    @OneToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "progressid", referencedColumnName = "id")
    @Schema(description = "Успеваемость из справочника")
    private ProgressHandbook progress;
}
