package org.vxinv.java_base.a2_object_oriented.c24_exception_class;

// 第6章 异常

/**
 * 类异常及其子类是Throwable的一种形式，它指示合理的应用程序可能希望捕获的条件。
 * 类异常和任何不是RuntimeException子类的子类都是受控异常。
 * 如果可以通过执行方法或构造函数抛出Checked异常并在方法或构造函数边界之外传播，
 * 则需要在方法或构造函数的throws子句中声明Checked异常。
 */
public class AppException extends Exception {

	private static final long serialVersionUID = 1L;

	public AppException() {
        super();
    }

    public AppException(String message,
            Throwable cause) {
        super(message, cause);
    }

    public AppException(String message) {
        super(message);
    }

    public AppException(Throwable cause) {
        super(cause);
    }
}
