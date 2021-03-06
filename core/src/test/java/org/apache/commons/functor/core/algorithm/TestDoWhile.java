/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.commons.functor.core.algorithm;

import static org.junit.Assert.assertEquals;

import org.apache.commons.functor.BaseFunctorTest;
import org.apache.commons.functor.NullaryProcedure;
import org.apache.commons.functor.core.Limit;
import org.junit.Test;

/**
 * Tests {@link DoWhile} algorithm.
 */
public class TestDoWhile extends BaseFunctorTest {

    // Functor Testing Framework
    // ------------------------------------------------------------------------

    @Override
    protected Object makeFunctor() throws Exception {
        Counter counter = new Counter();
        return new DoWhile(counter, new Limit(10));
    }
    
    @Test
    public void testDoWhile() {
        for(int i=0;i<3;i++){
            Counter counter = new Counter();
            new DoWhile(counter, new Limit(i)).run();
            assertEquals(i+1,counter.count);
        }
    }

    // Classes
    // ------------------------------------------------------------------------

    static class Counter implements NullaryProcedure {
        public void run() {
            count++;
        }
        public int count = 0;

        @Override
        public boolean equals(Object obj) {
            if(this == obj) {
                return true;
            }
            if (obj == null || !obj.getClass().equals(getClass())) {
                return false;
            }
            Counter that = (Counter)obj;
            return this.count == that.count;
        }

        @Override
        public int hashCode() {
            int hash = "Counter".hashCode();
            hash <<= 2;
            hash ^= this.count;
            return hash;
        }
    }

}
