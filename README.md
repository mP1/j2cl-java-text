[![Build Status](https://travis-ci.com/mP1/java-text-j2cl.svg?branch=master)](https://travis-ci.com/mP1/java-text-j2cl.svg?branch=master)
[![Coverage Status](https://coveralls.io/repos/github/mP1/java-text-j2cl/badge.svg?branch=master)](https://coveralls.io/github/mP1/java-text-j2cl?branch=master)
[![License](https://img.shields.io/badge/License-Apache%202.0-blue.svg)](https://opensource.org/licenses/Apache-2.0)

# java.text j2cl

This aims to provide most of the basics of the package.

- DateFormat
- DateFormat.Field
- DateFormatSymbols (DONE)

- DecimalFormat (DONE)
- DecimalFormatSymbols (DONE)

- FieldPosition (DONE)

- Format (DONE)
- Format.Field (DONE)

- NumberFormat (DONE)
- NumberFormat.Field

- ParsePosition (DONE)

- SimpleDateFormat

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

Some of these might need to be supported particularly to allow java.time to be completed emulated.

### Transpiling

The `j2cl-maven-plugin` will repackage the source during the transpile phase, so `walkingkooka.javatextj2cl.java.text`
is available to the runtime as `java.text`. 



### Serialization

Serialization is not supported, and all support classes and forms including magic methods such as `writeReplace` are removed.



## Getting the source

You can either download the source using the "ZIP" button at the top
of the github page, or you can make a clone using git:

```
git clone git://github.com/mP1/java-text-j2cl.git
```
