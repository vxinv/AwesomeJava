package org.vxinv.java_base.a4_file_operation.c59_file_utils;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class FileUtils {

    public static String path = ".";

    public static void listTextFiles() throws IOException {
        File f = new File(".");
        File[] files = f.listFiles(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                /*if (name.endsWith(".text")) {
                    return true;
                }*/
                return true;
            }
		});
		for (File file : files) {
			System.out.println(file.getCanonicalPath());
		}
	}

	public static long sizeOfDirectory(final File directory) {
		long size = 0;
		if (directory.isFile()) {
			return directory.length();
		} else {
            for (File file : directory.listFiles()) {
                if (file.isFile()) {
                    size += file.length();
                } else {
                    size += sizeOfDirectory(file);
                }
            }
        }
        return size;
    }

    @Test
    public void testSizeOfDirectory() {
        File file = new File(path);
        try {
            System.out.println(file.getCanonicalPath());
        } catch (IOException e) {
            e.printStackTrace();
        }
        long l = sizeOfDirectory(file);
        double d = (double) Math.round(l / 1024D / 1024D / 1024D * 100) / 100;
        System.out.println(d + "G");
    }

    public static Collection<File> findFile(final File directory,
                                            final String fileName) {
        List<File> files = new ArrayList<>();
        for (File f : directory.listFiles()) {
            if (f.isFile() && f.getName().equals(fileName)) {
                files.add(f);
            } else if (f.isDirectory()) {
                files.addAll(findFile(f, fileName));
            }
		}
		return files;
	}

	public static void deleteRecursively(final File file) throws IOException {
		if (file.isFile()) {
			if (!file.delete()) {
				throw new IOException("Failed to delete "
						+ file.getCanonicalPath());
			}
		} else if (file.isDirectory()) {
			for (File child : file.listFiles()) {
				deleteRecursively(child);
			}
			if (!file.delete()) {
				throw new IOException("Failed to delete "
						+ file.getCanonicalPath());
			}
		}
	}


    /**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		//System.out.println(sizeOfDirectory(new File("C:\\Users\\Administrator\\.m2")));
        listTextFiles();
	}

}
