package com.elsa.AdvancedMapping.dao;

import com.elsa.AdvancedMapping.entity.Instructor;
import com.elsa.AdvancedMapping.entity.InstructorDetail;

public interface AppDAO {

    void save(Instructor theInstructor);

    Instructor findInstructorById(int theId);

    void deleteInstructorById(int theId);

    InstructorDetail findInstructorDetailById(int theId);

    void deleteInstructorDetailById(int theId);
}
