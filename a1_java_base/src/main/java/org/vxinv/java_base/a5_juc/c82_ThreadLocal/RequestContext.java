package org.vxinv.java_base.a5_juc.c82_ThreadLocal;

public class RequestContext {
	public static class Request { //...
	};

	private static ThreadLocal<String> localUserId = new ThreadLocal<>();
	private static final ThreadLocal<Request> localRequest = new ThreadLocal<>();

	public static String getCurrentUserId() {
		return localUserId.get();
	}

	public static void setCurrentUserId(String userId) {
		localUserId.set(userId);
	}

	public static Request getCurrentRequest() {
		return localRequest.get();
	}

	public static void setCurrentRequest(Request request) {
		localRequest.set(request);
	}
}
