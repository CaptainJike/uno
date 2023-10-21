package cc.allio.uno.data.orm.type;

import cc.allio.uno.data.orm.SQLAdapter;

/**
 * SQL 数据库类型适配器
 *
 * @author jiangwei
 * @date 2023/4/13 13:17
 * @since 1.1.4
 */
public interface DBTypeAdapter<T> extends SQLAdapter<T, DBType> {
}