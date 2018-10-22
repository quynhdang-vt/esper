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
package com.espertech.esper.regressionlib.suite.epl.join;

import com.espertech.esper.common.client.EventBean;
import com.espertech.esper.common.client.scopetest.EPAssertionUtil;
import com.espertech.esper.regressionlib.framework.RegressionEnvironment;
import com.espertech.esper.regressionlib.framework.RegressionExecution;
import com.espertech.esper.regressionlib.support.bean.*;
import com.espertech.esper.regressionlib.support.util.ArrayHandlingUtil;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertFalse;

public class EPLOuterJoin6Stream {

    public static List<RegressionExecution> executions() {
        List<RegressionExecution> execs = new ArrayList<>();
        execs.add(new EPLJoinRootS0());
        execs.add(new EPLJoinRootS1());
        execs.add(new EPLJoinRootS2());
        execs.add(new EPLJoinRootS3());
        execs.add(new EPLJoinRootS4());
        execs.add(new EPLJoinRootS5());
        return execs;
    }

    private static class EPLJoinRootS0 implements RegressionExecution {
        public void run(RegressionEnvironment env) {
            /**
             * Query:
             *          s0 <- s1
             *                  <- s3
             *             <- s2
             *                  <- s4
             *                  <- s5
             */
            String epl = "@name('s0') select * from " +
                "SupportBean_S0#length(1000) as s0 " +
                " right outer join SupportBean_S1#length(1000) as s1 on s0.p00 = s1.p10 " +
                " right outer join SupportBean_S2#length(1000) as s2 on s0.p00 = s2.p20 " +
                " right outer join SupportBean_S3#length(1000) as s3 on s1.p10 = s3.p30 " +
                " right outer join SupportBean_S4#length(1000) as s4 on s2.p20 = s4.p40 " +
                " right outer join SupportBean_S5#length(1000) as s5 on s2.p20 = s5.p50 ";
            env.compileDeployAddListenerMileZero(epl, "s0");

            tryAssertion(env);
        }
    }

    private static class EPLJoinRootS1 implements RegressionExecution {
        public void run(RegressionEnvironment env) {
            /**
             * Query:
             *          s0 <- s1
             *                  <- s3
             *             <- s2
             *                  <- s4
             *                  <- s5
             */
            String epl = "@name('s0') select * from " +
                "SupportBean_S1#length(1000) as s1 " +
                " left outer join " + "SupportBean_S0#length(1000) as s0 on s0.p00 = s1.p10 " +
                " right outer join SupportBean_S3#length(1000) as s3 on s1.p10 = s3.p30 " +
                " right outer join SupportBean_S2#length(1000) as s2 on s0.p00 = s2.p20 " +
                " right outer join SupportBean_S5#length(1000) as s5 on s2.p20 = s5.p50 " +
                " right outer join SupportBean_S4#length(1000) as s4 on s2.p20 = s4.p40 ";
            env.compileDeployAddListenerMileZero(epl, "s0");

            tryAssertion(env);
        }
    }

    private static class EPLJoinRootS2 implements RegressionExecution {
        public void run(RegressionEnvironment env) {
            /**
             * Query:
             *          s0 <- s1
             *                  <- s3
             *             <- s2
             *                  <- s4
             *                  <- s5
             */
            String epl = "@name('s0') select * from " +
                "SupportBean_S2#length(1000) as s2 " +
                " left outer join " + "SupportBean_S0#length(1000) as s0 on s0.p00 = s2.p20 " +
                " right outer join SupportBean_S1#length(1000) as s1 on s0.p00 = s1.p10 " +
                " right outer join SupportBean_S3#length(1000) as s3 on s1.p10 = s3.p30 " +
                " right outer join SupportBean_S4#length(1000) as s4 on s2.p20 = s4.p40 " +
                " right outer join SupportBean_S5#length(1000) as s5 on s2.p20 = s5.p50 ";
            env.compileDeployAddListenerMileZero(epl, "s0");

            tryAssertion(env);
        }
    }

    private static class EPLJoinRootS3 implements RegressionExecution {
        public void run(RegressionEnvironment env) {
            /**
             * Query:
             *          s0 <- s1
             *                  <- s3
             *             <- s2
             *                  <- s4
             *                  <- s5
             */
            String epl = "@name('s0') select * from " +
                "SupportBean_S3#length(1000) as s3 " +
                " left outer join SupportBean_S1#length(1000) as s1 on s1.p10 = s3.p30 " +
                " left outer join " + "SupportBean_S0#length(1000) as s0 on s0.p00 = s1.p10 " +
                " right outer join SupportBean_S2#length(1000) as s2 on s0.p00 = s2.p20 " +
                " right outer join SupportBean_S5#length(1000) as s5 on s2.p20 = s5.p50 " +
                " right outer join SupportBean_S4#length(1000) as s4 on s2.p20 = s4.p40 ";
            env.compileDeployAddListenerMileZero(epl, "s0");

            tryAssertion(env);
        }
    }

