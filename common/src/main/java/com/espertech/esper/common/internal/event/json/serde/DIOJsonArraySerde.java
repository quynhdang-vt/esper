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
package com.espertech.esper.common.internal.event.json.serde;

import com.espertech.esper.common.client.serde.DataInputOutputSerde;
import com.espertech.esper.common.client.serde.EventBeanCollatedWriter;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class DIOJsonArraySerde implements DataInputOutputSerde<Object[]> {
    public final static DIOJsonArraySerde INSTANCE = new DIOJsonArraySerde();

    private DIOJsonArraySerde() {
    }

    public void write(Object[] object, DataOutput output, byte[] unitKey, EventBeanCollatedWriter writer) throws IOException {
        output.writeBoolean(object != null);
        if (object != null) {
            DIOJsonSerdeHelper.writeArray(object, output);
        }
    }

    public Object[] read(DataInput input, byte[] unitKey) throws IOException {
        boolean notNull = input.readBoolean();
        return notNull ? DIOJsonSerdeHelper.readArray(input) : null;
    }
}
