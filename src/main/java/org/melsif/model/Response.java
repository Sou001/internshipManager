package org.melsif.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.persistence.*;
import lombok.Data;
import org.hibernate.annotations.NaturalId;

@Data
@Entity
public class Response {
    
    @Id
    @GeneratedValue
    @Column(name = "id", updatable = false, nullable = false)
    private Integer id;
    @NaturalId
    private String content;
    private Boolean isActive;
    
    @OneToMany(
        mappedBy = "response",
        cascade = CascadeType.ALL,
        orphanRemoval = true
    )
    private List<OrderResponse> orderResponses = new ArrayList<>();
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Response response = (Response) o;
        return Objects.equals(content, response.content);
    }
 
    @Override
    public int hashCode() {
        return Objects.hash(content);
    }
}
