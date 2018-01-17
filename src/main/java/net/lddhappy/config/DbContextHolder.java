package net.lddhappy.config;

/**
 * Created by Liudongdong on 18/1/17.
 */
public class DbContextHolder {
    private static final ThreadLocal<Integer> PROJECT_ID = new ThreadLocal<>();

    public static void setProjectID(int projectID) {
        PROJECT_ID.set(projectID);
    }

    public static int getProjectID() {
        return PROJECT_ID.get().intValue();
    }

    public static void clearProjectID() {
        PROJECT_ID.remove();
    }
}
