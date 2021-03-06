/*
 ***************************************************************************************
 *  Copyright (C) 2006 EsperTech, Inc. All rights reserved.                            *
 *  http://www.espertech.com/esper                                                     *
 *  http://www.espertech.com                                                           *
 *  ---------------------------------------------------------------------------------- *
 *  The software in this package is published under the terms of the GPL license       *
 *  a copy of which has been included with this distribution in the license.txt file.  *
 ***************************************************************************************
 */
package com.espertech.esper.common.internal.epl.expression.dot.core;

import com.espertech.esper.common.internal.bytecodemodel.base.CodegenClassScope;
import com.espertech.esper.common.internal.bytecodemodel.base.CodegenMethodScope;
import com.espertech.esper.common.internal.bytecodemodel.model.expression.CodegenExpression;
import com.espertech.esper.common.internal.epl.expression.codegen.ExprForgeCodegenSymbol;
import com.espertech.esper.common.internal.epl.expression.core.ExprForge;
import com.espertech.esper.common.internal.rettype.EPType;
import com.espertech.esper.common.internal.rettype.EPTypeHelper;

public class ExprDotForgeArrayGet implements ExprDotForge {
    private final EPType typeInfo;
    private final ExprForge indexExpression;

    public ExprDotForgeArrayGet(ExprForge index, Class componentType) {
        this.indexExpression = index;
        this.typeInfo = EPTypeHelper.singleValue(componentType);
    }

    public EPType getTypeInfo() {
        return typeInfo;
    }

    public void visit(ExprDotEvalVisitor visitor) {
        visitor.visitArraySingleItemSource();
    }

    public ExprDotEval getDotEvaluator() {
        return new ExprDotForgeArrayGetEval(this, indexExpression.getExprEvaluator());
    }

    public CodegenExpression codegen(CodegenExpression inner, Class innerType, CodegenMethodScope parent, ExprForgeCodegenSymbol symbols, CodegenClassScope classScope) {
        return ExprDotForgeArrayGetEval.codegen(this, inner, innerType, parent, symbols, classScope);
    }

    public ExprForge getIndexExpression() {
        return indexExpression;
    }
}
