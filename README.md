[![Build Status](https://travis-ci.com/mP1/java-text-j2cl.svg?branch=master)](https://travis-ci.com/mP1/java-text-j2cl.svg?branch=master)
[![Coverage Status](https://coveralls.io/repos/github/mP1/java-text-j2cl/badge.svg?branch=master)](https://coveralls.io/github/mP1/java-text-j2cl?branch=master)

# java.text j2cl

This aims to provide most of the basics of the package.

- DateFormat
- DateFormat.Field
- DateFormatSymbols

- DecimalFormat
- DecimalFormatSymbols

- FieldPosition

- Format
- Format.Field

- NumberFormat
- NumberFormat.Field

- ParsePosition

- SimpleDateFormat

### Missing functionality

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
