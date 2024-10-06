package com.dev.internal.personal.team.model;

import com.dev.internal.personal.department.model.Department;
import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(schema = "personal", name = "teams")
public class Team {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false)
    private String displayName;

    private String description;

    @Column(nullable = false)
    private Boolean isActive;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @ManyToOne(optional = false)
    @JoinColumn(name = "department_id")
    private Department department;
}
