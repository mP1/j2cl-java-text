/*
 * Copyright 2019 Miroslav Pokorny (github.com/mP1)
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
 *
 */

package walkingkooka.j2cl.java.text;

import walkingkooka.NeverError;
import walkingkooka.ToStringBuilder;
import walkingkooka.collect.list.Lists;
import walkingkooka.j2cl.java.io.string.StringDataInputDataOutput;
import walkingkooka.j2cl.java.util.locale.support.LocaleSupport;
import walkingkooka.text.CharSequences;

import java.io.DataInput;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Currency;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import java.util.Set;

@SuppressWarnings("lgtm[java/inconsistent-equals-and-hashcode]")
public class DecimalFormat extends NumberFormat {

    final static char CURRENCY = '\u00A4';

    final static char DECIMAL_SEPARATOR = '.';

    final static char EXPONENT = 'E';

    final static char GROUPING_SEPARATOR = ',';

    final static char HASH = '#';

    final static char MINUS_SIGN = '-';

    final static char PERCENT = '%';

    final static char PER_MILLE = '\u2030';

    final static char QUOTE = '\'';

    final static char SUB_PATTERN_SEPARATOR = ';';

    final static char ZERO = '0';

    /**
     * Locale to an array of {@link DecimalFormat}, this is used internally to "get" the symbols for a given Locale.
     */
    final static LocaleLookup<DecimalFormat[]> LOCALE_TO_FORMATS = LocaleLookup.empty();

    // indices into the LANGUAGE_TAG_TO_FORMATS array.

    final static int INDEX_CURRENCY = 0;
    final static int INDEX_INSTANCE = 1;
    final static int INDEX_INTEGER = 2;
    final static int INDEX_NUMBER = 3;
    final static int INDEX_PERCENT = 4;

    /**
     * Loads all the {@link DecimalFormatSymbols} data and creates constants.
     */
    static {
        try {
            register(StringDataInputDataOutput.input(DecimalFormatProvider.DATA));
        } catch (final IOException cause) {
            throw new Error(cause);
        }
    }

    /**
     * Intended to only be called by the static init above. A test exists to verify the {@link DataInput} is consumed
     * and further operations will fail with an {@link java.io.EOFException}.
     */
    static void register(final DataInput data) throws IOException {
        final int count = data.readInt();

        for (int i = 0; i < count; i++) {
            register0(LocaleSupport.readLocales(data), // locales
                    data.readBoolean(), // currencyDecimalSeparatorAlwaysShown,
                    data.readInt(), // currencyGroupingSize,
                    data.readBoolean(), // currencyGroupingUsed,
                    data.readInt(), // currencyMaximumFractionDigits,
                    data.readInt(), // currencyMinimumFractionDigits,
                    data.readInt(), // currencyMaximumIntegerDigits,
                    data.readInt(), // currencyMinimumIntegerDigits,
                    data.readInt(), // currencyMultiplier,
                    data.readUTF(), // currencyNegativePrefix,
                    data.readUTF(), // currencyNegativeSuffix,
                    data.readInt(), // currencyParse,
                    data.readUTF(), // currencyPattern,
                    data.readUTF(), // currencyPositivePrefix,
                    data.readUTF(), // currencyPositiveSuffix,
                    readRoundingMode(data), // currencyRoundingMode,

                    data.readBoolean(), // currencyDecimalSeparatorAlwaysShown,
                    data.readInt(), // currencyGroupingSize,
                    data.readBoolean(), // currencyGroupingUsed,
                    data.readInt(), // currencyMaximumFractionDigits,
                    data.readInt(), // currencyMinimumFractionDigits,
                    data.readInt(), // currencyMaximumIntegerDigits,
                    data.readInt(), // currencyMinimumIntegerDigits,
                    data.readInt(), // currencyMultiplier,
                    data.readUTF(), // currencyNegativePrefix,
                    data.readUTF(), // currencyNegativeSuffix,
                    data.readInt(), // currencyParse,
                    data.readUTF(), // currencyPattern,
                    data.readUTF(), // currencyPositivePrefix,
                    data.readUTF(), // currencyPositiveSuffix,
                    readRoundingMode(data), // currencyRoundingMode,

                    data.readBoolean(), // currencyDecimalSeparatorAlwaysShown,
                    data.readInt(), // currencyGroupingSize,
                    data.readBoolean(), // currencyGroupingUsed,
                    data.readInt(), // currencyMaximumFractionDigits,
                    data.readInt(), // currencyMinimumFractionDigits,
                    data.readInt(), // currencyMaximumIntegerDigits,
                    data.readInt(), // currencyMinimumIntegerDigits,
                    data.readInt(), // currencyMultiplier,
                    data.readUTF(), // currencyNegativePrefix,
                    data.readUTF(), // currencyNegativeSuffix,
                    data.readInt(), // currencyParse,
                    data.readUTF(), // currencyPattern,
                    data.readUTF(), // currencyPositivePrefix,
                    data.readUTF(), // currencyPositiveSuffix,
                    readRoundingMode(data), // currencyRoundingMode,

                    data.readBoolean(), // currencyDecimalSeparatorAlwaysShown,
                    data.readInt(), // currencyGroupingSize,
                    data.readBoolean(), // currencyGroupingUsed,
                    data.readInt(), // currencyMaximumFractionDigits,
                    data.readInt(), // currencyMinimumFractionDigits,
                    data.readInt(), // currencyMaximumIntegerDigits,
                    data.readInt(), // currencyMinimumIntegerDigits,
                    data.readInt(), // currencyMultiplier,
                    data.readUTF(), // currencyNegativePrefix,
                    data.readUTF(), // currencyNegativeSuffix,
                    data.readInt(), // currencyParse,
                    data.readUTF(), // currencyPattern,
                    data.readUTF(), // currencyPositivePrefix,
                    data.readUTF(), // currencyPositiveSuffix,
                    readRoundingMode(data), // currencyRoundingMode,

                    data.readBoolean(), // currencyDecimalSeparatorAlwaysShown,
                    data.readInt(), // currencyGroupingSize,
                    data.readBoolean(), // currencyGroupingUsed,
                    data.readInt(), // currencyMaximumFractionDigits,
                    data.readInt(), // currencyMinimumFractionDigits,
                    data.readInt(), // currencyMaximumIntegerDigits,
                    data.readInt(), // currencyMinimumIntegerDigits,
                    data.readInt(), // currencyMultiplier,
                    data.readUTF(), // currencyNegativePrefix,
                    data.readUTF(), // currencyNegativeSuffix,
                    data.readInt(), // currencyParse,
                    data.readUTF(), // currencyPattern,
                    data.readUTF(), // currencyPositivePrefix,
                    data.readUTF(), // currencyPositiveSuffix,
                    readRoundingMode(data) // currencyRoundingMode,
            );
        }
    }

