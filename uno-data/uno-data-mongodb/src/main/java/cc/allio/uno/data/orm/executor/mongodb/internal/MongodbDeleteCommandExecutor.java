package cc.allio.uno.data.orm.executor.mongodb.internal;

import cc.allio.uno.auto.service.AutoService;
import cc.allio.uno.core.exception.Exceptions;
import cc.allio.uno.data.orm.dsl.Table;
import cc.allio.uno.data.orm.dsl.mongodb.dml.MongodbDeleteOperator;
import cc.allio.uno.data.orm.executor.CommandExecutor;
import cc.allio.uno.data.orm.executor.ResultGroup;
import cc.allio.uno.data.orm.executor.ResultRow;
import cc.allio.uno.data.orm.executor.handler.BoolResultHandler;
import cc.allio.uno.data.orm.executor.handler.ResultSetHandler;
import cc.allio.uno.data.orm.executor.internal.DOInnerCommandExecutor;
import cc.allio.uno.data.orm.executor.options.ExecutorKey;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.result.DeleteResult;
import lombok.extern.slf4j.Slf4j;
import org.bson.Document;

/**
 * mongodb delete command executor
 *
 * @author j.x
 * @date 2024/3/15 11:30
 * @since 1.1.7
 */
@Slf4j
@AutoService(DOInnerCommandExecutor.class)
@CommandExecutor.Group(ExecutorKey.MONGODB_LITERAL)
public class MongodbDeleteCommandExecutor implements DOInnerCommandExecutor<MongodbDeleteOperator> {

    final MongoDatabase database;

    public MongodbDeleteCommandExecutor(MongoDatabase database) {
        this.database = database;
    }

    @Override
    public Boolean doExec(MongodbDeleteOperator operator, ResultSetHandler<Boolean> handler) throws Throwable {
        Table fromColl = operator.getTable();
        if (fromColl == null) {
            throw Exceptions.unNull("from collection is empty");
        }
        ResultGroup resultGroup = new ResultGroup();
        ResultRow.ResultRowBuilder builder = ResultRow.builder();
        builder.column(BoolResultHandler.GUESS_UPDATE_OR_UPDATE);
        MongoCollection<Document> collection = database.getCollection(fromColl.getName().format());
        DeleteResult deleteResult = collection.deleteMany(operator.getFilter());
        boolean success = deleteResult.wasAcknowledged() && deleteResult.getDeletedCount() > 0;
        builder.value(success);
        ResultRow row = builder.build();
        resultGroup.addRow(row);
        return handler.apply(resultGroup);
    }
}
