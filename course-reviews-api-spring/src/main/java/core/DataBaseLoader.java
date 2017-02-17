package core;

import com.teamlunardi.course.Course;
import com.teamlunardi.course.CourseRepository;
import com.teamlunardi.review.Review;
import com.teamlunardi.user.User;
import com.teamlunardi.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

@Component
public class DataBaseLoader implements ApplicationRunner {
  private final CourseRepository courseRepository;
  private final UserRepository userRepository;
  private String[] buzzwords = {"mamama", "fufufu", "damamama", "nononono"};
  private String[] templates = {"Java", "Python", "JavaScript", "Mongol"};


  @Autowired
  public DataBaseLoader(CourseRepository courseRepository,UserRepository userRepository) {
    this.courseRepository = courseRepository;
    this.userRepository = userRepository;
  }

  @Override
  public void run(ApplicationArguments args) throws Exception {
    Course course = new Course("Java basics", "http://test1.com");
    course.addReview(new Review(3,  "you are a DOOOORK!!! "));
    courseRepository.save(course);
    List<User> students = Arrays.asList(
        new User("jacobproffer", "Jacob",  "Proffer", "password", new String[] {"ROLE_USER"}),
        new User("mlnorman", "Mike",  "Norman", "password", new String[] {"ROLE_USER"}),
        new User("k_freemansmith", "Karen",  "Freeman-Smith", "password", new String[] {"ROLE_USER"}),
        new User("seth_lk", "Seth",  "Kroger", "password", new String[] {"ROLE_USER"}),
        new User("mrstreetgrid", "Java",  "Vince", "password", new String[] {"ROLE_USER"}),
        new User("anthonymikhail", "Tony",  "Mikhail", "password", new String[] {"ROLE_USER"}),
        new User("boog690", "AJ",  "Teacher", "password", new String[] {"ROLE_USER"}),
        new User("faelor", "Erik",  "Faelor Shafer", "password", new String[] {"ROLE_USER"}),
        new User("christophernowack", "Christopher",  "Nowack", "password", new String[] {"ROLE_USER"}),
        new User("calebkleveter", "Caleb",  "Kleveter", "password", new String[] {"ROLE_USER"}),
        new User("richdonellan", "Rich",  "Donnellan", "password", new String[] {"ROLE_USER"}),
        new User("albertqerimi", "Albert",  "Qerimi", "password", new String[] {"ROLE_USER"})
    );
  List<Course> bunchOfCourses = new ArrayList<>();
    IntStream.range(0,100)
        .forEach(i -> {
          String template = templates[i % templates.length];
          String buzzword = buzzwords[i % buzzwords.length];
          String title = String.format(template,buzzword);
          Course c = new Course(title, "http://example.com");
          Review review = new Review((i % 5)+1, String.format("Moar %s please!!!", buzzword));
          review.setReviewer(students.get(i % students.size()));
          c.addReview(review);
          bunchOfCourses.add(c);
        });
    courseRepository.save(bunchOfCourses);
    userRepository.save(students);
    userRepository.save(new User("akumaldo", "Bruno", "Aldo", "12345", new String[]{"ROLE_USER", "ROLE_ADMIN"}));
  }
}
