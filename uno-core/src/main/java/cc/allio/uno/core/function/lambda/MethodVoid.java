package cc.allio.uno.core.function.lambda;

import cc.allio.uno.core.function.VoidConsumer;

/**
 * 基于函数式接口的Lambda实现
 * <p>该接口包含能够获取Lambda方法名、字段名、Lambda方法的序列化信息等。</p>
 *
 * @author jiangwei
 * @date 2024/2/11 10:46
 * @since 1.1.6
 */
@FunctionalInterface
public interface MethodVoid extends VoidConsumer, LambdaMethod {
}
