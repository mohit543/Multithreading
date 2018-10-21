package com.imcs.training.thread;

import com.imcs.training.service.FileLoadService;
import com.imcs.training.service.FileLoadServiceApi;

public class FileLoaderTask implements Runnable {

	private String fileName;
	FileLoadServiceApi fileLoadServiceApi;
	FileLoadService fileLoadService;

	{
		fileLoadServiceApi = new FileLoadService();
		// fileLoadService = new FileLoadService();
	}

	public FileLoaderTask(String fileName) {
		super();
		this.fileName = fileName;

	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	@Override
	public void run() {
		fileLoadServiceApi.loadFile(fileName);
		fileLoadServiceApi.inDB();

	}

}
