package project.app.modelRD;

import javax.persistence.*;

@Entity
@Table(name = "Awards")
public class Awards {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private Long year;

    public Awards() {
    }

    public Awards(String name, Long year) {
        this.name = name;
        this.year = year;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getYear() {
        return year;
    }

    public void setYear(Long year) {
        this.year = year;
    }
}
