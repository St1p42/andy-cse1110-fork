package nl.tudelft.cse1110.grader.util;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ClassUtils {

    /**
     * Extracts the class name out of the full class name
     * e.g., a.b.c.D return D
     * @param newClassName the full qualified class name
     * @return the class name
     */
    public static String extractClassName(String newClassName) {
        String[] packageAndClassName = newClassName.split("\\.");
        return packageAndClassName[packageAndClassName.length-1];
    }

    /**
     * Gets the name of the directory where a class is supposed to be
     * based on its package name
     * @param newClassName full qualified class name
     * @return directory
     */
    public static String extractDirectoryName(String newClassName) {
        List<String> packagesAndClass = new ArrayList<>(Arrays.asList(newClassName.split("\\.")));
        packagesAndClass.remove(packagesAndClass.size()-1);

        // TODO: '/' is OS dependant
        return packagesAndClass.stream().collect(Collectors.joining("/"));
    }

    /**
     * Receives the directory containing jar libraries, and returns
     * their list in the format that the JVM wants as classpath.
     *
     * @param librariesDir the full directory
     * @return string in the format of "/dir/dir/lib1.jar:/dir/dir/lib2.jar..."
     */
    public static String asClassPath(String librariesDir) {
        List<String> libraries = new ArrayList<>();

        File directoryPath = new File(librariesDir);
        File filesList[] = directoryPath.listFiles();
        for(File file : filesList) {
            libraries.add(file.getAbsolutePath());
        }

        return libraries.stream().collect(Collectors.joining(":"));
    }

    public static Class<?> getTestClass(List<String> newClasses) throws ClassNotFoundException {
        String className = newClasses.stream().filter(c -> c.contains("Test"))
                    .findFirst()
                    .get();

        return Class.forName(className);
    }

}