    private static class EPLJoinRootS4 implements RegressionExecution {
        public void run(RegressionEnvironment env) {
            /**
             * Query:
             *          s0 <- s1
             *                  <- s3
             *             <- s2
             *                  <- s4
             *                  <- s5
             */
            String epl = "@name('s0') select * from " +
                "SupportBean_S4#length(1000) as s4 " +
                " left outer join SupportBean_S2#length(1000) as s2 on s2.p20 = s4.p40 " +
                " right outer join SupportBean_S5#length(1000) as s5 on s2.p20 = s5.p50 " +
                " left outer join " + "SupportBean_S0#length(1000) as s0 on s0.p00 = s2.p20 " +
                " right outer join SupportBean_S1#length(1000) as s1 on s0.p00 = s1.p10 " +
                " right outer join SupportBean_S3#length(1000) as s3 on s1.p10 = s3.p30 ";
            env.compileDeployAddListenerMileZero(epl, "s0");

            tryAssertion(env);
        }
    }

    private static class EPLJoinRootS5 implements RegressionExecution {
        public void run(RegressionEnvironment env) {
            /**
             * Query:
             *          s0 <- s1
             *                  <- s3
             *             <- s2
             *                  <- s4
             *                  <- s5
             */
            String epl = "@name('s0') select * from " +
                "SupportBean_S5#length(1000) as s5 " +
                " left outer join SupportBean_S2#length(1000) as s2 on s2.p20 = s5.p50 " +
                " right outer join SupportBean_S4#length(1000) as s4 on s2.p20 = s4.p40 " +
                " left outer join " + "SupportBean_S0#length(1000) as s0 on s0.p00 = s2.p20 " +
                " right outer join SupportBean_S1#length(1000) as s1 on s0.p00 = s1.p10 " +
                " right outer join SupportBean_S3#length(1000) as s3 on s1.p10 = s3.p30 ";
            env.compileDeployAddListenerMileZero(epl, "s0");

            tryAssertion(env);
        }
    }