    private static RoundingMode readRoundingMode(final DataInput data) throws IOException {
        return RoundingMode.valueOf(data.readUTF());
    }

    /**
     * Factory called by the static init above.
     */
    private static void register0(final Set<Locale> locales,

                                  final boolean currencyDecimalSeparatorAlwaysShown,
                                  final int currencyGroupingSize,
                                  final boolean currencyGroupingUsed,
                                  final int currencyMaximumFractionDigits,
                                  final int currencyMinimumFractionDigits,
                                  final int currencyMaximumIntegerDigits,
                                  final int currencyMinimumIntegerDigits,
                                  final int currencyMultiplier,
                                  final String currencyNegativePrefix,
                                  final String currencyNegativeSuffix,
                                  final int currencyParse,
                                  final String currencyPattern,
                                  final String currencyPositivePrefix,
                                  final String currencyPositiveSuffix,
                                  final RoundingMode currencyRoundingMode,
                                  
                                  final boolean instanceDecimalSeparatorAlwaysShown,
                                  final int instanceGroupingSize,
                                  final boolean instanceGroupingUsed,
                                  final int instanceMaximumFractionDigits,
                                  final int instanceMinimumFractionDigits,
                                  final int instanceMaximumIntegerDigits,
                                  final int instanceMinimumIntegerDigits,
                                  final int instanceMultiplier,
                                  final String instanceNegativePrefix,
                                  final String instanceNegativeSuffix,
                                  final int instanceParse,
                                  final String instancePattern,
                                  final String instancePositivePrefix,
                                  final String instancePositiveSuffix,
                                  final RoundingMode instanceRoundingMode,
                                  
                                  final boolean integerDecimalSeparatorAlwaysShown,
                                  final int integerGroupingSize,
                                  final boolean integerGroupingUsed,
                                  final int integerMaximumFractionDigits,
                                  final int integerMinimumFractionDigits,
                                  final int integerMaximumIntegerDigits,
                                  final int integerMinimumIntegerDigits,
                                  final int integerMultiplier,
                                  final String integerNegativePrefix,
                                  final String integerNegativeSuffix,
                                  final int integerParse,
                                  final String integerPattern,
                                  final String integerPositivePrefix,
                                  final String integerPositiveSuffix,
                                  final RoundingMode integerRoundingMode,
                                  
                                  final boolean numberDecimalSeparatorAlwaysShown,
                                  final int numberGroupingSize,
                                  final boolean numberGroupingUsed,
                                  final int numberMaximumFractionDigits,
                                  final int numberMinimumFractionDigits,
                                  final int numberMaximumIntegerDigits,
                                  final int numberMinimumIntegerDigits,
                                  final int numberMultiplier,
                                  final String numberNegativePrefix,
                                  final String numberNegativeSuffix,
                                  final int numberParse,
                                  final String numberPattern,
                                  final String numberPositivePrefix,
                                  final String numberPositiveSuffix,
                                  final RoundingMode numberRoundingMode,
                                  
                                  final boolean percentDecimalSeparatorAlwaysShown,
                                  final int percentGroupingSize,
                                  final boolean percentGroupingUsed,
                                  final int percentMaximumFractionDigits,
                                  final int percentMinimumFractionDigits,
                                  final int percentMaximumIntegerDigits,
                                  final int percentMinimumIntegerDigits,
                                  final int percentMultiplier,
                                  final String percentNegativePrefix,
                                  final String percentNegativeSuffix,
                                  final int percentParse,
                                  final String percentPattern,
                                  final String percentPositivePrefix,
                                  final String percentPositiveSuffix,
                                  final RoundingMode percentRoundingMode

    ) {
        final Currency defaultCurrency = Currency.getInstance("XXX");

        for (final Locale locale : locales) {
            String country = locale.getCountry();
            Currency currency;

            try {
                currency = country.length()  == 2?
                        Currency.getInstance(locale) :
                        defaultCurrency;
            } catch (final IllegalArgumentException cause) {
                currency = defaultCurrency;
            }

            final DecimalFormatSymbols symbols = new DecimalFormatSymbols(locale);

            LOCALE_TO_FORMATS.add(locale,
                    new DecimalFormat[]{
                            new DecimalFormat(currency, currencyDecimalSeparatorAlwaysShown, currencyGroupingSize, currencyGroupingUsed, currencyMaximumFractionDigits, currencyMinimumFractionDigits, currencyMaximumIntegerDigits, currencyMinimumIntegerDigits, currencyMultiplier, currencyNegativePrefix, currencyNegativeSuffix, currencyParse, currencyPattern, currencyPositivePrefix, currencyPositiveSuffix, currencyRoundingMode, symbols),
                            new DecimalFormat(currency, instanceDecimalSeparatorAlwaysShown, instanceGroupingSize, instanceGroupingUsed, instanceMaximumFractionDigits, instanceMinimumFractionDigits, instanceMaximumIntegerDigits, instanceMinimumIntegerDigits, instanceMultiplier, instanceNegativePrefix, instanceNegativeSuffix, instanceParse, instancePattern, instancePositivePrefix, instancePositiveSuffix, instanceRoundingMode, symbols),
                            new DecimalFormat(currency, integerDecimalSeparatorAlwaysShown, integerGroupingSize, integerGroupingUsed, integerMaximumFractionDigits, integerMinimumFractionDigits, integerMaximumIntegerDigits, integerMinimumIntegerDigits, integerMultiplier, integerNegativePrefix, integerNegativeSuffix, integerParse, integerPattern, integerPositivePrefix, integerPositiveSuffix, integerRoundingMode, symbols),
                            new DecimalFormat(currency, numberDecimalSeparatorAlwaysShown, numberGroupingSize, numberGroupingUsed, numberMaximumFractionDigits, numberMinimumFractionDigits, numberMaximumIntegerDigits, numberMinimumIntegerDigits, numberMultiplier, numberNegativePrefix, numberNegativeSuffix, numberParse, numberPattern, numberPositivePrefix, numberPositiveSuffix, numberRoundingMode, symbols),
                            new DecimalFormat(currency, percentDecimalSeparatorAlwaysShown, percentGroupingSize, percentGroupingUsed, percentMaximumFractionDigits, percentMinimumFractionDigits, percentMaximumIntegerDigits, percentMinimumIntegerDigits, percentMultiplier, percentNegativePrefix, percentNegativeSuffix, percentParse, percentPattern, percentPositivePrefix, percentPositiveSuffix, percentRoundingMode, symbols),
                    });
        }
    }

