package nl.devpieter.marathon.utils;

import org.jetbrains.annotations.NotNull;

import java.io.File;

public class FileUtils {

    public static boolean tryCreateDirectories(@NotNull File file) {
        try {
            File parentDir = file.getParentFile();
            if (parentDir.exists()) return true;

            return parentDir.mkdirs();
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean tryCreateFile(@NotNull File file) {
        try {
            if (file.exists()) return true;
            if (!tryCreateDirectories(file)) return false;

            return file.createNewFile();
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean doesFileExist(@NotNull File file) {
        return file.exists() && file.isFile();
    }
}
