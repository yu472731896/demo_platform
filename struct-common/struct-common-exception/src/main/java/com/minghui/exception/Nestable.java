package com.ropeok.exception;

import java.io.PrintStream;
import java.io.PrintWriter;

/**
 * @Author:chenql
 * @Description:
 * @Date:Created in 18:12 2019-04-03
 * @Modified By:
 */
public interface Nestable {

    Throwable getCause();

    String getMessage();

    String getMessage(int index);

    String[] getMessages();

    Throwable getThrowable(int index);

    int getThrowableCount();

    Throwable[] getThrowables();

    int indexOfThrowable(Class type);

    int indexOfThrowable(Class type, int fromIndex);

    void printStackTrace(PrintWriter out);

    void printStackTrace(PrintStream out);

    void printPartialStackTrace(PrintWriter out);
}