    private static DecimalFormat forDefaultLocale() {
        return forLocale(Locale.getDefault(), INDEX_INSTANCE);
    }

    static DecimalFormat forLocale(final Locale locale,
                                   final int selectorIndex) {
        return LOCALE_TO_FORMATS.getOrFail(locale)[selectorIndex];
    }

    /**
     * Ctor used to register locale to decimal format and by {@link #clone()}
     */
    private DecimalFormat(final Currency currency,
                          final boolean decimalSeparatorAlwaysShown,
                          final int groupingSize,
                          final boolean groupingUsed,
                          final int maximumFractionDigits,
                          final int minimumFractionDigits,
                          final int maximumIntegerDigits,
                          final int minimumIntegerDigits,
                          final int multiplier,
                          final String negativePrefix,
                          final String negativeSuffix,
                          final int parse,
                          final String pattern,
                          final String positivePrefix,
                          final String positiveSuffix,
                          final RoundingMode roundingMode,
                          final DecimalFormatSymbols symbols) {
        super();

        this.currency = currency;

        this.decimalSeparatorAlwaysShown = decimalSeparatorAlwaysShown;

        this.groupingSize = groupingSize;
        this.groupingUsed = groupingUsed;

        this.maximumFractionDigits = maximumFractionDigits;
        this.minimumFractionDigits = minimumFractionDigits;
        this.maximumIntegerDigits = maximumIntegerDigits;
        this.minimumIntegerDigits = minimumIntegerDigits;

        this.setMultiplier(multiplier);

        this.negativePrefix = negativePrefix;
        this.negativeSuffix = negativeSuffix;

        switch (parse) {
            case DecimalFormatProvider.PARSE_NONE:
                this.parseBigDecimal = false;
                this.parseIntegerOnly = false;
                break;
            case DecimalFormatProvider.PARSE_INTEGER_ONLY:
                this.parseBigDecimal = false;
                this.parseIntegerOnly = true;
                break;
            case DecimalFormatProvider.PARSE_BIG_DECIMAL:
                this.parseBigDecimal = true;
                this.parseIntegerOnly = false;
                break;
            default:
                this.parseBigDecimal = false;
                this.parseIntegerOnly = false;
                break;
        }

        this.positivePrefix = positivePrefix;
        this.positiveSuffix = positiveSuffix;

        this.roundingMode = roundingMode;
        this.symbols = symbols;

        this.applyPattern(pattern);
    }

    /**
     * Constructs a new {@code DecimalFormat} for formatting and parsing numbers
     * for the default locale.
     */
    public DecimalFormat() {
        super();

        final DecimalFormat decimalFormat = forDefaultLocale();

        this.copySkipPatternSkipSymbols(decimalFormat);
        this.copyPattern(decimalFormat);
        this.symbols = decimalFormat.symbols;
    }

    /**
     * Constructs a new {@code DecimalFormat} using the specified non-localized
     * pattern and the {@code DecimalFormatSymbols} for the default Locale.
     *
     * @param pattern the non-localized pattern.
     * @throws IllegalArgumentException if the pattern cannot be parsed.
     */
    public DecimalFormat(final String pattern) {
        super();

        final DecimalFormat decimalFormat = forDefaultLocale();

        this.copySkipPatternSkipSymbols(decimalFormat);
        this.symbols = decimalFormat.symbols;
        this.applyPattern(pattern); // ignore the decimalFormat.symbols
    }

    /**
     * Constructs a new {@code DecimalFormat} using the specified non-localized
     * pattern and {@code DecimalFormatSymbols}.
     *
     * @param pattern the non-localized pattern.
     * @param symbols the DecimalFormatSymbols.
     * @throws IllegalArgumentException if the pattern cannot be parsed.
     */
    public DecimalFormat(final String pattern,
                         final DecimalFormatSymbols symbols) {
        super();

        final DecimalFormat decimalFormat = forDefaultLocale();

        this.copySkipPatternSkipSymbols(decimalFormat);
        this.setDecimalFormatSymbols(symbols); // ignore the decimalFormat.symbols
        this.applyPattern(pattern); // ignore the decimalFormat.pattern
    }

    /**
     * Copy constructor for internal use by {@link #clone()}.
     */
    private DecimalFormat(final DecimalFormat copy) {
        super();
        this.copySkipPatternSkipSymbols(copy);
        this.copyPattern(copy);
        this.symbols = copy.symbols;
    }

    /**
     * Copies all the properties from {@link DecimalFormat} except for pattern and symbols.
     */
    private void copySkipPatternSkipSymbols(final DecimalFormat copy) {
        this.currency = copy.currency;

        this.decimalSeparator = copy.decimalSeparator;

        this.groupingSize = copy.groupingSize;
        this.groupingUsed = copy.groupingUsed;

        this.maximumFractionDigits = copy.maximumFractionDigits;
        this.minimumFractionDigits = copy.minimumFractionDigits;
        this.maximumIntegerDigits = copy.maximumIntegerDigits;
        this.minimumIntegerDigits = copy.minimumIntegerDigits;

        this.multiplier = copy.multiplier;
        this.multiplierBigDecimal = copy.multiplierBigDecimal;

        this.negativePrefix = copy.negativePrefix;
        this.negativeSuffix = copy.negativeSuffix;

        this.parseBigDecimal = copy.parseBigDecimal;
        this.parseIntegerOnly = copy.parseIntegerOnly;

        this.positivePrefix = copy.positivePrefix;
        this.positiveSuffix = copy.positiveSuffix;

        this.roundingMode = copy.roundingMode;
    }

    private void copyPattern(final DecimalFormat copy) {
        this.pattern = copy.pattern;

        this.numberComponents = copy.numberComponents;

        this.negativePrefix = copy.negativePrefix;
        this.negativePrefixComponents = copy.negativePrefixComponents;
        this.negativeSuffix = copy.negativeSuffix;
        this.negativeSuffixComponents = copy.negativeSuffixComponents;

        this.positivePrefix = copy.positivePrefix;
        this.positivePrefixComponents = copy.positivePrefixComponents;
        this.positiveSuffix = copy.positiveSuffix;
        this.positiveSuffixComponents = copy.positiveSuffixComponents;

        this.customNegativePrefixSuffix = copy.customNegativePrefixSuffix;
    }

