package com.teamlunardi.review;

import com.teamlunardi.course.Course;
import com.teamlunardi.user.User;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import core.BaseEntity;

@Entity
public class Review extends BaseEntity{

  private String description;
  private int rating;

  @ManyToOne
  private Course course;

  @ManyToOne
  private User reviewer;

  public Review(int rating,String description) {
    this.description = description;
    this.rating = rating;
  }


  protected Review()
  {
    super();
  }

  public User getReviewer() {
    return reviewer;
  }

  public void setReviewer(User reviewer) {
    this.reviewer = reviewer;
  }

  public void setCourse(Course course) {
    this.course = course;
  }

  public Course getCourse() {
    return course;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public int getRating() {
    return rating;
  }

  public void setRating(int rating) {
    this.rating = rating;
  }


}
