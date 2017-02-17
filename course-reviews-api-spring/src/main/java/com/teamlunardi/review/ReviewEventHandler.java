package com.teamlunardi.review;

import com.teamlunardi.user.User;
import com.teamlunardi.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.core.annotation.HandleBeforeCreate;
import org.springframework.data.rest.core.annotation.RepositoryEventHandler;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;


/**
 * Created by akumaldo on 2/17/17.
 */

@Component
@RepositoryEventHandler
public class ReviewEventHandler {

  private final UserRepository users;

  @Autowired
  public ReviewEventHandler(UserRepository users) {
    this.users = users;
  }

  @HandleBeforeCreate
  public void addReviewerBasedOnLoggedInUser(Review review){
    String username = SecurityContextHolder.getContext().getAuthentication().getName();
    User user = users.findByUsername(username);
    review.setReviewer(user);
  }
}