    /**
     * Changes the pattern of this decimal format to the specified pattern which
     * uses non-localized pattern characters.
     *
     * @param pattern the non-localized pattern.
     * @throws IllegalArgumentException if the pattern cannot be parsed.
     */
    public void applyPattern(final String pattern) {
        Objects.requireNonNull(pattern, "pattern");

        if (pattern.isEmpty()) {
            this.applyPatternEmpty();
        } else {
            this.applyPatternNotEmpty(pattern);
        }
    }

    private void applyPatternEmpty() {
        this.numberComponents = EMPTY_PATTERN_COMPONENTS;

        this.positivePrefix = "";
        this.positivePrefixComponents = Lists.empty();

        this.negativeSuffix = "";
        this.negativeSuffixComponents = Lists.empty();

        this.setMinimumIntegerDigits(0);
        this.setMaximumIntegerDigits(MAXIMUM_INTEGER_DIGITS);
        this.setMinimumFractionDigits(0);
        this.setMaximumFractionDigits(MAXIMUM_FRACTION_DIGITS);

        this.setGroupingSize(DEFAULT_GROUPING_SIZE);
        this.setGroupingUsed(true);

        this.setMultiplier(1);

        this.decimalSeparator = false;
        this.customNegativePrefixSuffix = false;
    }

    private static final List<DecimalFormatPatternComponent> EMPTY_PATTERN_COMPONENTS = Lists.of(DecimalFormatPatternComponent.zero());

    private static final int DEFAULT_GROUPING_SIZE = 3;
    private static final int MAXIMUM_INTEGER_DIGITS  = Integer.MAX_VALUE;
    private static final int MAXIMUM_FRACTION_DIGITS = Integer.MAX_VALUE;

    private void applyPatternNotEmpty(final String pattern) {
        final DecimalFormatPatternParserNumber positive = DecimalFormatPatternParserNumber.with(pattern, 0);
        positive.parse();

        boolean currency = positive.currency;

        final int groupingSize = positive.groupingSize;
        final int multiplier = positive.multiplier;

        // String versions will be computed later.
        final List<DecimalFormatPatternComponent> positivePrefixComponents = positive.prefix;
        final List<DecimalFormatPatternComponent> positiveSuffixComponents = positive.suffix;

        final List<DecimalFormatPatternComponent> negativePrefixComponents;
        final List<DecimalFormatPatternComponent> negativeSuffixComponents;

        final boolean custom;

        final int position = positive.position;
        if (position < pattern.length()) {
            final DecimalFormatPatternParserNumber negative = DecimalFormatPatternParserNumber.with(pattern, position + 1);
            negative.parse();

            // if negative pattern has its on subPatternSeparator character fail!
            if (negative.subPatternSeparator) {
                negative.failInvalidCharacter();
            }

            currency |= negative.currency;

            // if negative prefix is empty make it minus only if there was no +ve/-ve prefix
            final List<DecimalFormatPatternComponent> prefix = negative.prefix;
            negativePrefixComponents = prefix.isEmpty() && positivePrefixComponents.isEmpty() && positiveSuffixComponents.isEmpty() ?
                    NEGATIVE_PREFIX_MINUS_SIGN :
                    prefix;

            negativeSuffixComponents = negative.suffix;

            custom = true;

            // ignore groupingSeparator, multiplier from negative.
        } else {
            // no negative pattern...negative prefix is minus sign + positive prefix
            negativePrefixComponents = Lists.array();
            negativePrefixComponents.add(DecimalFormatPatternComponent.minusSign());
            negativePrefixComponents.addAll(positivePrefixComponents);

            negativeSuffixComponents = positiveSuffixComponents;

            custom = false;
        }

        // commit pattern changes to this.
        this.setGroupingSize(groupingSize);
        this.setGroupingUsed(groupingSize > 0);
        this.setMultiplier(multiplier);

        this.maximumFractionDigits = positive.maximumFractionDigits;
        this.minimumFractionDigits = positive.minimumFractionDigits;

        this.maximumIntegerDigits = positive.maximumIntegerDigits;
        this.minimumIntegerDigits = positive.minimumIntegerDigits;

        this.numberComponents = positive.number;
        this.decimalSeparator = positive.hasDecimalSeparator();

        this.positivePrefixComponents = positivePrefixComponents;
        this.positivePrefix = this.toPatternLocalized(positivePrefixComponents);
        this.positiveSuffixComponents = positiveSuffixComponents;
        this.positiveSuffix = this.toPatternLocalized(positiveSuffixComponents);

        this.negativePrefixComponents = negativePrefixComponents;
        this.negativePrefix = this.toPatternLocalized(negativePrefixComponents);
        this.negativeSuffixComponents = negativeSuffixComponents;
        this.negativeSuffix = this.toPatternLocalized(negativeSuffixComponents);

        this.customNegativePrefixSuffix = custom;
        this.scientificFormat = positive.isScientificFormat();
    }

    /**
     * Patterns that include a negative sub pattern without a prefix defaults to prefix = minus sign.
     */
    private final static List<DecimalFormatPatternComponent> NEGATIVE_PREFIX_MINUS_SIGN = Lists.of(DecimalFormatPatternComponent.minusSign());

    /**
     * Returns the pattern of this decimal format using non-localized pattern
     * characters.
     *
     * @return the non-localized pattern.
     */
    public String toPattern() {
        if (null == this.pattern) {
            final StringBuilder b = new StringBuilder();

            final List<DecimalFormatPatternComponent> number = this.numberComponents;
            final boolean addDecimal = this.decimalSeparatorAlwaysShown && false == this.decimalSeparator;

            toPattern(this.positivePrefixComponents(), b);
            toPattern(number, b);
            if (addDecimal) {
                b.append(DecimalFormat.DECIMAL_SEPARATOR);
            }
            toPattern(this.positiveSuffixComponents(), b);

            if (this.customNegativePrefixSuffix) {
                b.append(DecimalFormat.SUB_PATTERN_SEPARATOR);

                toPattern(this.negativePrefixComponents(), b);
                toPattern(number, b);
                if (addDecimal) {
                    b.append(DecimalFormat.DECIMAL_SEPARATOR);
                }
                toPattern(this.negativeSuffixComponents(), b);
            }

            this.pattern = b.toString();
        }
        return this.pattern;
    }

