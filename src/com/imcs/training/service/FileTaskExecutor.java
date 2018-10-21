package com.imcs.training.service;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import com.imcs.training.thread.FileLoaderTask;

public class FileTaskExecutor {
	public void executeTasks(String[] files) {

		ExecutorService executorService = Executors.newFixedThreadPool(5);

		for (String fileName : files) {
			executorService.execute(new FileLoaderTask(fileName));
		}

		System.out.println("Completed scheduling the jobs..");

		executorService.shutdown();

		try {
			executorService.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
		} catch (InterruptedException e) {
			System.out.println(e);
		}
	}

}
