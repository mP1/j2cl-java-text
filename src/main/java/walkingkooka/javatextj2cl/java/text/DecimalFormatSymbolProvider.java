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

final class DecimalFormatSymbolProvider {
    static void register() {
        DecimalFormatSymbols.register(
                "\tak\tak-GH\tam\tam-ET\tar-EH\tasa\tasa-TZ\tbem\tbem-ZM\tbez\tbez-TZ\tbm\tbm-ML\tbo\tbo-CN\tbo-IN\tbrx\tbrx-IN\tce\tce-RU\tcgg\tcgg-UG\tchr\tchr-US\tcu\tcu-RU\tcy\tcy-GB\tdav\tdav-KE\tebu\tebu-KE\tee\tee-GH\tee-TG\ten\ten-001\ten-AG\ten-AI\ten-AS\ten-AU\ten-BB\ten-BI\ten-BM\ten-BS\ten-BW\ten-BZ\ten-CA\ten-CC\ten-CK\ten-CM\ten-CX\ten-CY\ten-DG\ten-DM\ten-ER\ten-FJ\ten-FK\ten-FM\ten-GB\ten-GD\ten-GG\ten-GH\ten-GI\ten-GM\ten-GU\ten-GY\ten-HK\ten-IE\ten-IL\ten-IM\ten-IN\ten-IO\ten-JE\ten-JM\ten-KE\ten-KI\ten-KN\ten-KY\ten-LC\ten-LR\ten-LS\ten-MG\ten-MH\ten-MO\ten-MP\ten-MS\ten-MT\ten-MU\ten-MW\ten-MY\ten-NA\ten-NF\ten-NG\ten-NR\ten-NU\ten-NZ\ten-PG\ten-PH\ten-PK\ten-PN\ten-PR\ten-PW\ten-RW\ten-SB\ten-SC\ten-SD\ten-SG\ten-SH\ten-SL\ten-SS\ten-SX\ten-SZ\ten-TC\ten-TK\ten-TO\ten-TT\ten-TV\ten-TZ\ten-UG\ten-UM\ten-US\ten-US-POSIX\ten-VC\ten-VG\ten-VI\ten-VU\ten-WS\ten-ZM\ten-ZW\tes-419\tes-BR\tes-CU\tes-DO\tes-GT\tes-HN\tes-MX\tes-NI\tes-PA\tes-PE\tes-PR\tes-SV\tes-US\tfil\tfil-PH\tga\tga-IE\tgd\tgd-GB\tgu\tgu-IN\tguz\tguz-KE\tgv\tgv-IM\tha\tha-GH\tha-NE\tha-NG\thaw\thaw-US\the\the-IL\thi\thi-IN\tig\tig-NG\tii\tii-CN\tiw\tiw-IL\tja\tja-JP\tji\tji-001\tjmc\tjmc-TZ\tkam\tkam-KE\tkde\tkde-TZ\tki\tki-KE\tkln\tkln-KE\tkn\tkn-IN\tko\tko-KP\tko-KR\tkok\tkok-IN\tksb\tksb-TZ\tkw\tkw-GB\tlag\tlag-TZ\tlg\tlg-UG\tlkt\tlkt-US\tluo\tluo-KE\tluy\tluy-KE\tmas\tmas-KE\tmas-TZ\tmer\tmer-KE\tmg\tmg-MG\tmgo\tmgo-CM\tml\tml-IN\tmn\tmn-MN\tms\tms-MY\tms-SG\tmt\tmt-MT\tnaq\tnaq-NA\tnd\tnd-ZW\tnus\tnus-SS\tnyn\tnyn-UG\tom\tom-ET\tom-KE\tor\tor-IN\tpa\tpa-Guru\tpa-Guru-IN\tpa-IN\tpa-PK\tprg\tprg-001\tqu\tqu-EC\tqu-PE\trof\trof-TZ\trwk\trwk-TZ\tsah\tsah-RU\tsaq\tsaq-KE\tsbp\tsbp-TZ\tsi\tsi-LK\tsmn\tsmn-FI\tsn\tsn-ZW\tso\tso-DJ\tso-ET\tso-KE\tso-SO\tsw\tsw-KE\tsw-TZ\tsw-UG\tta\tta-IN\tta-LK\tta-MY\tta-SG\tte\tte-IN\tteo\tteo-KE\tteo-UG\tth\tth-TH\tti\tti-ER\tti-ET\tto\tto-TO\tug\tug-CN\tund\tur\tur-PK\tvai\tvai-LR\tvai-Latn\tvai-Latn-LR\tvai-Vaii\tvai-Vaii-LR\tvo\tvo-001\tvun\tvun-TZ\txog\txog-UG\tyi\tyi-001\tyo\tyo-BJ\tyo-NG\tyue\tyue-HK\tzh\tzh-CN\tzh-HK\tzh-Hans\tzh-Hans-CN\tzh-Hans-HK\tzh-Hans-MO\tzh-Hans-SG\tzh-Hant\tzh-Hant-HK\tzh-Hant-MO\tzh-Hant-TW\tzh-SG\tzh-TW\tzu\tzu-ZA", // locales
                "XXX", // currency
                "¤", // currencySymbols
                '.', // decimalSeparator
                '#', // digit
                "E", // exponentSeparator
                ',', // groupingSeparator
                "∞", // inifinity
                "XXX", // internationalCurrencySymbol
                '-', // minusSign
                '.', // monetaryDecimalSeparator
                "NaN", // nan
                ';', // patternSeparator
                '%', // percent
                '‰', // perMill
                '0' // zeroDigit
        );

        DecimalFormatSymbols.register(
                "af\taf-NA\taf-ZA\tagq\tagq-CM\tbas\tbas-CM\tbe\tbe-BY\tbg\tbg-BG\tbr\tbr-FR\tcs\tcs-CZ\tde-AT\tdua\tdua-CM\tdyo\tdyo-SN\ten-FI\ten-SE\ten-ZA\teo\teo-001\tes-CR\tewo\tewo-CM\tff\tff-CM\tff-GN\tff-MR\tff-SN\tfi\tfi-FI\tfr\tfr-BF\tfr-BI\tfr-BJ\tfr-BL\tfr-CA\tfr-CD\tfr-CF\tfr-CG\tfr-CI\tfr-CM\tfr-DJ\tfr-DZ\tfr-FR\tfr-GA\tfr-GF\tfr-GN\tfr-GP\tfr-GQ\tfr-HT\tfr-KM\tfr-MC\tfr-MF\tfr-MG\tfr-ML\tfr-MQ\tfr-MR\tfr-MU\tfr-NC\tfr-NE\tfr-PF\tfr-PM\tfr-RE\tfr-RW\tfr-SC\tfr-SN\tfr-SY\tfr-TD\tfr-TG\tfr-TN\tfr-VU\tfr-WF\tfr-YT\thu\thu-HU\tka\tka-GE\tkab\tkab-DZ\tkk\tkk-KZ\tksf\tksf-CM\tksh\tksh-DE\tky\tky-KG\tlt\tlt-LT\tlv\tlv-LV\tnb\tnb-NO\tnb-SJ\tnmg\tnmg-CM\tnn\tnn-NO\tno\tno-NO\tno-NO-NY\tos\tos-GE\tos-RU\tpl\tpl-PL\tru\tru-BY\tru-KG\tru-KZ\tru-MD\tru-RU\tru-UA\tse\tse-FI\tse-NO\tse-SE\tshi\tshi-Latn\tshi-Latn-MA\tshi-MA\tshi-Tfng\tshi-Tfng-MA\tsk\tsk-SK\tsq\tsq-AL\tsq-MK\tsq-XK\tsv\tsv-AX\tsv-FI\tsv-SE\ttk\ttk-TM\ttzm\ttzm-MA\tuk\tuk-UA\tuz\tuz-AF\tuz-Latn\tuz-Latn-UZ\tuz-UZ\tyav\tyav-CM\tzgh\tzgh-MA", // locales
                "XXX", // currency
                "¤", // currencySymbols
                ',', // decimalSeparator
                '#', // digit
                "E", // exponentSeparator
                ' ', // groupingSeparator
                "∞", // inifinity
                "XXX", // internationalCurrencySymbol
                '-', // minusSign
                ',', // monetaryDecimalSeparator
                "NaN", // nan
                ';', // patternSeparator
                '%', // percent
                '‰', // perMill
                '0' // zeroDigit
        );

        DecimalFormatSymbols.register(
                "ar\tar-001\tar-AE\tar-BH\tar-DJ\tar-EG\tar-ER\tar-IL\tar-IQ\tar-JO\tar-KM\tar-KW\tar-OM\tar-PS\tar-QA\tar-SA\tar-SD\tar-SO\tar-SS\tar-SY\tar-TD\tar-YE\tckb\tckb-IQ\tckb-IR", // locales
                "XXX", // currency
                "¤", // currencySymbols
                '٫', // decimalSeparator
                '#', // digit
                "اس", // exponentSeparator
                '٬', // groupingSeparator
                "∞", // inifinity
                "XXX", // internationalCurrencySymbol
                '‏', // minusSign
                '٫', // monetaryDecimalSeparator
                "ليس رقم", // nan
                '؛', // patternSeparator
                '٪', // percent
                '؉', // perMill
                '٠' // zeroDigit
        );

        DecimalFormatSymbols.register(
                "ar-DZ\tar-LB\tar-LY\tar-MA\tar-MR\tar-TN\tast\tast-ES\taz\taz-AZ\taz-Cyrl\taz-Cyrl-AZ\taz-Latn\taz-Latn-AZ\tbs\tbs-BA\tbs-Cyrl\tbs-Cyrl-BA\tbs-Latn\tbs-Latn-BA\tca\tca-AD\tca-ES\tca-ES-VALENCIA\tca-FR\tca-IT\tda\tda-DK\tda-GL\tde\tde-BE\tde-DE\tde-LU\tdsb\tdsb-DE\tel\tel-CY\tel-GR\ten-150\ten-AT\ten-BE\ten-CH\ten-DE\ten-DK\ten-NL\ten-SI\tes\tes-AR\tes-BO\tes-CL\tes-CO\tes-EA\tes-EC\tes-ES\tes-GQ\tes-IC\tes-PH\tes-PY\tes-UY\tes-VE\teu\teu-ES\tfo\tfo-DK\tfo-FO\tfr-BE\tfr-LU\tfr-MA\tfur\tfur-IT\tfy\tfy-NL\tgl\tgl-ES\thr\thr-BA\thr-HR\thsb\thsb-DE\thy\thy-AM\tid\tid-ID\tin\tin-ID\tis\tis-IS\tit\tit-IT\tit-SM\tjgo\tjgo-CM\tkkj\tkkj-CM\tkl\tkl-GL\tkm\tkm-KH\tlb\tlb-LU\tln\tln-AO\tln-CD\tln-CF\tln-CG\tlo\tlo-LA\tlu\tlu-CD\tmgh\tmgh-MZ\tmk\tmk-MK\tms-BN\tmua\tmua-CM\tnl\tnl-AW\tnl-BE\tnl-BQ\tnl-CW\tnl-NL\tnl-SR\tnl-SX\tnnh\tnnh-CM\tpt\tpt-BR\tqu-BO\trn\trn-BI\tro\tro-MD\tro-RO\trw\trw-RW\tseh\tseh-MZ\tsg\tsg-CF\tsl\tsl-SI\tsr\tsr-BA\tsr-CS\tsr-Cyrl\tsr-Cyrl-BA\tsr-Cyrl-ME\tsr-Cyrl-RS\tsr-Cyrl-XK\tsr-Latn\tsr-Latn-BA\tsr-Latn-ME\tsr-Latn-RS\tsr-Latn-XK\tsr-ME\tsr-RS\tsw-CD\ttr\ttr-CY\ttr-TR\tvi\tvi-VN", // locales
                "DZD", // currency
                "د.ج.‏", // currencySymbols
                ',', // decimalSeparator
                '#', // digit
                "E", // exponentSeparator
                '.', // groupingSeparator
                "∞", // inifinity
                "DZD", // internationalCurrencySymbol
                '‎', // minusSign
                ',', // monetaryDecimalSeparator
                "ليس رقمًا", // nan
                ';', // patternSeparator
                '٪', // percent
                '‰', // perMill
                '0' // zeroDigit
        );

        DecimalFormatSymbols.register(
                "as\tas-IN\tbn\tbn-BD\tbn-IN", // locales
                "XXX", // currency
                "¤", // currencySymbols
                '.', // decimalSeparator
                '#', // digit
                "E", // exponentSeparator
                ',', // groupingSeparator
                "∞", // inifinity
                "XXX", // internationalCurrencySymbol
                '-', // minusSign
                '.', // monetaryDecimalSeparator
                "NaN", // nan
                ';', // patternSeparator
                '%', // percent
                '‰', // perMill
                '০' // zeroDigit
        );

        DecimalFormatSymbols.register(
                "de-CH\tde-LI\tit-CH", // locales
                "CHF", // currency
                "CHF", // currencySymbols
                '.', // decimalSeparator
                '#', // digit
                "E", // exponentSeparator
                '\'', // groupingSeparator
                "∞", // inifinity
                "CHF", // internationalCurrencySymbol
                '-', // minusSign
                '.', // monetaryDecimalSeparator
                "NaN", // nan
                ';', // patternSeparator
                '%', // percent
                '‰', // perMill
                '0' // zeroDigit
        );

        DecimalFormatSymbols.register(
                "dje\tdje-NE\tet\tet-EE\tfr-CH\tkhq\tkhq-ML\tmfe\tmfe-MU\tses\tses-ML\ttwq\ttwq-NE", // locales
                "XXX", // currency
                "¤", // currencySymbols
                '.', // decimalSeparator
                '#', // digit
                "E", // exponentSeparator
                ' ', // groupingSeparator
                "∞", // inifinity
                "XXX", // internationalCurrencySymbol
                '-', // minusSign
                '.', // monetaryDecimalSeparator
                "NaN", // nan
                ';', // patternSeparator
                '%', // percent
                '‰', // perMill
                '0' // zeroDigit
        );

        DecimalFormatSymbols.register(
                "dz\tdz-BT", // locales
                "XXX", // currency
                "¤", // currencySymbols
                '.', // decimalSeparator
                '#', // digit
                "E", // exponentSeparator
                ',', // groupingSeparator
                "གྲངས་མེད", // inifinity
                "XXX", // internationalCurrencySymbol
                '-', // minusSign
                '.', // monetaryDecimalSeparator
                "ཨང་མད", // nan
                'ད', // patternSeparator
                '%', // percent
                '‰', // perMill
                '༠' // zeroDigit
        );

        DecimalFormatSymbols.register(
                "fa\tfa-AF\tfa-IR\tks\tks-IN\tlrc\tlrc-IQ\tlrc-IR\tmzn\tmzn-IR\tpa-Arab\tpa-Arab-PK\tps\tps-AF\tuz-Arab\tuz-Arab-AF\tuz-Cyrl\tuz-Cyrl-UZ", // locales
                "XXX", // currency
                "¤", // currencySymbols
                '٫', // decimalSeparator
                '#', // digit
                "×۱۰^", // exponentSeparator
                '٬', // groupingSeparator
                "∞", // inifinity
                "XXX", // internationalCurrencySymbol
                '‎', // minusSign
                '٫', // monetaryDecimalSeparator
                "ناعدد", // nan
                '؛', // patternSeparator
                '٪', // percent
                '؉', // perMill
                '۰' // zeroDigit
        );

        DecimalFormatSymbols.register(
                "gsw\tgsw-CH\tgsw-FR\tgsw-LI\trm\trm-CH", // locales
                "XXX", // currency
                "¤", // currencySymbols
                '.', // decimalSeparator
                '#', // digit
                "E", // exponentSeparator
                '’', // groupingSeparator
                "∞", // inifinity
                "XXX", // internationalCurrencySymbol
                '−', // minusSign
                '.', // monetaryDecimalSeparator
                "NaN", // nan
                ';', // patternSeparator
                '%', // percent
                '‰', // perMill
                '0' // zeroDigit
        );

        DecimalFormatSymbols.register(
                "kea\tkea-CV\tpt-AO\tpt-CH\tpt-CV\tpt-GQ\tpt-GW\tpt-LU\tpt-MO\tpt-MZ\tpt-PT\tpt-ST\tpt-TL", // locales
                "XXX", // currency
                "¤", // currencySymbols
                '$', // decimalSeparator
                '#', // digit
                "E", // exponentSeparator
                ',', // groupingSeparator
                "∞", // inifinity
                "XXX", // internationalCurrencySymbol
                '-', // minusSign
                '$', // monetaryDecimalSeparator
                "NaN", // nan
                ';', // patternSeparator
                '%', // percent
                '‰', // perMill
                '0' // zeroDigit
        );

        DecimalFormatSymbols.register(
                "mr\tmr-IN\tne\tne-IN\tne-NP", // locales
                "XXX", // currency
                "¤", // currencySymbols
                '.', // decimalSeparator
                '#', // digit
                "E", // exponentSeparator
                ',', // groupingSeparator
                "∞", // inifinity
                "XXX", // internationalCurrencySymbol
                '-', // minusSign
                '.', // monetaryDecimalSeparator
                "NaN", // nan
                ';', // patternSeparator
                '%', // percent
                '‰', // perMill
                '०' // zeroDigit
        );

        DecimalFormatSymbols.register(
                "my\tmy-MM", // locales
                "XXX", // currency
                "¤", // currencySymbols
                '.', // decimalSeparator
                '#', // digit
                "E", // exponentSeparator
                ',', // groupingSeparator
                "∞", // inifinity
                "XXX", // internationalCurrencySymbol
                '-', // minusSign
                '.', // monetaryDecimalSeparator
                "NaN", // nan
                '၊', // patternSeparator
                '%', // percent
                '‰', // perMill
                '၀' // zeroDigit
        );

        DecimalFormatSymbols.register(
                "ur-IN", // locales
                "INR", // currency
                "₹", // currencySymbols
                '.', // decimalSeparator
                '#', // digit
                "×۱۰^", // exponentSeparator
                ',', // groupingSeparator
                "∞", // inifinity
                "INR", // internationalCurrencySymbol
                '‎', // minusSign
                '.', // monetaryDecimalSeparator
                "NaN", // nan
                ';', // patternSeparator
                '%', // percent
                '‰', // perMill
                '۰' // zeroDigit
        );

        DecimalFormatSymbols.register(
                "wae\twae-CH", // locales
                "XXX", // currency
                "¤", // currencySymbols
                ',', // decimalSeparator
                '#', // digit
                "E", // exponentSeparator
                '’', // groupingSeparator
                "∞", // inifinity
                "XXX", // internationalCurrencySymbol
                '-', // minusSign
                ',', // monetaryDecimalSeparator
                "NaN", // nan
                ';', // patternSeparator
                '%', // percent
                '‰', // perMill
                '0' // zeroDigit
        );

    }
}