    /**
     * Converts the components into a pattern without localizing special symbols like decimal separator.
     */
    private static void toPattern(final List<DecimalFormatPatternComponent> components,
                                  final StringBuilder b) {
        for (final DecimalFormatPatternComponent component : components) {
            component.toPattern(b);
        }
    }

    /**
     * Converts the components into a pattern localizing locale aware components such as currency.
     */
    private String toPatternLocalized(final List<DecimalFormatPatternComponent> components) {
        final DecimalFormatSymbols symbols = this.symbols;

        final StringBuilder b = new StringBuilder();
        for (final DecimalFormatPatternComponent component : components) {
            component.toPatternLocalized(symbols, b);
        }
        return b.toString();
    }

    /**
     * This method should be called by all prefix/suffix setters.
     */
    private void recomputePattern() {
        this.pattern = null;
        this.customNegativePrefixSuffix = true;
    }

    private String pattern;
    private boolean customNegativePrefixSuffix = false;

    /**
     * When true the pattern contains an exponent and thus is in scientific format.
     */
    private boolean scientificFormat;

    // format...........................................................................................................

    @Override
    public StringBuffer format(final double number,
                               final StringBuffer append,
                               final FieldPosition position) {


        return Double.isNaN(number) ?
                this.formatDoubleNan(number, append, position) :
                Double.isInfinite(number) ?
                        this.formatDoubleInfinite(number, append, position) :
                        number >= 0 ?
                                this.formatBigDecimal(BigDecimal.valueOf(number), append, this.positivePrefix, this.positiveSuffix) :
                                this.formatBigDecimal(BigDecimal.valueOf(-number), append, this.negativePrefix, this.negativeSuffix);
    }

    private StringBuffer formatDoubleInfinite(final double value,
                                            final StringBuffer append,
                                            final FieldPosition position) {
        final String prefix;
        final String suffix;

        if (value > 0) {
            prefix = this.positivePrefix;
            suffix = this.positiveSuffix;
        } else {
            prefix = this.negativePrefix;
            suffix = this.negativeSuffix;
        }

        append.append(prefix);
        append.append(this.getDecimalFormatSymbols().getInfinity());
        append.append(suffix);

        return append;
    }

    /**
     * To match the behaviour of {@link java.text.DecimalFormat#format(double)}, no prefix or suffix is included in the
     * formatted output.
     */
    private StringBuffer formatDoubleNan(final double value,
                                       final StringBuffer append,
                                       final FieldPosition position) {
        append.append(this.getDecimalFormatSymbols().getNaN());
        return append;
    }

    @Override
    public StringBuffer format(final long number,
                               final StringBuffer append,
                               final FieldPosition position) {
        return number >= 0 ?
                this.formatBigDecimal(BigDecimal.valueOf(number), append, this.positivePrefix, this.positiveSuffix) :
                this.formatBigDecimal(BigDecimal.valueOf(-number), append, this.negativePrefix, this.negativeSuffix);
    }

    /**
     * Dispatches the given value and its associated parameters to either scientific or non scientific handling.
     */
    private StringBuffer formatBigDecimal(final BigDecimal value,
                                        final StringBuffer append,
                                        final String prefix,
                                        final String suffix) {
        append.append(prefix);
        if (this.scientificFormat) {
            this.formatBigDecimalScientific(value, append);
        } else {
            this.formatBigDecimalDecimal(value, append);
        }
        return append.append(suffix);
    }

    /**
     * Handles formatting the given absolute/positive value into characters as a decimal format.
     */
    private void formatBigDecimalDecimal(final BigDecimal value,
                                       final StringBuffer append) {
        final DecimalFormatSymbols symbols = this.symbols;

        final int maxInteger = this.maximumIntegerDigits;
        final int minInteger = this.minimumIntegerDigits;

        final int maxFraction = this.maximumFractionDigits;

        // round to $maxFractionDigits decimal places
        final BigDecimal rounded = value
                .multiply(this.multiplierBigDecimal) // required might be a percent/perMille or have a custom multiplier.
                .setScale(maxFraction, this.roundingMode);

        final String digits = rounded.abs().unscaledValue().toString();

        final int precision = rounded.precision();
        final int scale = rounded.scale();
        final char zero = symbols.getZeroDigit();

        // add integer digits with grouping separator if necessary......................................................
        {
            CharSequence integer = digits.substring(0, precision - scale);
            if (integer.length() < minInteger) {
                integer = CharSequences.padLeft(integer, minInteger, '0');
            }
            final int integerDigitCount = integer.length();
            int i = maxInteger < integerDigitCount ?
                    integerDigitCount - maxInteger :
                    0;

            // add the portion integer digits that will include grouping
            if (this.isGroupingUsed()) {
                final int groupingSize = this.groupingSize;
                final char groupingSeparator = symbols.getGroupingSeparator();

                final int stopGrouping = integerDigitCount - groupingSize;
                while (i < stopGrouping) {

                    append.append(translate(integer.charAt(i), zero));
                    i++;

                    if (0 == (integerDigitCount - i) % groupingSize) {
                        append.append(groupingSeparator);
                    }
                }
            }

            // add remainder of digits without any grouping...
            while (i < integerDigitCount) {
                append.append(translate(integer.charAt(i), zero));
                i++;
            }
        }

        // add fraction digits..........................................................................................
        {
            CharSequence fraction = digits.substring(precision - scale);
            if (CharSequences.isNullOrEmpty(fraction)) {
                if (this.decimalSeparatorAlwaysShown) {
                    append.append(symbols.getDecimalSeparator());
                }
            } else {
                append.append(symbols.getDecimalSeparator());

                for (final char c : fraction.toString().toCharArray()) {
                    append.append(translate(c, zero));
                }
            }
        }
    }

