package org.english.englishonlinecourse.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import java.time.Instant;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "level")
public class Level {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "level_id_gen")
    @SequenceGenerator(name = "level_id_gen", sequenceName = "level_level_id_seq", allocationSize = 1)
    @Column(name = "level_id", nullable = false)
    private Long id;

    @Column(name = "public_id", nullable = false, length = 50, insertable = false, updatable = false)
    @ColumnDefault("('LVL-'::text || gen_random_uuid())")
    private String publicId;

    @Column(name = "name", nullable = false, length = Integer.MAX_VALUE)
    private String name;

    @Column(name = "description", length = Integer.MAX_VALUE)
    private String description;

    @ColumnDefault("now()")
    @Column(name = "created_at", insertable = false, updatable = false)
    private Instant createdAt;

    @Column(name = "updated_at", insertable = false)
    private Instant updatedAt;

    @Column(name = "status", nullable = false, length = 20)
    @ColumnDefault("'DRAFT'")
    private String status = "DRAFT";
}