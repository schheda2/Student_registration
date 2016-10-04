package com.example.himanshu.studentregistrationform;

import java.io.Serializable;

/**
 * Created by Himanshu on 9/6/2016.
 */
public class Student implements Serializable {
String name, email_address, department;
    int mood;

public String toString()
{
    return name;
}

public Student(String name, String email_address, String department, int mood)
{
    super();
    this.name=name;
    this.email_address=email_address;
    this.department=department;
    this.mood=mood;
}

    public Student()
    {
    }

}
