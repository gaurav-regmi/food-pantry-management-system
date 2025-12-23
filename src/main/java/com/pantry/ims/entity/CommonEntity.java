package com.pantry.ims.entity;

import com.pantry.ims.dto.ModelBase;
import jakarta.persistence.Column;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class CommonEntity extends ModelBase {

    @Column(name = "CREATED_AT")
    private LocalDate createdAt;

    @Column(name = "UPDATED_AT")
    private LocalDate updatedAt;

    @Column(name = "CREATED_BY")
    private LocalDate createdBy;

    @Column(name = "UPDATED_BY")
    private LocalDate updatedBy;
}
