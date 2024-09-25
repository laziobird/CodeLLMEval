package ai.next.dto;

public enum ResultCode {
    SUCC(200),
    FAIL_USER_AUTH(500), //用户名或者密码错误
    FAIL_INVALID_TOKEN(401),
    FAIL_SMSCODE(500),
    FAIL_FORBIDDEN(403),
    FAIL_REGISTER_USER_EXIST(444),
    FAIL_UNKNOWN(500),

    BIND_NOT_FOUND(601);


    private int code;

    private ResultCode(int value) {
        code = value;
    }

    public int getCode() {
        return code;
    }
}