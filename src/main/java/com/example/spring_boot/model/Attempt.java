package com.example.spring_boot.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.util.Date;

@Entity
@Table(name = "attempt")
public class Attempt {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "x")
    private float x;

    @Column(name = "y")
    private float y;

    @Column(name = "r")
    @Min(value = 3, message = "R must be greater or equal than 3")
    @Max(value = 5, message = "R must be less than or equal to 5")
    private float r;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private Person owner;

    @Column(name = "date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateOfHit;

    @Column(name = "time")
    private long timeWork;

    @Column(name = "hit")
    private boolean hit;

    public Attempt() {
    }

    public Attempt(float x, float y, float r) {
        this.x = x;
        this.y = y;
        this.r = r;
    }

    public long getTimeWork() {
        return timeWork;
    }

    public void setTimeWork(long timeWork) {
        this.timeWork = timeWork;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public float getR() {
        return r;
    }

    public void setR(float r) {
        this.r = r;
    }

    public Person getOwner() {
        return owner;
    }

    public void setOwner(Person owner) {
        this.owner = owner;
    }

    public Date getDateOfHit() {
        return dateOfHit;
    }

    public void setDateOfHit(Date dateOfHit) {
        this.dateOfHit = dateOfHit;
    }

    public boolean isHit() {
        return hit;
    }

    public void setHit(boolean hit) {
        this.hit = hit;
    }

    @Override
    public String toString() {
        return "Attempt{"
                + "                             id=" + id
                + ",                             x=" + x
                + ",                             y=" + y
                + ",                             r=" + r
                + ",                             owner=" + owner
                + ",                             dateOfHit=" + dateOfHit
                + ",                             timeWork=" + timeWork
                + ",                             hit=" + hit
                + '}';
    }
}
