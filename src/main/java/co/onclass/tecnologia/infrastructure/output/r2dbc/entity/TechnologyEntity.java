package co.onclass.tecnologia.infrastructure.output.r2dbc.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.time.Instant;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table("technology")
public class TechnologyEntity {

    @Id
    private UUID id;

    @Column("name")
    private String name;

    @Column("description")
    private String description;

    @CreatedDate
    @Column("created_at")
    private Instant createdAt;

    @LastModifiedDate
    @Column("updated_at")
    private Instant updatedAt;
}
