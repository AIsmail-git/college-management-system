package za.ac.cput.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.util.Objects;

/***
 * Faculty.java
 * Entity for the Faculty
 * Author: Mbuso Kotobe (218040385)
 * Date: 06 April 2022
 */
@Entity
public class Faculty
{
    @Id
    @GeneratedValue
    @NotNull
    private long facultyId;

    @NotNull
    private String facultyName;

    @NotNull
    private String facultyDescription;

    protected Faculty(){ }

    private Faculty(Builder faculty)
    {
        this.facultyId = faculty.facultyId;
        this.facultyName = faculty.facultyName;
        this.facultyDescription = faculty.facultyDescription;
    }

    public long getFacultyId ()
    {
        return facultyId;
    }

    public String getFacultyName ()
    {
        return facultyName;
    }

    public String getFacultyDescription ()
    {
        return facultyDescription;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (!(o instanceof Faculty)) return false;
        Faculty faculty = (Faculty) o;
        return getFacultyId() == faculty.getFacultyId() && Objects.equals(getFacultyName(), faculty.getFacultyName()) && Objects.equals(getFacultyDescription(), faculty.getFacultyDescription());
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(getFacultyId(), getFacultyName(), getFacultyDescription());
    }

    @Override
    public String toString()
    {
        return "Faculty{" +
                "facultyId=" + facultyId +
                ", facultyName='" + facultyName + '\'' +
                ", facultyDescription='" + facultyDescription + '\'' +
                '}';
    }

    public static class Builder{
        long facultyId;
        String facultyName;
        String facultyDescription;

        public Builder setFacultyId (long facultyId)
        {
            this.facultyId = facultyId;
            return this;
        }

        public Builder setFacultyName (String facultyName)
        {
            this.facultyName = facultyName;
            return this;
        }

        public Builder setFacultyDescription (String facultyDescription)
        {
            this.facultyDescription = facultyDescription;
            return this;
        }

        public Builder copy(Faculty faculty)
        {
            this.facultyId = faculty.facultyId;
            this.facultyName = faculty.facultyName;
            this.facultyDescription = faculty.facultyDescription;
            return this;
        }

        public Faculty build()
        {
            return new Faculty(this);
        }
    }
}