    /**
     * Handles formatting the given absolute/positive value into characters as a scientific format.
     */
    private void formatBigDecimalScientific(final BigDecimal value,
                                          final StringBuffer append) {
        final DecimalFormatSymbols symbols = this.symbols;

        final int maxInteger = this.maximumIntegerDigits;
        final int maxFraction = this.maximumFractionDigits;
        final int minFraction = this.minimumFractionDigits;

        final BigDecimal rounded = value.multiply(this.multiplierBigDecimal)// required might be a percent/perMille or have a custom multiplier.
                .movePointLeft(-maxInteger - maxFraction)
                .setScale(0, this.roundingMode)
                .stripTrailingZeros();

        int powerOfTen = value.precision() - value.scale();

        final int integerDigitCount;
        final int minFractionDigitCount;
        final int maxFractionDigitCount;

        if (maxInteger > 1) {
            integerDigitCount = ((maxInteger - 1) % maxInteger) + 1;

            final int delta = maxInteger - integerDigitCount;
            minFractionDigitCount = minFraction + delta;
            maxFractionDigitCount = maxFraction + delta;
        } else {
            integerDigitCount = 1;
            final int delta = maxInteger - integerDigitCount;
            minFractionDigitCount = minFraction + delta;
            maxFractionDigitCount = maxFraction + delta;
        }

        // mantissa......................................................................................................
        final char zero = symbols.getZeroDigit();

        final String digits = rounded.unscaledValue().toString();
        final int digitCount = digits.length();
        int next = 0;

        // integer......................................................................................................
        {
            int i = 0;

            while (next < digitCount && i < integerDigitCount) {
                append.append(translate(digits.charAt(next), zero));
                next++;
                i++;
                powerOfTen--;
            }
        }

        // fraction......................................................................................................
        {
            int i = 0;

            if ((next < digitCount && i < maxFractionDigitCount) ||
                    i < minFractionDigitCount ||
                    this.decimalSeparatorAlwaysShown) {
                append.append(symbols.getDecimalSeparator());
            }

            while (next < digitCount && i < maxFractionDigitCount) {
                append.append(translate(digits.charAt(next), zero));

                next++;
                i++;
            }

            while (i < minFractionDigitCount) {
                append.append(zero);
                i++;
            }
        }

        // exponent......................................................................................................
        append.append(symbols.getExponentSeparator());

        if (powerOfTen < 0) {
            append.append(symbols.getMinusSign());
        }

        for (final char c : String.valueOf(Math.abs(powerOfTen)).toCharArray()) {
            append.append(translate(c, zero));
        }
    }

    /**
     * Handles translating zero based digits to a new base.
     */
    private static char translate(final char digit,
                                  final char zero) {
        return (char) (digit - '0' + zero);
    }

    // parse............................................................................................................

    @Override
    public Number parse(final String source,
                        final ParsePosition position) {
        final int index = position.getIndex();

        Number result = this.parseNan(source, position);
        if (null == result) {
            result = this.parsePrefixNumberSuffix(source, position, this.positivePrefix, this.positiveSuffix, new StringBuilder());
            if (null == result) {
                position.setIndex(index);
                result = this.parsePrefixNumberSuffix(source, position, this.negativePrefix, this.negativeSuffix, new StringBuilder("-"));

                // if no Number parsed and no error set error.
                if (null == result && position.getErrorIndex() == -1) {
                    position.setErrorIndex(index);
                }
            }
        }

        return result;
    }

    /**
     * If the text matches the NAN without prefix or suffix return {@link Double#NaN}.
     */
    private Number parseNan(final String text,
                            final ParsePosition position) {
        final Number result;

        final String nan = this.getDecimalFormatSymbols().getNaN();
        if(text.equals(nan)) {
            result = Double.NaN;
            position.setIndex(nan.length());
        } else {
            result = null;
        }

        return result;
    }

    private Number parsePrefixNumberSuffix(final String text,
                                         final ParsePosition position,
                                         final String prefix,
                                         final String suffix,
                                         final StringBuilder digits) {
        Number result = null;

        if (subTextEquals(text, position, prefix)) {
            position.setIndex(position.getIndex() + prefix.length());

            result = this.parseInfinityOrNumber(text, position, digits);

            if (null != result) {
                if (subTextEquals(text, position, suffix)) {
                    position.setIndex(position.getIndex() + suffix.length());
                }
            }
        }

        return result;
    }

    /**
     * Tests if the text contains infinity otherwise tries to {@link #parseNumber(String, ParsePosition, StringBuilder)}
     */
    private Number parseInfinityOrNumber(final String text,
                                       final ParsePosition position,
                                       final StringBuilder digits) {
        final Number result;

        final String infinity = this.getDecimalFormatSymbols().getInfinity();
        if (subTextEquals(text, position, infinity)) {
            position.setIndex(position.getIndex() + infinity.length());

            result = digits.length() == 0 ?
                    Double.POSITIVE_INFINITY :
                    Double.NEGATIVE_INFINITY;
        } else {
            result = this.parseNumber(text, position, digits);
        }

        return result;
    }

    /**
     * Only returns true if the source contains text at {@link ParsePosition}.
     */
    private static boolean subTextEquals(final String text,
                                       final ParsePosition position,
                                       final String subText) {
        return subTextEquals(text, position.getIndex(), subText);
    }

    private static boolean subTextEquals(final String text,
                                       final int index,
                                       final String subText) {
        return index < text.length() && text.substring(index).startsWith(subText);
    }

