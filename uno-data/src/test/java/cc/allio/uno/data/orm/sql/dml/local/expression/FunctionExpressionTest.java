package cc.allio.uno.data.orm.sql.dml.local.expression;

import cc.allio.uno.data.orm.dialect.func.Func;
import cc.allio.uno.data.orm.sql.Alias;
import cc.allio.uno.data.orm.sql.dml.local.SelectColumn;
import cc.allio.uno.test.BaseTestCase;
import org.junit.jupiter.api.Test;

class FunctionExpressionTest extends BaseTestCase {
    SelectColumn column = new SelectColumn("user_name", null, null);

    @Test
    void testMin() {
        FunctionExpression expression = new FunctionExpression(TestExpressionContext.INSTANCE, Func.MIN_FUNCTION.getName(), new Object[]{column});
        assertEquals("min(user_name)", expression.getSQL());
    }

    @Test
    void testMax() {
        FunctionExpression expression = new FunctionExpression(TestExpressionContext.INSTANCE, Func.MAX_FUNCTION.getName(), new Object[]{column});
        assertEquals("max(user_name)", expression.getSQL());
    }

    @Test
    void testCount() {
        FunctionExpression expression = new FunctionExpression(TestExpressionContext.INSTANCE, Func.COUNT_FUNCTION.getName(), new Object[]{column});
        assertEquals("count(user_name)", expression.getSQL());
    }

    @Test
    void testCountAlias() {
        FunctionExpression expression = new FunctionExpression(TestExpressionContext.INSTANCE, Func.COUNT_FUNCTION.getName(), new Object[]{column, new Alias("count")});
        assertEquals("count(user_name) count", expression.getSQL());
    }
}