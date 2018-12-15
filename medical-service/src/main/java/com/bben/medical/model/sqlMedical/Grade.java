package com.bben.medical.model.sqlMedical;

import java.io.Serializable;

public class Grade implements Serializable {
    private Integer id;

    private String grade;

    private String gradecolor;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade == null ? null : grade.trim();
    }

    public String getGradecolor() {
        return gradecolor;
    }

    public void setGradecolor(String gradecolor) {
        this.gradecolor = gradecolor == null ? null : gradecolor.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", grade=").append(grade);
        sb.append(", gradecolor=").append(gradecolor);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}