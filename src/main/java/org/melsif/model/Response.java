package org.melsif.model;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;
import lombok.Data;

@Data
@Entity
public class Response {
    
    @Id
    @GeneratedValue
    @Column(name = "id", updatable = false, nullable = false)
    private Integer id;
    private String content;
    private Boolean isActive;
    
    @OneToMany(
        mappedBy = "response",
        cascade = CascadeType.ALL,
        orphanRemoval = true
    )
    private List<OrderResponse> orderR = new ArrayList<>();
}
