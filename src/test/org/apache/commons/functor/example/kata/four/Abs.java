/*
 * Copyright 2003,2004 The Apache Software Foundation.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.commons.functor.example.kata.four;

import org.apache.commons.functor.UnaryFunction;

/**
 * Evaluates to the absolute Integer value of the Number-valued
 * input parameter.
 * 
 * @version $Revision: 1.3 $ $Date: 2004/02/28 03:35:29 $
 * @author Rodney Waldhoff
 */
public final class Abs implements UnaryFunction {
    public Object evaluate(Object obj) {
        return evaluate((Number)obj);
    }

    public Object evaluate(Number num) {
        return new Integer(Math.abs(num.intValue()));
    }

    public static final Abs instance() {
        return INSTANCE;
    }
    
    private static final Abs INSTANCE = new Abs();
}