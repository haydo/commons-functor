/* 
 * $Header: /home/jerenkrantz/tmp/commons/commons-convert/cvs/home/cvs/jakarta-commons-sandbox//functor/src/java/org/apache/commons/functor/core/collection/IsEmpty.java,v 1.4 2003/11/24 23:11:48 rwaldhoff Exp $
 * ====================================================================
 * The Apache Software License, Version 1.1
 *
 * Copyright (c) 2003 The Apache Software Foundation.  All rights
 * reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 *
 * 1. Redistributions of source code must retain the above copyright
 *    notice, this list of conditions and the following disclaimer.
 *
 * 2. Redistributions in binary form must reproduce the above copyright
 *    notice, this list of conditions and the following disclaimer in
 *    the documentation and/or other materials provided with the
 *    distribution.
 *
 * 3. The end-user documentation included with the redistribution,
 *    if any, must include the following acknowledgment:
 *       "This product includes software developed by the
 *        Apache Software Foundation (http://www.apache.org/)."
 *    Alternately, this acknowledgment may appear in the software itself,
 *    if and wherever such third-party acknowledgments normally appear.
 *
 * 4. The names "The Jakarta Project", "Commons", and "Apache Software
 *    Foundation" must not be used to endorse or promote products derived 
 *    from this software without prior written permission. For written
 *    permission, please contact apache@apache.org.
 *
 * 5. Products derived from this software may not be called "Apache",
 *    nor may "Apache" appear in their name, without prior written
 *    permission of the Apache Software Foundation.
 *
 * THIS SOFTWARE IS PROVIDED ``AS IS'' AND ANY EXPRESSED OR IMPLIED
 * WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES
 * OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED.  IN NO EVENT SHALL THE APACHE SOFTWARE FOUNDATION OR
 * ITS CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL,
 * SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT
 * LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF
 * USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 * ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY,
 * OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT
 * OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF
 * SUCH DAMAGE.
 * ====================================================================
 *
 * This software consists of voluntary contributions made by many
 * individuals on behalf of the Apache Software Foundation.  For more
 * information on the Apache Software Foundation, please see
 * <http://www.apache.org/>.
 *
 */
package org.apache.commons.functor.core.collection;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Map;

import org.apache.commons.functor.UnaryPredicate;

/**
 * @version $Revision: 1.4 $ $Date: 2003/11/24 23:11:48 $
 * @author Rodney Waldhoff
 */
public final class IsEmpty implements UnaryPredicate, Serializable {

    // constructor
    // ------------------------------------------------------------------------
    
    public IsEmpty() { }

    // instance methods
    // ------------------------------------------------------------------------
    
    public boolean test(Object obj) {
        if(obj instanceof Collection) {
            return testCollection((Collection)obj);
        } else if(obj instanceof Map) {
            return testMap((Map)obj);
        } else if(obj instanceof String) {
            return testString((String)obj);
        } else if(null != obj && obj.getClass().isArray()) {
            return testArray(obj);
        } else if(null == obj){
            throw new NullPointerException("Argument must not be null");
        } else {
            throw new IllegalArgumentException("Expected Collection, Map, String or Array, found " + obj.getClass());
        } 
    }

    /**
     * @see java.lang.Object#equals(Object)
     */
    public boolean equals(Object that) {
        return that instanceof IsEmpty;
    }

    /**
     * @see java.lang.Object#hashCode()
     */
    public int hashCode() {
        return "IsEmpty".hashCode();
    }

    /**
     * @see java.lang.Object#toString()
     */
    public String toString() {
        return "IsEmpty()";
    }

    private boolean testCollection(Collection col) {
        return col.isEmpty();
    }
    
    private boolean testMap(Map map) {
        return map.isEmpty();
    }
    
    private boolean testString(String str) {
        return 0 == str.length();
    }
    
    private boolean testArray(Object array) {
        return 0 == Array.getLength(array);
    }

    // class methods
    // ------------------------------------------------------------------------
    
    public static final IsEmpty instance() {
        return INSTANCE;
    }
    
    // class variables
    // ------------------------------------------------------------------------
    
    private static final IsEmpty INSTANCE = new IsEmpty();

}
