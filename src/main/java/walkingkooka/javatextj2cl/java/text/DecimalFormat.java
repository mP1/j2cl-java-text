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

package walkingkooka.javatextj2cl.java.text;

import walkingkooka.NeverError;
import walkingkooka.ToStringBuilder;
import walkingkooka.collect.list.Lists;

import java.math.RoundingMode;
import java.util.Currency;
import java.util.List;
import java.util.Locale;
import java.util.Objects;

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
     * Language tag to an array of {@link DecimalFormat}, this is used internally to "get" the symbols for a given Locale.
     */
    final static LanguageTagLookup<DecimalFormat[]> LANGUAGE_TAG_TO_FORMATS = LanguageTagLookup.empty();

    /**
     * Registers all locale and their formats.
     */
    static {
        DecimalFormatProvider.register();
    }

    // indices into the LANGUAGE_TAG_TO_FORMATS array.

    final static int INDEX_CURRENCY = 0;
    final static int INDEX_INSTANCE = 1;
    final static int INDEX_INTEGER = 2;
    final static int INDEX_NUMBER = 3;
    final static int INDEX_PERCENT = 4;

    /**
     * Factory called by {@link DecimalFormatProvider#register()}, recording a DecimalFormat for currency,
     * instance, integer, number and percent for one or more {@link Locale}.
     */
    static void register(final String languageTags,

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

        for (final String languageTag : languageTags.split("\t")) {
            final Locale locale = Locale.forLanguageTag(languageTag);

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

            LANGUAGE_TAG_TO_FORMATS.add(languageTag,
                    new DecimalFormat[]{
                            new DecimalFormat(currency, currencyGroupingSize, currencyGroupingUsed, currencyMaximumFractionDigits, currencyMinimumFractionDigits, currencyMaximumIntegerDigits, currencyMinimumIntegerDigits, currencyMultiplier, currencyNegativePrefix, currencyNegativeSuffix, currencyParse, currencyPattern, currencyPositivePrefix, currencyPositiveSuffix, currencyRoundingMode, symbols),
                            new DecimalFormat(currency, instanceGroupingSize, instanceGroupingUsed, instanceMaximumFractionDigits, instanceMinimumFractionDigits, instanceMaximumIntegerDigits, instanceMinimumIntegerDigits, instanceMultiplier, instanceNegativePrefix, instanceNegativeSuffix, instanceParse, instancePattern, instancePositivePrefix, instancePositiveSuffix, instanceRoundingMode, symbols),
                            new DecimalFormat(currency, integerGroupingSize, integerGroupingUsed, integerMaximumFractionDigits, integerMinimumFractionDigits, integerMaximumIntegerDigits, integerMinimumIntegerDigits, integerMultiplier, integerNegativePrefix, integerNegativeSuffix, integerParse, integerPattern, integerPositivePrefix, integerPositiveSuffix, integerRoundingMode, symbols),
                            new DecimalFormat(currency, numberGroupingSize, numberGroupingUsed, numberMaximumFractionDigits, numberMinimumFractionDigits, numberMaximumIntegerDigits, numberMinimumIntegerDigits, numberMultiplier, numberNegativePrefix, numberNegativeSuffix, numberParse, numberPattern, numberPositivePrefix, numberPositiveSuffix, numberRoundingMode, symbols),
                            new DecimalFormat(currency, percentGroupingSize, percentGroupingUsed, percentMaximumFractionDigits, percentMinimumFractionDigits, percentMaximumIntegerDigits, percentMinimumIntegerDigits, percentMultiplier, percentNegativePrefix, percentNegativeSuffix, percentParse, percentPattern, percentPositivePrefix, percentPositiveSuffix, percentRoundingMode, symbols),
                    });

            // TODO symbols.setCurrency();
        }
    }

    private static DecimalFormat forDefaultLocale() {
        return forLocale(Locale.getDefault(), INDEX_INSTANCE);
    }

    static DecimalFormat forLocale(final Locale locale,
                                   final int selectorIndex) {
        return forLocale(locale.toLanguageTag(), selectorIndex);
    }

    private static DecimalFormat forLocale(final String locale,
                                           final int selectorIndex) {
        return LANGUAGE_TAG_TO_FORMATS.getOrFail(locale)[selectorIndex];
    }

    /**
     * Ctor used to register locale to decimal format and by {@link #cloneState()}
     */
    private DecimalFormat(final Currency currency,
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
        this.groupingSize = groupingSize;
        this.groupingUsed = groupingUsed;

        this.maximumFractionDigits = maximumFractionDigits;
        this.minimumFractionDigits = minimumFractionDigits;
        this.maximumIntegerDigits = maximumIntegerDigits;
        this.minimumIntegerDigits = minimumIntegerDigits;

        this.multiplier = multiplier;

        this.negativePrefix = negativePrefix;
        this.negativeSuffix = negativeSuffix;

        switch (parse) {
            case PARSE_NONE:
                this.parseBigDecimal = false;
                this.parseIntegerOnly = false;
                break;
            case PARSE_INTEGER_ONLY:
                this.parseBigDecimal = false;
                this.parseIntegerOnly = true;
                break;
            case PARSE_BIG_DECIMAL:
                this.parseBigDecimal = true;
                this.parseIntegerOnly = false;
                break;
            default:
                NeverError.unhandledCase(parse, PARSE_NONE, PARSE_INTEGER_ONLY, PARSE_BIG_DECIMAL);
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

    // constants used by parse.

    final static int PARSE_NONE = 0;
    final static int PARSE_INTEGER_ONLY = 1;
    final static int PARSE_BIG_DECIMAL = 2;

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
     * Copy constructor for internal use by {@link #cloneState()}.
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
        this.groupingSize = copy.groupingSize;
        this.groupingUsed = copy.groupingUsed;

        this.maximumFractionDigits = copy.maximumFractionDigits;
        this.minimumFractionDigits = copy.minimumFractionDigits;
        this.maximumIntegerDigits = copy.maximumIntegerDigits;
        this.minimumIntegerDigits = copy.minimumIntegerDigits;

        this.multiplier = copy.multiplier;

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

        this.positivePrefix = copy.positivePrefix;
        this.positivePrefixComponents = copy.positivePrefixComponents;
        this.positiveNumberComponents = copy.positiveNumberComponents;
        this.positiveSuffix = copy.positiveSuffix;
        this.positiveSuffixComponents = copy.positiveSuffixComponents;
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

        final DecimalFormatPatternParserNumber positive = DecimalFormatPatternParserNumber.with(pattern, 0);
        positive.parse();

        boolean currency = positive.currency;

        final int groupingSeparator = positive.groupingSeparator;
        final int multiplier = positive.multiplier;

        // String versions will be computed later.
        final List<DecimalFormatPatternComponent> positivePrefixComponents = positive.prefix;
        final List<DecimalFormatPatternComponent> positiveNumberComponents = positive.number;
        final List<DecimalFormatPatternComponent> positiveSuffixComponents = positive.suffix;

        final List<DecimalFormatPatternComponent> negativePrefixComponents;
        final List<DecimalFormatPatternComponent> negativeNumberComponents;
        final List<DecimalFormatPatternComponent> negativeSuffixComponents;

        final int position = positive.position;
        if (position < pattern.length()) {
            final DecimalFormatPatternParserNumber negative = DecimalFormatPatternParserNumber.with(pattern, position + 1);
            negative.parse();

            // if negative pattern has its on subPatternSeparator character fail!
            if (negative.subPatternSeparator) {
                negative.failInvalidCharacter();
            }

            currency |= negative.currency;

            negativePrefixComponents = negative.prefix;
            negativeNumberComponents = negative.number;
            negativeSuffixComponents = negative.suffix;

            // ignore groupingSeparator, multiplier from negative.
        } else {
            // no negative pattern...negative prefix is minus sign + positive prefix
            negativePrefixComponents = Lists.array();
            negativePrefixComponents.add(DecimalFormatPatternComponent.minusSign());
            negativePrefixComponents.addAll(positivePrefixComponents);

            negativeNumberComponents = null;

            negativeSuffixComponents = positiveSuffixComponents;
        }

        // commit pattern changes to this.
        this.setGroupingSize(groupingSeparator);
        this.setMultiplier(multiplier);

        this.maximumFractionDigits = positive.maximumFractionDigits;
        this.minimumFractionDigits = positive.minimumFractionDigits;

        this.maximumIntegerDigits = positive.maximumIntegerDigits;
        this.minimumIntegerDigits = positive.minimumIntegerDigits;

        this.positivePrefixComponents = positivePrefixComponents;
        this.positivePrefix = this.toPattern(positivePrefixComponents);
        this.positiveNumberComponents = positiveNumberComponents;
        this.positiveSuffixComponents = positiveSuffixComponents;
        this.positiveSuffix = this.toPattern(positiveSuffixComponents);

        this.negativePrefixComponents = negativePrefixComponents;
        this.negativePrefix = this.toPattern(negativePrefixComponents);
        this.negativeNumberComponents = negativeNumberComponents;
        this.negativeSuffixComponents = negativeSuffixComponents;
        this.negativeSuffix = this.toPattern(negativeSuffixComponents);
    }

    /**
     * Returns the pattern of this decimal format using non-localized pattern
     * characters.
     *
     * @return the non-localized pattern.
     */
    public String toPattern() {
        if (null == this.pattern) {
            final StringBuilder b = new StringBuilder();

            b.append(this.positivePrefix);
            b.append(this.toPattern(this.positiveNumberComponents));
            b.append(this.positiveSuffix);

            final List<DecimalFormatPatternComponent> negative = negativeNumberComponents;
            if (null != negative) {
                b.append(this.negativePrefix);
                b.append(this.toPattern(negative));
                b.append(this.negativeSuffix);
            }

            this.pattern = b.toString();
        }
        return this.pattern;
    }

    private String toPattern(final List<DecimalFormatPatternComponent> components) {
        final DecimalFormatSymbols symbols = this.symbols;

        final StringBuilder b = new StringBuilder();
        for (final DecimalFormatPatternComponent component : components) {
            component.toPattern(this, b);
        }

        return b.toString();
    }

    /**
     * Forces the pattern to be rebuild because a prefix or suffix changed.
     * If this holds a single pattern ignore any changes to negative prefix/suffix.
     */
    private void recomputePattern(final boolean negative) {
        if (negative && null != this.negativeNumberComponents) {
            this.pattern = null;
        }
    }

    private final static boolean NEGATIVE = true;
    private final static boolean POSITIVE = false;

    private String pattern;

    @Override
    public StringBuffer format(final double number,
                               final StringBuffer append,
                               final FieldPosition position) {
        throw new UnsupportedOperationException();
    }

    @Override
    public StringBuffer format(final long number,
                               final StringBuffer append,
                               final FieldPosition position) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Number parse(final String source,
                        final ParsePosition position) {
        throw new UnsupportedOperationException();
    }

    /**
     * Positive ill never be null and will be updated by {@link #applyPattern(String)}.
     */
    private List<DecimalFormatPatternComponent> positiveNumberComponents;

    /**
     * When the initial pattern had no negative sub pattern, this will be null.
     */
    private List<DecimalFormatPatternComponent> negativeNumberComponents;

    // currency.........................................................................................................

    public Currency getCurrency() {
        return this.currency;
    }

    public void setCurrency(final Currency currency) {
        Objects.requireNonNull(currency, "currency");
        this.currency = currency;
    }

    private Currency currency;

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
    }

    private int multiplier;

    // NegativePrefix.....................................................................................................

    public String getNegativePrefix() {
        return this.negativePrefix;
    }

    public void setNegativePrefix(final String negativePrefix) {
        this.negativePrefix = negativePrefix;
        this.recomputePattern(NEGATIVE);
    }

    private String negativePrefix;
    private List<DecimalFormatPatternComponent> negativePrefixComponents;

    // NegativeSuffix.....................................................................................................

    public String getNegativeSuffix() {
        return this.negativeSuffix;
    }

    public void setNegativeSuffix(final String negativeSuffix) {
        this.negativeSuffix = negativeSuffix;
        this.recomputePattern(NEGATIVE);
    }

    private String negativeSuffix;
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
        this.recomputePattern(POSITIVE);
    }

    private String positivePrefix;
    private List<DecimalFormatPatternComponent> positivePrefixComponents;

    // PositiveSuffix.....................................................................................................

    public String getPositiveSuffix() {
        return this.positiveSuffix;
    }

    public void setPositiveSuffix(final String positiveSuffix) {
        this.positiveSuffix = positiveSuffix;
        this.recomputePattern(POSITIVE);
    }

    private String positiveSuffix;
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
    DecimalFormat cloneState() {
        return new DecimalFormat(this);
    }

    // Object...........................................................................................................

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(),
                this.groupingSize,
                this.groupingUsed,
                this.multiplier,
                this.negativePrefix,
                this.negativeNumberComponents,
                this.negativeSuffix,
                this.parseBigDecimal,
                this.pattern,
                this.positivePrefix,
                this.positiveNumberComponents,
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
                this.groupingSize == other.groupingSize &&
                this.groupingUsed == other.groupingUsed &&
                this.maximumFractionDigits == other.maximumFractionDigits &&
                this.minimumFractionDigits == other.minimumFractionDigits &&
                this.maximumIntegerDigits == other.maximumIntegerDigits &&
                this.minimumIntegerDigits == other.minimumIntegerDigits &&
                this.multiplier == other.multiplier &&
                this.negativePrefix.equals(other.negativePrefix) &&
                Objects.equals(this.negativeNumberComponents, other.negativeNumberComponents) &&
                this.negativeSuffix.equals(other.negativeSuffix) &&
                this.parseBigDecimal == other.parseBigDecimal &&
                this.parseIntegerOnly == other.parseIntegerOnly &&
                this.positivePrefix.equals(other.positivePrefix) &&
                this.positiveNumberComponents.equals(other.positiveNumberComponents) &&
                this.positiveSuffix.equals(other.positiveSuffix) &&
                this.roundingMode == other.roundingMode &&
                this.symbols.equals(other.symbols);
    }

    @Override
    public String toString() {
        return ToStringBuilder.empty()
                .label("currency").value(this.currency)
                .label("groupingSize").value(this.groupingSize)
                .label("groupingUsed").value(this.groupingUsed)
                .label("maximumFractionDigits").value(this.maximumFractionDigits)
                .label("minimumFractionDigits").value(this.minimumFractionDigits)
                .label("maximumIntegerDigits").value(this.maximumIntegerDigits)
                .label("minimumIntegerDigits").value(this.minimumIntegerDigits)
                .label("multiplier").value(this.multiplier)
                .label("negativePrefix").value(this.negativePrefix)
                .label("negativePrefix").value(this.negativeNumberComponents)
                .label("negativeSuffix").value(this.negativeSuffix)
                .label("parseBigDecimalOnly").value(this.parseBigDecimal)
                .label("parseIntegerOnly").value(this.parseIntegerOnly)
                .label("pattern").value(this.pattern)
                .label("positivePrefix").value(this.positivePrefix)
                .label("positiveNumberComponents").value(this.positiveNumberComponents)
                .label("positiveSuffix").value(this.positiveSuffix)
                .label("roundingMode").value(this.roundingMode)
                .label("symbols").value(this.symbols)
                .build();
    }
}
