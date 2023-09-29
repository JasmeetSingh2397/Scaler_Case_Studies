package com.scaler.bookmyshow.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Entity(name= "shows")
@Getter
@Setter
public class Show extends BaseModel{

    @ManyToOne
    private Movie movie;

    private Date startTime;
    private Date EndTime;

    @ManyToOne
    private Screen screen;

    @Enumerated(EnumType.ORDINAL)
    @ElementCollection
    private List<Feature> features;


}
