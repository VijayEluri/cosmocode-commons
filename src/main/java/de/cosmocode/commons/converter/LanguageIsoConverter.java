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
package de.cosmocode.commons.converter;

/**
 * Converts ISO 639-2 coded language Strings (3-letter) into ISO 639-1 coded language Strings (2-letter)
 * and vice-versa.
 *
 * @since 1.8
 * @author Oliver Lorenz
 */
public interface LanguageIsoConverter {

    /**
     * <p> Converts an ISO 639-1 coded language code to ISO 639-2.
     * Example: toThreeLetter("de") would result in "deu".
     * </p>
     * 
     * @since 1.8
     * @param iso6391 the ISO 639-1 language code
     * @return the ISO 639-2 conversion of the parameter
     * @throws NullPointerException if parameter iso6391 is null
     * @throws IllegalArgumentException if parameter iso6391 is neither in iso 639-1 nor iso 639-2
     * @throws IsoConversionException if no ISO 639-2 code is known for the given ISO 639-1 code
     */
    String toThreeLetter(final String iso6391);

    /**
     * <p> Converts an ISO 639-2 coded language code to ISO 639-1.
     * Example: toTwoLetter("deu") would result in "de".
     * </p>
     * <p> If the given parameter is already in ISO 639-2, then it is returned without modifications.
     * </p>
     * 
     * @since 1.8
     * @param iso6392 the ISO 639-2 language code
     * @return the ISO 639-1 conversion of the parameter
     * @throws NullPointerException if parameter iso6392 is null
     * @throws IllegalArgumentException if parameter iso6392 is neither in ISO 639-1 nor ISO 639-2
     * @throws IsoConversionException if no ISO 639-1 code is known for the given ISO 639-2 code
     */
    String toTwoLetter(final String iso6392);

}
