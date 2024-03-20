package cc.allio.uno.rule.exception;

/**
 * 结果集运行时异常
 *
 * @author j.x
 * @date 2023/4/25 10:30
 * @since 1.1.4
 */
public class RuleResultRuntimeException extends RuntimeException {

    public RuleResultRuntimeException() {
        super();
    }

    public RuleResultRuntimeException(String message) {
        super(message);
    }

    public RuleResultRuntimeException(String message, Throwable cause) {
        super(message, cause);
    }

    public RuleResultRuntimeException(Throwable cause) {
        super(cause);
    }
}
