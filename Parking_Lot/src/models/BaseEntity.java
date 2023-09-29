package models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class BaseEntity {

    private long id;

    public void setId(long id) {
        this.id = id;
    }
}
