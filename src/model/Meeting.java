package model;

import java.io.Serializable;
import java.util.ArrayList;

public class Meeting implements Serializable {
    private ArrayList<String> people;
    private Boolean status;
    private String location;
    private String start;
    private String duration;

    private Meeting(Builder builder) {
        this.people = builder.people;
        this.status = builder.status;
        this.location = builder.location;
        this.start = builder.start;
        this.duration = builder.duration;
    }

    public String getString() {
        return String.valueOf(this.start) + " " + String.valueOf(this.duration) + "min " + location + " " + people.toString();
    }

    public String getStatusStr() {
        if (status) {
            return "activated";
        }
        return "closed";
    }

    public void open() {
        this.status = true;
    }

    public void close() {
        this.status = false;
    }

    public Boolean getStatus() {
        return status;
    }

    public static class Builder {
        private ArrayList<String> people;
        private Boolean status;
        private String location;
        private String start;
        private String duration;

        public Builder people(ArrayList<String> people) {
            this.people = people;
            return this;
        }

        public Builder status(Boolean status) {
            this.status = status;
            return this;
        }

        public Builder location(String location) {
            this.location = location;
            return this;
        }

        public Builder start(String start) {
            this.start = start;
            return this;
        }

        public Builder duration(String duration) {
            this.duration = duration;
            return this;
        }

        public Meeting build() {
            return new Meeting(this);
        }
    }
}
