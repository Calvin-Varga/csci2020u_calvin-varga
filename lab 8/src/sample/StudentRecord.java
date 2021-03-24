package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class StudentRecord {
    private String sid;
    private float midterm;
    private float assignments;
    private float finalExam;
    private double finalGrade;
    private String letGrade;

    public StudentRecord(String sid, float assignments, float midterm, float finalExam){
        this.sid = sid;
        this.midterm = midterm;
        this.assignments = assignments;
        this.finalExam = finalExam;

        this.finalGrade = (assignments * .2) + (midterm * .3) + (finalExam * .5);

        if (finalGrade >= 80){
            this.letGrade = "A";
        }
        else if ((finalGrade >= 70) && (finalGrade <= 79)){
            this.letGrade = "B";
        }
        else if ((finalGrade >= 60) && (finalGrade <= 69)){
            this.letGrade = "C";
        }
        else if ((finalGrade >= 50) && (finalGrade <= 59)){
            this.letGrade = "D";
        }
        else{
            this.letGrade = "F";
        }

    }


    public String getSid(){return sid;    }
    public float getMidterm(){return midterm;    }
    public float getAssignments(){return assignments;    }
    public float getFinalExam(){return finalExam;    }
    public double getFinalGrade(){return finalGrade;}
    public String getLetGrade(){return letGrade;}





}