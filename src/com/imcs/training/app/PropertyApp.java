package com.imcs.training.app;

public class PropertyApp {

	public static void main(String[] args) {
		String[] files = new String[] { "D:\\IMCS\\PropertyMultithreading\\src\\resources\\PropertyInfo.csv",
				"D:\\IMCS\\PropertyMultithreading\\src\\resources\\PropertyInfo1.csv",
				"D:\\IMCS\\PropertyMultithreading\\src\\resources\\PropertyInfo2.csv",
				"D:\\IMCS\\PropertyMultithreading\\src\\resources\\PropertyInfo3.csv",
				"D:\\IMCS\\PropertyMultithreading\\src\\resources\\PropertyInfo4.csv" };
		long startTime = System.nanoTime();

		FileLoaderTaskExecutor fileLoaderTaskExecutor = new FileLoaderTaskExecutor();
		fileLoaderTaskExecutor.executeTasks(files);

		long endTime = System.nanoTime();
		long duration = (endTime - startTime);
		System.out.println("Total time: " + duration);

	}

}
