package introduction.lambda;

import java.io.File;
import java.io.FileFilter;

// Classic use of the Functional interface from java.io.FileFilter
public class FileFilterLambda implements FileFilter {
    @Override
    public boolean accept(File pathname) {
        return pathname.getName().endsWith(".java");
    }

    // Examples of Use
    public static void main(String[] args) {
        File dir = new File("./src/main/java/introduction/lambda");

        //Example classic class implement
        FileFilterLambda fileFilter = new FileFilterLambda();
        File[] javaFiles = dir.listFiles(fileFilter);

        //Example with anonymous
        FileFilter fileFilterAnonymous = new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                return pathname.getName().endsWith(".java");
            }
        };
        File[] javaFilesWithAnonymous = dir.listFiles(fileFilterAnonymous);

        //Example Lambda
        FileFilter fileFilterLambda = (File pathname) -> pathname.getName().endsWith(".java");
        File[] javaFilesWithLambda = dir.listFiles(fileFilterAnonymous);
        if(javaFilesWithLambda != null) {
            for (File f : javaFilesWithLambda) {
                System.out.println(f);
            }
        }
    }
}
