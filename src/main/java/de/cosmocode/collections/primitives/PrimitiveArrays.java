/**
 * Copyright 2010 CosmoCode GmbH
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

package de.cosmocode.collections.primitives;

import java.util.List;

import com.google.common.base.Preconditions;
import com.google.common.primitives.Booleans;
import com.google.common.primitives.Bytes;
import com.google.common.primitives.Chars;
import com.google.common.primitives.Doubles;
import com.google.common.primitives.Floats;
import com.google.common.primitives.Ints;
import com.google.common.primitives.Longs;
import com.google.common.primitives.Shorts;
import com.google.gag.annotation.remark.OhNoYouDidnt;

/**
 * A static utility class to work with primitive arrays.
 *
 * @since 1.19
 * @author Willi Schoenborn
 */
public final class PrimitiveArrays {

    private PrimitiveArrays() {
        
    }
    
    /**
     * Converts the given primitive array into a {@link List}. This method
     * delegates to the different {@code asList}-methods in this class.
     * The returned list is fixed-sized but mutable. Changes in the backing
     * array will be reflected in the returned list and vice versa.
     *
     * @since 1.19
     * @param primitiveArray the primitive array
     * @return a fixed-sized {@link List} backed by the given array
     * @throws NullPointerException if primitiveArray is null
     * @throws IllegalArgumentException if primitiveArray is not an array or 
     *          the component type of primitiveArray is not primitive
     */
    @OhNoYouDidnt
    public static List<?> asList(Object primitiveArray) {
        Preconditions.checkNotNull(primitiveArray, "PrimitiveArray");
        final Class<?> type = primitiveArray.getClass();
        Preconditions.checkArgument(type.isArray(), "%s is not an array", type);
        final Class<?> componentType = type.getComponentType();
        Preconditions.checkArgument(componentType.isPrimitive(), "%s is not primitive", componentType);

        if (componentType == boolean.class) {
            return asList(boolean[].class.cast(primitiveArray));
        } else if (componentType == byte.class) {
            return asList(byte[].class.cast(primitiveArray));
        } else if (componentType == short.class) {
            return asList(short[].class.cast(primitiveArray));
        } else if (componentType == char.class) {
            return asList(char[].class.cast(primitiveArray));
        } else if (componentType == int.class) {
            return asList(int[].class.cast(primitiveArray));
        } else if (componentType == long.class) {
            return asList(long[].class.cast(primitiveArray));
        } else if (componentType == float.class) {
            return asList(float[].class.cast(primitiveArray));
        } else if (componentType == double.class) {
            return asList(double[].class.cast(primitiveArray));
        } else {
            throw new AssertionError();
        }
    }
    
    /**
     * Returns a {@link Boolean} {@link List}-view on the given array.
     * The returned list is fixed-sized but mutable. Changes in the backing
     * array will be reflected in the returned list and vice versa.
     *
     * @since 1.19
     * @param array the backing array
     * @return the list
     * @throws NullPointerException if array is null
     */
    public static List<Boolean> asList(boolean... array) {
        Preconditions.checkNotNull(array, "Array");
        return Booleans.asList(array);
    }

    /**
     * Returns a {@link Byte} {@link List}-view on the given array.
     * The returned list is fixed-sized but mutable. Changes in the backing
     * array will be reflected in the returned list and vice versa.
     *
     * @since 1.19
     * @param array the backing array
     * @return the list
     * @throws NullPointerException if array is null
     */
    public static List<Byte> asList(byte... array) {
        Preconditions.checkNotNull(array, "Array");
        return Bytes.asList(array);
    }

    /**
     * Returns a {@link Short} {@link List}-view on the given array.
     * The returned list is fixed-sized but mutable. Changes in the backing
     * array will be reflected in the returned list and vice versa.
     *
     * @since 1.19
     * @param array the backing array
     * @return the list
     * @throws NullPointerException if array is null
     */
    public static List<Short> asList(short... array) {
        Preconditions.checkNotNull(array, "Array");
        return Shorts.asList(array);
    }

    /**
     * Returns a {@link Character} {@link List}-view on the given array.
     * The returned list is fixed-sized but mutable. Changes in the backing
     * array will be reflected in the returned list and vice versa.
     *
     * @since 1.19
     * @param array the backing array
     * @return the list
     * @throws NullPointerException if array is null
     */
    public static List<Character> asList(char... array) {
        Preconditions.checkNotNull(array, "Array");
        return Chars.asList(array);
    }

    /**
     * Returns a {@link Integer} {@link List}-view on the given array.
     * The returned list is fixed-sized but mutable. Changes in the backing
     * array will be reflected in the returned list and vice versa.
     *
     * @since 1.19
     * @param array the backing array
     * @return the list
     * @throws NullPointerException if array is null
     */
    public static List<Integer> asList(int... array) {
        Preconditions.checkNotNull(array, "Array");
        return Ints.asList(array);
    }

    /**
     * Returns a {@link Long} {@link List}-view on the given array.
     * The returned list is fixed-sized but mutable. Changes in the backing
     * array will be reflected in the returned list and vice versa.
     *
     * @since 1.19
     * @param array the backing array
     * @return the list
     * @throws NullPointerException if array is null
     */
    public static List<Long> asList(long... array) {
        Preconditions.checkNotNull(array, "Array");
        return Longs.asList(array);
    }

    /**
     * Returns a {@link Float} {@link List}-view on the given array.
     * The returned list is fixed-sized but mutable. Changes in the backing
     * array will be reflected in the returned list and vice versa.
     *
     * @since 1.19
     * @param array the backing array
     * @return the list
     * @throws NullPointerException if array is null
     */
    public static List<Float> asList(float... array) {
        Preconditions.checkNotNull(array, "Array");
        return Floats.asList(array);
    }

    /**
     * Returns a {@link Double} {@link List}-view on the given array.
     * The returned list is fixed-sized but mutable. Changes in the backing
     * array will be reflected in the returned list and vice versa.
     *
     * @since 1.19
     * @param array the backing array
     * @return the list
     * @throws NullPointerException if array is null
     */
    public static List<Double> asList(double... array) {
        Preconditions.checkNotNull(array, "Array");
        return Doubles.asList(array);
    }
    
}
