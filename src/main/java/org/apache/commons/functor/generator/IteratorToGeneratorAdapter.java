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

package org.apache.commons.functor.generator;

import org.apache.commons.functor.UnaryProcedure;

import java.util.Iterator;

/**
 * Adapts an {@link Iterator} to the {@link Generator} interface.
 * 
 * @since 1.0
 * @version $Revision$ $Date$
 * @author Jason Horman (jason@jhorman.org)
 * @author Rodney Waldhoff
 */
public final class IteratorToGeneratorAdapter extends BaseGenerator {

    // constructors
    //-----------------------------------------------------

    public IteratorToGeneratorAdapter(Iterator iter) {
        if(null == iter) {
            throw new NullPointerException();
        } else {
            this.iter = iter;
        }
    }

    // instance methods
    //-----------------------------------------------------

    public void run(UnaryProcedure proc) {
        while(iter.hasNext()) {
            proc.run(iter.next());
            if (isStopped()) { break; } 
        }
    }

    public boolean equals(Object obj) {
        if(obj instanceof IteratorToGeneratorAdapter) {
            IteratorToGeneratorAdapter that = (IteratorToGeneratorAdapter)obj;
            return this.iter.equals(that.iter);
        } else {
            return false;
        }
    }
    
    public int hashCode() {
        int hash = "IteratorToGeneratorAdapater".hashCode();
        hash <<= 2;
        hash ^= iter.hashCode();
        return hash; 
    }
    
    public String toString() {
        return "IteratorToGeneratorAdapter<" + iter + ">";
    }


    // class methods
    //-----------------------------------------------------

    public static IteratorToGeneratorAdapter adapt(Iterator iter) {
        return null == iter ? null : new IteratorToGeneratorAdapter(iter);
    }
    
    // instance variables
    //-----------------------------------------------------

    private Iterator iter = null;
}