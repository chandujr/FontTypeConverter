/*
    FontTypeConverter - A simple tool to convert text in Unicode Malayalam font to Karthika font.
    Copyright (C) 2016  BlackDrongo

    This program is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    This program is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package com.blackdrongo.fonttypeconverter;

import java.util.LinkedHashMap;

/**
 * created by WeirdElfB0y of BlackDrongo on 22-Aug-2016.
 * last updated on 22-Jan-2017
 */
class CharacterReplacer {

    String replaceAll(String inputText) {
        String[] inputTextArray = new String[]{
                "അ", "ആ", "ഇ", "ഈ", "ഉ", "ഊ", "ഋ", "എ", "ഏ", "ഐ", "ഒ", "ഓ", "ഔ",
                "ക", "ഖ", "ഗ", "ഘ", "ങ", "ച", "ഛ", "ജ", "ഝ", "ഞ", "ട", "ഠ", "ഡ", "ഢ", "ണ", "ത", "ഥ", "ദ", "ധ", "ന", "പ", "ഫ", "ബ", "ഭ", "മ", "യ", "ര", "റ", "ല", "ള", "ഴ", "വ", "ശ", "ഷ", "സ", "ഹ",
                "ൺ", "ൻ", "ർ", "ൽ", "ൾ",
                "ാ", "ി", "ീ", "ു", "ൂ", "ൃ", "ൗ", "ം", "ഃ",
                "്",
                "–", "‘", "’"
        };
        String[] outputTextArray = new String[]{
                "A", "B", "C", "Cu", "D", "Du", "E", "F", "G", "ssF", "H", "Hm", "Hu",
                "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "[", "\\", "]", "^", "_", "`", "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l",
                "¬", "³", "À", "Â", "Ä",
                "m", "n", "o", "p", "q", "r", "u", "w", "x",
                "v",
                "þ", "\"", "'"
        };

        for (int i = 0; i < inputTextArray.length || i < outputTextArray.length; i++) {
            inputText = inputText.replace(inputTextArray[i], outputTextArray[i]);
        }

        // By now, every single letter is converted to Karthika Font. Now to convert conjunct consonants and chillus to their own symbols.

        LinkedHashMap<String, String> kaDoubles = new LinkedHashMap<>();
        kaDoubles.put("I", "¡");
        kaDoubles.put("e", "¢");
        kaDoubles.put("j", "£");
        kaDoubles.put("S", "Î");
        kaDoubles.put("X", "à");
        LinkedHashMap<String, String> gaDoubles = new LinkedHashMap<>();
        gaDoubles.put("K","¤");
        gaDoubles.put("e","¥");
        gaDoubles.put("a","Ü");
        gaDoubles.put("\\","á");
        LinkedHashMap<String, String> ngaDoubles = new LinkedHashMap<>();
        ngaDoubles.put("I", "¦");
        ngaDoubles.put("M", "§");
        LinkedHashMap<String, String> chaDoubles = new LinkedHashMap<>();
        chaDoubles.put("N", "¨");
        chaDoubles.put("O", "Ñ");
        LinkedHashMap<String, String> jaDoubles = new LinkedHashMap<>();
        jaDoubles.put("P", "Ö");
        jaDoubles.put("R", "Ú");
        LinkedHashMap<String, String> njaDoubles = new LinkedHashMap<>();
        njaDoubles.put("N","©");
        njaDoubles.put("R","ª");
        LinkedHashMap<String, String> taDoubles = new LinkedHashMap<>();
        taDoubles.put("S", "«");
        LinkedHashMap<String, String> daDoubles = new LinkedHashMap<>();
        daDoubles.put("U", "Í");
        LinkedHashMap<String, String> nnaDoubles = new LinkedHashMap<>();
        nnaDoubles.put("S","­");
        nnaDoubles.put("U","Þ");
        nnaDoubles.put("W","®");
        nnaDoubles.put("a","×");
        LinkedHashMap<String, String> thaDoubles = new LinkedHashMap<>();
        thaDoubles.put("X","¯");
        thaDoubles.put("Y","°");
        thaDoubles.put("k","Õ");
        thaDoubles.put("`","Û");
        thaDoubles.put("a","ß");
        LinkedHashMap<String, String> dhaDoubles = new LinkedHashMap<>();
        dhaDoubles.put("Z","±");
        dhaDoubles.put("[","²");
        LinkedHashMap<String, String> naDoubles = new LinkedHashMap<>();
        naDoubles.put("X","´");
        naDoubles.put("Y","Ù");
        naDoubles.put("Z","µ");
        naDoubles.put("[","Ô");
        naDoubles.put("\\","¶");
        naDoubles.put("a","∙");
        naDoubles.put("d","â");
        LinkedHashMap<String, String> paDoubles = new LinkedHashMap<>();
        paDoubles.put("]","¸");
        paDoubles.put("e","¹");
        LinkedHashMap<String, String> baDoubles = new LinkedHashMap<>();
        baDoubles.put("Z","Ð");
        baDoubles.put("[","Ï");
        baDoubles.put("_","º");
        baDoubles.put("e","»");
        LinkedHashMap<String, String> maDoubles = new LinkedHashMap<>();
        maDoubles.put("]","¼");
        maDoubles.put("a","½");
        maDoubles.put("e","¾");
        LinkedHashMap<String, String> yaDoubles = new LinkedHashMap<>();
        yaDoubles.put("b", "¿");
        LinkedHashMap<String, String> raDoubles = new LinkedHashMap<>();
        raDoubles.put("d", "ä");
        LinkedHashMap<String, String> laDoubles = new LinkedHashMap<>();
        laDoubles.put("e", "Ã");
        LinkedHashMap<String, String> llaDoubles = new LinkedHashMap<>();
        llaDoubles.put("f", "Å");
        LinkedHashMap<String, String> vaDoubles = new LinkedHashMap<>();
        vaDoubles.put("h", "Æ");
        LinkedHashMap<String, String> shaDoubles = new LinkedHashMap<>();
        shaDoubles.put("N", "Ý");
        shaDoubles.put("i", "È");
        shaDoubles.put("e", "Ç");
        LinkedHashMap<String, String> sshhaDoubles = new LinkedHashMap<>();
        sshhaDoubles.put("S", "ã");
        LinkedHashMap<String, String> saDoubles = new LinkedHashMap<>();
        saDoubles.put("e", "É");
        saDoubles.put("k", "Ê");
        saDoubles.put("Y", "Ø");
        LinkedHashMap<String, String> haDoubles = new LinkedHashMap<>();
        haDoubles.put("\\", "Ó");
        haDoubles.put("a", "Ò");
        haDoubles.put("k", "Ê");

        String yaChar = "y";
        String raChar = "{";
        String vaChar = "z";
//        String innChar = "¬";
        String inChar = "³";
//        String irChar = "À";
        String ilChar = "Â";
        String illChar = "Ä";
        String kalaChar = "v";
        int fromIndex = 0;

        while(true) {
//            System.out.println("Input text: " + inputText);
            int index = inputText.indexOf(kalaChar, fromIndex);
            if (index < 1 || index + 1 >= inputText.length()) break;

            if (inputText.charAt(index + 1) == 'b' && inputText.charAt(index - 1) != 'b') {
                inputText = inputText.substring(0, index) + yaChar + inputText.substring(index + 2);
            } else if (inputText.charAt(index + 1) == 'c') {
                inputText = inputText.substring(0, index - 1) + raChar + String.valueOf(inputText.charAt(index - 1)) + inputText.substring(index + 2);
            } else if (inputText.charAt(index + 1) == 'h' && inputText.charAt(index - 1) != 'h') {
                inputText = inputText.substring(0, index) + vaChar + inputText.substring(index + 2);
            } else if (inputText.charAt(index - 1) == 'I') {
                if (kaDoubles.get(String.valueOf(inputText.charAt(index + 1))) != null) {
                    inputText = inputText.substring(0, index - 1) + kaDoubles.get(String.valueOf(inputText.charAt(index + 1))) + inputText.substring(index + 2);
                } else {
                    fromIndex = index + 1;
                }
            } else if (inputText.charAt(index - 1) == 'K') {
                if (gaDoubles.get(String.valueOf(inputText.charAt(index + 1))) != null) {
                    inputText = inputText.substring(0, index - 1) + gaDoubles.get(String.valueOf(inputText.charAt(index + 1))) + inputText.substring(index + 2);
                } else {
                    fromIndex = index + 1;
                }
            } else if (inputText.charAt(index - 1) == 'M') {
                if (ngaDoubles.get(String.valueOf(inputText.charAt(index + 1))) != null) {
                    inputText = inputText.substring(0, index - 1) + ngaDoubles.get(String.valueOf(inputText.charAt(index + 1))) + inputText.substring(index + 2);
                } else {
                    fromIndex = index + 1;
                }
            } else if (inputText.charAt(index - 1) == 'N') {
                if (chaDoubles.get(String.valueOf(inputText.charAt(index + 1))) != null) {
                    inputText = inputText.substring(0, index - 1) + chaDoubles.get(String.valueOf(inputText.charAt(index + 1))) + inputText.substring(index + 2);
                } else {
                    fromIndex = index + 1;
                }
            } else if (inputText.charAt(index - 1) == 'P') {
                if (jaDoubles.get(String.valueOf(inputText.charAt(index + 1))) != null) {
                    inputText = inputText.substring(0, index - 1) + jaDoubles.get(String.valueOf(inputText.charAt(index + 1))) + inputText.substring(index + 2);
                } else {
                    fromIndex = index + 1;
                }
            } else if (inputText.charAt(index - 1) == 'R') {
                if (njaDoubles.get(String.valueOf(inputText.charAt(index + 1))) != null) {
                    inputText = inputText.substring(0, index - 1) + njaDoubles.get(String.valueOf(inputText.charAt(index + 1))) + inputText.substring(index + 2);
                } else {
                    fromIndex = index + 1;
                }
            } else if (inputText.charAt(index - 1) == 'S') {
                if (taDoubles.get(String.valueOf(inputText.charAt(index + 1))) != null) {
                    inputText = inputText.substring(0, index - 1) + taDoubles.get(String.valueOf(inputText.charAt(index + 1))) + inputText.substring(index + 2);
                } else {
                    fromIndex = index + 1;
                }
            } else if (inputText.charAt(index - 1) == 'U') {
                if (daDoubles.get(String.valueOf(inputText.charAt(index + 1))) != null) {
                    inputText = inputText.substring(0, index - 1) + daDoubles.get(String.valueOf(inputText.charAt(index + 1))) + inputText.substring(index + 2);
                } else {
                    fromIndex = index + 1;
                }
            } else if (inputText.charAt(index - 1) == 'W') {
                if (nnaDoubles.get(String.valueOf(inputText.charAt(index + 1))) != null) {
                    inputText = inputText.substring(0, index - 1) + nnaDoubles.get(String.valueOf(inputText.charAt(index + 1))) + inputText.substring(index + 2);
                } else {
                    fromIndex = index + 1;
//                    inputText = inputText.substring(0, index - 1) + innChar + inputText.substring(index + 1);
                }
            } else if (inputText.charAt(index - 1) == 'X') {
                if (thaDoubles.get(String.valueOf(inputText.charAt(index + 1))) != null) {
                    inputText = inputText.substring(0, index - 1) + thaDoubles.get(String.valueOf(inputText.charAt(index + 1))) + inputText.substring(index + 2);
                } else {
                    fromIndex = index + 1;
                }
            } else if (inputText.charAt(index - 1) == 'Z') {
                if (dhaDoubles.get(String.valueOf(inputText.charAt(index + 1))) != null) {
                    inputText = inputText.substring(0, index - 1) + dhaDoubles.get(String.valueOf(inputText.charAt(index + 1))) + inputText.substring(index + 2);
                } else {
                    fromIndex = index + 1;
                }
            } else if (inputText.charAt(index - 1) == '\\') {
                if (naDoubles.get(String.valueOf(inputText.charAt(index + 1))) != null) {
                    inputText = inputText.substring(0, index - 1) + naDoubles.get(String.valueOf(inputText.charAt(index + 1))) + inputText.substring(index + 2);
                } else {
                    fromIndex = index + 1;
//                    inputText = inputText.substring(0, index - 1) + inChar + inputText.substring(index + 1);
                }
            } else if (inputText.charAt(index - 1) == ']') {
                if (paDoubles.get(String.valueOf(inputText.charAt(index + 1))) != null) {
                    inputText = inputText.substring(0, index - 1) + paDoubles.get(String.valueOf(inputText.charAt(index + 1))) + inputText.substring(index + 2);
                } else {
                    fromIndex = index + 1;
                }
            } else if (inputText.charAt(index - 1) == '_') {
                if (baDoubles.get(String.valueOf(inputText.charAt(index + 1))) != null) {
                    inputText = inputText.substring(0, index - 1) + baDoubles.get(String.valueOf(inputText.charAt(index + 1))) + inputText.substring(index + 2);
                } else {
                    fromIndex = index + 1;
                }
            } else if (inputText.charAt(index - 1) == 'a') {
                if (maDoubles.get(String.valueOf(inputText.charAt(index + 1))) != null) {
                    inputText = inputText.substring(0, index - 1) + maDoubles.get(String.valueOf(inputText.charAt(index + 1))) + inputText.substring(index + 2);
                } else {
                    fromIndex = index + 1;
                }
            } else if (inputText.charAt(index - 1) == 'b') {
                if (yaDoubles.get(String.valueOf(inputText.charAt(index + 1))) != null) {
                    inputText = inputText.substring(0, index - 1) + yaDoubles.get(String.valueOf(inputText.charAt(index + 1))) + inputText.substring(index + 2);
                } else {
                    fromIndex = index + 1;
                }
            } else if (inputText.charAt(index - 1) == 'd') {
                if (raDoubles.get(String.valueOf(inputText.charAt(index + 1))) != null) {
                    inputText = inputText.substring(0, index - 1) + raDoubles.get(String.valueOf(inputText.charAt(index + 1))) + inputText.substring(index + 2);
                } else {
                    fromIndex = index + 1;
                }
            } else if (inputText.charAt(index - 1) == 'e') {
                if (laDoubles.get(String.valueOf(inputText.charAt(index + 1))) != null) {
                    inputText = inputText.substring(0, index - 1) + laDoubles.get(String.valueOf(inputText.charAt(index + 1))) + inputText.substring(index + 2);
                } else {
                    inputText = inputText.substring(0, index - 1) + ilChar + inputText.substring(index + 1);
                }
            } else if (inputText.charAt(index - 1) == 'f') {
                if (llaDoubles.get(String.valueOf(inputText.charAt(index + 1))) != null) {
                    inputText = inputText.substring(0, index - 1) + llaDoubles.get(String.valueOf(inputText.charAt(index + 1))) + inputText.substring(index + 2);
                } else {
                    inputText = inputText.substring(0, index - 1) + illChar + inputText.substring(index + 1);
                }
            } else if (inputText.charAt(index - 1) == 'h') {
                if (vaDoubles.get(String.valueOf(inputText.charAt(index + 1))) != null) {
                    inputText = inputText.substring(0, index - 1) + vaDoubles.get(String.valueOf(inputText.charAt(index + 1))) + inputText.substring(index + 2);
                } else {
                    fromIndex = index + 1;
                }
            } else if (inputText.charAt(index - 1) == 'i') {
                if (shaDoubles.get(String.valueOf(inputText.charAt(index + 1))) != null) {
                    inputText = inputText.substring(0, index - 1) + shaDoubles.get(String.valueOf(inputText.charAt(index + 1))) + inputText.substring(index + 2);
                } else {
                    fromIndex = index + 1;
                }
            } else if (inputText.charAt(index - 1) == 'j') {
                if (sshhaDoubles.get(String.valueOf(inputText.charAt(index + 1))) != null) {
                    inputText = inputText.substring(0, index - 1) + sshhaDoubles.get(String.valueOf(inputText.charAt(index + 1))) + inputText.substring(index + 2);
                } else {
                    fromIndex = index + 1;
                }
            } else if (inputText.charAt(index - 1) == 'k') {
                if (saDoubles.get(String.valueOf(inputText.charAt(index + 1))) != null) {
                    inputText = inputText.substring(0, index - 1) + saDoubles.get(String.valueOf(inputText.charAt(index + 1))) + inputText.substring(index + 2);
                } else {
                    fromIndex = index + 1;
                }
            } else if (inputText.charAt(index - 1) == 'l') {
                if (haDoubles.get(String.valueOf(inputText.charAt(index + 1))) != null) {
                    inputText = inputText.substring(0, index - 1) + haDoubles.get(String.valueOf(inputText.charAt(index + 1))) + inputText.substring(index + 2);
                } else {
                    fromIndex = index + 1;
                }
            } else {
                fromIndex = index + 1;
            }
        }

        String[] precedingLetterInputChars = new String[]{"െ", "േ", "ൈ"};
        String[] precedingLetterOutputChars = new String[]{"s", "t", "ss"};

        for (int i = 0; i < precedingLetterInputChars.length && i < precedingLetterOutputChars.length; i++) {
            while (true) {
                int index = inputText.indexOf(precedingLetterInputChars[i]);
                if (index == -1) break;
                inputText = inputText.substring(0, index) + String.format("%s%c", precedingLetterOutputChars[i], inputText.charAt(index - 1)) + inputText.substring(index + 1);
                inputText = inputText.substring(0, index - 1) + inputText.substring(index);
            }
        }

        String[] midLetterInputChars = new String[]{"ൊ", "ോ", "ൌ"};
        String[] midLetterOutputChars = new String[]{"sm", "tm", "su"};
        for (int i = 0; i < midLetterInputChars.length && i < midLetterOutputChars.length; i++) {
            while (true) {
                int index = inputText.indexOf(midLetterInputChars[i]);
                if (index == -1) break;
                inputText = inputText.substring(0, index) + String.format("%s%c%s", midLetterOutputChars[i].substring(0, 1), inputText.charAt(index - 1), midLetterOutputChars[i].substring(1)) + inputText.substring(index + 1);
                inputText = inputText.substring(0, index - 1) + inputText.substring(index);
            }
        }

        return inputText;
    }
}
