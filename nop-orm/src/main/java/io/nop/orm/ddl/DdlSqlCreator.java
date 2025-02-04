/**
 * Copyright (c) 2017-2023 Nop Platform. All rights reserved.
 * Author: canonical_entropy@163.com
 * Blog:   https://www.zhihu.com/people/canonical-entropy
 * Gitee:  https://gitee.com/canonical-entropy/nop-chaos
 * Github: https://github.com/entropy-cloud/nop-chaos
 */
package io.nop.orm.ddl;

import io.nop.dao.dialect.DialectManager;
import io.nop.dao.dialect.IDialect;
import io.nop.orm.model.IEntityModel;
import io.nop.xlang.api.XLang;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class DdlSqlCreator {
    private final String dmlLibPath;
    private final IDialect dialect;

    public DdlSqlCreator(String dialectName) {
        this.dmlLibPath = "/nop/orm/xlib/ddl/ddl_" + dialectName + ".xlib";
        this.dialect = DialectManager.instance().getDialect(dialectName);
    }

    public DdlSqlCreator(String dialectName, IDialect dialect) {
        this.dmlLibPath = "/nop/orm/xlib/ddl/ddl_" + dialectName + ".xlib";
        this.dialect = dialect;
    }

    public DdlSqlCreator(IDialect dialect) {
        this(dialect.getName(), dialect);
    }

    public static DdlSqlCreator forDialect(String dialectName) {
        return new DdlSqlCreator(dialectName);
    }

    public String createTable(IEntityModel table) {
        return createTable(table, false);
    }

    public String createTables(Collection<? extends IEntityModel> tables, boolean includeComments) {
        return createTables(tables, false, includeComments);
    }

    public String createTable(IEntityModel table, boolean allNullable) {
        Map<String, Object> args = new HashMap<>();
        args.put("table", table);
        args.put("dialect", dialect);
        args.put("allNullable", allNullable);
        return XLang.getTagAction(dmlLibPath, "CreateTable").generateText(XLang.newEvalScope(args));
    }

    public String createTables(Collection<? extends IEntityModel> tables, boolean allNullable,
                               boolean includeComments) {
        Map<String, Object> args = new HashMap<>();
        args.put("tables", tables);
        args.put("dialect", dialect);
        args.put("allNullable", allNullable);
        args.put("includeComments", includeComments);
        return XLang.getTagAction(dmlLibPath, "CreateTables").generateText(XLang.newEvalScope(args));
    }

    public String dropTable(IEntityModel table, boolean ifExists) {
        Map<String, Object> args = new HashMap<>();
        args.put("table", table);
        args.put("dialect", dialect);
        args.put("ifExists", ifExists);
        return XLang.getTagAction(dmlLibPath, "DropTable").generateText(XLang.newEvalScope(args));
    }

    public String dropTables(Collection<? extends IEntityModel> tables, boolean ifExists) {
        Map<String, Object> args = new HashMap<>();
        args.put("tables", tables);
        args.put("dialect", dialect);
        args.put("ifExists", ifExists);
        return XLang.getTagAction(dmlLibPath, "DropTables").generateText(XLang.newEvalScope(args));
    }
}