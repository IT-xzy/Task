package yxpTask6.util;

import org.springframework.stereotype.Component;

/*
* @Param message 出错信息
* @Param cause 出错原因
* */

public class TaskException extends Exception
{

    public TaskException(String message)
    {
        super(message);
    }

//    Task6Exception(String message,Throwable cause)
//    {
//        super(message,cause);
//    }
}
