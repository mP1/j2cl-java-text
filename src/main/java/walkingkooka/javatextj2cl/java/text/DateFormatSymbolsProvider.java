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

final class DateFormatSymbolsProvider {
    static void register() {
        DateFormatSymbols.register(
                "af\taf-NA\taf-ZA", // locales
                "vm.\tnm.", // ampm
                "v.C.\tn.C.", // eras
                "Januarie\tFebruarie\tMaart\tApril\tMei\tJunie\tJulie\tAugustus\tSeptember\tOktober\tNovember\tDesember", // months
                "Jan.\tFeb.\tMrt.\tApr.\tMei\tJun.\tJul.\tAug.\tSep.\tOkt.\tNov.\tDes.", // shortMonths
                "So.\tMa.\tDi.\tWo.\tDo.\tVr.\tSa.", // shortWeekdays
                "Sondag\tMaandag\tDinsdag\tWoensdag\tDonderdag\tVrydag\tSaterdag" // weekdays
        );

        DateFormatSymbols.register(
                "agq\tagq-CM", // locales
                "a.g\ta.k", // ampm
                "SK\tBK", // eras
                "ndzɔ̀ŋɔ̀nùm\tndzɔ̀ŋɔ̀kƗ̀zùʔ\tndzɔ̀ŋɔ̀tƗ̀dʉ̀ghà\tndzɔ̀ŋɔ̀tǎafʉ̄ghā\tndzɔ̀ŋèsèe\tndzɔ̀ŋɔ̀nzùghò\tndzɔ̀ŋɔ̀dùmlo\tndzɔ̀ŋɔ̀kwîfɔ̀e\tndzɔ̀ŋɔ̀tƗ̀fʉ̀ghàdzughù\tndzɔ̀ŋɔ̀ghǔuwelɔ̀m\tndzɔ̀ŋɔ̀chwaʔàkaa wo\tndzɔ̀ŋèfwòo", // months
                "nùm\tkɨz\ttɨd\ttaa\tsee\tnzu\tdum\tfɔe\tdzu\tlɔm\tkaa\tfwo", // shortMonths
                "nts\tkpa\tghɔ\ttɔm\tume\tghɨ\tdzk", // shortWeekdays
                "tsuʔntsɨ\ttsuʔukpà\ttsuʔughɔe\ttsuʔutɔ̀mlò\ttsuʔumè\ttsuʔughɨ̂m\ttsuʔndzɨkɔʔɔ" // weekdays
        );

        DateFormatSymbols.register(
                "ak\tak-GH", // locales
                "AN\tEW", // ampm
                "AK\tKE", // eras
                "Sanda-Ɔpɛpɔn\tKwakwar-Ɔgyefuo\tEbɔw-Ɔbenem\tEbɔbira-Oforisuo\tEsusow Aketseaba-Kɔtɔnimba\tObirade-Ayɛwohomumu\tAyɛwoho-Kitawonsa\tDifuu-Ɔsandaa\tFankwa-Ɛbɔ\tƆbɛsɛ-Ahinime\tƆberɛfɛw-Obubuo\tMumu-Ɔpɛnimba", // months
                "S-Ɔ\tK-Ɔ\tE-Ɔ\tE-O\tE-K\tO-A\tA-K\tD-Ɔ\tF-Ɛ\tƆ-A\tƆ-O\tM-Ɔ", // shortMonths
                "Kwe\tDwo\tBen\tWuk\tYaw\tFia\tMem", // shortWeekdays
                "Kwesida\tDwowda\tBenada\tWukuda\tYawda\tFida\tMemeneda" // weekdays
        );

        DateFormatSymbols.register(
                "am\tam-ET", // locales
                "ጥዋት\tከሰዓት", // ampm
                "ዓ/ዓ\tዓ/ም", // eras
                "ጃንዩወሪ\tፌብሩወሪ\tማርች\tኤፕሪል\tሜይ\tጁን\tጁላይ\tኦገስት\tሴፕቴምበር\tኦክቶበር\tኖቬምበር\tዲሴምበር", // months
                "ጃንዩ\tፌብሩ\tማርች\tኤፕሪ\tሜይ\tጁን\tጁላይ\tኦገስ\tሴፕቴ\tኦክቶ\tኖቬም\tዲሴም", // shortMonths
                "እሑድ\tሰኞ\tማክሰ\tረቡዕ\tሐሙስ\tዓርብ\tቅዳሜ", // shortWeekdays
                "እሑድ\tሰኞ\tማክሰኞ\tረቡዕ\tሐሙስ\tዓርብ\tቅዳሜ" // weekdays
        );

        DateFormatSymbols.register(
                "ar\tar-001\tar-AE\tar-BH\tar-DJ\tar-EG\tar-EH\tar-ER\tar-IL\tar-KM\tar-KW\tar-LY\tar-OM\tar-QA\tar-SA\tar-SD\tar-SO\tar-SS\tar-TD\tar-YE", // locales
                "ص\tم", // ampm
                "ق.م\tم", // eras
                "يناير\tفبراير\tمارس\tأبريل\tمايو\tيونيو\tيوليو\tأغسطس\tسبتمبر\tأكتوبر\tنوفمبر\tديسمبر", // months
                "يناير\tفبراير\tمارس\tأبريل\tمايو\tيونيو\tيوليو\tأغسطس\tسبتمبر\tأكتوبر\tنوفمبر\tديسمبر", // shortMonths
                "الأحد\tالاثنين\tالثلاثاء\tالأربعاء\tالخميس\tالجمعة\tالسبت", // shortWeekdays
                "الأحد\tالاثنين\tالثلاثاء\tالأربعاء\tالخميس\tالجمعة\tالسبت" // weekdays
        );

        DateFormatSymbols.register(
                "ar-DZ\tar-TN", // locales
                "ص\tم", // ampm
                "ق.م\tم", // eras
                "جانفي\tفيفري\tمارس\tأفريل\tماي\tجوان\tجويلية\tأوت\tسبتمبر\tأكتوبر\tنوفمبر\tديسمبر", // months
                "جانفي\tفيفري\tمارس\tأفريل\tماي\tجوان\tجويلية\tأوت\tسبتمبر\tأكتوبر\tنوفمبر\tديسمبر", // shortMonths
                "الأحد\tالاثنين\tالثلاثاء\tالأربعاء\tالخميس\tالجمعة\tالسبت", // shortWeekdays
                "الأحد\tالاثنين\tالثلاثاء\tالأربعاء\tالخميس\tالجمعة\tالسبت" // weekdays
        );

        DateFormatSymbols.register(
                "ar-IQ", // locales
                "ص\tم", // ampm
                "ق.م\tم", // eras
                "كانون الثاني\tشباط\tآذار\tنيسان\tأيار\tحزيران\tتموز\tآب\tأيلول\tتشرين الأول\tتشرين الثاني\tكانون الأول", // months
                "كانون الثاني\tشباط\tآذار\tنيسان\tأيار\tحزيران\tتموز\tآب\tأيلول\tتشرین الأول\tتشرين الثاني\tكانون الأول", // shortMonths
                "الأحد\tالاثنين\tالثلاثاء\tالأربعاء\tالخميس\tالجمعة\tالسبت", // shortWeekdays
                "الأحد\tالاثنين\tالثلاثاء\tالأربعاء\tالخميس\tالجمعة\tالسبت" // weekdays
        );

        DateFormatSymbols.register(
                "ar-JO\tar-LB\tar-PS\tar-SY", // locales
                "ص\tم", // ampm
                "ق.م\tم", // eras
                "كانون الثاني\tشباط\tآذار\tنيسان\tأيار\tحزيران\tتموز\tآب\tأيلول\tتشرين الأول\tتشرين الثاني\tكانون الأول", // months
                "كانون الثاني\tشباط\tآذار\tنيسان\tأيار\tحزيران\tتموز\tآب\tأيلول\tتشرين الأول\tتشرين الثاني\tكانون الأول", // shortMonths
                "الأحد\tالاثنين\tالثلاثاء\tالأربعاء\tالخميس\tالجمعة\tالسبت", // shortWeekdays
                "الأحد\tالاثنين\tالثلاثاء\tالأربعاء\tالخميس\tالجمعة\tالسبت" // weekdays
        );

        DateFormatSymbols.register(
                "ar-MA", // locales
                "ص\tم", // ampm
                "ق.م\tم", // eras
                "يناير\tفبراير\tمارس\tأبريل\tماي\tيونيو\tيوليوز\tغشت\tشتنبر\tأكتوبر\tنونبر\tدجنبر", // months
                "يناير\tفبراير\tمارس\tأبريل\tماي\tيونيو\tيوليوز\tغشت\tشتنبر\tأكتوبر\tنونبر\tدجنبر", // shortMonths
                "الأحد\tالاثنين\tالثلاثاء\tالأربعاء\tالخميس\tالجمعة\tالسبت", // shortWeekdays
                "الأحد\tالاثنين\tالثلاثاء\tالأربعاء\tالخميس\tالجمعة\tالسبت" // weekdays
        );

        DateFormatSymbols.register(
                "ar-MR", // locales
                "ص\tم", // ampm
                "ق.م\tم", // eras
                "يناير\tفبراير\tمارس\tإبريل\tمايو\tيونيو\tيوليو\tأغشت\tشتمبر\tأكتوبر\tنوفمبر\tدجمبر", // months
                "يناير\tفبراير\tمارس\tإبريل\tمايو\tيونيو\tيوليو\tأغشت\tشتمبر\tأكتوبر\tنوفمبر\tدجمبر", // shortMonths
                "الأحد\tالاثنين\tالثلاثاء\tالأربعاء\tالخميس\tالجمعة\tالسبت", // shortWeekdays
                "الأحد\tالاثنين\tالثلاثاء\tالأربعاء\tالخميس\tالجمعة\tالسبت" // weekdays
        );

        DateFormatSymbols.register(
                "as\tas-IN", // locales
                "পূৰ্বাহ্ণ\tঅপৰাহ্ণ", // ampm
                "BCE\tCE", // eras
                "জানুৱাৰী\tফেব্ৰুৱাৰী\tমাৰ্চ\tএপ্ৰিল\tমে\tজুন\tজুলাই\tআগষ্ট\tছেপ্তেম্বৰ\tঅক্টোবৰ\tনৱেম্বৰ\tডিচেম্বৰ", // months
                "জানু\tফেব্ৰু\tমাৰ্চ\tএপ্ৰিল\tমে\tজুন\tজুলাই\tআগ\tসেপ্ট\tঅক্টো\tনভে\tডিসে", // shortMonths
                "ৰবি\tসোম\tমঙ্গল\tবুধ\tবৃহষ্পতি\tশুক্ৰ\tশনি", // shortWeekdays
                "দেওবাৰ\tসোমবাৰ\tমঙ্গলবাৰ\tবুধবাৰ\tবৃহষ্পতিবাৰ\tশুক্ৰবাৰ\tশনিবাৰ" // weekdays
        );

        DateFormatSymbols.register(
                "asa\tasa-TZ", // locales
                "icheheavo\tichamthi", // ampm
                "KM\tBM", // eras
                "Januari\tFebruari\tMachi\tAprili\tMei\tJuni\tJulai\tAgosti\tSeptemba\tOktoba\tNovemba\tDesemba", // months
                "Jan\tFeb\tMac\tApr\tMei\tJun\tJul\tAgo\tSep\tOkt\tNov\tDec", // shortMonths
                "Jpi\tJtt\tJnn\tJtn\tAlh\tIjm\tJmo", // shortWeekdays
                "Jumapili\tJumatatu\tJumanne\tJumatano\tAlhamisi\tIjumaa\tJumamosi" // weekdays
        );

        DateFormatSymbols.register(
                "ast\tast-ES", // locales
                "de la mañana\tde la tardi", // ampm
                "a.C.\td.C.", // eras
                "de xineru\tde febreru\tde marzu\td’abril\tde mayu\tde xunu\tde xunetu\td’agostu\tde setiembre\td’ochobre\tde payares\td’avientu", // months
                "xin\tfeb\tmar\tabr\tmay\txun\txnt\tago\tset\toch\tpay\tavi", // shortMonths
                "dom\tllu\tmar\tmié\txue\tvie\tsáb", // shortWeekdays
                "domingu\tllunes\tmartes\tmiércoles\txueves\tvienres\tsábadu" // weekdays
        );

        DateFormatSymbols.register(
                "az\taz-AZ\taz-Latn\taz-Latn-AZ", // locales
                "AM\tPM", // ampm
                "e.ə.\tb.e.", // eras
                "yanvar\tfevral\tmart\taprel\tmay\tiyun\tiyul\tavqust\tsentyabr\toktyabr\tnoyabr\tdekabr", // months
                "yan\tfev\tmar\tapr\tmay\tiyn\tiyl\tavq\tsen\tokt\tnoy\tdek", // shortMonths
                "B.\tB.E.\tÇ.A.\tÇ.\tC.A.\tC.\tŞ.", // shortWeekdays
                "bazar\tbazar ertəsi\tçərşənbə axşamı\tçərşənbə\tcümə axşamı\tcümə\tşənbə" // weekdays
        );

        DateFormatSymbols.register(
                "az-Cyrl\taz-Cyrl-AZ", // locales
                "AM\tPM", // ampm
                "BCE\tCE", // eras
                "јанвар\tфеврал\tмарт\tапрел\tмай\tијун\tијул\tавгуст\tсентјабр\tоктјабр\tнојабр\tдекабр", // months
                "јанвар\tфеврал\tмарт\tапрел\tмай\tијун\tијул\tавгуст\tсентјабр\tоктјабр\tнојабр\tдекабр", // shortMonths
                "базар\tбазар ертәси\tчәршәнбә ахшамы\tчәршәнбә\tҹүмә ахшамы\tҹүмә\tшәнбә", // shortWeekdays
                "базар\tбазар ертәси\tчәршәнбә ахшамы\tчәршәнбә\tҹүмә ахшамы\tҹүмә\tшәнбә" // weekdays
        );

        DateFormatSymbols.register(
                "bas\tbas-CM", // locales
                "I bikɛ̂glà\tI ɓugajɔp", // ampm
                "b.Y.K\tm.Y.K", // eras
                "Kɔndɔŋ\tMàcɛ̂l\tMàtùmb\tMàtop\tM̀puyɛ\tHìlòndɛ̀\tNjèbà\tHìkaŋ\tDìpɔ̀s\tBìòôm\tMàyɛsèp\tLìbuy li ńyèe", // months
                "kɔn\tmac\tmat\tmto\tmpu\thil\tnje\thik\tdip\tbio\tmay\tliɓ", // shortMonths
                "nɔy\tnja\tuum\tŋge\tmbɔ\tkɔɔ\tjon", // shortWeekdays
                "ŋgwà nɔ̂y\tŋgwà njaŋgumba\tŋgwà ûm\tŋgwà ŋgê\tŋgwà mbɔk\tŋgwà kɔɔ\tŋgwà jôn" // weekdays
        );

        DateFormatSymbols.register(
                "be\tbe-BY", // locales
                "да паўдня\tпасля паўдня", // ampm
                "да н.э.\tн.э.", // eras
                "студзеня\tлютага\tсакавіка\tкрасавіка\tмая\tчэрвеня\tліпеня\tжніўня\tверасня\tкастрычніка\tлістапада\tснежня", // months
                "сту\tлют\tсак\tкра\tмая\tчэр\tліп\tжні\tвер\tкас\tліс\tсне", // shortMonths
                "нд\tпн\tаў\tср\tчц\tпт\tсб", // shortWeekdays
                "нядзеля\tпанядзелак\tаўторак\tсерада\tчацвер\tпятніца\tсубота" // weekdays
        );

        DateFormatSymbols.register(
                "bem\tbem-ZM", // locales
                "uluchelo\takasuba", // ampm
                "BC\tAD", // eras
                "Januari\tFebruari\tMachi\tEpreo\tMei\tJuni\tJulai\tOgasti\tSeptemba\tOktoba\tNovemba\tDisemba", // months
                "Jan\tFeb\tMac\tEpr\tMei\tJun\tJul\tOga\tSep\tOkt\tNov\tDis", // shortMonths
                "Pa Mulungu\tPalichimo\tPalichibuli\tPalichitatu\tPalichine\tPalichisano\tPachibelushi", // shortWeekdays
                "Pa Mulungu\tPalichimo\tPalichibuli\tPalichitatu\tPalichine\tPalichisano\tPachibelushi" // weekdays
        );

        DateFormatSymbols.register(
                "bez\tbez-TZ", // locales
                "pamilau\tpamunyi", // ampm
                "KM\tBM", // eras
                "pa mwedzi gwa hutala\tpa mwedzi gwa wuvili\tpa mwedzi gwa wudatu\tpa mwedzi gwa wutai\tpa mwedzi gwa wuhanu\tpa mwedzi gwa sita\tpa mwedzi gwa saba\tpa mwedzi gwa nane\tpa mwedzi gwa tisa\tpa mwedzi gwa kumi\tpa mwedzi gwa kumi na moja\tpa mwedzi gwa kumi na mbili", // months
                "Hut\tVil\tDat\tTai\tHan\tSit\tSab\tNan\tTis\tKum\tKmj\tKmb", // shortMonths
                "Mul\tVil\tHiv\tHid\tHit\tHih\tLem", // shortWeekdays
                "pa mulungu\tpa shahuviluha\tpa hivili\tpa hidatu\tpa hitayi\tpa hihanu\tpa shahulembela" // weekdays
        );

        DateFormatSymbols.register(
                "bg\tbg-BG", // locales
                "пр.об.\tсл.об.", // ampm
                "пр.Хр.\tсл.Хр.", // eras
                "януари\tфевруари\tмарт\tаприл\tмай\tюни\tюли\tавгуст\tсептември\tоктомври\tноември\tдекември", // months
                "яну\tфев\tмарт\tапр\tмай\tюни\tюли\tавг\tсеп\tокт\tное\tдек", // shortMonths
                "нд\tпн\tвт\tср\tчт\tпт\tсб", // shortWeekdays
                "неделя\tпонеделник\tвторник\tсряда\tчетвъртък\tпетък\tсъбота" // weekdays
        );

        DateFormatSymbols.register(
                "bm\tbm-ML", // locales
                "AM\tPM", // ampm
                "J.-C. ɲɛ\tni J.-C.", // eras
                "zanwuye\tfeburuye\tmarisi\tawirili\tmɛ\tzuwɛn\tzuluye\tuti\tsɛtanburu\tɔkutɔburu\tnowanburu\tdesanburu", // months
                "zan\tfeb\tmar\tawi\tmɛ\tzuw\tzul\tuti\tsɛt\tɔku\tnow\tdes", // shortMonths
                "kar\tntɛ\ttar\tara\tala\tjum\tsib", // shortWeekdays
                "kari\tntɛnɛ\ttarata\taraba\talamisa\tjuma\tsibiri" // weekdays
        );

        DateFormatSymbols.register(
                "bn\tbn-BD\tbn-IN", // locales
                "পূর্বাহ্ণ\tঅপরাহ্ণ", // ampm
                "খ্রিস্টপূর্ব\tখৃষ্টাব্দ", // eras
                "জানুয়ারী\tফেব্রুয়ারী\tমার্চ\tএপ্রিল\tমে\tজুন\tজুলাই\tআগস্ট\tসেপ্টেম্বর\tঅক্টোবর\tনভেম্বর\tডিসেম্বর", // months
                "জানুয়ারী\tফেব্রুয়ারী\tমার্চ\tএপ্রিল\tমে\tজুন\tজুলাই\tআগস্ট\tসেপ্টেম্বর\tঅক্টোবর\tনভেম্বর\tডিসেম্বর", // shortMonths
                "রবি\tসোম\tমঙ্গল\tবুধ\tবৃহস্পতি\tশুক্র\tশনি", // shortWeekdays
                "রবিবার\tসোমবার\tমঙ্গলবার\tবুধবার\tবৃহস্পতিবার\tশুক্রবার\tশনিবার" // weekdays
        );

        DateFormatSymbols.register(
                "bo\tbo-CN\tbo-IN", // locales
                "སྔ་དྲོ་\tཕྱི་དྲོ་", // ampm
                "སྤྱི་ལོ་སྔོན་\tསྤྱི་ལོ་", // eras
                "ཟླ་བ་དང་པོ\tཟླ་བ་གཉིས་པ\tཟླ་བ་གསུམ་པ\tཟླ་བ་བཞི་པ\tཟླ་བ་ལྔ་པ\tཟླ་བ་དྲུག་པ\tཟླ་བ་བདུན་པ\tཟླ་བ་བརྒྱད་པ\tཟླ་བ་དགུ་པ\tཟླ་བ་བཅུ་པ\tཟླ་བ་བཅུ་གཅིག་པ\tཟླ་བ་བཅུ་གཉིས་པ", // months
                "ཟླ་༡\tཟླ་༢\tཟླ་༣\tཟླ་༤\tཟླ་༥\tཟླ་༦\tཟླ་༧\tཟླ་༨\tཟླ་༩\tཟླ་༡༠\tཟླ་༡༡\tཟླ་༡༢", // shortMonths
                "ཉི་མ་\tཟླ་བ་\tམིག་དམར་\tལྷག་པ་\tཕུར་བུ་\tཔ་སངས་\tསྤེན་པ་", // shortWeekdays
                "གཟའ་ཉི་མ་\tགཟའ་ཟླ་བ་\tགཟའ་མིག་དམར་\tགཟའ་ལྷག་པ་\tགཟའ་ཕུར་བུ་\tགཟའ་པ་སངས་\tགཟའ་སྤེན་པ་" // weekdays
        );

        DateFormatSymbols.register(
                "br\tbr-FR", // locales
                "A.M.\tG.M.", // ampm
                "a-raok J.K.\tgoude J.K.", // eras
                "Genver\tCʼhwevrer\tMeurzh\tEbrel\tMae\tMezheven\tGouere\tEost\tGwengolo\tHere\tDu\tKerzu", // months
                "Gen.\tCʼhwe.\tMeur.\tEbr.\tMae\tMezh.\tGoue.\tEost\tGwen.\tHere\tDu\tKzu.", // shortMonths
                "Sul\tLun\tMeu.\tMer.\tYaou\tGwe.\tSad.", // shortWeekdays
                "Sul\tLun\tMeurzh\tMercʼher\tYaou\tGwener\tSadorn" // weekdays
        );

        DateFormatSymbols.register(
                "brx\tbrx-IN", // locales
                "फुं\tबेलासे", // ampm
                "ईसा.पूर्व\tसन", // eras
                "जानुवारी\tफेब्रुवारी\tमार्स\tएफ्रिल\tमे\tजुन\tजुलाइ\tआगस्थ\tसेबथेज्ब़र\tअखथबर\tनबेज्ब़र\tदिसेज्ब़र", // months
                "जानुवारी\tफेब्रुवारी\tमार्स\tएफ्रिल\tमे\tजुन\tजुलाइ\tआगस्थ\tसेबथेज्ब़र\tअखथबर\tनबेज्ब़र\tदिसेज्ब़र", // shortMonths
                "रबि\tसम\tमंगल\tबुद\tबिसथि\tसुखुर\tसुनि", // shortWeekdays
                "रबिबार\tसमबार\tमंगलबार\tबुदबार\tबिसथिबार\tसुखुरबार\tसुनिबार" // weekdays
        );

        DateFormatSymbols.register(
                "bs\tbs-BA\tbs-Latn\tbs-Latn-BA", // locales
                "prije podne\tpopodne", // ampm
                "p. n. e.\tn. e.", // eras
                "januar\tfebruar\tmart\tapril\tmaj\tjuni\tjuli\taugust\tseptembar\toktobar\tnovembar\tdecembar", // months
                "jan\tfeb\tmar\tapr\tmaj\tjun\tjul\taug\tsep\tokt\tnov\tdec", // shortMonths
                "ned\tpon\tuto\tsri\tčet\tpet\tsub", // shortWeekdays
                "nedjelja\tponedjeljak\tutorak\tsrijeda\tčetvrtak\tpetak\tsubota" // weekdays
        );

        DateFormatSymbols.register(
                "bs-Cyrl\tbs-Cyrl-BA", // locales
                "пре подне\tпоподне", // ampm
                "п. н. е.\tн. е.", // eras
                "јануар\tфебруар\tмарт\tаприл\tмај\tјуни\tјули\tавгуст\tсептембар\tоктобар\tновембар\tдецембар", // months
                "јан\tфеб\tмар\tапр\tмај\tјун\tјул\tавг\tсеп\tокт\tнов\tдец", // shortMonths
                "нед\tпон\tуто\tсри\tчет\tпет\tсуб", // shortWeekdays
                "недеља\tпонедељак\tуторак\tсриједа\tчетвртак\tпетак\tсубота" // weekdays
        );

        DateFormatSymbols.register(
                "ca\tca-AD\tca-ES\tca-ES-VALENCIA\tca-FR\tca-IT", // locales
                "a. m.\tp. m.", // ampm
                "aC\tdC", // eras
                "de gener\tde febrer\tde març\td’abril\tde maig\tde juny\tde juliol\td’agost\tde setembre\td’octubre\tde novembre\tde desembre", // months
                "gen.\tfebr.\tmarç\tabr.\tmaig\tjuny\tjul.\tag.\tset.\toct.\tnov.\tdes.", // shortMonths
                "dg.\tdl.\tdt.\tdc.\tdj.\tdv.\tds.", // shortWeekdays
                "diumenge\tdilluns\tdimarts\tdimecres\tdijous\tdivendres\tdissabte" // weekdays
        );

        DateFormatSymbols.register(
                "ce\tce-RU", // locales
                "AM\tPM", // ampm
                "BCE\tCE", // eras
                "январь\tфевраль\tмарт\tапрель\tмай\tиюнь\tиюль\tавгуст\tсентябрь\tоктябрь\tноябрь\tдекабрь", // months
                "янв\tфев\tмар\tапр\tмай\tиюн\tиюл\tавг\tсен\tокт\tноя\tдек", // shortMonths
                "кӀиранан де\tоршотан де\tшинарин де\tкхаарин де\tеарин де\tпӀераскан де\tшот де", // shortWeekdays
                "кӀиранан де\tоршотан де\tшинарин де\tкхаарин де\tеарин де\tпӀераскан де\tшот де" // weekdays
        );

        DateFormatSymbols.register(
                "cgg\tcgg-UG\tnyn\tnyn-UG", // locales
                "AM\tPM", // ampm
                "BC\tAD", // eras
                "Okwokubanza\tOkwakabiri\tOkwakashatu\tOkwakana\tOkwakataana\tOkwamukaaga\tOkwamushanju\tOkwamunaana\tOkwamwenda\tOkwaikumi\tOkwaikumi na kumwe\tOkwaikumi na ibiri", // months
                "KBZ\tKBR\tKST\tKKN\tKTN\tKMK\tKMS\tKMN\tKMW\tKKM\tKNK\tKNB", // shortMonths
                "SAN\tORK\tOKB\tOKS\tOKN\tOKT\tOMK", // shortWeekdays
                "Sande\tOrwokubanza\tOrwakabiri\tOrwakashatu\tOrwakana\tOrwakataano\tOrwamukaaga" // weekdays
        );

        DateFormatSymbols.register(
                "chr\tchr-US", // locales
                "ᏌᎾᎴ\tᏒᎯᏱᎢᏗᏢ", // ampm
                "ᎤᏓᎷᎸ\tᎤᎶᏐᏅ", // eras
                "ᎤᏃᎸᏔᏅ\tᎧᎦᎵ\tᎠᏅᏱ\tᎧᏬᏂ\tᎠᏂᏍᎬᏘ\tᏕᎭᎷᏱ\tᎫᏰᏉᏂ\tᎦᎶᏂ\tᏚᎵᏍᏗ\tᏚᏂᏅᏗ\tᏅᏓᏕᏆ\tᎥᏍᎩᏱ", // months
                "ᎤᏃ\tᎧᎦ\tᎠᏅ\tᎧᏬ\tᎠᏂ\tᏕᎭ\tᎫᏰ\tᎦᎶ\tᏚᎵ\tᏚᏂ\tᏅᏓ\tᎥᏍ", // shortMonths
                "ᏆᏍᎬ\tᏉᏅᎯ\tᏔᎵᏁ\tᏦᎢᏁ\tᏅᎩᏁ\tᏧᎾᎩ\tᏈᏕᎾ", // shortWeekdays
                "ᎤᎾᏙᏓᏆᏍᎬ\tᎤᎾᏙᏓᏉᏅᎯ\tᏔᎵᏁᎢᎦ\tᏦᎢᏁᎢᎦ\tᏅᎩᏁᎢᎦ\tᏧᎾᎩᎶᏍᏗ\tᎤᎾᏙᏓᏈᏕᎾ" // weekdays
        );

        DateFormatSymbols.register(
                "ckb\tckb-IQ\tckb-IR\tcu\tcu-RU\tprg\tprg-001\ttk\ttk-TM\tund\tvo\tvo-001", // locales
                "AM\tPM", // ampm
                "BCE\tCE", // eras
                "Jan\tFeb\tMar\tApr\tMay\tJun\tJul\tAug\tSep\tOct\tNov\tDec", // months
                "Jan\tFeb\tMar\tApr\tMay\tJun\tJul\tAug\tSep\tOct\tNov\tDec", // shortMonths
                "Sun\tMon\tTue\tWed\tThu\tFri\tSat", // shortWeekdays
                "Sun\tMon\tTue\tWed\tThu\tFri\tSat" // weekdays
        );

        DateFormatSymbols.register(
                "cs\tcs-CZ", // locales
                "dop.\todp.", // ampm
                "př. n. l.\tn. l.", // eras
                "ledna\túnora\tbřezna\tdubna\tkvětna\tčervna\tčervence\tsrpna\tzáří\tříjna\tlistopadu\tprosince", // months
                "led\túno\tbře\tdub\tkvě\tčvn\tčvc\tsrp\tzář\tříj\tlis\tpro", // shortMonths
                "ne\tpo\tút\tst\tčt\tpá\tso", // shortWeekdays
                "neděle\tpondělí\túterý\tstředa\tčtvrtek\tpátek\tsobota" // weekdays
        );

        DateFormatSymbols.register(
                "cy\tcy-GB", // locales
                "AM\tPM", // ampm
                "CC\tOC", // eras
                "Ionawr\tChwefror\tMawrth\tEbrill\tMai\tMehefin\tGorffennaf\tAwst\tMedi\tHydref\tTachwedd\tRhagfyr", // months
                "Ion\tChwef\tMaw\tEbrill\tMai\tMeh\tGorff\tAwst\tMedi\tHyd\tTach\tRhag", // shortMonths
                "Sul\tLlun\tMaw\tMer\tIau\tGwen\tSad", // shortWeekdays
                "Dydd Sul\tDydd Llun\tDydd Mawrth\tDydd Mercher\tDydd Iau\tDydd Gwener\tDydd Sadwrn" // weekdays
        );

        DateFormatSymbols.register(
                "da\tda-DK\tda-GL", // locales
                "AM\tPM", // ampm
                "f.Kr.\te.Kr.", // eras
                "januar\tfebruar\tmarts\tapril\tmaj\tjuni\tjuli\taugust\tseptember\toktober\tnovember\tdecember", // months
                "jan.\tfeb.\tmar.\tapr.\tmaj\tjun.\tjul.\taug.\tsep.\tokt.\tnov.\tdec.", // shortMonths
                "søn.\tman.\ttir.\tons.\ttor.\tfre.\tlør.", // shortWeekdays
                "søndag\tmandag\ttirsdag\tonsdag\ttorsdag\tfredag\tlørdag" // weekdays
        );

        DateFormatSymbols.register(
                "dav\tdav-KE", // locales
                "Luma lwa K\tluma lwa p", // ampm
                "KK\tBK", // eras
                "Mori ghwa imbiri\tMori ghwa kawi\tMori ghwa kadadu\tMori ghwa kana\tMori ghwa kasanu\tMori ghwa karandadu\tMori ghwa mfungade\tMori ghwa wunyanya\tMori ghwa ikenda\tMori ghwa ikumi\tMori ghwa ikumi na imweri\tMori ghwa ikumi na iwi", // months
                "Imb\tKaw\tKad\tKan\tKas\tKar\tMfu\tWun\tIke\tIku\tImw\tIwi", // shortMonths
                "Jum\tJim\tKaw\tKad\tKan\tKas\tNgu", // shortWeekdays
                "Ituku ja jumwa\tKuramuka jimweri\tKuramuka kawi\tKuramuka kadadu\tKuramuka kana\tKuramuka kasanu\tKifula nguwo" // weekdays
        );

        DateFormatSymbols.register(
                "de\tde-BE\tde-CH\tde-DE\tde-LI\tde-LU", // locales
                "vorm.\tnachm.", // ampm
                "v. Chr.\tn. Chr.", // eras
                "Januar\tFebruar\tMärz\tApril\tMai\tJuni\tJuli\tAugust\tSeptember\tOktober\tNovember\tDezember", // months
                "Jan.\tFeb.\tMärz\tApr.\tMai\tJuni\tJuli\tAug.\tSep.\tOkt.\tNov.\tDez.", // shortMonths
                "So.\tMo.\tDi.\tMi.\tDo.\tFr.\tSa.", // shortWeekdays
                "Sonntag\tMontag\tDienstag\tMittwoch\tDonnerstag\tFreitag\tSamstag" // weekdays
        );

        DateFormatSymbols.register(
                "de-AT", // locales
                "vorm.\tnachm.", // ampm
                "v. Chr.\tn. Chr.", // eras
                "Jänner\tFebruar\tMärz\tApril\tMai\tJuni\tJuli\tAugust\tSeptember\tOktober\tNovember\tDezember", // months
                "Jän.\tFeb.\tMärz\tApr.\tMai\tJuni\tJuli\tAug.\tSep.\tOkt.\tNov.\tDez.", // shortMonths
                "So.\tMo.\tDi.\tMi.\tDo.\tFr.\tSa.", // shortWeekdays
                "Sonntag\tMontag\tDienstag\tMittwoch\tDonnerstag\tFreitag\tSamstag" // weekdays
        );

        DateFormatSymbols.register(
                "dje\tdje-NE", // locales
                "Subbaahi\tZaarikay b", // ampm
                "IJ\tIZ", // eras
                "Žanwiye\tFeewiriye\tMarsi\tAwiril\tMe\tŽuweŋ\tŽuyye\tUt\tSektanbur\tOktoobur\tNoowanbur\tDeesanbur", // months
                "Žan\tFee\tMar\tAwi\tMe\tŽuw\tŽuy\tUt\tSek\tOkt\tNoo\tDee", // shortMonths
                "Alh\tAti\tAta\tAla\tAlm\tAlz\tAsi", // shortWeekdays
                "Alhadi\tAtinni\tAtalaata\tAlarba\tAlhamisi\tAlzuma\tAsibti" // weekdays
        );

        DateFormatSymbols.register(
                "dsb\tdsb-DE", // locales
                "dopołdnja\twótpołdnja", // ampm
                "pś.Chr.n.\tpó Chr.n.", // eras
                "januara\tfebruara\tměrca\tapryla\tmaja\tjunija\tjulija\tawgusta\tseptembra\toktobra\tnowembra\tdecembra", // months
                "jan.\tfeb.\tměr.\tapr.\tmaj.\tjun.\tjul.\tawg.\tsep.\tokt.\tnow.\tdec.", // shortMonths
                "nje\tpón\twał\tsrj\tstw\tpět\tsob", // shortWeekdays
                "njeźela\tpónjeźele\twałtora\tsrjoda\tstwórtk\tpětk\tsobota" // weekdays
        );

        DateFormatSymbols.register(
                "dua\tdua-CM", // locales
                "idiɓa\tebyámu", // ampm
                "ɓ.Ys\tmb.Ys", // eras
                "dimɔ́di\tŋgɔndɛ\tsɔŋɛ\tdiɓáɓá\temiasele\tesɔpɛsɔpɛ\tmadiɓɛ́díɓɛ́\tdiŋgindi\tnyɛtɛki\tmayésɛ́\ttiníní\teláŋgɛ́", // months
                "di\tŋgɔn\tsɔŋ\tdiɓ\temi\tesɔ\tmad\tdiŋ\tnyɛt\tmay\ttin\telá", // shortMonths
                "ét\tmɔ́s\tkwa\tmuk\tŋgi\tɗón\tesa", // shortWeekdays
                "éti\tmɔ́sú\tkwasú\tmukɔ́sú\tŋgisú\tɗónɛsú\tesaɓasú" // weekdays
        );

        DateFormatSymbols.register(
                "dyo\tdyo-SN", // locales
                "AM\tPM", // ampm
                "ArY\tAtY", // eras
                "Sanvie\tFébirie\tMars\tAburil\tMee\tSueŋ\tSúuyee\tUt\tSettembar\tOktobar\tNovembar\tDisambar", // months
                "Sa\tFe\tMa\tAb\tMe\tSu\tSú\tUt\tSe\tOk\tNo\tDe", // shortMonths
                "Dim\tTen\tTal\tAla\tAra\tArj\tSib", // shortWeekdays
                "Dimas\tTeneŋ\tTalata\tAlarbay\tAramisay\tArjuma\tSibiti" // weekdays
        );

        DateFormatSymbols.register(
                "dz\tdz-BT", // locales
                "སྔ་ཆ་\tཕྱི་ཆ་", // ampm
                "BCE\tCE", // eras
                "ཟླ་དངཔ་\tཟླ་གཉིས་པ་\tཟླ་གསུམ་པ་\tཟླ་བཞི་པ་\tཟླ་ལྔ་པ་\tཟླ་དྲུག་པ\tཟླ་བདུན་པ་\tཟླ་བརྒྱད་པ་\tཟླ་དགུ་པ་\tཟླ་བཅུ་པ་\tཟླ་བཅུ་གཅིག་པ་\tཟླ་བཅུ་གཉིས་པ་", // months
                "༡\t༢\t༣\t༤\t༥\t༦\t༧\t༨\t༩\t༡༠\t༡༡\t12", // shortMonths
                "ཟླ་\tམིར་\tལྷག་\tཕུར་\tསངས་\tསྤེན་\tཉི་", // shortWeekdays
                "གཟའ་ཟླ་བ་\tགཟའ་མིག་དམར་\tགཟའ་ལྷག་པ་\tགཟའ་ཕུར་བུ་\tགཟའ་པ་སངས་\tགཟའ་སྤེན་པ་\tགཟའ་ཉི་མ་" // weekdays
        );

        DateFormatSymbols.register(
                "ebu\tebu-KE", // locales
                "KI\tUT", // ampm
                "MK\tTK", // eras
                "Mweri wa mbere\tMweri wa kaĩri\tMweri wa kathatũ\tMweri wa kana\tMweri wa gatano\tMweri wa gatantatũ\tMweri wa mũgwanja\tMweri wa kanana\tMweri wa kenda\tMweri wa ikũmi\tMweri wa ikũmi na ũmwe\tMweri wa ikũmi na Kaĩrĩ", // months
                "Mbe\tKai\tKat\tKan\tGat\tGan\tMug\tKnn\tKen\tIku\tImw\tIgi", // shortMonths
                "Kma\tTat\tIne\tTan\tArm\tMaa\tNMM", // shortWeekdays
                "Kiumia\tNjumatatu\tNjumaine\tNjumatano\tAramithi\tNjumaa\tNJumamothii" // weekdays
        );

        DateFormatSymbols.register(
                "ee\tee-GH\tee-TG", // locales
                "ŋdi\tɣetrɔ", // ampm
                "hY\tYŋ", // eras
                "dzove\tdzodze\ttedoxe\tafɔfĩe\tdama\tmasa\tsiamlɔm\tdeasiamime\tanyɔnyɔ\tkele\tadeɛmekpɔxe\tdzome", // months
                "dzv\tdzd\tted\tafɔ\tdam\tmas\tsia\tdea\tany\tkel\tade\tdzm", // shortMonths
                "kɔs\tdzo\tbla\tkuɖ\tyaw\tfiɖ\tmem", // shortWeekdays
                "kɔsiɖa\tdzoɖa\tblaɖa\tkuɖa\tyawoɖa\tfiɖa\tmemleɖa" // weekdays
        );

        DateFormatSymbols.register(
                "el\tel-CY\tel-GR", // locales
                "π.μ.\tμ.μ.", // ampm
                "π.Χ.\tμ.Χ.", // eras
                "Ιανουαρίου\tΦεβρουαρίου\tΜαρτίου\tΑπριλίου\tΜαΐου\tΙουνίου\tΙουλίου\tΑυγούστου\tΣεπτεμβρίου\tΟκτωβρίου\tΝοεμβρίου\tΔεκεμβρίου", // months
                "Ιαν\tΦεβ\tΜαρ\tΑπρ\tΜαΐ\tΙουν\tΙουλ\tΑυγ\tΣεπ\tΟκτ\tΝοε\tΔεκ", // shortMonths
                "Κυρ\tΔευ\tΤρί\tΤετ\tΠέμ\tΠαρ\tΣάβ", // shortWeekdays
                "Κυριακή\tΔευτέρα\tΤρίτη\tΤετάρτη\tΠέμπτη\tΠαρασκευή\tΣάββατο" // weekdays
        );

        DateFormatSymbols.register(
                "en\ten-001\ten-150\ten-AG\ten-AI\ten-AS\ten-AT\ten-BB\ten-BE\ten-BI\ten-BM\ten-BS\ten-BW\ten-BZ\ten-CA\ten-CC\ten-CH\ten-CK\ten-CM\ten-CX\ten-CY\ten-DE\ten-DG\ten-DK\ten-DM\ten-ER\ten-FI\ten-FJ\ten-FK\ten-FM\ten-GD\ten-GG\ten-GH\ten-GI\ten-GM\ten-GU\ten-GY\ten-HK\ten-IL\ten-IM\ten-IN\ten-IO\ten-JE\ten-JM\ten-KE\ten-KI\ten-KN\ten-KY\ten-LC\ten-LR\ten-LS\ten-MG\ten-MH\ten-MO\ten-MP\ten-MS\ten-MT\ten-MU\ten-MW\ten-MY\ten-NA\ten-NF\ten-NG\ten-NL\ten-NR\ten-NU\ten-NZ\ten-PG\ten-PH\ten-PK\ten-PN\ten-PR\ten-PW\ten-RW\ten-SB\ten-SC\ten-SD\ten-SE\ten-SG\ten-SH\ten-SI\ten-SL\ten-SS\ten-SX\ten-SZ\ten-TC\ten-TK\ten-TO\ten-TT\ten-TV\ten-TZ\ten-UG\ten-UM\ten-US\ten-US-POSIX\ten-VC\ten-VG\ten-VI\ten-VU\ten-WS\ten-ZA\ten-ZM\ten-ZW", // locales
                "AM\tPM", // ampm
                "BC\tAD", // eras
                "January\tFebruary\tMarch\tApril\tMay\tJune\tJuly\tAugust\tSeptember\tOctober\tNovember\tDecember", // months
                "Jan\tFeb\tMar\tApr\tMay\tJun\tJul\tAug\tSep\tOct\tNov\tDec", // shortMonths
                "Sun\tMon\tTue\tWed\tThu\tFri\tSat", // shortWeekdays
                "Sunday\tMonday\tTuesday\tWednesday\tThursday\tFriday\tSaturday" // weekdays
        );

        DateFormatSymbols.register(
                "en-AU", // locales
                "am\tpm", // ampm
                "BC\tAD", // eras
                "January\tFebruary\tMarch\tApril\tMay\tJune\tJuly\tAugust\tSeptember\tOctober\tNovember\tDecember", // months
                "Jan.\tFeb.\tMar.\tApr.\tMay\tJun.\tJul.\tAug.\tSep.\tOct.\tNov.\tDec.", // shortMonths
                "Sun.\tMon.\tTue.\tWed.\tThu.\tFri.\tSat.", // shortWeekdays
                "Sunday\tMonday\tTuesday\tWednesday\tThursday\tFriday\tSaturday" // weekdays
        );

        DateFormatSymbols.register(
                "en-GB", // locales
                "am\tpm", // ampm
                "BC\tAD", // eras
                "January\tFebruary\tMarch\tApril\tMay\tJune\tJuly\tAugust\tSeptember\tOctober\tNovember\tDecember", // months
                "Jan\tFeb\tMar\tApr\tMay\tJun\tJul\tAug\tSep\tOct\tNov\tDec", // shortMonths
                "Sun\tMon\tTue\tWed\tThu\tFri\tSat", // shortWeekdays
                "Sunday\tMonday\tTuesday\tWednesday\tThursday\tFriday\tSaturday" // weekdays
        );

        DateFormatSymbols.register(
                "en-IE", // locales
                "a.m.\tp.m.", // ampm
                "BC\tAD", // eras
                "January\tFebruary\tMarch\tApril\tMay\tJune\tJuly\tAugust\tSeptember\tOctober\tNovember\tDecember", // months
                "Jan\tFeb\tMar\tApr\tMay\tJun\tJul\tAug\tSep\tOct\tNov\tDec", // shortMonths
                "Sun\tMon\tTue\tWed\tThu\tFri\tSat", // shortWeekdays
                "Sunday\tMonday\tTuesday\tWednesday\tThursday\tFriday\tSaturday" // weekdays
        );

        DateFormatSymbols.register(
                "eo\teo-001", // locales
                "atm\tptm", // ampm
                "aK\tpK", // eras
                "januaro\tfebruaro\tmarto\taprilo\tmajo\tjunio\tjulio\taŭgusto\tseptembro\toktobro\tnovembro\tdecembro", // months
                "jan\tfeb\tmar\tapr\tmaj\tjun\tjul\taŭg\tsep\tokt\tnov\tdec", // shortMonths
                "di\tlu\tma\tme\tĵa\tve\tsa", // shortWeekdays
                "dimanĉo\tlundo\tmardo\tmerkredo\tĵaŭdo\tvendredo\tsabato" // weekdays
        );

        DateFormatSymbols.register(
                "es\tes-EA\tes-ES\tes-GQ\tes-IC\tes-PH\tes-VE", // locales
                "a. m.\tp. m.", // ampm
                "a. C.\td. C.", // eras
                "enero\tfebrero\tmarzo\tabril\tmayo\tjunio\tjulio\tagosto\tseptiembre\toctubre\tnoviembre\tdiciembre", // months
                "ene.\tfeb.\tmar.\tabr.\tmay.\tjun.\tjul.\tago.\tsept.\toct.\tnov.\tdic.", // shortMonths
                "dom.\tlun.\tmar.\tmié.\tjue.\tvie.\tsáb.", // shortWeekdays
                "domingo\tlunes\tmartes\tmiércoles\tjueves\tviernes\tsábado" // weekdays
        );

        DateFormatSymbols.register(
                "es-419\tes-AR\tes-BO\tes-BR\tes-CR\tes-CU\tes-DO\tes-EC\tes-GT\tes-HN\tes-NI\tes-PA\tes-PR\tes-SV", // locales
                "a.m.\tp.m.", // ampm
                "a. C.\td. C.", // eras
                "enero\tfebrero\tmarzo\tabril\tmayo\tjunio\tjulio\tagosto\tseptiembre\toctubre\tnoviembre\tdiciembre", // months
                "ene.\tfeb.\tmar.\tabr.\tmay.\tjun.\tjul.\tago.\tsep.\toct.\tnov.\tdic.", // shortMonths
                "dom.\tlun.\tmar.\tmié.\tjue.\tvie.\tsáb.", // shortWeekdays
                "domingo\tlunes\tmartes\tmiércoles\tjueves\tviernes\tsábado" // weekdays
        );

        DateFormatSymbols.register(
                "es-CL\tes-CO\tes-PY", // locales
                "a.m.\tp.m.", // ampm
                "a. C.\td. C.", // eras
                "enero\tfebrero\tmarzo\tabril\tmayo\tjunio\tjulio\tagosto\tseptiembre\toctubre\tnoviembre\tdiciembre", // months
                "ene.\tfeb.\tmar.\tabr.\tmay.\tjun.\tjul.\tago.\tsept.\toct.\tnov.\tdic.", // shortMonths
                "dom.\tlun.\tmar.\tmié.\tjue.\tvie.\tsáb.", // shortWeekdays
                "domingo\tlunes\tmartes\tmiércoles\tjueves\tviernes\tsábado" // weekdays
        );

        DateFormatSymbols.register(
                "es-MX", // locales
                "a.m.\tp.m.", // ampm
                "a. C.\td. C.", // eras
                "enero\tfebrero\tmarzo\tabril\tmayo\tjunio\tjulio\tagosto\tseptiembre\toctubre\tnoviembre\tdiciembre", // months
                "ene\tfeb\tmar\tabr\tmay\tjun\tjul\tago\tsep\toct\tnov\tdic", // shortMonths
                "dom.\tlun.\tmar.\tmié.\tjue.\tvie.\tsáb.", // shortWeekdays
                "domingo\tlunes\tmartes\tmiércoles\tjueves\tviernes\tsábado" // weekdays
        );

        DateFormatSymbols.register(
                "es-PE\tes-UY", // locales
                "a.m.\tp.m.", // ampm
                "a. C.\td. C.", // eras
                "enero\tfebrero\tmarzo\tabril\tmayo\tjunio\tjulio\tagosto\tsetiembre\toctubre\tnoviembre\tdiciembre", // months
                "ene.\tfeb.\tmar.\tabr.\tmay.\tjun.\tjul.\tago.\tset.\toct.\tnov.\tdic.", // shortMonths
                "dom.\tlun.\tmar.\tmié.\tjue.\tvie.\tsáb.", // shortWeekdays
                "domingo\tlunes\tmartes\tmiércoles\tjueves\tviernes\tsábado" // weekdays
        );

        DateFormatSymbols.register(
                "es-US", // locales
                "AM\tPM", // ampm
                "a. C.\td. C.", // eras
                "enero\tfebrero\tmarzo\tabril\tmayo\tjunio\tjulio\tagosto\tseptiembre\toctubre\tnoviembre\tdiciembre", // months
                "ene.\tfeb.\tmar.\tabr.\tmay.\tjun.\tjul.\tago.\tsep.\toct.\tnov.\tdic.", // shortMonths
                "dom.\tlun.\tmar.\tmié.\tjue.\tvie.\tsáb.", // shortWeekdays
                "domingo\tlunes\tmartes\tmiércoles\tjueves\tviernes\tsábado" // weekdays
        );

        DateFormatSymbols.register(
                "et\tet-EE", // locales
                "AM\tPM", // ampm
                "eKr\tpKr", // eras
                "jaanuar\tveebruar\tmärts\taprill\tmai\tjuuni\tjuuli\taugust\tseptember\toktoober\tnovember\tdetsember", // months
                "jaan\tveebr\tmärts\tapr\tmai\tjuuni\tjuuli\taug\tsept\tokt\tnov\tdets", // shortMonths
                "P\tE\tT\tK\tN\tR\tL", // shortWeekdays
                "pühapäev\tesmaspäev\tteisipäev\tkolmapäev\tneljapäev\treede\tlaupäev" // weekdays
        );

        DateFormatSymbols.register(
                "eu\teu-ES", // locales
                "AM\tPM", // ampm
                "K.a.\tK.o.", // eras
                "urtarrilak\totsailak\tmartxoak\tapirilak\tmaiatzak\tekainak\tuztailak\tabuztuak\tirailak\turriak\tazaroak\tabenduak", // months
                "urt.\tots.\tmar.\tapi.\tmai.\teka.\tuzt.\tabu.\tira.\turr.\taza.\tabe.", // shortMonths
                "ig.\tal.\tar.\taz.\tog.\tor.\tlr.", // shortWeekdays
                "igandea\tastelehena\tasteartea\tasteazkena\tosteguna\tostirala\tlarunbata" // weekdays
        );

        DateFormatSymbols.register(
                "ewo\tewo-CM", // locales
                "kíkíríg\tngəgógəle", // ampm
                "oyk\tayk", // eras
                "ngɔn osú\tngɔn bɛ̌\tngɔn lála\tngɔn nyina\tngɔn tána\tngɔn saməna\tngɔn zamgbála\tngɔn mwom\tngɔn ebulú\tngɔn awóm\tngɔn awóm ai dziá\tngɔn awóm ai bɛ̌", // months
                "ngo\tngb\tngl\tngn\tngt\tngs\tngz\tngm\tnge\tnga\tngad\tngab", // shortMonths
                "sɔ́n\tmɔ́n\tsmb\tsml\tsmn\tfúl\tsér", // shortWeekdays
                "sɔ́ndɔ\tmɔ́ndi\tsɔ́ndɔ məlú mə́bɛ̌\tsɔ́ndɔ məlú mə́lɛ́\tsɔ́ndɔ məlú mə́nyi\tfúladé\tséradé" // weekdays
        );

        DateFormatSymbols.register(
                "fa\tfa-IR", // locales
                "قبل‌ازظهر\tبعدازظهر", // ampm
                "ق.م.\tم.", // eras
                "ژانویهٔ\tفوریهٔ\tمارس\tآوریل\tمهٔ\tژوئن\tژوئیهٔ\tاوت\tسپتامبر\tاکتبر\tنوامبر\tدسامبر", // months
                "ژانویهٔ\tفوریهٔ\tمارس\tآوریل\tمهٔ\tژوئن\tژوئیهٔ\tاوت\tسپتامبر\tاکتبر\tنوامبر\tدسامبر", // shortMonths
                "یکشنبه\tدوشنبه\tسه‌شنبه\tچهارشنبه\tپنجشنبه\tجمعه\tشنبه", // shortWeekdays
                "یکشنبه\tدوشنبه\tسه‌شنبه\tچهارشنبه\tپنجشنبه\tجمعه\tشنبه" // weekdays
        );

        DateFormatSymbols.register(
                "fa-AF", // locales
                "قبل‌ازظهر\tبعدازظهر", // ampm
                "ق.م.\tم.", // eras
                "جنوری\tفبروری\tمارچ\tاپریل\tمی\tجون\tجولای\tاگست\tسپتمبر\tاکتوبر\tنومبر\tدسمبر", // months
                "جنو\tفبروری\tمارچ\tاپریل\tمی\tجون\tجول\tاگست\tسپتمبر\tاکتوبر\tنومبر\tدسم", // shortMonths
                "یکشنبه\tدوشنبه\tسه‌شنبه\tچهارشنبه\tپنجشنبه\tجمعه\tشنبه", // shortWeekdays
                "یکشنبه\tدوشنبه\tسه‌شنبه\tچهارشنبه\tپنجشنبه\tجمعه\tشنبه" // weekdays
        );

        DateFormatSymbols.register(
                "ff\tff-CM\tff-GN\tff-MR\tff-SN", // locales
                "subaka\tkikiiɗe", // ampm
                "H-I\tC-I", // eras
                "siilo\tcolte\tmbooy\tseeɗto\tduujal\tkorse\tmorso\tjuko\tsiilto\tyarkomaa\tjolal\tbowte", // months
                "sii\tcol\tmbo\tsee\tduu\tkor\tmor\tjuk\tslt\tyar\tjol\tbow", // shortMonths
                "dew\taaɓ\tmaw\tnje\tnaa\tmwd\thbi", // shortWeekdays
                "dewo\taaɓnde\tmawbaare\tnjeslaare\tnaasaande\tmawnde\thoore-biir" // weekdays
        );

        DateFormatSymbols.register(
                "fi\tfi-FI", // locales
                "ap.\tip.", // ampm
                "eKr.\tjKr.", // eras
                "tammikuuta\thelmikuuta\tmaaliskuuta\thuhtikuuta\ttoukokuuta\tkesäkuuta\theinäkuuta\telokuuta\tsyyskuuta\tlokakuuta\tmarraskuuta\tjoulukuuta", // months
                "tammikuuta\thelmikuuta\tmaaliskuuta\thuhtikuuta\ttoukokuuta\tkesäkuuta\theinäkuuta\telokuuta\tsyyskuuta\tlokakuuta\tmarraskuuta\tjoulukuuta", // shortMonths
                "su\tma\tti\tke\tto\tpe\tla", // shortWeekdays
                "sunnuntaina\tmaanantaina\ttiistaina\tkeskiviikkona\ttorstaina\tperjantaina\tlauantaina" // weekdays
        );

        DateFormatSymbols.register(
                "fil\tfil-PH", // locales
                "AM\tPM", // ampm
                "BC\tAD", // eras
                "Enero\tPebrero\tMarso\tAbril\tMayo\tHunyo\tHulyo\tAgosto\tSetyembre\tOktubre\tNobyembre\tDisyembre", // months
                "Ene\tPeb\tMar\tAbr\tMay\tHun\tHul\tAgo\tSet\tOkt\tNob\tDis", // shortMonths
                "Lin\tLun\tMar\tMiy\tHuw\tBiy\tSab", // shortWeekdays
                "Linggo\tLunes\tMartes\tMiyerkules\tHuwebes\tBiyernes\tSabado" // weekdays
        );

        DateFormatSymbols.register(
                "fo\tfo-DK\tfo-FO", // locales
                "AM\tPM", // ampm
                "f.Kr.\te.Kr.", // eras
                "januar\tfebruar\tmars\tapríl\tmai\tjuni\tjuli\taugust\tseptember\toktober\tnovember\tdesember", // months
                "jan.\tfeb.\tmar.\tapr.\tmai\tjun.\tjul.\taug.\tsep.\tokt.\tnov.\tdes.", // shortMonths
                "sun.\tmán.\ttýs.\tmik.\thós.\tfrí.\tley.", // shortWeekdays
                "sunnudagur\tmánadagur\ttýsdagur\tmikudagur\thósdagur\tfríggjadagur\tleygardagur" // weekdays
        );

        DateFormatSymbols.register(
                "fr\tfr-BE\tfr-BF\tfr-BI\tfr-BJ\tfr-BL\tfr-CA\tfr-CD\tfr-CF\tfr-CG\tfr-CH\tfr-CI\tfr-CM\tfr-DJ\tfr-DZ\tfr-FR\tfr-GA\tfr-GF\tfr-GN\tfr-GP\tfr-GQ\tfr-HT\tfr-KM\tfr-LU\tfr-MC\tfr-MF\tfr-MG\tfr-ML\tfr-MQ\tfr-MR\tfr-MU\tfr-NC\tfr-NE\tfr-PF\tfr-PM\tfr-RE\tfr-RW\tfr-SC\tfr-SN\tfr-SY\tfr-TD\tfr-TG\tfr-TN\tfr-VU\tfr-WF\tfr-YT", // locales
                "AM\tPM", // ampm
                "av. J.-C.\tap. J.-C.", // eras
                "janvier\tfévrier\tmars\tavril\tmai\tjuin\tjuillet\taoût\tseptembre\toctobre\tnovembre\tdécembre", // months
                "janv.\tfévr.\tmars\tavr.\tmai\tjuin\tjuil.\taoût\tsept.\toct.\tnov.\tdéc.", // shortMonths
                "dim.\tlun.\tmar.\tmer.\tjeu.\tven.\tsam.", // shortWeekdays
                "dimanche\tlundi\tmardi\tmercredi\tjeudi\tvendredi\tsamedi" // weekdays
        );

        DateFormatSymbols.register(
                "fr-MA", // locales
                "a.m.\tp.m.", // ampm
                "av. J.-C.\tap. J.-C.", // eras
                "janvier\tfévrier\tmars\tavril\tmai\tjuin\tjuillet\taoût\tseptembre\toctobre\tnovembre\tdécembre", // months
                "jan.\tfév.\tmar.\tavr.\tmai\tjui.\tjuil.\taoût\tsept.\toct.\tnov.\tdéc.", // shortMonths
                "dim.\tlun.\tmar.\tmer.\tjeu.\tven.\tsam.", // shortWeekdays
                "dimanche\tlundi\tmardi\tmercredi\tjeudi\tvendredi\tsamedi" // weekdays
        );

        DateFormatSymbols.register(
                "fur\tfur-IT", // locales
                "a.\tp.", // ampm
                "pdC\tddC", // eras
                "Zenâr\tFevrâr\tMarç\tAvrîl\tMai\tJugn\tLui\tAvost\tSetembar\tOtubar\tNovembar\tDicembar", // months
                "Zen\tFev\tMar\tAvr\tMai\tJug\tLui\tAvo\tSet\tOtu\tNov\tDic", // shortMonths
                "dom\tlun\tmar\tmie\tjoi\tvin\tsab", // shortWeekdays
                "domenie\tlunis\tmartars\tmiercus\tjoibe\tvinars\tsabide" // weekdays
        );

        DateFormatSymbols.register(
                "fy\tfy-NL", // locales
                "AM\tPM", // ampm
                "f.Kr.\tn.Kr.", // eras
                "jannewaris\tfebrewaris\tmaart\tapril\tmaaie\tjuny\tjuly\taugustus\tseptimber\toktober\tnovimber\tdesimber", // months
                "jan.\tfeb.\tmrt.\tapr.\tmai.\tjun.\tjul.\taug.\tsep.\tokt.\tnov.\tdes.", // shortMonths
                "si\tmo\tti\two\tto\tfr\tso", // shortWeekdays
                "snein\tmoandei\ttiisdei\twoansdei\ttongersdei\tfreed\tsneon" // weekdays
        );

        DateFormatSymbols.register(
                "ga\tga-IE", // locales
                "a.m.\tp.m.", // ampm
                "RC\tAD", // eras
                "Eanáir\tFeabhra\tMárta\tAibreán\tBealtaine\tMeitheamh\tIúil\tLúnasa\tMeán Fómhair\tDeireadh Fómhair\tSamhain\tNollaig", // months
                "Ean\tFeabh\tMárta\tAib\tBeal\tMeith\tIúil\tLún\tMFómh\tDFómh\tSamh\tNoll", // shortMonths
                "Domh\tLuan\tMáirt\tCéad\tDéar\tAoine\tSath", // shortWeekdays
                "Dé Domhnaigh\tDé Luain\tDé Máirt\tDé Céadaoin\tDéardaoin\tDé hAoine\tDé Sathairn" // weekdays
        );

        DateFormatSymbols.register(
                "gd\tgd-GB", // locales
                "m\tf", // ampm
                "RC\tAD", // eras
                "dhen Fhaoilleach\tdhen Ghearran\tdhen Mhàrt\tdhen Ghiblean\tdhen Chèitean\tdhen Ògmhios\tdhen Iuchar\tdhen Lùnastal\tdhen t-Sultain\tdhen Dàmhair\tdhen t-Samhain\tdhen Dùbhlachd", // months
                "Faoi\tGearr\tMàrt\tGibl\tCèit\tÒgmh\tIuch\tLùna\tSult\tDàmh\tSamh\tDùbh", // shortMonths
                "DiD\tDiL\tDiM\tDiC\tDia\tDih\tDiS", // shortWeekdays
                "DiDòmhnaich\tDiLuain\tDiMàirt\tDiCiadain\tDiarDaoin\tDihAoine\tDiSathairne" // weekdays
        );

        DateFormatSymbols.register(
                "gl\tgl-ES", // locales
                "a.m.\tp.m.", // ampm
                "a.C.\td.C.", // eras
                "xaneiro\tfebreiro\tmarzo\tabril\tmaio\txuño\txullo\tagosto\tsetembro\toutubro\tnovembro\tdecembro", // months
                "xan\tfeb\tmar\tabr\tmai\txuñ\txul\tago\tset\tout\tnov\tdec", // shortMonths
                "dom\tluns\tmar\tmér\txov\tven\tsáb", // shortWeekdays
                "domingo\tluns\tmartes\tmércores\txoves\tvenres\tsábado" // weekdays
        );

        DateFormatSymbols.register(
                "gsw\tgsw-CH\tgsw-FR\tgsw-LI", // locales
                "vorm.\tnam.", // ampm
                "v. Chr.\tn. Chr.", // eras
                "Januar\tFebruar\tMärz\tApril\tMai\tJuni\tJuli\tAuguscht\tSeptämber\tOktoober\tNovämber\tDezämber", // months
                "Jan\tFeb\tMär\tApr\tMai\tJun\tJul\tAug\tSep\tOkt\tNov\tDez", // shortMonths
                "Su.\tMä.\tZi.\tMi.\tDu.\tFr.\tSa.", // shortWeekdays
                "Sunntig\tMääntig\tZiischtig\tMittwuch\tDunschtig\tFriitig\tSamschtig" // weekdays
        );

        DateFormatSymbols.register(
                "gu\tgu-IN", // locales
                "AM\tPM", // ampm
                "ઈ.સ.પૂર્વે\tઈ.સ.", // eras
                "જાન્યુઆરી\tફેબ્રુઆરી\tમાર્ચ\tએપ્રિલ\tમે\tજૂન\tજુલાઈ\tઑગસ્ટ\tસપ્ટેમ્બર\tઑક્ટોબર\tનવેમ્બર\tડિસેમ્બર", // months
                "જાન્યુ\tફેબ્રુ\tમાર્ચ\tએપ્રિલ\tમે\tજૂન\tજુલાઈ\tઑગસ્ટ\tસપ્ટે\tઑક્ટો\tનવે\tડિસે", // shortMonths
                "રવિ\tસોમ\tમંગળ\tબુધ\tગુરુ\tશુક્ર\tશનિ", // shortWeekdays
                "રવિવાર\tસોમવાર\tમંગળવાર\tબુધવાર\tગુરુવાર\tશુક્રવાર\tશનિવાર" // weekdays
        );

        DateFormatSymbols.register(
                "guz\tguz-KE", // locales
                "Mambia\tMog", // ampm
                "YA\tYK", // eras
                "Chanuari\tFeburari\tMachi\tApiriri\tMei\tJuni\tChulai\tAgosti\tSeptemba\tOkitoba\tNobemba\tDisemba", // months
                "Can\tFeb\tMac\tApr\tMei\tJun\tCul\tAgt\tSep\tOkt\tNob\tDis", // shortMonths
                "Cpr\tCtt\tCmn\tCmt\tArs\tIcm\tEst", // shortWeekdays
                "Chumapiri\tChumatato\tChumaine\tChumatano\tAramisi\tIchuma\tEsabato" // weekdays
        );

        DateFormatSymbols.register(
                "gv\tgv-IM", // locales
                "a.m.\tp.m.", // ampm
                "RC\tAD", // eras
                "Jerrey-geuree\tToshiaght-arree\tMayrnt\tAveril\tBoaldyn\tMean-souree\tJerrey-souree\tLuanistyn\tMean-fouyir\tJerrey-fouyir\tMee Houney\tMee ny Nollick", // months
                "J-guer\tT-arree\tMayrnt\tAvrril\tBoaldyn\tM-souree\tJ-souree\tLuanistyn\tM-fouyir\tJ-fouyir\tM-Houney\tM-Nollick", // shortMonths
                "Jed\tJel\tJem\tJerc\tJerd\tJeh\tJes", // shortWeekdays
                "Jedoonee\tJelhein\tJemayrt\tJercean\tJerdein\tJeheiney\tJesarn" // weekdays
        );

        DateFormatSymbols.register(
                "ha\tha-GH\tha-NE\tha-NG", // locales
                "AM\tPM", // ampm
                "KHAI\tBHAI", // eras
                "Janairu\tFaburairu\tMaris\tAfirilu\tMayu\tYuni\tYuli\tAgusta\tSatumba\tOktoba\tNuwamba\tDisamba", // months
                "Jan\tFab\tMar\tAfi\tMay\tYun\tYul\tAgu\tSat\tOkt\tNuw\tDis", // shortMonths
                "Lh\tLi\tTa\tLr\tAl\tJu\tAs", // shortWeekdays
                "Lahadi\tLitinin\tTalata\tLaraba\tAlhamis\tJummaʼa\tAsabar" // weekdays
        );

        DateFormatSymbols.register(
                "haw\thaw-US", // locales
                "AM\tPM", // ampm
                "BCE\tCE", // eras
                "Ianuali\tPepeluali\tMalaki\tʻApelila\tMei\tIune\tIulai\tʻAukake\tKepakemapa\tʻOkakopa\tNowemapa\tKekemapa", // months
                "Ian.\tPep.\tMal.\tʻAp.\tMei\tIun.\tIul.\tʻAu.\tKep.\tʻOk.\tNow.\tKek.", // shortMonths
                "LP\tP1\tP2\tP3\tP4\tP5\tP6", // shortWeekdays
                "Lāpule\tPoʻakahi\tPoʻalua\tPoʻakolu\tPoʻahā\tPoʻalima\tPoʻaono" // weekdays
        );

        DateFormatSymbols.register(
                "he\the-IL", // locales
                "לפנה״צ\tאחה״צ", // ampm
                "לפנה״ס\tלספירה", // eras
                "ינואר\tפברואר\tמרץ\tאפריל\tמאי\tיוני\tיולי\tאוגוסט\tספטמבר\tאוקטובר\tנובמבר\tדצמבר", // months
                "ינו׳\tפבר׳\tמרץ\tאפר׳\tמאי\tיוני\tיולי\tאוג׳\tספט׳\tאוק׳\tנוב׳\tדצמ׳", // shortMonths
                "יום א׳\tיום ב׳\tיום ג׳\tיום ד׳\tיום ה׳\tיום ו׳\tשבת", // shortWeekdays
                "יום ראשון\tיום שני\tיום שלישי\tיום רביעי\tיום חמישי\tיום שישי\tיום שבת" // weekdays
        );

        DateFormatSymbols.register(
                "hi\thi-IN", // locales
                "पूर्वाह्न\tअपराह्न", // ampm
                "ईसा-पूर्व\tईस्वी", // eras
                "जनवरी\tफ़रवरी\tमार्च\tअप्रैल\tमई\tजून\tजुलाई\tअगस्त\tसितंबर\tअक्तूबर\tनवंबर\tदिसंबर", // months
                "जन॰\tफ़र॰\tमार्च\tअप्रैल\tमई\tजून\tजुल॰\tअग॰\tसित॰\tअक्तू॰\tनव॰\tदिस॰", // shortMonths
                "रवि\tसोम\tमंगल\tबुध\tगुरु\tशुक्र\tशनि", // shortWeekdays
                "रविवार\tसोमवार\tमंगलवार\tबुधवार\tगुरुवार\tशुक्रवार\tशनिवार" // weekdays
        );

        DateFormatSymbols.register(
                "hr\thr-BA\thr-HR", // locales
                "AM\tPM", // ampm
                "pr. Kr.\tp. Kr.", // eras
                "siječnja\tveljače\tožujka\ttravnja\tsvibnja\tlipnja\tsrpnja\tkolovoza\trujna\tlistopada\tstudenoga\tprosinca", // months
                "sij\tvelj\tožu\ttra\tsvi\tlip\tsrp\tkol\truj\tlis\tstu\tpro", // shortMonths
                "ned\tpon\tuto\tsri\tčet\tpet\tsub", // shortWeekdays
                "nedjelja\tponedjeljak\tutorak\tsrijeda\tčetvrtak\tpetak\tsubota" // weekdays
        );

        DateFormatSymbols.register(
                "hsb\thsb-DE", // locales
                "dopołdnja\tpopołdnju", // ampm
                "př.Chr.n.\tpo Chr.n.", // eras
                "januara\tfebruara\tměrca\tapryla\tmeje\tjunija\tjulija\tawgusta\tseptembra\toktobra\tnowembra\tdecembra", // months
                "jan.\tfeb.\tměr.\tapr.\tmej.\tjun.\tjul.\tawg.\tsep.\tokt.\tnow.\tdec.", // shortMonths
                "nje\tpón\twut\tsrj\tštw\tpja\tsob", // shortWeekdays
                "njedźela\tpóndźela\twutora\tsrjeda\tštwórtk\tpjatk\tsobota" // weekdays
        );

        DateFormatSymbols.register(
                "hu\thu-HU", // locales
                "de.\tdu.", // ampm
                "i. e.\ti. sz.", // eras
                "január\tfebruár\tmárcius\táprilis\tmájus\tjúnius\tjúlius\taugusztus\tszeptember\toktóber\tnovember\tdecember", // months
                "jan.\tfebr.\tmárc.\tápr.\tmáj.\tjún.\tjúl.\taug.\tszept.\tokt.\tnov.\tdec.", // shortMonths
                "V\tH\tK\tSze\tCs\tP\tSzo", // shortWeekdays
                "vasárnap\thétfő\tkedd\tszerda\tcsütörtök\tpéntek\tszombat" // weekdays
        );

        DateFormatSymbols.register(
                "hy\thy-AM", // locales
                "AM\tPM", // ampm
                "մ.թ.ա.\tմ.թ.", // eras
                "հունվարի\tփետրվարի\tմարտի\tապրիլի\tմայիսի\tհունիսի\tհուլիսի\tօգոստոսի\tսեպտեմբերի\tհոկտեմբերի\tնոյեմբերի\tդեկտեմբերի", // months
                "հնվ\tփտվ\tմրտ\tապր\tմյս\tհնս\tհլս\tօգս\tսեպ\tհոկ\tնոյ\tդեկ", // shortMonths
                "կիր\tերկ\tերք\tչրք\tհնգ\tուր\tշբթ", // shortWeekdays
                "կիրակի\tերկուշաբթի\tերեքշաբթի\tչորեքշաբթի\tհինգշաբթի\tուրբաթ\tշաբաթ" // weekdays
        );

        DateFormatSymbols.register(
                "id\tid-ID", // locales
                "AM\tPM", // ampm
                "SM\tM", // eras
                "Januari\tFebruari\tMaret\tApril\tMei\tJuni\tJuli\tAgustus\tSeptember\tOktober\tNovember\tDesember", // months
                "Jan\tFeb\tMar\tApr\tMei\tJun\tJul\tAgt\tSep\tOkt\tNov\tDes", // shortMonths
                "Min\tSen\tSel\tRab\tKam\tJum\tSab", // shortWeekdays
                "Minggu\tSenin\tSelasa\tRabu\tKamis\tJumat\tSabtu" // weekdays
        );

        DateFormatSymbols.register(
                "ig\tig-NG", // locales
                "A.M.\tP.M.", // ampm
                "T.K.\tA.K.", // eras
                "Jenụwarị\tFebrụwarị\tMaachị\tEprel\tMee\tJuun\tJulaị\tỌgọọst\tSeptemba\tỌktoba\tNovemba\tDisemba", // months
                "Jen\tFeb\tMaa\tEpr\tMee\tJuu\tJul\tỌgọ\tSep\tỌkt\tNov\tDis", // shortMonths
                "Ụka\tMọn\tTiu\tWen\tTọọ\tFraị\tSat", // shortWeekdays
                "Mbọsị Ụka\tMọnde\tTiuzdee\tWenezdee\tTọọzdee\tFraịdee\tSatọdee" // weekdays
        );

        DateFormatSymbols.register(
                "ii\tii-CN", // locales
                "ꎸꄑ\tꁯꋒ", // ampm
                "ꃅꋊꂿ\tꃅꋊꊂ", // eras
                "ꋍꆪ\tꑍꆪ\tꌕꆪ\tꇖꆪ\tꉬꆪ\tꃘꆪ\tꏃꆪ\tꉆꆪ\tꈬꆪ\tꊰꆪ\tꊰꊪꆪ\tꊰꑋꆪ", // months
                "ꋍꆪ\tꑍꆪ\tꌕꆪ\tꇖꆪ\tꉬꆪ\tꃘꆪ\tꏃꆪ\tꉆꆪ\tꈬꆪ\tꊰꆪ\tꊰꊪꆪ\tꊰꑋꆪ", // shortMonths
                "ꑭꆏ\tꆏꋍ\tꆏꑍ\tꆏꌕ\tꆏꇖ\tꆏꉬ\tꆏꃘ", // shortWeekdays
                "ꑭꆏꑍ\tꆏꊂꋍ\tꆏꊂꑍ\tꆏꊂꌕ\tꆏꊂꇖ\tꆏꊂꉬ\tꆏꊂꃘ" // weekdays
        );

        DateFormatSymbols.register(
                "is\tis-IS", // locales
                "f.h.\te.h.", // ampm
                "f.Kr.\te.Kr.", // eras
                "janúar\tfebrúar\tmars\tapríl\tmaí\tjúní\tjúlí\tágúst\tseptember\toktóber\tnóvember\tdesember", // months
                "jan.\tfeb.\tmar.\tapr.\tmaí\tjún.\tjúl.\tágú.\tsep.\tokt.\tnóv.\tdes.", // shortMonths
                "sun.\tmán.\tþri.\tmið.\tfim.\tfös.\tlau.", // shortWeekdays
                "sunnudagur\tmánudagur\tþriðjudagur\tmiðvikudagur\tfimmtudagur\tföstudagur\tlaugardagur" // weekdays
        );

        DateFormatSymbols.register(
                "it\tit-CH\tit-IT\tit-SM", // locales
                "AM\tPM", // ampm
                "a.C.\td.C.", // eras
                "gennaio\tfebbraio\tmarzo\taprile\tmaggio\tgiugno\tluglio\tagosto\tsettembre\tottobre\tnovembre\tdicembre", // months
                "gen\tfeb\tmar\tapr\tmag\tgiu\tlug\tago\tset\tott\tnov\tdic", // shortMonths
                "dom\tlun\tmar\tmer\tgio\tven\tsab", // shortWeekdays
                "domenica\tlunedì\tmartedì\tmercoledì\tgiovedì\tvenerdì\tsabato" // weekdays
        );

        DateFormatSymbols.register(
                "ja\tja-JP", // locales
                "午前\t午後", // ampm
                "紀元前\t西暦", // eras
                "1月\t2月\t3月\t4月\t5月\t6月\t7月\t8月\t9月\t10月\t11月\t12月", // months
                "1月\t2月\t3月\t4月\t5月\t6月\t7月\t8月\t9月\t10月\t11月\t12月", // shortMonths
                "日\t月\t火\t水\t木\t金\t土", // shortWeekdays
                "日曜日\t月曜日\t火曜日\t水曜日\t木曜日\t金曜日\t土曜日" // weekdays
        );

        DateFormatSymbols.register(
                "jgo\tjgo-CM", // locales
                "mbaꞌmbaꞌ\tŋka mbɔ́t nji", // ampm
                "BCE\tCE", // eras
                "Nduŋmbi Saŋ\tPɛsaŋ Pɛ́pá\tPɛsaŋ Pɛ́tát\tPɛsaŋ Pɛ́nɛ́kwa\tPɛsaŋ Pataa\tPɛsaŋ Pɛ́nɛ́ntúkú\tPɛsaŋ Saambá\tPɛsaŋ Pɛ́nɛ́fɔm\tPɛsaŋ Pɛ́nɛ́pfúꞋú\tPɛsaŋ Nɛgɛ́m\tPɛsaŋ Ntsɔ̌pmɔ́\tPɛsaŋ Ntsɔ̌ppá", // months
                "Nduŋmbi Saŋ\tPɛsaŋ Pɛ́pá\tPɛsaŋ Pɛ́tát\tPɛsaŋ Pɛ́nɛ́kwa\tPɛsaŋ Pataa\tPɛsaŋ Pɛ́nɛ́ntúkú\tPɛsaŋ Saambá\tPɛsaŋ Pɛ́nɛ́fɔm\tPɛsaŋ Pɛ́nɛ́pfúꞋú\tPɛsaŋ Nɛgɛ́m\tPɛsaŋ Ntsɔ̌pmɔ́\tPɛsaŋ Ntsɔ̌ppá", // shortMonths
                "Sɔ́ndi\tMɔ́ndi\tÁpta Mɔ́ndi\tWɛ́nɛsɛdɛ\tTɔ́sɛdɛ\tFɛlâyɛdɛ\tSásidɛ", // shortWeekdays
                "Sɔ́ndi\tMɔ́ndi\tÁpta Mɔ́ndi\tWɛ́nɛsɛdɛ\tTɔ́sɛdɛ\tFɛlâyɛdɛ\tSásidɛ" // weekdays
        );

        DateFormatSymbols.register(
                "jmc\tjmc-TZ\trwk\trwk-TZ\tvun\tvun-TZ", // locales
                "utuko\tkyiukonyi", // ampm
                "KK\tBK", // eras
                "Januari\tFebruari\tMachi\tAprilyi\tMei\tJunyi\tJulyai\tAgusti\tSeptemba\tOktoba\tNovemba\tDesemba", // months
                "Jan\tFeb\tMac\tApr\tMei\tJun\tJul\tAgo\tSep\tOkt\tNov\tDes", // shortMonths
                "Jpi\tJtt\tJnn\tJtn\tAlh\tIju\tJmo", // shortWeekdays
                "Jumapilyi\tJumatatuu\tJumanne\tJumatanu\tAlhamisi\tIjumaa\tJumamosi" // weekdays
        );

        DateFormatSymbols.register(
                "ka\tka-GE", // locales
                "AM\tPM", // ampm
                "ძვ. წ.\tახ. წ.", // eras
                "იანვარი\tთებერვალი\tმარტი\tაპრილი\tმაისი\tივნისი\tივლისი\tაგვისტო\tსექტემბერი\tოქტომბერი\tნოემბერი\tდეკემბერი", // months
                "იან\tთებ\tმარ\tაპრ\tმაი\tივნ\tივლ\tაგვ\tსექ\tოქტ\tნოე\tდეკ", // shortMonths
                "კვი\tორშ\tსამ\tოთხ\tხუთ\tპარ\tშაბ", // shortWeekdays
                "კვირა\tორშაბათი\tსამშაბათი\tოთხშაბათი\tხუთშაბათი\tპარასკევი\tშაბათი" // weekdays
        );

        DateFormatSymbols.register(
                "kab\tkab-DZ", // locales
                "n tufat\tn tmeddit", // ampm
                "snd. T.Ɛ\tsld. T.Ɛ", // eras
                "Yennayer\tFuṛar\tMeɣres\tYebrir\tMayyu\tYunyu\tYulyu\tƔuct\tCtembeṛ\tTubeṛ\tNunembeṛ\tDuǧembeṛ", // months
                "Yen\tFur\tMeɣ\tYeb\tMay\tYun\tYul\tƔuc\tCte\tTub\tNun\tDuǧ", // shortMonths
                "Yan\tSan\tKraḍ\tKuẓ\tSam\tSḍis\tSay", // shortWeekdays
                "Yanass\tSanass\tKraḍass\tKuẓass\tSamass\tSḍisass\tSayass" // weekdays
        );

        DateFormatSymbols.register(
                "kam\tkam-KE", // locales
                "Ĩyakwakya\tĨyawĩoo", // ampm
                "MY\tIY", // eras
                "Mwai wa mbee\tMwai wa kelĩ\tMwai wa katatũ\tMwai wa kana\tMwai wa katano\tMwai wa thanthatũ\tMwai wa muonza\tMwai wa nyaanya\tMwai wa kenda\tMwai wa ĩkumi\tMwai wa ĩkumi na ĩmwe\tMwai wa ĩkumi na ilĩ", // months
                "Mbe\tKel\tKtũ\tKan\tKtn\tTha\tMoo\tNya\tKnd\tĨku\tĨkm\tĨkl", // shortMonths
                "Wky\tWkw\tWkl\tWtũ\tWkn\tWtn\tWth", // shortWeekdays
                "Wa kyumwa\tWa kwambĩlĩlya\tWa kelĩ\tWa katatũ\tWa kana\tWa katano\tWa thanthatũ" // weekdays
        );

        DateFormatSymbols.register(
                "kde\tkde-TZ", // locales
                "Muhi\tChilo", // ampm
                "AY\tNY", // eras
                "Mwedi Ntandi\tMwedi wa Pili\tMwedi wa Tatu\tMwedi wa Nchechi\tMwedi wa Nnyano\tMwedi wa Nnyano na Umo\tMwedi wa Nnyano na Mivili\tMwedi wa Nnyano na Mitatu\tMwedi wa Nnyano na Nchechi\tMwedi wa Nnyano na Nnyano\tMwedi wa Nnyano na Nnyano na U\tMwedi wa Nnyano na Nnyano na M", // months
                "Jan\tFeb\tMac\tApr\tMei\tJun\tJul\tAgo\tSep\tOkt\tNov\tDes", // shortMonths
                "Ll2\tLl3\tLl4\tLl5\tLl6\tLl7\tLl1", // shortWeekdays
                "Liduva lyapili\tLiduva lyatatu\tLiduva lyanchechi\tLiduva lyannyano\tLiduva lyannyano na linji\tLiduva lyannyano na mavili\tLiduva litandi" // weekdays
        );

        DateFormatSymbols.register(
                "kea\tkea-CV", // locales
                "am\tpm", // ampm
                "AK\tDK", // eras
                "Janeru\tFebreru\tMarsu\tAbril\tMaiu\tJunhu\tJulhu\tAgostu\tSetenbru\tOtubru\tNuvenbru\tDizenbru", // months
                "Jan\tFeb\tMar\tAbr\tMai\tJun\tJul\tAgo\tSet\tOtu\tNuv\tDiz", // shortMonths
                "dum\tsig\tter\tkua\tkin\tses\tsab", // shortWeekdays
                "dumingu\tsigunda-fera\ttersa-fera\tkuarta-fera\tkinta-fera\tsesta-fera\tsabadu" // weekdays
        );

        DateFormatSymbols.register(
                "khq\tkhq-ML", // locales
                "Adduha\tAluula", // ampm
                "IJ\tIZ", // eras
                "Žanwiye\tFeewiriye\tMarsi\tAwiril\tMe\tŽuweŋ\tŽuyye\tUt\tSektanbur\tOktoobur\tNoowanbur\tDeesanbur", // months
                "Žan\tFee\tMar\tAwi\tMe\tŽuw\tŽuy\tUt\tSek\tOkt\tNoo\tDee", // shortMonths
                "Alh\tAti\tAta\tAla\tAlm\tAlj\tAss", // shortWeekdays
                "Alhadi\tAtini\tAtalata\tAlarba\tAlhamiisa\tAljuma\tAssabdu" // weekdays
        );

        DateFormatSymbols.register(
                "ki\tki-KE", // locales
                "Kiroko\tHwaĩ-inĩ", // ampm
                "MK\tTK", // eras
                "Njenuarĩ\tMwere wa kerĩ\tMwere wa gatatũ\tMwere wa kana\tMwere wa gatano\tMwere wa gatandatũ\tMwere wa mũgwanja\tMwere wa kanana\tMwere wa kenda\tMwere wa ikũmi\tMwere wa ikũmi na ũmwe\tNdithemba", // months
                "JEN\tWKR\tWGT\tWKN\tWTN\tWTD\tWMJ\tWNN\tWKD\tWIK\tWMW\tDIT", // shortMonths
                "KMA\tNTT\tNMN\tNMT\tART\tNMA\tNMM", // shortWeekdays
                "Kiumia\tNjumatatũ\tNjumaine\tNjumatana\tAramithi\tNjumaa\tNjumamothi" // weekdays
        );

        DateFormatSymbols.register(
                "kk\tkk-KZ", // locales
                "таңғы\tтүскі/кешкі", // ampm
                "б.з.д.\tб.з.", // eras
                "қаңтар\tақпан\tнаурыз\tсәуір\tмамыр\tмаусым\tшілде\tтамыз\tқыркүйек\tқазан\tқараша\tжелтоқсан", // months
                "қаң.\tақп.\tнау.\tсәу.\tмам.\tмау.\tшіл.\tтам.\tқыр.\tқаз.\tқар.\tжел.", // shortMonths
                "Жс\tДс\tСс\tСр\tБс\tЖм\tСб", // shortWeekdays
                "жексенбі\tдүйсенбі\tсейсенбі\tсәрсенбі\tбейсенбі\tжұма\tсенбі" // weekdays
        );

        DateFormatSymbols.register(
                "kkj\tkkj-CM", // locales
                "AM\tPM", // ampm
                "BCE\tCE", // eras
                "pamba\twanja\tmbiyɔ mɛndoŋgɔ\tNyɔlɔmbɔŋgɔ\tMɔnɔ ŋgbanja\tNyaŋgwɛ ŋgbanja\tkuŋgwɛ\tfɛ\tnjapi\tnyukul\t11\tɓulɓusɛ", // months
                "pamba\twanja\tmbiyɔ mɛndoŋgɔ\tNyɔlɔmbɔŋgɔ\tMɔnɔ ŋgbanja\tNyaŋgwɛ ŋgbanja\tkuŋgwɛ\tfɛ\tnjapi\tnyukul\t11\tɓulɓusɛ", // shortMonths
                "sɔndi\tlundi\tmardi\tmɛrkɛrɛdi\tyedi\tvaŋdɛrɛdi\tmɔnɔ sɔndi", // shortWeekdays
                "sɔndi\tlundi\tmardi\tmɛrkɛrɛdi\tyedi\tvaŋdɛrɛdi\tmɔnɔ sɔndi" // weekdays
        );

        DateFormatSymbols.register(
                "kl\tkl-GL", // locales
                "AM\tPM", // ampm
                "BCE\tCE", // eras
                "januari\tfebruari\tmartsi\taprili\tmaji\tjuni\tjuli\taugustusi\tseptemberi\toktoberi\tnovemberi\tdecemberi", // months
                "jan\tfeb\tmar\tapr\tmaj\tjun\tjul\taug\tsep\tokt\tnov\tdec", // shortMonths
                "sab\tata\tmar\tpin\tsis\ttal\tarf", // shortWeekdays
                "sabaat\tataasinngorneq\tmarlunngorneq\tpingasunngorneq\tsisamanngorneq\ttallimanngorneq\tarfininngorneq" // weekdays
        );

        DateFormatSymbols.register(
                "kln\tkln-KE", // locales
                "karoon\tkooskoliny", // ampm
                "AM\tKO", // eras
                "Mulgul\tNg’atyaato\tKiptaamo\tIwootkuut\tMamuut\tPaagi\tNg’eiyeet\tRooptui\tBureet\tEpeeso\tKipsuunde ne taai\tKipsuunde nebo aeng’", // months
                "Mul\tNgat\tTaa\tIwo\tMam\tPaa\tNge\tRoo\tBur\tEpe\tKpt\tKpa", // shortMonths
                "Kts\tKot\tKoo\tKos\tKoa\tKom\tKol", // shortWeekdays
                "Kotisap\tKotaai\tKoaeng’\tKosomok\tKoang’wan\tKomuut\tKolo" // weekdays
        );

        DateFormatSymbols.register(
                "km\tkm-KH", // locales
                "ព្រឹក\tល្ងាច", // ampm
                "មុន គ.ស.\tគ.ស.", // eras
                "មករា\tកុម្ភៈ\tមីនា\tមេសា\tឧសភា\tមិថុនា\tកក្កដា\tសីហា\tកញ្ញា\tតុលា\tវិច្ឆិកា\tធ្នូ", // months
                "មករា\tកុម្ភៈ\tមីនា\tមេសា\tឧសភា\tមិថុនា\tកក្កដា\tសីហា\tកញ្ញា\tតុលា\tវិច្ឆិកា\tធ្នូ", // shortMonths
                "អាទិត្យ\tច័ន្ទ\tអង្គារ\tពុធ\tព្រហស្បតិ៍\tសុក្រ\tសៅរ៍", // shortWeekdays
                "អាទិត្យ\tច័ន្ទ\tអង្គារ\tពុធ\tព្រហស្បតិ៍\tសុក្រ\tសៅរ៍" // weekdays
        );

        DateFormatSymbols.register(
                "kn\tkn-IN", // locales
                "ಪೂರ್ವಾಹ್ನ\tಅಪರಾಹ್ನ", // ampm
                "ಕ್ರಿ.ಪೂ\tಕ್ರಿ.ಶ", // eras
                "ಜನವರಿ\tಫೆಬ್ರವರಿ\tಮಾರ್ಚ್\tಏಪ್ರಿಲ್\tಮೇ\tಜೂನ್\tಜುಲೈ\tಆಗಸ್ಟ್\tಸೆಪ್ಟೆಂಬರ್\tಅಕ್ಟೋಬರ್\tನವೆಂಬರ್\tಡಿಸೆಂಬರ್", // months
                "ಜನ\tಫೆಬ್ರ\tಮಾರ್ಚ್\tಏಪ್ರಿ\tಮೇ\tಜೂನ್\tಜುಲೈ\tಆಗ\tಸೆಪ್ಟೆಂ\tಅಕ್ಟೋ\tನವೆಂ\tಡಿಸೆಂ", // shortMonths
                "ಭಾನು\tಸೋಮ\tಮಂಗಳ\tಬುಧ\tಗುರು\tಶುಕ್ರ\tಶನಿ", // shortWeekdays
                "ಭಾನುವಾರ\tಸೋಮವಾರ\tಮಂಗಳವಾರ\tಬುಧವಾರ\tಗುರುವಾರ\tಶುಕ್ರವಾರ\tಶನಿವಾರ" // weekdays
        );

        DateFormatSymbols.register(
                "ko\tko-KP\tko-KR", // locales
                "오전\t오후", // ampm
                "BC\tAD", // eras
                "1월\t2월\t3월\t4월\t5월\t6월\t7월\t8월\t9월\t10월\t11월\t12월", // months
                "1월\t2월\t3월\t4월\t5월\t6월\t7월\t8월\t9월\t10월\t11월\t12월", // shortMonths
                "일\t월\t화\t수\t목\t금\t토", // shortWeekdays
                "일요일\t월요일\t화요일\t수요일\t목요일\t금요일\t토요일" // weekdays
        );

        DateFormatSymbols.register(
                "kok\tkok-IN", // locales
                "म.पू.\tम.नं.", // ampm
                "क्रिस्तपूर्व\tक्रिस्तशखा", // eras
                "जानेवारी\tफेब्रुवारी\tमार्च\tएप्रिल\tमे\tजून\tजुलै\tओगस्ट\tसेप्टेंबर\tओक्टोबर\tनोव्हेंबर\tडिसेंबर", // months
                "जानेवारी\tफेब्रुवारी\tमार्च\tएप्रिल\tमे\tजून\tजुलै\tओगस्ट\tसेप्टेंबर\tओक्टोबर\tनोव्हेंबर\tडिसेंबर", // shortMonths
                "रवि\tसोम\tमंगळ\tबुध\tगुरु\tशुक्र\tशनि", // shortWeekdays
                "आदित्यवार\tसोमवार\tमंगळार\tबुधवार\tगुरुवार\tशुक्रवार\tशनिवार" // weekdays
        );

        DateFormatSymbols.register(
                "ks\tks-IN", // locales
                "AM\tPM", // ampm
                "بی سی\tاے ڈی", // eras
                "جنؤری\tفرؤری\tمارٕچ\tاپریل\tمیٔ\tجوٗن\tجوٗلایی\tاگست\tستمبر\tاکتوٗبر\tنومبر\tدسمبر", // months
                "جنؤری\tفرؤری\tمارٕچ\tاپریل\tمیٔ\tجوٗن\tجوٗلایی\tاگست\tستمبر\tاکتوٗبر\tنومبر\tدسمبر", // shortMonths
                "آتھوار\tژٔنٛدٕروار\tبوٚموار\tبودوار\tبرٛٮ۪سوار\tجُمہ\tبٹوار", // shortWeekdays
                "اَتھوار\tژٔنٛدرٕروار\tبوٚموار\tبودوار\tبرٛٮ۪سوار\tجُمہ\tبٹوار" // weekdays
        );

        DateFormatSymbols.register(
                "ksb\tksb-TZ", // locales
                "makeo\tnyiaghuo", // ampm
                "KK\tBK", // eras
                "Januali\tFebluali\tMachi\tAplili\tMei\tJuni\tJulai\tAgosti\tSeptemba\tOktoba\tNovemba\tDesemba", // months
                "Jan\tFeb\tMac\tApr\tMei\tJun\tJul\tAgo\tSep\tOkt\tNov\tDes", // shortMonths
                "Jpi\tJtt\tJmn\tJtn\tAlh\tIju\tJmo", // shortWeekdays
                "Jumaapii\tJumaatatu\tJumaane\tJumaatano\tAlhamisi\tIjumaa\tJumaamosi" // weekdays
        );

        DateFormatSymbols.register(
                "ksf\tksf-CM", // locales
                "sárúwá\tcɛɛ́nko", // ampm
                "d.Y.\tk.Y.", // eras
                "ŋwíí a ntɔ́ntɔ\tŋwíí akǝ bɛ́ɛ\tŋwíí akǝ ráá\tŋwíí akǝ nin\tŋwíí akǝ táan\tŋwíí akǝ táafɔk\tŋwíí akǝ táabɛɛ\tŋwíí akǝ táaraa\tŋwíí akǝ táanin\tŋwíí akǝ ntɛk\tŋwíí akǝ ntɛk di bɔ́k\tŋwíí akǝ ntɛk di bɛ́ɛ", // months
                "ŋ1\tŋ2\tŋ3\tŋ4\tŋ5\tŋ6\tŋ7\tŋ8\tŋ9\tŋ10\tŋ11\tŋ12", // shortMonths
                "sɔ́n\tlǝn\tmaa\tmɛk\tjǝǝ\tjúm\tsam", // shortWeekdays
                "sɔ́ndǝ\tlǝndí\tmaadí\tmɛkrɛdí\tjǝǝdí\tjúmbá\tsamdí" // weekdays
        );

        DateFormatSymbols.register(
                "ksh\tksh-DE", // locales
                "Uhr vörmiddaachs\tUhr nommendaachs", // ampm
                "v. Chr.\tn. Chr.", // eras
                "Jannewa\tFäbrowa\tMääz\tAprell\tMäi\tJuuni\tJuuli\tOujoß\tSeptämber\tOktoober\tNovämber\tDezämber", // months
                "Jan\tFäb\tMäz\tApr\tMäi\tJun\tJul\tOuj\tSäp\tOkt\tNov\tDez", // shortMonths
                "Su.\tMo.\tDi.\tMe.\tDu.\tFr.\tSa.", // shortWeekdays
                "Sunndaach\tMoondaach\tDinnsdaach\tMetwoch\tDunnersdaach\tFriidaach\tSamsdaach" // weekdays
        );

        DateFormatSymbols.register(
                "kw\tkw-GB", // locales
                "a.m.\tp.m.", // ampm
                "RC\tAD", // eras
                "mis Genver\tmis Hwevrer\tmis Meurth\tmis Ebrel\tmis Me\tmis Metheven\tmis Gortheren\tmis Est\tmis Gwynngala\tmis Hedra\tmis Du\tmis Kevardhu", // months
                "Gen\tHwe\tMeu\tEbr\tMe\tMet\tGor\tEst\tGwn\tHed\tDu\tKev", // shortMonths
                "Sul\tLun\tMth\tMhr\tYow\tGwe\tSad", // shortWeekdays
                "dy Sul\tdy Lun\tdy Meurth\tdy Merher\tdy Yow\tdy Gwener\tdy Sadorn" // weekdays
        );

        DateFormatSymbols.register(
                "ky\tky-KG", // locales
                "таңкы\tтүштөн кийинки", // ampm
                "б.з.ч.\tб.з.", // eras
                "январь\tфевраль\tмарт\tапрель\tмай\tиюнь\tиюль\tавгуст\tсентябрь\tоктябрь\tноябрь\tдекабрь", // months
                "янв.\tфев.\tмар.\tапр.\tмай\tиюн.\tиюл.\tавг.\tсен.\tокт.\tноя.\tдек.", // shortMonths
                "жек.\tдүй.\tшейш.\tшарш.\tбейш.\tжума\tишм.", // shortWeekdays
                "жекшемби\tдүйшөмбү\tшейшемби\tшаршемби\tбейшемби\tжума\tишемби" // weekdays
        );

        DateFormatSymbols.register(
                "lag\tlag-TZ", // locales
                "TOO\tMUU", // ampm
                "KSA\tKA", // eras
                "Kʉfúngatɨ\tKʉnaanɨ\tKʉkeenda\tKwiikumi\tKwiinyambála\tKwiidwaata\tKʉmʉʉnchɨ\tKʉvɨɨrɨ\tKʉsaatʉ\tKwiinyi\tKʉsaano\tKʉsasatʉ", // months
                "Fúngatɨ\tNaanɨ\tKeenda\tIkúmi\tInyambala\tIdwaata\tMʉʉnchɨ\tVɨɨrɨ\tSaatʉ\tInyi\tSaano\tSasatʉ", // shortMonths
                "Píili\tTáatu\tÍne\tTáano\tAlh\tIjm\tMóosi", // shortWeekdays
                "Jumapíiri\tJumatátu\tJumaíne\tJumatáano\tAlamíisi\tIjumáa\tJumamóosi" // weekdays
        );

        DateFormatSymbols.register(
                "lb\tlb-LU", // locales
                "moies\tnomëttes", // ampm
                "v. Chr.\tn. Chr.", // eras
                "Januar\tFebruar\tMäerz\tAbrëll\tMee\tJuni\tJuli\tAugust\tSeptember\tOktober\tNovember\tDezember", // months
                "Jan.\tFeb.\tMäe.\tAbr.\tMee\tJuni\tJuli\tAug.\tSep.\tOkt.\tNov.\tDez.", // shortMonths
                "Son.\tMéi.\tDën.\tMët.\tDon.\tFre.\tSam.", // shortWeekdays
                "Sonndeg\tMéindeg\tDënschdeg\tMëttwoch\tDonneschdeg\tFreideg\tSamschdeg" // weekdays
        );

        DateFormatSymbols.register(
                "lg\tlg-UG", // locales
                "AM\tPM", // ampm
                "BC\tAD", // eras
                "Janwaliyo\tFebwaliyo\tMarisi\tApuli\tMaayi\tJuuni\tJulaayi\tAgusito\tSebuttemba\tOkitobba\tNovemba\tDesemba", // months
                "Jan\tFeb\tMar\tApu\tMaa\tJuu\tJul\tAgu\tSeb\tOki\tNov\tDes", // shortMonths
                "Sab\tBal\tLw2\tLw3\tLw4\tLw5\tLw6", // shortWeekdays
                "Sabbiiti\tBalaza\tLwakubiri\tLwakusatu\tLwakuna\tLwakutaano\tLwamukaaga" // weekdays
        );

        DateFormatSymbols.register(
                "lkt\tlkt-US", // locales
                "AM\tPM", // ampm
                "BCE\tCE", // eras
                "Wiótheȟika Wí\tThiyóȟeyuŋka Wí\tIštáwičhayazaŋ Wí\tPȟežítȟo Wí\tČhaŋwápetȟo Wí\tWípazukȟa-wašté Wí\tČhaŋpȟásapa Wí\tWasútȟuŋ Wí\tČhaŋwápeǧi Wí\tČhaŋwápe-kasná Wí\tWaníyetu Wí\tTȟahékapšuŋ Wí", // months
                "Wiótheȟika Wí\tThiyóȟeyuŋka Wí\tIštáwičhayazaŋ Wí\tPȟežítȟo Wí\tČhaŋwápetȟo Wí\tWípazukȟa-wašté Wí\tČhaŋpȟásapa Wí\tWasútȟuŋ Wí\tČhaŋwápeǧi Wí\tČhaŋwápe-kasná Wí\tWaníyetu Wí\tTȟahékapšuŋ Wí", // shortMonths
                "Aŋpétuwakȟaŋ\tAŋpétuwaŋži\tAŋpétunuŋpa\tAŋpétuyamni\tAŋpétutopa\tAŋpétuzaptaŋ\tOwáŋgyužažapi", // shortWeekdays
                "Aŋpétuwakȟaŋ\tAŋpétuwaŋži\tAŋpétunuŋpa\tAŋpétuyamni\tAŋpétutopa\tAŋpétuzaptaŋ\tOwáŋgyužažapi" // weekdays
        );

        DateFormatSymbols.register(
                "ln\tln-AO\tln-CD\tln-CF\tln-CG", // locales
                "ntɔ́ngɔ́\tmpókwa", // ampm
                "libóso ya\tnsima ya Y", // eras
                "sánzá ya yambo\tsánzá ya míbalé\tsánzá ya mísáto\tsánzá ya mínei\tsánzá ya mítáno\tsánzá ya motóbá\tsánzá ya nsambo\tsánzá ya mwambe\tsánzá ya libwa\tsánzá ya zómi\tsánzá ya zómi na mɔ̌kɔ́\tsánzá ya zómi na míbalé", // months
                "yan\tfbl\tmsi\tapl\tmai\tyun\tyul\tagt\tstb\tɔtb\tnvb\tdsb", // shortMonths
                "eye\tybo\tmbl\tmst\tmin\tmtn\tmps", // shortWeekdays
                "eyenga\tmokɔlɔ mwa yambo\tmokɔlɔ mwa míbalé\tmokɔlɔ mwa mísáto\tmokɔlɔ ya mínéi\tmokɔlɔ ya mítáno\tmpɔ́sɔ" // weekdays
        );

        DateFormatSymbols.register(
                "lo\tlo-LA", // locales
                "ກ່ອນທ່ຽງ\tຫຼັງທ່ຽງ", // ampm
                "ກ່ອນ ຄ.ສ.\tຄ.ສ.", // eras
                "ມັງກອນ\tກຸມພາ\tມີນາ\tເມສາ\tພຶດສະພາ\tມິຖຸນາ\tກໍລະກົດ\tສິງຫາ\tກັນຍາ\tຕຸລາ\tພະຈິກ\tທັນວາ", // months
                "ມ.ກ.\tກ.ພ.\tມ.ນ.\tມ.ສ.\tພ.ພ.\tມິ.ຖ.\tກ.ລ.\tສ.ຫ.\tກ.ຍ.\tຕ.ລ.\tພ.ຈ.\tທ.ວ.", // shortMonths
                "ວັນອາທິດ\tວັນຈັນ\tວັນອັງຄານ\tວັນພຸດ\tວັນພະຫັດ\tວັນສຸກ\tວັນເສົາ", // shortWeekdays
                "ວັນອາທິດ\tວັນຈັນ\tວັນອັງຄານ\tວັນພຸດ\tວັນພະຫັດ\tວັນສຸກ\tວັນເສົາ" // weekdays
        );

        DateFormatSymbols.register(
                "lrc\tlrc-IQ\tlrc-IR", // locales
                "AM\tPM", // ampm
                "BCE\tCE", // eras
                "جانڤیە\tفئڤریە\tمارس\tآڤریل\tمئی\tجوٙأن\tجوٙلا\tآگوست\tسئپتامر\tئوکتوڤر\tنوڤامر\tدئسامر", // months
                "جانڤیە\tفئڤریە\tمارس\tآڤریل\tمئی\tجوٙأن\tجوٙلا\tآگوست\tسئپتامر\tئوکتوڤر\tنوڤامر\tدئسامر", // shortMonths
                "Sun\tMon\tTue\tWed\tThu\tFri\tSat", // shortWeekdays
                "Sun\tMon\tTue\tWed\tThu\tFri\tSat" // weekdays
        );

        DateFormatSymbols.register(
                "lt\tlt-LT", // locales
                "priešpiet\tpopiet", // ampm
                "pr. Kr.\tpo Kr.", // eras
                "sausio\tvasario\tkovo\tbalandžio\tgegužės\tbirželio\tliepos\trugpjūčio\trugsėjo\tspalio\tlapkričio\tgruodžio", // months
                "saus.\tvas.\tkov.\tbal.\tgeg.\tbirž.\tliep.\trugp.\trugs.\tspal.\tlapkr.\tgruod.", // shortMonths
                "sk\tpr\tan\ttr\tkt\tpn\tšt", // shortWeekdays
                "sekmadienis\tpirmadienis\tantradienis\ttrečiadienis\tketvirtadienis\tpenktadienis\tšeštadienis" // weekdays
        );

        DateFormatSymbols.register(
                "lu\tlu-CD", // locales
                "Dinda\tDilolo", // ampm
                "kmp. Y.K.\tkny. Y. K.", // eras
                "Ciongo\tLùishi\tLusòlo\tMùuyà\tLumùngùlù\tLufuimi\tKabàlàshìpù\tLùshìkà\tLutongolo\tLungùdi\tKaswèkèsè\tCiswà", // months
                "Cio\tLui\tLus\tMuu\tLum\tLuf\tKab\tLush\tLut\tLun\tKas\tCis", // shortMonths
                "Lum\tNko\tNdy\tNdg\tNjw\tNgv\tLub", // shortWeekdays
                "Lumingu\tNkodya\tNdàayà\tNdangù\tNjòwa\tNgòvya\tLubingu" // weekdays
        );

        DateFormatSymbols.register(
                "luo\tluo-KE", // locales
                "OD\tOT", // ampm
                "BC\tAD", // eras
                "Dwe mar Achiel\tDwe mar Ariyo\tDwe mar Adek\tDwe mar Ang’wen\tDwe mar Abich\tDwe mar Auchiel\tDwe mar Abiriyo\tDwe mar Aboro\tDwe mar Ochiko\tDwe mar Apar\tDwe mar gi achiel\tDwe mar Apar gi ariyo", // months
                "DAC\tDAR\tDAD\tDAN\tDAH\tDAU\tDAO\tDAB\tDOC\tDAP\tDGI\tDAG", // shortMonths
                "JMP\tWUT\tTAR\tTAD\tTAN\tTAB\tNGS", // shortWeekdays
                "Jumapil\tWuok Tich\tTich Ariyo\tTich Adek\tTich Ang’wen\tTich Abich\tNgeso" // weekdays
        );

        DateFormatSymbols.register(
                "luy\tluy-KE", // locales
                "a.m.\tp.m.", // ampm
                "BC\tAD", // eras
                "Januari\tFebruari\tMachi\tAprili\tMei\tJuni\tJulai\tAgosti\tSeptemba\tOktoba\tNovemba\tDesemba", // months
                "Jan\tFeb\tMar\tApr\tMei\tJun\tJul\tAgo\tSep\tOkt\tNov\tDes", // shortMonths
                "J2\tJ3\tJ4\tJ5\tAl\tIj\tJ1", // shortWeekdays
                "Jumapiri\tJumatatu\tJumanne\tJumatano\tMurwa wa Kanne\tMurwa wa Katano\tJumamosi" // weekdays
        );

        DateFormatSymbols.register(
                "lv\tlv-LV", // locales
                "priekšpusdienā\tpēcpusdienā", // ampm
                "p.m.ē.\tm.ē.", // eras
                "janvāris\tfebruāris\tmarts\taprīlis\tmaijs\tjūnijs\tjūlijs\taugusts\tseptembris\toktobris\tnovembris\tdecembris", // months
                "janv.\tfebr.\tmarts\tapr.\tmaijs\tjūn.\tjūl.\taug.\tsept.\tokt.\tnov.\tdec.", // shortMonths
                "Sv\tPr\tOt\tTr\tCe\tPk\tSe", // shortWeekdays
                "svētdiena\tpirmdiena\totrdiena\ttrešdiena\tceturtdiena\tpiektdiena\tsestdiena" // weekdays
        );

        DateFormatSymbols.register(
                "mas\tmas-KE\tmas-TZ", // locales
                "Ɛnkakɛnyá\tƐndámâ", // ampm
                "MY\tEY", // eras
                "Oladalʉ́\tArát\tƆɛnɨ́ɔɨŋɔk\tOlodoyíóríê inkókúâ\tOloilépūnyīē inkókúâ\tKújúɔrɔk\tMórusásin\tƆlɔ́ɨ́bɔ́rárɛ\tKúshîn\tOlgísan\tPʉshʉ́ka\tNtʉ́ŋʉ́s", // months
                "Dal\tArá\tƆɛn\tDoy\tLép\tRok\tSás\tBɔ́r\tKús\tGís\tShʉ́\tNtʉ́", // shortMonths
                "Jpi\tJtt\tJnn\tJtn\tAlh\tIju\tJmo", // shortWeekdays
                "Jumapílí\tJumatátu\tJumane\tJumatánɔ\tAlaámisi\tJumáa\tJumamósi" // weekdays
        );

        DateFormatSymbols.register(
                "mer\tmer-KE", // locales
                "RŨ\tŨG", // ampm
                "MK\tNK", // eras
                "Januarĩ\tFeburuarĩ\tMachi\tĨpurũ\tMĩĩ\tNjuni\tNjuraĩ\tAgasti\tSeptemba\tOktũba\tNovemba\tDicemba", // months
                "JAN\tFEB\tMAC\tĨPU\tMĨĨ\tNJU\tNJR\tAGA\tSPT\tOKT\tNOV\tDEC", // shortMonths
                "KIU\tMRA\tWAI\tWET\tWEN\tWTN\tJUM", // shortWeekdays
                "Kiumia\tMuramuko\tWairi\tWethatu\tWena\tWetano\tJumamosi" // weekdays
        );

        DateFormatSymbols.register(
                "mfe\tmfe-MU", // locales
                "AM\tPM", // ampm
                "av. Z-K\tap. Z-K", // eras
                "zanvie\tfevriye\tmars\tavril\tme\tzin\tzilye\tout\tseptam\toktob\tnovam\tdesam", // months
                "zan\tfev\tmar\tavr\tme\tzin\tzil\tout\tsep\tokt\tnov\tdes", // shortMonths
                "dim\tlin\tmar\tmer\tze\tvan\tsam", // shortWeekdays
                "dimans\tlindi\tmardi\tmerkredi\tzedi\tvandredi\tsamdi" // weekdays
        );

        DateFormatSymbols.register(
                "mg\tmg-MG", // locales
                "AM\tPM", // ampm
                "BC\tAD", // eras
                "Janoary\tFebroary\tMartsa\tAprily\tMey\tJona\tJolay\tAogositra\tSeptambra\tOktobra\tNovambra\tDesambra", // months
                "Jan\tFeb\tMar\tApr\tMey\tJon\tJol\tAog\tSep\tOkt\tNov\tDes", // shortMonths
                "Alah\tAlats\tTal\tAlar\tAlak\tZom\tAsab", // shortWeekdays
                "Alahady\tAlatsinainy\tTalata\tAlarobia\tAlakamisy\tZoma\tAsabotsy" // weekdays
        );

        DateFormatSymbols.register(
                "mgh\tmgh-MZ", // locales
                "wichishu\tmchochil’l", // ampm
                "HY\tYY", // eras
                "Mweri wo kwanza\tMweri wo unayeli\tMweri wo uneraru\tMweri wo unecheshe\tMweri wo unethanu\tMweri wo thanu na mocha\tMweri wo saba\tMweri wo nane\tMweri wo tisa\tMweri wo kumi\tMweri wo kumi na moja\tMweri wo kumi na yel’li", // months
                "Kwa\tUna\tRar\tChe\tTha\tMoc\tSab\tNan\tTis\tKum\tMoj\tYel", // shortMonths
                "Sab\tJtt\tJnn\tJtn\tAra\tIju\tJmo", // shortWeekdays
                "Sabato\tJumatatu\tJumanne\tJumatano\tArahamisi\tIjumaa\tJumamosi" // weekdays
        );

        DateFormatSymbols.register(
                "mgo\tmgo-CM", // locales
                "AM\tPM", // ampm
                "BCE\tCE", // eras
                "iməg mbegtug\timeg àbùbì\timeg mbəŋchubi\timəg ngwə̀t\timəg fog\timəg ichiibɔd\timəg àdùmbə̀ŋ\timəg ichika\timəg kud\timəg tèsiʼe\timəg zò\timəg krizmed", // months
                "mbegtug\timeg àbùbì\timeg mbəŋchubi\timəg ngwə̀t\timəg fog\timəg ichiibɔd\timəg àdùmbə̀ŋ\timəg ichika\timəg kud\timəg tèsiʼe\timəg zò\timəg krizmed", // shortMonths
                "Aneg 1\tAneg 2\tAneg 3\tAneg 4\tAneg 5\tAneg 6\tAneg 7", // shortWeekdays
                "Aneg 1\tAneg 2\tAneg 3\tAneg 4\tAneg 5\tAneg 6\tAneg 7" // weekdays
        );

        DateFormatSymbols.register(
                "mk\tmk-MK", // locales
                "претпладне\tпопладне", // ampm
                "пр.н.е.\tн.е.", // eras
                "јануари\tфевруари\tмарт\tаприл\tмај\tјуни\tјули\tавгуст\tсептември\tоктомври\tноември\tдекември", // months
                "јан.\tфев.\tмар.\tапр.\tмај\tјун.\tјул.\tавг.\tсепт.\tокт.\tноем.\tдек.", // shortMonths
                "нед.\tпон.\tвт.\tсре.\tчет.\tпет.\tсаб.", // shortWeekdays
                "недела\tпонеделник\tвторник\tсреда\tчетврток\tпеток\tсабота" // weekdays
        );

        DateFormatSymbols.register(
                "ml\tml-IN", // locales
                "AM\tPM", // ampm
                "ക്രി.മു.\tഎഡി", // eras
                "ജനുവരി\tഫെബ്രുവരി\tമാർച്ച്\tഏപ്രിൽ\tമേയ്\tജൂൺ\tജൂലൈ\tഓഗസ്റ്റ്\tസെപ്റ്റംബർ\tഒക്‌ടോബർ\tനവംബർ\tഡിസംബർ", // months
                "ജനു\tഫെബ്രു\tമാർ\tഏപ്രി\tമേയ്\tജൂൺ\tജൂലൈ\tഓഗ\tസെപ്റ്റം\tഒക്ടോ\tനവം\tഡിസം", // shortMonths
                "ഞായർ\tതിങ്കൾ\tചൊവ്വ\tബുധൻ\tവ്യാഴം\tവെള്ളി\tശനി", // shortWeekdays
                "ഞായറാഴ്‌ച\tതിങ്കളാഴ്‌ച\tചൊവ്വാഴ്ച\tബുധനാഴ്‌ച\tവ്യാഴാഴ്‌ച\tവെള്ളിയാഴ്‌ച\tശനിയാഴ്‌ച" // weekdays
        );

        DateFormatSymbols.register(
                "mn\tmn-MN", // locales
                "ҮӨ\tҮХ", // ampm
                "м.э.ө\tм.э.", // eras
                "Нэгдүгээр сар\tХоёрдугаар сар\tГуравдугаар сар\tДөрөвдүгээр сар\tТавдугаар сар\tЗургадугаар сар\tДолдугаар сар\tНаймдугаар сар\tЕсдүгээр сар\tАравдугаар сар\tАрван нэгдүгээр сар\tАрван хоёрдугаар сар", // months
                "1-р сар\t2-р сар\t3-р сар\t4-р сар\t5-р сар\t6-р сар\t7-р сар\t8-р сар\t9-р сар\t10-р сар\t11-р сар\t12-р сар", // shortMonths
                "Ня\tДа\tМя\tЛх\tПү\tБа\tБя", // shortWeekdays
                "ням\tдаваа\tмягмар\tлхагва\tпүрэв\tбаасан\tбямба" // weekdays
        );

        DateFormatSymbols.register(
                "mr\tmr-IN", // locales
                "म.पू.\tम.उ.", // ampm
                "इ. स. पू.\tइ. स.", // eras
                "जानेवारी\tफेब्रुवारी\tमार्च\tएप्रिल\tमे\tजून\tजुलै\tऑगस्ट\tसप्टेंबर\tऑक्टोबर\tनोव्हेंबर\tडिसेंबर", // months
                "जाने\tफेब्रु\tमार्च\tएप्रि\tमे\tजून\tजुलै\tऑग\tसप्टें\tऑक्टो\tनोव्हें\tडिसें", // shortMonths
                "रवि\tसोम\tमंगळ\tबुध\tगुरु\tशुक्र\tशनि", // shortWeekdays
                "रविवार\tसोमवार\tमंगळवार\tबुधवार\tगुरुवार\tशुक्रवार\tशनिवार" // weekdays
        );

        DateFormatSymbols.register(
                "ms\tms-BN\tms-MY\tms-SG", // locales
                "PG\tPTG", // ampm
                "S.M.\tTM", // eras
                "Januari\tFebruari\tMac\tApril\tMei\tJun\tJulai\tOgos\tSeptember\tOktober\tNovember\tDisember", // months
                "Jan\tFeb\tMac\tApr\tMei\tJun\tJul\tOgo\tSep\tOkt\tNov\tDis", // shortMonths
                "Ahd\tIsn\tSel\tRab\tKha\tJum\tSab", // shortWeekdays
                "Ahad\tIsnin\tSelasa\tRabu\tKhamis\tJumaat\tSabtu" // weekdays
        );

        DateFormatSymbols.register(
                "mt\tmt-MT", // locales
                "AM\tPM", // ampm
                "QK\tWK", // eras
                "Jannar\tFrar\tMarzu\tApril\tMejju\tĠunju\tLulju\tAwwissu\tSettembru\tOttubru\tNovembru\tDiċembru", // months
                "Jan\tFra\tMar\tApr\tMej\tĠun\tLul\tAww\tSet\tOtt\tNov\tDiċ", // shortMonths
                "Ħad\tTne\tTli\tErb\tĦam\tĠim\tSib", // shortWeekdays
                "Il-Ħadd\tIt-Tnejn\tIt-Tlieta\tL-Erbgħa\tIl-Ħamis\tIl-Ġimgħa\tIs-Sibt" // weekdays
        );

        DateFormatSymbols.register(
                "mua\tmua-CM", // locales
                "comme\tlilli", // ampm
                "KK\tPK", // eras
                "Fĩi Loo\tCokcwaklaŋne\tCokcwaklii\tFĩi Marfoo\tMadǝǝuutǝbijaŋ\tMamǝŋgwãafahbii\tMamǝŋgwãalii\tMadǝmbii\tFĩi Dǝɓlii\tFĩi Mundaŋ\tFĩi Gwahlle\tFĩi Yuru", // months
                "FLO\tCLA\tCKI\tFMF\tMAD\tMBI\tMLI\tMAM\tFDE\tFMU\tFGW\tFYU", // shortMonths
                "Cya\tCla\tCzi\tCko\tCka\tCga\tCze", // shortWeekdays
                "Com’yakke\tComlaaɗii\tComzyiiɗii\tComkolle\tComkaldǝɓlii\tComgaisuu\tComzyeɓsuu" // weekdays
        );

        DateFormatSymbols.register(
                "my\tmy-MM", // locales
                "နံနက်\tညနေ", // ampm
                "ဘီစီ\tအေဒီ", // eras
                "ဇန်နဝါရီ\tဖေဖော်ဝါရီ\tမတ်\tဧပြီ\tမေ\tဇွန်\tဇူလိုင်\tဩဂုတ်\tစက်တင်ဘာ\tအောက်တိုဘာ\tနိုဝင်ဘာ\tဒီဇင်ဘာ", // months
                "ဇန်\tဖေ\tမတ်\tဧပြီ\tမေ\tဇွန်\tဇူ\tဩ\tစက်\tအောက်\tနို\tဒီ", // shortMonths
                "တနင်္ဂနွေ\tတနင်္လာ\tအင်္ဂါ\tဗုဒ္ဓဟူး\tကြာသပတေး\tသောကြာ\tစနေ", // shortWeekdays
                "တနင်္ဂနွေ\tတနင်္လာ\tအင်္ဂါ\tဗုဒ္ဓဟူး\tကြာသပတေး\tသောကြာ\tစနေ" // weekdays
        );

        DateFormatSymbols.register(
                "mzn\tmzn-IR", // locales
                "AM\tPM", // ampm
                "پ.م\tم.", // eras
                "ژانویه\tفوریه\tمارس\tآوریل\tمه\tژوئن\tژوئیه\tاوت\tسپتامبر\tاکتبر\tنوامبر\tدسامبر", // months
                "ژانویه\tفوریه\tمارس\tآوریل\tمه\tژوئن\tژوئیه\tاوت\tسپتامبر\tاکتبر\tنوامبر\tدسامبر", // shortMonths
                "Sun\tMon\tTue\tWed\tThu\tFri\tSat", // shortWeekdays
                "Sun\tMon\tTue\tWed\tThu\tFri\tSat" // weekdays
        );

        DateFormatSymbols.register(
                "naq\tnaq-NA", // locales
                "ǁgoagas\tǃuias", // ampm
                "BC\tAD", // eras
                "ǃKhanni\tǃKhanǀgôab\tǀKhuuǁkhâb\tǃHôaǂkhaib\tǃKhaitsâb\tGamaǀaeb\tǂKhoesaob\tAoǁkhuumûǁkhâb\tTaraǀkhuumûǁkhâb\tǂNûǁnâiseb\tǀHooǂgaeb\tHôasoreǁkhâb", // months
                "Jan\tFeb\tMar\tApr\tMay\tJun\tJul\tAug\tSep\tOct\tNov\tDec", // shortMonths
                "Son\tMa\tDe\tWu\tDo\tFr\tSat", // shortWeekdays
                "Sontaxtsees\tMantaxtsees\tDenstaxtsees\tWunstaxtsees\tDondertaxtsees\tFraitaxtsees\tSatertaxtsees" // weekdays
        );

        DateFormatSymbols.register(
                "nb\tnb-NO\tnb-SJ\tno\tno-NO", // locales
                "a.m.\tp.m.", // ampm
                "f.Kr.\te.Kr.", // eras
                "januar\tfebruar\tmars\tapril\tmai\tjuni\tjuli\taugust\tseptember\toktober\tnovember\tdesember", // months
                "jan.\tfeb.\tmar.\tapr.\tmai\tjun.\tjul.\taug.\tsep.\tokt.\tnov.\tdes.", // shortMonths
                "søn.\tman.\ttir.\tons.\ttor.\tfre.\tlør.", // shortWeekdays
                "søndag\tmandag\ttirsdag\tonsdag\ttorsdag\tfredag\tlørdag" // weekdays
        );

        DateFormatSymbols.register(
                "nd\tnd-ZW", // locales
                "AM\tPM", // ampm
                "BC\tAD", // eras
                "Zibandlela\tNhlolanja\tMbimbitho\tMabasa\tNkwenkwezi\tNhlangula\tNtulikazi\tNcwabakazi\tMpandula\tMfumfu\tLwezi\tMpalakazi", // months
                "Zib\tNhlo\tMbi\tMab\tNkw\tNhla\tNtu\tNcw\tMpan\tMfu\tLwe\tMpal", // shortMonths
                "Son\tMvu\tSib\tSit\tSin\tSih\tMgq", // shortWeekdays
                "Sonto\tMvulo\tSibili\tSithathu\tSine\tSihlanu\tMgqibelo" // weekdays
        );

        DateFormatSymbols.register(
                "ne\tne-IN\tne-NP", // locales
                "पूर्वाह्न\tअपराह्न", // ampm
                "ईसा पूर्व\tसन्", // eras
                "जनवरी\tफेब्रुअरी\tमार्च\tअप्रिल\tमई\tजुन\tजुलाई\tअगस्ट\tसेप्टेम्बर\tअक्टोबर\tनोभेम्बर\tडिसेम्बर", // months
                "जनवरी\tफेब्रुअरी\tमार्च\tअप्रिल\tमे\tजुन\tजुलाई\tअगस्ट\tसेप्टेम्बर\tअक्टोबर\tनोभेम्बर\tडिसेम्बर", // shortMonths
                "आइत\tसोम\tमङ्गल\tबुध\tबिही\tशुक्र\tशनि", // shortWeekdays
                "आइतबार\tसोमबार\tमङ्गलबार\tबुधबार\tबिहिबार\tशुक्रबार\tशनिबार" // weekdays
        );

        DateFormatSymbols.register(
                "nl\tnl-AW\tnl-BE\tnl-BQ\tnl-CW\tnl-NL\tnl-SR\tnl-SX", // locales
                "a.m.\tp.m.", // ampm
                "v.Chr.\tn.Chr.", // eras
                "januari\tfebruari\tmaart\tapril\tmei\tjuni\tjuli\taugustus\tseptember\toktober\tnovember\tdecember", // months
                "jan.\tfeb.\tmrt.\tapr.\tmei\tjun.\tjul.\taug.\tsep.\tokt.\tnov.\tdec.", // shortMonths
                "zo\tma\tdi\two\tdo\tvr\tza", // shortWeekdays
                "zondag\tmaandag\tdinsdag\twoensdag\tdonderdag\tvrijdag\tzaterdag" // weekdays
        );

        DateFormatSymbols.register(
                "nmg\tnmg-CM", // locales
                "maná\tkugú", // ampm
                "BL\tPB", // eras
                "ngwɛn matáhra\tngwɛn ńmba\tngwɛn ńlal\tngwɛn ńna\tngwɛn ńtan\tngwɛn ńtuó\tngwɛn hɛmbuɛrí\tngwɛn lɔmbi\tngwɛn rɛbvuâ\tngwɛn wum\tngwɛn wum navǔr\tkrísimin", // months
                "ng1\tng2\tng3\tng4\tng5\tng6\tng7\tng8\tng9\tng10\tng11\tkris", // shortMonths
                "sɔ́n\tmɔ́n\tsmb\tsml\tsmn\tmbs\tsas", // shortWeekdays
                "sɔ́ndɔ\tmɔ́ndɔ\tsɔ́ndɔ mafú mába\tsɔ́ndɔ mafú málal\tsɔ́ndɔ mafú mána\tmabágá má sukul\tsásadi" // weekdays
        );

        DateFormatSymbols.register(
                "nn\tnn-NO", // locales
                "formiddag\tettermiddag", // ampm
                "f.Kr.\te.Kr.", // eras
                "januar\tfebruar\tmars\tapril\tmai\tjuni\tjuli\taugust\tseptember\toktober\tnovember\tdesember", // months
                "jan.\tfeb.\tmars\tapr.\tmai\tjuni\tjuli\taug.\tsep.\tokt.\tnov.\tdes.", // shortMonths
                "sø.\tmå.\tty.\ton.\tto.\tfr.\tla.", // shortWeekdays
                "søndag\tmåndag\ttysdag\tonsdag\ttorsdag\tfredag\tlaurdag" // weekdays
        );

        DateFormatSymbols.register(
                "nnh\tnnh-CM", // locales
                "mbaʼámbaʼ\tncwònzém", // ampm
                "m.z.Y.\tm.g.n.Y.", // eras
                "saŋ tsetsɛ̀ɛ lùm\tsaŋ kàg ngwóŋ\tsaŋ lepyè shúm\tsaŋ cÿó\tsaŋ tsɛ̀ɛ cÿó\tsaŋ njÿoláʼ\tsaŋ tyɛ̀b tyɛ̀b mbʉ̀ŋ\tsaŋ mbʉ̀ŋ\tsaŋ ngwɔ̀ʼ mbÿɛ\tsaŋ tàŋa tsetsáʼ\tsaŋ mejwoŋó\tsaŋ lùm", // months
                "saŋ tsetsɛ̀ɛ lùm\tsaŋ kàg ngwóŋ\tsaŋ lepyè shúm\tsaŋ cÿó\tsaŋ tsɛ̀ɛ cÿó\tsaŋ njÿoláʼ\tsaŋ tyɛ̀b tyɛ̀b mbʉ̀ŋ\tsaŋ mbʉ̀ŋ\tsaŋ ngwɔ̀ʼ mbÿɛ\tsaŋ tàŋa tsetsáʼ\tsaŋ mejwoŋó\tsaŋ lùm", // shortMonths
                "lyɛʼɛ́ sẅíŋtè\tmvfò lyɛ̌ʼ\tmbɔ́ɔntè mvfò lyɛ̌ʼ\ttsètsɛ̀ɛ lyɛ̌ʼ\tmbɔ́ɔntè tsetsɛ̀ɛ lyɛ̌ʼ\tmvfò màga lyɛ̌ʼ\tmàga lyɛ̌ʼ", // shortWeekdays
                "lyɛʼɛ́ sẅíŋtè\tmvfò lyɛ̌ʼ\tmbɔ́ɔntè mvfò lyɛ̌ʼ\ttsètsɛ̀ɛ lyɛ̌ʼ\tmbɔ́ɔntè tsetsɛ̀ɛ lyɛ̌ʼ\tmvfò màga lyɛ̌ʼ\tmàga lyɛ̌ʼ" // weekdays
        );

        DateFormatSymbols.register(
                "nus\tnus-SS", // locales
                "RW\tTŊ", // ampm
                "AY\tƐY", // eras
                "Tiop thar pɛt\tPɛt\tDuɔ̱ɔ̱ŋ\tGuak\tDuät\tKornyoot\tPay yie̱tni\tTho̱o̱r\tTɛɛr\tLaath\tKur\tTio̱p in di̱i̱t", // months
                "Tiop\tPɛt\tDuɔ̱ɔ̱\tGuak\tDuä\tKor\tPay\tThoo\tTɛɛ\tLaa\tKur\tTid", // shortMonths
                "Cäŋ\tJiec\tRɛw\tDiɔ̱k\tŊuaan\tDhieec\tBäkɛl", // shortWeekdays
                "Cäŋ kuɔth\tJiec la̱t\tRɛw lätni\tDiɔ̱k lätni\tŊuaan lätni\tDhieec lätni\tBäkɛl lätni" // weekdays
        );

        DateFormatSymbols.register(
                "om\tom-ET\tom-KE", // locales
                "WD\tWB", // ampm
                "KD\tKB", // eras
                "Amajjii\tGuraandhala\tBitooteessa\tElba\tCaamsa\tWaxabajjii\tAdooleessa\tHagayya\tFuulbana\tOnkololeessa\tSadaasa\tMuddee", // months
                "Ama\tGur\tBit\tElb\tCam\tWax\tAdo\tHag\tFul\tOnk\tSad\tMud", // shortMonths
                "Dil\tWix\tQib\tRob\tKam\tJim\tSan", // shortWeekdays
                "Dilbata\tWiixata\tQibxata\tRoobii\tKamiisa\tJimaata\tSanbata" // weekdays
        );

        DateFormatSymbols.register(
                "or\tor-IN", // locales
                "am\tpm", // ampm
                "BCE\tCE", // eras
                "ଜାନୁଆରୀ\tଫେବୃଆରୀ\tମାର୍ଚ୍ଚ\tଅପ୍ରେଲ\tମଇ\tଜୁନ\tଜୁଲାଇ\tଅଗଷ୍ଟ\tସେପ୍ଟେମ୍ବର\tଅକ୍ଟୋବର\tନଭେମ୍ବର\tଡିସେମ୍ବର", // months
                "ଜାନୁଆରୀ\tଫେବୃଆରୀ\tମାର୍ଚ୍ଚ\tଅପ୍ରେଲ\tମଇ\tଜୁନ\tଜୁଲାଇ\tଅଗଷ୍ଟ\tସେପ୍ଟେମ୍ବର\tଅକ୍ଟୋବର\tନଭେମ୍ବର\tଡିସେମ୍ବର", // shortMonths
                "ରବି\tସୋମ\tମଙ୍ଗଳ\tବୁଧ\tଗୁରୁ\tଶୁକ୍ର\tଶନି", // shortWeekdays
                "ରବିବାର\tସୋମବାର\tମଙ୍ଗଳବାର\tବୁଧବାର\tଗୁରୁବାର\tଶୁକ୍ରବାର\tଶନିବାର" // weekdays
        );

        DateFormatSymbols.register(
                "os\tos-GE\tos-RU", // locales
                "ӕмбисбоны размӕ\tӕмбисбоны фӕстӕ", // ampm
                "н.д.а.\tн.д.", // eras
                "январы\tфевралы\tмартъийы\tапрелы\tмайы\tиюны\tиюлы\tавгусты\tсентябры\tоктябры\tноябры\tдекабры", // months
                "янв.\tфев.\tмар.\tапр.\tмайы\tиюны\tиюлы\tавг.\tсен.\tокт.\tноя.\tдек.", // shortMonths
                "хцб\tкрс\tдцг\tӕрт\tцпр\tмрб\tсбт", // shortWeekdays
                "хуыцаубон\tкъуырисӕр\tдыццӕг\tӕртыццӕг\tцыппӕрӕм\tмайрӕмбон\tсабат" // weekdays
        );

        DateFormatSymbols.register(
                "pa\tpa-Guru\tpa-Guru-IN\tpa-IN\tpa-PK", // locales
                "ਪੂ.ਦੁ.\tਬਾ.ਦੁ.", // ampm
                "ਈ. ਪੂ.\tਸੰਨ", // eras
                "ਜਨਵਰੀ\tਫ਼ਰਵਰੀ\tਮਾਰਚ\tਅਪ੍ਰੈਲ\tਮਈ\tਜੂਨ\tਜੁਲਾਈ\tਅਗਸਤ\tਸਤੰਬਰ\tਅਕਤੂਬਰ\tਨਵੰਬਰ\tਦਸੰਬਰ", // months
                "ਜਨ\tਫ਼ਰ\tਮਾਰਚ\tਅਪ੍ਰੈ\tਮਈ\tਜੂਨ\tਜੁਲਾ\tਅਗ\tਸਤੰ\tਅਕਤੂ\tਨਵੰ\tਦਸੰ", // shortMonths
                "ਐਤ\tਸੋਮ\tਮੰਗਲ\tਬੁੱਧ\tਵੀਰ\tਸ਼ੁੱਕਰ\tਸ਼ਨਿੱਚਰ", // shortWeekdays
                "ਐਤਵਾਰ\tਸੋਮਵਾਰ\tਮੰਗਲਵਾਰ\tਬੁੱਧਵਾਰ\tਵੀਰਵਾਰ\tਸ਼ੁੱਕਰਵਾਰ\tਸ਼ਨਿੱਚਰਵਾਰ" // weekdays
        );

        DateFormatSymbols.register(
                "pa-Arab\tpa-Arab-PK", // locales
                "AM\tPM", // ampm
                "ايساپورو\tسں", // eras
                "جنوری\tفروری\tمارچ\tاپریل\tمئ\tجون\tجولائی\tاگست\tستمبر\tاکتوبر\tنومبر\tدسمبر", // months
                "جنوری\tفروری\tمارچ\tاپریل\tمئ\tجون\tجولائی\tاگست\tستمبر\tاکتوبر\tنومبر\tدسمبر", // shortMonths
                "اتوار\tپیر\tمنگل\tبُدھ\tجمعرات\tجمعہ\tہفتہ", // shortWeekdays
                "اتوار\tپیر\tمنگل\tبُدھ\tجمعرات\tجمعہ\tہفتہ" // weekdays
        );

        DateFormatSymbols.register(
                "pl\tpl-PL", // locales
                "AM\tPM", // ampm
                "p.n.e.\tn.e.", // eras
                "stycznia\tlutego\tmarca\tkwietnia\tmaja\tczerwca\tlipca\tsierpnia\twrześnia\tpaździernika\tlistopada\tgrudnia", // months
                "sty\tlut\tmar\tkwi\tmaj\tcze\tlip\tsie\twrz\tpaź\tlis\tgru", // shortMonths
                "niedz.\tpon.\twt.\tśr.\tczw.\tpt.\tsob.", // shortWeekdays
                "niedziela\tponiedziałek\twtorek\tśroda\tczwartek\tpiątek\tsobota" // weekdays
        );

        DateFormatSymbols.register(
                "ps\tps-AF", // locales
                "غ.م.\tغ.و.", // ampm
                "ق.م.\tم.", // eras
                "جنوري\tفبروري\tمارچ\tاپریل\tمی\tجون\tجولای\tاګست\tسپتمبر\tاکتوبر\tنومبر\tدسمبر", // months
                "جنوري\tفبروري\tمارچ\tاپریل\tمی\tجون\tجولای\tاګست\tسپتمبر\tاکتوبر\tنومبر\tدسمبر", // shortMonths
                "یکشنبه\tدوشنبه\tسه‌شنبه\tچهارشنبه\tپنجشنبه\tجمعه\tشنبه", // shortWeekdays
                "یکشنبه\tدوشنبه\tسه‌شنبه\tچهارشنبه\tپنجشنبه\tجمعه\tشنبه" // weekdays
        );

        DateFormatSymbols.register(
                "pt\tpt-BR", // locales
                "AM\tPM", // ampm
                "a.C.\td.C.", // eras
                "janeiro\tfevereiro\tmarço\tabril\tmaio\tjunho\tjulho\tagosto\tsetembro\toutubro\tnovembro\tdezembro", // months
                "jan\tfev\tmar\tabr\tmai\tjun\tjul\tago\tset\tout\tnov\tdez", // shortMonths
                "dom\tseg\tter\tqua\tqui\tsex\tsáb", // shortWeekdays
                "domingo\tsegunda-feira\tterça-feira\tquarta-feira\tquinta-feira\tsexta-feira\tsábado" // weekdays
        );

        DateFormatSymbols.register(
                "pt-AO\tpt-CH\tpt-CV\tpt-GQ\tpt-GW\tpt-LU\tpt-MO\tpt-MZ\tpt-PT\tpt-ST\tpt-TL", // locales
                "da manhã\tda tarde", // ampm
                "a.C.\td.C.", // eras
                "janeiro\tfevereiro\tmarço\tabril\tmaio\tjunho\tjulho\tagosto\tsetembro\toutubro\tnovembro\tdezembro", // months
                "jan\tfev\tmar\tabr\tmai\tjun\tjul\tago\tset\tout\tnov\tdez", // shortMonths
                "domingo\tsegunda\tterça\tquarta\tquinta\tsexta\tsábado", // shortWeekdays
                "domingo\tsegunda-feira\tterça-feira\tquarta-feira\tquinta-feira\tsexta-feira\tsábado" // weekdays
        );

        DateFormatSymbols.register(
                "qu\tqu-BO\tqu-EC\tqu-PE", // locales
                "a.m.\tp.m.", // ampm
                "BCE\td.C.", // eras
                "Qulla puquy\tHatun puquy\tPauqar waray\tAyriwa\tAymuray\tInti raymi\tAnta Sitwa\tQhapaq Sitwa\tUma raymi\tKantaray\tAyamarqʼa\tKapaq Raymi", // months
                "Qul\tHat\tPau\tAyr\tAym\tInt\tAnt\tQha\tUma\tKan\tAya\tKap", // shortMonths
                "Dom\tLun\tMar\tMié\tJue\tVie\tSab", // shortWeekdays
                "Domingo\tLunes\tMartes\tMiércoles\tJueves\tViernes\tSábado" // weekdays
        );

        DateFormatSymbols.register(
                "rm\trm-CH", // locales
                "am\tsm", // ampm
                "av. Cr.\ts. Cr.", // eras
                "schaner\tfavrer\tmars\tavrigl\tmatg\tzercladur\tfanadur\tavust\tsettember\toctober\tnovember\tdecember", // months
                "schan.\tfavr.\tmars\tavr.\tmatg\tzercl.\tfan.\tavust\tsett.\toct.\tnov.\tdec.", // shortMonths
                "du\tgli\tma\tme\tgie\tve\tso", // shortWeekdays
                "dumengia\tglindesdi\tmardi\tmesemna\tgievgia\tvenderdi\tsonda" // weekdays
        );

        DateFormatSymbols.register(
                "rn\trn-BI", // locales
                "Z.MU.\tZ.MW.", // ampm
                "Mb.Y.\tNy.Y", // eras
                "Nzero\tRuhuhuma\tNtwarante\tNdamukiza\tRusama\tRuheshi\tMukakaro\tNyandagaro\tNyakanga\tGitugutu\tMunyonyo\tKigarama", // months
                "Mut.\tGas.\tWer.\tMat.\tGic.\tKam.\tNya.\tKan.\tNze.\tUkw.\tUgu.\tUku.", // shortMonths
                "cu.\tmbe.\tkab.\tgtu.\tkan.\tgnu.\tgnd.", // shortWeekdays
                "Ku w’indwi\tKu wa mbere\tKu wa kabiri\tKu wa gatatu\tKu wa kane\tKu wa gatanu\tKu wa gatandatu" // weekdays
        );

        DateFormatSymbols.register(
                "ro\tro-RO", // locales
                "a.m.\tp.m.", // ampm
                "î.Hr.\td.Hr.", // eras
                "ianuarie\tfebruarie\tmartie\taprilie\tmai\tiunie\tiulie\taugust\tseptembrie\toctombrie\tnoiembrie\tdecembrie", // months
                "ian.\tfeb.\tmar.\tapr.\tmai\tiun.\tiul.\taug.\tsept.\toct.\tnov.\tdec.", // shortMonths
                "dum.\tlun.\tmar.\tmie.\tjoi\tvin.\tsâm.", // shortWeekdays
                "duminică\tluni\tmarți\tmiercuri\tjoi\tvineri\tsâmbătă" // weekdays
        );

        DateFormatSymbols.register(
                "ro-MD", // locales
                "a.m.\tp.m.", // ampm
                "î.Hr.\td.Hr.", // eras
                "ianuarie\tfebruarie\tmartie\taprilie\tmai\tiunie\tiulie\taugust\tseptembrie\toctombrie\tnoiembrie\tdecembrie", // months
                "ian.\tfeb.\tmar.\tapr.\tmai\tiun.\tiul.\taug.\tsept.\toct.\tnov.\tdec.", // shortMonths
                "Dum\tLun\tMar\tMie\tJoi\tVin\tSâm", // shortWeekdays
                "duminică\tluni\tmarți\tmiercuri\tjoi\tvineri\tsâmbătă" // weekdays
        );

        DateFormatSymbols.register(
                "rof\trof-TZ", // locales
                "kang’ama\tkingoto", // ampm
                "KM\tBM", // eras
                "Mweri wa kwanza\tMweri wa kaili\tMweri wa katatu\tMweri wa kaana\tMweri wa tanu\tMweri wa sita\tMweri wa saba\tMweri wa nane\tMweri wa tisa\tMweri wa ikumi\tMweri wa ikumi na moja\tMweri wa ikumi na mbili", // months
                "M1\tM2\tM3\tM4\tM5\tM6\tM7\tM8\tM9\tM10\tM11\tM12", // shortMonths
                "Ijp\tIjt\tIjn\tIjtn\tAlh\tIju\tIjm", // shortWeekdays
                "Ijumapili\tIjumatatu\tIjumanne\tIjumatano\tAlhamisi\tIjumaa\tIjumamosi" // weekdays
        );

        DateFormatSymbols.register(
                "ru\tru-BY\tru-KG\tru-KZ\tru-MD\tru-RU\tru-UA", // locales
                "ДП\tПП", // ampm
                "до н. э.\tн. э.", // eras
                "января\tфевраля\tмарта\tапреля\tмая\tиюня\tиюля\tавгуста\tсентября\tоктября\tноября\tдекабря", // months
                "янв.\tфевр.\tмар.\tапр.\tмая\tиюн.\tиюл.\tавг.\tсент.\tокт.\tнояб.\tдек.", // shortMonths
                "вс\tпн\tвт\tср\tчт\tпт\tсб", // shortWeekdays
                "воскресенье\tпонедельник\tвторник\tсреда\tчетверг\tпятница\tсуббота" // weekdays
        );

        DateFormatSymbols.register(
                "rw\trw-RW", // locales
                "AM\tPM", // ampm
                "BCE\tCE", // eras
                "Mutarama\tGashyantare\tWerurwe\tMata\tGicuransi\tKamena\tNyakanga\tKanama\tNzeli\tUkwakira\tUgushyingo\tUkuboza", // months
                "mut.\tgas.\twer.\tmat.\tgic.\tkam.\tnya.\tkan.\tnze.\tukw.\tugu.\tuku.", // shortMonths
                "cyu.\tmbe.\tkab.\tgtu.\tkan.\tgnu.\tgnd.", // shortWeekdays
                "Ku cyumweru\tKuwa mbere\tKuwa kabiri\tKuwa gatatu\tKuwa kane\tKuwa gatanu\tKuwa gatandatu" // weekdays
        );

        DateFormatSymbols.register(
                "sah\tsah-RU", // locales
                "ЭИ\tЭК", // ampm
                "б. э. и.\tб. э", // eras
                "Тохсунньу\tОлунньу\tКулун тутар\tМуус устар\tЫам ыйын\tБэс ыйын\tОт ыйын\tАтырдьых ыйын\tБалаҕан ыйын\tАлтынньы\tСэтинньи\tАхсынньы", // months
                "Тохс\tОлун\tКлн_ттр\tМус_уст\tЫам_йн\tБэс_йн\tОт_йн\tАтрдь_йн\tБлҕн_йн\tАлт\tСэт\tАхс", // shortMonths
                "Бс\tБн\tОп\tСэ\tЧп\tБэ\tСб", // shortWeekdays
                "Баскыһыанньа\tБэнидиэлинньик\tОптуорунньук\tСэрэдэ\tЧэппиэр\tБээтиҥсэ\tСубуота" // weekdays
        );

        DateFormatSymbols.register(
                "saq\tsaq-KE", // locales
                "Tesiran\tTeipa", // ampm
                "KK\tBK", // eras
                "Lapa le obo\tLapa le waare\tLapa le okuni\tLapa le ong’wan\tLapa le imet\tLapa le ile\tLapa le sapa\tLapa le isiet\tLapa le saal\tLapa le tomon\tLapa le tomon obo\tLapa le tomon waare", // months
                "Obo\tWaa\tOku\tOng\tIme\tIle\tSap\tIsi\tSaa\tTom\tTob\tTow", // shortMonths
                "Are\tKun\tOng\tIne\tIle\tSap\tKwe", // shortWeekdays
                "Mderot ee are\tMderot ee kuni\tMderot ee ong’wan\tMderot ee inet\tMderot ee ile\tMderot ee sapa\tMderot ee kwe" // weekdays
        );

        DateFormatSymbols.register(
                "sbp\tsbp-TZ", // locales
                "Lwamilawu\tPashamihe", // ampm
                "AK\tPK", // eras
                "Mupalangulwa\tMwitope\tMushende\tMunyi\tMushende Magali\tMujimbi\tMushipepo\tMupuguto\tMunyense\tMokhu\tMusongandembwe\tMuhaano", // months
                "Mup\tMwi\tMsh\tMun\tMag\tMuj\tMsp\tMpg\tMye\tMok\tMus\tMuh", // shortMonths
                "Mul\tJtt\tJnn\tJtn\tAlh\tIju\tJmo", // shortWeekdays
                "Mulungu\tJumatatu\tJumanne\tJumatano\tAlahamisi\tIjumaa\tJumamosi" // weekdays
        );

        DateFormatSymbols.register(
                "se\tse-FI\tse-NO\tse-SE", // locales
                "iđitbeaivet\teahketbeaivet", // ampm
                "o.Kr.\tm.Kr.", // eras
                "ođđajagemánnu\tguovvamánnu\tnjukčamánnu\tcuoŋománnu\tmiessemánnu\tgeassemánnu\tsuoidnemánnu\tborgemánnu\tčakčamánnu\tgolggotmánnu\tskábmamánnu\tjuovlamánnu", // months
                "ođđj\tguov\tnjuk\tcuo\tmies\tgeas\tsuoi\tborg\tčakč\tgolg\tskáb\tjuov", // shortMonths
                "sotn\tvuos\tmaŋ\tgask\tduor\tbear\tláv", // shortWeekdays
                "sotnabeaivi\tvuossárga\tmaŋŋebárga\tgaskavahkku\tduorasdat\tbearjadat\tlávvardat" // weekdays
        );

        DateFormatSymbols.register(
                "seh\tseh-MZ", // locales
                "AM\tPM", // ampm
                "AC\tAD", // eras
                "Janeiro\tFevreiro\tMarco\tAbril\tMaio\tJunho\tJulho\tAugusto\tSetembro\tOtubro\tNovembro\tDecembro", // months
                "Jan\tFev\tMar\tAbr\tMai\tJun\tJul\tAug\tSet\tOtu\tNov\tDec", // shortMonths
                "Dim\tPos\tPir\tTat\tNai\tSha\tSab", // shortWeekdays
                "Dimingu\tChiposi\tChipiri\tChitatu\tChinai\tChishanu\tSabudu" // weekdays
        );

        DateFormatSymbols.register(
                "ses\tses-ML", // locales
                "Adduha\tAluula", // ampm
                "IJ\tIZ", // eras
                "Žanwiye\tFeewiriye\tMarsi\tAwiril\tMe\tŽuweŋ\tŽuyye\tUt\tSektanbur\tOktoobur\tNoowanbur\tDeesanbur", // months
                "Žan\tFee\tMar\tAwi\tMe\tŽuw\tŽuy\tUt\tSek\tOkt\tNoo\tDee", // shortMonths
                "Alh\tAti\tAta\tAla\tAlm\tAlz\tAsi", // shortWeekdays
                "Alhadi\tAtinni\tAtalaata\tAlarba\tAlhamiisa\tAlzuma\tAsibti" // weekdays
        );

        DateFormatSymbols.register(
                "sg\tsg-CF", // locales
                "ND\tLK", // ampm
                "KnK\tNpK", // eras
                "Nyenye\tFulundïgi\tMbängü\tNgubùe\tBêläwü\tFöndo\tLengua\tKükürü\tMvuka\tNgberere\tNabändüru\tKakauka", // months
                "Nye\tFul\tMbä\tNgu\tBêl\tFön\tLen\tKük\tMvu\tNgb\tNab\tKak", // shortMonths
                "Bk1\tBk2\tBk3\tBk4\tBk5\tLâp\tLây", // shortWeekdays
                "Bikua-ôko\tBïkua-ûse\tBïkua-ptâ\tBïkua-usïö\tBïkua-okü\tLâpôsö\tLâyenga" // weekdays
        );

        DateFormatSymbols.register(
                "shi\tshi-MA\tshi-Tfng\tshi-Tfng-MA", // locales
                "ⵜⵉⴼⴰⵡⵜ\tⵜⴰⴷⴳⴳⵯⴰⵜ", // ampm
                "ⴷⴰⵄ\tⴷⴼⵄ", // eras
                "ⵉⵏⵏⴰⵢⵔ\tⴱⵕⴰⵢⵕ\tⵎⴰⵕⵚ\tⵉⴱⵔⵉⵔ\tⵎⴰⵢⵢⵓ\tⵢⵓⵏⵢⵓ\tⵢⵓⵍⵢⵓⵣ\tⵖⵓⵛⵜ\tⵛⵓⵜⴰⵏⴱⵉⵔ\tⴽⵜⵓⴱⵔ\tⵏⵓⵡⴰⵏⴱⵉⵔ\tⴷⵓⵊⴰⵏⴱⵉⵔ", // months
                "ⵉⵏⵏ\tⴱⵕⴰ\tⵎⴰⵕ\tⵉⴱⵔ\tⵎⴰⵢ\tⵢⵓⵏ\tⵢⵓⵍ\tⵖⵓⵛ\tⵛⵓⵜ\tⴽⵜⵓ\tⵏⵓⵡ\tⴷⵓⵊ", // shortMonths
                "ⴰⵙⴰ\tⴰⵢⵏ\tⴰⵙⵉ\tⴰⴽⵕ\tⴰⴽⵡ\tⴰⵙⵉⵎ\tⴰⵙⵉⴹ", // shortWeekdays
                "ⴰⵙⴰⵎⴰⵙ\tⴰⵢⵏⴰⵙ\tⴰⵙⵉⵏⴰⵙ\tⴰⴽⵕⴰⵙ\tⴰⴽⵡⴰⵙ\tⵙⵉⵎⵡⴰⵙ\tⴰⵙⵉⴹⵢⴰⵙ" // weekdays
        );

        DateFormatSymbols.register(
                "shi-Latn\tshi-Latn-MA", // locales
                "tifawt\ttadggʷat", // ampm
                "daɛ\tdfɛ", // eras
                "innayr\tbṛayṛ\tmaṛṣ\tibrir\tmayyu\tyunyu\tyulyuz\tɣuct\tcutanbir\tktubr\tnuwanbir\tdujanbir", // months
                "inn\tbṛa\tmaṛ\tibr\tmay\tyun\tyul\tɣuc\tcut\tktu\tnuw\tduj", // shortMonths
                "asa\tayn\tasi\takṛ\takw\tasim\tasiḍ", // shortWeekdays
                "asamas\taynas\tasinas\takṛas\takwas\tasimwas\tasiḍyas" // weekdays
        );

        DateFormatSymbols.register(
                "si\tsi-LK", // locales
                "පෙ.ව.\tප.ව.", // ampm
                "ක්‍රි.පූ.\tක්‍රි.ව.", // eras
                "ජනවාරි\tපෙබරවාරි\tමාර්තු\tඅප්‍රේල්\tමැයි\tජූනි\tජූලි\tඅගෝස්තු\tසැප්තැම්බර්\tඔක්තෝබර්\tනොවැම්බර්\tදෙසැම්බර්", // months
                "ජන\tපෙබ\tමාර්තු\tඅප්‍රේල්\tමැයි\tජූනි\tජූලි\tඅගෝ\tසැප්\tඔක්\tනොවැ\tදෙසැ", // shortMonths
                "ඉරිදා\tසඳුදා\tඅඟහ\tබදාදා\tබ්‍රහස්\tසිකු\tසෙන", // shortWeekdays
                "ඉරිදා\tසඳුදා\tඅඟහරුවාදා\tබදාදා\tබ්‍රහස්පතින්දා\tසිකුරාදා\tසෙනසුරාදා" // weekdays
        );

        DateFormatSymbols.register(
                "sk\tsk-SK", // locales
                "AM\tPM", // ampm
                "pred Kr.\tpo Kr.", // eras
                "januára\tfebruára\tmarca\tapríla\tmája\tjúna\tjúla\taugusta\tseptembra\toktóbra\tnovembra\tdecembra", // months
                "jan\tfeb\tmar\tapr\tmáj\tjún\tjúl\taug\tsep\tokt\tnov\tdec", // shortMonths
                "ne\tpo\tut\tst\tšt\tpi\tso", // shortWeekdays
                "nedeľa\tpondelok\tutorok\tstreda\tštvrtok\tpiatok\tsobota" // weekdays
        );

        DateFormatSymbols.register(
                "sl\tsl-SI", // locales
                "dop.\tpop.", // ampm
                "pr. Kr.\tpo n. št.", // eras
                "januar\tfebruar\tmarec\tapril\tmaj\tjunij\tjulij\tavgust\tseptember\toktober\tnovember\tdecember", // months
                "jan.\tfeb.\tmar.\tapr.\tmaj\tjun.\tjul.\tavg.\tsep.\tokt.\tnov.\tdec.", // shortMonths
                "ned.\tpon.\ttor.\tsre.\tčet.\tpet.\tsob.", // shortWeekdays
                "nedelja\tponedeljek\ttorek\tsreda\tčetrtek\tpetek\tsobota" // weekdays
        );

        DateFormatSymbols.register(
                "smn\tsmn-FI", // locales
                "AM\tPM", // ampm
                "BCE\tCE", // eras
                "uđđâivemáánu\tkuovâmáánu\tnjuhčâmáánu\tcuáŋuimáánu\tvyesimáánu\tkesimáánu\tsyeinimáánu\tporgemáánu\tčohčâmáánu\troovvâdmáánu\tskammâmáánu\tjuovlâmáánu", // months
                "Jan\tFeb\tMar\tApr\tMay\tJun\tJul\tAug\tSep\tOct\tNov\tDec", // shortMonths
                "pa\tvu\tma\tko\ttu\tvá\tlá", // shortWeekdays
                "pasepeeivi\tvuossaargâ\tmajebaargâ\tkoskoho\ttuorâstuv\tvástuppeeivi\tlávurduv" // weekdays
        );

        DateFormatSymbols.register(
                "sn\tsn-ZW", // locales
                "AM\tPM", // ampm
                "BC\tAD", // eras
                "Ndira\tKukadzi\tKurume\tKubvumbi\tChivabvu\tChikumi\tChikunguru\tNyamavhuvhu\tGunyana\tGumiguru\tMbudzi\tZvita", // months
                "Ndi\tKuk\tKur\tKub\tChv\tChk\tChg\tNya\tGun\tGum\tMb\tZvi", // shortMonths
                "Svo\tMuv\tChip\tChit\tChin\tChis\tMug", // shortWeekdays
                "Svondo\tMuvhuro\tChipiri\tChitatu\tChina\tChishanu\tMugovera" // weekdays
        );

        DateFormatSymbols.register(
                "so\tso-DJ\tso-ET\tso-KE\tso-SO", // locales
                "sn.\tgn.", // ampm
                "CK\tCD", // eras
                "Bisha Koobaad\tBisha Labaad\tBisha Saddexaad\tBisha Afraad\tBisha Shanaad\tBisha Lixaad\tBisha Todobaad\tBisha Sideedaad\tBisha Sagaalaad\tBisha Tobnaad\tBisha Kow iyo Tobnaad\tBisha Laba iyo Tobnaad", // months
                "Kob\tLab\tSad\tAfr\tSha\tLix\tTod\tSid\tSag\tTob\tKIT\tLIT", // shortMonths
                "Axd\tIsn\tTal\tArb\tKha\tJim\tSab", // shortWeekdays
                "Axad\tIsniin\tTalaado\tArbaco\tKhamiis\tJimco\tSabti" // weekdays
        );

        DateFormatSymbols.register(
                "sq\tsq-AL\tsq-MK\tsq-XK", // locales
                "e paradites\te pasdites", // ampm
                "p.e.r.\te.r.", // eras
                "janar\tshkurt\tmars\tprill\tmaj\tqershor\tkorrik\tgusht\tshtator\ttetor\tnëntor\tdhjetor", // months
                "Jan\tShk\tMar\tPri\tMaj\tQer\tKor\tGsh\tSht\tTet\tNën\tDhj", // shortMonths
                "Die\tHën\tMar\tMër\tEnj\tPre\tSht", // shortWeekdays
                "e diel\te hënë\te martë\te mërkurë\te enjte\te premte\te shtunë" // weekdays
        );

        DateFormatSymbols.register(
                "sr\tsr-Cyrl\tsr-Cyrl-BA\tsr-Cyrl-ME\tsr-Cyrl-RS\tsr-Cyrl-XK\tsr-RS", // locales
                "пре подне\tпо подне", // ampm
                "п. н. е.\tн. е.", // eras
                "јануар\tфебруар\tмарт\tаприл\tмај\tјун\tјул\tавгуст\tсептембар\tоктобар\tновембар\tдецембар", // months
                "јан\tфеб\tмар\tапр\tмај\tјун\tјул\tавг\tсеп\tокт\tнов\tдец", // shortMonths
                "нед\tпон\tуто\tсре\tчет\tпет\tсуб", // shortWeekdays
                "недеља\tпонедељак\tуторак\tсреда\tчетвртак\tпетак\tсубота" // weekdays
        );

        DateFormatSymbols.register(
                "sr-BA", // locales
                "AM\tPM", // ampm
                "п. н. е.\tн. е", // eras
                "јануар\tфебруар\tмарт\tаприл\tмај\tјуни\tјули\tавгуст\tсептембар\tоктобар\tновембар\tдецембар", // months
                "јан\tфеб\tмар\tапр\tмај\tјун\tјул\tавг\tсеп\tокт\tнов\tдец", // shortMonths
                "нед\tпон\tуто\tсри\tчет\tпет\tсуб", // shortWeekdays
                "недеља\tпонедељак\tуторак\tсриједа\tчетвртак\tпетак\tсубота" // weekdays
        );

        DateFormatSymbols.register(
                "sr-CS\tsr-ME", // locales
                "AM\tPM", // ampm
                "п. н. е.\tн. е", // eras
                "јануар\tфебруар\tмарт\tаприл\tмај\tјун\tјул\tавгуст\tсептембар\tоктобар\tновембар\tдецембар", // months
                "јан\tфеб\tмар\tапр\tмај\tјун\tјул\tавг\tсеп\tокт\tнов\tдец", // shortMonths
                "нед\tпон\tуто\tсре\tчет\tпет\tсуб", // shortWeekdays
                "недеља\tпонедељак\tуторак\tсреда\tчетвртак\tпетак\tсубота" // weekdays
        );

        DateFormatSymbols.register(
                "sr-Latn\tsr-Latn-BA\tsr-Latn-ME\tsr-Latn-RS\tsr-Latn-XK", // locales
                "pre podne\tpo podne", // ampm
                "p. n. e.\tn. e.", // eras
                "januar\tfebruar\tmart\tapril\tmaj\tjun\tjul\tavgust\tseptembar\toktobar\tnovembar\tdecembar", // months
                "jan\tfeb\tmar\tapr\tmaj\tjun\tjul\tavg\tsep\tokt\tnov\tdec", // shortMonths
                "ned\tpon\tuto\tsre\tčet\tpet\tsub", // shortWeekdays
                "nedelja\tponedeljak\tutorak\tsreda\tčetvrtak\tpetak\tsubota" // weekdays
        );

        DateFormatSymbols.register(
                "sv\tsv-AX\tsv-FI\tsv-SE", // locales
                "fm\tem", // ampm
                "f.Kr.\te.Kr.", // eras
                "januari\tfebruari\tmars\tapril\tmaj\tjuni\tjuli\taugusti\tseptember\toktober\tnovember\tdecember", // months
                "jan.\tfeb.\tmars\tapr.\tmaj\tjuni\tjuli\taug.\tsep.\tokt.\tnov.\tdec.", // shortMonths
                "sön\tmån\ttis\tons\ttors\tfre\tlör", // shortWeekdays
                "söndag\tmåndag\ttisdag\tonsdag\ttorsdag\tfredag\tlördag" // weekdays
        );

        DateFormatSymbols.register(
                "sw\tsw-KE\tsw-TZ\tsw-UG", // locales
                "AM\tPM", // ampm
                "BC\tAD", // eras
                "Januari\tFebruari\tMachi\tAprili\tMei\tJuni\tJulai\tAgosti\tSeptemba\tOktoba\tNovemba\tDesemba", // months
                "Jan\tFeb\tMac\tApr\tMei\tJun\tJul\tAgo\tSep\tOkt\tNov\tDes", // shortMonths
                "Jumapili\tJumatatu\tJumanne\tJumatano\tAlhamisi\tIjumaa\tJumamosi", // shortWeekdays
                "Jumapili\tJumatatu\tJumanne\tJumatano\tAlhamisi\tIjumaa\tJumamosi" // weekdays
        );

        DateFormatSymbols.register(
                "sw-CD", // locales
                "ya asubuyi\tya muchana", // ampm
                "BC\tAD", // eras
                "mwezi ya kwanja\tmwezi ya pili\tmwezi ya tatu\tmwezi ya ine\tmwezi ya tanu\tmwezi ya sita\tmwezi ya saba\tmwezi ya munane\tmwezi ya tisa\tmwezi ya kumi\tmwezi ya kumi na moya\tmwezi ya kumi ya mbili", // months
                "mkw\tmpi\tmtu\tmin\tmtn\tmst\tmsb\tmun\tmts\tmku\tmkm\tmkb", // shortMonths
                "yen\tkwa\tpil\ttat\tine\ttan\tsit", // shortWeekdays
                "siku ya yenga\tsiku ya kwanza\tsiku ya pili\tsiku ya tatu\tsiku ya ine\tsiku ya tanu\tsiku ya sita" // weekdays
        );

        DateFormatSymbols.register(
                "ta\tta-IN\tta-LK\tta-MY\tta-SG", // locales
                "முற்பகல்\tபிற்பகல்", // ampm
                "கி.மு.\tகி.பி.", // eras
                "ஜனவரி\tபிப்ரவரி\tமார்ச்\tஏப்ரல்\tமே\tஜூன்\tஜூலை\tஆகஸ்ட்\tசெப்டம்பர்\tஅக்டோபர்\tநவம்பர்\tடிசம்பர்", // months
                "ஜன.\tபிப்.\tமார்.\tஏப்.\tமே\tஜூன்\tஜூலை\tஆக.\tசெப்.\tஅக்.\tநவ.\tடிச.", // shortMonths
                "ஞாயி.\tதிங்.\tசெவ்.\tபுத.\tவியா.\tவெள்.\tசனி", // shortWeekdays
                "ஞாயிறு\tதிங்கள்\tசெவ்வாய்\tபுதன்\tவியாழன்\tவெள்ளி\tசனி" // weekdays
        );

        DateFormatSymbols.register(
                "te\tte-IN", // locales
                "[AM]\t[PM]", // ampm
                "క్రీపూ\tక్రీశ", // eras
                "జనవరి\tఫిబ్రవరి\tమార్చి\tఏప్రిల్\tమే\tజూన్\tజులై\tఆగస్టు\tసెప్టెంబర్\tఅక్టోబర్\tనవంబర్\tడిసెంబర్", // months
                "జన\tఫిబ్ర\tమార్చి\tఏప్రి\tమే\tజూన్\tజులై\tఆగ\tసెప్టెం\tఅక్టో\tనవం\tడిసెం", // shortMonths
                "ఆది\tసోమ\tమంగళ\tబుధ\tగురు\tశుక్ర\tశని", // shortWeekdays
                "ఆదివారం\tసోమవారం\tమంగళవారం\tబుధవారం\tగురువారం\tశుక్రవారం\tశనివారం" // weekdays
        );

        DateFormatSymbols.register(
                "teo\tteo-KE\tteo-UG", // locales
                "Taparachu\tEbongi", // ampm
                "KK\tBK", // eras
                "Orara\tOmuk\tOkwamg’\tOdung’el\tOmaruk\tOmodok’king’ol\tOjola\tOpedel\tOsokosokoma\tOtibar\tOlabor\tOpoo", // months
                "Rar\tMuk\tKwa\tDun\tMar\tMod\tJol\tPed\tSok\tTib\tLab\tPoo", // shortMonths
                "Jum\tBar\tAar\tUni\tUng\tKan\tSab", // shortWeekdays
                "Nakaejuma\tNakaebarasa\tNakaare\tNakauni\tNakaung’on\tNakakany\tNakasabiti" // weekdays
        );

        DateFormatSymbols.register(
                "th\tth-TH", // locales
                "ก่อนเที่ยง\tหลังเที่ยง", // ampm
                "ปีก่อน ค.ศ.\tค.ศ.", // eras
                "มกราคม\tกุมภาพันธ์\tมีนาคม\tเมษายน\tพฤษภาคม\tมิถุนายน\tกรกฎาคม\tสิงหาคม\tกันยายน\tตุลาคม\tพฤศจิกายน\tธันวาคม", // months
                "ม.ค.\tก.พ.\tมี.ค.\tเม.ย.\tพ.ค.\tมิ.ย.\tก.ค.\tส.ค.\tก.ย.\tต.ค.\tพ.ย.\tธ.ค.", // shortMonths
                "อา.\tจ.\tอ.\tพ.\tพฤ.\tศ.\tส.", // shortWeekdays
                "วันอาทิตย์\tวันจันทร์\tวันอังคาร\tวันพุธ\tวันพฤหัสบดี\tวันศุกร์\tวันเสาร์" // weekdays
        );

        DateFormatSymbols.register(
                "ti\tti-ET", // locales
                "ንጉሆ ሰዓተ\tድሕር ሰዓት", // ampm
                "ዓ/ዓ\tዓ/ም", // eras
                "ጃንዩወሪ\tፌብሩወሪ\tማርች\tኤፕረል\tሜይ\tጁን\tጁላይ\tኦገስት\tሴፕቴምበር\tኦክተውበር\tኖቬምበር\tዲሴምበር", // months
                "ጃንዩ\tፌብሩ\tማርች\tኤፕረ\tሜይ\tጁን\tጁላይ\tኦገስ\tሴፕቴ\tኦክተ\tኖቬም\tዲሴም", // shortMonths
                "ሰንበት\tሰኑይ\tሠሉስ\tረቡዕ\tኃሙስ\tዓርቢ\tቀዳም", // shortWeekdays
                "ሰንበት\tሰኑይ\tሠሉስ\tረቡዕ\tኃሙስ\tዓርቢ\tቀዳም" // weekdays
        );

        DateFormatSymbols.register(
                "ti-ER", // locales
                "ንጉሆ ሰዓተ\tድሕር ሰዓት", // ampm
                "ዓ/ዓ\tዓ/ም", // eras
                "ጥሪ\tለካቲት\tመጋቢት\tሚያዝያ\tግንቦት\tሰነ\tሓምለ\tነሓሰ\tመስከረም\tጥቅምቲ\tሕዳር\tታሕሳስ", // months
                "ጥሪ\tለካቲ\tመጋቢ\tሚያዝ\tግንቦ\tሰነ\tሓምለ\tነሓሰ\tመስከ\tጥቅም\tሕዳር\tታሕሳ", // shortMonths
                "ሰንበት\tሰኑይ\tሰሉስ\tረቡዕ\tሓሙስ\tዓርቢ\tቀዳም", // shortWeekdays
                "ሰንበት\tሰኑይ\tሰሉስ\tረቡዕ\tሓሙስ\tዓርቢ\tቀዳም" // weekdays
        );

        DateFormatSymbols.register(
                "to\tto-TO", // locales
                "AM\tPM", // ampm
                "KM\tTS", // eras
                "Sānuali\tFēpueli\tMaʻasi\tʻEpeleli\tMē\tSune\tSiulai\tʻAokosi\tSepitema\tʻOkatopa\tNōvema\tTīsema", // months
                "Sān\tFēp\tMaʻa\tʻEpe\tMē\tSun\tSiu\tʻAok\tSep\tʻOka\tNōv\tTīs", // shortMonths
                "Sāp\tMōn\tTūs\tPul\tTuʻa\tFal\tTok", // shortWeekdays
                "Sāpate\tMōnite\tTūsite\tPulelulu\tTuʻapulelulu\tFalaite\tTokonaki" // weekdays
        );

        DateFormatSymbols.register(
                "tr\ttr-CY\ttr-TR", // locales
                "ÖÖ\tÖS", // ampm
                "MÖ\tMS", // eras
                "Ocak\tŞubat\tMart\tNisan\tMayıs\tHaziran\tTemmuz\tAğustos\tEylül\tEkim\tKasım\tAralık", // months
                "Oca\tŞub\tMar\tNis\tMay\tHaz\tTem\tAğu\tEyl\tEki\tKas\tAra", // shortMonths
                "Paz\tPzt\tSal\tÇar\tPer\tCum\tCmt", // shortWeekdays
                "Pazar\tPazartesi\tSalı\tÇarşamba\tPerşembe\tCuma\tCumartesi" // weekdays
        );

        DateFormatSymbols.register(
                "twq\ttwq-NE", // locales
                "Subbaahi\tZaarikay b", // ampm
                "IJ\tIZ", // eras
                "Žanwiye\tFeewiriye\tMarsi\tAwiril\tMe\tŽuweŋ\tŽuyye\tUt\tSektanbur\tOktoobur\tNoowanbur\tDeesanbur", // months
                "Žan\tFee\tMar\tAwi\tMe\tŽuw\tŽuy\tUt\tSek\tOkt\tNoo\tDee", // shortMonths
                "Alh\tAti\tAta\tAla\tAlm\tAlz\tAsi", // shortWeekdays
                "Alhadi\tAtinni\tAtalaata\tAlarba\tAlhamiisa\tAlzuma\tAsibti" // weekdays
        );

        DateFormatSymbols.register(
                "tzm\ttzm-MA", // locales
                "Zdat azal\tḌeffir aza", // ampm
                "ZƐ\tḌƐ", // eras
                "Yennayer\tYebrayer\tMars\tIbrir\tMayyu\tYunyu\tYulyuz\tƔuct\tCutanbir\tKṭuber\tNwanbir\tDujanbir", // months
                "Yen\tYeb\tMar\tIbr\tMay\tYun\tYul\tƔuc\tCut\tKṭu\tNwa\tDuj", // shortMonths
                "Asa\tAyn\tAsn\tAkr\tAkw\tAsm\tAsḍ", // shortWeekdays
                "Asamas\tAynas\tAsinas\tAkras\tAkwas\tAsimwas\tAsiḍyas" // weekdays
        );

        DateFormatSymbols.register(
                "ug\tug-CN", // locales
                "چۈشتىن بۇرۇن\tچۈشتىن كېيىن", // ampm
                "BCE\tمىلادىيە", // eras
                "يانۋار\tفېۋرال\tمارت\tئاپرېل\tماي\tئىيۇن\tئىيۇل\tئاۋغۇست\tسېنتەبىر\tئۆكتەبىر\tنويابىر\tدېكابىر", // months
                "يانۋار\tفېۋرال\tمارت\tئاپرېل\tماي\tئىيۇن\tئىيۇل\tئاۋغۇست\tسېنتەبىر\tئۆكتەبىر\tنويابىر\tدېكابىر", // shortMonths
                "يە\tدۈ\tسە\tچا\tپە\tجۈ\tشە", // shortWeekdays
                "يەكشەنبە\tدۈشەنبە\tسەيشەنبە\tچارشەنبە\tپەيشەنبە\tجۈمە\tشەنبە" // weekdays
        );

        DateFormatSymbols.register(
                "uk\tuk-UA", // locales
                "дп\tпп", // ampm
                "до н. е.\tн. е.", // eras
                "січня\tлютого\tберезня\tквітня\tтравня\tчервня\tлипня\tсерпня\tвересня\tжовтня\tлистопада\tгрудня", // months
                "січ.\tлют.\tбер.\tквіт.\tтрав.\tчерв.\tлип.\tсерп.\tвер.\tжовт.\tлист.\tгруд.", // shortMonths
                "Нд\tПн\tВт\tСр\tЧт\tПт\tСб", // shortWeekdays
                "неділя\tпонеділок\tвівторок\tсереда\tчетвер\tпʼятниця\tсубота" // weekdays
        );

        DateFormatSymbols.register(
                "ur\tur-IN\tur-PK", // locales
                "قبل دوپہر\tبعد دوپہر", // ampm
                "قبل مسیح\tعیسوی", // eras
                "جنوری\tفروری\tمارچ\tاپریل\tمئی\tجون\tجولائی\tاگست\tستمبر\tاکتوبر\tنومبر\tدسمبر", // months
                "جنوری\tفروری\tمارچ\tاپریل\tمئی\tجون\tجولائی\tاگست\tستمبر\tاکتوبر\tنومبر\tدسمبر", // shortMonths
                "اتوار\tسوموار\tمنگل\tبدھ\tجمعرات\tجمعہ\tہفتہ", // shortWeekdays
                "اتوار\tسوموار\tمنگل\tبدھ\tجمعرات\tجمعہ\tہفتہ" // weekdays
        );

        DateFormatSymbols.register(
                "uz\tuz-AF\tuz-Latn\tuz-Latn-UZ\tuz-UZ", // locales
                "TO\tTK", // ampm
                "m.a.\tmilodiy", // eras
                "yanvar\tfevral\tmart\taprel\tmay\tiyun\tiyul\tavgust\tSentabr\tOktabr\tnoyabr\tdekabr", // months
                "yan\tfev\tmar\tapr\tmay\tiyn\tiyl\tavg\tsen\tokt\tnoy\tdek", // shortMonths
                "Ya\tDu\tSe\tCh\tPa\tJu\tSh", // shortWeekdays
                "yakshanba\tdushanba\tseshanba\tchorshanba\tpayshanba\tjuma\tshanba" // weekdays
        );

        DateFormatSymbols.register(
                "uz-Arab\tuz-Arab-AF", // locales
                "AM\tPM", // ampm
                "BCE\tCE", // eras
                "جنوری\tفبروری\tمارچ\tاپریل\tمی\tجون\tجولای\tاگست\tسپتمبر\tاکتوبر\tنومبر\tدسمبر", // months
                "جنو\tفبر\tمار\tاپر\tمی\tجون\tجول\tاگس\tسپت\tاکت\tنوم\tدسم", // shortMonths
                "ی.\tد.\tس.\tچ.\tپ.\tج.\tش.", // shortWeekdays
                "یکشنبه\tدوشنبه\tسه‌شنبه\tچهارشنبه\tپنجشنبه\tجمعه\tشنبه" // weekdays
        );

        DateFormatSymbols.register(
                "uz-Cyrl\tuz-Cyrl-UZ", // locales
                "AM\tPM", // ampm
                "М.А.\tЭ", // eras
                "Январ\tФеврал\tМарт\tАпрел\tМай\tИюн\tИюл\tАвгуст\tСентябр\tОктябр\tНоябр\tДекабр", // months
                "Янв\tФев\tМар\tАпр\tМай\tИюн\tИюл\tАвг\tСен\tОкт\tНоя\tДек", // shortMonths
                "Якш\tДуш\tСеш\tЧор\tПай\tЖум\tШан", // shortWeekdays
                "якшанба\tдушанба\tсешанба\tчоршанба\tпайшанба\tжума\tшанба" // weekdays
        );

        DateFormatSymbols.register(
                "vai\tvai-LR\tvai-Vaii\tvai-Vaii-LR", // locales
                "AM\tPM", // ampm
                "BCE\tCE", // eras
                "ꖨꕪꖃ ꔞꕮ\tꕒꕡꖝꖕ\tꕾꖺ\tꖢꖕ\tꖑꕱ\t6\t7\tꗛꔕ\tꕢꕌ\tꕭꖃ\tꔞꘋꕔꕿ ꕸꖃꗏ\tꖨꕪꕱ ꗏꕮ", // months
                "ꖨꕪꖃ ꔞꕮ\tꕒꕡꖝꖕ\tꕾꖺ\tꖢꖕ\tꖑꕱ\t6\t7\tꗛꔕ\tꕢꕌ\tꕭꖃ\tꔞꘋꕔꕿ ꕸꖃꗏ\tꖨꕪꕱ ꗏꕮ", // shortMonths
                "ꕞꕌꔵ\tꗳꗡꘉ\tꕚꕞꕚ\tꕉꕞꕒ\tꕉꔤꕆꕢ\tꕉꔤꕀꕮ\tꔻꔬꔳ", // shortWeekdays
                "ꕞꕌꔵ\tꗳꗡꘉ\tꕚꕞꕚ\tꕉꕞꕒ\tꕉꔤꕆꕢ\tꕉꔤꕀꕮ\tꔻꔬꔳ" // weekdays
        );

        DateFormatSymbols.register(
                "vai-Latn\tvai-Latn-LR", // locales
                "AM\tPM", // ampm
                "BCE\tCE", // eras
                "luukao kemã\tɓandaɓu\tvɔɔ\tfulu\tgoo\t6\t7\tkɔnde\tsaah\tgalo\tkenpkato ɓololɔ\tluukao lɔma", // months
                "luukao kemã\tɓandaɓu\tvɔɔ\tfulu\tgoo\t6\t7\tkɔnde\tsaah\tgalo\tkenpkato ɓololɔ\tluukao lɔma", // shortMonths
                "lahadi\ttɛɛnɛɛ\ttalata\talaba\taimisa\taijima\tsiɓiti", // shortWeekdays
                "lahadi\ttɛɛnɛɛ\ttalata\talaba\taimisa\taijima\tsiɓiti" // weekdays
        );

        DateFormatSymbols.register(
                "vi\tvi-VN", // locales
                "SA\tCH", // ampm
                "tr. CN\tsau CN", // eras
                "tháng 1\ttháng 2\ttháng 3\ttháng 4\ttháng 5\ttháng 6\ttháng 7\ttháng 8\ttháng 9\ttháng 10\ttháng 11\ttháng 12", // months
                "thg 1\tthg 2\tthg 3\tthg 4\tthg 5\tthg 6\tthg 7\tthg 8\tthg 9\tthg 10\tthg 11\tthg 12", // shortMonths
                "CN\tTh 2\tTh 3\tTh 4\tTh 5\tTh 6\tTh 7", // shortWeekdays
                "Chủ Nhật\tThứ Hai\tThứ Ba\tThứ Tư\tThứ Năm\tThứ Sáu\tThứ Bảy" // weekdays
        );

        DateFormatSymbols.register(
                "wae\twae-CH", // locales
                "AM\tPM", // ampm
                "v. Chr.\tn. Chr", // eras
                "Jenner\tHornig\tMärze\tAbrille\tMeije\tBráčet\tHeiwet\tÖigšte\tHerbštmánet\tWímánet\tWintermánet\tChrištmánet", // months
                "Jen\tHor\tMär\tAbr\tMei\tBrá\tHei\tÖig\tHer\tWím\tWin\tChr", // shortMonths
                "Sun\tMän\tZiš\tMit\tFró\tFri\tSam", // shortWeekdays
                "Sunntag\tMäntag\tZištag\tMittwuč\tFróntag\tFritag\tSamštag" // weekdays
        );

        DateFormatSymbols.register(
                "xog\txog-UG", // locales
                "Munkyo\tEigulo", // ampm
                "AZ\tAF", // eras
                "Janwaliyo\tFebwaliyo\tMarisi\tApuli\tMaayi\tJuuni\tJulaayi\tAgusito\tSebuttemba\tOkitobba\tNovemba\tDesemba", // months
                "Jan\tFeb\tMar\tApu\tMaa\tJuu\tJul\tAgu\tSeb\tOki\tNov\tDes", // shortMonths
                "Sabi\tBala\tKubi\tKusa\tKuna\tKuta\tMuka", // shortWeekdays
                "Sabiiti\tBalaza\tOwokubili\tOwokusatu\tOlokuna\tOlokutaanu\tOlomukaaga" // weekdays
        );

        DateFormatSymbols.register(
                "yav\tyav-CM", // locales
                "kiɛmɛ́ɛm\tkisɛ́ndɛ", // ampm
                "k.Y.\t+J.C.", // eras
                "pikítíkítie, oólí ú kutúan\tsiɛyɛ́, oóli ú kándíɛ\tɔnsúmbɔl, oóli ú kátátúɛ\tmesiŋ, oóli ú kénie\tensil, oóli ú kátánuɛ\tɔsɔn\tefute\tpisuyú\timɛŋ i puɔs\timɛŋ i putúk,oóli ú kátíɛ\tmakandikɛ\tpilɔndɔ́", // months
                "o.1\to.2\to.3\to.4\to.5\to.6\to.7\to.8\to.9\to.10\to.11\to.12", // shortMonths
                "sd\tmd\tmw\tet\tkl\tfl\tss", // shortWeekdays
                "sɔ́ndiɛ\tmóndie\tmuányáŋmóndie\tmetúkpíápɛ\tkúpélimetúkpiapɛ\tfeléte\tséselé" // weekdays
        );

        DateFormatSymbols.register(
                "yi\tyi-001", // locales
                "פֿאַרמיטאָג\tנאָכמיטאָג", // ampm
                "BCE\tCE", // eras
                "יאַנואַר\tפֿעברואַר\tמערץ\tאַפּריל\tמיי\tיוני\tיולי\tאויגוסט\tסעפּטעמבער\tאקטאבער\tנאוועמבער\tדעצעמבער", // months
                "יאַנואַר\tפֿעברואַר\tמערץ\tאַפּריל\tמיי\tיוני\tיולי\tאויגוסט\tסעפּטעמבער\tאקטאבער\tנאוועמבער\tדעצעמבער", // shortMonths
                "זונטיק\tמאָנטיק\tדינסטיק\tמיטוואך\tדאנערשטיק\tפֿרײַטיק\tשבת", // shortWeekdays
                "זונטיק\tמאָנטיק\tדינסטיק\tמיטוואך\tדאנערשטיק\tפֿרײַטיק\tשבת" // weekdays
        );

        DateFormatSymbols.register(
                "yo\tyo-NG", // locales
                "Àárọ̀\tỌ̀sán", // ampm
                "SK\tLK", // eras
                "Oṣù Ṣẹ́rẹ́\tOṣù Èrèlè\tOṣù Ẹrẹ̀nà\tOṣù Ìgbé\tOṣù Ẹ̀bibi\tOṣù Òkúdu\tOṣù Agẹmọ\tOṣù Ògún\tOṣù Owewe\tOṣù Ọ̀wàrà\tOṣù Bélú\tOṣù Ọ̀pẹ̀", // months
                "Ṣẹ́rẹ́\tÈrèlè\tẸrẹ̀nà\tÌgbé\tẸ̀bibi\tÒkúdu\tAgẹmọ\tÒgún\tOwewe\tỌ̀wàrà\tBélú\tỌ̀pẹ̀", // shortMonths
                "Àìkú\tAjé\tÌsẹ́gun\tỌjọ́rú\tỌjọ́bọ\tẸtì\tÀbámẹ́ta", // shortWeekdays
                "Ọjọ́ Àìkú\tỌjọ́ Ajé\tỌjọ́ Ìsẹ́gun\tỌjọ́rú\tỌjọ́bọ\tỌjọ́ Ẹtì\tỌjọ́ Àbámẹ́ta" // weekdays
        );

        DateFormatSymbols.register(
                "yo-BJ", // locales
                "Àárɔ̀\tƆ̀sán", // ampm
                "SK\tLK", // eras
                "Oshù Shɛ́rɛ́\tOshù Èrèlè\tOshù Ɛrɛ̀nà\tOshù Ìgbé\tOshù Ɛ̀bibi\tOshù Òkúdu\tOshù Agɛmɔ\tOshù Ògún\tOshù Owewe\tOshù Ɔ̀wàrà\tOshù Bélú\tOshù Ɔ̀pɛ̀", // months
                "Shɛ́rɛ́\tÈrèlè\tƐrɛ̀nà\tÌgbé\tƐ̀bibi\tÒkúdu\tAgɛmɔ\tÒgún\tOwewe\tƆ̀wàrà\tBélú\tƆ̀pɛ̀", // shortMonths
                "Àìkú\tAjé\tÌsɛ́gun\tƆjɔ́rú\tƆjɔ́bɔ\tƐtì\tÀbámɛ́ta", // shortWeekdays
                "Ɔjɔ́ Àìkú\tƆjɔ́ Ajé\tƆjɔ́ Ìsɛ́gun\tƆjɔ́rú\tƆjɔ́bɔ\tƆjɔ́ Ɛtì\tƆjɔ́ Àbámɛ́ta" // weekdays
        );

        DateFormatSymbols.register(
                "yue\tyue-HK\tzh-Hant\tzh-Hant-TW\tzh-TW", // locales
                "上午\t下午", // ampm
                "西元前\t西元", // eras
                "1月\t2月\t3月\t4月\t5月\t6月\t7月\t8月\t9月\t10月\t11月\t12月", // months
                "1月\t2月\t3月\t4月\t5月\t6月\t7月\t8月\t9月\t10月\t11月\t12月", // shortMonths
                "週日\t週一\t週二\t週三\t週四\t週五\t週六", // shortWeekdays
                "星期日\t星期一\t星期二\t星期三\t星期四\t星期五\t星期六" // weekdays
        );

        DateFormatSymbols.register(
                "zgh\tzgh-MA", // locales
                "ⵜⵉⴼⴰⵡⵜ\tⵜⴰⴷⴳⴳⵯⴰⵜ", // ampm
                "ⴷⴰⵄ\tⴷⴼⵄ", // eras
                "ⵉⵏⵏⴰⵢⵔ\tⴱⵕⴰⵢⵕ\tⵎⴰⵕⵚ\tⵉⴱⵔⵉⵔ\tⵎⴰⵢⵢⵓ\tⵢⵓⵏⵢⵓ\tⵢⵓⵍⵢⵓⵣ\tⵖⵓⵛⵜ\tⵛⵓⵜⴰⵏⴱⵉⵔ\tⴽⵜⵓⴱⵔ\tⵏⵓⵡⴰⵏⴱⵉⵔ\tⴷⵓⵊⴰⵏⴱⵉⵔ", // months
                "ⵉⵏⵏ\tⴱⵕⴰ\tⵎⴰⵕ\tⵉⴱⵔ\tⵎⴰⵢ\tⵢⵓⵏ\tⵢⵓⵍ\tⵖⵓⵛ\tⵛⵓⵜ\tⴽⵜⵓ\tⵏⵓⵡ\tⴷⵓⵊ", // shortMonths
                "ⴰⵙⴰ\tⴰⵢⵏ\tⴰⵙⵉ\tⴰⴽⵕ\tⴰⴽⵡ\tⴰⵙⵉⵎ\tⴰⵙⵉⴹ", // shortWeekdays
                "ⴰⵙⴰⵎⴰⵙ\tⴰⵢⵏⴰⵙ\tⴰⵙⵉⵏⴰⵙ\tⴰⴽⵕⴰⵙ\tⴰⴽⵡⴰⵙ\tⴰⵙⵉⵎⵡⴰⵙ\tⴰⵙⵉⴹⵢⴰⵙ" // weekdays
        );

        DateFormatSymbols.register(
                "zh\tzh-CN\tzh-Hans\tzh-Hans-CN\tzh-Hans-HK\tzh-Hans-MO\tzh-Hans-SG", // locales
                "上午\t下午", // ampm
                "公元前\t公元", // eras
                "一月\t二月\t三月\t四月\t五月\t六月\t七月\t八月\t九月\t十月\t十一月\t十二月", // months
                "1月\t2月\t3月\t4月\t5月\t6月\t7月\t8月\t9月\t10月\t11月\t12月", // shortMonths
                "周日\t周一\t周二\t周三\t周四\t周五\t周六", // shortWeekdays
                "星期日\t星期一\t星期二\t星期三\t星期四\t星期五\t星期六" // weekdays
        );

        DateFormatSymbols.register(
                "zh-HK\tzh-Hant-HK\tzh-Hant-MO", // locales
                "上午\t下午", // ampm
                "公元前\t公元", // eras
                "1月\t2月\t3月\t4月\t5月\t6月\t7月\t8月\t9月\t10月\t11月\t12月", // months
                "1月\t2月\t3月\t4月\t5月\t6月\t7月\t8月\t9月\t10月\t11月\t12月", // shortMonths
                "週日\t週一\t週二\t週三\t週四\t週五\t週六", // shortWeekdays
                "星期日\t星期一\t星期二\t星期三\t星期四\t星期五\t星期六" // weekdays
        );

        DateFormatSymbols.register(
                "zh-SG", // locales
                "上午\t下午", // ampm
                "公元前\t公元", // eras
                "一月\t二月\t三月\t四月\t五月\t六月\t七月\t八月\t九月\t十月\t十一月\t十二月", // months
                "一月\t二月\t三月\t四月\t五月\t六月\t七月\t八月\t九月\t十月\t十一月\t十二月", // shortMonths
                "周日\t周一\t周二\t周三\t周四\t周五\t周六", // shortWeekdays
                "星期日\t星期一\t星期二\t星期三\t星期四\t星期五\t星期六" // weekdays
        );

        DateFormatSymbols.register(
                "zu\tzu-ZA", // locales
                "AM\tPM", // ampm
                "BC\tAD", // eras
                "Januwari\tFebruwari\tMashi\tEphreli\tMeyi\tJuni\tJulayi\tAgasti\tSepthemba\tOkthoba\tNovemba\tDisemba", // months
                "Jan\tFeb\tMas\tEph\tMey\tJun\tJul\tAga\tSep\tOkt\tNov\tDis", // shortMonths
                "Son\tMso\tBil\tTha\tSin\tHla\tMgq", // shortWeekdays
                "ISonto\tUMsombuluko\tULwesibili\tULwesithathu\tULwesine\tULwesihlanu\tUMgqibelo" // weekdays
        );

    }
}