    /**
     * Parses the given text into a {@link Number} honouring {@link #isParseBigDecimal()} and {@link #isParseIntegerOnly()}.
     * Note both {@link #getMinimumIntegerDigits()} and {@link #getMinimumFractionDigits()} are ignored to match
     * behaviour with the real {@link java.text.DecimalFormat}.
     */
    private Number parseNumber(final String text,
                               final ParsePosition position,
                               final StringBuilder digits) {
        final DecimalFormatSymbols symbols = this.getDecimalFormatSymbols();

        final char decimalSeparator = symbols.getDecimalSeparator();
        final char zero = symbols.getZeroDigit();
        final String exponent = symbols.getExponentSeparator();
        final char minus = symbols.getMinusSign();

        final boolean groupingUsed = this.isGroupingUsed();
        final char grouping = symbols.getGroupingSeparator();

        final int maxInt = this.getMaximumIntegerDigits();

        int integerDigitCount = 0;
        int fractionDigitCount = 0;

        boolean exponentSign = false;
        final boolean parseIntegerOnly = this.isParseIntegerOnly();

        final int textLength = text.length();

        int mode = MODE_INTEGER;

        int index = position.getIndex();
        int errorIndex = position.getErrorIndex();

        Exit:
        //
        while (index < textLength) {
            final char c = text.charAt(index);

            switch (mode) {
                case MODE_INTEGER: {
                    if (groupingUsed && grouping == c) {
                        index++;
                        break;
                    }
                    final int digitValue = c - zero;
                    if (digitValue >= 0 && digitValue <= 9) {
                        integerDigitCount++;
                        if (integerDigitCount > maxInt) {
                            errorIndex = index;
                            break Exit;
                        }
                        digits.append(digitValue);
                        index++;
                        break;
                    }

                    // stop parsing the remainder of the text
                    if (parseIntegerOnly) {
                        break Exit;
                    }

                    if (decimalSeparator == c) {
                        digits.append('.');
                        index++;
                        mode = MODE_FRACTION;
                        break;
                    }

                    // invalid digit, could be exponent
                    if (subTextEquals(text, index, exponent)) {
                        digits.append('E');
                        index += exponent.length();
                        mode = MODE_EXPONENT;
                        break;
                    }

                    // invalid character give up
                    break Exit;
                }
                case MODE_FRACTION: {
                    final int digitValue = c - zero;
                    if (digitValue >= 0 && digitValue <= 9) {
                        fractionDigitCount++;
                        digits.append(digitValue);
                        index++;
                        break;
                    }

                    // invalid digit, could be exponent
                    if (subTextEquals(text, index, exponent)) {
                        digits.append('E');
                        index += exponent.length();
                        mode = MODE_EXPONENT;
                        break;
                    }
                    // invalid character give up
                    break Exit;
                }
                case MODE_EXPONENT:
                    if (minus == c) {
                        if (exponentSign) {
                            break Exit;
                        }
                        digits.append('-');
                        exponentSign = true;
                        index++;
                        break;
                    }
                    final int digitValue = c - zero;
                    if (digitValue >= 0 && digitValue <= 9) {
                        digits.append(digitValue);
                        index++;
                        break;
                    }
                    // invalid character give up
                    break Exit;
                default:
                    NeverError.unhandledCase(mode, MODE_INTEGER, MODE_FRACTION, MODE_EXPONENT);
            }
        }

        position.setIndex(index);
        position.setErrorIndex(errorIndex);

        Number result = null;

        // if no error and some digits were found, convert to the desired Number type...................................
        if (errorIndex == -1 && integerDigitCount + fractionDigitCount > 0) {
            final BigDecimal bigDecimal = integerDigitCount + fractionDigitCount > 0 ?
                    new BigDecimal(digits.toString()).divide(this.multiplierBigDecimal) :
                    BigDecimal.ZERO;
            if (this.isParseBigDecimal()) {
                result = bigDecimal;
            } else {
                if (parseIntegerOnly) {
                    result = bigDecimal.longValue();
                } else {
                    try {
                        result = bigDecimal.setScale(0, RoundingMode.UNNECESSARY)
                                .longValue();
                    } catch (final ArithmeticException ignore) {
                        result = bigDecimal.doubleValue();
                    }
                }
            }
        }

        return result;
    }

    /**
     * Processing digits before the decimal separator or exponent.
     */
    private final static int MODE_INTEGER = 1;

    /**
     * Consuming digits after the decimal separator and before the exponent.
     */
    private final static int MODE_FRACTION = 2;

    /**
     * Consuming the exponent
     */
    private final static int MODE_EXPONENT = 3;

    /**
     * Positive ill never be null and will be updated by {@link #applyPattern(String)}.
     */
    private List<DecimalFormatPatternComponent> numberComponents;

    /**
     * Will be true if the {@link #numberComponents} contains a {@link DecimalFormatPatternComponentDecimalSeparator}
     */
    private boolean decimalSeparator;

    // currency.........................................................................................................

    public Currency getCurrency() {
        return this.currency;
    }

    public void setCurrency(final Currency currency) {
        Objects.requireNonNull(currency, "currency");
        this.currency = currency;
    }

    private Currency currency;

    // decimalSeparatorAlwaysShown......................................................................................

    /**
     * Indicates whether the decimal separator is shown when there are no
     * fractional digits.
     *
     * @return {@code true} if the decimal separator should always be formatted;
     * {@code false} otherwise.
     */
    public boolean isDecimalSeparatorAlwaysShown() {
        return this.decimalSeparatorAlwaysShown;
    }

    /**
     * Sets whether the decimal separator is shown when there are no fractional
     * digits.
     *
     * @param value
     *            {@code true} if the decimal separator should always be
     *            formatted; {@code false} otherwise.
     */
    public void setDecimalSeparatorAlwaysShown(final boolean value) {
        if (this.decimalSeparatorAlwaysShown != value) {
            this.pattern = null; // the change in decimalSeparatorAlwaysShown affects the cached pattern in String form.
        }
        this.decimalSeparatorAlwaysShown = value;
    }

    private boolean decimalSeparatorAlwaysShown;

    // GroupingSize.....................................................................................................

    public int getGroupingSize() {
        return this.groupingSize;
    }

    public void setGroupingSize(final int groupingSize) {
        this.groupingSize = Math.max(0, groupingSize);
    }

    private int groupingSize;

    // Multiplier.....................................................................................................

    public int getMultiplier() {
        return this.multiplier;
    }

    public void setMultiplier(final int multiplier) {
        this.multiplier = Math.max(0, multiplier);
        this.multiplierBigDecimal = BigDecimal.valueOf(this.multiplier);
    }

    private int multiplier;
    private BigDecimal multiplierBigDecimal;

    // NegativePrefix.....................................................................................................

    public String getNegativePrefix() {
        return this.negativePrefix;
    }

    public void setNegativePrefix(final String negativePrefix) {
        this.negativePrefix = negativePrefix;
        this.negativePrefixComponents = null;
        this.recomputePattern();
    }

    private String negativePrefix;

    private List<DecimalFormatPatternComponent> negativePrefixComponents() {
        if (null == this.negativePrefixComponents) {
            this.negativePrefixComponents = DecimalFormatPatternParserPrefixSuffix.parseAndGetComponents(this.negativePrefix, "negativePrefix");
        }
        return this.negativePrefixComponents;
    }

    private List<DecimalFormatPatternComponent> negativePrefixComponents;

    // NegativeSuffix.....................................................................................................

    public String getNegativeSuffix() {
        return this.negativeSuffix;
    }

    public void setNegativeSuffix(final String negativeSuffix) {
        this.negativeSuffix = negativeSuffix;
        this.negativeSuffixComponents = null;
        this.recomputePattern();
    }

    private String negativeSuffix;

    private List<DecimalFormatPatternComponent> negativeSuffixComponents() {
        if (null == this.negativeSuffixComponents) {
            this.negativeSuffixComponents = DecimalFormatPatternParserPrefixSuffix.parseAndGetComponents(this.negativeSuffix, "negativeSuffix");
        }
        return this.negativeSuffixComponents;
    }

