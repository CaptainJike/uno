package cc.allio.uno.data.orm.sql.dml.local.expression;

import cc.allio.uno.data.orm.sql.PlainColumn;
import cc.allio.uno.test.BaseTestCase;
import org.junit.jupiter.api.Test;

class PlainExpressionTest extends BaseTestCase {

    @Test
    void testAlias() {
        PlainColumn column = new PlainColumn("test", null, null);
        PlainExpression expression = new PlainExpression(column, TestExpressionContext.INSTANCE);
        expression.alias("name");
        assertEquals("test AS name", expression.getSQL());
    }
}