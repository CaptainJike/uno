package cc.allio.uno.data.orm.executor.influxdb;

import cc.allio.uno.core.exception.Exceptions;
import cc.allio.uno.data.orm.dsl.type.DBType;
import cc.allio.uno.data.orm.executor.CommandExecutorLoader;
import cc.allio.uno.data.orm.executor.interceptor.Interceptor;
import cc.allio.uno.data.orm.executor.options.ExecutorOptions;

import java.util.List;

/**
 * load influxdb command executor
 *
 * @author j.x
 * @date 2024/4/1 17:21
 * @since 1.1.8
 */
public class InfluxdbCommandExecutorLoader implements CommandExecutorLoader<InfluxdbCommandExecutor> {

    @Override
    public InfluxdbCommandExecutor load(List<Interceptor> interceptors) {
        throw Exceptions.unOperate("load by interceptors");
    }

    @Override
    public InfluxdbCommandExecutor load(ExecutorOptions executorOptions) {
        return new InfluxdbCommandExecutor(executorOptions);
    }

    @Override
    public boolean match(DBType dbType) {
        return DBType.INFLUXDB == dbType;
    }
}