package cc.allio.uno.core.function.lambda;

import java.util.function.BiPredicate;

/**
 * 基于函数式接口的Lambda实现
 * <p>该接口包含能够获取Lambda方法名、字段名、Lambda方法的序列化信息等。</p>
 *
 * @author jiangwei
 * @date 2024/2/11 10:48
 * @see BiPredicate
 * @since 1.1.7
 */
@FunctionalInterface
public interface MethodBiPredicate<T, U> extends BiPredicate<T, U>, LambdaMethod {
}
