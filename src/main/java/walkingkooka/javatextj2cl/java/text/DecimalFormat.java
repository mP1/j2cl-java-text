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
                            new DecimalFormat(currency, currencyDecimalSeparatorAlwaysShown, currencyGroupingSize, currencyGroupingUsed, currencyMaximumFractionDigits, currencyMinimumFractionDigits, currencyMaximumIntegerDigits, currencyMinimumIntegerDigits, currencyMultiplier, currencyNegativePrefix, currencyNegativeSuffix, currencyParse, currencyPattern, currencyPositivePrefix, currencyPositiveSuffix, currencyRoundingMode, symbols),
                            new DecimalFormat(currency, instanceDecimalSeparatorAlwaysShown, instanceGroupingSize, instanceGroupingUsed, instanceMaximumFractionDigits, instanceMinimumFractionDigits, instanceMaximumIntegerDigits, instanceMinimumIntegerDigits, instanceMultiplier, instanceNegativePrefix, instanceNegativeSuffix, instanceParse, instancePattern, instancePositivePrefix, instancePositiveSuffix, instanceRoundingMode, symbols),
                            new DecimalFormat(currency, integerDecimalSeparatorAlwaysShown, integerGroupingSize, integerGroupingUsed, integerMaximumFractionDigits, integerMinimumFractionDigits, integerMaximumIntegerDigits, integerMinimumIntegerDigits, integerMultiplier, integerNegativePrefix, integerNegativeSuffix, integerParse, integerPattern, integerPositivePrefix, integerPositiveSuffix, integerRoundingMode, symbols),
                            new DecimalFormat(currency, numberDecimalSeparatorAlwaysShown, numberGroupingSize, numberGroupingUsed, numberMaximumFractionDigits, numberMinimumFractionDigits, numberMaximumIntegerDigits, numberMinimumIntegerDigits, numberMultiplier, numberNegativePrefix, numberNegativeSuffix, numberParse, numberPattern, numberPositivePrefix, numberPositiveSuffix, numberRoundingMode, symbols),
                            new DecimalFormat(currency, percentDecimalSeparatorAlwaysShown, percentGroupingSize, percentGroupingUsed, percentMaximumFractionDigits, percentMinimumFractionDigits, percentMaximumIntegerDigits, percentMinimumIntegerDigits, percentMultiplier, percentNegativePrefix, percentNegativeSuffix, percentParse, percentPattern, percentPositivePrefix, percentPositiveSuffix, percentRoundingMode, symbols),
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

        this.decimalSeparator = copy.decimalSeparator;

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
    }

    private int multiplier;

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
    DecimalFormat cloneState() {
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
