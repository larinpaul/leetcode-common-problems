//// 2023/06/16 // 12:52 //

//// 659. Encode and Decode Strings // Medium //

// Design an algorithm to encode a list of strings to a string.
// The encoded string is then sent over the network and is decoded back to the original list of strings.

// Please implement encode an decode

// Example1
// Input: ["list","code","love","you"]
// Output: ["lint","code","love","you"]
// Explanation:
// One possible encode method is: "lint:;code:;love:;you"

// Example2
// Input: ["we", "say", ":", "yes"]
// Output: ["we", "say", ":", "yes"]
// Explanation:
// One possible encode method is : "we:;say:;:::;yes"

import java.util.ArrayList;
import java.util.List;

class EncodeAndDecodeString {

    // Here is one possible way to approach the problem:
    // * To encode a list of string to a single string, we can use a delimiter character that does
    // not appear in any of the strings, such as ;, and append it to the end of each string.
    // We also need to escape the delimited character if it appears in the original strings, such as
    // by using : as an escape character. For example, if the list is ["we","say",":","yes"],
    // we can encode it as "we:;say:;:::;yes:;".
    // * To decode a single string to a list of strings, we can use a StringBuilder to store the
    // current string, and iterate over the encoded string character by character. If we
    // encounter a :, we check the next character. If it is also a :, we append a : to the StringBuilder.
    // If it is a ;, we append a ; to the String Builder. Otherwise, we ignore it.
    // If we encounter a ;, we add the current string to the list and reset the StringBuilder.
    // For example, if the encoded string is "we:;say:;:::;yes:;",
    // we can decode it as ["we","say",":","yes"].
    // * The code for Java shown below:

    /**
     * @param strs: a list of strings
     * @return: encodes a list of strings to a single string.
     */
    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for (String s : strs) {
            for (char c : s.toCharArray()) {
                if (c == ':') {
                    sb.append("::");
                } else if (c == ';') {
                    sb.append(":;");
                } else {
                    sb.append(c);
                }
            }
            sb.append(";");
        }
        return sb.toString();
    }

    /**
     * @param str: A string
     * @return: decodes a single string to a list of strings
     */
    public List<String> decode(String str) {
        List<String> result = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (i < str.length()) {
            char c = str.charAt(i);
            if (c == ':') {
                i++;
                char next = str.charAt(i);
                if (next == ':') {
                    sb.append(':');
                } else if (next == ';') {
                    sb.append(';');
                }
            } else if (c == ';') {
                result.add(sb.toString());
                sb.setLength(0);
            } else {
                sb.append(c);
            }
            i++;
        }
        return result;
    }

    // The time complexity of both encode and decode is O(n),
    // where n is the total number of characters in the input list or string.
    // The space complexity of both encode and decode is also O(n),
    // as we need to store the encoded or decoded string in memory.




}



