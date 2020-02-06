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

/**
 * Represents the different states when parsing a number pattern, except for escaped/quoted character literals.
 */
enum DecimalFormatPatternParserNumberMode {
    /**
     * Handles parsing the integer portion of a pattern
     */
    PREFIX {
        @Override
        void decimalSeparator(final DecimalFormatPatternParserNumber parser) {
            parser.decimalSeparator();
            parser.setMode(FRACTION);
        }

        @Override
        void exponent(final DecimalFormatPatternParserNumber parser) {
            this.nonSpecialChar(DecimalFormat.EXPONENT, parser);
        }

        @Override
        void groupingSeparator(final DecimalFormatPatternParserNumber parser) {
            parser.failInvalidCharacter();
        }

        @Override
        void hash(final DecimalFormatPatternParserNumber parser) {
            parser.setMode(INTEGER);
            parser.hash();
        }

        @Override
        void nonSpecialChar(final char c,
                            final DecimalFormatPatternParserNumber parser) {
            parser.prefix.add(DecimalFormatPatternComponent.characterLiteral(c));
        }

        @Override
        void subPatternSeparator(final DecimalFormatPatternParserNumber parser) {
            parser.failInvalidCharacter();
        }

        @Override
        void zero(final DecimalFormatPatternParserNumber parser) {
            parser.setMode(INTEGER);
            parser.zero();
        }
    },

    /**
     * Handles parsing the integer portion of a pattern
     */
    INTEGER {
        @Override
        void decimalSeparator(final DecimalFormatPatternParserNumber parser) {
            parser.decimalSeparator();
            parser.setMode(FRACTION);
        }

        @Override
        void exponent(final DecimalFormatPatternParserNumber parser) {
            parser.exponent();
            parser.setMode(EXPONENT);
        }

        @Override
        void groupingSeparator(final DecimalFormatPatternParserNumber parser) {
            parser.groupingSeparator();
        }

        @Override
        void hash(final DecimalFormatPatternParserNumber parser) {
            parser.hash();
        }

        @Override
        void nonSpecialChar(final char c,
                            final DecimalFormatPatternParserNumber parser) {
            parser.addCharacterLiteral(c);
        }

        @Override
        void subPatternSeparator(final DecimalFormatPatternParserNumber parser) {
            parser.subPatternSeparator();
        }

        @Override
        void zero(final DecimalFormatPatternParserNumber parser) {
            parser.zero();
        }
    },

    FRACTION {
        @Override
        void decimalSeparator(final DecimalFormatPatternParserNumber parser) {
            parser.failInvalidCharacter();
        }

        @Override
        void exponent(final DecimalFormatPatternParserNumber parser) {
            parser.exponent();
        }

        @Override
        void groupingSeparator(final DecimalFormatPatternParserNumber parser) {
            parser.failInvalidCharacter();
        }

        @Override
        void hash(final DecimalFormatPatternParserNumber parser) {
            parser.hash();
            parser.fractionHash = true;
        }

        @Override
        void nonSpecialChar(final char c,
                            final DecimalFormatPatternParserNumber parser) {
            parser.addCharacterLiteral(c);
        }

        @Override
        void subPatternSeparator(final DecimalFormatPatternParserNumber parser) {
            parser.subPatternSeparator();
        }

        @Override
        void zero(final DecimalFormatPatternParserNumber parser) {
            // fraction then zeroes after hash hashes fails
            if (parser.fractionHash) {
                parser.failInvalidCharacter();
            }
            parser.zero();
        }
    },

    EXPONENT {
        @Override
        void decimalSeparator(final DecimalFormatPatternParserNumber parser) {
            parser.failInvalidCharacter();
        }

        @Override
        void exponent(final DecimalFormatPatternParserNumber parser) {
            parser.failInvalidCharacter();
        }

        @Override
        void groupingSeparator(final DecimalFormatPatternParserNumber parser) {
            parser.failInvalidCharacter();
        }

        @Override
        void hash(final DecimalFormatPatternParserNumber parser) {
            parser.failInvalidCharacter();
        }

        @Override
        void nonSpecialChar(final char c,
                            final DecimalFormatPatternParserNumber parser) {
            parser.failInvalidCharacter();
        }

        @Override
        void subPatternSeparator(final DecimalFormatPatternParserNumber parser) {
            parser.subPatternSeparator();
        }

        @Override
        void zero(final DecimalFormatPatternParserNumber parser) {
            parser.zero();
        }
    };

    final void handle(final char c, final DecimalFormatPatternParserNumber parser) {
        switch (c) {
            case DecimalFormat.CURRENCY:
                this.currency(parser);
                break;
            case DecimalFormat.DECIMAL_SEPARATOR:
                this.decimalSeparator(parser);
                break;
            case DecimalFormat.EXPONENT:
                this.exponent(parser);
                break;
            case DecimalFormat.GROUPING_SEPARATOR:
                this.groupingSeparator(parser);
                break;
            case DecimalFormat.HASH:
                this.hash(parser);
                break;
            case DecimalFormat.MINUS_SIGN:
                this.minusSign(parser);
                break;
            case DecimalFormat.PERCENT:
                this.percent(parser);
                break;
            case DecimalFormat.PER_MILLE:
                this.perMille(parser);
                break;
            case DecimalFormat.SUB_PATTERN_SEPARATOR:
                this.subPatternSeparator(parser);
                break;
            case DecimalFormat.ZERO:
                this.zero(parser);
                break;
            default:
                this.nonSpecialChar(c, parser);
                break;
        }
    }

    final void currency(final DecimalFormatPatternParserNumber parser) {
        parser.currency();
    }

    abstract void decimalSeparator(final DecimalFormatPatternParserNumber parser);

    abstract void exponent(final DecimalFormatPatternParserNumber parser);

    abstract void groupingSeparator(final DecimalFormatPatternParserNumber parser);

    abstract void hash(final DecimalFormatPatternParserNumber parser);

    final void minusSign(final DecimalFormatPatternParserNumber parser) {
        parser.minusSign();
    }

    abstract void nonSpecialChar(final char c,
                                 final DecimalFormatPatternParserNumber parser);

    final void percent(final DecimalFormatPatternParserNumber parser) {
        parser.percent();
    }

    final void perMille(final DecimalFormatPatternParserNumber parser) {
        parser.perMille();
    }

    abstract void subPatternSeparator(final DecimalFormatPatternParserNumber parser);

    abstract void zero(final DecimalFormatPatternParserNumber parser);
}
