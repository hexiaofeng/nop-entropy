package io.nop.batch.orm.loader;

import io.nop.api.core.beans.query.QueryBean;
import io.nop.batch.core.IBatchChunkContext;
import io.nop.batch.core.IBatchLoader;
import io.nop.batch.core.IBatchTaskContext;
import io.nop.batch.core.IBatchTaskListener;
import io.nop.dao.api.IDaoEntity;
import io.nop.dao.api.IDaoProvider;
import io.nop.dao.api.IEntityDao;
import io.nop.dao.api.IQueryBuilder;

import javax.inject.Inject;
import java.util.List;

public class OrmQueryBatchLoader<S extends IDaoEntity> implements IBatchLoader<S, IBatchChunkContext>, IBatchTaskListener {

    private IQueryBuilder queryBuilder;

    private IDaoProvider daoProvider;

    private S lastEntity;
    private QueryBean query;

    @Inject
    public void setDaoProvider(IDaoProvider daoProvider) {
        this.daoProvider = daoProvider;
    }

    public void setQueryBuilder(IQueryBuilder queryBuilder) {
        this.queryBuilder = queryBuilder;
    }

    @Override
    public void onTaskBegin(IBatchTaskContext context) {
        query = queryBuilder.buildQuery(context);
        lastEntity = null;
    }

    @Override
    public void onTaskEnd(Throwable exception, IBatchTaskContext context) {
        query = null;
        lastEntity = null;
    }

    @Override
    public List<S> load(int batchSize, IBatchChunkContext context) {
        IEntityDao<S> dao = daoProvider.dao(query.getSourceName());
        List<S> list = dao.findNext(lastEntity, query.getFilter(), query.getOrderBy(), batchSize);

        if (list.isEmpty()) {
            return list;
        }

        lastEntity = list.get(list.size() - 1);
        return list;
    }
}