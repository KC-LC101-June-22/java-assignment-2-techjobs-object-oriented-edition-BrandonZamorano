package org.launchcode.techjobs.oo;

import java.util.Objects;

public class Job {

    private int id;
    private static int nextId = 1;

    private String name;
    private Employer employer;
    private Location location;
    private PositionType positionType;
    private CoreCompetency coreCompetency;

    public Job() {
        this.id = nextId;
        nextId++;
    }

    public Job(String name, Employer employer, Location location, PositionType positionType, CoreCompetency coreCompetency) {
        this();
        this.name = name;
        this.employer = employer;
        this.location = location;
        this.positionType = positionType;
        this.coreCompetency = coreCompetency;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Job job = (Job) o;
        return id == job.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }


    // TODO: Add getters for each field EXCEPT nextId. Add setters for each field EXCEPT nextID
    //  and id.
}
