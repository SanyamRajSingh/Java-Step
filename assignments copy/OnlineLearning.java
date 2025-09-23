package week7.assignments;

class Course {
    protected String title;
    protected String instructor;
    protected String enrollmentDate;

    public Course(String title, String instructor, String enrollmentDate) {
        this.title = title;
        this.instructor = instructor;
        this.enrollmentDate = enrollmentDate;
    }

    public void showProgress() {
        System.out.println("Course: " + title + "\nInstructor: " + instructor + "\nEnrollment Date: " + enrollmentDate);
    }
}

class VideoCourse extends Course {
    private int completionPercent;
    private int watchTime;

    public VideoCourse(String title, String instructor, String enrollmentDate, int completionPercent, int watchTime) {
        super(title, instructor, enrollmentDate);
        this.completionPercent = completionPercent;
        this.watchTime = watchTime;
    }

    @Override
    public void showProgress() {
        super.showProgress();
        System.out.println("Completion: " + completionPercent + "%\nWatch Time: " + watchTime + " minutes");
    }
}

class InteractiveCourse extends Course {
    private int quizScores;
    private int projectsCompleted;

    public InteractiveCourse(String title, String instructor, String enrollmentDate, int quizScores, int projectsCompleted) {
        super(title, instructor, enrollmentDate);
        this.quizScores = quizScores;
        this.projectsCompleted = projectsCompleted;
    }

    @Override
    public void showProgress() {
        super.showProgress();
        System.out.println("Quiz Scores: " + quizScores + "\nProjects Completed: " + projectsCompleted);
    }
}

class ReadingCourse extends Course {
    private int pagesRead;
    private int notesTaken;

    public ReadingCourse(String title, String instructor, String enrollmentDate, int pagesRead, int notesTaken) {
        super(title, instructor, enrollmentDate);
        this.pagesRead = pagesRead;
        this.notesTaken = notesTaken;
    }

    @Override
    public void showProgress() {
        super.showProgress();
        System.out.println("Pages Read: " + pagesRead + "\nNotes Taken: " + notesTaken);
    }
}

class CertificationCourse extends Course {
    private int examAttempts;
    private boolean certified;

    public CertificationCourse(String title, String instructor, String enrollmentDate, int examAttempts, boolean certified) {
        super(title, instructor, enrollmentDate);
        this.examAttempts = examAttempts;
        this.certified = certified;
    }

    @Override
    public void showProgress() {
        super.showProgress();
        System.out.println("Exam Attempts: " + examAttempts + "\nCertified: " + (certified ? "Yes" : "No"));
    }
}

public class OnlineLearning {
    public static void main(String[] args) {
        Course[] courses = new Course[] {
                new VideoCourse("Java Basics", "Alice", "2025-01-01", 80, 120),
                new InteractiveCourse("Data Structures", "Bob", "2025-02-15", 85, 3),
                new ReadingCourse("Algorithms", "Carol", "2025-03-10", 150, 20),
                new CertificationCourse("Cybersecurity", "Dave", "2025-04-05", 2, true)
        };

        for (Course course : courses) {
            course.showProgress();
            System.out.println();
        }
    }
}
