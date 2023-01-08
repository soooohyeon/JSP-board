package com.koreait.app;

public class Result {
	private boolean isRedirect; // false → forward / true → redirect
	private String path; // 경로
	
	public Result() {;}
	
	public boolean isRedirect() {
		return isRedirect;
	}
	public void setRedirect(boolean isRedirect) {
		this.isRedirect = isRedirect;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}

	@Override
	public String toString() {
		return "Result [isRedirect=" + isRedirect + ", path=" + path + "]";
	}
	
	
}
