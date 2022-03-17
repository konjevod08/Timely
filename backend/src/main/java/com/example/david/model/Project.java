package com.example.david.model;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.time.Period;

@Entity
@Table(name="Projects")
public class Project implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "startingDate")
    private Date startingDate;
    @Column(name = "endingDate")
    private Date endingDate;
    @Column(name = "duration")
    private String duration;

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {

        this.duration = duration;
    }

    public Project(String name) {
        this.name = name;
    }

    public Project(String name, Date startingDate, Date endingDate) {
        this.name = name;
        this.startingDate = startingDate;
        this.endingDate = endingDate;
    }

    public Project() {
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getStartingDate() {
        return startingDate;
    }

    public void setStartingDate(Date startingDate) {
        this.startingDate = startingDate;
    }

    public Date getEndingDate() {
        return endingDate;
    }

    public void setEndingDate(Date endingDate) {
        this.endingDate = endingDate;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
