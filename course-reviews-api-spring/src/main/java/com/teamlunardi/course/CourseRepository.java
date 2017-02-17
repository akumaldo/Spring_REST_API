package com.teamlunardi.course;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by akumaldo on 2/16/17.
 */

public interface CourseRepository extends PagingAndSortingRepository<Course,Long> {

}
