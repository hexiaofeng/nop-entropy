package io.nop.graphql.core.engine;

import io.nop.core.lang.json.JsonTool;
import io.nop.core.resource.IResource;
import io.nop.core.resource.impl.ClassPathResource;
import io.nop.graphql.core.ast.GraphQLFieldDefinition;
import io.nop.graphql.core.ast.GraphQLObjectDefinition;
import io.nop.graphql.core.ast.GraphQLOperationType;
import io.nop.graphql.core.ast.GraphQLType;
import io.nop.graphql.core.fetcher.BeanPropertyFetcher;
import io.nop.graphql.core.fetcher.ServiceActionFetcher;
import io.nop.graphql.core.model.IGraphQLSchemaLoader;
import io.nop.graphql.core.model.TypeRegistry;
import io.nop.graphql.core.parse.GraphQLDocumentHelper;
import io.nop.graphql.core.reflection.GraphQLBizModels;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class MockGraphQLSchemaLoader implements IGraphQLSchemaLoader {
    private Map<String, GraphQLObjectDefinition> defs;
    private TypeRegistry typeRegistry = new TypeRegistry();

    private GraphQLBizModels bizModels = new GraphQLBizModels();

    public MockGraphQLSchemaLoader() {
        IResource resource = new ClassPathResource("classpath:io/nop/graphql/core/engine/test.graphql");
        defs = GraphQLDocumentHelper.parseObjectDefinitions(resource);

        List<Object> beans = Arrays.asList(new MyEntityBizModel(), new MyChildBizModel());

        bizModels.build(typeRegistry, beans);

        System.out.println(JsonTool.serialize(bizModels, true));

        for (GraphQLObjectDefinition def : defs.values()) {
            bizModels.customize(def);
        }

        for (GraphQLObjectDefinition objDef : defs.values()) {
            objDef.init();
            for (GraphQLFieldDefinition fieldDef : objDef.getFields()) {
                if (fieldDef.getFetcher() == null) {
                    if (fieldDef.getServiceAction() != null) {
                        fieldDef.setFetcher(new ServiceActionFetcher(fieldDef.getServiceAction()));
                    } else {
                        fieldDef.setFetcher(BeanPropertyFetcher.INSTANCE);
                    }
                }
            }
        }
    }

    private void merge(GraphQLObjectDefinition obj) {
        GraphQLObjectDefinition old = defs.get(obj.getName());
        old.merge(obj);
    }

    @Override
    public GraphQLFieldDefinition getOperationDefinition(GraphQLOperationType opType, String name) {
        return bizModels.getOperationDefinition(opType, name);
    }

    @Override
    public GraphQLObjectDefinition getTypeDefinition(String objName) {
        return defs.get(objName);
    }

    @Override
    public GraphQLObjectDefinition resolveTypeDefinition(GraphQLType type) {
        return defs.get(type.getObjTypeName());
    }
}