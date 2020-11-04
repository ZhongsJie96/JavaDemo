package java8.lambda.functionIterface;

@FunctionalInterface
public interface StudentFilter {
    boolean compare(Student student);
}