    private List<DecimalFormatPatternComponent> negativeSuffixComponents;

    // parseBigDecimal...................................................................................................

    public boolean isParseBigDecimal() {
        return this.parseBigDecimal;
    }

    public void setParseBigDecimal(final boolean parseBigDecimal) {
        this.parseBigDecimal = parseBigDecimal;

        // tests show parseIntegerOnly is not modified.
    }

    private boolean parseBigDecimal;

    // PositivePrefix.....................................................................................................

    public String getPositivePrefix() {
        return this.positivePrefix;
    }

    public void setPositivePrefix(final String positivePrefix) {
        this.positivePrefix = positivePrefix;
        this.positivePrefixComponents = null;
        this.recomputePattern();
    }

    private String positivePrefix;

    private List<DecimalFormatPatternComponent> positivePrefixComponents() {
        if (null == this.positivePrefixComponents) {
            this.positivePrefixComponents = DecimalFormatPatternParserPrefixSuffix.parseAndGetComponents(this.positivePrefix, "positivePrefix");
        }
        return this.positivePrefixComponents;
    }

    private List<DecimalFormatPatternComponent> positivePrefixComponents;

    // PositiveSuffix.....................................................................................................

    public String getPositiveSuffix() {
        return this.positiveSuffix;
    }

    public void setPositiveSuffix(final String positiveSuffix) {
        this.positiveSuffix = positiveSuffix;
        this.positiveSuffixComponents = null;
        this.recomputePattern();
    }

    private String positiveSuffix;

    private List<DecimalFormatPatternComponent> positiveSuffixComponents() {
        if (null == this.positiveSuffixComponents) {
            this.positiveSuffixComponents = DecimalFormatPatternParserPrefixSuffix.parseAndGetComponents(this.positiveSuffix, "positiveSuffix");
        }
        return this.positiveSuffixComponents;
    }

    private List<DecimalFormatPatternComponent> positiveSuffixComponents;

    // RoundingMode.....................................................................................................

    public RoundingMode getRoundingMode() {
        return this.roundingMode;
    }

    public void setRoundingMode(final RoundingMode roundingMode) {
        Objects.requireNonNull(roundingMode, "roundingMode");
        this.roundingMode = roundingMode;
    }

    private RoundingMode roundingMode;

    // symbols..........................................................................................................

    /**
     * Returns the {@code DecimalFormatSymbols} used by this decimal format.
     *
     * @return a copy of the {@code DecimalFormatSymbols} used by this decimal
     *         format.
     */
    public DecimalFormatSymbols getDecimalFormatSymbols() {
        return this.symbols.cloneState();
    }

    /**
     * Sets the {@code DecimalFormatSymbols} used by this decimal format.
     *
     * @param symbols
     *            the {@code DecimalFormatSymbols} to set.
     */
    public void setDecimalFormatSymbols(final DecimalFormatSymbols symbols) {
        if (symbols != null) {
            this.symbols = symbols.cloneState();
        }
    }

    DecimalFormatSymbols symbols;

    // clone...........................................................................................................

    /**
     * Because {@link DecimalFormat} is mutable clones must be made by the various static getters.
     */
    public DecimalFormat clone() {
        return new DecimalFormat(this);
    }

    // Object...........................................................................................................

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(),
                this.decimalSeparatorAlwaysShown,
                this.groupingSize,
                this.groupingUsed,
                this.multiplier,
                this.negativePrefix,
                this.negativeSuffix,
                this.numberComponents,
                this.parseBigDecimal,
                this.pattern,
                this.positivePrefix,
                this.positiveSuffix,
                this.roundingMode,
                this.symbols);
    }

    @Override
    boolean canBeEqual(final Object other) {
        return other instanceof DecimalFormat;
    }

    @Override
    boolean equals0(final NumberFormat other) {
        return super.equals0(other) && this.equals1((DecimalFormat) other);
    }

    private boolean equals1(final DecimalFormat other) {
        return this.currency.equals(other.currency) &&
                this.decimalSeparatorAlwaysShown == other.decimalSeparatorAlwaysShown &&
                this.groupingSize == other.groupingSize &&
                this.groupingUsed == other.groupingUsed &&
                this.maximumFractionDigits == other.maximumFractionDigits &&
                this.minimumFractionDigits == other.minimumFractionDigits &&
                this.maximumIntegerDigits == other.maximumIntegerDigits &&
                this.minimumIntegerDigits == other.minimumIntegerDigits &&
                this.multiplier == other.multiplier &&
                this.negativePrefix.equals(other.negativePrefix) &&
                this.negativeSuffix.equals(other.negativeSuffix) &&
                this.numberComponents.equals(other.numberComponents) &&
                this.parseBigDecimal == other.parseBigDecimal &&
                this.parseIntegerOnly == other.parseIntegerOnly &&
                this.positivePrefix.equals(other.positivePrefix) &&
                this.positiveSuffix.equals(other.positiveSuffix) &&
                this.roundingMode == other.roundingMode &&
                this.symbols.equals(other.symbols);
    }

    @Override
    public String toString() {
        return ToStringBuilder.empty()
                .valueSeparator("")
                .label("currency").value(this.currency)
                .label("decimalSeparatorAlwaysShown").value(this.decimalSeparatorAlwaysShown)
                .label("groupingSize").value(this.groupingSize)
                .label("groupingUsed").value(this.groupingUsed)
                .label("maximumFractionDigits").value(this.maximumFractionDigits)
                .label("minimumFractionDigits").value(this.minimumFractionDigits)
                .label("maximumIntegerDigits").value(this.maximumIntegerDigits)
                .label("minimumIntegerDigits").value(this.minimumIntegerDigits)
                .label("multiplier").value(this.multiplier)
                .label("negativePrefix").value(this.negativePrefix)
                .label("negativeSuffix").value(this.negativeSuffix)
                .label("numberComponents").value(this.numberComponents)
                .label("parseBigDecimalOnly").value(this.parseBigDecimal)
                .label("parseIntegerOnly").value(this.parseIntegerOnly)
                .label("pattern").value(this.pattern)
                .label("positivePrefix").value(this.positivePrefix)
                .label("positiveSuffix").value(this.positiveSuffix)
                .label("roundingMode").value(this.roundingMode)
                .label("symbols").value(this.symbols)
                .build();
    }
}
