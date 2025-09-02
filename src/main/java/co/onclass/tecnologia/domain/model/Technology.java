package co.onclass.tecnologia.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Technology {
    private UUID id;
    private String name;
    private String description;
}
