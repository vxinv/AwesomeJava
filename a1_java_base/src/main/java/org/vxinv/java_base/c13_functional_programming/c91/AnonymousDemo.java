package org.vxinv.java_base.c13_functional_programming.c91;

import java.io.File;
import java.util.Arrays;
import java.util.Comparator;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class AnonymousDemo {
	public static void main(String[] args) {
		//列出当前目录下的所有后缀为.txt的文件
		File f = new File(".");
		File[] files = f.listFiles((dir, name) -> {
			if (name.endsWith(".txt")) {
				return true;
			}
			return false;
		});


		Arrays.sort(files, new Comparator<File>() {
			@Override
			public int compare(File f1, File f2) {
				return f1.getName().compareTo(f2.getName());
			}
		});
		ExecutorService executor = Executors.newFixedThreadPool(100);
		executor.submit(() -> System.out.println("hello world"));
	}

}
