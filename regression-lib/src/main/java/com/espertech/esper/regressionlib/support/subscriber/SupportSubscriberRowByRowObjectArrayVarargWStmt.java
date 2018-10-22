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
package com.espertech.esper.regressionlib.support.subscriber;

import com.espertech.esper.runtime.client.EPStatement;

public class SupportSubscriberRowByRowObjectArrayVarargWStmt extends SupportSubscriberRowByRowObjectArrayBase {
    public SupportSubscriberRowByRowObjectArrayVarargWStmt() {
        super(true);
    }

    public void update(EPStatement stmt, Object... row) {
        addIndication(stmt, row);
    }
}
