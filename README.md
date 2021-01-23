[![Build Status](https://travis-ci.com/mP1/j2cl-java-text.svg?branch=master)](https://travis-ci.com/mP1/j2cl-java-text.svg?branch=master)
[![Coverage Status](https://coveralls.io/repos/github/mP1/j2cl-java-text/badge.svg?branch=master)](https://coveralls.io/github/mP1/j2cl-java-text?branch=master)
[![License](https://img.shields.io/badge/License-Apache%202.0-blue.svg)](https://opensource.org/licenses/Apache-2.0)
[![Language grade: Java](https://img.shields.io/lgtm/grade/java/g/mP1/j2cl-java-text.svg?logo=lgtm&logoWidth=18)](https://lgtm.com/projects/g/mP1/j2cl-java-text/context:java)
[![Total alerts](https://img.shields.io/lgtm/alerts/g/mP1/j2cl-java-text.svg?logo=lgtm&logoWidth=18)](https://lgtm.com/projects/g/mP1/j2cl-java-text/alerts/)
[![J2CL compatible](https://img.shields.io/badge/J2CL-compatible-brightgreen.svg)](https://github.com/mP1/j2cl-central)



# java.text j2cl

This aims to provide most of the basics of the `java.text` package. Note while most of the core functionality is present,
some parts are methods are missing. Care should be taken when selecting locales and other extracted data to avoid
very large amounts of data being extracted resulting in javascript with huge strings holding this data.



## DecimalFormat

Note there are some differences between the JDK and emulated DecimalFormat. Where possible behaviour is matched using black box approach,
with multiple tests that perform the same operation with the same parameters and then compare state or results such as
output from format or parse.



### pattern parsing

The JDK DecimalFormat parse of patterns has some strange quirks resulting in the negative suffix in the pattern being ignored,
and empty string returned. An example of this counter intuitive behaviour is given below.

```java
new java.text.DecimalFormat("P#S;PP##SS").getNegativeSuffix() // returns empty and not SS
```


### parse string with number

The minimumIntegerDigits, maximumFractionDigits and minimumFractionDigits are not actually honoured by `DecimalFormat.parse`.



This example demonstrates that the minimumIntegerDigit count is ignored during parsing and the number returned.

```java
java.text.DecimalFormat f = new java.text.DecimalFormat("000");
f.getMaximumIntegerDigits(); // returns 2147483647
f.getMinimumIntegerDigits(); // returns 3
f.parse("1"); // returns 1

```



This example demonstrates that the maximumFractionDigits count is ignored, because the string has more fraction digits
than the pattern.

```java
java.text.DecimalFormat f = new java.text.DecimalFormat("#");
f.getMaximumFractionDigits(); // returns 0
f.getMinimumFractionDigits(); // returns 0
f.parse("1.25"); // returns 1.25

```


This example demonstrates that the maximumFractionDigits count is ignored, because the string has less fraction digits
than the pattern.

```java
java.text.DecimalFormat f = new java.text.DecimalFormat("#.0000");
f.getMaximumFractionDigits(); // returns 4
f.getMinimumFractionDigits(); // returns 4
f.parse("1.5"); // returns 1.5

```

To match compatibility the behaviour of ignoring the counts are ignored.



## SimpleDateFormat

Is an almost complete replacement for `java.text.SimpleDateFormat` supporting formatting and parsing pattern letters.
 
- `java.text.ParsePosition` index and errorIndex is supported and matches the behaviour or the JRE class.
- WEEK_YEAR which is represented by the pattern letter "Y" [TODO format](https://github.com/mP1/j2cl-java-text/issues/216) [TODO parse](https://github.com/mP1/j2cl-java-text/issues/219)



```java
SimpleDateFormat f = new SimpleDateFormat("dd/MM/yyyy");
f.parse("31/12/1999") // gives a Date with 31 December 1999.
```


## Annotation processor arguments

- See [j2cl-java-util-currency-annotation-processor](https://github.com/mP1/j2cl-java-util-locale-annotation-processor) for more info about selecting which currencies get bundled.
- See [j2cl-java-util-locale-annotation-processor](https://github.com/mP1/j2cl-java-util-locale-annotation-processor) for more info about selecting which locales get bundled.
- See [j2cl-locale](https://github.com/mP1/j2cl-locale) for more info about logging.

The currency code `XXX` must be selected as it is used by various `java.text` classes as a source of defaults.



## Missing functionality

For the moment the following classes will not be supported:

- Annotation
- AttributedCharacterIterator.Attribute
- AttributedString
- Bidi
- BreakIterator

- ChoiceFormat

- CollationElementIterator
- CollationKey
- Collator

- MessageFormat
- MessageFormat.Field

- RuleBasedCollator

- Serialization is not supported, and all support classes and forms including magic methods such as `writeReplace` are removed.


### Transpiling

The `j2cl-maven-plugin` will shade the source during the transpile phase, so `walkingkooka.j2cl.java.text`
is available to the runtime as `java.text`. 



