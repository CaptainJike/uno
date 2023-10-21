package cc.allio.uno.core.type;

/**
 * Boolean类型转换器，可能抛出NumberFormatException异常
 *
 * @author jiangwei
 * @date 2021/12/23 20:10
 * @since 1.0
 */
public class BooleanCalculateOperator extends UnsupportedCalculateOperator {
    @Override
    public Object convert(Object target, Class<?> maybeType) {
        return Boolean.parseBoolean(target.toString());
    }

    @Override
    public String fromString(Object target) {
        return convert(target, Boolean.class).toString();
    }

    @Override
    public Object defaultValue() {
        return Boolean.FALSE;
    }

    @Override
    public Class<?> getType() {
        return Types.BOOLEAN;
    }
}