/**
 * Copyright 2010 - 2013 CosmoCode GmbH
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package de.cosmocode.commons.reflect;

/**
 * Static utility class for {@link Class}es.
 *
 * @deprecated use {@link Reflection}
 * @since 1.6
 * @author Willi Schoenborn
 */
@Deprecated
public final class Classes {
    
    private Classes() {
        
    }
    
    /**
     * Returns the Class object associated with the class or interface with the given string name.
     * This method does, in contrast to {@link Class#forName(String)}, cache the results.
     * 
     * @deprecated use {@link Reflection#forName(String)} instead
     * 
     * @since 1.6
     * @param name the class name
     * @return the loaded class
     * @throws ClassNotFoundException if the class does not exist
     */
    @Deprecated
    public static Class<?> forName(String name) throws ClassNotFoundException {
        return Reflection.forName(name);
    }
    
}
