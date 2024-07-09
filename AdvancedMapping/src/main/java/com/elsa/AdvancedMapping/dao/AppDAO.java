package com.elsa.AdvancedMapping.dao;

import com.elsa.AdvancedMapping.entity.Instructor;
public interface AppDAO {

    void save(Instructor theInstructor);

    Instructor findInstructorById(int theId);

    void deleteInstructorById(int theId);
}
