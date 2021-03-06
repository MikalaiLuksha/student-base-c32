package by.tms.domain;

import java.util.Objects;

public class Student extends UsersOfStudentBase {

	private String faculty;
	private String group;

	public Student(long id, String name, String login, String password, String faculty, String group) {
		super(id, name, login, password);
		this.faculty = faculty;
		this.group = group;
	}

	public String getFaculty() {
		return faculty;
	}

	public void setFaculty(String faculty) {
		this.faculty = faculty;
	}

	public String getGroup() {
		return group;
	}

	public void setGroup(String group) {
		this.group = group;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		if (!super.equals(o)) return false;

		Student student = (Student) o;

		if (faculty != null ? !faculty.equals(student.faculty) : student.faculty != null) return false;
		return group != null ? group.equals(student.group) : student.group == null;
	}

	@Override
	public int hashCode() {
		int result = super.hashCode();
		result = 31 * result + (faculty != null ? faculty.hashCode() : 0);
		result = 31 * result + (group != null ? group.hashCode() : 0);
		return result;
	}

	@Override
	public String toString() {
		return "Student{" +
				"faculty='" + faculty + '\'' +
				", group='" + group + '\'' +
				'}';
	}
}
