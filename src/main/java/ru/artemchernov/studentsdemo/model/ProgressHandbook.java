package ru.artemchernov.studentsdemo.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Setter
@Getter
@Entity
@Table(name = "progress_handbook")
@Schema(description = "Сущность справочника успеваемости")
public class ProgressHandbook {

    @Id
    @NotNull
    @Column(name = "id")
    @Schema(description = "Идентификатор", example = "4")
    private Long id;

    @NotNull
    @Column(name = "text")
    @Schema(description = "Значение", example = "хор")
    private String text;

    ProgressHandbook() {}
}
