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
package de.cosmocode.commons;

import com.google.common.base.Preconditions;

import java.util.Locale;

/**
 * Implementation for {@link Strings#toLowerCase(Locale)}.
 *
 * @since 1.9
 * @author Willi Schoenborn
 */
final class LocaleAwareLowerCaseFunction extends AbstractFunction<String, String> {

    private final Locale locale;
    
    public LocaleAwareLowerCaseFunction(Locale locale) {
        this.locale = Preconditions.checkNotNull(locale, "Locale");
    }
    
    @Override
    public String apply(String from) {
        return from == null ? null : from.toLowerCase(locale);
    }
    
    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        } else if (that instanceof LocaleAwareLowerCaseFunction) {
            final LocaleAwareLowerCaseFunction other = LocaleAwareLowerCaseFunction.class.cast(that);
            return locale.equals(other.locale);
        } else {
            return false;
        }
    }
    
    @Override
    public int hashCode() {
        return locale.hashCode() ^ -921210296;
    }
    
    @Override
    public String toString() {
        return "Strings.toLowerCase(" + locale + ")";
    }
    
}
