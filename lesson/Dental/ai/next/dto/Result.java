package ai.next.dto;

import lombok.Data;
import java.io.Serializable;

@Data
public class Result<T> implements Serializable {
    private int code;
    private String msg;
    private String detailMsg;
    private T data;

    public static <T> Result<T> succ(T data) {
        return succ(200, "Success", data);
    }

    public static <T> Result<T> succ(int code, String msg, T data) {
        Result r = new Result();
        r.setCode(code);
        r.setMsg(msg);
        r.setData(data);
        return r;
    }

    public static <T> Result<T> succMsg(String detailMsg) {
        Result r = new Result();
        //前端 msg + detailMsg
        r.setCode(200);
        r.setMsg(" ");
        r.setDetailMsg(detailMsg);
        return r;
    }

    public static <T> Result<T> succ(ResultCode code, String msg, T data){
        return succ(code.getCode(), msg, data);
    }

    public static <T> Result<T> fail(String msg) {
        return fail(500, msg, null);
    }

    public static <T> Result<T> failDetail(String detailMsg) {
        return fail(500, "系统异常",detailMsg, null);
    }

    public static <T> Result<T> fail(ResultCode code, String msg) {
        return fail(code, msg, null);
    }

    public static <T> Result<T> fail(int code, String msg, T data) {
        Result r = new Result();
        r.setCode(code);
        r.setMsg(msg);
        r.setData(data);
        return r;
    }

    public static <T> Result<T> fail(int code, String msg,String detailMsg, T data) {
        Result r = new Result();
        r.setCode(code);
        r.setMsg(msg);
        r.setData(data);
        r.setDetailMsg(detailMsg);
        return r;
    }

    public static <T> Result<T> fail(ResultCode code, String msg, T data) {
        return fail(code.getCode(), msg, data);
    }
}