package cc.allio.uno.data.orm.dsl.type;

import cc.allio.uno.core.type.Types;

import java.util.Map;

/**
 * map
 *
 * @author j.x
 * @date 2023/4/16 16:59
 * @since 1.1.4
 */
public class MapJavaType extends JavaTypeImpl<Map> {
    @Override
    public Class<Map> getJavaType() {
        return Types.MAP;
    }

    @Override
    public boolean equalsTo(Class<?> otherJavaType) {
        return Map.class.isAssignableFrom(otherJavaType);
    }
}
