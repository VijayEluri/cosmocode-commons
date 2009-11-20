package de.cosmocode.commons;

import java.util.Locale;
import java.util.regex.Pattern;

/** 
 * Utility class providing constant and
 * frequently used {@link Pattern}s.
 *
 * @author Willi Schoenborn
 * @author Adrian Lang
 */
public final class Patterns {
    
    /**
     * ISO 3166-1 alpha-2 codes are two-letter country codes defined in ISO 3166-1, part of the
     * ISO 3166 standard published by the International Organization for Standardization (ISO), 
     * to represent countries, dependent territories, and special areas of geographical interest.
     * 
     * @see <a href="http://en.wikipedia.org/wiki/ISO_3166-1_alpha-2">Wikpedia</a>
     */
    public static final Pattern ISO_3166_1_ALPHA_2 = Pattern.compile("^[A-Z]{2}$");
    
    /**
     * ISO 639-1 is the first part of the ISO 639 international-standard language-code family.
     * It consists of 136 two-letter codes used to identify the world's major languages. 
     * 
     * @see <a href="http://en.wikipedia.org/wiki/ISO_639-1">Wikipedia</a>
     */
    public static final Pattern ISO_639_1 = Pattern.compile("^[a-z]{2}$");
    
    /**
     * An IATA airport code, also known an IATA location identifier, IATA station code or 
     * simply a location identifier, is a three-letter code designating many airports around 
     * the world, defined by the International Air Transport Association (IATA).
     * 
     * @see <a href="http://en.wikipedia.org/wiki/International_Air_Transport_Association_airport_code">Wikipedia</a>
     */
    public static final Pattern IATA_AIRPORT_CODE = Pattern.compile("^[A-Z]{3}$");
    
    /**
     * {@link Pattern} which matches valid {@link Locale} strings.
     * 
     * <div>
     *   The different parts of the corresponding {@link Locale} are provided in
     *   the following groups:
     *   <ol>
     *     <li>Language</li>
     *     <li>Country</li>
     *     <li>Variant</li>
     *   </ol>
     * </div>
     * 
     * <p>
     *   If a part is missing (which is valid in some cases), the group is
     *   a blank string (either "" or null).
     * </p>
     * 
     * @see {@link Locale#toString()}
     */
    public static final Pattern LOCALE = Pattern.compile("^([a-z]{2}|(?=.+))(?:_([A-Z]{2}|(?=.+))(?:(?<!^_)_(.+))?)?$");
    
    /**
     * Prevent instantiation.
     */
    private Patterns() {
        
    }
    
}