    private static void tryAssertion(RegressionEnvironment env) {
        Object[] s0Events;
        Object[] s1Events;
        Object[] s2Events;
        Object[] s3Events;
        Object[] s4Events;
        Object[] s5Events;

        // Test s0 and s1=0, s2=0, s3=0, s4=0, s5=0
        //
        s0Events = SupportBean_S0.makeS0("A", new String[]{"A-s0-1"});
        sendEvent(env, s0Events);
        assertFalse(env.listener("s0").isInvoked());

        // Test s0 and s1=1, s2=0, s3=0, s4=0, s5=0
        //
        s1Events = SupportBean_S1.makeS1("B", new String[]{"B-s1-1"});
        sendEvent(env, s1Events);
        assertFalse(env.listener("s0").isInvoked());

        s0Events = SupportBean_S0.makeS0("B", new String[]{"B-s0-1"});
        sendEvent(env, s0Events);
        assertFalse(env.listener("s0").isInvoked());

        // Test s0 and s1=1, s2=1, s3=0, s4=0, s5=0
        //
        s1Events = SupportBean_S1.makeS1("C", new String[]{"C-s1-1"});
        sendEvent(env, s1Events);

        s2Events = SupportBean_S2.makeS2("C", new String[]{"C-s2-1"});
        sendEvent(env, s2Events);
        assertFalse(env.listener("s0").isInvoked());

        s0Events = SupportBean_S0.makeS0("C", new String[]{"C-s0-1"});
        sendEvent(env, s0Events);
        assertFalse(env.listener("s0").isInvoked());

        // Test s0 and s1=1, s2=1, s3=1, s4=0, s5=0
        //
        s1Events = SupportBean_S1.makeS1("D", new String[]{"D-s1-1"});
        sendEvent(env, s1Events);

        s2Events = SupportBean_S2.makeS2("D", new String[]{"D-s2-1"});
        sendEvent(env, s2Events);

        s3Events = SupportBean_S3.makeS3("D", new String[]{"D-s2-1"});
        sendEvent(env, s3Events);
        EPAssertionUtil.assertSameAnyOrder(new Object[][]{
            {null, s1Events[0], null, s3Events[0], null, null}}, getAndResetNewEvents(env));

        s0Events = SupportBean_S0.makeS0("D", new String[]{"D-s0-1"});
        sendEvent(env, s0Events);
        assertFalse(env.listener("s0").isInvoked());

        // Test s0 and s1=1, s2=1, s3=1, s4=1, s5=0
        //
        s1Events = SupportBean_S1.makeS1("E", new String[]{"E-s1-1"});
        sendEvent(env, s1Events);

        s2Events = SupportBean_S2.makeS2("E", new String[]{"E-s2-1"});
        sendEvent(env, s2Events);

        s3Events = SupportBean_S3.makeS3("E", new String[]{"E-s2-1"});
        sendEvent(env, s3Events);
        EPAssertionUtil.assertSameAnyOrder(new Object[][]{
            {null, s1Events[0], null, s3Events[0], null, null}}, getAndResetNewEvents(env));

        s4Events = SupportBean_S4.makeS4("E", new String[]{"E-s2-1"});
        sendEvent(env, s4Events);
        EPAssertionUtil.assertSameAnyOrder(new Object[][]{
            {null, null, null, null, s4Events[0], null}}, getAndResetNewEvents(env));

        s0Events = SupportBean_S0.makeS0("E", new String[]{"E-s0-1"});
        sendEvent(env, s0Events);
        assertFalse(env.listener("s0").isInvoked());

        // Test s0 and s1=2, s2=1, s3=1, s4=1, s5=1
        //
        s1Events = SupportBean_S1.makeS1("F", new String[]{"F-s1-1"});
        sendEvent(env, s1Events);
        assertFalse(env.listener("s0").isInvoked());

        s2Events = SupportBean_S2.makeS2("F", new String[]{"F-s2-1"});
        sendEvent(env, s2Events);
        assertFalse(env.listener("s0").isInvoked());

        s3Events = SupportBean_S3.makeS3("F", new String[]{"F-s3-1"});
        sendEvent(env, s3Events);
        EPAssertionUtil.assertSameAnyOrder(new Object[][]{
            {null, s1Events[0], null, s3Events[0], null, null}}, getAndResetNewEvents(env));

        s4Events = SupportBean_S4.makeS4("F", new String[]{"F-s2-1"});
        sendEvent(env, s4Events);
        EPAssertionUtil.assertSameAnyOrder(new Object[][]{
            {null, null, null, null, s4Events[0], null}}, getAndResetNewEvents(env));

        s5Events = SupportBean_S5.makeS5("F", new String[]{"F-s2-1"});
        sendEvent(env, s5Events);
        EPAssertionUtil.assertSameAnyOrder(new Object[][]{
            {null, null, s2Events[0], null, s4Events[0], s5Events[0]}}, getAndResetNewEvents(env));

        s0Events = SupportBean_S0.makeS0("F", new String[]{"F-s0-1"});
        sendEvent(env, s0Events);
        EPAssertionUtil.assertSameAnyOrder(new Object[][]{
            {s0Events[0], s1Events[0], s2Events[0], s3Events[0], s4Events[0], s5Events[0]}}, getAndResetNewEvents(env));

        // Test s0 and s1=2, s2=2, s3=1, s4=1, s5=2
        //
        s1Events = SupportBean_S1.makeS1("G", new String[]{"G-s1-1", "G-s1-2"});
        sendEventsAndReset(env, s1Events);

        s2Events = SupportBean_S2.makeS2("G", new String[]{"G-s2-1", "G-s2-2"});
        sendEventsAndReset(env, s2Events);

        s3Events = SupportBean_S3.makeS3("G", new String[]{"G-s3-1"});
        sendEventsAndReset(env, s3Events);

        s4Events = SupportBean_S4.makeS4("G", new String[]{"G-s2-1"});
        sendEventsAndReset(env, s4Events);

        s5Events = SupportBean_S5.makeS5("G", new String[]{"G-s5-1", "G-s5-2"});
        sendEventsAndReset(env, s5Events);

        s0Events = SupportBean_S0.makeS0("G", new String[]{"G-s0-1"});
        sendEvent(env, s0Events);
        EPAssertionUtil.assertSameAnyOrder(new Object[][]{
            {s0Events[0], s1Events[0], s2Events[0], s3Events[0], s4Events[0], s5Events[0]},
            {s0Events[0], s1Events[1], s2Events[0], s3Events[0], s4Events[0], s5Events[0]},
            {s0Events[0], s1Events[0], s2Events[0], s3Events[0], s4Events[0], s5Events[1]},
            {s0Events[0], s1Events[1], s2Events[0], s3Events[0], s4Events[0], s5Events[1]},
            {s0Events[0], s1Events[0], s2Events[1], s3Events[0], s4Events[0], s5Events[0]},
            {s0Events[0], s1Events[1], s2Events[1], s3Events[0], s4Events[0], s5Events[0]},
            {s0Events[0], s1Events[0], s2Events[1], s3Events[0], s4Events[0], s5Events[1]},
            {s0Events[0], s1Events[1], s2Events[1], s3Events[0], s4Events[0], s5Events[1]}}, getAndResetNewEvents(env));

        // Test s0 and s1=2, s2=2, s3=2, s4=2, s5=2
        //
        s1Events = SupportBean_S1.makeS1("H", new String[]{"H-s1-1", "H-s1-2"});
        sendEventsAndReset(env, s1Events);

        s2Events = SupportBean_S2.makeS2("H", new String[]{"H-s2-1", "H-s2-2"});
        sendEventsAndReset(env, s2Events);

        s3Events = SupportBean_S3.makeS3("H", new String[]{"H-s3-1", "H-s3-2"});
        sendEventsAndReset(env, s3Events);

        s4Events = SupportBean_S4.makeS4("H", new String[]{"H-s4-1", "H-s4-2"});
        sendEventsAndReset(env, s4Events);

        s5Events = SupportBean_S5.makeS5("H", new String[]{"H-s5-1", "H-s5-2"});
        sendEventsAndReset(env, s5Events);

        s0Events = SupportBean_S0.makeS0("H", new String[]{"H-s0-1"});
        sendEvent(env, s0Events);
        EPAssertionUtil.assertSameAnyOrder(new Object[][]{
            {s0Events[0], s1Events[0], s2Events[0], s3Events[0], s4Events[0], s5Events[0]},
            {s0Events[0], s1Events[1], s2Events[0], s3Events[0], s4Events[0], s5Events[0]},
            {s0Events[0], s1Events[0], s2Events[0], s3Events[0], s4Events[0], s5Events[1]},
            {s0Events[0], s1Events[1], s2Events[0], s3Events[0], s4Events[0], s5Events[1]},
            {s0Events[0], s1Events[0], s2Events[1], s3Events[0], s4Events[0], s5Events[0]},
            {s0Events[0], s1Events[1], s2Events[1], s3Events[0], s4Events[0], s5Events[0]},
            {s0Events[0], s1Events[0], s2Events[1], s3Events[0], s4Events[0], s5Events[1]},
            {s0Events[0], s1Events[1], s2Events[1], s3Events[0], s4Events[0], s5Events[1]},
            {s0Events[0], s1Events[0], s2Events[0], s3Events[0], s4Events[1], s5Events[0]},
            {s0Events[0], s1Events[1], s2Events[0], s3Events[0], s4Events[1], s5Events[0]},
            {s0Events[0], s1Events[0], s2Events[0], s3Events[0], s4Events[1], s5Events[1]},
            {s0Events[0], s1Events[1], s2Events[0], s3Events[0], s4Events[1], s5Events[1]},
            {s0Events[0], s1Events[0], s2Events[1], s3Events[0], s4Events[1], s5Events[0]},
            {s0Events[0], s1Events[1], s2Events[1], s3Events[0], s4Events[1], s5Events[0]},
            {s0Events[0], s1Events[0], s2Events[1], s3Events[0], s4Events[1], s5Events[1]},
            {s0Events[0], s1Events[1], s2Events[1], s3Events[0], s4Events[1], s5Events[1]},
            {s0Events[0], s1Events[0], s2Events[0], s3Events[1], s4Events[0], s5Events[0]},
            {s0Events[0], s1Events[1], s2Events[0], s3Events[1], s4Events[0], s5Events[0]},
            {s0Events[0], s1Events[0], s2Events[0], s3Events[1], s4Events[0], s5Events[1]},
            {s0Events[0], s1Events[1], s2Events[0], s3Events[1], s4Events[0], s5Events[1]},
            {s0Events[0], s1Events[0], s2Events[1], s3Events[1], s4Events[0], s5Events[0]},
            {s0Events[0], s1Events[1], s2Events[1], s3Events[1], s4Events[0], s5Events[0]},
            {s0Events[0], s1Events[0], s2Events[1], s3Events[1], s4Events[0], s5Events[1]},
            {s0Events[0], s1Events[1], s2Events[1], s3Events[1], s4Events[0], s5Events[1]},
            {s0Events[0], s1Events[0], s2Events[0], s3Events[1], s4Events[1], s5Events[0]},
            {s0Events[0], s1Events[1], s2Events[0], s3Events[1], s4Events[1], s5Events[0]},
            {s0Events[0], s1Events[0], s2Events[0], s3Events[1], s4Events[1], s5Events[1]},
            {s0Events[0], s1Events[1], s2Events[0], s3Events[1], s4Events[1], s5Events[1]},
            {s0Events[0], s1Events[0], s2Events[1], s3Events[1], s4Events[1], s5Events[0]},
            {s0Events[0], s1Events[1], s2Events[1], s3Events[1], s4Events[1], s5Events[0]},
            {s0Events[0], s1Events[0], s2Events[1], s3Events[1], s4Events[1], s5Events[1]},
            {s0Events[0], s1Events[1], s2Events[1], s3Events[1], s4Events[1], s5Events[1]}}, getAndResetNewEvents(env));

        // Test s0 and s1=2, s2=1, s3=1, s4=3, s5=1
        //
        s1Events = SupportBean_S1.makeS1("I", new String[]{"I-s1-1", "I-s1-2"});
        sendEventsAndReset(env, s1Events);

        s2Events = SupportBean_S2.makeS2("I", new String[]{"I-s2-1"});
        sendEventsAndReset(env, s2Events);

        s3Events = SupportBean_S3.makeS3("I", new String[]{"I-s3-1"});
        sendEventsAndReset(env, s3Events);

        s4Events = SupportBean_S4.makeS4("I", new String[]{"I-s4-1", "I-s4-2", "I-s4-3"});
        sendEventsAndReset(env, s4Events);

        s5Events = SupportBean_S5.makeS5("I", new String[]{"I-s5-1"});
        sendEventsAndReset(env, s5Events);

        s0Events = SupportBean_S0.makeS0("I", new String[]{"I-s0-1"});
        sendEvent(env, s0Events);
        EPAssertionUtil.assertSameAnyOrder(new Object[][]{
            {s0Events[0], s1Events[0], s2Events[0], s3Events[0], s4Events[0], s5Events[0]},
            {s0Events[0], s1Events[1], s2Events[0], s3Events[0], s4Events[1], s5Events[0]},
            {s0Events[0], s1Events[0], s2Events[0], s3Events[0], s4Events[2], s5Events[0]},
            {s0Events[0], s1Events[1], s2Events[0], s3Events[0], s4Events[0], s5Events[0]},
            {s0Events[0], s1Events[0], s2Events[0], s3Events[0], s4Events[1], s5Events[0]},
            {s0Events[0], s1Events[1], s2Events[0], s3Events[0], s4Events[2], s5Events[0]}}, getAndResetNewEvents(env));

        // Test s1 and s3=0
        //
        s1Events = SupportBean_S1.makeS1("J", new String[]{"J-s1-1"});
        sendEvent(env, s1Events);
        assertFalse(env.listener("s0").isInvoked());

        // Test s1 and s0=1, s2=0, s3=1, s4=1, s5=0
        //
        s0Events = SupportBean_S0.makeS0("K", new String[]{"K-s0-1"});
        sendEvent(env, s0Events);

        s3Events = SupportBean_S3.makeS3("K", new String[]{"K-s3-1"});
        sendEventsAndReset(env, s3Events);

        s1Events = SupportBean_S1.makeS1("K", new String[]{"K-s1-1"});
        sendEvent(env, s1Events);
        EPAssertionUtil.assertSameAnyOrder(new Object[][]{
            {null, s1Events[0], null, s3Events[0], null, null}}, getAndResetNewEvents(env));

        // Test s1 and s0=1, s2=1, s3=1, s4=0, s5=1
        //
        s0Events = SupportBean_S0.makeS0("L", new String[]{"L-s0-1"});
        sendEvent(env, s0Events);
        assertFalse(env.listener("s0").isInvoked());

        s2Events = SupportBean_S2.makeS2("L", new String[]{"L-s2-1"});
        sendEvent(env, s2Events);
        assertFalse(env.listener("s0").isInvoked());

        s3Events = SupportBean_S3.makeS3("L", new String[]{"L-s3-1"});
        sendEventsAndReset(env, s3Events);

        s5Events = SupportBean_S5.makeS5("L", new String[]{"L-s5-1"});
        sendEventsAndReset(env, s5Events);

        s1Events = SupportBean_S1.makeS1("L", new String[]{"L-s1-1"});
        sendEvent(env, s1Events);
        EPAssertionUtil.assertSameAnyOrder(new Object[][]{
            {null, s1Events[0], null, s3Events[0], null, null}}, getAndResetNewEvents(env));

        // Test s1 and s0=1, s2=1, s3=1, s4=2, s5=1
        //
        s0Events = SupportBean_S0.makeS0("M", new String[]{"M-s0-1"});
        sendEvent(env, s0Events);

        s2Events = SupportBean_S2.makeS2("M", new String[]{"M-s2-1"});
        sendEventsAndReset(env, s2Events);

        s3Events = SupportBean_S3.makeS3("M", new String[]{"M-s3-1"});
        sendEventsAndReset(env, s3Events);

        s4Events = SupportBean_S4.makeS4("M", new String[]{"M-s4-1", "M-s4-2"});
        sendEventsAndReset(env, s4Events);

        s5Events = SupportBean_S5.makeS5("M", new String[]{"M-s5-1"});
        sendEventsAndReset(env, s5Events);

        s1Events = SupportBean_S1.makeS1("M", new String[]{"M-s1-1"});
        sendEvent(env, s1Events);
        EPAssertionUtil.assertSameAnyOrder(new Object[][]{
            {s0Events[0], s1Events[0], s2Events[0], s3Events[0], s4Events[0], s5Events[0]},
            {s0Events[0], s1Events[0], s2Events[0], s3Events[0], s4Events[1], s5Events[0]}}, getAndResetNewEvents(env));

        // Test s2 and s0=1, s1=0, s3=0, s4=1, s5=2
        //
        s0Events = SupportBean_S0.makeS0("N", new String[]{"N-s0-1"});
        sendEvent(env, s0Events);

        s4Events = SupportBean_S4.makeS4("N", new String[]{"N-s4-1"});
        sendEventsAndReset(env, s4Events);

        s5Events = SupportBean_S5.makeS5("N", new String[]{"N-s5-1", "N-s5-2"});
        sendEventsAndReset(env, s5Events);

        s2Events = SupportBean_S2.makeS2("N", new String[]{"N-s2-1"});
        sendEvent(env, s2Events);
        EPAssertionUtil.assertSameAnyOrder(new Object[][]{
            {null, null, s2Events[0], null, s4Events[0], s5Events[0]},
            {null, null, s2Events[0], null, s4Events[0], s5Events[1]}}, getAndResetNewEvents(env));

        // Test s2 and s0=1, s1=1, s3=3, s4=1, s5=2
        //
        s0Events = SupportBean_S0.makeS0("O", new String[]{"O-s0-1"});
        sendEvent(env, s0Events);

        s1Events = SupportBean_S1.makeS1("O", new String[]{"O-s1-1"});
        sendEvent(env, s1Events);

        s3Events = SupportBean_S3.makeS3("O", new String[]{"O-s3-1", "O-s3-2", "O-s3-3"});
        sendEventsAndReset(env, s3Events);

        s4Events = SupportBean_S4.makeS4("O", new String[]{"O-s4-1"});
        sendEventsAndReset(env, s4Events);

        s5Events = SupportBean_S5.makeS5("O", new String[]{"O-s5-1", "O-s5-2"});
        sendEventsAndReset(env, s5Events);

        s2Events = SupportBean_S2.makeS2("O", new String[]{"O-s2-1"});
        sendEvent(env, s2Events);
        EPAssertionUtil.assertSameAnyOrder(new Object[][]{
            {s0Events[0], s1Events[0], s2Events[0], s3Events[0], s4Events[0], s5Events[0]},
            {s0Events[0], s1Events[0], s2Events[0], s3Events[1], s4Events[0], s5Events[0]},
            {s0Events[0], s1Events[0], s2Events[0], s3Events[2], s4Events[0], s5Events[0]},
            {s0Events[0], s1Events[0], s2Events[0], s3Events[0], s4Events[0], s5Events[1]},
            {s0Events[0], s1Events[0], s2Events[0], s3Events[1], s4Events[0], s5Events[1]},
            {s0Events[0], s1Events[0], s2Events[0], s3Events[2], s4Events[0], s5Events[1]}}, getAndResetNewEvents(env));

        // Test s3 and s0=0, s1=0, s2=0, s4=0, s5=0
        //
        s3Events = SupportBean_S3.makeS3("P", new String[]{"P-s1-1"});
        sendEvent(env, s3Events);
        EPAssertionUtil.assertSameAnyOrder(new Object[][]{
            {null, null, null, s3Events[0], null, null}}, getAndResetNewEvents(env));

        // Test s3 and s0=0, s1=1, s2=0, s4=0, s5=0
        //
        s1Events = SupportBean_S1.makeS1("Q", new String[]{"Q-s1-1"});
        sendEvent(env, s1Events);

        s3Events = SupportBean_S3.makeS3("Q", new String[]{"Q-s1-1"});
        sendEvent(env, s3Events);
        EPAssertionUtil.assertSameAnyOrder(new Object[][]{
            {null, s1Events[0], null, s3Events[0], null, null}}, getAndResetNewEvents(env));

        // Test s3 and s0=1, s1=2, s2=2, s4=0, s5=0
        //
        s0Events = SupportBean_S0.makeS0("R", new String[]{"R-s0-1"});
        sendEvent(env, s0Events);

        s1Events = SupportBean_S1.makeS1("R", new String[]{"R-s1-1", "R-s1-2"});
        sendEvent(env, s1Events);

        s2Events = SupportBean_S2.makeS2("R", new String[]{"R-s2-1", "R-s2-1"});
        sendEventsAndReset(env, s2Events);

        s3Events = SupportBean_S3.makeS3("R", new String[]{"R-s3-1"});
        sendEvent(env, s3Events);
        EPAssertionUtil.assertSameAnyOrder(new Object[][]{
            {null, s1Events[0], null, s3Events[0], null, null},
            {null, s1Events[1], null, s3Events[0], null, null}}, getAndResetNewEvents(env));

        // Test s3 and s0=2, s1=2, s2=1, s4=2, s5=2
        //
        s0Events = SupportBean_S0.makeS0("S", new String[]{"S-s0-1", "S-s0-2"});
        sendEvent(env, s0Events);

        s1Events = SupportBean_S1.makeS1("S", new String[]{"S-s1-1", "S-s1-2"});
        sendEvent(env, s1Events);

        s2Events = SupportBean_S2.makeS2("S", new String[]{"S-s2-1", "S-s2-1"});
        sendEventsAndReset(env, s2Events);

        s4Events = SupportBean_S4.makeS4("S", new String[]{"S-s4-1", "S-s4-2"});
        sendEventsAndReset(env, s4Events);

        s5Events = SupportBean_S5.makeS5("S", new String[]{"S-s5-1", "S-s5-2"});
        sendEventsAndReset(env, s5Events);

        s3Events = SupportBean_S3.makeS3("S", new String[]{"s-s3-1"});
        sendEvent(env, s3Events);
        EPAssertionUtil.assertSameAnyOrder(new Object[][]{
            {s0Events[0], s1Events[0], s2Events[0], s3Events[0], s4Events[0], s5Events[0]},
            {s0Events[1], s1Events[0], s2Events[0], s3Events[0], s4Events[0], s5Events[0]},
            {s0Events[0], s1Events[0], s2Events[0], s3Events[0], s4Events[0], s5Events[1]},
            {s0Events[1], s1Events[0], s2Events[0], s3Events[0], s4Events[0], s5Events[1]},
            {s0Events[0], s1Events[0], s2Events[1], s3Events[0], s4Events[0], s5Events[0]},
            {s0Events[1], s1Events[0], s2Events[1], s3Events[0], s4Events[0], s5Events[0]},
            {s0Events[0], s1Events[0], s2Events[1], s3Events[0], s4Events[0], s5Events[1]},
            {s0Events[1], s1Events[0], s2Events[1], s3Events[0], s4Events[0], s5Events[1]},
            {s0Events[0], s1Events[0], s2Events[0], s3Events[0], s4Events[1], s5Events[0]},
            {s0Events[1], s1Events[0], s2Events[0], s3Events[0], s4Events[1], s5Events[0]},
            {s0Events[0], s1Events[0], s2Events[0], s3Events[0], s4Events[1], s5Events[1]},
            {s0Events[1], s1Events[0], s2Events[0], s3Events[0], s4Events[1], s5Events[1]},
            {s0Events[0], s1Events[0], s2Events[1], s3Events[0], s4Events[1], s5Events[0]},
            {s0Events[1], s1Events[0], s2Events[1], s3Events[0], s4Events[1], s5Events[0]},
            {s0Events[0], s1Events[0], s2Events[1], s3Events[0], s4Events[1], s5Events[1]},
            {s0Events[1], s1Events[0], s2Events[1], s3Events[0], s4Events[1], s5Events[1]},
            {s0Events[0], s1Events[1], s2Events[0], s3Events[0], s4Events[0], s5Events[0]},
            {s0Events[1], s1Events[1], s2Events[0], s3Events[0], s4Events[0], s5Events[0]},
            {s0Events[0], s1Events[1], s2Events[0], s3Events[0], s4Events[0], s5Events[1]},
            {s0Events[1], s1Events[1], s2Events[0], s3Events[0], s4Events[0], s5Events[1]},
            {s0Events[0], s1Events[1], s2Events[1], s3Events[0], s4Events[0], s5Events[0]},
            {s0Events[1], s1Events[1], s2Events[1], s3Events[0], s4Events[0], s5Events[0]},
            {s0Events[0], s1Events[1], s2Events[1], s3Events[0], s4Events[0], s5Events[1]},
            {s0Events[1], s1Events[1], s2Events[1], s3Events[0], s4Events[0], s5Events[1]},
            {s0Events[0], s1Events[1], s2Events[0], s3Events[0], s4Events[1], s5Events[0]},
            {s0Events[1], s1Events[1], s2Events[0], s3Events[0], s4Events[1], s5Events[0]},
            {s0Events[0], s1Events[1], s2Events[0], s3Events[0], s4Events[1], s5Events[1]},
            {s0Events[1], s1Events[1], s2Events[0], s3Events[0], s4Events[1], s5Events[1]},
            {s0Events[0], s1Events[1], s2Events[1], s3Events[0], s4Events[1], s5Events[0]},
            {s0Events[1], s1Events[1], s2Events[1], s3Events[0], s4Events[1], s5Events[0]},
            {s0Events[0], s1Events[1], s2Events[1], s3Events[0], s4Events[1], s5Events[1]},
            {s0Events[1], s1Events[1], s2Events[1], s3Events[0], s4Events[1], s5Events[1]}}, getAndResetNewEvents(env));

        // Test s4 and s0=1, s1=0, s2=1, s3=0, s5=0
        //
        s0Events = SupportBean_S0.makeS0("U", new String[]{"U-s0-1"});
        sendEventsAndReset(env, s0Events);

        s2Events = SupportBean_S2.makeS2("U", new String[]{"U-s1-1"});
        sendEventsAndReset(env, s2Events);

        s4Events = SupportBean_S4.makeS4("U", new String[]{"U-s4-1"});
        sendEvent(env, s4Events);
        EPAssertionUtil.assertSameAnyOrder(new Object[][]{
            {null, null, null, null, s4Events[0], null}}, getAndResetNewEvents(env));

        // Test s4 and s0=1, s1=0, s2=1, s3=0, s5=1
        //
        s0Events = SupportBean_S0.makeS0("V", new String[]{"V-s0-1"});
        sendEventsAndReset(env, s0Events);

        s2Events = SupportBean_S2.makeS2("V", new String[]{"V-s1-1"});
        sendEventsAndReset(env, s2Events);

        s5Events = SupportBean_S5.makeS5("V", new String[]{"V-s5-1"});
        sendEventsAndReset(env, s5Events);

        s4Events = SupportBean_S4.makeS4("V", new String[]{"V-s4-1"});
        sendEvent(env, s4Events);
        EPAssertionUtil.assertSameAnyOrder(new Object[][]{
            {null, null, s2Events[0], null, s4Events[0], s5Events[0]}}, getAndResetNewEvents(env));

        // Test s4 and s0=1, s1=1, s2=1, s3=1, s5=2
        //
        s0Events = SupportBean_S0.makeS0("W", new String[]{"W-s0-1"});
        sendEvent(env, s0Events);

        s1Events = SupportBean_S1.makeS1("W", new String[]{"W-s1-1"});
        sendEventsAndReset(env, s1Events);

        s2Events = SupportBean_S2.makeS2("W", new String[]{"W-s2-1"});
        sendEventsAndReset(env, s2Events);

        s3Events = SupportBean_S3.makeS3("W", new String[]{"W-s3-1"});
        sendEventsAndReset(env, s3Events);

        s5Events = SupportBean_S5.makeS5("W", new String[]{"W-s5-1", "W-s5-2"});
        sendEventsAndReset(env, s5Events);

        s4Events = SupportBean_S4.makeS4("W", new String[]{"W-s4-1"});
        sendEvent(env, s4Events);
        EPAssertionUtil.assertSameAnyOrder(new Object[][]{
            {s0Events[0], s1Events[0], s2Events[0], s3Events[0], s4Events[0], s5Events[0]},
            {s0Events[0], s1Events[0], s2Events[0], s3Events[0], s4Events[0], s5Events[1]}}, getAndResetNewEvents(env));

        // Test s5 and s0=1, s1=2, s2=2, s3=1, s4=1
        //
        s0Events = SupportBean_S0.makeS0("X", new String[]{"X-s0-1"});
        sendEvent(env, s0Events);

        s1Events = SupportBean_S1.makeS1("X", new String[]{"X-s1-1", "X-s1-2"});
        sendEventsAndReset(env, s1Events);

        s2Events = SupportBean_S2.makeS2("X", new String[]{"X-s2-1", "X-s2-2"});
        sendEvent(env, s2Events);

        s3Events = SupportBean_S3.makeS3("X", new String[]{"X-s3-1"});
        sendEventsAndReset(env, s3Events);

        s4Events = SupportBean_S4.makeS4("X", new String[]{"X-s4-1"});
        sendEventsAndReset(env, s4Events);

        s5Events = SupportBean_S5.makeS5("X", new String[]{"X-s5-1"});
        sendEvent(env, s5Events);
        EPAssertionUtil.assertSameAnyOrder(new Object[][]{
            {s0Events[0], s1Events[0], s2Events[0], s3Events[0], s4Events[0], s5Events[0]},
            {s0Events[0], s1Events[0], s2Events[1], s3Events[0], s4Events[0], s5Events[0]},
            {s0Events[0], s1Events[1], s2Events[0], s3Events[0], s4Events[0], s5Events[0]},
            {s0Events[0], s1Events[1], s2Events[1], s3Events[0], s4Events[0], s5Events[0]}}, getAndResetNewEvents(env));

        // Test s5 and s0=2, s1=1, s2=1, s3=1, s4=1
        //
        s0Events = SupportBean_S0.makeS0("Y", new String[]{"Y-s0-1", "Y-s0-2"});
        sendEvent(env, s0Events);

        s1Events = SupportBean_S1.makeS1("Y", new String[]{"Y-s1-1"});
        sendEventsAndReset(env, s1Events);

        s2Events = SupportBean_S2.makeS2("Y", new String[]{"Y-s2-1"});
        sendEvent(env, s2Events);

        s3Events = SupportBean_S3.makeS3("Y", new String[]{"Y-s3-1"});
        sendEventsAndReset(env, s3Events);

        s4Events = SupportBean_S4.makeS4("Y", new String[]{"Y-s4-1"});
        sendEventsAndReset(env, s4Events);

        s5Events = SupportBean_S5.makeS5("Y", new String[]{"X-s5-1"});
        sendEvent(env, s5Events);
        EPAssertionUtil.assertSameAnyOrder(new Object[][]{
            {s0Events[0], s1Events[0], s2Events[0], s3Events[0], s4Events[0], s5Events[0]},
            {s0Events[1], s1Events[0], s2Events[0], s3Events[0], s4Events[0], s5Events[0]}}, getAndResetNewEvents(env));

        // Test s5 and s0=1, s1=1, s2=1, s3=2, s4=2
        //
        s0Events = SupportBean_S0.makeS0("Z", new String[]{"Z-s0-1"});
        sendEvent(env, s0Events);

        s1Events = SupportBean_S1.makeS1("Z", new String[]{"Z-s1-1"});
        sendEventsAndReset(env, s1Events);

        s2Events = SupportBean_S2.makeS2("Z", new String[]{"Z-s2-1"});
        sendEventsAndReset(env, s2Events);

        s3Events = SupportBean_S3.makeS3("Z", new String[]{"Z-s3-1", "Z-s3-2"});
        sendEventsAndReset(env, s3Events);

        s4Events = SupportBean_S4.makeS4("Z", new String[]{"Z-s4-1", "Z-s4-2"});
        sendEventsAndReset(env, s4Events);

        s5Events = SupportBean_S5.makeS5("Z", new String[]{"Z-s5-1"});
        sendEvent(env, s5Events);
        EPAssertionUtil.assertSameAnyOrder(new Object[][]{
            {s0Events[0], s1Events[0], s2Events[0], s3Events[0], s4Events[0], s5Events[0]},
            {s0Events[0], s1Events[0], s2Events[0], s3Events[0], s4Events[1], s5Events[0]},
            {s0Events[0], s1Events[0], s2Events[0], s3Events[1], s4Events[0], s5Events[0]},
            {s0Events[0], s1Events[0], s2Events[0], s3Events[1], s4Events[1], s5Events[0]}}, getAndResetNewEvents(env));

        env.undeployAll();
    }

    private static void sendEventsAndReset(RegressionEnvironment env, Object[] events) {
        sendEvent(env, events);
        env.listener("s0").reset();
    }

    private static void sendEvent(RegressionEnvironment env, Object[] events) {
        for (int i = 0; i < events.length; i++) {
            env.sendEventBean(events[i]);
        }
    }

    private static Object[][] getAndResetNewEvents(RegressionEnvironment env) {
        EventBean[] newEvents = env.listener("s0").getLastNewData();
        env.listener("s0").reset();
        return ArrayHandlingUtil.getUnderlyingEvents(newEvents, new String[]{"s0", "s1", "s2", "s3", "s4", "s5"});
    }
}
